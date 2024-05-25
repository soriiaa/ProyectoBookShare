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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _12_MiPerfil extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNicknameUsuario;
	private JTextField txtFotoUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtApellidos;
	private JTextField txtContrasea;
	private JTextField txtDiagrama;
	private JTextField txtEstadistcas;
	private JButton btnCambiarFotoUsuario;
	private JTextField txtPreguntasSeguridad;
	private JList listOpcionesMenuNavegacion;
	private JLabel lblMenuNavegacion;
	private JScrollPane scrollPane;
	private JLabel lblTituloMiPerfil;
	private JButton btnCambiarNickName;
	private JButton btnCambiarApellidos;
	private JButton btnCambiarNombre;
	private JButton btnCambiarConrasea;
	private JButton btnCambiarPreguntas;
	private JButton btnAplicarCambios;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnBandejaDeEntrada;
	private JButton btnMiperfil;

	private Controlador miControlador;
	private Modelo miModelo;
	private JPasswordField PasswordContraseña;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _12_MiPerfil() {
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
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(230, 230, 250));
		btnCogerLibro.setForeground(new Color(0, 0, 128));
		btnCogerLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 8);
			}
		});
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setBorderPainted(false);
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(230, 230, 250));
		btnDejarUnLibro.setForeground(new Color(0, 0, 128));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDejarUnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 9);
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(230, 230, 250));
		btnDarDeAlta.setForeground(new Color(0, 0, 128));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 7);
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.setBounds(0, 119, 195, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setBorderPainted(false);
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(230, 230, 250));
		btnFaq.setForeground(new Color(0, 0, 128));
		btnFaq.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 11);
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setBorderPainted(false);
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(230, 230, 250));
		btnHistorialLibros.setForeground(new Color(0, 0, 128));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHistorialLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 10);
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color (220, 220, 220));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
		
		btnBandejaDeEntrada = new JButton("Bandeja de Entrada");
		btnBandejaDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		btnBandejaDeEntrada.setForeground(new Color(0, 0, 128));
		btnBandejaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBandejaDeEntrada.setBorderPainted(false);
		btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));		
		btnBandejaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 13);
			}
		});
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.setBounds(0, 237, 198, 40);
		panelMenuNavegacion.add(btnBandejaDeEntrada);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color (220, 220, 220));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);

		txtNicknameUsuario = new JTextField();
		txtNicknameUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNicknameUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNicknameUsuario.setEditable(false);
		txtNicknameUsuario.setText("NickName de Usuario");
		txtNicknameUsuario.setBounds(299, 253, 230, 29);
		contentPane.add(txtNicknameUsuario);
		txtNicknameUsuario.setColumns(10);

		txtFotoUsuario = new JTextField();
		txtFotoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtFotoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtFotoUsuario.setText("Foto de Usuario");
		txtFotoUsuario.setEditable(false);
		txtFotoUsuario.setColumns(10);
		txtFotoUsuario.setBounds(299, 11, 230, 126);
		contentPane.add(txtFotoUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setText("Nombre del Usuario");
		txtNombreUsuario.setEditable(false);
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(299, 319, 230, 29);
		contentPane.add(txtNombreUsuario);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtApellidos.setText("Apellidos del Usuario\r\n");
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(299, 386, 230, 29);
		contentPane.add(txtApellidos);

		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtContrasea.setText("Contraseña");
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.setEditable(false);
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(299, 451, 230, 27);
		contentPane.add(txtContrasea);

		txtDiagrama = new JTextField();
		txtDiagrama.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiagrama.setText("Diagrama ");
		txtDiagrama.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiagrama.setEditable(false);
		txtDiagrama.setColumns(10);
		txtDiagrama.setBounds(695, 11, 201, 126);
		contentPane.add(txtDiagrama);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "- Ninguno seleccionando ", "- Género Aventura  ", "- Género Fantasía ",
						"- Género Ficción ", "- Género Misterio  ", "- Género Suspense ", "- Género Terror   " }));
		comboBox.setBounds(695, 280, 201, 29);
		contentPane.add(comboBox);

		txtEstadistcas = new JTextField();
		txtEstadistcas.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEstadistcas.setText("Estadísticas");
		txtEstadistcas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadistcas.setEditable(false);
		txtEstadistcas.setColumns(10);
		txtEstadistcas.setBounds(695, 252, 201, 29);
		contentPane.add(txtEstadistcas);

		btnCambiarFotoUsuario = new JButton("Cambiar Foto de Usuario");
		btnCambiarFotoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFotoUsuario.setEditable(true);
			}
		});
		btnCambiarFotoUsuario.setBounds(299, 135, 230, 50);
		contentPane.add(btnCambiarFotoUsuario);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "Digrama de Barras (Predeterminado)", "Diagrama Circular" }));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_1.setBounds(695, 135, 201, 50);
		contentPane.add(comboBox_1);

		btnCambiarNickName = new JButton("Cambiar NickName ");
		btnCambiarNickName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNicknameUsuario.setEditable(true);
			}
		});
		btnCambiarNickName.setBounds(299, 280, 230, 29);
		contentPane.add(btnCambiarNickName);

		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombreUsuario.setEditable(true);
			}
		});
		btnCambiarNombre.setBounds(299, 347, 230, 29);
		contentPane.add(btnCambiarNombre);

		btnCambiarApellidos = new JButton("Cambiar Apellidos");
		btnCambiarApellidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtApellidos.setEditable(true);
			}
		});
		btnCambiarApellidos.setBounds(299, 414, 230, 27);
		contentPane.add(btnCambiarApellidos);

		btnCambiarConrasea = new JButton("Cambiar Contraseña");
		btnCambiarConrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordContraseña.setEditable(true);
			}
		});
		btnCambiarConrasea.setBounds(299, 504, 230, 27);
		contentPane.add(btnCambiarConrasea);

		txtPreguntasSeguridad = new JTextField();
		txtPreguntasSeguridad.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPreguntasSeguridad.setText("Pregunta de Seguridad ");
		txtPreguntasSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreguntasSeguridad.setEditable(false);
		txtPreguntasSeguridad.setColumns(10);
		txtPreguntasSeguridad.setBounds(299, 541, 230, 27);
		contentPane.add(txtPreguntasSeguridad);

		btnCambiarPreguntas = new JButton("Cambiar Preguntas de Seguridad");
		btnCambiarPreguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPreguntasSeguridad.setEditable(true);
			}
		});
		btnCambiarPreguntas.setBounds(299, 568, 230, 27);
		contentPane.add(btnCambiarPreguntas);

		btnAplicarCambios = new JButton("Aplicar Cambios");
		btnAplicarCambios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAplicarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFotoUsuario.setEditable(false);
				txtNicknameUsuario.setEditable(false);
				txtNombreUsuario.setEditable(false);
				txtApellidos.setEditable(false);
				PasswordContraseña.setEditable(false);
				txtPreguntasSeguridad.setEditable(false);
			}
		});
		btnAplicarCambios.setBackground(new Color(0, 255, 128));
		btnAplicarCambios.setBounds(758, 593, 201, 44);
		contentPane.add(btnAplicarCambios);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Pregunta de Seguridad 1", "Pregunta de Seguridad 2", "Pregunta de Seguridad 3"}));
		comboBox_2.setBounds(299, 593, 230, 29);
		contentPane.add(comboBox_2);
		
		PasswordContraseña = new JPasswordField();
		PasswordContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordContraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
		PasswordContraseña.setBounds(299, 477, 230, 29);
		contentPane.add(PasswordContraseña);
		PasswordContraseña.setText("Predeterminado");
		PasswordContraseña.setEditable(false);
	}
}
