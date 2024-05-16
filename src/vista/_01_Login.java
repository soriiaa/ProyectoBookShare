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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _01_Login extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblNoTieneCuenta;
	private JPasswordField txtContraseña;

	private Controlador miControlador;
	private Modelo miModelo;
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(120, 44, 193, 29);
		txtUsuario.setBorder(null);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(1, 6);
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color (220, 220, 220));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(255, 255, 255));
			}
		});
		btnLogin.setBounds(168, 153, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblOlvidoContraseña = new JLabel("Olvidé la contraseña");
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
		lblOlvidoContraseña.setBounds(155, 187, 124, 14);
		lblOlvidoContraseña.setFocusable(true);
		contentPane.add(lblOlvidoContraseña);

		lblNoTieneCuenta = new JLabel("¿No tiene cuenta? Registrese");
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
		lblNoTieneCuenta.setBounds(130, 216, 175, 14);
		contentPane.add(lblNoTieneCuenta);

		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(120, 96, 193, 29);
		txtContraseña.setBorder(null);
		contentPane.add(txtContraseña);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(120, 82, 124, 14);
		contentPane.add(lblContraseña);

		JLabel lblUsuario = new JLabel("Nombre de Usuario");
		lblUsuario.setBounds(120, 28, 185, 14);
		contentPane.add(lblUsuario);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOlvidoContraseña.setForeground(new Color(0, 0, 255));
				lblOlvidoContraseña.setText("Olvidé la contraseña");
				lblNoTieneCuenta.setForeground(new Color(0, 0, 255));
				lblNoTieneCuenta.setText("¿No tiene cuenta? Registrese");
			}
		});
		
		
	}
}