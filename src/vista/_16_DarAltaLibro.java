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

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _16_DarAltaLibro extends JFrame implements Vista {
	private static final long serialVersionUID = 1L;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblIntroducirDatos;
	private JLabel lblTituloLibro;
	private JLabel lblAutor;
	private JLabel lblFechaPublicacion;
	private JLabel lblNumeroPaginas;
	private JLabel lblGenero;
	private JButton btnDarDeAlta;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtFechaPublicacion;
	private JTextField txtNumeroPaginas;
	private JTextField txtGenero;
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

	public _16_DarAltaLibro() {
		setResizable(false);
		setTitle("BookShare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
				miControlador.cambiarVentana(16, 17);
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
				miControlador.cambiarVentana(16, 19);
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
				miControlador.cambiarVentana(16, 16);
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
				miControlador.cambiarVentana(16, 18);
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
				miControlador.cambiarVentana(16, 15);
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
				miControlador.cambiarVentana(16, 12);
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

		lblTitulo = new JLabel("Alta Libros");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(394, 37, 298, 36);
		contentPane.add(lblTitulo);

		lblIntroducirDatos = new JLabel("Por favor, introduzca los datos de los libros que desee registrar: \r\n");
		lblIntroducirDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIntroducirDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroducirDatos.setBounds(267, 136, 600, 36);
		contentPane.add(lblIntroducirDatos);

		lblTituloLibro = new JLabel("Titulo del Libro:");
		lblTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloLibro.setBounds(277, 243, 130, 36);
		contentPane.add(lblTituloLibro);

		lblAutor = new JLabel("Autor del Libro:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(277, 288, 130, 36);
		contentPane.add(lblAutor);

		lblFechaPublicacion = new JLabel("Fecha de Publicación:");
		lblFechaPublicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaPublicacion.setBounds(277, 336, 154, 36);
		contentPane.add(lblFechaPublicacion);

		lblNumeroPaginas = new JLabel("Número de Páginas:");
		lblNumeroPaginas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroPaginas.setBounds(277, 383, 154, 36);
		contentPane.add(lblNumeroPaginas);

		lblGenero = new JLabel("Género Literario:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(277, 433, 130, 36);
		contentPane.add(lblGenero);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTitulo.setBounds(431, 243, 436, 39);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(431, 287, 436, 39);
		contentPane.add(txtAutor);

		txtFechaPublicacion = new JTextField();
		txtFechaPublicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFechaPublicacion.setColumns(10);
		txtFechaPublicacion.setBounds(431, 334, 436, 39);
		contentPane.add(txtFechaPublicacion);

		txtNumeroPaginas = new JTextField();
		txtNumeroPaginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumeroPaginas.setColumns(10);
		txtNumeroPaginas.setBounds(431, 380, 436, 39);
		contentPane.add(txtNumeroPaginas);

		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGenero.setColumns(10);
		txtGenero.setBounds(431, 430, 436, 39);
		contentPane.add(txtGenero);

		btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.setBackground(new Color(128, 255, 128));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDarDeAlta.setBounds(822, 602, 154, 39);
		contentPane.add(btnDarDeAlta);
	}
}
