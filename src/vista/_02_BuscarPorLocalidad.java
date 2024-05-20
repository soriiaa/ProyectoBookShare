/**
 * @author Alejandro
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _02_BuscarPorLocalidad extends JFrame implements Vista {
	private JButton btnBuscarPorLocalidad;
	private JPanel panel;
	private JTable table;
	private JPanel contentPane;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnBuscarPorLocalidad2;
	private JButton btnIniciarSesion;
	private DefaultTableModel modelo;

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtBuscador;
	
	public JTextField getTxtBuscador() {
		return txtBuscador;
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _02_BuscarPorLocalidad() {
		initialize();
	}

	private void initialize() {
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
		
		btnBuscarPorLocalidad2 = new JButton("Buscar por Localidad");
		btnBuscarPorLocalidad2.setBorderPainted(false);
		btnBuscarPorLocalidad2.setBackground(new Color(230, 230, 250));
		btnBuscarPorLocalidad2.setForeground(new Color(0, 0, 128));
		btnBuscarPorLocalidad2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarPorLocalidad2.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorLocalidad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 2);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnBuscarPorLocalidad2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad2.setBackground(new Color (220, 220, 220));
				btnBuscarPorLocalidad2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad2.setBackground(new Color(230, 230, 250));
			}
		});
		btnBuscarPorLocalidad2.setBounds(0, 39, 205, 40);
		panelMenuNavegacion.add(btnBuscarPorLocalidad2);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(new Color(230, 230, 250));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.RIGHT);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 1);
			}
		});
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color (220, 220, 220));
				btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(230, 230, 250));
			}
		});
		btnIniciarSesion.setBounds(0, 621, 183, 42);
		contentPane.add(btnIniciarSesion);
		
		/*
		
		getContentPane().setBackground(new Color(176, 210, 253));
		setBounds(100, 100, 908, 716);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad.setBackground(new Color(255, 255, 255));
			}
		});
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 10, 193, 607);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 193, 42);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblMenuNavegacion = new JLabel("Menú Navegación");
		lblMenuNavegacion.setForeground(new Color(255, 255, 255));
		lblMenuNavegacion.setBounds(26, 12, 144, 20);
		panel.add(lblMenuNavegacion);
		lblMenuNavegacion.setBackground(new Color(192, 192, 192));
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnBuscarPorLocalidad = new JButton("Buscar Por Localidad");
		btnBuscarPorLocalidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLocalidad.setBackground(new Color(220, 220, 220));
				btnBuscarPorLocalidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnBuscarPorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarPorLocalidad.setBackground(new Color(255, 255, 255));
		btnBuscarPorLocalidad.setBounds(0, 41, 193, 35);
		btnBuscarPorLocalidad.setBorder(null);
		panel_1.add(btnBuscarPorLocalidad);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(220, 220, 220));
				btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnIniciarSesion.setBounds(10, 627, 193, 42);
		getContentPane().add(btnIniciarSesion);
		
		*/

		JLabel lblBuscarPorLocalidad = new JLabel("Buscar por localidad");
		lblBuscarPorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblBuscarPorLocalidad.setBounds(359, 31, 446, 93);
		getContentPane().add(lblBuscarPorLocalidad);

		txtBuscador = new JTextField();
		txtBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscador.setText("");
			}
		});
		txtBuscador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscador.getText().isEmpty()) {
					txtBuscador.setText("Buscar...");
				}
			}
		});
		txtBuscador.setText("Buscar...");
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(263, 149, 542, 30);
		txtBuscador.setBorder(null);
		Border border = BorderFactory.createEmptyBorder(0, 10, 0, 0);
		txtBuscador.setBorder(border);

		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(263, 202, 646, 426);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		table.setBorder(null);
		modelo = new DefaultTableModel(
				new Object[][] { { 25432, "Libro 1" }, { 52345, "Libro 2" },
				{ 74562, "Libro 3" }, { 12522, "Libro 4" }, }, new String[] { "C\u00F3digo Postal", "Libro" });
		table.setModel(modelo);
		scrollPane.setViewportView(table);

		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.setGridColor(Color.LIGHT_GRAY);

		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(new Color(200, 200, 255));
		table.setSelectionForeground(Color.BLACK);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				limpiarCampos();
				Object[][] info = miControlador.guardarCodPostal();
				String[] columnas = {"Codigo Postal", "Libro"};
				modelo = new DefaultTableModel(info,columnas);
				table.setModel(modelo);
				

			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(90, 90, 90));
				btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(30, 30, 30));
		btnBuscar.setBounds(815, 147, 94, 30);
		btnBuscar.setBorder(null);
		getContentPane().add(btnBuscar);

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(30, 30, 30));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

	}
	
	private void limpiarCampos() {
		txtBuscador.setText("");
	}
}
