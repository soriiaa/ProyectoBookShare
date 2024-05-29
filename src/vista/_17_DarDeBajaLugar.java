/**
 * @author Apa
 */

package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import controlador.Controlador;
import modelo.Modelo;

public class _17_DarDeBajaLugar extends JFrame implements Vista {
	private static final long serialVersionUID = 1L;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
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
	private DefaultTableModel modelo;
	private JButton btnAlta, btnBaja, btnModificar;
	private JTextField txtNombre;
	private JTextField txtCodigoPostal;
	private JButton btnRefresh;
	private int codPostalAntiguo;

	public int getCodPostalAntiguo() {
		return codPostalAntiguo;
	}

	public JTextField getNombre() {
		return txtNombre;
	}

	public JTextField getTxtCodigoPostal() {
		return txtCodigoPostal;
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _17_DarDeBajaLugar() {
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
				miControlador.cambiarVentana(17, 16);
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
				miControlador.cambiarVentana(17, 16);
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
				miControlador.cambiarVentana(17, 15);
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
				miControlador.cambiarVentana(17, 12);
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

		JLabel lblNewLabel_1 = new JLabel("Alta y Baja Lugares");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(316, 11, 542, 115);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(300, 313, 591, 115);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = table.getSelectedRow();
				txtNombre.setText((String) modelo.getValueAt(fila, 0));
				txtCodigoPostal.setText(String.valueOf(modelo.getValueAt(fila, 1)));
				updateBaja();
				updateModificar();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		table.setToolTipText("\r\n");

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
				modelo.addRow(new String[] { txtNombre.getText(), txtCodigoPostal.getText()});
				miControlador.recogerInfoBajaAltaLugaresParaInsert();
				limpiarCampos();
			}
		});
		btnAlta.setBackground(new Color(0, 0, 0));
		btnAlta.setBorder(null);
		btnAlta.setBounds(354, 546, 103, 44);
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
				miControlador.recogerInfoBajaAltaLugaresParaDelete();
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
				modelo.setValueAt(txtNombre.getText(), fila, 0);
				modelo.setValueAt(txtCodigoPostal.getText(), fila, 1);
				miControlador.recogerInfoBajaAltaLugaresParaUpdate();
				limpiarCampos();
			}
		});
		btnModificar.setBackground(new Color(0, 0, 0));
		btnModificar.setBorder(null);
		btnModificar.setBounds(791, 547, 103, 44);
		contentPane.add(btnModificar);

		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtNombre, "Nombre del Lugar");
		txtNombre.addFocusListener(focusListener);
		txtNombre.setText("Nombre del Lugar");
		txtNombre.addFocusListener(new PlaceholderFocusListener(txtNombre, "Nombre del Lugar"));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setForeground(Color.GRAY);
		txtNombre.setBorder(null);
		txtNombre.setBorder(BorderFactory.createCompoundBorder(txtNombre.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtNombre.setColumns(10);

		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Nombre del Lugar".equals(txtNombre.getText())) {
					txtNombre.setForeground(Color.GRAY);
				} else {
					txtNombre.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtNombre.getText().isEmpty()) {
					txtNombre.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		txtNombre.setBounds(384, 158, 436, 30);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtNombre);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBackground(new Color(192, 192, 192));
		focusListener = new PlaceholderFocusListener(txtCodigoPostal, "Codigo Postal");
		txtCodigoPostal.addFocusListener(focusListener);
		txtCodigoPostal.setText("Codigo Postal");
		txtCodigoPostal.addFocusListener(new PlaceholderFocusListener(txtCodigoPostal, "Codigo Postal"));
		txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoPostal.setForeground(Color.GRAY);
		txtCodigoPostal.setBorder(null);
		txtCodigoPostal.setBorder(BorderFactory.createCompoundBorder(txtCodigoPostal.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtCodigoPostal.setColumns(10);

		txtCodigoPostal.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Codigo Postal".equals(txtCodigoPostal.getText())) {
					txtCodigoPostal.setForeground(Color.GRAY);
				} else {
					txtCodigoPostal.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		txtCodigoPostal.setBounds(384, 216, 436, 30);
		txtCodigoPostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		contentPane.add(txtCodigoPostal);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Object[][] datos = miControlador.sacarLugaresActuales();
				String[] columnas = { "Nombre", "Codigo Postal"};
				modelo = new DefaultTableModel(datos, columnas);
				table.setModel(modelo);
			}
		});
	}

	private void updateAlta() {
		if ((txtNombre.getText().length() == 0 || txtNombre.getText().equals("Nombre del Lugar")) || (txtCodigoPostal.getText().length() == 0 || txtCodigoPostal.getText().equals("Codigo Postal"))) {
			btnAlta.setEnabled(false);
		} else {
			btnAlta.setEnabled(true);
		}
	}

	private void updateBaja() {
		if (table.getSelectedRow() == -1) {
			btnBaja.setEnabled(false);
		} else {
			btnBaja.setEnabled(true);
		}
	}

	private void updateModificar() {
		if (txtNombre.getText().length() == 0 || txtCodigoPostal.getText().length() == 0 || table.getSelectedRow() == -1) {
			btnModificar.setEnabled(false);
		} else {
			btnModificar.setEnabled(true);
		}
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtCodigoPostal.setText("");
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