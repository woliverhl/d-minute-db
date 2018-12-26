package cl.usach.dminute.dto;

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
public class UsuarioActaDto {
	
	private String asiste;
	private String secretario;
	private String username;
	private String nombre;
	private long actaId;
	

}
