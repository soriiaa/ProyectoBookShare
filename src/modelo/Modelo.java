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
	private String usuario;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public boolean validarUsuario(String usuario, String pwd) {
		this.usuario = usuario;
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

	public void insertarUsuario(String usr, String nombre, String apellido, String pwd, int codPostal, int pregunta,
			String respuesta, String rol, int claveAdmin) {

		int valor = miConexion.comproAdmin("Select * from BookShare.administracion where valor = ?", claveAdmin, 2);

		if (valor == 1) {
			rol = "Administrador";
		} else {
			rol = "Usuario";
		}

		miConexion.insertar(usr, nombre, apellido, pwd, rol, codPostal, pregunta, respuesta);
	}

	public Object[][] busquedaCodPostal(int busqueda) {

		Conexion miConexion = new Conexion();

		String consulta = "SELECT cod_postal.codigo_postal, libro.titulo AS tituloLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON lugar.id = libro_lugar.id_Lugar inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal where cod_postal.codigo_postal = ?";

		String consultaCp = "select codigo_postal from cod_postal where codigo_postal = ?";
		
		int numeroFilas = miConexion.contarRegistros(consultaCp, busqueda);
		
		Object[][] info = new Object[numeroFilas][2];

		info = miConexion.sacarLibroLugar(consulta, busqueda, numeroFilas);

		return info;
	}
	


	public ArrayList<Object> cogerLibroBaseDatos () {
		
		ArrayList<Object> listaLibros = new ArrayList<>();
		
		String consultaNumeroLibros = "Select * from libro";
		int numeroLibros;
		
		Conexion miConexion = new Conexion();
		numeroLibros = miConexion.contarRegistrosTablaLibros(consultaNumeroLibros);
		
		return listaLibros;

	}

}
