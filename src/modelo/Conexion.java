package modelo;

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
import java.util.List;

public class Conexion {

	private String db = "BookShare";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + db;
	private Connection conexion;

	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("-> Proyecto conectado con la BBDD.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
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
			pstmt.setString(1,filtro);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			return res;
		}catch(SQLException s) {
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
			String nick = "Nick";
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
	
	public String[][] cogerLibrosIdTituloLugarGenero (String query) {
		
		String[][] error2 = new String[1][1];
		
		try {
			int i = 0;
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				i++;
			}
			
			resultSet = preparedStatement.executeQuery();
			
			String[][] libros = new String[i][4];
			
			System.out.println("Coger Libro Funciona");
			
			int j = 0;
			
			while(resultSet.next()) {
			
				
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

	public Object[][] sacarHistorialLibros(String query, int numeroFilasCoger, int numeroFilasDejar,int[] filtroCoger, int[] filtroDejar) {
		Object[][] datos = new Object[numeroFilasCoger+numeroFilasDejar][9];

		for (int i = 0; i < numeroFilasCoger+numeroFilasDejar; i++) {
			try {
				PreparedStatement pstmt = conexion.prepareStatement(query);
				if(i < filtroCoger.length) {
					pstmt.setInt(1, filtroCoger[i]);
				}else if(i < filtroDejar.length) {
					pstmt.setInt(1, filtroDejar[i]);
				}
				
				ResultSet rs = pstmt.executeQuery();

				// Verificar si hay resultados antes de procesarlos
				if (rs.next()) {
					datos[i][0] = rs.getObject(1);
					datos[i][1] = rs.getObject(2);
					datos[i][2] = rs.getObject(3);
					datos[i][3] = rs.getObject(4);
					datos[i][4] = rs.getObject(5);
					datos[i][5] = rs.getObject(6);
					datos[i][6] = rs.getObject(7);
					datos[i][7] = rs.getObject(8);
					datos[i][8] = rs.getObject(9);
				}

				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return datos;

	}
}
