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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _08_CogerLibro extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblCogerUnLibro;
	private JTextField txtBuscador;
	private JScrollPane scrollPane;
	private JTextField txtGenero;
	private JTextField txtLugar;
	private JButton btnGuardarYSalir;
	private JTable tablaLibros;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnMiperfil;

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
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(255, 255, 255));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setBackground(new Color(128, 128, 192));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(255, 250, 250));
		btnCogerLibro.setForeground(new Color(204, 204, 51));
		btnCogerLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 8);
			}
		});
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setBorderPainted(false);
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(255, 250, 250));
		btnDejarUnLibro.setForeground(new Color(204, 204, 51));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDejarUnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 9);
			}
		});
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(255, 250, 250));
		btnDarDeAlta.setForeground(new Color(204, 204, 51));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 7);
			}
		});
		btnDarDeAlta.setBounds(0, 119, 183, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setBorderPainted(false);
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(255, 250, 250));
		btnFaq.setForeground(new Color(204, 204, 51));
		btnFaq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 11);
			}
		});
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setBorderPainted(false);
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(255, 250, 250));
		btnHistorialLibros.setForeground(new Color(204, 204, 51));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistorialLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 10);
			}
		});
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBackground(new Color(128, 128, 192));
		btnMiperfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 12);
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);

		lblCogerUnLibro = new JLabel("Coger un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(449, 26, 310, 86);
		getContentPane().add(lblCogerUnLibro);

		txtBuscador = new JTextField();
		txtBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscador.setText("");
			}
		});
		txtBuscador.setText("Título...");
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(366, 153, 117, 30);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 232, 430, 346);
		getContentPane().add(scrollPane);

		tablaLibros = new JTable();
		tablaLibros.setModel(
				new DefaultTableModel(new Object[][] { { "Libro 1" }, { "Libro 2" }, { "Libro 3" }, { "Libro 4" }, },
						new String[] { "Libros" }));
		scrollPane.setViewportView(tablaLibros);

		txtGenero = new JTextField();
		txtGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtGenero.setText("");
			}
		});
		txtGenero.setText("Género...");
		txtGenero.setToolTipText("");
		txtGenero.setColumns(10);
		txtGenero.setBounds(677, 153, 117, 30);
		getContentPane().add(txtGenero);

		txtLugar = new JTextField();
		txtLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLugar.setText("");
			}
		});
		txtLugar.setText("Lugar...");
		txtLugar.setToolTipText("");
		txtLugar.setColumns(10);
		txtLugar.setBounds(523, 153, 117, 30);
		getContentPane().add(txtLugar);

		btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLugar.setText("Lugar...");
				txtGenero.setText("Género...");
				txtBuscador.setText("Título...");
			}
		});
		btnGuardarYSalir.setBackground(new Color(128, 255, 128));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarYSalir.setBounds(843, 610, 133, 42);
		getContentPane().add(btnGuardarYSalir);

		btnNewButton = new JButton("");
		btnNewButton.setBounds(804, 162, 21, 21);
		getContentPane().add(btnNewButton);

	}
}
