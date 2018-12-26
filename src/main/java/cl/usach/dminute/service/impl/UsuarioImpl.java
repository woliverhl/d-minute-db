package cl.usach.dminute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.LoginUserDto;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.exception.UsPersonException;
import cl.usach.dminute.repository.UsuarioJpa;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service(value = "usuarioService")
public class UsuarioImpl implements UserDetailsService, UsuarioService {
	
	@Autowired
	@Qualifier("usuarioJpa")
	private UsuarioJpa usuarioJpa;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDetails loadUserByUsername(String userId) throws UsPersonException {
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.loadUserByUsername.INIT");
			log.info("UsuarioImpl.loadUserByUsername.userId:" + userId.toString());
		}
		Usuario user = usuarioJpa.findByUsername(userId);
		if(user == null){
			throw new UsPersonException(Constants.ERROR_USUARIO_EXISTE_COD,"Usuario o Password invalido.");
		}
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.loadUserByUsername.user: " + user);
			log.info("UsuarioImpl.loadUserByUsername.FIN");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Usuario> findAll() {
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.findAll.INIT");
		}
		List<Usuario> list = new ArrayList<>();
		usuarioJpa.findAll().iterator().forEachRemaining(list::add);
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.findAll.lista:" + list.toString());
			log.info("UsuarioImpl.findAll.FIN");
		}
		return list;
	}

	@Override
	public void delete(long id) {
		usuarioJpa.delete(id);
	}

	@Override
	public Usuario findOne(String username) {
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.findOne.INIT");
			log.info("UsuarioImpl.findOne.user: " + username);
		}
		Usuario retorno = usuarioJpa.findByUsername(username);
		if(retorno == null){
			log.info("UsuarioImpl.findOne.ERROR: " + Constants.ERROR_USUARIO_EXISTE_COD + "Usuario invalido.");	
			throw new UsPersonException(Constants.ERROR_USUARIO_EXISTE_COD, Constants.ERROR_USUARIO_NR);
		}
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.findOne.FIN: " + retorno.toString());
		}
		return retorno;
	}

	@Override
    public Usuario save(Usuario user) {
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.save.INIT");
			log.info("UsuarioImpl.save.user: " + user.toString());
		}
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setNombre(user.getNombre().toUpperCase());
			user.setApellido(user.getApellido().toUpperCase());
			Usuario validacion = findOne(user.getUsername()); 
			if (validacion == null)
				return usuarioJpa.save(user);
			else
				throw new UsPersonException(Constants.ERROR_USUARIO_EXISTE_COD, Constants.ERROR_USUARIO_EXISTE);
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.error("UsuarioImpl.save.ERROR - " + ex.getMessage());			
			}	
			throw ex;
		}	
    }
	
	@Override
    public Usuario userOauth(LoginUserDto user) {
		if(log.isInfoEnabled()) {
			log.info("UsuarioImpl.userOauth.INIT");
			log.info("UsuarioImpl.userOauth.user: " + user.toString());
		}
		try {
			
			Usuario validacion = usuarioJpa.findByUsername(user.getUsername()); 
			if (validacion != null) {
				if(log.isInfoEnabled()) {
					log.info("UsuarioImpl.userOauth.usuarioExiste");
				}
				if ((validacion.getOrigen() == null) || (!validacion.getOrigen().toString().equals(Constants.ORIGEN_GOOGLE))) {
					if(log.isInfoEnabled()) {
						log.info("UsuarioImpl.userOauth.usuario.existente");
					}
					throw new UsPersonException(Constants.ERROR_USUARIO_EXISTE_COD, Constants.ERROR_USUARIO_EXISTE_GOOGLE);
				}
				else {
					if(log.isInfoEnabled()) {
						log.info("UsuarioImpl.userOauth.usuario.Oauth");
					}
					return validacion;
				}
			}
			if(log.isInfoEnabled()) {
				log.info("UsuarioImpl.userOauth.guardar");
			}
			Usuario usuario = new Usuario();
			usuario.setUsername(user.getUsername());
			usuario.setPassword(passwordEncoder.encode(user.getPassword()));
			usuario.setNombre(user.getName().toUpperCase());
			usuario.setApellido("");
			usuario.setOrigen(Constants.ORIGEN_GOOGLE);
			return usuarioJpa.save(usuario);
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.error("UsuarioImpl.userOauth.ERROR - " + ex.getMessage());			
			}	
			throw ex;
		}	
    }
}
