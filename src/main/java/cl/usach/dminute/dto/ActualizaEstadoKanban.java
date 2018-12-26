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
public class ActualizaEstadoKanban {

	private long idElemento;
	private String estado; //TODO-DOING-DONE-DEL
	private long proyectoId;
	
}
