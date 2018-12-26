package cl.usach.dminute.service;

import cl.usach.dminute.dto.LoginUserDto;
import cl.usach.dminute.entity.Usuario;

import java.util.List;

public interface UsuarioService {

	public abstract Usuario save(Usuario user);
    
	public abstract List<Usuario> findAll();
    
	public abstract void delete(long id);
   
	public abstract Usuario findOne(String username);
	
	public abstract Usuario userOauth(LoginUserDto user);
	
}
