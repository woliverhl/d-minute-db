package cl.usach.dminute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.ProyectoUsuariosDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.entity.UsuarioProyecto;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/consultasDminute")
public class MiscelaneoStoreProcedureController {

	@Autowired
	@Qualifier("callStoreProcedureImpl")
	private CallStoreProcedureImpl callStoreProcedure;
	
	@GetMapping(value = "/buscarProyectoPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarProyectoPorUsuario(@PathVariable(value = "usuario") String usuario) {
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuario.INIT");
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuario.user:" + usuario.toString());
		}
		
		List<UsuarioProyecto> retorno =  callStoreProcedure.buscarProyectoPorUsuario(usuario);
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuario.retorno: " + retorno.toString());
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuario.FIN");
		}		
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping(value = "/eliminarUsuariosProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarUsuariosProyecto(@PathVariable(value = "proyectoId") Long proyectoId) {
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.eliminarUsuariosProyecto.INIT");
			log.info("MiscelaneoStoreProcedureController.eliminarUsuariosProyecto.proyectoId:" + proyectoId.toString());
		}
		
		callStoreProcedure.eliminarUsuariosProyecto(proyectoId);
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.eliminarUsuariosProyecto.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/buscarProyectoPorUsuarioAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarProyectoPorUsuarioAll(@PathVariable(value = "usuario") String usuario) {
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuarioAll.INIT");
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuarioAll.user:" + usuario.toString());
		}
		
		List<ProyectoUsuariosDto> retorno =  callStoreProcedure.buscarProyectoPorUsuarioAll(usuario);
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuarioAll.retorno: " + retorno.toString());
			log.info("MiscelaneoStoreProcedureController.buscarProyectoPorUsuarioAll.FIN");
		}		
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping(value = "/buscarActasProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarActasProyecto(@PathVariable(value = "proyectoId") Long proyectoId) {
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarActasProyecto.INIT");
			log.info("MiscelaneoStoreProcedureController.buscarActasProyecto.proyectoId:" + proyectoId.toString());
		}
		
		List<ActaDto> retorno =  callStoreProcedure.buscarActasProyecto(proyectoId);
		
		if(log.isInfoEnabled()) {
			log.info("MiscelaneoStoreProcedureController.buscarActasProyecto.retorno: " + retorno.toString());
			log.info("MiscelaneoStoreProcedureController.buscarActasProyecto.FIN");
		}		
		return ResponseEntity.ok(retorno);
	}
	
}
