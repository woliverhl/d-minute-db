package cl.usach.dminute.dto;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class ErrorValidacion implements Serializable {

	private static final long serialVersionUID = 1L;
	private String atributo;
	private String mensaje;
	
	private ErrorValidacion(ErrorValidacionBuilder builder) {
		this.atributo = builder.getAtributo();
		this.mensaje = builder.getMensaje();
	}
	
	public static ErrorValidacionBuilder builder() {
		return new ErrorValidacionBuilder(); 
	}
	
	
	public static class ErrorValidacionBuilder {
		public String atributo;
		public String mensaje;	
			
		public ErrorValidacionBuilder() { }
		
		public ErrorValidacion build() {
            return new ErrorValidacion(this);
        }
		
		public ErrorValidacionBuilder atributo(String atributo) {
			this.atributo = atributo;
			return this;
	    }
		
		public ErrorValidacionBuilder mensaje(String mensaje) {
			this.mensaje = mensaje;
			return this;
	    }

		public String getAtributo() {
			return atributo;
		}

		public String getMensaje() {
			return mensaje;
		}		
	}

	public String getAtributo() {
		return atributo;
	}

	public String getMensaje() {
		return mensaje;
	}	
	
}
