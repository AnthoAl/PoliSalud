package UserInterface.Form;

import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {

    private String usuario;
    private String clave;
    
    public void login() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        frame.add(panel);
    
        JPanel loginPanel = createLoginPanel(frame);
    
        panel.add(loginPanel, "Login");
        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, "Login");
    
        frame.pack();  
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    @SuppressWarnings("Convert2Lambda")
    private JPanel createLoginPanel(JFrame frame) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; 
    
        ImageIcon imageIcon = new ImageIcon(IAStyle.URL_MAIN);
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(imageLabel, gbc);
    
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(IAStyle.FONT); 
        userLabel.setForeground(IAStyle.COLOR_FONT); 
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE; 
        loginPanel.add(userLabel, gbc);
    
        JTextField userText = new JTextField(25); 
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        loginPanel.add(userText, gbc);
    
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(IAStyle.FONT);
        passwordLabel.setForeground(IAStyle.COLOR_FONT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
    
        JPasswordField passwordText = new JPasswordField(25); 
        gbc.gridx = 1;
        loginPanel.add(passwordText, gbc);
    
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(IAStyle.FONT_BOLD);
        loginButton.setCursor(IAStyle.CURSOR_HAND);
        loginButton.setBackground(IAStyle.COLOR_FONT_LIGHT);
        loginButton.setForeground(Color.WHITE); 
        
        loginButton.setPreferredSize(new Dimension(120, 40));  
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; 
        loginPanel.add(loginButton, gbc);
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction(frame, userText, passwordText);
            }
        });

        userText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginAction(frame, userText, passwordText);
                }
            }
        });

        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginAction(frame, userText, passwordText);
                }
            }
        });

        JLabel welcomeLabel = new JLabel("Bienvenido Patmic, su Usuario es patmic y su contraseña es 12345");
        welcomeLabel.setFont(IAStyle.FONT);
        welcomeLabel.setForeground(IAStyle.COLOR_FONT_LIGHT);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST; 
        loginPanel.add(welcomeLabel, gbc);

        return loginPanel;
    }

    private void loginAction(JFrame frame, JTextField userText, JPasswordField passwordText) {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());
        if (user.isEmpty() || password.isEmpty()) {
            IAStyle.showMsgError("Por favor ingrese usuario y contraseña");
        } else if (user.equals("patmic") && password.equals("12345")) {
            frame.setVisible(false); 
            showMainFrame(); 
        } else {
            IAStyle.showMsgError("Usuario o contraseña incorrectos");
        }
    }

    private void showMainFrame() {
        SwingUtilities.invokeLater(() -> {
            MainForm frmMain = new MainForm("POLISALUD");
        });
    }
}
