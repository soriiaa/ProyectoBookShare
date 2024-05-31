/**
 * @author Andres
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
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.Controlador;
import modelo.Modelo;

public class _12_MiPerfil extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtApellidos;
	private JTextField txtContrasea;
	private JButton btnCambiarFotoUsuario;
	private JList listOpcionesMenuNavegacion;
	private JLabel lblMenuNavegacion;
	private JScrollPane scrollPane;
	private JLabel lblTituloMiPerfil;
	private JButton btnCambiarApellidos;
	private JButton btnCambiarNombre;
	private JButton btnCambiarContrasena;
	private JButton btnAplicarCambios;
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
	private JLabel lblImage;
	private JFileChooser fileChooser;
	private File selectedFile;
	private JLabel lblImagenPerfil;
	private JLabel lblFotoDisplay;
	private JLabel lblUsuarioDisplay;
	private JLabel lblNombreDisplay;
	private JLabel lblApellidoDisplay;
	private JLabel lblTituloVista;
	private JPanel panelResaltarNombre;
	private String nickName;
	private String nombre;
	private String apellido;
	private FocusListener focusListener;

	private boolean botonNicknameHabilitado;
	private boolean botonUsuarioHabilitado;
	private boolean botonApellidoHabilitado;
	private boolean botonContrasenaHabilitado;

	public String getNickName() {
		return nickName;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getTxtContrasea() {
		return txtContrasea;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void chooseFile() {
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	// @Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _12_MiPerfil() {
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
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
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
				btnCogerLibro.setBackground(new Color(220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				comprobarCampoUsuario();
				comprobarCampoApellido();
				comprobarCampoContraseña();

				btnCogerLibro.setBackground(new Color(230, 230, 250));
				btnAplicarCambios.setBackground(new Color(0, 0, 0));

				if (botonUsuarioHabilitado) {
					btnCambiarNombre.setBackground(new Color(0, 0, 0));
					btnCambiarNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

				if (botonApellidoHabilitado) {
					btnCambiarApellidos.setBackground(new Color(0, 0, 0));
					btnCambiarApellidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

				if (botonContrasenaHabilitado) {
					btnCambiarContrasena.setBackground(new Color(0, 0, 0));
					btnCambiarContrasena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

				btnCambiarFotoUsuario.setBackground(new Color(0, 0, 0));
				btnAplicarCambios.setBackground(new Color(0, 0, 0));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTituloVista.requestFocus();
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
				btnDejarUnLibro.setBackground(new Color(220, 220, 220));
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
				btnDarDeAlta.setBackground(new Color(220, 220, 220));
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
				btnFaq.setBackground(new Color(220, 220, 220));
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
				btnHistorialLibros.setBackground(new Color(220, 220, 220));
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
				btnBandejaDeEntrada.setBackground(new Color(220, 220, 220));
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
		btnMiperfil.setBounds(0, 621, 183, 42);
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
				btnMiperfil.setBackground(new Color(220, 220, 220));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		contentPane.add(btnMiperfil);

		// BOTON DE USUARIO

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(299, 313, 230, 27);
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampoUsuario();
			}
		});
		txtNombreUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampoUsuario();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampoUsuario();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampoUsuario();
			}
		});
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtNombreUsuario, "Usuario");
		txtNombreUsuario.addFocusListener(focusListener);
		txtNombreUsuario.setText("Usuario");
		txtNombreUsuario.addFocusListener(new PlaceholderFocusListener(txtNombreUsuario, "Usuario"));
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setForeground(Color.GRAY);
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setBorder(BorderFactory.createCompoundBorder(txtNombreUsuario.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtNombreUsuario.setColumns(10);

		txtNombreUsuario.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Usuario".equals(txtNombreUsuario.getText())) {
					txtNombreUsuario.setForeground(Color.GRAY);
				} else {
					txtNombreUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtNombreUsuario.getText().isEmpty()) {
					txtNombreUsuario.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		contentPane.add(txtNombreUsuario);

		// BOTON DE APELLIDO

		txtApellidos = new JTextField();
		txtApellidos.setBounds(299, 387, 230, 29);
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampoApellido();
			}
		});
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampoApellido();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampoApellido();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampoApellido();
			}
		});
		contentPane.add(txtApellidos);
		txtApellidos.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtApellidos, "Apellido");
		txtApellidos.addFocusListener(focusListener);
		txtApellidos.setText("Apellido");
		txtApellidos.addFocusListener(new PlaceholderFocusListener(txtApellidos, "Apellido"));
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setForeground(Color.GRAY);
		txtApellidos.setBorder(null);
		txtApellidos.setBorder(BorderFactory.createCompoundBorder(txtApellidos.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtApellidos.setColumns(10);

		txtApellidos.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Usuario".equals(txtApellidos.getText())) {
					txtApellidos.setForeground(Color.GRAY);
				} else {
					txtApellidos.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		contentPane.add(txtApellidos);

		// BOTON DE CONTRASEÑA

		txtContrasea = new JTextField();
		txtContrasea.setBounds(299, 465, 230, 27);
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCampoContraseña();
			}
		});
		txtContrasea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampoContraseña();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampoContraseña();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampoContraseña();
			}
		});
		contentPane.add(txtContrasea);
		txtContrasea.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtContrasea, "Contraseña");
		txtContrasea.addFocusListener(focusListener);
		txtContrasea.setText("Contraseña");
		txtContrasea.addFocusListener(new PlaceholderFocusListener(txtContrasea, "Contraseña"));
		txtContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasea.setForeground(Color.GRAY);
		txtContrasea.setBorder(null);
		txtContrasea.setBorder(BorderFactory.createCompoundBorder(txtContrasea.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtContrasea.setColumns(10);

		txtContrasea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Usuario".equals(txtContrasea.getText())) {
					txtContrasea.setForeground(Color.GRAY);
				} else {
					txtContrasea.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtContrasea.getText().isEmpty()) {
					txtContrasea.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		contentPane.add(txtContrasea);

		btnCambiarFotoUsuario = new JButton("Cambiar Foto de Usuario");
		btnCambiarFotoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarFotoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCambiarFotoUsuario.setBackground(new Color(70, 70, 70));
				btnCambiarFotoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnCambiarFotoUsuario.setBounds(299, 217, 230, 50);
		btnCambiarFotoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.recogerImagen();

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
					lblImagenPerfil.setIcon(imageIcon);
				}
			}
		});
		contentPane.add(btnCambiarFotoUsuario);
		btnCambiarFotoUsuario.setForeground(new Color(255, 255, 255));
		btnCambiarFotoUsuario.setBackground(new Color(0, 0, 0));
		btnCambiarFotoUsuario.setBorder(null);

		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (botonUsuarioHabilitado) {
					btnCambiarNombre.setBackground(new Color(70, 70, 70));
					btnCambiarNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		btnCambiarNombre.setBounds(299, 338, 230, 29);
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarNombre();
//				txtNicknameUsuario.setEditable(true);
				nombre = getTxtNombreUsuario().getText();
				txtNombreUsuario.setText("Nombre");
			}
		});
		contentPane.add(btnCambiarNombre);
		btnCambiarNombre.setForeground(new Color(255, 255, 255));
		btnCambiarNombre.setBackground(new Color(0, 0, 0));
		btnCambiarNombre.setBorder(null);

		btnCambiarApellidos = new JButton("Cambiar Apellidos");
		btnCambiarApellidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (botonApellidoHabilitado) {
					btnCambiarApellidos.setBackground(new Color(70, 70, 70));
					btnCambiarApellidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		btnCambiarApellidos.setBounds(299, 416, 230, 27);
		btnCambiarApellidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarApellido();
//				txtNicknameUsuario.setEditable(true);
				apellido = getTxtApellidos().getText();
				txtApellidos.setText("Apellido");
			}
		});
		contentPane.add(btnCambiarApellidos);
		btnCambiarApellidos.setForeground(new Color(255, 255, 255));
		btnCambiarApellidos.setBackground(new Color(0, 0, 0));
		btnCambiarApellidos.setBorder(null);

		btnCambiarContrasena = new JButton("Cambiar Contraseña");
		btnCambiarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (botonContrasenaHabilitado) {
					btnCambiarContrasena.setBackground(new Color(70, 70, 70));
					btnCambiarContrasena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		btnCambiarContrasena.setBounds(299, 490, 230, 27);
		contentPane.add(btnCambiarContrasena);
		btnCambiarContrasena.setForeground(new Color(255, 255, 255));
		btnCambiarContrasena.setBackground(new Color(0, 0, 0));
		btnCambiarContrasena.setBorder(null);

		btnAplicarCambios = new JButton("Aplicar Cambios");
		btnAplicarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAplicarCambios.setBackground(new Color(70, 70, 70));
				btnAplicarCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnAplicarCambios.setBounds(778, 597, 162, 44);
		btnAplicarCambios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAplicarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombreUsuario.setEditable(false);
				txtApellidos.setEditable(false);
				miControlador.mostrarImagen();
				if(getNickName() != null) {
					lblUsuarioDisplay.setText(getNickName());
				}
				if(getNombre() != null) {
					lblNombreDisplay.setText(getNombre());
				}
				if(getApellido() != null) {
					lblApellidoDisplay.setText(getApellido());
					
				}
			}
		});
		btnAplicarCambios.setBackground(new Color(0, 255, 128));
		contentPane.add(btnAplicarCambios);
		btnAplicarCambios.setForeground(new Color(255, 255, 255));
		btnAplicarCambios.setBackground(new Color(0, 0, 0));
		btnAplicarCambios.setBorder(null);

		lblImagenPerfil = new JLabel("");
		lblImagenPerfil.setBounds(346, 124, 131, 83);
		lblImagenPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImagenPerfil);

		JPanel panel = new JPanel();
		panel.setBounds(634, 109, 306, 460);
		panel.setBackground(new Color(175, 175, 239));
		contentPane.add(panel);
		panel.setLayout(null);

		lblFotoDisplay = new JLabel("Foto Display");
		lblFotoDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoDisplay.setBounds(76, 62, 162, 142);
		panel.add(lblFotoDisplay);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				miControlador.mostrarImagen();
			}
		});

		JLabel lblImagenPerfil_1 = new JLabel("");
		lblImagenPerfil_1.setBounds(180, 12, 0, 0);
		panel.add(lblImagenPerfil_1);

		lblTituloVista = new JLabel("Configurar Perfil");
		lblTituloVista.setBounds(182, 22, 804, 69);
		lblTituloVista.setFont(new Font("Tahoma", Font.PLAIN, 58));
		lblTituloVista.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTituloVista);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblUsuarioDisplay = new JLabel(miControlador.sacarUsuario());
				lblUsuarioDisplay.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuarioDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblUsuarioDisplay.setBounds(35, 202, 239, 50);
				panel.add(lblUsuarioDisplay);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblNombreDisplay = new JLabel(miControlador.sacarNombre());
				lblNombreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
				lblNombreDisplay.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNombreDisplay.setBounds(76, 297, 162, 32);
				panel.add(lblNombreDisplay);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblApellidoDisplay = new JLabel(miControlador.sacarApellido());
				lblApellidoDisplay.setHorizontalAlignment(SwingConstants.CENTER);
				lblApellidoDisplay.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblApellidoDisplay.setBounds(76, 340, 162, 32);
				panel.add(lblApellidoDisplay);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				miControlador.mostrarImagen();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				comprobarCampoUsuario();
				comprobarCampoApellido();
				comprobarCampoContraseña();
			}
		});

	}

	public void setImagenPerfil(byte[] imgBytes) {

		if (imgBytes != null) {
			ImageIcon imageIcon = new ImageIcon(imgBytes);
			lblImagenPerfil.setIcon(imageIcon);
			lblFotoDisplay.setIcon(imageIcon);
		} else {
			System.out.println("No hay imagen");
		}

		contentPane.revalidate();
		contentPane.repaint();
	}


	public void comprobarCampoUsuario() {

		botonUsuarioHabilitado = true;

		if (txtNombreUsuario.getText().isEmpty() || txtNombreUsuario.getText().equals("Usuario")) {
			botonUsuarioHabilitado = false;
		} else {
			botonUsuarioHabilitado = true;
		}

		if (botonUsuarioHabilitado == true) {
			btnCambiarNombre.setEnabled(true);
			btnCambiarNombre.setBackground(new Color(0, 0, 0));
		} else {
			btnCambiarNombre.setEnabled(false);
			btnCambiarNombre.setBackground(new Color(114, 114, 114));
		}
	}

	public void comprobarCampoApellido() {

		botonApellidoHabilitado = true;

		if (txtApellidos.getText().isEmpty() || txtApellidos.getText().equals("Apellido")) {
			botonApellidoHabilitado = false;
		} else {
			botonApellidoHabilitado = true;
		}

		if (botonApellidoHabilitado == true) {
			btnCambiarApellidos.setEnabled(true);
			btnCambiarApellidos.setBackground(new Color(0, 0, 0));
		} else {
			btnCambiarApellidos.setEnabled(false);
			btnCambiarApellidos.setBackground(new Color(114, 114, 114));
		}
	}

	public void comprobarCampoContraseña() {

		botonContrasenaHabilitado = true;

		if (txtContrasea.getText().isEmpty() || txtContrasea.getText().equals("Contraseña")) {
			botonContrasenaHabilitado = false;
		} else {
			botonContrasenaHabilitado = true;
		}

		if (botonContrasenaHabilitado == true) {
			btnCambiarContrasena.setEnabled(true);
			btnCambiarContrasena.setBackground(new Color(0, 0, 0));
		} else {
			btnCambiarContrasena.setEnabled(false);
			btnCambiarContrasena.setBackground(new Color(114, 114, 114));
		}
	}

	public class PlaceholderFocusListener implements FocusListener {
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
