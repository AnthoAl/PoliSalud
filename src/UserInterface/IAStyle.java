package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class IAStyle {
    public static final Color COLOR_FONT = new Color(26, 139, 162); //Color para texto
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100); //Color para texto más claro
    public static final Color COLOR_CURSOR = Color.black; //Color del cursor
    public static final Color COLOR_BORDER = Color.lightGray; //Color del borde
    public static final Font  FONT         = new Font("Cascadia Code", Font.PLAIN, 14); //Fuente normal de tamaño 14.
    public static final Font  FONT_BOLD    = new Font("Cascadia Code", Font.BOLD | Font.PLAIN, 14);
    public static final Font  FONT_SMALL   = new Font("Cascadia Code", Font.PLAIN| Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT; //Alineación izquierda de texto
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT; 
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR); //Cambia el cursor a mano (similar a un hipervínculo).
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_MAIN  = IAStyle.class.getResource("/UserInterface/Resource/Login.png");
    public static final URL URL_LOGO  = IAStyle.class.getResource("/UserInterface/Resource/Logo.png");
    public static final URL URL_SPLASH= IAStyle.class.getResource("/UserInterface/Resource/SplahSalud.png");
// The line `public static final URL URL_FONDO= IAStyle.class.getResource("/UserInterface/Resource/Fondo2.png");` is defining a public static final variable named `URL_FONDO` of type `URL` in the `IAStyle` class. This variable is being initialized with the result of calling the `getResource` method on the `IAStyle` class, which is used to obtain a URL for the specified resource path "/UserInterface/Resource/Fondo2.png".
    public static final URL URL_FONDO= IAStyle.class.getResource("/UserInterface/Resource/Fondo2.png");

    public static final CompoundBorder createBorderRect(){ //Crea un borde personalizado
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray), // Borde exterior
                                                    new EmptyBorder(5, 5, 5, 5)); // Espaciado interno
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "PoliSalud Informa", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "☠️PoliSalud Error", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "PoliSalud Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
