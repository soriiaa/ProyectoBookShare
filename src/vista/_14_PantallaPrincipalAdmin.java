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

public class _14_PantallaPrincipalAdmin extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnMiPerfil;
	private JLabel lblImagenInicio;
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

	public _14_PantallaPrincipalAdmin() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 154, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(14, 20);
			}
		});
		btnVolverLanzadera.setBounds(818, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);

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
			String[] values = new String[] { "Alta Lugar", "Alta Libro", "Baja Libro", "Baja Lugar", "Enviar Mensaje" };

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

		lblImagenInicio = new JLabel("New label");
		lblImagenInicio.setIcon(
				new ImageIcon(_14_PantallaPrincipalAdmin.class.getResource("/assets/BookShare_Presentacion.jpg")));
		lblImagenInicio.setBounds(260, 11, 705, 622);
		contentPane.add(lblImagenInicio);
	}

}
