package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionPostalCat {
	private String login;
	private String pwd;
	private String url;
	private Connection conexion;
	private Properties misPropiedades;
	private FileInputStream input;
	private OutputStream output;
	private File miFichero;
	private final String FILE = "configuracionPostal.ini";

	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUrl() {
		return url;
	}

	public ConexionPostalCat() {
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
			System.out.println("-> Proyecto conectado con la BBDD de codigos Postales.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD de codigos Postales");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero de configuracion de codigos Postales");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error general de Conexión con la BBDD de codigos Postales");
			e.printStackTrace();
		}
	}

	// Con este método veo si el código postal buscado existe en la base de datos y si existe devuelve más info.

	/**
	 * 
	 * @param consulta
	 * @param codigoPostal a verificar la existencia
	 * @return
	 */

	public String[] verificarExistenciCodigoPostal(String consulta, String codigoPostal) {
	    ResultSet resultSet;
	    
	    String[] error = new String[1];
	    error[0] = "ERROR";

	    try {
	        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
	        preparedStatement.setString(1, codigoPostal);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) { // Mover cursor a la primera fila
	            String[] listaDatosCodPostal = new String[3];
	            
	            listaDatosCodPostal[0] = resultSet.getString("cp");
	            listaDatosCodPostal[1] = resultSet.getString("provincia");
	            listaDatosCodPostal[2] = resultSet.getString("poblacio");
	            
	            return listaDatosCodPostal;
	        } else {
	            return error;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return error;
	}

}
