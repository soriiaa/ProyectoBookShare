package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrés
 */

import controlador.Controlador;
import vista.Vista;
import vista._18_ConfiguracionConexion;

public class Modelo {

	private Vista[] misVistas;
	private Controlador miControlador;
	private Conexion miConexion;
	private ConexionPostalCat miConexionPostal;
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

		// De momento da error porque los nuevos libros no están asociados a un lugar.

		String consultaLibros = "SELECT libro.id AS idLibro, libro.titulo AS tituloLibro, lugar.nombre AS nombreLugar, libro.genero AS generoLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON libro_lugar.id_Lugar = lugar.id WHERE libro.disponible = 1";

		String[][] arrayLibros = miConexion.cogerLibrosIdTituloLugarGenero(consultaLibros);

		return arrayLibros;
	}

	public void cambiarEstadoCogerLibro(String valor) {
		String consultaIdLibro = "select id from libro where titulo = ?";
		String idLibro = miConexion.consultaConFiltro(consultaIdLibro, valor);
		String consultaUsuarioLibro = "insert into coger(usr, id, Fecha) values(?,?,?)";
//		java.util.Date fechaAct = new java.util.Date();
		Date fechaAct = new Date();
		java.sql.Date sqlDate = new java.sql.Date(fechaAct.getTime());
		miConexion.insertarCogerLibroUsuario(consultaUsuarioLibro, usuario, idLibro, sqlDate);

		miConexion.imprimir("select * from coger", 1);
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
		Object[][] datos = new Object[numeroFilasCoger + numeroFilasDejar][9];
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

		if (rol.equals("Administrador")) {
			admin = true;
		}

		return admin;
	}

	public Object[][] sacarLugaresBase() {

		String consulta = "select nombre, codigo_postal from lugar";

		int numFilas = miConexion.contarRegistros(consulta);

		Object[][] datos = miConexion.sacarLugares(consulta, numFilas);

		return datos;
	}

	public void conectorInsertLugar(String nombre, int codPostal) {

		miConexion.insertarLugar(nombre, codPostal);
	}

	public void conectorDeleteLugar(String nombre, int codPostal) {
		miConexion.deleteLugar(nombre, codPostal);
	}

	public void conectorUpdateLugar(String nombre, int codPostal) {
		 String consultaID = "select id from lugar where nombre = ? and codigo_postal = ?";
		 int id = miConexion.sacarIDLugar(consultaID, nombre, codPostal);

		String consulta = "update lugar set nombre = ? where id = ?";

		miConexion.updateLugar(consulta, nombre, id);
	}

	public String[] recogerInfoConexion() {
		String[] datos = new String[3];
		datos[0] = miConexion.getLogin();
		datos[1] = miConexion.getPwd();
		datos[2] = miConexion.getUrl();

		return datos;
	}

	public void activarConexion() {
		miConexion = new Conexion();
		miConexionPostal = new ConexionPostalCat();
	}

	public void modificarDatosConfiguracion(String url, String usuario, String contrasena) {
		miConexion.modificarDatosConfiguracion(url, usuario, contrasena);
		((_18_ConfiguracionConexion) misVistas[18]).actualizar();
	}

	public boolean devolverConexion() {
		if (miConexion == null) {
			return false;
		} else {
			return true;
		}
	}

	public void insertarDatosDejarLibro(String titulo, String fechaRecogida, String codigoPostal, String comentario,
			String valoracion) {

		String idStr = miConexion.consultaConFiltro("select id from libro where titulo like ? limit 1", titulo);
		int id = Integer.parseInt(idStr);
		String consulta = "INSERT into dejar (usr, id, fecha, comentario, valoracion) values(?,?,?,?,?)";

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;
		try {

			// Parsear el String a java.util.Date
			java.util.Date fechaAct = formato.parse(fechaRecogida);

			// Convertir java.util.Date a java.sql.Date
			sqlDate = new java.sql.Date(fechaAct.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		valoracion = valoracion + "/5";
		miConexion.introducirDejarLibro(consulta, usuario, id, sqlDate, comentario, valoracion);
	}

	public boolean comprobarLibroBBDD(String titulo) {

		String query = "Select id from libro where titulo = ?";

		String idStr = miConexion.sacarIdLibro(query, titulo);
		int id = Integer.parseInt(idStr);
		System.out.println(id);

		int cuenta = miConexion.contarRegistrosComproDejar(
				"select * from libro inner join coger on libro.id = coger.id where libro.titulo like ? and libro.disponible = 0 and coger.id = ? and coger.usr = ?",
				titulo, id, usuario);
//titulo,id,usuario

		if (cuenta > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void cambiarEstadoDejarLibro(String titulo) {

		String query = "UPDATE libro set disponible = 1 where titulo like ?";
		miConexion.actualizarDisponibilidadADisponible(query, titulo);
	}

	public void eliminarLibroTablaCoger(String titulo) {
		String query = "Select id from libro where titulo = ?";

		String idStr = miConexion.sacarIdLibro(query, titulo);
		int id = Integer.parseInt(idStr);

		String queryDelete = "delete from coger where id = ?";

		miConexion.eliminarRegistroTablaCoger(queryDelete, id);
	}

	public void actualizarHistorial(String titulo) {
		String query = "insert into historial (usr,titulo,accion) values(?,?,?)";
		String accion = "dejar";

		miConexion.actualizarHistorial(query, usuario, titulo, accion);
	}
	public void actualizarHistorialCoger(String titulo) {
		String query = "insert into historial (usr,titulo,accion) values(?,?,?)";
		String accion = "coger";

		miConexion.actualizarHistorial(query, usuario, titulo, accion);
	}

	public void eliminarDatosDejarLibro(String titulo) {
		String idStr = miConexion.consultaConFiltro("select id from libro where titulo like ? limit 1", titulo);
		int id = Integer.parseInt(idStr);
		String consulta = "DELETE from dejar where id = ?";

		Date fechaActual = new Date();
		java.sql.Date sqlDate = null;

		// Parsear el String a java.util.Date
		java.util.Date fechaAct = new java.sql.Date(fechaActual.getTime());

		// Convertir java.util.Date a java.sql.Date
		sqlDate = new java.sql.Date(fechaAct.getTime());
		
		miConexion.eliminarRegistroTablaDejar(consulta, id);

	}

}
