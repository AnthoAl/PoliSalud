package DataAccess.DAO;

import DataAccess.DTO.*;
import DataAccess.DataHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO extends DataHelper{
    
    public boolean create(CitaDTO citaDTO) throws Exception {
        String sql = "INSERT INTO Cita (IdMedico, IdPaciente, FechaCita, HoraCita) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, citaDTO.getIdMedico());
            pstmt.setInt(2, citaDTO.getIdPaciente());
            pstmt.setString(3, citaDTO.getFechaCita());
            pstmt.setString(4, citaDTO.getHoraCita());
    
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }
    

    public CitaDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Cita WHERE EstadoRegistro = 'A' AND IdCita = ?";
        Connection conn = null;
        CitaDTO cita = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cita = new CitaDTO(
                    rs.getInt("IdMedico"),
                    rs.getInt("IdPaciente"),
                    rs.getString("FechaCita"),
                    rs.getString("HoraCita"));
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
        String sql = "SELECT C.IdCita, " +
                        "P1.PrimerNombre || ' ' || P1.PrimerApellido AS Medico, " +
                        "P2.PrimerNombre || ' ' ||  P2.PrimerApellido AS Paciente, " +
                        "C.FechaCita, " +
                        "C.HoraCita " +
                 "FROM Cita C " +
                 "JOIN Medico M ON C.IdMedico = M.IdMedico " +
                 "JOIN Persona P1 ON M.IdPersonaMedico = P1.IdPersona " +
                 "JOIN Paciente Pa ON C.IdPaciente = Pa.IdPaciente " +
                 "JOIN Persona P2 ON Pa.IdPersonaPaciente = P2.IdPersona " +
                 "WHERE C.EstadoRegistro = 'A'"; 
        Connection conn = null;
        List<CitaDTO> citas = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String medico = rs.getString("Medico");
                    String paciente = rs.getString("Paciente");
                
                    System.out.println("Medico: " + medico);
                    System.out.println("Paciente: " + paciente);
                    System.out.println("FechaCita: " + rs.getString("FechaCita"));
                    System.out.println("HoraCita: " + rs.getString("HoraCita"));
                
                    citas.add(new CitaDTO(
                        rs.getInt("IdCita"),
                        medico,
                        paciente,
                        rs.getString("FechaCita"),
                        rs.getString("HoraCita")
                    ));
                }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
        return citas;
    }

    public boolean update(CitaDTO cita) throws Exception{
        String sql = "UPDATE Cita SET FechaCita = ?, HoraCita = ?, FechaModificacion = datetime('now','localtime') WHERE IdCita = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cita.getFechaCita());
            pstmt.setString(2, cita.getHoraCita());
            pstmt.setInt(3, cita.getIdCita());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public boolean delete(int id) throws Exception{
        String sql = "UPDATE Cita SET EstadoRegistro = 'X' WHERE idCita = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            return true;

        }catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Cita "
                     +" WHERE EstadoRegistro ='A' ";
        try {
            Connection conn = openConnection();         
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                return rs.getInt(1);                    
            }
        } 
        catch (SQLException e) {
            throw e; 
        }
        return 0;
    }
}
