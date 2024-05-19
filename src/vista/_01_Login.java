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

public class _01_Login extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JLabel lblNoTieneCuenta;
	public JButton btnLogin;

	private Controlador miControlador;
	private Modelo miModelo;
	private FocusListener focusListener;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private int contador = 1;
	private JLabel lblIntentosRestantes;

	public JTextField getUsuario() {
		return txtUsuario;
	}

	public JPasswordField getTxtContrasea() {
		return txtContraseña;
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _01_Login() {
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		JPanel contentPane = new JPanel();
		setLocationRelativeTo(null);

		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(96, 10, 244, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(77, 217, 89, 23);
		panel.add(btnLogin);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBorder(null);
		btnLogin.setEnabled(false);

		lblNoTieneCuenta = new JLabel("¿No tiene cuenta? Registrese");
		lblNoTieneCuenta.setBounds(38, 283, 167, 16);
		panel.add(lblNoTieneCuenta);
		lblNoTieneCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clic en '¿No tiene cuenta? Registrese'");
				miControlador.cambiarVentana(1, 4);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Entrado en el area del registro");
				lblNoTieneCuenta.setForeground(Color.BLACK);
				lblNoTieneCuenta.setText("<html><u>¿No tiene cuenta? Registrese</u></html>");
			}
		});
		lblNoTieneCuenta.setForeground(Color.BLUE);
		lblNoTieneCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblTitulo = new JLabel("BIENVENIDO");
		lblTitulo.setBounds(17, 23, 209, 61);
		panel.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 35));

		JLabel lblOlvidoContraseña = new JLabel("Olvidé la contraseña");
		lblOlvidoContraseña.setBounds(62, 259, 120, 14);
		panel.add(lblOlvidoContraseña);
		lblOlvidoContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clic en 'Olvidaste tu contraseña'");
				miControlador.cambiarVentana(1, 5);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Entrado en el area del olvido de contraseña");
				lblOlvidoContraseña.setForeground(Color.BLACK);
				lblOlvidoContraseña.setText("<html><u>Olvidé la contraseña</u></html>");
			}
		});
		lblOlvidoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOlvidoContraseña.setForeground(new Color(0, 0, 255));
		lblOlvidoContraseña.setFocusable(true);

		txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.comprobarCamposLogin();
			}
		});
		txtContraseña.setBounds(25, 163, 193, 29);
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

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.comprobarCamposLogin();
			}
		});
		txtUsuario.setBounds(25, 112, 193, 29);
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

		lblIntentosRestantes = new JLabel("");
		lblIntentosRestantes.setForeground(new Color(255, 0, 0));
		lblIntentosRestantes.setVisible(true);
		lblIntentosRestantes.setBounds(70, 203, 135, 14);
		panel.add(lblIntentosRestantes);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!miControlador.recogerLogIn() && contador < 3) {
					contador++;
					lblIntentosRestantes.setText("Te quedan " + (4 - contador) + " intentos");
					miControlador.cambiarVentana(1, 1);
				} else if (contador == 3) {
					System.exit(0);
				}
				miControlador.cambiarVentana(1, 6);
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(70, 70, 70));
			}
		});

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOlvidoContraseña.setForeground(new Color(0, 0, 255));
				lblOlvidoContraseña.setText("Olvidé la contraseña");
				lblNoTieneCuenta.setForeground(new Color(0, 0, 255));
				lblNoTieneCuenta.setText("¿No tiene cuenta? Registrese");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocusInWindow();
			}
		});

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 0, 0));
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnLogin.requestFocusInWindow();
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocusInWindow();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 0, 0));
				lblOlvidoContraseña.setForeground(new Color(0, 0, 255));
				lblOlvidoContraseña.setText("Olvidé la contraseña");
				lblNoTieneCuenta.setForeground(new Color(0, 0, 255));
				lblNoTieneCuenta.setText("¿No tiene cuenta? Registrese");
			}
		});

		btnLogin.requestFocusInWindow();

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
