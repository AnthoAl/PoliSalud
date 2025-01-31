package BusinessLogic;

import DataAccess.DAO.CitaDAO;
import DataAccess.DTO.CitaDTO;
import java.util.List;

public class BLCita {

    private CitaDTO cita;       // cache
    private CitaDAO citaDAO = new CitaDAO();


    public BLCita(){}

    public List<CitaDTO> getAll() throws Exception{
        return citaDAO.readAll();
    }
    public CitaDTO getByIdCita(int idCita) throws Exception{
        cita = citaDAO.read(idCita);
        return cita;
    }
    public boolean create(CitaDTO citaDTO) throws Exception{   
        return citaDAO.create(citaDTO);
    }
    public boolean update(CitaDTO citaDTO) throws Exception{
        return citaDAO.update(citaDTO);
    }
    public boolean delete(int idCita) throws Exception{
        return citaDAO.delete(idCita);
    }
    public Integer getMaxRow() throws Exception{
        return citaDAO.getMaxRow();
    }
}
