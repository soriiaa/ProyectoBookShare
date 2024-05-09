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

public class _02_BuscarPorLocalidad extends JFrame implements Vista {

	private JButton btnIniciarSesion;
	private JButton btnBuscarPorLocalidad;
	private JPanel panel;
	private JTable table;
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

	public _02_BuscarPorLocalidad() {
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

		btnBuscarPorLocalidad = new JButton("Buscar Por Localidad");
		btnBuscarPorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarPorLocalidad.setBackground(new Color(255, 255, 255));
		btnBuscarPorLocalidad.setBounds(0, 41, 193, 35);
		panel_1.add(btnBuscarPorLocalidad);

		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnIniciarSesion.setBounds(10, 627, 193, 42);
		getContentPane().add(btnIniciarSesion);

		JLabel lblBuscarPorLocalidad = new JLabel("Buscar por localidad");
		lblBuscarPorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblBuscarPorLocalidad.setBounds(342, 25, 417, 66);
		getContentPane().add(lblBuscarPorLocalidad);

		JTextField txtBuscador = new JTextField();
		txtBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscador.setText("");
			}
		});
		txtBuscador.setText("Buscar...");
		txtBuscador.setToolTipText("");
		txtBuscador.setBounds(329, 150, 430, 30);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 233, 430, 384);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { 25432, "Libro 1" }, { 52345, "Libro 2" },
				{ 74562, "Libro 3" }, { 12522, "Libro 4" }, }, new String[] { "C\u00F3digo Postal", "Libro" }));
		scrollPane.setViewportView(table);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setBounds(777, 627, 96, 37);
		getContentPane().add(btnBuscar);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 20);
			}
		});
		btnVolverLanzadera.setBounds(714, 0, 180, 21);
		getContentPane().add(btnVolverLanzadera);

	}
}
