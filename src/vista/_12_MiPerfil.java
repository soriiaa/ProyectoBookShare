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

public class _12_MiPerfil extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNicknameUsuario;
	private JTextField txtFotoUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtApellidos;
	private JTextField txtContrasea;
	private JTextField txtDiagrama;
	private JTextField txtEstadistcas;
	private JButton btnCambiarFotoUsuario;
	private JTextField txtPreguntasSeguridad;
	private JList listOpcionesMenuNavegacion;
	private JLabel lblMenuNavegacion;
	private JScrollPane scrollPane;
	private JLabel lblTituloMiPerfil;
	private JButton btnCambiarNickName;
	private JButton btnCambiarApellidos;
	private JButton btnCambiarNombre;
	private JButton btnCambiarConrasea;
	private JButton btnCambiarPreguntas;
	private JButton btnAplicarCambios;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
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

	public _12_MiPerfil() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 136, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 185, 420);
		contentPane.add(scrollPane);

		lblMenuNavegacion = new JLabel("Menu Navegacion");
		lblMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuNavegacion.setBackground(new Color(128, 128, 128));
		scrollPane.setColumnHeaderView(lblMenuNavegacion);

		listOpcionesMenuNavegacion = new JList();
		listOpcionesMenuNavegacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOpcionesMenuNavegacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listOpcionesMenuNavegacion.setModel(new AbstractListModel() {
			String[] values = new String[] { "Volver al menu principal", "Bandeja de Entrada", "Cerrar sesión" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listOpcionesMenuNavegacion);

		lblTituloMiPerfil = new JLabel("Usted se encuentra en: Mi Perfil");
		lblTituloMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTituloMiPerfil.setBounds(10, 430, 185, 27);
		contentPane.add(lblTituloMiPerfil);

		txtNicknameUsuario = new JTextField();
		txtNicknameUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNicknameUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNicknameUsuario.setEditable(false);
		txtNicknameUsuario.setText("NickName de Usuario");
		txtNicknameUsuario.setBounds(299, 195, 230, 19);
		contentPane.add(txtNicknameUsuario);
		txtNicknameUsuario.setColumns(10);

		txtFotoUsuario = new JTextField();
		txtFotoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtFotoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtFotoUsuario.setText("Foto de Usuario");
		txtFotoUsuario.setEditable(false);
		txtFotoUsuario.setColumns(10);
		txtFotoUsuario.setBounds(299, 11, 230, 126);
		contentPane.add(txtFotoUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setText("Nombre del Usuario");
		txtNombreUsuario.setEditable(false);
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(299, 244, 230, 19);
		contentPane.add(txtNombreUsuario);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtApellidos.setText("Apellidos del Usuario\r\n");
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(299, 291, 230, 19);
		contentPane.add(txtApellidos);

		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtContrasea.setText("Contraseña");
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.setEditable(false);
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(299, 339, 230, 19);
		contentPane.add(txtContrasea);

		txtDiagrama = new JTextField();
		txtDiagrama.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDiagrama.setText("Diagrama ");
		txtDiagrama.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiagrama.setEditable(false);
		txtDiagrama.setColumns(10);
		txtDiagrama.setBounds(635, 11, 201, 126);
		contentPane.add(txtDiagrama);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "- Ninguno seleccionando ", "- Género Aventura  ", "- Género Fantasía ",
						"- Género Ficción ", "- Género Misterio  ", "- Género Suspense ", "- Género Terror   " }));
		comboBox.setBounds(635, 214, 201, 21);
		contentPane.add(comboBox);

		txtEstadistcas = new JTextField();
		txtEstadistcas.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEstadistcas.setText("Estadísticas");
		txtEstadistcas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadistcas.setEditable(false);
		txtEstadistcas.setColumns(10);
		txtEstadistcas.setBounds(635, 195, 201, 19);
		contentPane.add(txtEstadistcas);

		btnCambiarFotoUsuario = new JButton("Cambiar Foto de Usuario");
		btnCambiarFotoUsuario.setBounds(299, 135, 230, 27);
		contentPane.add(btnCambiarFotoUsuario);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "Digrama de Barras (Predeterminado)", "Diagrama Circular" }));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_1.setBounds(635, 135, 201, 27);
		contentPane.add(comboBox_1);

		btnCambiarNickName = new JButton("Cambiar NickName ");
		btnCambiarNickName.setBounds(299, 214, 230, 20);
		contentPane.add(btnCambiarNickName);

		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.setBounds(299, 261, 230, 20);
		contentPane.add(btnCambiarNombre);

		btnCambiarApellidos = new JButton("Cambiar Apellidos");
		btnCambiarApellidos.setBounds(299, 309, 230, 20);
		contentPane.add(btnCambiarApellidos);

		btnCambiarConrasea = new JButton("Cambiar Contraseña");
		btnCambiarConrasea.setBounds(299, 357, 230, 20);
		contentPane.add(btnCambiarConrasea);

		txtPreguntasSeguridad = new JTextField();
		txtPreguntasSeguridad.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPreguntasSeguridad.setText("Preguntas de Seguridad");
		txtPreguntasSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreguntasSeguridad.setEditable(false);
		txtPreguntasSeguridad.setColumns(10);
		txtPreguntasSeguridad.setBounds(299, 387, 230, 27);
		contentPane.add(txtPreguntasSeguridad);

		btnCambiarPreguntas = new JButton("Cambiar Preguntas de Seguridad");
		btnCambiarPreguntas.setBounds(299, 412, 230, 19);
		contentPane.add(btnCambiarPreguntas);

		btnAplicarCambios = new JButton("Aplicar Cambios");
		btnAplicarCambios.setBackground(new Color(0, 255, 128));
		btnAplicarCambios.setBounds(635, 387, 201, 44);
		contentPane.add(btnAplicarCambios);

		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 20);
			}
		});
		btnVolverLanzadera.setBounds(697, 446, 168, 21);
		contentPane.add(btnVolverLanzadera);
	}
}
