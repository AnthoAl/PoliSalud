package UserInterface.Form;

import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginPanel extends JPanel {

        private String usuario;
        private String clave;
        
        public void login() {
            JFrame frame = new JFrame("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400); // Tamaño aumentado
            frame.setLocationRelativeTo(null);
    
            JPanel panel = new JPanel();
            panel.setLayout(new CardLayout());
            frame.add(panel);
    
            JPanel loginPanel = createLoginPanel(frame);
           
    
            panel.add(loginPanel, "Login");
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Login");
    
            frame.setVisible(true);
        }
    
        @SuppressWarnings("Convert2Lambda")
        private JPanel createLoginPanel(JFrame frame) {
            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.CENTER; // Alinea los componentes al centro
    
            // Imagen
            ImageIcon imageIcon = new ImageIcon(IAStyle.URL_MAIN);
            JLabel imageLabel = new JLabel(imageIcon);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loginPanel.add(imageLabel, gbc);
    
            // Usuario
            JLabel userLabel = new JLabel("Usuario:");
            userLabel.setFont(IAStyle.FONT); // Aplicar fuente personalizada
            userLabel.setForeground(IAStyle.COLOR_FONT); // Aplicar color de texto
            gbc.gridwidth = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE; // Sin relleno
            loginPanel.add(userLabel, gbc);
    
            JTextField userText = new JTextField(25); // Aumenta el tamaño del campo
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Rellenar horizontalmente
            loginPanel.add(userText, gbc);
    
            // Contraseña
            JLabel passwordLabel = new JLabel("Contraseña:");
            passwordLabel.setFont(IAStyle.FONT);
            passwordLabel.setForeground(IAStyle.COLOR_FONT);
            gbc.gridx = 0;
            gbc.gridy = 2;
            loginPanel.add(passwordLabel, gbc);
    
            JPasswordField passwordText = new JPasswordField(25); // Aumenta el tamaño del campo
            gbc.gridx = 1;
            loginPanel.add(passwordText, gbc);
    
            // Botones
            JButton loginButton = new JButton("Entrar");
            loginButton.setFont(IAStyle.FONT_BOLD);
            loginButton.setCursor(IAStyle.CURSOR_HAND);
            loginButton.setBackground(IAStyle.COLOR_FONT_LIGHT); // Color de fondo
            loginButton.setForeground(Color.WHITE); // Color del texto
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            loginPanel.add(loginButton, gbc);
    
            // Acción del botón de login
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String user = userText.getText();
                    String password = new String(passwordText.getPassword());
                    if (user.equals("patmic") && password.equals("12345")) {
                        frame.setVisible(false); // Oculta la ventana de login
                        showMainFrame(); // Muestra la ventana principal
                    } else {
                        IAStyle.showMsgError("Usuario o contraseña incorrectos");
                    }
                }
            });

    
            return loginPanel;
        }
    
        
        private void showMainFrame() {
            SwingUtilities.invokeLater(() -> {
                MainForm frmMain = new MainForm("POLISALUD");
            });
        }
        
    }