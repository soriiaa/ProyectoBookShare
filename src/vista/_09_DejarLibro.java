/**
 * @author Alejandro
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _09_DejarLibro extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTextField txtBuscador;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblTexto1;
	private JLabel lblFechaEnLa;
	private JLabel lblCdigoPostalEn;
	private JLabel lblEscribeUnaValoracin;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnMiperfil;
	private JButton btnDejar;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _09_DejarLibro() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(255, 255, 255));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setBackground(new Color(128, 128, 192));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(255, 250, 250));
		btnCogerLibro.setForeground(new Color(204, 204, 51));
		btnCogerLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 8);
			}
		});
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setBorderPainted(false);
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(255, 250, 250));
		btnDejarUnLibro.setForeground(new Color(204, 204, 51));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDejarUnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 9);
			}
		});
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(255, 250, 250));
		btnDarDeAlta.setForeground(new Color(204, 204, 51));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 7);
			}
		});
		btnDarDeAlta.setBounds(0, 119, 183, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setBorderPainted(false);
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(255, 250, 250));
		btnFaq.setForeground(new Color(204, 204, 51));
		btnFaq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 11);
			}
		});
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setBorderPainted(false);
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(255, 250, 250));
		btnHistorialLibros.setForeground(new Color(204, 204, 51));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistorialLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 10);
			}
		});
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBackground(new Color(128, 128, 192));
		btnMiperfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 12);
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);

		JLabel lblCogerUnLibro = new JLabel("Dejar un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(436, 26, 284, 66);
		getContentPane().add(lblCogerUnLibro);

		txtBuscador = new JTextField();
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(643, 153, 228, 30);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(702, 264, 169, 30);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(548, 209, 323, 30);
		getContentPane().add(textField_1);

		btnDejar = new JButton("Dejar");
		btnDejar.setBackground(new Color(128, 255, 128));
		btnDejar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDejar.setBounds(845, 622, 117, 42);
		getContentPane().add(btnDejar);

		lblTexto1 = new JLabel("Introduce el nombre del libro a dejar:");
		lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTexto1.setBounds(332, 143, 315, 42);
		getContentPane().add(lblTexto1);

		lblFechaEnLa = new JLabel("Fecha en la que se cogió:");
		lblFechaEnLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaEnLa.setBounds(332, 208, 216, 24);
		getContentPane().add(lblFechaEnLa);

		lblCdigoPostalEn = new JLabel("Código Postal en el que se va a dejar el libro:");
		lblCdigoPostalEn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoPostalEn.setBounds(332, 263, 371, 24);
		getContentPane().add(lblCdigoPostalEn);

		lblEscribeUnaValoracin = new JLabel("Escribe una valoración sobre el libro:");
		lblEscribeUnaValoracin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEscribeUnaValoracin.setBounds(332, 322, 295, 24);
		getContentPane().add(lblEscribeUnaValoracin);

		JTextField txtPuntuacion = new JTextField();
		txtPuntuacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPuntuacion.setText("");
			}
		});
		txtPuntuacion.setForeground(new Color(145, 145, 145));
		txtPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPuntuacion.setText("X/5");
		txtPuntuacion.setToolTipText("");
		txtPuntuacion.setColumns(10);
		txtPuntuacion.setBounds(637, 321, 42, 30);
		getContentPane().add(txtPuntuacion);

		JTextArea textComentario = new JTextArea();
		textComentario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textComentario.setText("");
			}
		});
		textComentario.setForeground(new Color(145, 145, 145));
		textComentario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textComentario.setText("Comentario...");
		textComentario.setBounds(332, 376, 540, 152);
		getContentPane().add(textComentario);
	}
}
