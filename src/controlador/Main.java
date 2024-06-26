/**
 * @author PABLO APARICIO
 */
package controlador;


import modelo.Modelo;
import vista.Vista;
import vista._00_PantallaInicio;
import vista._01_Login;
import vista._02_BuscarPorLocalidad;
import vista._03_PaginaPrincipalSinLog;
import vista._04_Registro;
import vista._05_OlvidoContraseña;
import vista._06_PantallaPrincipal;
import vista._07_AltaLibro;
import vista._08_CogerLibro;
import vista._09_DejarLibro;
import vista._10_HistorialLibros;
import vista._11_Faq;
import vista._12_MiPerfil;
import vista._13_BandejaDeEntrada;
import vista._14_PantallaPrincipalAdmin;
import vista._15_EnviarMensaje;
import vista._16_DarDeBajaLibro;
import vista._17_DarDeBajaLugar;
import vista._18_ConfiguracionConexion;

public class Main {
	
	public static void main(String[] args) {

		// Creo tres objetos de las diferentes clases del proyecto
		// La encargada del modelo
		Modelo miModelo = new Modelo();
		// Un Array de Vistas con todas las vistas que tendrá la app
		Vista[] misVistas = new Vista[19];
		// La encargada del controlador
		Controlador miControlador = new Controlador();
		
		

		// Tengo que introducir manualmente en el array todas las vistas creadas
		misVistas[0] = new _00_PantallaInicio();
		misVistas[1] = new _01_Login();
		misVistas[2] = new _02_BuscarPorLocalidad();
		misVistas[3] = new _03_PaginaPrincipalSinLog();
		misVistas[4] = new _04_Registro();
		misVistas[5] = new _05_OlvidoContraseña();
		misVistas[6] = new _06_PantallaPrincipal();
		misVistas[7] = new _07_AltaLibro();
		misVistas[8] = new _08_CogerLibro();
		misVistas[9] = new _09_DejarLibro();
		misVistas[10] = new _10_HistorialLibros();
		misVistas[11] = new _11_Faq();
		misVistas[12] = new _12_MiPerfil();
		misVistas[13] = new _13_BandejaDeEntrada();
		misVistas[14] = new _14_PantallaPrincipalAdmin();
		misVistas[15] = new _15_EnviarMensaje();
		misVistas[16] = new _16_DarDeBajaLibro();
		misVistas[17] = new _17_DarDeBajaLugar();
		misVistas[18] = new _18_ConfiguracionConexion();

		// Con estos metodos permito que se conozcan el modelo el controlador y las
		// vistas
		miModelo.setVista(misVistas);
		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);

		// Al tener varias vistas y tener que repetir que se conozca a todas, se
		// itera con un for each
		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}

		// Por último hago visible la lanzadera para poder navegar por todas partes
		
		_03_PaginaPrincipalSinLog frame = (_03_PaginaPrincipalSinLog) misVistas[3];
		
		frame.setVisible(true);

	}
}
