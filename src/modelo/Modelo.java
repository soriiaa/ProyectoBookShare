package modelo;

/**
 * @author Andrés
 */

import controlador.Controlador;
import vista.Vista;

public class Modelo {
	
	private Vista[] misVistas;
	private Controlador miControlador;
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setVista (Vista[] misVistas) {
		this.misVistas = misVistas;
	}

}
