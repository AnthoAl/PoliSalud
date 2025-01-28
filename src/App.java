import java.util.Date;

import DataAccess.DAO.CatalogoDAO;
import DataAccess.DAO.CatalogoTipoDAO;
import DataAccess.DAO.CentroMedicoDAO;
import DataAccess.DAO.CitaDAO;
import DataAccess.DAO.CorreoDAO;
import DataAccess.DAO.HistorialClinicoDAO;
import DataAccess.DAO.MedicoDAO;
import DataAccess.DAO.PacienteDAO;
import DataAccess.DAO.PersonaDAO;
import DataAccess.DTO.CatalogoDTO;
import DataAccess.DTO.CatalogoTipoDTO;
import DataAccess.DTO.CentroMedicoDTO;
import DataAccess.DTO.CitaDTO;
import DataAccess.DTO.CorreoDTO;
import DataAccess.DTO.HistorialClinicoDTO;
import DataAccess.DTO.MedicoDTO;
import DataAccess.DTO.PacienteDTO;
import DataAccess.DTO.PersonaDTO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, PoliSalud! :)");

        //Update y Delete funcionan similar por el borrado lógico
        CitaDAO dAO = new CitaDAO();
        CitaDTO dTO = dAO.read(1); //Recupera el objeto catalogo con id 1
        
        //dTO.setHoraCita("20:00:00");  //Modifica el nombre del catalogo

        //dAO.update(dTO); //Actualiza el catalogo con id 1

        //Delete
        dAO.delete(2);

        //Create
        //dAO.create(new CitaDTO(1, 1, "2025-01-18", "17:20:00"));

        //Read
        for (CitaDTO dto : dAO.readAll()) {
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
