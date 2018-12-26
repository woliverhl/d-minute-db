package cl.usach.dminute.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProyectoDto {
	
	private long proyectoId;
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;	
	private List<ProyectoUsuariosDto> usuariosNuevoProyecto;
	private String username;

}
