/**
 * @author Alejandro
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class _09_DejarLibro extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;
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
	private JButton btnDejar;
	private JButton btnBandejaDeEntrada;
	private JTextField txtTitulo;
	private JTextField txtFechaCogidaLibro;
	private JTextField txtCodigoPostal;
	private JTextField txtComentario;
	private boolean botonHabilitado;

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
		botonHabilitado = true;
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
		panelMenuNavegacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampos();
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
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(230, 230, 250));
		btnCogerLibro.setForeground(new Color(0, 0, 128));
		btnCogerLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 8);
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
				btnDejar.setBackground(new Color(0, 0, 0));
				comprobarCampos();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTituloMenu.requestFocus();
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
				miControlador.cambiarVentana(9, 9);
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
				miControlador.cambiarVentana(9, 7);
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
				miControlador.cambiarVentana(9, 11);
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
				miControlador.cambiarVentana(9, 10);
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
		contentPane.addMouseListener(new MouseAdapter() {
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
				miControlador.cambiarVentana(9, 13);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
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
				miControlador.cambiarVentana(9, 12);
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

		JLabel lblCogerUnLibro = new JLabel("Dejar un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(435, 39, 284, 66);
		getContentPane().add(lblCogerUnLibro);

		btnDejar = new JButton("Dejar");
		btnDejar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clic2");
			}
		});
		btnDejar.setEnabled(false);
		btnDejar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejar.setBackground(new Color(70, 70, 70));
				btnDejar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				comprobarCampos();
			}
		});
		btnDejar.setForeground(new Color(255, 255, 255));
		btnDejar.setBorder(null);
		btnDejar.setBackground(new Color(144, 144, 144));
		btnDejar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDejar.setBounds(859, 611, 117, 42);
		getContentPane().add(btnDejar);
		
		txtTitulo = new JTextField();
		txtTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampos();
			}
		});
		txtTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});

		txtTitulo.setBounds(381, 162, 387, 29);
		contentPane.add(txtTitulo);
		txtTitulo.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtTitulo, "Título");
		txtTitulo.addFocusListener(focusListener);
		txtTitulo.setText("Título");
		txtTitulo.addFocusListener(new PlaceholderFocusListener(txtTitulo, "Título"));
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTitulo.setForeground(Color.GRAY);
		txtTitulo.setBorder(null);
		txtTitulo.setBorder(BorderFactory.createCompoundBorder(txtTitulo.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtTitulo.setColumns(10);

		txtTitulo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Título".equals(txtTitulo.getText())) {
					txtTitulo.setForeground(Color.GRAY);
				} else {
					txtTitulo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtTitulo.getText().isEmpty()) {
					txtTitulo.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		contentPane.add(txtTitulo);
		
		txtFechaCogidaLibro = new JTextField();
		txtFechaCogidaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampos();
			}
		});
		txtFechaCogidaLibro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtFechaCogidaLibro.setText("Fecha adquisición libro");
		txtFechaCogidaLibro.setForeground(Color.GRAY);
		txtFechaCogidaLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaCogidaLibro.setColumns(10);
		txtFechaCogidaLibro.setBorder(null);
		txtFechaCogidaLibro.setBackground(Color.LIGHT_GRAY);
		txtFechaCogidaLibro.setBounds(381, 218, 387, 29);
		focusListener = new PlaceholderFocusListener(txtFechaCogidaLibro, "Fecha adquisición libro");
		txtFechaCogidaLibro.addFocusListener(focusListener);
		txtFechaCogidaLibro.addFocusListener(new PlaceholderFocusListener(txtFechaCogidaLibro, "Fecha adquisición libro"));
		txtFechaCogidaLibro.setBorder(BorderFactory.createCompoundBorder(txtFechaCogidaLibro.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtFechaCogidaLibro);

		txtFechaCogidaLibro.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Fecha adquisición libro".equals(txtFechaCogidaLibro.getText())) {
					txtFechaCogidaLibro.setForeground(Color.GRAY);
				} else {
					txtFechaCogidaLibro.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtFechaCogidaLibro.getText().isEmpty()) {
					txtFechaCogidaLibro.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampos();
			}
		});
		txtCodigoPostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtCodigoPostal.setText("Código Postal");
		txtCodigoPostal.setForeground(Color.GRAY);
		txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBorder(null);
		txtCodigoPostal.setBackground(Color.LIGHT_GRAY);
		txtCodigoPostal.setBounds(381, 274, 387, 29);
		focusListener = new PlaceholderFocusListener(txtCodigoPostal, "Código Postal");
		txtCodigoPostal.addFocusListener(focusListener);
		txtCodigoPostal.addFocusListener(new PlaceholderFocusListener(txtCodigoPostal, "Código Postal"));
		txtCodigoPostal.setBorder(BorderFactory.createCompoundBorder(txtCodigoPostal.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtCodigoPostal);

		txtCodigoPostal.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Código Postal".equals(txtCodigoPostal.getText())) {
					txtCodigoPostal.setForeground(Color.GRAY);
				} else {
					txtCodigoPostal.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		
		
		
		txtComentario = new JTextField();
		txtComentario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampos();
			}
		});
		txtComentario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtComentario.setText("Comentario");
		txtComentario.setForeground(Color.GRAY);
		txtComentario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComentario.setColumns(10);
		txtComentario.setBorder(null);
		txtComentario.setBackground(Color.LIGHT_GRAY);
		txtComentario.setBounds(381, 330, 387, 137);
		focusListener = new PlaceholderFocusListener(txtComentario, "Comentario");
		txtComentario.addFocusListener(focusListener);
		txtComentario.addFocusListener(new PlaceholderFocusListener(txtComentario, "Comentario"));
		txtComentario.setBorder(BorderFactory.createCompoundBorder(txtComentario.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtComentario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBorder(null);
		comboBox.setBounds(508, 496, 59, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Puntuación (1-5):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(381, 494, 117, 21);
		contentPane.add(lblNewLabel);

		txtComentario.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Comentario".equals(txtComentario.getText())) {
					txtComentario.setForeground(Color.GRAY);
				} else {
					txtComentario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtComentario.getText().isEmpty()) {
					txtComentario.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblCogerUnLibro.requestFocus();
				comprobarCampos();
			}
		});
		
	}
	
	public void comprobarCampos() {
		
		if ((txtTitulo.getText().isEmpty() || txtTitulo.getText().equals("Título")) || (txtFechaCogidaLibro.getText().isEmpty() || txtFechaCogidaLibro.getText().equals("Fecha adquisición libro")) || (txtCodigoPostal.getText().isEmpty() || txtCodigoPostal.getText().equals("Código Postal")) || (txtComentario.getText().isEmpty() || txtComentario.getText().equals("Comentario"))) {
			botonHabilitado = false;
		} else {
			btnDejar.setBackground(new Color(0, 0, 0));
			btnDejar.setEnabled(true);
		}
		
		if (botonHabilitado == false) {
			btnDejar.setBackground(new Color(144, 144, 144));
			btnDejar.setEnabled(false);
		} 
		
	}
	
	private static class PlaceholderFocusListener implements FocusListener {
		private final JTextField field;
		private final String placeholder;

		public PlaceholderFocusListener(JTextField field, String placeholder) {
			this.field = field;
			this.placeholder = placeholder;
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (field.getText().equals(placeholder)) {
				field.setText("");
				if (field instanceof JPasswordField) {
					((JPasswordField) field).setEchoChar('*'); // Para ocultar los caracteres al escribir
				}
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (field.getText().isEmpty()) {
				field.setText(placeholder);
				if (field instanceof JPasswordField) {
					((JPasswordField) field).setEchoChar((char) 0); // Para que el texto sea visible
				}
			}
		}
	}
}
