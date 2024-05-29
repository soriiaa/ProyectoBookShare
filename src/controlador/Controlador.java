/**
 * @author pablo
 */
package controlador;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._01_Login;
import vista._02_BuscarPorLocalidad;
import vista._03_PaginaPrincipalSinLog;
import vista._04_Registro;
import vista._09_DejarLibro;
import vista._16_DarDeBajaLibro;
import vista._17_DarDeBajaLugar;
import vista._18_ConfiguracionConexion;

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
	
	public void setVista3Invisible() {
		_03_PaginaPrincipalSinLog pag = (_03_PaginaPrincipalSinLog) misVistas[3];
		pag.setVisible(false);
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

	public void recogerModificarDatosAltaBajaLibros() {
		String titulo = ((_16_DarDeBajaLibro) misVistas[16]).getTxtTitulo().getText();
		String autor = ((_16_DarDeBajaLibro) misVistas[16]).getTxtAutor().getText();
		String genero = ((_16_DarDeBajaLibro) misVistas[16]).getTxtGenero().getText();
		String tituloAntiguo = ((_16_DarDeBajaLibro) misVistas[16]).getTituloOriginal();
		miModelo.actualizarDatosBajaAltaLibro(titulo, autor, genero, tituloAntiguo);
	}

	public Object[][] sacarDatosLibro() {
		Object[][] datos = miModelo.sacarDatosLibro();
		return datos;		
	}

	public void recogerAltaDatosAltaBajaLibro() {
		String titulo = ((_16_DarDeBajaLibro) misVistas[16]).getTxtTitulo().getText();
		String autor = ((_16_DarDeBajaLibro) misVistas[16]).getTxtAutor().getText();
		String genero = ((_16_DarDeBajaLibro) misVistas[16]).getTxtGenero().getText();
		miModelo.AltaDatosAltaBajaLibro(titulo, autor, genero);
	}

	public void recogerBajaDatosAltaBajaLibro() {
		String titulo = ((_16_DarDeBajaLibro) misVistas[16]).getTxtTitulo().getText();
		miModelo.BajaDatosAltaBajaLibro(titulo);	
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

	public String[] recogerDatosConexion() {
		String[] datos = new String[3];
		datos = miModelo.recogerInfoConexion();
		return datos;
	}

	public void modificarDatosConfiguracion() {
		String url = ((_18_ConfiguracionConexion) misVistas[18]).getTxtUrl();
		String usuario = ((_18_ConfiguracionConexion) misVistas[18]).getTxtUsuario();
		String contrasena = ((_18_ConfiguracionConexion) misVistas[18]).getTxtContrasena();
		miModelo.modificarDatosConfiguracion(url, usuario, contrasena);
	}

	public void sacarDatosCogerLibro(String valorSeleccionado) {
		miModelo.cambiarEstadoCogerLibro(valorSeleccionado);
		
	}

	public boolean comproConexion() {
		return miModelo.devolverConexion();
	}

	public void recogerDatosDejarLibro() {
		String titulo = ((_09_DejarLibro) misVistas[9]).getTxtTitulo().getText();
		String fechaRecogida = ((_09_DejarLibro) misVistas[9]).getTxtFechaCogidaLibro().getText();
		String codigoPostal = ((_09_DejarLibro) misVistas[9]).getTxtCodigoPostal().getText();
		String comentario = ((_09_DejarLibro) misVistas[9]).getTxtComentario().getText();
		String valoracion = ((_09_DejarLibro) misVistas[9]).getComboValoracion().getToolTipText();
		
		
		miModelo.insertarDatosDejarLibro(titulo, fechaRecogida, codigoPostal, comentario, valoracion);
		miModelo.cambiarEstadoDejarLibro(titulo);
		miModelo.eliminarLibroTablaCoger(titulo);
	}

	public boolean recogerdatosComproExistencia() {
		String titulo = ((_09_DejarLibro) misVistas[9]).getTxtTitulo().getText();
		
		return miModelo.comprobarLibroBBDD(titulo);
	}

	public void cogerDatosHistorialDejar() {
		String titulo = ((_09_DejarLibro) misVistas[9]).getTxtTitulo().getText();
		String codigoPostalStr = ((_09_DejarLibro) misVistas[9]).getTxtCodigoPostal().getText();
		
		int codPostal = Integer.parseInt(codigoPostalStr);
		
		miModelo.actualizarHistorial(titulo, codPostal);
	}

	public void recogerDatosCogerLibro(String valorSeleccionado) {
		miModelo.eliminarDatosDejarLibro(valorSeleccionado);
		miModelo.actualizarHistorialCoger(valorSeleccionado);
	}

}