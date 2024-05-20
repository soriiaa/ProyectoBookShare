/**
 * @author pablo
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._01_Login;
import vista._02_BuscarPorLocalidad;
import vista._04_Registro;
import vista._17_DarDeBajaLugar;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;

	public Controlador() {
		super();
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);
	}

	public boolean recogerInfo() throws NumberFormatException {

		String nombre = ((_04_Registro) misVistas[4]).getNombre().getText();
		String apellido = ((_04_Registro) misVistas[4]).getApellido().getText();
		String usr = ((_04_Registro) misVistas[4]).getUsuario().getText();
		String administrador = ((_04_Registro) misVistas[4]).getAdmin().getText();
		String pregunta = ((_04_Registro) misVistas[4]).getPreguntaSeguridad().getToolTipText();
		String respuesta = ((_04_Registro) misVistas[4]).getTxtRespuestaPreguntaSeguridad().getText();
		String codigoAdmin = ((_04_Registro) misVistas[4]).getTxtCódigo().getText();
		String contraseña = String.valueOf(((_04_Registro) misVistas[4]).geTtxtContraseñaComprobar().getPassword());
		String codigoPostal = ((_04_Registro) misVistas[4]).getTxtCodigoPostal().getText();

		if (administrador.equals(null)) {
			administrador = "Usuario";
		}

		if (codigoAdmin.equals("Código")) {
			codigoAdmin = "0";
		}

		int codAdmin = Integer.parseInt(codigoAdmin);
		int codPostal = Integer.parseInt(codigoPostal);

		int numPregunta = miModelo.sacarPregunta(pregunta);

		miModelo.insertarUsuario(usr, nombre, apellido, contraseña, codPostal, numPregunta, respuesta, administrador,
				codAdmin);

		return true;
	}

	public void camposRellenados() {
		boolean camposRellenos = !((_04_Registro) misVistas[4]).getUsuario().getText().isEmpty()
				&& !String.valueOf(((_04_Registro) misVistas[4]).getTxtContraseña().getPassword()).isEmpty()
				&& !String.valueOf(((_04_Registro) misVistas[4]).geTtxtContraseñaComprobar().getPassword()).isEmpty()
				&& !((_04_Registro) misVistas[4]).getNombre().getText().isEmpty()
				&& !((_04_Registro) misVistas[4]).getApellido().getText().isEmpty()
				&& !((_04_Registro) misVistas[4]).getTxtCodigoPostal().getText().isEmpty()
				&& !((_04_Registro) misVistas[4]).getTxtRespuestaPreguntaSeguridad().getText().isEmpty()
				&& ((_04_Registro) misVistas[4]).getPreguntaSeguridad().getSelectedIndex() != 0;

		((_04_Registro) misVistas[4]).btnRegistro_1.setEnabled(camposRellenos);
	}

	// No sabemos porque no funciona ya que true && false da false con lo cual el
	// boton no se deberia habilitar ademas de que es
	// igual que el de arriba que si funciona
	public void comprobarCamposLogin() {
		boolean camposRellenos = (((!((_01_Login) misVistas[1]).getUsuario().getText().isEmpty())
				&& (!((_01_Login) misVistas[1]).getUsuario().getText().equals("Usuario")))
				&& ((!String.valueOf(((_01_Login) misVistas[1]).getTxtContrasea().getPassword()).isEmpty()) && (!String
						.valueOf(((_01_Login) misVistas[1]).getTxtContrasea().getPassword()).equals("Contraseña"))));
		((_01_Login) misVistas[1]).btnLogin.setEnabled(camposRellenos);
	}

	public boolean recogerLogIn() {
		String contraseña = String.valueOf(((_01_Login) misVistas[1]).getTxtContrasea().getPassword());
		String usuario = ((_01_Login) misVistas[1]).getUsuario().getText();
		return miModelo.validarUsuario(usuario, contraseña);
	}

	public Object[][] guardarCodPostal() {
		String busqueda = ((_02_BuscarPorLocalidad) misVistas[2]).getTxtBuscador().getText();

		int filtro = Integer.parseInt(busqueda);

		Object[][] lista = new Object[2][2];

		lista = miModelo.busquedaCodPostal(filtro);

		return lista;

	}
	
	public Object[][] sacarHistorial() {

		Object[][] info = miModelo.sentenciaHistorial();
		
		return info;

	}
	
	public boolean comprobarAdmin() {
		boolean admin = false;
		
		String usuario = ((_01_Login) misVistas[1]).getUsuario().getText();

		return miModelo.validarAdmin(usuario);
	}
	
	public Object[][] sacarLugaresActuales(){
		
		Object[][] datos = miModelo.sacarLugaresBase();
		
		return datos;
		
	}

	public void recogerInfoBajaAltaLugaresParaInsert() {
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();
		String comunidad = ((_17_DarDeBajaLugar) misVistas[17]).getTxtComunidad().getText();
		String provincia = ((_17_DarDeBajaLugar) misVistas[17]).getTxtProvincia().getText();
		String poblacion = ((_17_DarDeBajaLugar) misVistas[17]).getTxtPoblacion().getText();
		
		int codPostal = Integer.parseInt(codigoPostal);
		
		miModelo.conectorInsertLugar(codPostal,comunidad,provincia,poblacion);
	}

	public void recogerInfoBajaAltaLugaresParaDelete() {
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();
		String comunidad = ((_17_DarDeBajaLugar) misVistas[17]).getTxtComunidad().getText();
		String provincia = ((_17_DarDeBajaLugar) misVistas[17]).getTxtProvincia().getText();
		String poblacion = ((_17_DarDeBajaLugar) misVistas[17]).getTxtPoblacion().getText();
		
		int codPostal = Integer.parseInt(codigoPostal);		
		
		miModelo.conectorDeleteLugar(codPostal, comunidad, provincia, poblacion);
	}
	
	public void recogerInfoBajaAltaLugaresParaUpdate() {
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();
		String comunidad = ((_17_DarDeBajaLugar) misVistas[17]).getTxtComunidad().getText();
		String provincia = ((_17_DarDeBajaLugar) misVistas[17]).getTxtProvincia().getText();
		String pobla = ((_17_DarDeBajaLugar) misVistas[17]).getTxtPoblacion().getText();
		
		int codPostal = Integer.parseInt(codigoPostal);		
		int poblacion = Integer.parseInt(pobla);
		int codPostalAntiguo = ((_17_DarDeBajaLugar) misVistas[17]).getCodPostalAntiguo();
		
		miModelo.conectorUpdateLugar(codPostal, comunidad, provincia, poblacion, codPostalAntiguo);
	}

}