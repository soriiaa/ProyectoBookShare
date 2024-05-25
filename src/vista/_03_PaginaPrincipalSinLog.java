/**
 * @author Alejandro
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _03_PaginaPrincipalSinLog extends JFrame implements Vista {

	private JLabel lblImagen;
	private JButton btnIniciarSesion;
	private JButton btnBuscarPorLocalidad;
	private JPanel panel;

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnBuscarPorLocalidad2;
	private JLabel lblImagenPrincipio;
	private JButton btnConfiguracion;

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
		
		
		
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfiguracion.setBackground(new Color(230, 230, 255));
				btnBuscarPorLocalidad2.setBackground(new Color(230, 230, 255));
				btnIniciarSesion.setBackground(new Color(230, 230, 255));
			}
		});
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setForeground(new Color(0, 0, 0));
		panelTituloMenu.setBackground(new Color(0, 0, 0));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setForeground(new Color(255, 255, 255));
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnBuscarPorLocalidad2 = new JButton("Buscar por Localidad");
		btnBuscarPorLocalidad2.setBorderPainted(false);
		btnBuscarPorLocalidad2.setBackground(new Color(230, 230, 250));
		btnBuscarPorLocalidad2.setForeground(new Color(0, 0, 128));
		btnBuscarPorLocalidad2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarPorLocalidad2.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorLocalidad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 2);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnBuscarPorLocalidad2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad2.setBackground(new Color (220, 220, 220));
				btnBuscarPorLocalidad2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad2.setBackground(new Color(230, 230, 250));
			}
		});
		btnBuscarPorLocalidad2.setBounds(0, 39, 205, 40);
		panelMenuNavegacion.add(btnBuscarPorLocalidad2);
		
		btnConfiguracion = new JButton("");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.activarConexion();
			}
		});
		btnConfiguracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfiguracion.setBackground(new Color(200, 200, 255));
				btnConfiguracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(3, 18);
			}
		});
		btnConfiguracion.setBounds(140, 579, 33, 33);
		panelMenuNavegacion.add(btnConfiguracion);
		btnConfiguracion.setIcon(new ImageIcon(_01_Login.class.getResource("/Assets/config.png")));
		btnConfiguracion.setBorder(null);
		btnConfiguracion.setBackground(new Color(230, 230, 255));
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(new Color(230, 230, 250));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.RIGHT);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 1);
			}
		});
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color (220, 220, 220));
				btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(230, 230, 250));
			}
		});
		btnIniciarSesion.setBounds(0, 621, 183, 42);
		contentPane.add(btnIniciarSesion);
		
		lblImagenPrincipio = new JLabel("New label");
		lblImagenPrincipio.setIcon(new ImageIcon(_06_PantallaPrincipal.class.getResource("/Assets/BookShare_Presentacion.jpg")));
		lblImagenPrincipio.setBounds(185, 0, 801, 663);
		contentPane.add(lblImagenPrincipio);
		
		/*
		
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

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(_03_PaginaPrincipalSinLog.class.getResource("/assets/BookShareImagen.png")));
		lblImagen.setBounds(213, 10, 671, 659);
		getContentPane().add(lblImagen);
		
		*/

	}

}