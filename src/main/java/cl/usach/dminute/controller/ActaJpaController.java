package cl.usach.dminute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.repository.ActaJpa;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/actaDb")
public class ActaJpaController {

	@Autowired
	@Qualifier("actaJpa")
	private ActaJpa actaJpa;
	
	@GetMapping(value = "/findByActaId/{actaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByActaId(@PathVariable(value = "actaid") Long actaId) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaJpaController.findByActaId.INIT");
			log.info("ActaJpaController.findByActaId.acta:" + actaId.toString());
		}
		
		Acta retorno =  actaJpa.findByActaId(actaId);
		
		if(log.isInfoEnabled()) {
			log.info("ActaJpaController.findByActaId.retorno: " + retorno.toString());
			log.info("ActaJpaController.findByActaId.FIN");
		}		
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody Acta guardarActa) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaJpaController.guardar.INIT");
			log.info("ActaJpaController.guardar.acta:" + guardarActa.toString());
		}
		
		Acta retorno = actaJpa.save(guardarActa);
		
		if(log.isInfoEnabled()) {
			log.info("ActaJpaController.guardar.retorno: " + retorno.toString());
			log.info("ActaJpaController.guardar.FIN");
		}		
		return ResponseEntity.ok(retorno);
	}
}
