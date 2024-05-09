/**
 * @author Alejandro
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import controlador.Controlador;
import modelo.Modelo;

public class _00_PantallaInicio extends JFrame implements Vista {

	private JButton btnEmpezar;
	private JLabel lblTitulo;
	private JProgressBar progressBar;
	private JLabel lblImagen;
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

	public _00_PantallaInicio() {
		setResizable(false);
		getContentPane().setBackground(new Color(20, 154, 235));
		setBounds(100, 100, 918, 604);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblTitulo = new JLabel("BookShare 2.0");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblTitulo.setBounds(315, 10, 274, 99);
		getContentPane().add(lblTitulo);

		btnEmpezar = new JButton("EMPEZAR");
		btnEmpezar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer(20, new ActionListener() {
                    int progress = 0;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        progress++;
                        progressBar.setValue(progress);
                        if (progress >= 100) {
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                timer.start();
            }
        });
		btnEmpezar.setBackground(new Color(255, 255, 255));
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnEmpezar.setBounds(364, 483, 175, 53);
		getContentPane().add(btnEmpezar);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(255, 438, 393, 23);
		getContentPane().add(progressBar);
		
		lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(_00_PantallaInicio.class.getResource("/assets/BookShareImagen.png")));
		lblImagen.setBounds(226, 109, 452, 298);
		getContentPane().add(lblImagen);
		
		btnVolverLanzadera = new JButton("Volver a la Lanzadera");
		btnVolverLanzadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(0, 20);
			}
		});
		btnVolverLanzadera.setBounds(0, 0, 175, 28);
		getContentPane().add(btnVolverLanzadera);

	}
}
