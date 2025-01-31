package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainForm extends JFrame{
    MenuPanel  pnlMenu = new MenuPanel();
    JPanel     pnlMain = new MainPanel();
 
    public MainForm(String tilteApp) {
        customizeComponent(tilteApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new MainPanel())); 
        pnlMenu.btnCita.addActionListener(      e -> {
            try {
                setPanel(new CitaPanel());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });  
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
     
    //JOptionPane.showMessageDialog(this, "Seleccionaste Opción 3");

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }   
}