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

import controlador.Controlador;
import modelo.Modelo;

public class _09_DejarLibro extends JFrame implements Vista {

	private JButton btnMiPerfil;
	private JButton btnCogerLibro;
	private JPanel panel;
	private JTextField txtBuscador;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnDejarLibro;
	private JButton btnAltaDeLibro;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JLabel lblTexto1;
	private JLabel lblFechaEnLa;
	private JLabel lblCdigoPostalEn;
	private JLabel lblEscribeUnaValoracin;
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

	public _09_DejarLibro() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		getContentPane().setBackground(new Color(20, 154, 235));
		setBounds(100, 100, 908, 716);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 193, 607);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 193, 42);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblMenuNavegacion = new JLabel("Menú Navegación");
		lblMenuNavegacion.setBounds(33, 11, 126, 20);
		panel.add(lblMenuNavegacion);
		lblMenuNavegacion.setBackground(new Color(192, 192, 192));
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnCogerLibro = new JButton("Coger Libro");
		btnCogerLibro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCogerLibro.setBackground(new Color(255, 255, 255));
		btnCogerLibro.setBounds(0, 41, 193, 35);
		panel_1.add(btnCogerLibro);

		btnDejarLibro = new JButton("Dejar Libro");
		btnDejarLibro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDejarLibro.setBackground(Color.WHITE);
		btnDejarLibro.setBounds(0, 74, 193, 35);
		panel_1.add(btnDejarLibro);

		btnAltaDeLibro = new JButton("Alta de Libro");
		btnAltaDeLibro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAltaDeLibro.setBackground(Color.WHITE);
		btnAltaDeLibro.setBounds(0, 107, 193, 35);
		panel_1.add(btnAltaDeLibro);

		btnFaq = new JButton("FAQ");
		btnFaq.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFaq.setBackground(Color.WHITE);
		btnFaq.setBounds(0, 140, 193, 35);
		panel_1.add(btnFaq);

		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHistorialLibros.setBackground(Color.WHITE);
		btnHistorialLibros.setBounds(0, 172, 193, 35);
		panel_1.add(btnHistorialLibros);

		btnMiPerfil = new JButton("Mi Perfil");
		btnMiPerfil.setBackground(new Color(255, 255, 255));
		btnMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnMiPerfil.setBounds(10, 627, 193, 42);
		getContentPane().add(btnMiPerfil);

		JLabel lblCogerUnLibro = new JLabel("Dejar un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(401, 26, 284, 66);
		getContentPane().add(lblCogerUnLibro);

		txtBuscador = new JTextField();
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(608, 153, 228, 30);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(667, 264, 169, 30);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(513, 209, 323, 30);
		getContentPane().add(textField_1);

		JButton btnGuardarYSalir = new JButton("Dejar");
		btnGuardarYSalir.setBackground(new Color(128, 179, 77));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarYSalir.setBounds(767, 627, 117, 42);
		getContentPane().add(btnGuardarYSalir);

		lblTexto1 = new JLabel("Introduce el nombre del libro a dejar:");
		lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTexto1.setBounds(297, 143, 315, 42);
		getContentPane().add(lblTexto1);

		lblFechaEnLa = new JLabel("Fecha en la que se cogió:");
		lblFechaEnLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaEnLa.setBounds(297, 208, 216, 24);
		getContentPane().add(lblFechaEnLa);

		lblCdigoPostalEn = new JLabel("Código Postal en el que se va a dejar el libro:");
		lblCdigoPostalEn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoPostalEn.setBounds(297, 263, 371, 24);
		getContentPane().add(lblCdigoPostalEn);

		lblEscribeUnaValoracin = new JLabel("Escribe una valoración sobre el libro:");
		lblEscribeUnaValoracin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEscribeUnaValoracin.setBounds(297, 322, 295, 24);
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
		txtPuntuacion.setBounds(602, 321, 29, 30);
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
		textComentario.setBounds(297, 376, 540, 152);
		getContentPane().add(textComentario);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 20);
			}
		});
		btnVolverLanzadera.setBounds(726, 0, 168, 21);
		getContentPane().add(btnVolverLanzadera);

	}
}
