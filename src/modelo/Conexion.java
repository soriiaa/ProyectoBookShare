package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Conexion {

	private String login;
	private String pwd;
	private String url;
	private Connection conexion;
	private Properties misPropiedades;
	private FileInputStream input;
	private OutputStream output;
	private File miFichero;
	private final String FILE = "configuracion.ini";

	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUrl() {
		return url;
	}

	public Conexion() {
		try {
			miFichero = new File(FILE);
			misPropiedades = new Properties();
			input = new FileInputStream(miFichero);
			misPropiedades.load(input);

			login = misPropiedades.getProperty("login");
			pwd = misPropiedades.getProperty("pwd");
			url = misPropiedades.getProperty("url");

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("-> Proyecto conectado con la BBDD.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero de configuracion");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error general de Conexión");
			e.printStackTrace();
		}
	}

	public void terminar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void imprimir(String query, int columna) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next())
				System.out.println(rset.getString(columna));
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public String consultaConFiltro(String query, String filtro) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String res = "";
		try {
			pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, filtro);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				res = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			return res;
		}

	}

	public int consultaStatement(String query, int columna) {
		int res = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next())
				res = 1;
			System.out.println(rset.getString(columna));
			rset.close();
			stmt.close();
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			return res;
		}
	}

	public int devueltaPregunta(String query, String cod, int columna) {
		int res = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, cod);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				res = 1;
			rset.close();
			pstmt.close();
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			return res;
		}
	}

	public boolean comproLogin(String query, String usr, String pwd) {
		boolean existe = false;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				existe = true;
			rset.close();
			pstmt.close();
			return existe;
		} catch (SQLException s) {
			s.printStackTrace();
			return existe;
		}
	}

	public int comproAdmin(String query, int cod, int columna) {
		int res = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, cod);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				res = 1;
			rset.close();
			pstmt.close();
			return res;
		} catch (SQLException s) {
			s.printStackTrace();
			return res;
		}
	}

	public void consultaPrepareCall(int id) {
		String procedimiento = "{call superpoblado(?)}";
		try {
			CallableStatement ctmt = conexion.prepareCall(procedimiento);
			ctmt.setInt(1, id);
			ctmt.execute();
			ResultSet rset = ctmt.getResultSet();
			while (rset.next())
				System.out.println(rset.getString(2));
			rset.close();
			ctmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertar(String usr, String nombre, String apellido, String pwd, String rol, int cp,
			int codigoPreguntaRecuperacion, String respuestaPreguntaRecuperacion) {
		int resultado = 0;
		try {
			String query = "INSERT INTO users (usr,nombre,apellido,pwd,rol,cp,codigoPreguntaRecuperacion,respuestaPreguntaRecuperacion) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setString(4, pwd);
			pstmt.setString(5, rol);
			pstmt.setInt(6, cp);
			pstmt.setInt(7, codigoPreguntaRecuperacion);
			pstmt.setString(8, respuestaPreguntaRecuperacion);

			resultado = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public int modificar(String pwd) {
		int resultado = 0;
		try {
			String query = "UPDATE users SET pwd = ?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, pwd);
			resultado = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public int borrar(String usr) {
		int resultado = 0;
		try {
			String query = "DELETE FROM users WHERE usr = ?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			resultado = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public void estructuraTabla() {
		try {
			String query = "SELECT * FROM city";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numeroColumnas = rsmd.getColumnCount();
			for (int i = 1; i <= numeroColumnas; i++) {
				System.out.println(rsmd.getColumnName(i) + " - " + rsmd.getColumnTypeName(i));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void infoBaseDatos() {
		try {
			DatabaseMetaData dbmd = conexion.getMetaData();
			System.out.println("URL: " + dbmd.getURL());
			System.out.println("Usuario: " + dbmd.getUserName());
			System.out.println("Driver: " + dbmd.getDriverName());
			ResultSet misTablas = dbmd.getTables("world", null, null, null);
			System.out.println("TABLAS");
			while (misTablas.next()) {
				System.out.println("-> " + misTablas.getString("TABLE_NAME"));
			}
			misTablas.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public int contarRegistros(String query) {
		int contador = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				contador++;
			}
			rset.close();
			pstmt.close();
			return contador;
		} catch (SQLException error) {
			error.printStackTrace();
			return contador;
		}
	}

	public int contarRegistros(String query, int filtro) {
		int contador = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, filtro);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				contador++;
			}
			rset.close();
			pstmt.close();
			return contador;
		} catch (SQLException error) {
			error.printStackTrace();
			return contador;
		}
	}

	public int contarRegistros(String query, String filtro) {
		int contador = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, filtro);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				contador++;
			}
			rset.close();
			pstmt.close();
			return contador;
		} catch (SQLException error) {
			error.printStackTrace();
			return contador;
		}
	}

	/**
	 * El arrayList guardará en los pares el codigo postal, y en los impares la
	 * comunidad
	 * 
	 * @param query
	 * @param filtro
	 * @return
	 */
	public ArrayList<Object> buscarLocalidad(String query, String filtro) {
		ArrayList<Object> lugares = new ArrayList<>();
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(query);
			pstmt.setString(3, filtro);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				int columna = 2;
				lugares.add(rs.getString(columna));
				columna++;
				lugares.add(rs.getString(columna));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lugares;
	}

	public Object[][] sacarLibroLugar(String query, int cod, int numFilas) {
		int res = 0;
		boolean vacio = false;
		if (numFilas == 0) {
			numFilas = 1;
			vacio = true;
		}
		Object[][] info = new Object[numFilas][2];
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, cod);
			ResultSet rset = pstmt.executeQuery();
			int i = 0;

			if (rset == null || vacio) {
				info[0][0] = "";
				info[0][1] = "";
				return info;
			}
			while (rset.next()) {
				info[i][0] = rset.getObject(1);
				info[i][1] = rset.getObject(2);
				i++;
			}
			rset.close();
			pstmt.close();
			return info;
		} catch (SQLException s) {
			s.printStackTrace();
			return info;
		}
	}

	public String[][] cogerLibrosIdTituloLugarGenero(String query) {

		String[][] error2 = new String[1][1];

		int i = 0;

		try {

			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				i++;
			}

			resultSet = preparedStatement.executeQuery();

			String[][] libros = new String[i][4];

			System.out.println("Coger Libro Funciona");

			int j = 0;

			while (resultSet.next()) {

				int idLibro = resultSet.getInt("idLibro");
				String tituloLibro = resultSet.getString("tituloLibro");
				String nombreLugar = resultSet.getString("nombreLugar");
				String generoLibro = resultSet.getString("generoLibro");

				libros[j][0] = Integer.toString(idLibro);
				libros[j][1] = tituloLibro;
				libros[j][2] = nombreLugar;
				libros[j][3] = generoLibro;

				j++;

			}

			resultSet.close();
			preparedStatement.close();
			return libros;
		} catch (SQLException error) {
			error.printStackTrace();
			return error2;
		}
	}

	public int contarRegistrosTablaLibros(String query) {
		int contador = 0;
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				contador++;
			}
			resultSet.close();
			preparedStatement.close();
			return contador;
		} catch (SQLException error) {
			error.printStackTrace();
			return contador;
		}
	}

	public int[] sacarIdCoger(String query, String filtro, int numFilas) {
		int[] librosAsociados = new int[numFilas];
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, filtro);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				librosAsociados[i] = rs.getInt(1);
				i++;
			}
			pstmt.close();
			return librosAsociados;
		} catch (SQLException e) {
			e.printStackTrace();
			return librosAsociados;
		}
	}

	public Object[][] sacarHistorialLibros(String query, String usuario, int numeroFilas) {
		Object[][] datos = new Object[numeroFilas][8];

		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usuario);

			ResultSet rs = pstmt.executeQuery();

			// Verificar si hay resultados antes de procesarlos
			int i = 0;
			while (rs.next()) {
				datos[i][0] = rs.getObject(1);
				datos[i][1] = rs.getObject(2);
				datos[i][2] = rs.getObject(3);
				datos[i][3] = rs.getObject(4);
				datos[i][4] = rs.getObject(5);
				datos[i][5] = rs.getObject(6);
				datos[i][6] = rs.getObject(7);
				datos[i][7] = rs.getObject(8);
				i++;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return datos;

	}

	public Object[][] sacarDatosAltaBajaLibros(String query, int filas) {
		Object[][] datos = new Object[filas][3];
		try {
			PreparedStatement pmtst = conexion.prepareStatement(query);
			ResultSet rset = pmtst.executeQuery();
			int i = 0;
			while (rset.next()) {
				datos[i][0] = rset.getObject(1);
				datos[i][1] = rset.getObject(2);
				datos[i][2] = rset.getObject(3);
				i++;
			}
			rset.close();
			pmtst.close();
			return datos;
		} catch (SQLException e) {
			e.printStackTrace();
			return datos;
		}
	}

	public void actualizarAltaBajaLibros(String query, String titulo, String autor, String genero, String id) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, titulo);
			pstmt.setString(2, autor);
			pstmt.setString(3, genero);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarDisponibilidadANoDisponible(String consulta1, String consulta2, String titulo) {

		try {

			Statement statement = conexion.createStatement();
			statement.executeUpdate(consulta1);

			PreparedStatement preparedStatement2 = conexion.prepareStatement(consulta2);
			preparedStatement2.setString(1, titulo);
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertarAltaBajaLibros(String query, String titulo, String autor, String genero) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, titulo);
			pstmt.setString(2, autor);
			pstmt.setString(3, genero);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String sacarIdLibro(String sacarId, String tituloAntiguo) {
		String idLibro = null;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sacarId);
			pstmt.setString(1, tituloAntiguo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				idLibro = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idLibro;
	}

	public void bajaAltaBajaLibros(String query, String id) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Object[][] sacarLugares(String consulta, int numFilas) {
		Object[][] datos = new Object[numFilas][2];

		try {
			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				datos[i][0] = rs.getObject(1);
				datos[i][1] = rs.getObject(2);
				i++;
			}
			pstmt.close();
			rs.close();
			return datos;
		} catch (SQLException e) {
			e.printStackTrace();
			return datos;
		}
	}

	public void insertarLugar(String nombre, int codPostal) {
		try {
			String query = "insert into lugar (nombre, codigo_Postal) values(?,?)";

			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codPostal);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException s) {
			System.err.println(s.getMessage());
		}
	}

	public void deleteLugar(String nombre, int codPostal) {
		try {
			String query = "delete from cod_postal where nombre = ? AND codigo_postal = ?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codPostal);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void updateLugar(String consulta, String nombre, int id) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			pstmt.setString(1, nombre);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void modificarDatosConfiguracion(String url, String usuario, String contrasena) {
		try {
			misPropiedades.setProperty("login", usuario);
			misPropiedades.setProperty("pwd", contrasena);
			misPropiedades.setProperty("url", url);
			output = new FileOutputStream(miFichero);
			login = misPropiedades.getProperty("login");
			pwd = misPropiedades.getProperty("pwd");
			this.url = misPropiedades.getProperty("url");
			misPropiedades.store(output, "Datos de login cambiados");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertarCogerLibroUsuario(String query, String usuario, String idLibro, java.sql.Date fechaAct) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usuario);
			pstmt.setString(2, idLibro);
			pstmt.setDate(3, fechaAct);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void introducirDejarLibro(String consulta, String usuario, int id, java.sql.Date sqlDate, String comentario,
			String valoracion) {
		try {

			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			pstmt.setString(1, usuario);
			pstmt.setInt(2, id);
			pstmt.setDate(3, sqlDate);
			pstmt.setString(4, comentario);
			pstmt.setString(5, valoracion);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarDisponibilidadADisponible(String query, String titulo) {
		try {

			PreparedStatement preparedStatement2 = conexion.prepareStatement(query);
			preparedStatement2.setString(1, titulo);
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int contarRegistrosComproDejar(String query, String titulo, int id, String usuario) {
		int contador = 0;
		try {

			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, titulo);
			pstmt.setInt(2, id);
			pstmt.setString(3, usuario);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				contador++;
			}
			resultSet.close();
			pstmt.close();
			return contador;
		} catch (SQLException error) {
			error.printStackTrace();
			return contador;
		}
	}

	public void eliminarRegistroTablaCoger(String queryDelete, int id) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(queryDelete);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarHistorial(String query, String usuario, String titulo, String accion, java.sql.Date fecha,
			int codPostal) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usuario);
			pstmt.setString(2, titulo);
			pstmt.setString(3, accion);
			pstmt.setDate(4, fecha);
			pstmt.setInt(5, codPostal);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void introducirCogerLibro(String consulta, String usuario, int id, java.sql.Date sqlDate) {
		try {

			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			pstmt.setString(1, usuario);
			pstmt.setInt(2, id);
			pstmt.setDate(3, sqlDate);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarRegistroTablaDejar(String consulta, int id) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int sacarIDLugar(String consultaID, String nombre, int codPostal) {
		int idLugar = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consultaID);
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codPostal );
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				idLugar = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idLugar;
		
	}

	public java.sql.Date sacarFechaCogerDejar(String consultaFecha, String usuario) {
		java.sql.Date fecha = null;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consultaFecha);
			pstmt.setString(1, usuario);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				fecha = rs.getDate(1); // Obtenemos la fecha de la primera columna del resultado
			}
			pstmt.close();
			rs.close();
			return fecha;
		} catch (SQLException e) {
			e.printStackTrace();
			return fecha;
		}
	}

	public int sacarCodPostal(String consultaCodPostal, int id) {
		int codigo = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consultaCodPostal);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				codigo = rs.getInt(1);

			}
			rs.close();
			pstmt.close();
			return codigo;

		} catch (SQLException e) {
			e.printStackTrace();
			return codigo;
		}
	}

	public boolean comprobarExistenciaCodigoPostal(String consulta, String codigoAComprobar) {

		ResultSet resultSet;
		int contadorRegistros = 0;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, codigoAComprobar);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contadorRegistros++;
			}

			if (contadorRegistros > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void insertarCodigoPostalProvinciaPoblacion(String consulta, String codigoPostal, String provincia) {

		ResultSet resultSet;

		try {
			PreparedStatement preparedStatemente = conexion.prepareStatement(consulta);
			preparedStatemente.setString(1, codigoPostal);
			preparedStatemente.setString(2, provincia);

			preparedStatemente.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertarLugarDesconocido(String consulta, String codigoPostal) {

		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, codigoPostal);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int buscarLibroPorTituloYAutor(String consulta, String titulo, String autor) {

		ResultSet resultSet;
		int contador = 0;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, autor);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contador++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (contador > 0) {
			return 1;
		} else {
			return 0;
		}

	}

	public void insertarLibroTituloAutor(String consulta, String titulo, String autor) {

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, autor);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String devolverIdLibroBuscado(String consulta, String titulo, String autor) {

		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, autor);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // Mueve el cursor al primer registro válido
				return resultSet.getString("id"); // Devuelve el valor de la columna "id"
			} else {
				return ""; // Retorna una cadena vacía si no se encontraron registros
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}

	}

	public String devolverIdLugarBuscado(String consulta, String codigo_postal) {

		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, codigo_postal);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // Mueve el cursor al primer registro válido
				return resultSet.getString("id"); // Devuelve el valor de la columna "id"
			} else {
				return ""; // Retorna una cadena vacía si no se encontraron registros
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}

	}

	public void insertarLibroLugar(String consulta, String idLibro, String idLugar, java.sql.Date fechaAct) {

		try {

			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, idLibro);
			preparedStatement.setString(2, idLugar);
			preparedStatement.setDate(3, fechaAct);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String[][] cogerPreguntasSeguridad(String consulta) {

		String[][] listaPreguntas = new String[3][2];
		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			resultSet = preparedStatement.executeQuery();
			int j = 0;

			while (resultSet.next()) {
				int i = 0;

				listaPreguntas[j][i] = resultSet.getString("codigo");
				i++;
				listaPreguntas[j][i] = resultSet.getString("pregunta");

				j++;
			}
			
			return listaPreguntas;

		} catch (SQLException e) {
			e.printStackTrace();
			return listaPreguntas;
		}

	}
	
	public String sacarRespuestaSeguridadUsuario(String consulta, String codigoPregunta, String nombreDeUsuario) {
		
		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, codigoPregunta);
			preparedStatement.setString(2, nombreDeUsuario);
			resultSet = preparedStatement.executeQuery();

			String respuestaSeguridad = "";
			
			if (resultSet.next()) {
	            respuestaSeguridad = resultSet.getString("respuestaPreguntaRecuperacion");
	        } else {
	            System.out.println("");
	        }
			
			return respuestaSeguridad;

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		
		
	}
	
	public void updateContrasenaUsuario(String consulta, String contrasena, String usuario) {
		
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
			preparedStatement.setString(1, contrasena);
			preparedStatement.setString(2, usuario);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void subirImagen(String consulta, File foto, String usuario) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			FileInputStream fis = new FileInputStream(foto);
			pstmt.setBinaryStream(1, fis, foto.length());
			pstmt.setString(2, usuario);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public byte[] sacarImagen(String consulta, String usuario) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(consulta);
			pstmt.setString(1, usuario);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getBytes("img");
			}
			pstmt.close();
			rs.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateNickName(String query,String nick, String usuario) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, nick);
			pstmt.setString(2, usuario);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
