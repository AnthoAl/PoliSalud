import UserInterface.Form.LoginPanel;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        //SplashScreenForm.show();
        
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.login();
        

        //Update y Delete funcionan similar por el borrado lógico
        //CitaDAO dAO = new CitaDAO();
        //CitaDTO dTO = dAO.read(1); //Recupera el objeto catalogo con id 1
        
        //dTO.setHoraCita("20:00:00");  //Modifica el nombre del catalogo

        //dAO.update(dTO); //Actualiza el catalogo con id 1

        //Delete
        //dAO.delete(2);

        //Create
        //dAO.create(new CitaDTO(1, 1, "2025-01-18", "17:20:00"));

        //Read
        //for (CitaDTO dto : dAO.readAll()) {
            //System.out.println(dto);
       //}

        //try {
            // Llamar a las pruebas directamente
            // TestApp.testCorreoDAO();
            //TestApp.testCatalogoTipoDAO();
            // TestApp.testCentroMedicoDAO();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    //}
}}
