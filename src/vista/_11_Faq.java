/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _11_Faq extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnMiperfil;
	private JButton btnBandejaDeEntrada;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _11_Faq() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
				miControlador.cambiarVentana(11, 8);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
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
				miControlador.cambiarVentana(11, 9);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(11, 7);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(11, 11);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(11, 10);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(11, 13);
			}
		});
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(11, 12);
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

		JLabel lblNewLabel_1 = new JLabel("FAQ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(460, 36, 182, 39);
		contentPane.add(lblNewLabel_1);

		JTextArea txtrporQue = new JTextArea();
		txtrporQue.setBackground(new Color(192, 192, 192));
		txtrporQue.setText(
				"1. ¿Por que debería leer libros?\r\nLeer libros no solo amplía tus conocimientos y vocabulario, sino que\r\n también estimula tu imaginación, mejora tu comprensión del mundo\r\n y puede ser una fuente inagotable de entretenimiento y reflexión\r\n\r\n2. ¿Cómo puedo encontrar libros que me interesen?\r\nHay varias formas de encontrar libros que te gusten, como explorar \r\ngéneros que te interesen, buscar recomendaciones de amigos, revisar\r\nreseñas en linea, visitar librerías físicas o virtuales, o unirte a clubes\r\nde lectura.\r\n\r\n3. ¿Cuál es la mejor manera de comenzar a leer si no tengo el hábito?\r\nEmpieza por elegir libros que te interesen genuinamente y establece \r\nmetas realistas de lectura. Puedes comenzar con lecturas conrtas o \r\nfragmentos pequeños y aumentar gradualmente la cantidad de \r\ntiempo dedicado a la lectura\r\n\r\n4. ¿Debería leer en formato impreso o electrónico?\r\nLa elección entre libros impresos o electrónicos depende de tus \r\npreferencias personales. Algunas personas prefieren la sensación \r\ntáctil y la experiencia física de un libro impreso, mientras que otras \r\ndisfrutan de la comodidad y la portabilidad de los dispositivos electrónicos.");
		txtrporQue.setBounds(256, 139, 628, 415);
		contentPane.add(txtrporQue);
	}
}