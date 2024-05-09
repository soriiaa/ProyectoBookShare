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
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _11_Faq extends JFrame implements Vista {

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

	public _11_Faq() {
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
			String[] values = new String[] { "Coger Libro", "Dejar Libro", "Alta libro", "FAQ", "Historial Libros" };

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

		JLabel lblNewLabel_1 = new JLabel("FAQ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(460, 36, 182, 39);
		contentPane.add(lblNewLabel_1);

		JTextArea txtrporQue = new JTextArea();
		txtrporQue.setText(
				"1. ¿Por que debería leer libros?\r\nLeer libros no solo amplía tus conocimientos y vocabulario, sino que\r\n también estimula tu imaginación, mejora tu comprensión del mundo\r\n y puede ser una fuente inagotable de entretenimiento y reflexión\r\n\r\n2. ¿Cómo puedo encontrar libros que me interesen?\r\nHay varias formas de encontrar libros que te gusten, como explorar \r\ngéneros que te interesen, buscar recomendaciones de amigos, revisar\r\nreseñas en linea, visitar librerías físicas o virtuales, o unirte a clubes\r\nde lectura.\r\n\r\n3. ¿Cuál es la mejor manera de comenzar a leer si no tengo el hábito?\r\nEmpieza por elegir libros que te interesen genuinamente y establece \r\nmetas realistas de lectura. Puedes comenzar con lecturas conrtas o \r\nfragmentos pequeños y aumentar gradualmente la cantidad de \r\ntiempo dedicado a la lectura\r\n\r\n4. ¿Debería leer en formato impreso o electrónico?\r\nLa elección entre libros impresos o electrónicos depende de tus \r\npreferencias personales. Algunas personas prefieren la sensación \r\ntáctil y la experiencia física de un libro impreso, mientras que otras \r\ndisfrutan de la comodidad y la portabilidad de los dispositivos electrónicos.");
		txtrporQue.setBounds(256, 139, 628, 415);
		contentPane.add(txtrporQue);

		JButton btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(11, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}
}