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
public class TemaDto {
	
	private long id;
	private String nombre;
	private String discusion;
	private long actaId;	
	private List<ElementoDialogoDto> elementoDialogoDto;

}
