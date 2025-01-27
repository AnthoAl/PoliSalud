package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class CitaDAO extends DataHelper{
    
    public void create(CitaDTO citaDTO) throws Exception {
        String sql = "INSERT INTO Cita (IdMedico, IdPaciente, FechaCita, HoraCita, EstadoRegistro) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, citaDTO.getIdMedico());  // Asumiendo que IdMedico es un entero
            pstmt.setInt(2, citaDTO.getIdPaciente());  // Asumiendo que IdPaciente es un entero
            pstmt.setString(3, citaDTO.getFechaCita());  // Asumiendo que FechaCita es una cadena
            pstmt.setString(4, citaDTO.getHoraCita());  // Asumiendo que HoraCita es un entero
            pstmt.setString(5, citaDTO.getEstadoRegistro());  // EstadoRegistro es un string (por defecto 'A')
    
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }
    

    public CitaDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Cita WHERE IdCita = ?";
        Connection conn = null;
        CitaDTO cita = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cita = new CitaDTO(
                    rs.getInt("IdCita"),
                    rs.getInt("IdMedico"),
                    rs.getInt("IdPaciente"),
                    rs.getString("FechaCita"),
                    rs.getString("HoraCita"),
                    rs.getString("EstadoRegistro"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModificacion")
                );
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
        return cita;
    }

    public List<CitaDTO> readAll() throws Exception{
        String sql = "SELECT * FROM Cita";
        Connection conn = null;
        List<CitaDTO> Cita = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cita.add(new CitaDTO(
                    rs.getInt("IdCita"),
                    rs.getInt("IdMedico"),
                    rs.getInt("IdPaciente"),
                    rs.getString("FechaCita"),
                    rs.getString("HoraCita"),
                    rs.getString("EstadoRegistro"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModificacion")
                    ));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
        return Cita;
    }

    public void update(CitaDTO cita) throws Exception{
        String sql = "UPDATE Cita SET Nombre = ?, EstadoRegistro = ?, FechaModificacion = ? WHERE IdCita = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cita.getIdCita());
            pstmt.setInt(2, cita.getIdPaciente());
            pstmt.setInt(3, cita.getIdPaciente());
            pstmt.setString(4, cita.getFechaCita());
            pstmt.setString(5, cita.getHoraCita());
            pstmt.setString(6, cita.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE Cita SET EstadoRegistro = 'X' WHERE idCita = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
    }


}
