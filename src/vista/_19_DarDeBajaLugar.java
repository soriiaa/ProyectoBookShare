/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTextField txtPorFavorIntroduzca;
	private JTextField textField;
	private JTable table;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnAltaLugar;
	private JButton btnAltaLibro;
	private JButton btnBajaLugar;
	private JButton btnBajaLibro;
	private JButton btnEnviarMensaje;
	private JButton btnMiperfil;

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
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
		panelMenuNavegacion.setBounds(0, 0, 195, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setForeground(new Color(0, 0, 0));
		panelTituloMenu.setBackground(new Color(0, 0, 0));
		panelTituloMenu.setBounds(0, 0, 198, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setForeground(new Color(255, 255, 255));
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 194, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnAltaLugar = new JButton("Dar de alta un Lugar");
		btnAltaLugar.setBorderPainted(false);
		btnAltaLugar.setBackground(new Color(230, 230, 250));
		btnAltaLugar.setForeground(new Color(0, 0, 128));
		btnAltaLugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaLugar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAltaLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 17);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnAltaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLugar.setBounds(0, 39, 198, 40);
		panelMenuNavegacion.add(btnAltaLugar);
		
		btnAltaLibro = new JButton("Dar de baja un Lugar");
		btnAltaLibro.setBorderPainted(false);
		btnAltaLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnAltaLibro.setBackground(new Color(230, 230, 250));
		btnAltaLibro.setForeground(new Color(0, 0, 128));	
		btnAltaLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 19);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.setBounds(0, 79, 209, 40);
		panelMenuNavegacion.add(btnAltaLibro);
		
		btnBajaLugar = new JButton("Dar de alta un Libro");
		btnBajaLugar.setBorderPainted(false);
		btnBajaLugar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLugar.setBackground(new Color(230, 230, 250));
		btnBajaLugar.setForeground(new Color(0, 0, 128));
		btnBajaLugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBajaLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 16);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAltaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.setBounds(0, 119, 198, 40);
		panelMenuNavegacion.add(btnBajaLugar);
		
		btnBajaLibro = new JButton("Dar de baja un Libro");
		btnBajaLibro.setBorderPainted(false);
		btnBajaLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLibro.setBackground(new Color(230, 230, 250));
		btnBajaLibro.setForeground(new Color(0, 0, 128));
		btnBajaLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBajaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 18);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.setBounds(0, 159, 198, 40);
		panelMenuNavegacion.add(btnBajaLibro);
		
		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.setBorderPainted(false);
		btnEnviarMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		btnEnviarMensaje.setBackground(new Color(230, 230, 250));
		btnEnviarMensaje.setForeground(new Color(0, 0, 128));
		btnEnviarMensaje.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 15);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color(230, 230, 250));
			}
		});
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color(230, 230, 250));
			}
		});
		btnEnviarMensaje.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnEnviarMensaje);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(19, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		btnMiperfil.setBounds(0, 621, 195, 42);
		contentPane.add(btnMiperfil);

		JLabel lblNewLabel_1 = new JLabel("Baja Lugares");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(461, 35, 221, 39);
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
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(301, 216, 112, 20);
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
	}
}
