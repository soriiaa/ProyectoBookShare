/**
 * @author Andres
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _13_BandejaDeEntrada extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

	public _13_BandejaDeEntrada() {
		setResizable(false);
		setTitle("BookShare 2.0");
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
			String[] values = new String[] { "Coger Libro", "Dejar Libro", "Alta libro", "FAQ", "Historial Libros" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);

		JLabel lblNewLabel_1 = new JLabel("Usted esta en bandeja de entrada");
		lblNewLabel_1.setBounds(10, 602, 173, 39);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(266, 10, 535, 380);
		contentPane.add(scrollPane_1);

		JLabel lblNewLabel_2 = new JLabel("Mensajes");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);

		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] { "Mensaje 1", "Mensaje 2", "Mensaje 3 ", "Mensaje 4", "Mensaje 5",
					"Mensaje 6 ", "Mensaje 7", "Mensaje 8", "Mensaje 9", "Mensaje 10", "Mensaje 11", "Mensaje 12",
					"Mensaje 13", "Mensaje 14", "Mensaje 15", "Mensaje 16", "Mensaje 17", "Mensaje 18", "Mensaje 19" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(list_1);

		JButton btnNewButton = new JButton("Vaciar Bandeja de Entrada");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(550, 400, 251, 42);
		contentPane.add(btnNewButton);

		JButton btnMarcarMensajesComo = new JButton("Marcar mensajes como leidos");
		btnMarcarMensajesComo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMarcarMensajesComo.setBounds(266, 400, 251, 42);
		contentPane.add(btnMarcarMensajesComo);

		JButton btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 642, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}

}
