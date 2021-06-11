package com.Unla.TPPOO2.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	
	//ACCESO
	public final static String ACCESO_LOGIN = "acceso/login";
	public final static String ACCESO_REGISTER = "acceso/register";
	
	//USUARIO
	public final static String USUARIO_AGREGAR = "usuario/agregarUsuario";
	public final static String USUARIO_TABLA = "usuario/usuariosVista";
	
	//PERFIL
	public final static String PERFIL_AGREGAR = "perfil/agregarPerfil";
	public final static String PERFIL_TABLA = "perfil/perfilesVista";
	
	//PERSONA
	public final static String PERSONA_AGREGAR = "persona/agregarPersona";
	
	//RODADO
	public final static String RODADO_AGREGAR = "rodado/agregarRodado";
	
	//PERMISO
	public final static String PERMISO_DIARIO_AGREGAR = "permiso/agregarPermisoDiario";
	public final static String PERMISO_PERIODO_AGREGAR = "permiso/agregarPermisoPeriodo";
	public final static String PERMISO_TABLA = "permiso/traerPermiso";
	public final static String PERMISO_QR = "QRCode/traerPermisoQR";
	
	
	/**** Redirects ****/
	public final static String INDEX_HOME = "redirect:/";
	public final static String INDEX_USUARIOS = "redirect:/user/list";
	public final static String INDEX_PERFILES= "redirect:/perfil/list";
	public final static String INDEX_PERMISOS = "redirect:/permiso/list";
}
