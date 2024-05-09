/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btnVolverLanzadera;

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
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(120, 44, 193, 29);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 255, 128));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(168, 153, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblOlvidoContraseña = new JLabel("Olvidé la contraseña");
		lblOlvidoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOlvidoContraseña.setForeground(new Color(0, 0, 255));
		lblOlvidoContraseña.setBounds(155, 187, 124, 14);
		contentPane.add(lblOlvidoContraseña);

		lblNoTieneCuenta = new JLabel("¿No tiene cuenta? Registrese");
		lblNoTieneCuenta.setForeground(Color.BLUE);
		lblNoTieneCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoTieneCuenta.setBounds(130, 216, 175, 14);
		contentPane.add(lblNoTieneCuenta);

		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(120, 96, 193, 29);
		contentPane.add(txtContraseña);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(120, 82, 124, 14);
		contentPane.add(lblContraseña);

		JLabel lblUsuario = new JLabel("Nombre de Usuario");
		lblUsuario.setBounds(120, 28, 185, 14);
		contentPane.add(lblUsuario);
		
		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(1, 20);
			}
		});
		btnVolverLanzadera.setBounds(0, 0, 149, 21);
		contentPane.add(btnVolverLanzadera);
		
		
	}
}