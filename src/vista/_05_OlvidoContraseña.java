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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controlador.Controlador;
import modelo.Modelo;

public class _05_OlvidoContraseña extends JFrame implements Vista {

	private static final long serialVersionUID = 1L;
	

	private Controlador miControlador;
	private Modelo miModelo;
	
	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtRespuestaSeguridad;
	private JPasswordField pwdNuevaContrasena;
	private JPasswordField pwdConfirmarContrasena;
	private JButton btnVolver;
	private JComboBox comboBoxPreguntaSeguridad;
	private JLabel lblTitulo;
	private JButton btnEnviar;
	private String nuevaContrasena;


	private boolean botonHabilitado;
	private JLabel lblRespuestaContrasena;
	
	public String getNuevaContrasena() {
		return nuevaContrasena;
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _05_OlvidoContraseña() {
		setTitle("BookShare2.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtNombreUsuario.setBounds(26, 75, 169, 29);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener = new PlaceholderFocusListener(txtNombreUsuario, "Nombre de Usuario");
		txtNombreUsuario.addFocusListener(focusListener);
		txtNombreUsuario.setText("Nombre de Usuario");
		txtNombreUsuario.addFocusListener(new PlaceholderFocusListener(txtNombreUsuario, "Nombre de Usuario"));
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setForeground(Color.GRAY);
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setBorder(BorderFactory.createCompoundBorder(txtNombreUsuario.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Nombre de Usuario".equals(txtNombreUsuario.getText())) {
					txtNombreUsuario.setForeground(Color.GRAY);
				} else {
					txtNombreUsuario.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtNombreUsuario.getText().isEmpty()) {
					txtNombreUsuario.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		contentPane.add(txtNombreUsuario);
		
		txtRespuestaSeguridad = new JTextField();
		txtRespuestaSeguridad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
		});
		txtRespuestaSeguridad.setText("Respuesta de Seguridad");
		txtRespuestaSeguridad.setForeground(Color.GRAY);
		txtRespuestaSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRespuestaSeguridad.setColumns(10);
		txtRespuestaSeguridad.setBorder(null);
		txtRespuestaSeguridad.setBackground(Color.LIGHT_GRAY);
		txtRespuestaSeguridad.setBounds(26, 181, 169, 29);
		focusListener = new PlaceholderFocusListener(txtRespuestaSeguridad, "Respuesta de Seguridad");
		txtRespuestaSeguridad.addFocusListener(focusListener);
		txtRespuestaSeguridad.addFocusListener(new PlaceholderFocusListener(txtRespuestaSeguridad, "Respuesta de Seguridad"));
		txtRespuestaSeguridad.setBorder(BorderFactory.createCompoundBorder(txtRespuestaSeguridad.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		contentPane.add(txtRespuestaSeguridad);

		txtRespuestaSeguridad.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Respuesta de Seguridad".equals(txtRespuestaSeguridad.getText())) {
					txtRespuestaSeguridad.setForeground(Color.GRAY);
				} else {
					txtRespuestaSeguridad.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtRespuestaSeguridad.getText().isEmpty()) {
					txtRespuestaSeguridad.setForeground(Color.GRAY);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		pwdNuevaContrasena = new JPasswordField();
		pwdNuevaContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
		});
		pwdNuevaContrasena.setBounds(246, 75, 169, 29);
		contentPane.add(pwdNuevaContrasena);
		pwdNuevaContrasena.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener1 = new PlaceholderFocusListener(pwdNuevaContrasena, "Nueva Contraseña");
		pwdNuevaContrasena.addFocusListener(focusListener1);
		pwdNuevaContrasena.setText("Nueva Contraseña");
		pwdNuevaContrasena.addFocusListener(new PlaceholderFocusListener(pwdNuevaContrasena, "Nueva Contraseña"));
		pwdNuevaContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdNuevaContrasena.setForeground(Color.GRAY);
		pwdNuevaContrasena.setBorder(null);
		pwdNuevaContrasena.setBorder(BorderFactory.createCompoundBorder(pwdNuevaContrasena.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		pwdNuevaContrasena.setColumns(10);
		pwdNuevaContrasena.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Nueva Contraseña".equals(new String(pwdNuevaContrasena.getPassword()))) {
					pwdNuevaContrasena.setForeground(Color.GRAY);
				} else {
					pwdNuevaContrasena.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (new String(pwdNuevaContrasena.getPassword()).isEmpty()) {
		            pwdNuevaContrasena.setForeground(Color.GRAY);
		        }
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		pwdNuevaContrasena.getDocument().addDocumentListener(new DocumentListener() {
            private void updateEchoChar() {
                String password = new String(pwdNuevaContrasena.getPassword());
                if ("Nueva Contraseña".equals(password)) {
                    pwdNuevaContrasena.setEchoChar((char) 0); // Mostrar texto
                } else {
                    pwdNuevaContrasena.setEchoChar('*'); // Ocultar texto
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEchoChar();
            }
        });

		contentPane.add(pwdNuevaContrasena);
		
		pwdConfirmarContrasena = new JPasswordField();
		pwdConfirmarContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				comprobarCampos();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				comprobarCampos();
			}
		});
		pwdConfirmarContrasena.setBounds(246, 130, 169, 29);
		pwdConfirmarContrasena.setBackground(new Color(192, 192, 192));
		PlaceholderFocusListener focusListener2 = new PlaceholderFocusListener(pwdConfirmarContrasena, "Confirmar Contraseña");
		pwdConfirmarContrasena.addFocusListener(focusListener2);
		pwdConfirmarContrasena.setText("Confirmar Contraseña");
		pwdConfirmarContrasena.addFocusListener(new PlaceholderFocusListener(pwdConfirmarContrasena, "Confirmar Contraseña"));
		pwdConfirmarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdConfirmarContrasena.setForeground(Color.GRAY);
		pwdConfirmarContrasena.setBorder(null);
		pwdConfirmarContrasena.setBorder(BorderFactory.createCompoundBorder(pwdConfirmarContrasena.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		pwdConfirmarContrasena.setColumns(10);
		pwdConfirmarContrasena.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if ("Confirmar Contraseña".equals(new String(pwdConfirmarContrasena.getPassword()))) {
					pwdConfirmarContrasena.setForeground(Color.GRAY);
				} else {
					pwdConfirmarContrasena.setForeground(Color.BLACK);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (new String(pwdConfirmarContrasena.getPassword()).isEmpty()) {
					pwdConfirmarContrasena.setForeground(Color.GRAY);
		        }
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		pwdConfirmarContrasena.getDocument().addDocumentListener(new DocumentListener() {
            private void updateEchoChar() {
                String password = new String(pwdConfirmarContrasena.getPassword());
                if ("Confirmar Contraseña".equals(password)) {
                	pwdConfirmarContrasena.setEchoChar((char) 0); // Mostrar texto
                } else {
                	pwdConfirmarContrasena.setEchoChar('*'); // Ocultar texto
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEchoChar();
            }
        });
		
		pwdConfirmarContrasena.getDocument().addDocumentListener(new DocumentListener() {
            private void updateEchoChar() {
                String password = new String(pwdConfirmarContrasena.getPassword());
                if ("Confirmar Contraseña".equals(password)) {
                	pwdConfirmarContrasena.setEchoChar((char) 0); // Mostrar texto
                } else {
                	pwdConfirmarContrasena.setEchoChar('*'); // Ocultar texto
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEchoChar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEchoChar();
            }
        });

		contentPane.add(pwdConfirmarContrasena);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String devolucionContrasena = miControlador.comprobarRespuestaSeguridad(miControlador.cogerPreguntaSeguridad(), comboBoxPreguntaSeguridad.getSelectedItem().toString(), txtRespuestaSeguridad.getText(), new String(pwdNuevaContrasena.getPassword()), txtNombreUsuario.getText());
				
				if (devolucionContrasena.equals("No es tu pregunta de seguridad.")) {
					lblRespuestaContrasena.setText("Pregunta o usario incorrectos.");
					lblRespuestaContrasena.setForeground(new Color(0, 255, 255));
					lblRespuestaContrasena.setVisible(true);
				} else if (devolucionContrasena.equals("Respuesta Incorrecta.")) {
					lblRespuestaContrasena.setText("Respuesta Incorrecta");
					lblRespuestaContrasena.setForeground(new Color(255, 0, 0));
					lblRespuestaContrasena.setVisible(true);
				} else {
					lblRespuestaContrasena.setText("Contraseña cambiada con éxito.");
					lblRespuestaContrasena.setForeground(new Color(0, 255, 0));
					lblRespuestaContrasena.setVisible(true);
				}
				
				
			}
		});
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if (botonHabilitado) {
					btnEnviar.setBackground(new Color (70, 70, 70));
					btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				
			}
		});	
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 0, 0));
				btnVolver.setBackground(new Color(0, 0, 0));
				comprobarCampos();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitulo.requestFocus();
			}
		});
		btnEnviar.setBorder(null);
		btnEnviar.setBackground(new Color(0, 0, 0));
		btnEnviar.setBounds(266, 223, 89, 29);
		contentPane.add(btnEnviar);

		

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBorder(null);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(5, 1);
			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolver.setBackground(new Color (70, 70, 70));
				btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});	
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolver.setBackground(new Color(0, 0, 0));
			}
		});
		btnVolver.setBorder(null);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setBounds(88, 223, 89, 29);
		contentPane.add(btnVolver);
		
		lblTitulo = new JLabel("Recuperación Contraseña");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(46, 10, 343, 48);
		contentPane.add(lblTitulo);
		
		lblRespuestaContrasena = new JLabel("New label");
		lblRespuestaContrasena.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRespuestaContrasena.setBounds(246, 186, 169, 23);
		contentPane.add(lblRespuestaContrasena);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				lblRespuestaContrasena.setVisible(false);
				
				comprobarCampos();
				
				comboBoxPreguntaSeguridad = new JComboBox();
				comboBoxPreguntaSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 10));
				
				String[][] codigoPreguntasRecuperacionArray = miControlador.cogerPreguntaSeguridad();
				String[] preguntasRecuperacionArray = new String[3];
				
				for (int i = 0; i < 3; i++) {
					preguntasRecuperacionArray[i] = codigoPreguntasRecuperacionArray[i][1];
				}
				
				String opcion1 = preguntasRecuperacionArray[0];
				String opcion2 = preguntasRecuperacionArray[1];
				String opcion3 = preguntasRecuperacionArray[2];
				
				comboBoxPreguntaSeguridad.setModel(new DefaultComboBoxModel(new String[] {"Pregunta de Seguridad", opcion1, opcion2, opcion3}));
				comboBoxPreguntaSeguridad.setBounds(26, 130, 169, 29);
				comboBoxPreguntaSeguridad.setBorder(null);
				comboBoxPreguntaSeguridad.setBackground(new Color(255, 255, 255));
				contentPane.add(comboBoxPreguntaSeguridad);
				
				lblTitulo.requestFocus();
				
				String password = new String(pwdNuevaContrasena.getPassword());
                if ("Nueva Contraseña".equals(password)) {
                    pwdNuevaContrasena.setEchoChar((char) 0); // Mostrar texto
                } else {
                    pwdNuevaContrasena.setEchoChar('*'); // Ocultar texto
                }
                
                String password2 = new String(pwdConfirmarContrasena.getPassword());
                if ("Confirmar Contraseña".equals(password2)) {
                	pwdConfirmarContrasena.setEchoChar((char) 0); // Mostrar texto
                } else {
                	pwdConfirmarContrasena.setEchoChar('*'); // Ocultar texto
                }
                
                comboBoxPreguntaSeguridad.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (comboBoxPreguntaSeguridad.getSelectedIndex() == 0) {
                        	comboBoxPreguntaSeguridad.setSelectedIndex(-1); // Deselect the "Elige la pregunta" option
                        }
                    }
                });
                
			}
		});
		
	}
	
	public void comprobarCampos() {
		
		String pwdNuevaContrasena2 = new String(pwdNuevaContrasena.getPassword());
		String pwdConfirmarContrasena2 = new String(pwdConfirmarContrasena.getPassword());
		
		if ((txtNombreUsuario.getText().isEmpty() || txtNombreUsuario.getText().equals("Nombre de Usuario")) || (txtRespuestaSeguridad.getText().isEmpty() || txtRespuestaSeguridad.getText().equals("Respuesta de Seguridad")) || (new String(pwdNuevaContrasena.getPassword()).isEmpty() || new String(pwdNuevaContrasena.getPassword()).equals("Nueva Contraseña") || (new String(pwdConfirmarContrasena.getPassword()).isEmpty() || new String(pwdConfirmarContrasena.getPassword()).equals("Confirmar Contraseña")) || (comboBoxPreguntaSeguridad.getSelectedItem() == null || comboBoxPreguntaSeguridad.getSelectedItem().toString().equals("Pregunta de Seguridad")) || (!pwdNuevaContrasena2.equals(pwdConfirmarContrasena2)))) {
			botonHabilitado = false;
			
			if (!pwdNuevaContrasena2.equals(pwdConfirmarContrasena2)) {
				lblRespuestaContrasena.setText("Las contraseñas deben coincidir.");
				lblRespuestaContrasena.setForeground(new Color(0, 0, 0));
				lblRespuestaContrasena.setVisible(true);
			} else {
				lblRespuestaContrasena.setText("");
				lblRespuestaContrasena.setVisible(false);
			}
			
		} else {
			botonHabilitado = true;
			btnEnviar.setBackground(new Color(0, 0, 0));
			btnEnviar.setEnabled(true);
		}
		
		if (botonHabilitado == false) {
			btnEnviar.setBackground(new Color(144, 144, 144));
			btnEnviar.setEnabled(false);
		} 
		
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
