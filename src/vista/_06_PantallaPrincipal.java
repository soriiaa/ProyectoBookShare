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

public class _06_PantallaPrincipal extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImagenPrincipio;
	private JButton btnMiperfil;

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel panelMenuNavegacion;
	private JPanel panelTituloMenu;
	private JLabel lblTituloMenu;
	private JButton btnCogerLibro;
	private JButton btnDejarUnLibro;
	private JButton btnDarDeAlta;
	private JButton btnFaq;
	private JButton btnHistorialLibros;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _06_PantallaPrincipal() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMenuNavegacion = new JPanel();
		panelMenuNavegacion.setBackground(new Color(255, 255, 255));
		panelMenuNavegacion.setBounds(0, 0, 183, 622);
		contentPane.add(panelMenuNavegacion);
		panelMenuNavegacion.setLayout(null);
		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setBackground(new Color(128, 128, 192));
		panelTituloMenu.setBounds(0, 0, 183, 40);
		panelMenuNavegacion.add(panelTituloMenu);
		panelTituloMenu.setLayout(null);
		
		lblTituloMenu = new JLabel("Menu Navegacion");
		lblTituloMenu.setBackground(new Color(255, 255, 255));
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setBounds(0, 0, 183, 40);
		panelTituloMenu.add(lblTituloMenu);
		
		btnCogerLibro = new JButton("Coger un Libro");
		btnCogerLibro.setBackground(new Color(255, 250, 250));
		btnCogerLibro.setForeground(new Color(255, 215, 0));
		btnCogerLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCogerLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnCogerLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCogerLibro.setBounds(0, 39, 183, 40);
		panelMenuNavegacion.add(btnCogerLibro);
		
		btnDejarUnLibro = new JButton("Dejar un Libro");
		btnDejarUnLibro.setHorizontalAlignment(SwingConstants.LEFT);
		btnDejarUnLibro.setBackground(new Color(255, 250, 250));
		btnDejarUnLibro.setForeground(new Color(255, 215, 0));	
		btnDejarUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDejarUnLibro.setBounds(0, 79, 183, 40);
		panelMenuNavegacion.add(btnDejarUnLibro);
		
		btnDarDeAlta = new JButton("Dar de alta un Libro");
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDarDeAlta.setBackground(new Color(255, 250, 250));
		btnDarDeAlta.setForeground(new Color(255, 215, 0));
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarDeAlta.setBounds(0, 119, 183, 40);
		panelMenuNavegacion.add(btnDarDeAlta);
		
		btnFaq = new JButton("FAQ");
		btnFaq.setHorizontalAlignment(SwingConstants.LEFT);
		btnFaq.setBackground(new Color(255, 250, 250));
		btnFaq.setForeground(new Color(255, 215, 0));
		btnFaq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFaq.setBounds(0, 159, 183, 40);
		panelMenuNavegacion.add(btnFaq);
		
		btnHistorialLibros = new JButton("Historial Libros");
		btnHistorialLibros.setHorizontalAlignment(SwingConstants.LEFT);
		btnHistorialLibros.setBackground(new Color(255, 250, 250));
		btnHistorialLibros.setForeground(new Color(255, 215, 0));
		btnHistorialLibros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistorialLibros.setBounds(0, 198, 183, 40);
		panelMenuNavegacion.add(btnHistorialLibros);
				
		btnMiperfil = new JButton("Mi perfil");
		btnMiperfil.setBackground(new Color(128, 128, 192));
		btnMiperfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMiperfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMiperfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiperfil.setBounds(0, 621, 183, 42);
		contentPane.add(btnMiperfil);
		
		lblImagenPrincipio = new JLabel("New label");
		lblImagenPrincipio
				.setIcon(new ImageIcon(_06_PantallaPrincipal.class.getResource("/assets/BookShare_Presentacion3.jpg")));
		lblImagenPrincipio.setBounds(260, 0, 701, 663);
		contentPane.add(lblImagenPrincipio);
	}
}