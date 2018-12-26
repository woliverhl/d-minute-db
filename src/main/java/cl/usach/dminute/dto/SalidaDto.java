package cl.usach.dminute.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalidaDto {

	private String retorno;
	private static final String codigo = "OK";
	
	public SalidaDto() {
		super();
		this.retorno = codigo;
	}
	
}
