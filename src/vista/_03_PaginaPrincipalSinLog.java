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
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Modelo;

public class _03_PaginaPrincipalSinLog extends JFrame implements Vista {

	private JLabel lblImagen;
	private JButton btnIniciarSesion;
	private JButton btnBuscarPorLocalidad;
	private JPanel panel;
	private JButton btnVolverLanzadera;

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

	public _03_PaginaPrincipalSinLog() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		getContentPane().setBackground(new Color(20, 154, 235));
		setBounds(100, 100, 908, 716);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 193, 607);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 193, 42);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblMenuNavegacion = new JLabel("Menú Navegación");
		lblMenuNavegacion.setBounds(33, 11, 126, 20);
		panel.add(lblMenuNavegacion);
		lblMenuNavegacion.setBackground(new Color(192, 192, 192));
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnBuscarPorLocalidad = new JButton("Buscar Por Localidad");
		btnBuscarPorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarPorLocalidad.setBackground(new Color(255, 255, 255));
		btnBuscarPorLocalidad.setBounds(0, 41, 193, 35);
		panel_1.add(btnBuscarPorLocalidad);

		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnIniciarSesion.setBounds(10, 627, 193, 42);
		getContentPane().add(btnIniciarSesion);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(3, 20);
			}
		});
		btnVolverLanzadera.setBounds(713, 10, 171, 21);
		getContentPane().add(btnVolverLanzadera);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(_03_PaginaPrincipalSinLog.class.getResource("/assets/BookShareImagen.png")));
		lblImagen.setBounds(213, 10, 671, 659);
		getContentPane().add(lblImagen);

	}

}