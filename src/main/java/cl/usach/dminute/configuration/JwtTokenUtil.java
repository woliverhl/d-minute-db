package cl.usach.dminute.configuration;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.exception.ErrorTecnicoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import static cl.usach.dminute.dto.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static cl.usach.dminute.dto.Constants.HEADER_STRING;
import static cl.usach.dminute.dto.Constants.SIGNING_KEY;
import static cl.usach.dminute.dto.Constants.TOKEN_PREFIX;

@Slf4j
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Clock clock = DefaultClock.INSTANCE;

	public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Usuario user) {
        return doGenerateToken(user.getUsername());
    }

    private String doGenerateToken(String subject) {

        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://devglan.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
              username.equals(userDetails.getUsername())
                    && !isTokenExpired(token));
    }
    
    public Boolean isTokenActivo(HttpServletRequest req)
    {
    	String header = req.getHeader(HEADER_STRING);
    	String username = null;
        String authToken = null;
    	if (header != null && header.startsWith(TOKEN_PREFIX)) {
    		 authToken = header.replace(TOKEN_PREFIX,"");
    		 username = this.getUsernameFromToken(authToken);
    		 return (
    	              username.equals(username)
    	                    && !isTokenExpired(authToken));
    	}
    	return true;
    }
    
    public String getUserToken(HttpServletRequest req)
    {
    	if(log.isInfoEnabled()) {
			log.info("JwtTokenUtil.getUserToken.INIT");
		}
    	String header = req.getHeader(HEADER_STRING);
    	String username = null;
        String authToken = null;
    	if (header != null && header.startsWith(TOKEN_PREFIX)) {
    		 authToken = header.replace(TOKEN_PREFIX,"");
    		 username = this.getUsernameFromToken(authToken);
    		 if(log.isInfoEnabled()) {
    				log.info("JwtTokenUtil.getUserToken.username: " + username);
    			}
    		 return username;
    	}
    	if(log.isInfoEnabled()) {
			log.info("JwtTokenUtil.getUserToken.FIN");
		}
    	throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_USUARIO_INVALIDO);
    }
    
    public String getTokenActivo(HttpServletRequest req)
    {
    	String header = req.getHeader(HEADER_STRING);
    	String authToken = null;
    	if (header != null && header.startsWith(TOKEN_PREFIX)) {
    		 authToken = header.replace(TOKEN_PREFIX,"");
    		 return authToken;
    	}
    	return "";
    }
    
    public String refrescarToken(String token) {
        final Date createdDate = clock.now();
        final Date expirationDate = getExpirationDateFromToken(token);

        final Claims claims = getAllClaimsFromToken(token);
        
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://devglan.com")
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }
}
