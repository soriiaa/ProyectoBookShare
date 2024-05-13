/**
 * @author Alejandro
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

		Timer timer = new Timer(20, new ActionListener() {
			int progress = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				progress++;
				progressBar.setValue(progress);
				if (progress >= 100) {
					((Timer) e.getSource()).stop();
					miControlador.cambiarVentana(0, 3);
				}
			}
		});

		timer.start();
	}
}
