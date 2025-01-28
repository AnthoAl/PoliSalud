import java.util.Date;

import DataAccess.DAO.CatalogoDAO;
import DataAccess.DAO.CatalogoTipoDAO;
import DataAccess.DAO.CentroMedicoDAO;
import DataAccess.DAO.PersonaDAO;
import DataAccess.DTO.CatalogoDTO;
import DataAccess.DTO.CatalogoTipoDTO;
import DataAccess.DTO.CentroMedicoDTO;
import DataAccess.DTO.PersonaDTO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, PoliSalud! :)");

        //Update y Delete funcionan similar por el borrado lógico
        PersonaDAO dAO = new PersonaDAO();
       // PersonaDTO dTO = dAO.read(2); //Recupera el objeto catalogo con id 1
        
        //dTO.setDireccion("Ppepin");  //Modifica el nombre del catalogo

        //dAO.update(dTO); //Actualiza el catalogo con id 1

        //Delete
        dAO.delete(2);

        //Create
        //dAO.create(new PersonaDTO(2, 1, 2, "175025", "Diego", "Leo", "Aquino", "Bélez", "2005-01-21","Guamaní"));

        //Read
        for (PersonaDTO dto : dAO.readAll()) {
            System.out.println(dto);
        }

        try {
            // Llamar a las pruebas directamente
            // TestApp.testCorreoDAO();
            //TestApp.testCatalogoTipoDAO();
            // TestApp.testCentroMedicoDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
