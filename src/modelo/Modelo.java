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
		String queryHistorial = "select * from historial where usr = ?";
		int numeroFilasHistorial = miConexion.contarRegistros(queryHistorial, usuario);
//		int[] filtroCoger = miConexion.sacarIdCoger(queryCoger, usuario, numeroFilasCoger);
//		int[] filtroDejar = miConexion.sacarIdCoger(queryDejar, usuario, numeroFilasDejar);
		System.out.println(numeroFilasHistorial);
		// ? == filtro
		String consultaId = "select id from libro where titulo = ?";

		String consulta = "SELECT historial.titulo, libro.autor, libro.genero, libro.disponible, dejar.valoracion, historial.fecha, historial.accion, historial.cod_postal "
				+ "FROM historial INNER JOIN users ON historial.usr = users.usr LEFT JOIN dejar ON historial.usr = dejar.usr AND historial.titulo = historial.titulo "
				+ "INNER JOIN libro ON historial.titulo = libro.titulo INNER JOIN libro_lugar ON libro.id = libro_lugar.id_libro INNER JOIN lugar ON libro_lugar.id_lugar = lugar.id "
				+ "INNER JOIN cod_postal ON lugar.codigo_postal = cod_postal.codigo_postal WHERE historial.usr = ? order by historial.fecha desc";
		Object[][] datos = new Object[numeroFilasHistorial][];
		datos = miConexion.sacarHistorialLibros(consulta, usuario, numeroFilasHistorial);

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

	
	public int darLibroAlta(String titulo, String autor, String codigoPostal) {
		
		// Retorno 0: El codigo postal no existe en la base de datos externa
		
		
		// Consulta para comprobar si existe el código postal.		
		String[] listaDatosCodigoPostal;
		boolean existeCodigoPostalEnBaseDeDatos;
		
		String consultaCodigoPostal = "SELECT cp, provincia, poblacio FROM codipostal WHERE cp = ? LIMIT 1";
		listaDatosCodigoPostal = miConexionPostal.verificarExistenciCodigoPostal(consultaCodigoPostal, codigoPostal);
		
		// Si el código postal existe en la base de datos externa al proyecto
		if (!listaDatosCodigoPostal[0].equals("ERROR")) {
			
			// Compruebo que no esté añadido ya en la base de datos propia
			String consultaComprobarExistenciaCodigoPostal = "SELECT codigo_postal FROM cod_postal WHERE codigo_postal = ?";
			existeCodigoPostalEnBaseDeDatos = miConexion.comprobarExistenciaCodigoPostal(consultaComprobarExistenciaCodigoPostal, listaDatosCodigoPostal[0]);
			
			String cp = listaDatosCodigoPostal[0];
			String provincia = listaDatosCodigoPostal[1];
			String poblacion = listaDatosCodigoPostal[2];
			
			// Si no esta, lo inserto con toda su información
			if (!existeCodigoPostalEnBaseDeDatos) {
				
				// Inserto en nuestra base de datos la información del lugar.
				String consulta = "INSERT INTO cod_postal (codigo_postal, comunidad_autonoma, provincia, poblacion) VALUES (?, 'Desconocida', ?, '0')";
				
				miConexion.insertarCodigoPostalProvinciaPoblacion(consulta, cp, provincia);
				
			}  // Después creo el lugar, que será desconocido.
				
			String consultaInsertarLugar = "INSERT INTO lugar (nombre, codigo_postal) VALUES ('Desconocido', ?)";
			miConexion.insertarLugarDesconocido(consultaInsertarLugar, cp);
			
			// Ahora tengo que comprobar si el libro existe en nuestra base de datos, para ello, voy a buscar que no haya ninguno registro en el cual coincidan
			// titulo y autor
			
			String consultaExisteLibro = "SELECT titulo, autor FROM libro WHERE titulo = ? AND autor = ?";
			int existe = miConexion.buscarLibroPorTituloYAutor(consultaExisteLibro, titulo, autor);
			
			if (existe == 0) { // El libro no existe
				
				// Si el libro no existe lo inserto.
				
				String consultaIntroducirLibro = "INSERT INTO libro (titulo, autor, disponible, genero, activo) VALUES (?, ?, 1, 'Desconocido', 1)";
				miConexion.insertarLibroTituloAutor(consultaIntroducirLibro, titulo, autor);
				
			}
			
			// Ahora debo enlazar el lugar con el libro.
			
			// Busco el id del libro
			String consultaId_Libro = "SELECT id FROM libro WHERE titulo = ? AND autor = ?";
			String id_Libro = miConexion.devolverIdLibroBuscado(consultaId_Libro, titulo, autor);
			
			// Busco el id del lugar
			String consultaId_Lugar = "SELECT id FROM lugar WHERE codigo_postal = ?";
			String id_Lugar = miConexion.devolverIdLugarBuscado(consultaId_Lugar, codigoPostal);
			
			String consultaEnlaceLibroLugar = "INSERT INTO libro_lugar (id_Libro, id_Lugar, Fecha) VALUES (?, ?, ?)";
			Date fechaAct = new Date();
			java.sql.Date sqlDate = new java.sql.Date(fechaAct.getTime());
			
			miConexion.insertarLibroLugar(consultaEnlaceLibroLugar, id_Libro, id_Lugar, sqlDate);
			
			
		} else {
			return 0;
		}
		
		return 1;
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

		int cuenta = miConexion.contarRegistrosComproDejar("select * from libro inner join coger on libro.id = coger.id where libro.titulo like ? and libro.disponible = 0 and coger.id = ? and coger.usr = ?",	titulo, id, usuario);
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

	public void actualizarHistorial(String titulo, int codPostal) {
		String query = "insert into historial (usr,titulo,accion,fecha,cod_postal) values(?,?,?,?,?)";
		String accion = "dejar";
		String consultaFecha = "select fecha from dejar where usr = ?";

		java.sql.Date fecha = miConexion.sacarFechaCogerDejar(consultaFecha, usuario);

		miConexion.actualizarHistorial(query, usuario, titulo, accion, fecha, codPostal);
	}

	public void actualizarHistorialCoger(String titulo) {
		String query = "insert into historial (usr,titulo,accion,fecha,cod_postal) values(?,?,?,?,?)";
		String accion = "coger";
		String consultaFecha = "select fecha from coger where usr = ?";

		String idStr = miConexion.sacarIdLibro("select * from libro where titulo = ?", titulo);
		int id = Integer.parseInt(idStr);

		String consultaCodPostal = "select cod_postal.codigo_postal from libro inner join libro_lugar on libro.id = libro_lugar.id_libro inner join lugar on libro_lugar.id_lugar = lugar.id inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal where libro.id = ?";

		int codPostal = miConexion.sacarCodPostal(consultaCodPostal, id);

		java.sql.Date fecha = miConexion.sacarFechaCogerDejar(consultaFecha, usuario);

		miConexion.actualizarHistorial(query, usuario, titulo, accion, fecha, codPostal);
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


