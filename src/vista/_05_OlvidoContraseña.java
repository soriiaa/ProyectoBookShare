/**

 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _05_OlvidoContraseña extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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

	public _05_OlvidoContraseña() {
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(26, 36, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(26, 182, 158, 20);
		contentPane.add(textField_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(266, 36, 139, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(266, 111, 139, 20);
		contentPane.add(passwordField_1);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(5, 1);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color (220, 220, 220));
			}
		});	
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 255, 255));
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 255, 128));
		btnNewButton.setBounds(316, 229, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setBounds(26, 21, 139, 14);
		contentPane.add(lblNewLabel);

		JLabel lblRespuestaDeSeguridad = new JLabel("Respuesta de Seguridad");
		lblRespuestaDeSeguridad.setBounds(26, 167, 139, 14);
		contentPane.add(lblRespuestaDeSeguridad);

		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		lblNuevaContrasea.setBounds(266, 21, 139, 14);
		contentPane.add(lblNuevaContrasea);

		JLabel lblRepitaContrasea = new JLabel("Repita Contraseña");
		lblRepitaContrasea.setBounds(266, 97, 139, 14);
		contentPane.add(lblRepitaContrasea);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 110, 158, 22);
		contentPane.add(comboBox);

		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de Seguridad");
		lblPreguntaDeSeguridad.setBounds(26, 97, 139, 14);
		contentPane.add(lblPreguntaDeSeguridad);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(5, 1);
			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolver.setBackground(new Color (220, 220, 220));
			}
		});	
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolver.setBackground(new Color(255, 255, 255));
			}
		});
		btnVolver.setBorder(null);
		btnVolver.setBackground(new Color(255, 128, 128));
		btnVolver.setBounds(26, 229, 89, 23);
		contentPane.add(btnVolver);
	}
}
