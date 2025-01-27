public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, PoliSalud! :)");

        try {
            // Llamar a las pruebas directamente
            // TestApp.testCorreoDAO();
            TestApp.testCatalogoTipoDAO();
            // TestApp.testCentroMedicoDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
