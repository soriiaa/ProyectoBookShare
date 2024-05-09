/**
 * @author Andres
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class _17_DarAltaUbicacion extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIntroducirDireccion;
	private JLabel lblMenuNavegacion;
	private JList list;
	private JButton btnMiPerfil;
	private JScrollPane scrollPane;
	private JLabel lblTituloPantalla;
	private JLabel lblIndicacionDireccion;
	private JLabel lblEjemplo;
	private JButton btnDarDeAlta;
	private JLabel lblDireccion;
	private JComboBox comboBox;
	private JLabel lblIndicacionUbicacion;
	private JLabel lblUbicacion;
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

	public _17_DarAltaUbicacion() {
		setResizable(false);
		setTitle("BookShare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 140, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 173, 418);
		contentPane.add(scrollPane);

		lblMenuNavegacion = new JLabel("Menu Navegacion");
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuNavegacion.setBackground(new Color(128, 128, 128));
		scrollPane.setColumnHeaderView(lblMenuNavegacion);

		list = new JList();
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

		btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiPerfil.setBounds(10, 431, 173, 39);
		contentPane.add(btnMiPerfil);

		lblTituloPantalla = new JLabel("Alta Lugares");
		lblTituloPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloPantalla.setBounds(335, 24, 298, 36);
		contentPane.add(lblTituloPantalla);

		lblEjemplo = new JLabel("Ej: Calle/Avenida/Rotonda nombre de la via, N.º Portal");
		lblEjemplo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEjemplo.setBounds(232, 116, 532, 36);
		contentPane.add(lblEjemplo);

		lblIndicacionDireccion = new JLabel(
				"Por favor, introduzca la dirrección que desea activar y registrar en el sistema:\r\n");
		lblIndicacionDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicacionDireccion.setBounds(232, 70, 532, 36);
		contentPane.add(lblIndicacionDireccion);

		btnDarDeAlta = new JButton("Dar de Alta\r\n");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDarDeAlta.setBackground(new Color(0, 255, 128));
		btnDarDeAlta.setBounds(621, 432, 143, 39);
		contentPane.add(btnDarDeAlta);

		textIntroducirDireccion = new JTextField();
		textIntroducirDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textIntroducirDireccion.setColumns(10);
		textIntroducirDireccion.setBounds(335, 174, 429, 39);
		contentPane.add(textIntroducirDireccion);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(232, 175, 89, 39);
		contentPane.add(lblDireccion);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Ningun estado seleccionado", "Ubicación Privado", "Ubicación Público" }));
		comboBox.setBounds(335, 290, 429, 36);
		contentPane.add(comboBox);

		lblIndicacionUbicacion = new JLabel("Por favor, indique si la dirección es un lugar público o privado:\r\n");
		lblIndicacionUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndicacionUbicacion.setBounds(232, 244, 532, 36);
		contentPane.add(lblIndicacionUbicacion);

		lblUbicacion = new JLabel("Ubicación:");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUbicacion.setBounds(232, 290, 89, 39);
		contentPane.add(lblUbicacion);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(17, 20);
			}
		});
		btnVolverLanzadera.setBounds(691, 0, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}

}
