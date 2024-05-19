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
	private JTextField txtRespuestaPreguntaSeguridad;
	private JTextField txtCódigo;
	private JPasswordField txtContraseñaComprobar;
	private JTextField txtCodigoPostal;

	public JTextField getUsuario() {
		return txtUsuario;
	}

	public JCheckBox getAdmin() {
		return chckbxAdministrador;
	}

	public JComboBox getPreguntaSeguridad() {
		return comboBoxPreguntaSeguridad;
	}

	public JTextField getTxtRespuestaPreguntaSeguridad() {
		return txtRespuestaPreguntaSeguridad;
	}

	public JTextField getTxtCódigo() {
		return txtCódigo;
	}

	public JPasswordField geTtxtContraseñaComprobar() {
		return txtContraseñaComprobar;
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
		setBounds(100, 100, 453, 465);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(65, 27, 311, 376);
		contentPane.add(panel);
		panel.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 
			}
		});
		txtUsuario.setBounds(20, 116, 107, 29);
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

		JPasswordField txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContraseña.setBounds(20, 164, 107, 29);
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

		JButton btnVueltaLogin = new JButton("Volver");
		btnVueltaLogin.setBounds(46, 343, 103, 23);
		panel.add(btnVueltaLogin);
		btnVueltaLogin.setForeground(new Color(255, 255, 255));
		btnVueltaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(4, 1);
			}
		});
		btnVueltaLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin.setBackground(new Color(70, 70, 70));
			}
		});

		btnVueltaLogin.setBorder(null);
		btnVueltaLogin.setBackground(new Color(0, 0, 0));

		JButton btnRegistro = new JButton("Register");
//		btnRegistro.setEnabled(false);
		btnRegistro.setBounds(159, 343, 108, 23);
		panel.add(btnRegistro);
		btnRegistro.setForeground(new Color(255, 255, 255));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					miControlador.recogerInfo();
					
					miControlador.cambiarVentana(4, 1);
					
				}catch(NumberFormatException a) {
					//mensaje de fallo en una de las casillas
				}/*catch(CasillaVaciaException b) {
					//Creo una excepcion que se lanze cuando deje algo sin rellenar
				}catch(UsuarioExistenteException c) {
					//Creo una excepcion que se lanze cuando en la base de datos
					//ya exista ese usuario
				}*/

			}
		});
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(70, 70, 70));
			}
		});
		btnRegistro.setBackground(new Color(0, 0, 0));

		btnRegistro.setBorder(null);

		chckbxAdministrador = new JCheckBox("¿Administrador?");
		chckbxAdministrador.setBounds(192, 280, 103, 23);
		panel.add(chckbxAdministrador);
		chckbxAdministrador.setBackground(new Color(255, 255, 255));
		chckbxAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNewLabel = new JLabel("Pregunta Seguridad *");
		lblNewLabel.setBounds(174, 107, 103, 14);
		panel.add(lblNewLabel);

		comboBoxPreguntaSeguridad = new JComboBox();
		comboBoxPreguntaSeguridad.setBounds(174, 122, 111, 21);
		panel.add(comboBoxPreguntaSeguridad);

		txtRespuestaPreguntaSeguridad = new JTextField();
		txtRespuestaPreguntaSeguridad.setText("Respuesta");
		txtRespuestaPreguntaSeguridad.setBounds(174, 169, 103, 20);
		panel.add(txtRespuestaPreguntaSeguridad);
		txtRespuestaPreguntaSeguridad.setColumns(10);

		txtCódigo = new JTextField();
		txtCódigo.setText("Código");
		txtCódigo.setBounds(231, 303, 55, 20);
		panel.add(txtCódigo);
		txtCódigo.setColumns(10);

		JLabel lblTitulo = new JLabel("REGÍSTRESE");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblTitulo.setBounds(46, 26, 218, 57);
		panel.add(lblTitulo);

		txtContraseñaComprobar = new JPasswordField();
		txtContraseñaComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContraseñaComprobar.setText("C. Contraseña");
		txtContraseñaComprobar.setForeground(Color.GRAY);
		focusListener = new PlaceholderFocusListener(txtContraseñaComprobar, "C. Contraseña");
		txtContraseñaComprobar.setEchoChar(' ');
		txtContraseñaComprobar.setBorder(null);
		txtContraseñaComprobar.setBackground(Color.LIGHT_GRAY);
		txtContraseñaComprobar.setBounds(20, 213, 107, 29);
		txtContraseñaComprobar.addFocusListener(focusListener);
		txtContraseñaComprobar.addFocusListener(new PlaceholderFocusListener(txtContraseñaComprobar, "C. Contraseña"));
		txtContraseñaComprobar.setBorder(BorderFactory.createCompoundBorder(txtContraseñaComprobar.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtContraseñaComprobar);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setText("Código Postal");
		txtCodigoPostal.setForeground(Color.GRAY);
		txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBorder(null);
		txtCodigoPostal.setBackground(Color.LIGHT_GRAY);
		txtCodigoPostal.setBounds(20, 264, 107, 29);
		focusListener = new PlaceholderFocusListener(txtCodigoPostal, "C. Contraseña");
		txtCodigoPostal.addFocusListener(focusListener);
		txtCodigoPostal.addFocusListener(new PlaceholderFocusListener(txtCodigoPostal, "Código Postal"));
		txtCodigoPostal.setBorder(BorderFactory.createCompoundBorder(txtCodigoPostal.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		panel.add(txtCodigoPostal);

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocus();
			}
		});

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin.setBackground(new Color(0, 0, 0));
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
				btnRegistro.setBackground(new Color(0, 0, 0));
				btnVueltaLogin.setBackground(new Color(0, 0, 0));
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
