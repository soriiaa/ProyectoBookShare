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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _08_CogerLibro extends JFrame implements Vista {

	private JButton btnMiPerfil;
	private JButton btnCogerLibro;
	private JPanel panel;
	private JTable tablaLibros;
	private JButton btnDejarLibro;
	private JButton btnAltaDeLibro;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
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

	public _08_CogerLibro() {
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

		JLabel lblCogerUnLibro = new JLabel("Coger un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(401, 26, 284, 66);
		getContentPane().add(lblCogerUnLibro);

		JTextField txtBuscador = new JTextField();
		txtBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscador.setText("");
			}
		});
		txtBuscador.setText("Título...");
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(302, 153, 117, 30);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 233, 430, 346);
		getContentPane().add(scrollPane);

		tablaLibros = new JTable();
		tablaLibros.setModel(
				new DefaultTableModel(new Object[][] { { "Libro 1" }, { "Libro 2" }, { "Libro 3" }, { "Libro 4" }, },
						new String[] { "Libros" }));
		scrollPane.setViewportView(tablaLibros);

		JTextField txtGenero = new JTextField();
		txtGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGenero.setText("");
			}
		});
		txtGenero.setText("Género...");
		txtGenero.setToolTipText("");
		txtGenero.setColumns(10);
		txtGenero.setBounds(646, 153, 117, 30);
		getContentPane().add(txtGenero);

		JTextField txtLugar = new JTextField();
		txtLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLugar.setText("");
			}
		});
		txtLugar.setText("Lugar...");
		txtLugar.setToolTipText("");
		txtLugar.setColumns(10);
		txtLugar.setBounds(476, 153, 117, 30);
		getContentPane().add(txtLugar);

		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLugar.setText("Lugar...");
				txtGenero.setText("Género...");
				txtBuscador.setText("Título...");
			}
		});
		btnGuardarYSalir.setBackground(new Color(128, 179, 77));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarYSalir.setBounds(767, 627, 117, 42);
		getContentPane().add(btnGuardarYSalir);

		btnNewButton = new JButton("");
		btnNewButton.setBounds(773, 157, 21, 21);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(863, 10, 21, 21);
		getContentPane().add(btnNewButton_1);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 20);
			}
		});
		btnVolverLanzadera.setBounds(695, 10, 168, 21);
		getContentPane().add(btnVolverLanzadera);

	}
}
