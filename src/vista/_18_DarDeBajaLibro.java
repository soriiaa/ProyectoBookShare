/**
 * @author Apa
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _18_DarDeBajaLibro extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPorFavorIntroduzca;
	private JTextField textField;
	private JTable table;

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

	public _18_DarDeBajaLibro() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 154, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 173, 591);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Menu Navegacion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(128, 128, 128));
		scrollPane.setColumnHeaderView(lblNewLabel);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Alta Lugar", "Alta Libro", "Baja Libro", "Baja Lugar", "Enviar Mensaje" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);

		JButton btnNewButton = new JButton("Mi perfil");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 602, 173, 39);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Baja Libros");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(463, 56, 182, 39);
		contentPane.add(lblNewLabel_1);

		txtPorFavorIntroduzca = new JTextField();
		txtPorFavorIntroduzca.setText(
				"Por favor, introduzca el titulo del libro que desea anular y eliminar del registro del sistema");
		txtPorFavorIntroduzca.setBounds(308, 165, 515, 30);
		contentPane.add(txtPorFavorIntroduzca);
		txtPorFavorIntroduzca.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(308, 224, 416, 20);
		contentPane.add(textField);

		JLabel lblNewLabel_2 = new JLabel("Titulo");
		lblNewLabel_2.setBounds(310, 206, 105, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(311, 343, 515, 115);
		contentPane.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Libro 1", "Autor 1", "Terror", "5/5", "230" },
						{ "Libro 2", "Autor 2", "Ficci\u00F3n", "4.3/5", "510" },
						{ "Libro 3", "Autor 3", "Aventura", "4/5", "240" }, },
				new String[] { "T\u00EDtulo", "Autor", "G\u00E9nero", "Valoraci\u00F3n",
						"N\u00FAmero de P\u00E1ginas" }));
		table.getColumnModel().getColumn(4).setPreferredWidth(112);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setToolTipText("\r\n");

		JButton btnNewButton_1_1 = new JButton("Dar de baja");
		btnNewButton_1_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1_1.setBounds(843, 602, 112, 39);
		contentPane.add(btnNewButton_1_1);

		JButton btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(18, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}
}
