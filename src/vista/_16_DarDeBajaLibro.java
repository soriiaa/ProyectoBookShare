/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusAdapter;

import controlador.Controlador;
import modelo.Modelo;

public class _16_DarDeBajaLibro extends JFrame implements Vista {
	private static final long serialVersionUID = 1L;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table.getSelectionModel().clearSelection();
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

		JLabel lblTitulo = new JLabel("Alta y Baja Libros");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblTitulo.setBounds(357, 10, 486, 119);
		contentPane.add(lblTitulo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 306, 591, 115);
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
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlta.setEnabled(false);
		btnAlta.setForeground(new Color(255, 255, 255));
		btnAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlta.setBackground(new Color(70, 70, 70));
				btnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlta.setBackground(new Color(0, 0, 0));
			}
		});
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addRow(new String [] {txtTitulo.getText(), txtAutor.getText(), txtGenero.getText()});
				miControlador.recogerAltaDatosAltaBajaLibro();
				limpiarCampos();
			}
		});
		btnAlta.setBackground(new Color(0, 0, 0));
		btnAlta.setBorder(null);
		btnAlta.setBounds(358, 547, 103, 44);
		contentPane.add(btnAlta);
		
		//btnBaja
		btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBaja.setEnabled(false);
		btnBaja.setForeground(new Color(255, 255, 255));
		btnBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBaja.setBackground(new Color(70, 70, 70));
				btnBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBaja.setBackground(new Color(0, 0, 0));
			}
		});
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.recogerBajaDatosAltaBajaLibro();
				modelo.removeRow(table.getSelectedRow());
				limpiarCampos();
			}
		});
		btnBaja.setBackground(new Color(0, 0, 0));
		btnBaja.setBorder(null);
		btnBaja.setBounds(569, 546, 103, 44);
		contentPane.add(btnBaja);
		
		// btnModificar
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setEnabled(false);
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setBackground(new Color(70, 70, 70));
				btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setBackground(new Color(0, 0, 0));
			}
		});
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
		btnModificar.setBackground(new Color(0, 0, 0));
		btnModificar.setBorder(null);
		btnModificar.setBounds(791, 547, 103, 44);
		contentPane.add(btnModificar);
		
		JLabel lblTituloLibro = new JLabel("Titulo del Libro:");
		lblTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTituloLibro.setBounds(308, 140, 130, 30);
		contentPane.add(lblTituloLibro);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(381, 162, 387, 29);
		txtTitulo.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtTitulo, "Titulo");
		txtTitulo.addFocusListener(focusListener);
		txtTitulo.setText("Titulo");
		txtTitulo.addFocusListener(new PlaceholderFocusListener(txtTitulo, "Titulo"));
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTitulo.setForeground(Color.GRAY);
		txtTitulo.setBorder(null);
		txtTitulo.setBorder(BorderFactory.createCompoundBorder(txtTitulo.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtTitulo.setColumns(10);

		txtTitulo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Titulo".equals(txtTitulo.getText())) {
					txtTitulo.setForeground(Color.GRAY);
				} else {
					txtTitulo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtTitulo.getText().isEmpty()) {
					txtTitulo.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		txtTitulo.setBounds(448, 142, 436, 30);
		txtTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtTitulo);
		
		txtAutor = new JTextField();
		txtAutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		txtAutor.setBackground(new Color(192, 192, 192));
		txtAutor.setBounds(448, 184, 436, 30);
		focusListener = new PlaceholderFocusListener(txtAutor, "Autor");
		txtAutor.addFocusListener(focusListener);
		txtAutor.setText("Autor");
//		txtAutor.addFocusListener(new PlaceholderFocusListener(txtAutor, "Título"));
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAutor.setForeground(Color.GRAY);
		txtAutor.setBorder(null);
		txtAutor.setBorder(BorderFactory.createCompoundBorder(txtAutor.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtAutor.setColumns(10);

		txtAutor.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Autor".equals(txtAutor.getText())) {
					txtAutor.setForeground(Color.GRAY);
				} else {
					txtAutor.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtAutor.getText().isEmpty()) {
					txtAutor.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		contentPane.add(txtAutor);
		
		JLabel lblAutor = new JLabel("Autor del Libro:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(308, 183, 130, 30);
		contentPane.add(lblAutor);
		
		JLabel lblGenero = new JLabel("Género Literario:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(308, 224, 130, 30);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtGenero, "Genero");
		txtGenero.addFocusListener(focusListener);
		txtGenero.setText("Genero");
//		txtTitulo.addFocusListener(new PlaceholderFocusListener(txtTitulo, "Título"));
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGenero.setForeground(Color.GRAY);
		txtGenero.setBorder(null);
		txtGenero.setBorder(BorderFactory.createCompoundBorder(txtGenero.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtGenero.setColumns(10);

		txtGenero.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Genero".equals(txtGenero.getText())) {
					txtGenero.setForeground(Color.GRAY);
				} else {
					txtGenero.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtGenero.getText().isEmpty()) {
					txtGenero.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		txtGenero.setBounds(448, 224, 436, 30);
		txtGenero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtGenero);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Object[][] datos = miControlador.sacarDatosLibro();
				String[] titulo = {"T\u00EDtulo", "Autor", "G\u00E9nero"};
				modelo = new DefaultTableModel(datos, titulo);
				table.setModel(modelo);
			}
		});
	}
	
	private void updateAlta() {
		if((txtTitulo.getText().length() == 0 || txtTitulo.getText().equals("Titulo")) || (txtAutor.getText().length() == 0 || txtAutor.getText().equals("Autor")) || (txtGenero.getText().length() == 0 || txtGenero.getText().equals("Genero"))) {
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
		if((txtTitulo.getText().length() == 0 || txtTitulo.getText().equals("Titulo")) || (txtAutor.getText().length() == 0 || txtAutor.getText().equals("Autor")) || (txtGenero.getText().length() == 0 || txtGenero.getText().equals("Genero")) || table.getSelectedRow() == -1) {
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
	
	private static class PlaceholderFocusListener implements FocusListener {
		private final JTextField field;
		private final String placeholder;

		public PlaceholderFocusListener(JTextField field, String placeholder) {
			this.field = field;
			this.placeholder = placeholder;
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (field.getText().equals(placeholder)) {
				field.setText("");
				if (field instanceof JPasswordField) {
					((JPasswordField) field).setEchoChar('*'); // Para ocultar los caracteres al escribir
				}
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (field.getText().isEmpty()) {
				field.setText(placeholder);
				if (field instanceof JPasswordField) {
					((JPasswordField) field).setEchoChar((char) 0); // Para que el texto sea visible
				}
			}
		}
	}
}
