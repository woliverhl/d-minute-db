package cl.usach.dminute.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {
	
	@NotNull
	@NotEmpty
	private String codigo;
	@NotNull
	@NotEmpty
	private String mensaje;
	private StringBuilder info;
	private String debug;	
	
	
	private ErrorDto(ErrorDtoBuilder builder) {
		this.codigo = builder.getCodigo();
		this.mensaje = builder.getMensaje();
		this.info = builder.getInfo();
		this.debug = builder.getDebug();
	}
	
	public static ErrorDtoBuilder builder() {
		return new ErrorDtoBuilder(); 
	}
	
	public static class ErrorDtoBuilder {
		public String codigo;
		public String mensaje;
		public StringBuilder info;
		public String debug;	
			
		public ErrorDtoBuilder() { }
		
		public ErrorDto build() {
            return new ErrorDto(this);
        }
		
		public ErrorDtoBuilder codigo(String codigo) {
			this.codigo = codigo;
			return this;
	    }
		
		public ErrorDtoBuilder mensaje(String mensaje) {
			this.mensaje = mensaje;
			return this;
	    }
		
		public ErrorDtoBuilder info(StringBuilder info) {
			this.info = info;
			return this;
	    }
		
		public ErrorDtoBuilder debug(String debug) {
			this.debug = debug;
			return this;
	    }

		public String getCodigo() {
			return codigo;
		}
		
		public String getMensaje() {
			return mensaje;
		}
		
		public StringBuilder getInfo() {
			return info;
		}
		
		public String getDebug() {
			return debug;
		}		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public StringBuilder getInfo() {
		return info;
	}
	
	public String getDebug() {
		return debug;
	}
	
}
