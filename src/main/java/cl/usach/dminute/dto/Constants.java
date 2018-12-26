package cl.usach.dminute.dto;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*6;
    public static final String SIGNING_KEY = "devglan123r";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String HEADER_ORIGEN = "Origen";
    public static final String ORIGEN_DMINUTE = "DMINUTE";
    public static final String ORIGEN_GOOGLE = "GOOGLE";
    public static final String OK = "OK";
    public static final String ACT = "ACT";
	public static final String ERROR_TECNICO_MENSAJE = "Ha ocurrido un error en el sistema";
	public static final String ERROR_USUARIO_EXISTE = "El usuario que se intenta guardar ya esta registrado";
	public static final String ERROR_USUARIO_EXISTE_GOOGLE = "El usuario no puede acceder de esta forma, utilice inicio de sesion normal";
	public static final String ERROR_USUARIO_INVALIDO = "El usuario no existe o su sesion a cadicado";
	public static final String ERROR_USUARIO_NR = "El usuario no esta registrado en D-Minute, registre su información";
	public static final String ERROR_USUARIO_NOK = "Usuario o contraseña invalido, verifique su información";
	public static final String ERROR_PROYECTO_ERROR = "No ha sido posible guardar el proyecto, intenta mas tarde";
	public static final String ERROR_ACTA_ERROR = "No ha sido posible guardar el acta asociada al proyecto, intenta mas tarde";
	public static final String ERROR_ELEMENTO_ERROR = "No ha sido posible guardar el elemento asociado  al acta del proyecto, intenta mas tarde";
	public static final String ERROR_ACTA_NOEXISTE = "El acta asociada al proyecto no existe, verifique informacións";
	public static final String ERROR_TEMA_DEL_ERROR = "No ha sido posible eliminar el tema asociada al acta, intenta mas tarde";
	public static final String ERROR_TEMA_ERROR = "No ha sido posible guardar el tema asociada al acta, intenta mas tarde";
	public static final String ERROR_PROYECTO_NOEXISTE = "El proyecto no existe, verifique";
	public static final String ERROR_ELEMENTO_NOEXISTE = "El elemento de dialogo no existe, verifique";
	public static final String ERROR_PROYECTO_NODUENO = "El proyecto no pertenece al usuario, verifique";
	public static final String ERROR_PERMISO_ERROR = "Usted no posee los privilegios para realizar esta actualización";
	public static final String ERROR_INTERNAL_MENSAJE = "Ha ocurrido un error en el servidor, por favor intente mas tarde";
	
	public static final String ERROR_INTERNAL = "999";
	public static final String ERROR_TECNICO_GENERICO_COD = "001";
	public static final String ERROR_USUARIO_EXISTE_COD = "002";
	public static final String ERROR_PERMISO_GENERICO_COD = "003";
	public static final String ERROR_SP_COD = "004";
	public static final String estadoActivo = "A";
	public static final String estadoBloqueado = "B";
	public static final String estadoEliminadoElementoDialogo = "DELE";
	
	
}

