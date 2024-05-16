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

public class _04_Registro extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

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

	public _04_Registro() {
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(32, 37, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(32, 221, 129, 20);
		contentPane.add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(32, 80, 129, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(32, 123, 129, 20);
		contentPane.add(passwordField_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 172, 129, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel = new JLabel("Nombre de Usuario *");
		lblNewLabel.setBounds(31, 23, 173, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Contraseña *");
		lblPassword.setBounds(32, 68, 129, 14);
		contentPane.add(lblPassword);

		JLabel lblRepitaContrasea = new JLabel("Repita Contraseña *");
		lblRepitaContrasea.setBounds(32, 111, 129, 14);
		contentPane.add(lblRepitaContrasea);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento *");
		lblFechaNacimiento.setBounds(32, 160, 129, 14);
		contentPane.add(lblFechaNacimiento);

		JLabel lblCodPostal = new JLabel("Cod postal *");
		lblCodPostal.setBounds(32, 209, 110, 14);
		contentPane.add(lblCodPostal);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(228, 37, 150, 21);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Pregunta de Seguridad *");
		lblNewLabel_1.setBounds(228, 23, 168, 14);
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 80, 150, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1_1 = new JLabel("Respuesta *");
		lblNewLabel_1_1.setBounds(228, 68, 136, 14);
		contentPane.add(lblNewLabel_1_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("¿Eres administrador?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(228, 137, 150, 23);
		contentPane.add(chckbxNewCheckBox);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 188, 150, 20);
		contentPane.add(textField_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Codigo Admin");
		lblNewLabel_1_1_1.setBounds(228, 175, 136, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnRegistro = new JButton("Register");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(4, 1);
			}
		});
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color (220, 220, 220));
			}
		});
		btnRegistro.setBackground(new Color(128, 255, 128));
		btnRegistro.setBounds(289, 220, 89, 23);
		contentPane.add(btnRegistro);
		
		btnRegistro.setBorder(null);
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(255, 255, 255));
			}
		});
		
		JButton btnVueltaLogin = new JButton("Volver");
		btnVueltaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(4, 1);
			}
		});
		btnVueltaLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin.setBackground(new Color (220, 220, 220));
			}
		});		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVueltaLogin.setBackground(new Color(255, 255, 255));
			}
		});
		
		btnVueltaLogin.setBorder(null);
		btnVueltaLogin.setBackground(new Color(255, 128, 128));
		btnVueltaLogin.setBounds(192, 220, 89, 23);
		contentPane.add(btnVueltaLogin);
	}
}
