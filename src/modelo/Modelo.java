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

	public void setVista (Vista[] misVistas) {
		this.misVistas = misVistas;
	}
	
	public boolean validarUsuario(String usuario, String pwd) {
		boolean comprobacion = false;
		miConexion = new Conexion();
		
		return comprobacion;
	}
	
	public void insertarUsuario() {
		
	}

}
