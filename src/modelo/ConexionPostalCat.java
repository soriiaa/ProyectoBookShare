package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
		}catch (IOException e){
			System.out.println("Error al leer el fichero de configuracion de codigos Postales");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Error general de Conexión con la BBDD de codigos Postales");
			e.printStackTrace();
		}
	}
}
