/**
 * @author Alejandro
 */
package vista;

/*
 * Pedro, hemos hecho todas las pruebas en portatil y lo hemos puesto un momento en una pantalla más grande, una de sobremesa y hay
 * cosas que no se ven bien.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import controlador.Controlador;
import modelo.Modelo;

public class _00_PantallaInicio extends JFrame implements Vista {
	private JLabel lblTitulo;
	private JProgressBar progressBar;
	private JLabel lblImagen;

	private Controlador miControlador;
	private Modelo miModelo;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _00_PantallaInicio() {

		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 918, 604);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblTitulo = new JLabel("BookShare 2.0");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblTitulo.setBounds(272, 19, 360, 107);
		getContentPane().add(lblTitulo);
		setLocationRelativeTo(null);

		progressBar = new JProgressBar();
		progressBar.setToolTipText("");
		progressBar.setBackground(new Color(230, 230, 230));
		progressBar.setForeground(new Color(255, 255, 255));
		progressBar.setBounds(228, 501, 448, 28);

		getContentPane().add(progressBar);

		lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(_00_PantallaInicio.class.getResource("/assets/BookShareImagen.png")));
		lblImagen.setBounds(228, 147, 448, 311);
		getContentPane().add(lblImagen);

	}
}
