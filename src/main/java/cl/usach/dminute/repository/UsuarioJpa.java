package cl.usach.dminute.repository;

import cl.usach.dminute.entity.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("usuarioJpa")
public interface UsuarioJpa extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
