package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.Controlador;
import modelo.Modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _18_ConfiguracionConexion extends JFrame implements Vista {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtUrl;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel lblUrl;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JButton btnGuardarYSalir;
	private JPanel contentPane;
	private boolean habilitado;
	
	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public String getTxtUrl() {
		return txtUrl.getText();
	}

	public String getTxtUsuario() {
		return txtUsuario.getText();
	}

	public String getTxtContrasena() {
		return txtContrasena.getText();
	}

	public _18_ConfiguracionConexion() {
		
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 299);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardarYSalir.setBackground(new Color(0, 0, 0));
				comprobarCamposRellenos();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblContrasena.requestFocus();
			}
		});
		setLocationRelativeTo(null);
		
		

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsuario.setBounds(39, 41, 100, 23);
		getContentPane().add(lblUsuario);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContrasena.setBounds(39, 109, 114, 23);
		getContentPane().add(lblContrasena);
		
		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUrl.setBounds(39, 174, 100, 23);
		getContentPane().add(lblUrl);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtUsuario.setBounds(162, 41, 234, 23);
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(new Color(200, 200, 200));
		txtUsuario.setBorder(BorderFactory.createCompoundBorder(txtUsuario.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(163, 109, 234, 23);
		txtContrasena.setBorder(null);
		txtContrasena.setBackground(new Color(200, 200, 200));
		txtContrasena.setBorder(BorderFactory.createCompoundBorder(txtContrasena.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtContrasena);
		
		txtUrl = new JTextField();
		txtUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtUrl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCamposRellenos();
			}
		});
		txtUrl.setColumns(10);
		txtUrl.setBounds(162, 174, 234, 23);
		txtUrl.setBorder(null);
		txtUrl.setBackground(new Color(200, 200, 200));
		txtUrl.setBorder(BorderFactory.createCompoundBorder(txtUrl.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtUrl);
		
		btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comprobarCamposRellenos();
				btnGuardarYSalir.setBackground(new Color(70, 70, 70));
				btnGuardarYSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});		
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(18, 3);
			}
		});
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarYSalir.setForeground(new Color(255, 255, 255));
		btnGuardarYSalir.setBackground(new Color(0, 0, 0));
		btnGuardarYSalir.setBounds(318, 221, 114, 31);
		btnGuardarYSalir.setBorder(null);
		contentPane.add(btnGuardarYSalir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
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
				miControlador.modificarDatosConfiguracion();
			}
		});
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(0, 0, 0));
		btnGuardarYSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarYSalir.setBorder(null);
		btnModificar.setBounds(180, 226, 89, 23);
		contentPane.add(btnModificar);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblContrasena.requestFocus();
				comprobarCamposRellenos();
				String[] datos = miControlador.recogerDatosConexion();
				
				txtUsuario.setText(datos[0]);
				txtContrasena.setText(datos[1]);
				txtUrl.setText(datos[2]);
			}
		});
		
	}
	
	public void comprobarCamposRellenos() {
		
		if ((txtUsuario.getText().isEmpty()) || (txtUrl.getText().isEmpty()) ) {
			habilitado = false;
		} else {
			habilitado = true;
		}
		
		if (habilitado == true) {
			btnGuardarYSalir.setBackground(new Color(0, 0, 0));
		} else {
			btnGuardarYSalir.setBackground(new Color(120, 120, 120));
		}	
	}
	
	public void actualizar () {
		String[] datos = miControlador.recogerDatosConexion();	
		txtUsuario.setText(datos[0]);
		txtContrasena.setText(datos[1]);
		txtUrl.setText(datos[2]);
	}
}
