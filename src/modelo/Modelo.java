package modelo;

import java.util.ArrayList;

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
		if (miConexion.comproLogin("select * from BookShare.users where usr = ? and pwd = ?", usuario, pwd)) {
			comprobacion = true;
		}
		return comprobacion;
	}

	public int sacarPregunta(String pregunta) {
		miConexion = new Conexion();
		return (miConexion.devueltaPregunta("select * from BookShare.pregunta_recuperacion where pregunta = ?",
				pregunta, 1) + 1);
	}

	public void insertarUsuario(String usr, String nombre, String apellido, String pwd, int codPostal, int pregunta, String respuesta, String rol, int claveAdmin) {

		int valor = miConexion.comproAdmin("Select * from BookShare.administracion where valor = ?", claveAdmin, 2);

		if (valor == 1) {
			rol = "Administrador";
		} else {
			rol = "Usuario";
		}

		miConexion.insertar(usr, nombre, apellido, pwd, rol, codPostal, pregunta, respuesta);
	}
	
	public ArrayList<Object> cogerLibroBaseDatos () {
		
		ArrayList<Object> listaLibros = new ArrayList<>();
		
		String consultaNumeroLibros = "Select * from libro";
		int numeroLibros;
		
		Conexion miConexion = new Conexion();
		numeroLibros = miConexion.contarRegistrosTablaLibros(consultaNumeroLibros);
		
		return listaLibros;
	}
	
	public void editarDatosAltaBajaLibros() {
		
	}

}
