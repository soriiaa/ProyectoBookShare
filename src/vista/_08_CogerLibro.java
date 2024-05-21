/**
 * @author Alejandro
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
import java.util.ArrayList;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _08_CogerLibro extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JButton btnReiniciarBusqueda;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	private JTextField txtBuscadorGenero;
	private JTextField txtBuscadorLugar;
	private JButton btnGuardarYSalir;
	private JTable tablaLibros;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;
	private JButton btnMiperfil;
	private JButton btnBandejaDeEntrada;
	private String[][] arrayLibrosIdTituloGeneroLugar;
	private JButton btnBuscarPorTitulo;
	private JButton btnBuscarPorLugar;
	private JButton btnBuscarPorGénero;
	private JTextField txtUsuario;
	private JTextField txtBuscadorTitulo;
	private String valorSeleccionado;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _08_CogerLibro() {
		initialize();
	}

	private void initialize() {
		
		miModelo = new Modelo();
		arrayLibrosIdTituloGeneroLugar = miModelo.cogerLibroBaseDatos();
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(230, 230, 250));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setForeground(new Color(0, 0, 0));
		panelTituloMenu.setBackground(new Color(0, 0, 0));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setForeground(new Color(255, 255, 255));
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBorderPainted(false);
		btnCogerLibro.setBackground(new Color(230, 230, 250));
		btnCogerLibro.setForeground(new Color(0, 0, 128));
		btnCogerLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 8);
			}
		});
		
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color (220, 220, 220));
				btnCogerLibro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 250));
				btnGuardarYSalir.setBackground(new Color(0, 0, 0));
				btnReiniciarBusqueda.setBackground(new Color(0, 0, 0));
				btnBuscarPorTitulo.setBackground(new Color(170, 208, 255));
				btnBuscarPorLugar.setBackground(new Color(170, 208, 255));
				btnBuscarPorGénero.setBackground(new Color(170, 208, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocus();
			}
		});
		
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setBorderPainted(false);
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(230, 230, 250));
		btnDejarUnLibro.setForeground(new Color(0, 0, 128));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDejarUnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 9);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCogerLibro.setBackground(new Color(230, 230, 250));
				btnDejarUnLibro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnCogerLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
			}
		});
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(230, 230, 250));
		btnDarDeAlta.setForeground(new Color(0, 0, 128));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 7);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDejarUnLibro.setBackground(new Color(230, 230, 250));
				btnDarDeAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnDejarUnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
			}
		});
		btnDarDeAlta.setBounds(0, 119, 195, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setBorderPainted(false);
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(230, 230, 250));
		btnFaq.setForeground(new Color(0, 0, 128));
		btnFaq.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 11);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(230, 230, 250));
				btnFaq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
			}
		});
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setBorderPainted(false);
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(230, 230, 250));
		btnHistorialLibros.setForeground(new Color(0, 0, 128));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHistorialLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 10);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(230, 230, 250));
				btnHistorialLibros.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
			}
		});
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
		
		btnBandejaDeEntrada = new JButton("Bandeja de Entrada");
		btnBandejaDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		btnBandejaDeEntrada.setForeground(new Color(0, 0, 128));
		btnBandejaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBandejaDeEntrada.setBorderPainted(false);
		btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));		
		btnBandejaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 13);
			}
		});
		// Esta parte del codigo sirve para cambiar el color del boton al pasar por encima y ademas cambiar el anterior a su color 
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorialLibros.setBackground(new Color(230, 230, 250));
				btnBandejaDeEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnHistorialLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color (220, 220, 220));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBandejaDeEntrada.setBackground(new Color(230, 230, 250));
			}
		});
		btnBandejaDeEntrada.setBounds(0, 237, 198, 40);
		panelMenuNavegacion.add(btnBandejaDeEntrada);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBorderPainted(false);
		btnMiperfil.setBackground(new Color(230, 230, 250));
		btnMiperfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 12);
			}
		});
		btnMiperfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color (220, 220, 220));
				btnMiperfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiperfil.setBackground(new Color(230, 230, 250));
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);

		lblTitulo = new JLabel("Coger un libro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblTitulo.setBounds(357, 10, 441, 119);
		getContentPane().add(lblTitulo);

		txtBuscadorTitulo = new JTextField();
		txtBuscadorTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.comprobarCamposLogin();
			}
		});

		txtBuscadorTitulo.setBounds(364, 182, 117, 29);
		contentPane.add(txtBuscadorTitulo);
		txtBuscadorTitulo.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtBuscadorTitulo, "Título");
		txtBuscadorTitulo.addFocusListener(focusListener);
		txtBuscadorTitulo.setText("Título");
		txtBuscadorTitulo.addFocusListener(new PlaceholderFocusListener(txtBuscadorTitulo, "Título"));
		txtBuscadorTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscadorTitulo.setForeground(Color.GRAY);
		txtBuscadorTitulo.setBorder(null);
		txtBuscadorTitulo.setBorder(BorderFactory.createCompoundBorder(txtBuscadorTitulo.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtBuscadorTitulo.setColumns(10);
		
		txtBuscadorTitulo.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        if ("Título".equals(txtBuscadorTitulo.getText())) {
		        	txtBuscadorTitulo.setForeground(Color.GRAY);
		        } else {
		        	txtBuscadorTitulo.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        if (txtBuscadorTitulo.getText().isEmpty()) {
		        	txtBuscadorTitulo.setForeground(Color.GRAY);
		        }
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {}
		});
		
		contentPane.add(txtBuscadorTitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 260, 430, 346);
		getContentPane().add(scrollPane);
		
		tablaLibros = new JTable() {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		tablaLibros.setRowHeight(25);
		tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		System.out.println("Tabla actualizada");
		
		String[][] titulos = new String [arrayLibrosIdTituloGeneroLugar.length][1];
		String[] columnas = {"Libros"};
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			titulos[i][0] = arrayLibrosIdTituloGeneroLugar[i][1];
		}
		
		tablaLibros.setModel(new DefaultTableModel(titulos, columnas));
		scrollPane.setViewportView(tablaLibros);
		
		
		
		tablaLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
            	
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tablaLibros.getSelectedRow();
                    int selectedColumn = tablaLibros.getSelectedColumn();
                    if (selectedRow != -1 && selectedColumn != -1) {
                        valorSeleccionado = tablaLibros.getValueAt(selectedRow, selectedColumn).toString();
                        System.out.println("Valor seleccionado: " + valorSeleccionado);
                    }
                }
            }
        });
		
		txtBuscadorGenero = new JTextField();
		txtBuscadorGenero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtBuscadorGenero.setText("Género");
		txtBuscadorGenero.setForeground(Color.GRAY);
		txtBuscadorGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscadorGenero.setColumns(10);
		txtBuscadorGenero.setBorder(null);
		txtBuscadorGenero.setBackground(Color.LIGHT_GRAY);
		txtBuscadorGenero.setBounds(677, 182, 117, 29);
		focusListener = new PlaceholderFocusListener(txtBuscadorGenero, "Género");
		txtBuscadorGenero.addFocusListener(focusListener);
		txtBuscadorGenero.addFocusListener(new PlaceholderFocusListener(txtBuscadorGenero, "Género"));
		txtBuscadorGenero.setBorder(BorderFactory.createCompoundBorder(txtBuscadorGenero.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtBuscadorGenero);

		txtBuscadorGenero.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Género".equals(txtBuscadorGenero.getText())) {
					txtBuscadorGenero.setForeground(Color.GRAY);
				} else {
					txtBuscadorGenero.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtBuscadorGenero.getText().isEmpty()) {
					txtBuscadorGenero.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		getContentPane().add(txtBuscadorGenero);

		txtBuscadorLugar = new JTextField();
		txtBuscadorLugar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				miControlador.camposRellenados();
			}
		});
		txtBuscadorLugar.setText("Lugar");
		txtBuscadorLugar.setForeground(Color.GRAY);
		txtBuscadorLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscadorLugar.setColumns(10);
		txtBuscadorLugar.setBorder(null);
		txtBuscadorLugar.setBackground(Color.LIGHT_GRAY);
		txtBuscadorLugar.setBounds(520, 182, 117, 29);
		focusListener = new PlaceholderFocusListener(txtBuscadorLugar, "Lugar");
		txtBuscadorLugar.addFocusListener(focusListener);
		txtBuscadorLugar.addFocusListener(new PlaceholderFocusListener(txtBuscadorLugar, "Lugar"));
		txtBuscadorLugar.setBorder(BorderFactory.createCompoundBorder(txtBuscadorLugar.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtBuscadorLugar);

		txtBuscadorLugar.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Lugar".equals(txtBuscadorLugar.getText())) {
					txtBuscadorLugar.setForeground(Color.GRAY);
				} else {
					txtBuscadorLugar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtBuscadorLugar.getText().isEmpty()) {
					txtBuscadorLugar.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.setForeground(new Color(255, 255, 255));
		btnGuardarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardarYSalir.setBackground(new Color(70, 70, 70));
				btnGuardarYSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				miModelo.libroNoDisponible(valorSeleccionado);
				arrayLibrosIdTituloGeneroLugar = miModelo.cogerLibroBaseDatos();
				actualizarTabla();
				
			}
		});
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscadorLugar.setText("Lugar");
				txtBuscadorGenero.setText("Género");
				txtBuscadorTitulo.setText("Título");
			}
		});
		btnGuardarYSalir.setBackground(new Color(0, 0, 0));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardarYSalir.setBounds(843, 611, 133, 42);
		btnGuardarYSalir.setBorder(null);
		getContentPane().add(btnGuardarYSalir);

		btnReiniciarBusqueda = new JButton("Reiniciar Búsqueda");
		btnReiniciarBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReiniciarBusqueda.setBackground(new Color(70, 70, 70));
				btnReiniciarBusqueda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscadorTitulo.setText("Título");
				txtBuscadorLugar.setText("Lugar");
				txtBuscadorGenero.setText("Género");
				
				actualizarTabla();
			}
		});
		btnReiniciarBusqueda.setForeground(new Color(255, 255, 255));
		btnReiniciarBusqueda.setBounds(804, 182, 117, 29);
		btnReiniciarBusqueda.setBorder(null);
		btnReiniciarBusqueda.setBackground(new Color(0, 0, 0));
		getContentPane().add(btnReiniciarBusqueda);
		
		btnBuscarPorTitulo = new JButton("Buscar por Título");
		btnBuscarPorTitulo.setBackground(new Color(170, 208, 255));
		btnBuscarPorTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tituloBuscado = txtBuscadorTitulo.getText();
				actualizarTablaPorTitulo(tituloBuscado);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorTitulo.setBackground(new Color(98, 169, 255));
				btnBuscarPorTitulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnBuscarPorTitulo.setBounds(364, 221, 117, 29);
		btnBuscarPorTitulo.setBorder(null);
		contentPane.add(btnBuscarPorTitulo);
		
		btnBuscarPorLugar = new JButton("Buscar por Lugar");
		btnBuscarPorLugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorLugar.setBackground(new Color(98, 169, 255));
				btnBuscarPorLugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnBuscarPorLugar.setBackground(new Color(170, 208, 255));
		btnBuscarPorLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lugarBuscado = txtBuscadorLugar.getText();
				actualizarTablaPorLugar(lugarBuscado);
			}
		});
		btnBuscarPorLugar.setBorder(null);
		btnBuscarPorLugar.setBounds(520, 221, 117, 29);
		contentPane.add(btnBuscarPorLugar);
		
		btnBuscarPorGénero = new JButton("Buscar por Género");
		btnBuscarPorGénero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarPorGénero.setBackground(new Color(98, 169, 255));
				btnBuscarPorGénero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnBuscarPorGénero.setBackground(new Color(170, 208, 255));
		btnBuscarPorGénero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String generoBuscado = txtBuscadorGenero.getText();
				actualizarTablaPorGenero(generoBuscado);
			}
		});
		btnBuscarPorGénero.setBorder(null);
		btnBuscarPorGénero.setBounds(677, 221, 117, 29);
		contentPane.add(btnBuscarPorGénero);
		
		

	}
	
	public void actualizarTabla() {
		
		System.out.println("Tabla actualizada");
		
		String[][] titulos = new String [arrayLibrosIdTituloGeneroLugar.length][1];
		String[] columnas = {"Libros"};
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			titulos[i][0] = arrayLibrosIdTituloGeneroLugar[i][1];
		}
		
		tablaLibros.setModel(new DefaultTableModel(titulos, columnas));
	}
	
	public void actualizarTablaPorTitulo(String titulo) {
		
		System.out.println("Tabla actualizada por título");
		String[][] titulos = new String [arrayLibrosIdTituloGeneroLugar.length][1];
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			titulos[i][0] = arrayLibrosIdTituloGeneroLugar[i][1];
		}
		
		ArrayList<String> listaTitulosBuscados = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (titulos[i][0].equalsIgnoreCase(titulo)) {
				listaTitulosBuscados.add(titulos[i][0]);
			}
		}
		
		String[][] titulosBuscadosPorTitulo = new String[listaTitulosBuscados.size()][1];
		
		for (int i = 0; i < listaTitulosBuscados.size(); i++) {
			titulosBuscadosPorTitulo[i][0] = listaTitulosBuscados.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorTitulo, columnas));
	}
	
	public void actualizarTablaPorLugar(String lugarBuscado) {
		
		System.out.println("Tabla actualizada por lugar");
		
		ArrayList<String> listaTitulosPorLugar = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (arrayLibrosIdTituloGeneroLugar[i][2].equalsIgnoreCase(lugarBuscado)) {
				listaTitulosPorLugar.add(arrayLibrosIdTituloGeneroLugar[i][1]);
			}
		}
		
		String[][] titulosBuscadosPorLugar = new String[listaTitulosPorLugar.size()][1];
		
		for (int i = 0; i < listaTitulosPorLugar.size(); i++) {
			titulosBuscadosPorLugar[i][0] = listaTitulosPorLugar.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorLugar, columnas));
		
	}
	
	public void actualizarTablaPorGenero(String generoBuscado) {
		
		System.out.println("Tabla actualizada por género");
		
		ArrayList<String> listaTitulosPorGenero = new ArrayList<>();
		
		for (int i = 0; i < arrayLibrosIdTituloGeneroLugar.length; i++) {
			if (arrayLibrosIdTituloGeneroLugar[i][3].equalsIgnoreCase(generoBuscado)) {
				listaTitulosPorGenero.add(arrayLibrosIdTituloGeneroLugar[i][1]);
			}
		}
		
		String[][] titulosBuscadosPorGenero = new String[listaTitulosPorGenero.size()][1];
		
		for (int i = 0; i < listaTitulosPorGenero.size(); i++) {
			titulosBuscadosPorGenero[i][0] = listaTitulosPorGenero.get(i);
		}
		
		String[] columnas = {"Libros"};
		
		tablaLibros.setModel(new DefaultTableModel(titulosBuscadosPorGenero, columnas));
		
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
