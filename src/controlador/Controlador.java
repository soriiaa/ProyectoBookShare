/**
 * @author pablo
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.JTextField;

import modelo.Modelo;
import vista.Vista;
import vista._04_Registro;

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
		
		if(administrador.equals(null)) {
			administrador = "Usuario";
		}
		
		if(codigoAdmin.equals("Código")) {
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
}