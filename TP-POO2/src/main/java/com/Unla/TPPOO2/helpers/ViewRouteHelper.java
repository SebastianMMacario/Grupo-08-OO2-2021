package com.Unla.TPPOO2.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";
		
	//USUARIO
	public final static String USUARIO_AGREGAR = "usuario/agregarUsuario";
	public final static String USUARIO_TABLA = "usuario/usuariosVista";
	
	//ACCESO
	public final static String ACCESO_LOGIN = "acceso/login";
	public final static String ACCESO_REGISTER = "acceso/register";
	
	//PERFIL
	public final static String PERFIL_AGREGAR = "perfil/agregarPerfil";
	public final static String PERFIL_TABLA = "perfil/perfilesVista";
	
	//PERMISO
	public final static String PERMISO_TABLA = "permiso/traerPermiso";
	public final static String PERMISO_QR = "QRCode/traerPermisoQR";
	
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String DEGREE_ROOT = "/degrees/";
	public final static String PERSON_ROOT = "/person";
}
