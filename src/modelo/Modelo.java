package modelo;

import java.sql.SQLException;

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

	public int sacarPregunta(String pregunta) {
		miConexion = new Conexion();
		return (miConexion.devueltaPregunta("select * from BookShare.pregunta_recuperacion where pregunta = ?",
				pregunta, 1) + 1);
	}

	public void insertarUsuario(String usr, String nombre, String apellido, String pwd, int codPostal, int pregunta,
			String respuesta, String rol, int claveAdmin) {

		int valor = miConexion.comproAdmin("Select * from BookShare.administracion where valor = ?", claveAdmin,
				2);

		if (valor == 1) {
			rol = "Administrador";
		} else {
			rol = "Usuario";
		}

		miConexion.insertar(usr, nombre, apellido, pwd, rol, codPostal, pregunta, respuesta);

	}

}
