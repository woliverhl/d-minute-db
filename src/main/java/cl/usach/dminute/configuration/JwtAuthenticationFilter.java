package cl.usach.dminute.configuration;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static cl.usach.dminute.dto.Constants.HEADER_STRING;
import static cl.usach.dminute.dto.Constants.HEADER_ORIGEN;
import static cl.usach.dminute.dto.Constants.TOKEN_PREFIX;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    	if(log.isInfoEnabled()) {
			log.info("JwtAuthenticationFilter.doFilterInternal.INIT");
		}
    	String header = req.getHeader(HEADER_STRING);
    	String origen = req.getHeader(HEADER_ORIGEN);
    	
    	String username = null;
        String authToken = null;
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX,"");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("the token is expired and not valid anymore", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
        } 
        
        if(log.isInfoEnabled()) {
			log.info("JwtAuthenticationFilter.doFilterInternal.AntesDeValidar: " + username);
			log.info("JwtAuthenticationFilter.doFilterInternal.origen: " + origen);
		}
        

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	
        	if(log.isInfoEnabled()) {
    			log.info("JwtAuthenticationFilter.doFilterInternal.Validado:" +username );
    		}

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
            	if(log.isInfoEnabled()) {
        			log.info("JwtAuthenticationFilter.doFilterInternal.validateToken.OK");
        		}
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }	

        chain.doFilter(req, res);
        
        if(log.isInfoEnabled()) {
			log.info("JwtAuthenticationFilter.doFilterInternal.FIN:" +username );
		}
    }
}