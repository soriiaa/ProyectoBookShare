/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.Controlador;
import modelo.Modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class _04_Registro extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JButton btnRegistro;
	private JButton btnVueltaLogin;
	private FocusListener focusListener;

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtUsuario;
	private JCheckBox chckbxAdministrador;
	private JComboBox comboBoxPreguntaSeguridad;
	private JPasswordField txtContraseñaComprobar;
	private JTextField txtCodigoPostal;
	private JTextField txtRespuesta;
	private JTextField txtCódigo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JLabel lblTitulo;
	private JPasswordField txtContraseña;
	public JButton btnRegistro_1;
	private JButton btnVueltaLogin_1;

	public JTextField getNombre() {
		return txtNombre;
	}

	public JTextField getApellido() {
		return txtApellidos;
	}

	public JTextField getUsuario() {
		return txtUsuario;
	}

	public JCheckBox getAdmin() {
		return chckbxAdministrador;
	}

	public JComboBox<String> getPreguntaSeguridad() {
		return comboBoxPreguntaSeguridad;
	}

	public JTextField getTxtRespuestaPreguntaSeguridad() {
		return txtRespuesta;
	}

	public JTextField getTxtCódigo() {
		return txtCódigo;
	}

	public JPasswordField geTtxtContraseñaComprobar() {
		return txtContraseñaComprobar;
	}
	
	public JPasswordField getTxtContraseña() {
		return txtContraseña;
	}

	public JTextField getTxtCodigoPostal() {
		return txtCodigoPostal;
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _04_Registro() {
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 538);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(65, 27, 311, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnRegistro_1 = new JButton("Registrar");
		btnRegistro_1.setBounds(159, 408, 108, 23);
		panel.add(btnRegistro_1);
		btnRegistro_1.setForeground(new Color(255, 255, 255));
		btnRegistro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.recogerInfo();
				miControlador.cambiarVentana(4, 1);
			}
		});
		btnRegistro_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro_1.setBackground(new Color(70, 70, 70));
			}
		});
		btnRegistro_1.setBackground(new Color(0, 0, 0));
		btnRegistro_1.setBorder(null);
		btnRegistro_1.setEnabled(false);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtUsuario.setBounds(20, 116, 117, 29);
		panel.add(txtUsuario);
		txtUsuario.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtUsuario, "Usuario");
		txtUsuario.addFocusListener(focusListener);
		txtUsuario.setText("Usuario");
		txtUsuario.addFocusListener(new PlaceholderFocusListener(txtUsuario, "Usuario"));
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setForeground(Color.GRAY);
		txtUsuario.setBorder(null);
		txtUsuario.setBorder(BorderFactory.createCompoundBorder(txtUsuario.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtUsuario.setColumns(10);

		txtUsuario.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Usuario".equals(txtUsuario.getText())) {
					txtUsuario.setForeground(Color.GRAY);
				} else {
					txtUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtUsuario.getText().isEmpty()) {
					txtUsuario.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContraseña.setBounds(20, 164, 117, 29);
		panel.add(txtContraseña);
		txtContraseña.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtContraseña, "Contraseña");
		txtContraseña.setText("Contraseña");
		txtContraseña.setEchoChar((char) 0);
		txtContraseña.addFocusListener(focusListener);
		txtContraseña.addFocusListener(new PlaceholderFocusListener(txtContraseña, "Contraseña"));
		txtContraseña.setForeground(Color.GRAY);
		txtContraseña.setBorder(null);
		txtContraseña.setBorder(BorderFactory.createCompoundBorder(txtContraseña.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));

		txtContraseña.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Contraseña".equals(txtContraseña.getText())) {
					txtContraseña.setForeground(Color.GRAY);
				} else {
					txtContraseña.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtContraseña.getText().isEmpty()) {
					txtContraseña.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		btnVueltaLogin_1 = new JButton("Volver");
		btnVueltaLogin_1.setBounds(46, 408, 103, 23);
		panel.add(btnVueltaLogin_1);
		btnVueltaLogin_1.setForeground(new Color(255, 255, 255));
		btnVueltaLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(4, 1);
			}
		});
		btnVueltaLogin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin_1.setBackground(new Color(70, 70, 70));
			}
		});

		btnVueltaLogin_1.setBorder(null);
		btnVueltaLogin_1.setBackground(new Color(0, 0, 0));

		chckbxAdministrador = new JCheckBox("¿Administrador?");
		chckbxAdministrador.setBounds(170, 218, 103, 23);
		panel.add(chckbxAdministrador);
		chckbxAdministrador.setBackground(new Color(255, 255, 255));
		chckbxAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxAdministrador.setBorder(null);
		chckbxAdministrador.setOpaque(false);

		chckbxAdministrador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Checkbox seleccionado
					txtCódigo.setVisible(true);
					txtCódigo.requestFocus();
					lblTitulo.requestFocus();

				} else {
					// Checkbox deseleccionado
					txtCódigo.setVisible(false);
					txtCódigo.setText("");
				}
			}
		});

		String[] opciones = { "¿Como se llama tu perro?", "¿Cual es tu comida favorita?",
				"¿Cual es tu superheroe favorito?" };

		comboBoxPreguntaSeguridad = new JComboBox<>(opciones);
		comboBoxPreguntaSeguridad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		comboBoxPreguntaSeguridad.insertItemAt("Seleccione la Pregunta de Seguridad", 0);
		comboBoxPreguntaSeguridad.setSelectedIndex(0);
		comboBoxPreguntaSeguridad.setBounds(20, 315, 267, 29);
		comboBoxPreguntaSeguridad.setBorder(null);

		comboBoxPreguntaSeguridad.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxPreguntaSeguridad.getSelectedIndex() == 0) {
					comboBoxPreguntaSeguridad.setForeground(Color.GRAY);
					comboBoxPreguntaSeguridad.setSelectedIndex(1);
				}
			}
		});

		panel.add(comboBoxPreguntaSeguridad);
		getContentPane().add(panel);

		lblTitulo = new JLabel("REGÍSTRESE");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblTitulo.setBounds(31, 26, 248, 80);
		panel.add(lblTitulo);

		txtContraseñaComprobar = new JPasswordField();
		txtContraseñaComprobar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtContraseñaComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContraseñaComprobar.setText("C. Contraseña");
		txtContraseñaComprobar.setForeground(Color.GRAY);
		focusListener = new PlaceholderFocusListener(txtContraseñaComprobar, "C. Contraseña");
		txtContraseñaComprobar.setEchoChar(' ');
		txtContraseñaComprobar.setBorder(null);
		txtContraseñaComprobar.setBackground(Color.LIGHT_GRAY);
		txtContraseñaComprobar.setBounds(20, 213, 117, 29);
		txtContraseñaComprobar.addFocusListener(focusListener);
		txtContraseñaComprobar.addFocusListener(new PlaceholderFocusListener(txtContraseñaComprobar, "C. Contraseña"));
		txtContraseñaComprobar.setBorder(BorderFactory.createCompoundBorder(txtContraseñaComprobar.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtContraseñaComprobar);

		txtContraseñaComprobar.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("C. Contraseña".equals(txtContraseñaComprobar.getText())) {
					txtContraseñaComprobar.setForeground(Color.GRAY);
				} else {
					txtContraseñaComprobar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtContraseñaComprobar.getText().isEmpty()) {
					txtContraseñaComprobar.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtCodigoPostal.setText("Código Postal");
		txtCodigoPostal.setForeground(Color.GRAY);
		txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBorder(null);
		txtCodigoPostal.setBackground(Color.LIGHT_GRAY);
		txtCodigoPostal.setBounds(20, 264, 117, 29);
		focusListener = new PlaceholderFocusListener(txtCodigoPostal, "Código Postal");
		txtCodigoPostal.addFocusListener(focusListener);
		txtCodigoPostal.addFocusListener(new PlaceholderFocusListener(txtCodigoPostal, "Código Postal"));
		txtCodigoPostal.setBorder(BorderFactory.createCompoundBorder(txtCodigoPostal.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtCodigoPostal);

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

		txtRespuesta = new JTextField();
		txtRespuesta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtRespuesta.setText("Respuesta");
		txtRespuesta.setForeground(Color.GRAY);
		txtRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRespuesta.setColumns(10);
		txtRespuesta.setBorder(null);
		txtRespuesta.setBackground(Color.LIGHT_GRAY);
		txtRespuesta.setBounds(20, 354, 267, 29);
		focusListener = new PlaceholderFocusListener(txtRespuesta, "Respuesta");
		txtRespuesta.addFocusListener(focusListener);
		txtRespuesta.addFocusListener(new PlaceholderFocusListener(txtRespuesta, "Respuesta"));
		txtRespuesta.setBorder(BorderFactory.createCompoundBorder(txtRespuesta.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtRespuesta);

		txtRespuesta.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Respuesta".equals(txtRespuesta.getText())) {
					txtRespuesta.setForeground(Color.GRAY);
				} else {
					txtRespuesta.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtRespuesta.getText().isEmpty()) {
					txtRespuesta.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		txtCódigo = new JTextField();
		txtCódigo.setText("Código");
		txtCódigo.setForeground(Color.GRAY);
		txtCódigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCódigo.setColumns(10);
		txtCódigo.setBorder(null);
		txtCódigo.setBackground(Color.LIGHT_GRAY);
		txtCódigo.setBounds(170, 264, 117, 29);
		focusListener = new PlaceholderFocusListener(txtCódigo, "Código");
		txtCódigo.addFocusListener(focusListener);
		txtCódigo.addFocusListener(new PlaceholderFocusListener(txtCódigo, "Código"));
		txtCódigo.setBorder(BorderFactory.createCompoundBorder(txtCódigo.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtCódigo);
		txtCódigo.setVisible(false);

		txtCódigo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Código".equals(txtCódigo.getText())) {
					txtCódigo.setForeground(Color.GRAY);
				} else {
					txtCódigo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtCódigo.getText().isEmpty()) {
					txtCódigo.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.GRAY);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setBounds(170, 116, 117, 29);
		focusListener = new PlaceholderFocusListener(txtNombre, "Nombre");
		txtNombre.addFocusListener(focusListener);
		txtNombre.addFocusListener(new PlaceholderFocusListener(txtNombre, "Nombre"));
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtNombre);

		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Nombre".equals(txtNombre.getText())) {
					txtNombre.setForeground(Color.GRAY);
				} else {
					txtNombre.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtNombre.getText().isEmpty()) {
					txtNombre.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(Color.GRAY);
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(null);
		txtApellidos.setBackground(Color.LIGHT_GRAY);
		txtApellidos.setBounds(170, 164, 117, 29);
		focusListener = new PlaceholderFocusListener(txtApellidos, "Apellidos");
		txtApellidos.addFocusListener(focusListener);
		txtApellidos.addFocusListener(new PlaceholderFocusListener(txtApellidos, "Apellidos"));
		txtApellidos.setBorder(BorderFactory.createCompoundBorder(txtApellidos.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtApellidos);

		txtApellidos.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Apellidos".equals(txtApellidos.getText())) {
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

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocus();
			}
		});

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin_1.setBackground(new Color(0, 0, 0));
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblTitulo.requestFocus();
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocus();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro_1.setBackground(new Color(0, 0, 0));
				btnVueltaLogin_1.setBackground(new Color(0, 0, 0));
			}
		});
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
