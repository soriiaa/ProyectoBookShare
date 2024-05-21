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
	    String queryCoger = "select id from coger where usr like ?";
	    int numeroFilasCoger = miConexion.contarRegistros(queryCoger, usuario);
	    String queryDejar = "select id from dejar where usr like ?";
	    int numeroFilasDejar = miConexion.contarRegistros(queryDejar, usuario);
	    int[] filtroCoger = miConexion.sacarIdCoger(queryCoger, usuario, numeroFilasCoger);
	    int[] filtroDejar = miConexion.sacarIdCoger(queryDejar, usuario, numeroFilasDejar);

	    // ? == filtro
	    String consulta = "SELECT libro.titulo, libro.autor, libro.genero, libro.disponible, libro.activo, dejar.valoracion, cod_postal.codigo_postal, dejar.fecha, coger.fecha FROM libro left JOIN dejar ON libro.id = dejar.id left JOIN coger on libro.id = coger.id INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON lugar.id = libro_lugar.id_Lugar inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal where libro.id = ?";
	    Object[][] datos = new Object[numeroFilasCoger+numeroFilasDejar][9];
	    datos = miConexion.sacarHistorialLibros(consulta, numeroFilasCoger, numeroFilasDejar, filtroCoger, filtroDejar);

	    return datos;
	}
	
	public void libroNoDisponible(String titulo) {
		
		String consulta1 = "SET SQL_SAFE_UPDATES = 0";
		String consulta2 = "UPDATE libro SET disponible = 0 WHERE titulo = ?";
		
		miConexion.actualizarDisponibilidadANoDisponible(consulta1, consulta2, titulo);
		
	}

	public Object[][] sacarDatosLibro() {
		String consulta = "select titulo, autor, genero from libro";
		int filas = miConexion.contarRegistros(consulta);
		Object[][] datos = miConexion.sacarDatosAltaBajaLibros(consulta, filas);	
		return datos;
	}

	public void actualizarDatosBajaAltaLibro(String titulo, String autor, String genero, String tituloAntiguo) {
		String sacarId = "select id from libro where titulo = ?";
		String id = miConexion.sacarIdLibro(sacarId, tituloAntiguo);
		String consulta = "update libro set titulo = ?, autor = ?, genero = ? where id = ?";
		miConexion.actualizarAltaBajaLibros(consulta, titulo, autor, genero, id);
	}

	public void AltaDatosAltaBajaLibro(String titulo, String autor, String genero) {
		String consulta = "insert into libro (titulo, autor, genero, disponible, activo) values (?,?,?, true, true)";
		miConexion.insertarAltaBajaLibros(consulta, titulo, autor, genero);
	}

	public void BajaDatosAltaBajaLibro(String titulo) {
		String sacarId = "select id from libro where titulo = ?";
		String id = miConexion.sacarIdLibro(sacarId, titulo);
		String consulta = "delete from libro where id = ?";
		miConexion.bajaAltaBajaLibros(consulta, id);
	}

	public boolean validarAdmin(String usuarioInput) {
		boolean admin = false;
		
		String sentencia = "select rol from users where usr like ?";
		
		String rol = miConexion.consultaConFiltro(sentencia, usuarioInput);
		
		if(rol.equals("Administrador")) {
			admin = true;
		}
		
		return admin;
	}
	
	public Object[][] sacarLugaresBase(){
		
		String consulta = "select * from cod_postal";
		
		int numFilas = miConexion.contarRegistros(consulta);
		
		Object[][] datos = miConexion.sacarLugares(consulta, numFilas);
		
		return datos;
	}

	public void conectorInsertLugar(int codPostal, String comunidad, String provincia, String poblacion) {
		
		miConexion.insertarLugar(codPostal, comunidad, provincia, poblacion);
	}

	public void conectorDeleteLugar(int codPostal, String comunidad, String provincia, String poblacion) {
		miConexion.deleteLugar(codPostal, comunidad, provincia, poblacion);
	}

	public void conectorUpdateLugar(int codPostal, String comunidad, String provincia, int poblacion,
			int codPostalAntiguo) {

		String consulta = "update cod_postal set codigo_postal = ?, comunidad_autonoma = ?, provincia = ?, poblacion = ? where codigo_postal = ?";
		
		miConexion.updateLugar(consulta, codPostal, comunidad, provincia, poblacion, codPostalAntiguo);
	}
}
