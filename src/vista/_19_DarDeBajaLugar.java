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

public class _19_DarDeBajaLugar extends JFrame implements Vista {

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

	public _19_DarDeBajaLugar() {
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

		JLabel lblNewLabel_1 = new JLabel("Baja Lugares");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(463, 56, 182, 39);
		contentPane.add(lblNewLabel_1);

		txtPorFavorIntroduzca = new JTextField();
		txtPorFavorIntroduzca
				.setText("Por favor introduzca el  lugar que desea anular y eliminar del registro en el sistema:");
		txtPorFavorIntroduzca.setBounds(301, 166, 515, 30);
		contentPane.add(txtPorFavorIntroduzca);
		txtPorFavorIntroduzca.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(301, 241, 416, 20);
		contentPane.add(textField);

		JLabel lblNewLabel_2 = new JLabel("Codigo Postal");
		lblNewLabel_2.setBounds(301, 216, 105, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(301, 374, 515, 82);
		contentPane.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(new Object[][] { { "Talleres Paco", "28321", "Madrid", "Madrid" }, },
				new String[] { "Nombre", "Codigo Postal", "Comunidad Autonoma", "Provincia" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setToolTipText("\r\n");

		JButton btnNewButton_1_1 = new JButton("Dar de baja");
		btnNewButton_1_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1_1.setBounds(843, 602, 112, 39);
		contentPane.add(btnNewButton_1_1);

		JButton btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}
}
