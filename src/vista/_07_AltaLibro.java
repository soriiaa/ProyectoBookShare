/**
 * @author pablo
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _07_AltaLibro extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreLibro;
	private JTextField txtAutor;
	private JButton btnDejar;
	private JButton btnDarDeAlta;
	private JTextField txtGenero;
	private JLabel lblNewLabel_2_2;
	private JLabel lblAutorLibro;
	private JLabel lblTituloIntroducirLibro;
	private JLabel lblTituloLibro;
	private JButton btnMiPerfil;
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

	public _07_AltaLibro() {
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

		btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiPerfil.setBounds(10, 602, 173, 39);
		contentPane.add(btnMiPerfil);

		lblTituloLibro = new JLabel("Alta de libro");
		lblTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTituloLibro.setBounds(493, 11, 178, 39);
		contentPane.add(lblTituloLibro);

		lblTituloIntroducirLibro = new JLabel("Introduce el nombre del libro a dejar:");
		lblTituloIntroducirLibro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloIntroducirLibro.setBounds(238, 125, 490, 39);
		contentPane.add(lblTituloIntroducirLibro);

		txtNombreLibro = new JTextField();
		txtNombreLibro.setBounds(238, 175, 271, 32);
		contentPane.add(txtNombreLibro);
		txtNombreLibro.setColumns(10);

		lblAutorLibro = new JLabel("Introduce el autor del libro a dejar:");
		lblAutorLibro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAutorLibro.setBounds(238, 230, 490, 39);
		contentPane.add(lblAutorLibro);

		lblNewLabel_2_2 = new JLabel("Introduce el genero del libro a dejar:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(238, 321, 490, 39);
		contentPane.add(lblNewLabel_2_2);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(238, 280, 271, 30);
		contentPane.add(txtAutor);

		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(238, 380, 271, 32);
		contentPane.add(txtGenero);

		btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBackground(new Color(128, 255, 128));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDarDeAlta.setBounds(708, 604, 112, 39);
		contentPane.add(btnDarDeAlta);

		btnDejar = new JButton("Dejar");
		btnDejar.setBackground(new Color(128, 255, 128));
		btnDejar.setBounds(843, 602, 112, 39);
		contentPane.add(btnDejar);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(7, 20);
			}
		});
		btnVolverLanzadera.setBounds(808, 0, 178, 21);
		contentPane.add(btnVolverLanzadera);
	}
}
