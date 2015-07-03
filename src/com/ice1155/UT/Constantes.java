package com.ice1155.UT;

import com.ice1155.DA.User;

public class Constantes {
	// Token for post 
	public static String accessToken = "";
	public static User user = new User();
	
	//localhost(HP)
	//private final static String SERVER = "http://192.168.1.7:8080/backend-gimnasio/";
	//private final static String SERVER = "http://172.22.12.161:8080/backend-gimnasio/";
	//Server de pruebas
	private final static String SERVER = "http://190.171.0.181:8080/backend-gimnasio/";
	
	//Login
	public static final String LOGIN = SERVER + "api/login";
	
	//Entrenadores
	private static final String ENTRENADORES = SERVER + "entrenadores/";
	public static final String MOSTRAR_ENTRENADORES = ENTRENADORES + "mostrar/";
	public static final String MOSTRAR_TODOS_ENTRENADORES = ENTRENADORES + "list/";
	public static final String GUARDAR_ENTRENADOR = ENTRENADORES+ "guardar/1";
	public static final String EDITAR_ENTRENADOR = ENTRENADORES + "actualizar/1";
	//public static final String BORRAR_ENTRENADOR = ENTRENADORES + "borrar/1";
	
	//Clientes
	private static final String CLIENTES = SERVER + "perfiles/";
	public static final String MOSTRAR_CLIENTES = CLIENTES + "mostrar/";
	public static final String MOSTRAR_TODOS_CLIENTES = CLIENTES + "list/";
	public static final String GUARDAR_CLIENTE = CLIENTES + "guardar/1";
	public static final String EDITAR_CLIENTE = CLIENTES + "actualizar/1/";
	//public static final String BORRAR_CLIENTE = CLIENTES + "borrar/1";
	
	//Rutinas
	private static final String RUTINAS = SERVER + "rutinas/";
	public static final String MOSTRAR_RUTINA = RUTINAS + "rutinas/mostrar/";
	public static final String GUARDAR_RUTINA = RUTINAS + "rutinas/guardar/1";
	public static final String EDITAR_RUTINA = RUTINAS + "rutinas/actualizar/1";
	//public static final String BORRAR_RUTINA = RUTINAS + "rutinas/borrar/1";

}