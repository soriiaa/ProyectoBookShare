/**
 * @author Pablo
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _10_HistorialLibros extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDatos;
	private JScrollPane scrollPane;
	private JButton btnMiPerfil;
	private JLabel lblTituloHistorialLibros;
	private JScrollPane scrollPaneTabla;
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

	public _10_HistorialLibros() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 154, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 173, 591);
		contentPane.add(scrollPane);

		JLabel lblMenuNavegacion = new JLabel("Menu Navegacion");
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuNavegacion.setBackground(new Color(128, 128, 128));
		scrollPane.setColumnHeaderView(lblMenuNavegacion);

		JList listNavegacion = new JList();
		listNavegacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listNavegacion.setModel(new AbstractListModel() {
			String[] values = new String[] { "Coger Libro", "Dejar Libro", "Alta libro", "FAQ", "Historial Libros" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listNavegacion);

		btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiPerfil.setBounds(10, 602, 173, 39);
		contentPane.add(btnMiPerfil);

		lblTituloHistorialLibros = new JLabel("Historial de Libros");
		lblTituloHistorialLibros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTituloHistorialLibros.setBounds(435, 11, 264, 39);
		contentPane.add(lblTituloHistorialLibros);

		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(202, 169, 765, 277);
		contentPane.add(scrollPaneTabla);

		tableDatos = new JTable();
		tableDatos.setRowHeight(25);
		scrollPaneTabla.setViewportView(tableDatos);
		tableDatos.setEnabled(false);
		tableDatos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tableDatos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "Titulo", "Autor", "Genero", "N\u00BA paginas", "Fecha operacion", "Valoracion",
						"Codigo Postal", "Tipo" }));

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(10, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);
		tableDatos.getColumnModel().getColumn(4).setPreferredWidth(102);
		tableDatos.getColumnModel().getColumn(5).setPreferredWidth(72);
		tableDatos.getColumnModel().getColumn(6).setPreferredWidth(92);
	}
}
