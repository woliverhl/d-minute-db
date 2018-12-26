package cl.usach.dminute.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.Acta;

@Repository("actaJpa")
public interface ActaJpa extends JpaRepository<Acta, Serializable> {
	
	public abstract Acta findByActaId(long actaId);
	

}
