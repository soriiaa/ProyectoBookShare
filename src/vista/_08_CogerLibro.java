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
import java.util.ArrayList;

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
	private JTextField txtBuscadorTitulo;
	private JScrollPane scrollPane;
	private JTextField txtBuscadorGenero;
	private JTextField txtBuscadorLugar;
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
	private JButton btnBandejaDeEntrada;
	private String[][] arrayLibrosIdTituloGeneroLugar;
	private JButton btnBuscarTitulo;
	private JButton btnBuscarPorLugar;
	private JButton btnBuscarPorGénero;

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
		miModelo = new Modelo();
		arrayLibrosIdTituloGeneroLugar = miModelo.cogerLibroBaseDatos();
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setForeground(new Color(0, 0, 0));
		panelTituloMenu.setBackground(new Color(0, 0, 0));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setForeground(new Color(255, 255, 255));
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(230, 230, 250));
		btnCogerLibro.setForeground(new Color(0, 0, 128));
		btnCogerLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 8);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 230));
				btnGuardarYSalir.setBackground(new Color(255, 255, 255));
			}
		});
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setBorderPainted(false);
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(230, 230, 250));
		btnDejarUnLibro.setForeground(new Color(0, 0, 128));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDejarUnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 9);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(230, 230, 250));
		btnDarDeAlta.setForeground(new Color(0, 0, 128));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 7);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.setBounds(0, 119, 195, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setBorderPainted(false);
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(230, 230, 250));
		btnFaq.setForeground(new Color(0, 0, 128));
		btnFaq.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 11);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setBorderPainted(false);
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(230, 230, 250));
		btnHistorialLibros.setForeground(new Color(0, 0, 128));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHistorialLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 10);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
		
		btnBandejaDeEntrada = new JButton("Bandeja de Entrada");
		btnBandejaDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		btnBandejaDeEntrada.setForeground(new Color(0, 0, 128));
		btnBandejaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBandejaDeEntrada.setBorderPainted(false);
		btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));		
		btnBandejaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 13);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.setBounds(0, 237, 198, 40);
		panelMenuNavegacion.add(btnBandejaDeEntrada);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color (220, 220, 220));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);

		lblCogerUnLibro = new JLabel("Coger un libro");
		lblCogerUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCogerUnLibro.setBounds(449, 26, 310, 86);
		getContentPane().add(lblCogerUnLibro);

		txtBuscadorTitulo = new JTextField();
		txtBuscadorTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscadorTitulo.setText("");
			}
		});
		txtBuscadorTitulo.setText("Título...");
		txtBuscadorTitulo.setToolTipText("");
		txtBuscadorTitulo.setBounds(366, 141, 117, 30);
		txtBuscadorTitulo.setBorder(null);
		getContentPane().add(txtBuscadorTitulo);
		txtBuscadorTitulo.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 232, 430, 346);
		getContentPane().add(scrollPane);
		
		tablaLibros = new JTable();
		
		System.out.println("Tabla actualizada");
		
		
		
		String[][] titulos = new String [arrayLibrosIdTituloGeneroLugar.length][1];
		String[] columnas = {"Libros"};
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			titulos[i][0] = arrayLibrosIdTituloGeneroLugar[i][1];
		}
		
		tablaLibros.setModel(new DefaultTableModel(titulos, columnas));
		scrollPane.setViewportView(tablaLibros);
		

		txtBuscadorGenero = new JTextField();
		txtBuscadorGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscadorGenero.setText("");
			}
		});
		txtBuscadorGenero.setText("Género...");
		txtBuscadorGenero.setToolTipText("");
		txtBuscadorGenero.setColumns(10);
		txtBuscadorGenero.setBounds(677, 141, 117, 30);
		txtBuscadorGenero.setBorder(null);
		getContentPane().add(txtBuscadorGenero);

		txtBuscadorLugar = new JTextField();
		txtBuscadorLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscadorLugar.setText("");
			}
		});
		txtBuscadorLugar.setText("Lugar...");
		txtBuscadorLugar.setToolTipText("");
		txtBuscadorLugar.setColumns(10);
		txtBuscadorLugar.setBounds(523, 141, 117, 30);
		txtBuscadorLugar.setBorder(null);
		getContentPane().add(txtBuscadorLugar);

		btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardarYSalir.setBackground(new Color(220, 220, 220));
			}
		});
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscadorLugar.setText("Lugar...");
				txtBuscadorGenero.setText("Género...");
				txtBuscadorTitulo.setText("Título...");
			}
		});
		btnGuardarYSalir.setBackground(new Color(255, 255, 255));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarYSalir.setBounds(843, 610, 133, 42);
		btnGuardarYSalir.setBorder(null);
		getContentPane().add(btnGuardarYSalir);

		btnNewButton = new JButton("");
		btnNewButton.setBounds(804, 150, 21, 21);
		getContentPane().add(btnNewButton);
		
		btnBuscarTitulo = new JButton("Buscar por Título");
		btnBuscarTitulo.setBackground(new Color(255, 255, 255));
		btnBuscarTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tituloBuscado = txtBuscadorTitulo.getText();
				actualizarTablaPorTitulo(tituloBuscado);
			}
		});
		btnBuscarTitulo.setBounds(366, 181, 117, 29);
		btnBuscarTitulo.setBorder(null);
		contentPane.add(btnBuscarTitulo);
		
		btnBuscarPorLugar = new JButton("Buscar por Lugar");
		btnBuscarPorLugar.setBackground(new Color(255, 255, 255));
		btnBuscarPorLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lugarBuscado = txtBuscadorLugar.getText();
				actualizarTablaPorLugar(lugarBuscado);
			}
		});
		btnBuscarPorLugar.setBorder(null);
		btnBuscarPorLugar.setBounds(523, 181, 117, 29);
		contentPane.add(btnBuscarPorLugar);
		
		btnBuscarPorGénero = new JButton("Buscar por Género");
		btnBuscarPorGénero.setBackground(new Color(255, 255, 255));
		btnBuscarPorGénero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String generoBuscado = txtBuscadorGenero.getText();
				actualizarTablaPorGenero(generoBuscado);
			}
		});
		btnBuscarPorGénero.setBorder(null);
		btnBuscarPorGénero.setBounds(677, 181, 117, 29);
		contentPane.add(btnBuscarPorGénero);
		
		

	}
	
	public void actualizarTablaPorTitulo(String titulo) {
		
		System.out.println("Tabla actualizada por título");
		String[][] titulos = new String [arrayLibrosIdTituloGeneroLugar.length][1];
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			titulos[i][0] = arrayLibrosIdTituloGeneroLugar[i][1];
		}
		
		ArrayList<String> listaTitulosBuscados = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (titulos[i][0].equalsIgnoreCase(titulo)) {
				listaTitulosBuscados.add(titulos[i][0]);
			}
		}
		
		String[][] titulosBuscadosPorTitulo = new String[listaTitulosBuscados.size()][1];
		
		for (int i = 0; i < listaTitulosBuscados.size(); i++) {
			titulosBuscadosPorTitulo[i][0] = listaTitulosBuscados.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorTitulo, columnas));
	}
	
	public void actualizarTablaPorLugar(String lugarBuscado) {
		
		System.out.println("Tabla actualizada por lugar");
		
		ArrayList<String> listaTitulosPorLugar = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (arrayLibrosIdTituloGeneroLugar[i][2].equalsIgnoreCase(lugarBuscado)) {
				listaTitulosPorLugar.add(arrayLibrosIdTituloGeneroLugar[i][1]);
			}
		}
		
		String[][] titulosBuscadosPorLugar = new String[listaTitulosPorLugar.size()][1];
		
		for (int i = 0; i < listaTitulosPorLugar.size(); i++) {
			titulosBuscadosPorLugar[i][0] = listaTitulosPorLugar.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorLugar, columnas));
		
	}
	
	public void actualizarTablaPorGenero(String generoBuscado) {
		
		System.out.println("Tabla actualizada por género");
		
		ArrayList<String> listaTitulosPorGenero = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (arrayLibrosIdTituloGeneroLugar[i][3].equalsIgnoreCase(generoBuscado)) {
				listaTitulosPorGenero.add(arrayLibrosIdTituloGeneroLugar[i][1]);
			}
		}
		
		String[][] titulosBuscadosPorGenero = new String[listaTitulosPorGenero.size()][1];
		
		for (int i = 0; i < listaTitulosPorGenero.size(); i++) {
			titulosBuscadosPorGenero[i][0] = listaTitulosPorGenero.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorGenero, columnas));
		
	}
}
