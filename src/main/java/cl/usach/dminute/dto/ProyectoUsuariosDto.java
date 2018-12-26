package cl.usach.dminute.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ProyectoUsuariosDto {
	
	@JsonIgnore
	private long proyectoId;
	private String username;
	private String nombre;
	private String fullName;

}
