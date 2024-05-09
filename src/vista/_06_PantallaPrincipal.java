/**
 * @author pablo
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
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

public class _06_PantallaPrincipal extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImagenPrincipio;
	private JButton btnMiperfil;
	private JScrollPane scrollPane;
	private JLabel lblMenuNavegacion;
	private JList listNavegacion;
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

	public _06_PantallaPrincipal() {
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

		lblMenuNavegacion = new JLabel("Menu Navegacion");
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuNavegacion.setBackground(new Color(128, 128, 128));
		scrollPane.setColumnHeaderView(lblMenuNavegacion);

		listNavegacion = new JList();
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

		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiperfil.setBounds(10, 602, 173, 39);
		contentPane.add(btnMiperfil);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(6, 20);;
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);

		lblImagenPrincipio = new JLabel("New label");
		lblImagenPrincipio
				.setIcon(new ImageIcon(_06_PantallaPrincipal.class.getResource("/assets/BookShare_Presentacion3.jpg")));
		lblImagenPrincipio.setBounds(260, 11, 705, 622);
		contentPane.add(lblImagenPrincipio);
	}
}
