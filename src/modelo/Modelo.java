package modelo;

/**
 * @author Andrés
 */

import controlador.Controlador;
import vista.Vista;

public class Modelo {

	private Vista[] misVistas;
	private Controlador miControlador;
	private Conexion miConexion = new Conexion();
	private String consultaLibros;
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
		
		if (miConexion.comproLogin("select * from BookShare.users where usr = ? and pwd = ?", usuario, pwd)) {
			comprobacion = true;
		}
		return comprobacion;
	}

	public int sacarPregunta(String pregunta) {
		
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

		

		String consulta = "SELECT cod_postal.codigo_postal, libro.titulo AS tituloLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON lugar.id = libro_lugar.id_Lugar inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal where cod_postal.codigo_postal = ?";

		String consultaCp = "select codigo_postal from cod_postal where codigo_postal = ?";

		int numeroFilas = miConexion.contarRegistros(consultaCp, busqueda);

		Object[][] info = new Object[numeroFilas][2];

		info = miConexion.sacarLibroLugar(consulta, busqueda, numeroFilas);

		return info;
	}

	public String[][] cogerLibroBaseDatos() {

		String consultaLibros = "SELECT libro.id AS idLibro, libro.titulo AS tituloLibro, lugar.nombre AS nombreLugar, libro.genero AS generoLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON libro_lugar.id_Lugar = lugar.id WHERE libro.disponible = 1";

		String[][] arrayLibros = miConexion.cogerLibrosIdTituloLugarGenero(consultaLibros);

		return arrayLibros;
	}
	
	public Object[][] sentenciaHistorial() {
	  
	    // ? == usuario atributo
	    String cons = "select id from coger where usr like ?";
	    int numeroFilas = miConexion.contarRegistros(cons, usuario);
	    System.out.println(numeroFilas);
	    int[] filtro = miConexion.sacarIdCoger(cons, usuario, numeroFilas);
	    
	    // ? == filtro
	    String consulta = "SELECT libro.titulo, libro.autor, libro.genero, libro.disponible, libro.activo, dejar.valoracion, cod_postal.codigo_postal, dejar.fecha FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON lugar.id = libro_lugar.id_Lugar inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal INNER JOIN dejar ON libro.id = dejar.id where libro.id = ?";
	    Object[][] datos = new Object[numeroFilas][8];
	    datos = miConexion.sacarHistorialLibros(consulta, numeroFilas, filtro);
	    
	    return datos;
	}
	
	public void libroNoDisponible(String titulo) {
		
		String consulta1 = "SET SQL_SAFE_UPDATES = 0";
		String consulta2 = "UPDATE libro SET disponible = 0 WHERE titulo = ?";
		
		miConexion.actualizarDisponibilidadANoDisponible(consulta1, consulta2, titulo);
		
	}

}
