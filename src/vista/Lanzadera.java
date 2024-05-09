package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class Lanzadera extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

	public static void main(String[] args) {
		Lanzadera frame = new Lanzadera();
		frame.setVisible(true);
	}

	public Lanzadera() {
		setResizable(false);
		setTitle("Bookshare 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 154, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Pantalla Inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 0);
			}
		});
		btnNewButton.setBounds(10, 79, 135, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Pagina Principal Sin Log");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 3);
			}
		});
		btnNewButton_1.setBounds(155, 79, 220, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Buscar Por Localidad");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 2);
			}
		});
		btnNewButton_2.setBounds(386, 79, 171, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 1);
			}
		});
		btnNewButton_3.setBounds(567, 79, 89, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Register");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 4);
			}
		});
		btnNewButton_4.setBounds(666, 79, 115, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Olvido Contraseña");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 5);
			}
		});
		btnNewButton_5.setBounds(10, 149, 142, 26);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Pantalla Principal");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 6);
			}
		});
		btnNewButton_6.setBounds(162, 149, 135, 25);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Alta Libro");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 7);
			}
		});
		btnNewButton_7.setBounds(307, 151, 109, 23);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Coger Libro");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 8);
			}
		});
		btnNewButton_8.setBounds(426, 151, 135, 23);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Dejar Libro");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 9);
			}
		});
		btnNewButton_9.setBounds(571, 151, 109, 23);
		contentPane.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Historial Libros");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 10);
			}
		});
		btnNewButton_10.setBounds(10, 245, 142, 23);
		contentPane.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("FAQ");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 18);
			}
		});
		btnNewButton_11.setBounds(690, 152, 115, 23);
		contentPane.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("Mi perfil");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 12);
			}
		});
		btnNewButton_12.setBounds(162, 245, 135, 23);
		contentPane.add(btnNewButton_12);

		JButton btnNewButton_14 = new JButton("Bandeja de Entrada");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 13);
			}
		});
		btnNewButton_14.setBounds(307, 245, 162, 23);
		contentPane.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Pantalla Principal Admin");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 14);
			}
		});
		btnNewButton_15.setBounds(479, 245, 218, 23);
		contentPane.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("Enviar Mensaje");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 15);
			}
		});
		btnNewButton_16.setBounds(10, 329, 142, 23);
		contentPane.add(btnNewButton_16);

		JButton btnNewButton_18 = new JButton("Alta Libro");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 16);
			}
		});
		btnNewButton_18.setBounds(164, 329, 114, 23);
		contentPane.add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("Alta Lugar");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 17);
			}
		});
		btnNewButton_19.setBounds(288, 329, 135, 23);
		contentPane.add(btnNewButton_19);

		JButton btnNewButton_20 = new JButton("Baja Libro");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 18);
			}
		});
		btnNewButton_20.setBounds(433, 329, 161, 23);
		contentPane.add(btnNewButton_20);

		JButton btnNewButton_21 = new JButton("Baja Lugar");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(20, 19);
			}
		});
		btnNewButton_21.setBounds(604, 329, 142, 23);
		contentPane.add(btnNewButton_21);
	}
}
