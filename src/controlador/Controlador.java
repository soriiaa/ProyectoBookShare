/**
 * @author pablo
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._01_Login;
import vista._02_BuscarPorLocalidad;
import vista._03_PaginaPrincipalSinLog;
import vista._04_Registro;
import vista._07_AltaLibro;
import vista._09_DejarLibro;
import vista._12_MiPerfil;
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

	/**
	 * @author Apa
	 * Método que recoge las variables de las textbox de la vista del registro
	 * @return
	 * @throws NumberFormatException Por si introduce letras en codPostal
	 */
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

		//Convierto a int, los getText
		int codAdmin = Integer.parseInt(codigoAdmin);
		int codPostal = Integer.parseInt(codigoPostal);

		int numPregunta = miModelo.sacarPregunta(pregunta);

		//Método para meter los datos en la base de datos del nuevo usuario
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

	/**
	 * @author Apa
	 * @return Booleano que determina si el usuario y contraseña figuran en la bbdd
	 */
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
	
	/**
	 * @author Apa
	 * @return Array de objetos para mostrar por tablas
	 */
	public Object[][] sacarHistorial() {
		
		//Creo una matriz de objetos con lo que devuelve el método del modelo
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

	/**
	 * @author pablo
	 * @return Array de objetos para poder mostrar los libros que hay en la base
	 */
	public Object[][] sacarDatosLibro() {
		// Creo un array bidimensional de objetos con lo que devuelve el metodo de modelo 
		Object[][] datos = miModelo.sacarDatosLibro();
		return datos;
	}

	/**
	 * @author pablo
	 */
	public void recogerAltaDatosAltaBajaLibro() {
		// Almaceno en variables el valor de los getter de la vista 16 para el titulo, autor y genero
		String titulo = ((_16_DarDeBajaLibro) misVistas[16]).getTxtTitulo().getText();
		String autor = ((_16_DarDeBajaLibro) misVistas[16]).getTxtAutor().getText();
		String genero = ((_16_DarDeBajaLibro) misVistas[16]).getTxtGenero().getText();
		miModelo.AltaDatosAltaBajaLibro(titulo, autor, genero);
	}

	public void recogerBajaDatosAltaBajaLibro() {
		String titulo = ((_16_DarDeBajaLibro) misVistas[16]).getTxtTitulo().getText();
		miModelo.BajaDatosAltaBajaLibro(titulo);
	}

	/**
	 * @author Apa
	 * @return true = es admin / False = no es admin
	 */
	public boolean comprobarAdmin() {

		String usuario = ((_01_Login) misVistas[1]).getUsuario().getText();

		return miModelo.validarAdmin(usuario);
	}

	public Object[][] sacarLugaresActuales() {

		Object[][] datos = miModelo.sacarLugaresBase();

		return datos;

	}
	
	public void recogerInfoBajaAltaLugaresParaInsert() {
		String nombre = ((_17_DarDeBajaLugar) misVistas[17]).getNombre().getText();
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();
		
		int codPostal = Integer.parseInt(codigoPostal);
		
		miModelo.conectorInsertLugar(nombre, codPostal);
	}

	public void recogerInfoBajaAltaLugaresParaDelete() {
		String nombre = ((_17_DarDeBajaLugar) misVistas[17]).getNombre().getText();
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();

		
		int codPostal = Integer.parseInt(codigoPostal);		
		
		miModelo.conectorDeleteLugar(nombre, codPostal);
	}

	public void recogerInfoBajaAltaLugaresParaUpdate() {
		String nombre = ((_17_DarDeBajaLugar) misVistas[17]).getNombre().getText();
		String codigoPostal = ((_17_DarDeBajaLugar) misVistas[17]).getTxtCodigoPostal().getText();

		int codPostal = Integer.parseInt(codigoPostal);		
		
		miModelo.conectorUpdateLugar(nombre, codPostal);
	}

	/**
	 * @author Apa
	 * @return devuelve array d String con la info de la conexion del fichero ini
	 */
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

	/**
	 * @author Apa
	 * @return true = conexion establecita / false = conexion null
	 */
	public boolean comproConexion() {
		return miModelo.devolverConexion();
	}
	
	/**
	 * @author Alejandro Soria
	 * @return
	 */
	public String cogerDatosAltaLibro() {
		
		// Creo un array de String en el que voy a guardar los datos de un libro
		String[] datosAltaLibro = new String[3];
		// Añado a sus respectivas posiciones el titulo el autor y el codigo postal
		datosAltaLibro[0] = ((_07_AltaLibro) misVistas[7]).getTitulo();
		datosAltaLibro[1] = ((_07_AltaLibro) misVistas[7]).getAutor();
		datosAltaLibro[2] = ((_07_AltaLibro) misVistas[7]).getCodigoPostal();
		
		// Creo un booleano inicializado a true
		boolean camposCorrectos = true;
		
		try {
			// Parseo un dato, si no funciona, salta la excepcion, la capturo y establezco el booleano a false
	        Integer.parseInt(datosAltaLibro[2]);
	    } catch (NumberFormatException e) {
	        camposCorrectos = false;
	    }
		
		int respuesta = 0; // 1 es que hay resultados y se ha insertado bien. 0 es que no hay ningún código postal.
		
		// Si el booleano es true
		if (camposCorrectos) {
			// Guardo en el int respuesta lo que devuelve el método darLibroAlta
			respuesta = miModelo.darLibroAlta(datosAltaLibro[0], datosAltaLibro[1], datosAltaLibro[2]);
		}
		
		if (respuesta == 0) {
			return "Error";
		} else if (respuesta == 1) {
			return "Libro dado de alta con éxito";
		} else {
			return "Error";
		}
		
	}

	/**
	 * @author Apa
	 * Método que saca los valores recogidos en la vista para jugar con ellos mas adelante
	 */
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
	
	/**
	 * @author Alejandro Soria
	 * @return
	 */
	public String[][] cogerPreguntaSeguridad() {
		
		// Guardo en un array bidimensional de Strings las preguntas de seguridad junto a su código
		// Llamo al método cogerPreguntasSeguridad de la clase Modelo.
		
		String[][] preguntasArray = miModelo.cogerPreguntasSeguridad();
		
		// Retorno el array de preguntas y códigos.
		return preguntasArray;
	}
	
	/**
	 * @author Alejandro Soria
	 * @param listaCodigoPreguntaSeguridad
	 * @param preguntaUsuario
	 * @param respuestaUsuarioIntroducida
	 * @param nuevaContrasenaIntroducida
	 * @param nombreUsuario
	 * @return retorna lo que ha pasado con el método (Si ha ido mal o bien)
	 */
	
	public String comprobarRespuestaSeguridad(String[][] listaCodigoPreguntaSeguridad, String preguntaUsuario, String respuestaUsuarioIntroducida, String nuevaContrasenaIntroducida, String nombreUsuario) {
		
		int codigoPregunta = 0;
		
		// Bucle for que añade a CodigoPregunta el codigo de la pregunta de seguridad que tiene el usuario
		for (int i = 0; i < listaCodigoPreguntaSeguridad.length; i++) {
			if (listaCodigoPreguntaSeguridad[i][1].equals(preguntaUsuario)) {
				codigoPregunta = Integer.parseInt(listaCodigoPreguntaSeguridad[i][0]);
			}
		}
		
		// Paso el código a un String
		String codigoPreguntaString = Integer.toString(codigoPregunta);
		
		// Consulta para coger la respuesta del usuario a la pregunta de seguridad
		String consulta = "SELECT respuestaPreguntaRecuperacion FROM users WHERE codigoPreguntaRecuperacion = ? AND usr = ?";
		
		// 0 -> No existe respuesta para la pregunta
		// 1 -> Todo correcto
		// 2 -> La respuesta es incorrecta.
		
		int situacion;
		
		// Desde aqui llamo al método de la clase modelo ComprobarValidezPreguntaSeguridad, en el cual veo si la respuesta introducida por el usuario es la misma
		// que la que figura en la base de datos al registrarse.
		
		// Puede devolver 3 opciones, 0 -> No existe respuesta para la pregunta, por lo que o el usuario ha introducido otra pregunta o se ha confundido con su nombre de usuario.
		// Tambien puede devolver 1, lo que significa que todo está bien
		// Y tambien 2, lo que significa que las respuestas no coinciden, por lo que no permite generar la nueva contraseña
		situacion = miModelo.comprobarValidezPreguntaSeguridad(consulta, codigoPreguntaString, nombreUsuario, respuestaUsuarioIntroducida);
		
		// Si es 0, retorno que no es la pregunta de seguridad.
		if (situacion == 0) {
			return "No es tu pregunta de seguridad.";
			// Si es 1
		} else if (situacion == 1) {
			
			// Creo la consulta de update de la contraseña
			String consultaUpdateContrasena = "UPDATE users SET pwd = ? WHERE usr = ?";
			
			// Envio al método updateContraseña la consulta con la nueva contraseña y el usuario al que se le va a actualizar la contraseña de su cuenta.
			miModelo.updateContrasena(consultaUpdateContrasena, nuevaContrasenaIntroducida, nombreUsuario);
			
			
			// Retorno que todo correcto
			return "Correcto";
		} else {
			// Si no es ninguna de esas dos opciones, retorno que la respuesta es incorrecta.
			return "Respuesta Incorrecta.";
		}
		
	}



	public void recogerImagen() {
		((_12_MiPerfil) misVistas[12]).chooseFile();
		File foto = ((_12_MiPerfil) misVistas[12]).getSelectedFile();

		if (foto != null) {
			try {
				miModelo.guardarImagen(foto);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void mostrarImagen() {
		byte[] imgBytes = miModelo.getImage();

		((_12_MiPerfil) misVistas[12]).setImagenPerfil(imgBytes);
		
	}

	public String sacarUsuario() {
		return miModelo.getUsuario();
	}

	public String sacarNombre() {
		return miModelo.getNombre();
	}

	public String sacarApellido() {
		return miModelo.getApellido();
	}

	public void cambiarNombre() {
		String nombre = ((_12_MiPerfil) misVistas[12]).getTxtNombreUsuario().getText();
		miModelo.updateNombre(nombre);
	}

	public void cambiarApellido() {
		String apellido = ((_12_MiPerfil) misVistas[12]).getTxtApellidos().getText();
		miModelo.updateApellido(apellido);		
	}

	public void cambiarContraseña() {
		String contraseña = ((_12_MiPerfil) misVistas[12]).getTxtContrasea().getText();
		miModelo.updateContraseña(contraseña);	
	}
	
}
