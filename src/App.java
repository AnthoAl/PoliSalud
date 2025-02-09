import UserInterface.Form.LoginPanel;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        
        SplashScreenForm.show();
        
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.login();
        
}}
