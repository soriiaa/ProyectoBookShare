/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class _16_DarDeBajaLibro extends JFrame implements Vista {
	private static final long serialVersionUID = 1L;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JTextField txtPorFavorIntroduzca;
	private JTable table;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnAltaLugar;
	private JButton btnAltaLibro;
	private JButton btnBajaLugar;
	private JButton btnBajaLibro;
	private String tituloOriginal;
	
	public String getTituloOriginal() {
		return tituloOriginal;	
	}
	
	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextField getTxtGenero() {
		return txtGenero;
	}

	private JButton btnEnviarMensaje;
	private JButton btnMiperfil;
	private DefaultTableModel modelo;
	private JButton btnAlta, btnBaja, btnModificar;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtGenero;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _16_DarDeBajaLibro() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table.getSelectionModel().clearSelection();
				limpiarCampos();
			}
		});

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

		btnBajaLugar = new JButton("Dar de baja y alta un Lugar");
		btnBajaLugar.setBorderPainted(false);
		btnBajaLugar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLugar.setBackground(new Color(230, 230, 250));
		btnBajaLugar.setForeground(new Color(0, 0, 128));
		btnBajaLugar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBajaLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(16, 17);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por
		// encima y ademas cambiar el anterior a su color
		btnBajaLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLugar.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLugar.setBounds(0, 42, 217, 40);
		panelMenuNavegacion.add(btnBajaLugar);

		btnBajaLibro = new JButton("Dar de baja y alta un Libro");
		btnBajaLibro.setBorderPainted(false);
		btnBajaLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaLibro.setBackground(new Color(230, 230, 250));
		btnBajaLibro.setForeground(new Color(0, 0, 128));
		btnBajaLibro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBajaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(16, 16);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por
		// encima y ademas cambiar el anterior a su color
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
				btnBajaLibro.setBackground(new Color(220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnBajaLibro.setBounds(0, 80, 217, 40);
		panelMenuNavegacion.add(btnBajaLibro);

		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.setBorderPainted(false);
		btnEnviarMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		btnEnviarMensaje.setBackground(new Color(230, 230, 250));
		btnEnviarMensaje.setForeground(new Color(0, 0, 128));
		btnEnviarMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(16, 15);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por
		// encima y ademas cambiar el anterior a su color
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
				btnEnviarMensaje.setBackground(new Color(220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviarMensaje.setBackground(new Color(230, 230, 250));
			}
		});
		btnEnviarMensaje.setBounds(0, 119, 183, 40);
		panelMenuNavegacion.add(btnEnviarMensaje);

		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(16, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(220, 220, 220));
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

		JLabel lblNewLabel_1 = new JLabel("Alta y Baja Libros");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(463, 36, 307, 39);
		contentPane.add(lblNewLabel_1);

		txtPorFavorIntroduzca = new JTextField();
		txtPorFavorIntroduzca.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorFavorIntroduzca.setText(
				"Por favor, introduzca el titulo del libro que desea anular y eliminar del registro del sistema y la informacion del libro que desee dar de alta");
		txtPorFavorIntroduzca.setBounds(235, 105, 741, 42);
		contentPane.add(txtPorFavorIntroduzca);
		txtPorFavorIntroduzca.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 168, 591, 115);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = table.getSelectedRow();
				txtTitulo.setText((String) modelo.getValueAt(fila, 0));
				txtAutor.setText((String) modelo.getValueAt(fila, 1));
				txtGenero.setText((String) modelo.getValueAt(fila, 2));
				updateBaja();
				updateModificar();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		table.setToolTipText("\r\n");
		
		// btnAlta
		btnAlta = new JButton("Alta");
		btnAlta.setEnabled(false);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addRow(new String [] {txtTitulo.getText(), txtAutor.getText(), txtGenero.getText()});
				miControlador.recogerAltaDatosAltaBajaLibro();
				limpiarCampos();
			}
		});
		btnAlta.setBounds(419, 526, 103, 42);
		contentPane.add(btnAlta);
		
		//btnBaja
		btnBaja = new JButton("Baja");
		btnBaja.setBackground(new Color(0, 255, 0));
		btnBaja.setEnabled(false);
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.recogerBajaDatosAltaBajaLibro();
				modelo.removeRow(table.getSelectedRow());
				limpiarCampos();
			}
		});
		btnBaja.setBounds(573, 526, 103, 44);
		contentPane.add(btnBaja);
		
		// btnModificar
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				tituloOriginal = (String) modelo.getValueAt(fila, 0);
				miControlador.recogerModificarDatosAltaBajaLibros();
				modelo.setValueAt(txtTitulo.getText(), fila, 0);
				modelo.setValueAt(txtAutor.getText(), fila, 1);
				modelo.setValueAt(txtGenero.getText(), fila, 2);
				limpiarCampos();
			}
		});
		btnModificar.setBounds(731, 528, 93, 39);
		contentPane.add(btnModificar);
		
		JLabel lblTituloLibro = new JLabel("Titulo del Libro:");
		lblTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloLibro.setBounds(308, 322, 130, 30);
		contentPane.add(lblTituloLibro);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(448, 324, 436, 30);
		txtTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtTitulo);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(448, 377, 436, 30);
		txtAutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtAutor);
		
		JLabel lblAutor = new JLabel("Autor del Libro:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(308, 375, 130, 30);
		contentPane.add(lblAutor);
		
		JLabel lblGenero = new JLabel("Género Literario:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(308, 430, 130, 30);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGenero.setColumns(10);
		txtGenero.setBounds(450, 432, 436, 30);
		txtGenero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtGenero);
		
		JButton btnRefresh = new JButton("Cargar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] datos = miControlador.sacarDatosLibro();
				String[] titulo = {"T\u00EDtulo", "Autor", "G\u00E9nero"};
				modelo = new DefaultTableModel(datos, titulo);
				table.setModel(modelo);
			}
		});
		btnRefresh.setBounds(205, 191, 89, 23);
		contentPane.add(btnRefresh);
	}
	
	private void updateAlta() {
		if(txtTitulo.getText().length() == 0 || txtAutor.getText().length() == 0 || txtGenero.getText().length() == 0) {
			btnAlta.setEnabled(false);
		}else {
			btnAlta.setEnabled(true);
		}	
	}
	
	private void updateBaja() {
		if(table.getSelectedRow() == -1) {
			btnBaja.setEnabled(false);
		}else {
			btnBaja.setEnabled(true);
		}
	}
	
	private void updateModificar() {
		if(txtTitulo.getText().length() == 0 || txtAutor.getText().length() == 0 || txtGenero.getText().length() == 0 || table.getSelectedRow() == -1) {
			btnModificar.setEnabled(false);
		}else {
			btnModificar.setEnabled(true);
		}		
	}
	
	private void limpiarCampos() {
		txtTitulo.setText("");
		txtAutor.setText("");
		txtGenero.setText("");
		updateAlta();
		updateModificar();
		updateBaja();
	}
}
