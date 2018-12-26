package cl.usach.dminute.exception;

public class ErrorTecnicoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String codigo;
	private final String mensaje;
	
	public String getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public ErrorTecnicoException(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	
}
