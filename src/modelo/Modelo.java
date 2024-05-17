package modelo;

/**
 * @author Andrés
 */

import controlador.Controlador;
import vista.Vista;

public class Modelo {

	private Vista[] misVistas;
	private Controlador miControlador;
	private Conexion miConexion;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public boolean validarUsuario(String usuario, String pwd) {
		boolean comprobacion = false;
		miConexion = new Conexion();

		return comprobacion;
	}

	public void insertarUsuario(String nombre, String pwd, String apellido,int codPostal, String pregunta, String respuesta,
			String admin, int claveAdmin) {
		miConexion = new Conexion();
		
		int valor = miConexion.consultaPrepared("Select * from BookShare.administracion where valor = ?",claveAdmin,2);
		
		if(valor == 1) {
			admin = "si";
		}else {
			admin = "no";
		}
		
		miConexion.insertar(nombre, pwd, apellido, admin, codPostal);
	}

}
