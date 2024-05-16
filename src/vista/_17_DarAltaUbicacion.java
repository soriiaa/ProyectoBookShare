/**
 * @author Andres
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _17_DarAltaUbicacion extends JFrame implements Vista {
	private static final long serialVersionUID = 1L;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTextField textIntroducirDireccion;
	private JLabel lblTituloPantalla;
	private JLabel lblIndicacionDireccion;
	private JLabel lblEjemplo;
	private JButton btnDarDeAlta;
	private JLabel lblDireccion;
	private JComboBox comboBox;
	private JLabel lblIndicacionUbicacion;
	private JLabel lblUbicacion;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnAltaLugar;
	private JButton btnAltaLibro;
	private JButton btnBajaLugar;
	private JButton btnBajaLibro;
	private JButton btnEnviarMensaje;
	private JButton btnMiperfil;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _17_DarAltaUbicacion() {
		setResizable(false);
		setTitle("BookShare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
		panelMenuNavegacion.setBounds(0, 0, 195, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setForeground(new Color(0, 0, 0));
		panelTituloMenu.setBackground(new Color(0, 0, 0));
		panelTituloMenu.setBounds(0, 0, 198, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setForeground(new Color(255, 255, 255));
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 194, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnAltaLugar = new JButton("Dar de alta un Lugar");
		btnAltaLugar.setBorderPainted(false);
		btnAltaLugar.setBackground(new Color(230, 230, 250));
		btnAltaLugar.setForeground(new Color(0, 0, 128));
		btnAltaLugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaLugar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAltaLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 17);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnAltaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLugar.setBounds(0, 39, 198, 40);
		panelMenuNavegacion.add(btnAltaLugar);
		
		btnAltaLibro = new JButton("Dar de baja un Lugar");
		btnAltaLibro.setBorderPainted(false);
		btnAltaLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnAltaLibro.setBackground(new Color(230, 230, 250));
		btnAltaLibro.setForeground(new Color(0, 0, 128));	
		btnAltaLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 19);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.setBounds(0, 79, 209, 40);
		panelMenuNavegacion.add(btnAltaLibro);
		
		btnBajaLugar = new JButton("Dar de alta un Libro");
		btnBajaLugar.setBorderPainted(false);
		btnBajaLugar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLugar.setBackground(new Color(230, 230, 250));
		btnBajaLugar.setForeground(new Color(0, 0, 128));
		btnBajaLugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBajaLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 16);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.setBounds(0, 119, 198, 40);
		panelMenuNavegacion.add(btnBajaLugar);
		
		btnBajaLibro = new JButton("Dar de baja un Libro");
		btnBajaLibro.setBorderPainted(false);
		btnBajaLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLibro.setBackground(new Color(230, 230, 250));
		btnBajaLibro.setForeground(new Color(0, 0, 128));
		btnBajaLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBajaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 18);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.setBounds(0, 159, 198, 40);
		panelMenuNavegacion.add(btnBajaLibro);
		
		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.setBorderPainted(false);
		btnEnviarMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		btnEnviarMensaje.setBackground(new Color(230, 230, 250));
		btnEnviarMensaje.setForeground(new Color(0, 0, 128));
		btnEnviarMensaje.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 15);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color(230, 230, 250));
			}
		});
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color(230, 230, 250));
			}
		});
		btnEnviarMensaje.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnEnviarMensaje);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		btnMiperfil.setBounds(0, 621, 195, 42);
		contentPane.add(btnMiperfil);

		lblTituloPantalla = new JLabel("Alta Lugares");
		lblTituloPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPantalla.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTituloPantalla.setBounds(433, 22, 298, 36);
		contentPane.add(lblTituloPantalla);

		lblEjemplo = new JLabel("Ej: Calle/Avenida/Rotonda nombre de la via, N.º Portal");
		lblEjemplo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEjemplo.setBounds(350, 176, 532, 36);
		contentPane.add(lblEjemplo);

		lblIndicacionDireccion = new JLabel(
				"Por favor, introduzca la dirrección que desea activar y registrar en el sistema:\r\n");
		lblIndicacionDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIndicacionDireccion.setBounds(228, 123, 728, 36);
		contentPane.add(lblIndicacionDireccion);

		btnDarDeAlta = new JButton("Dar de Alta\r\n");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDarDeAlta.setBackground(new Color(0, 255, 128));
		btnDarDeAlta.setBounds(833, 564, 143, 39);
		contentPane.add(btnDarDeAlta);

		textIntroducirDireccion = new JTextField();
		textIntroducirDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textIntroducirDireccion.setColumns(10);
		textIntroducirDireccion.setBounds(453, 234, 429, 39);
		contentPane.add(textIntroducirDireccion);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(350, 235, 89, 39);
		contentPane.add(lblDireccion);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Ningun estado seleccionado", "Ubicación Privado", "Ubicación Público" }));
		comboBox.setBounds(453, 389, 429, 36);
		contentPane.add(comboBox);

		lblIndicacionUbicacion = new JLabel("Por favor, indique si la dirección es un lugar público o privado:\r\n");
		lblIndicacionUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicacionUbicacion.setBounds(350, 343, 532, 36);
		contentPane.add(lblIndicacionUbicacion);

		lblUbicacion = new JLabel("Ubicación:");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUbicacion.setBounds(350, 389, 89, 39);
		contentPane.add(lblUbicacion);
	}

}
