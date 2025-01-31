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
            pstmt.setInt(1, citaDTO.getIdMedico());  // Asumiendo que IdMedico es un entero
            pstmt.setInt(2, citaDTO.getIdPaciente());  // Asumiendo que IdPaciente es un entero
            pstmt.setString(3, citaDTO.getFechaCita());  // Asumiendo que FechaCita es una cadena
            pstmt.setString(4, citaDTO.getHoraCita());  // Asumiendo que HoraCita es un entero
    
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
        String sql = "SELECT * FROM Cita WHERE EstadoRegistro ='A' AND IdCita = ?";
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
        String sql = "SELECT C.IdCita, " +
                        "P1.PrimerNombre || ' ' || P1.SegundoNombre || ' ' || P1.PrimerApellido || ' ' || P1.SegundoApellido AS Medico, " +
                        "P2.PrimerNombre || ' ' || P2.SegundoNombre || ' ' || P2.PrimerApellido || ' ' || P2.SegundoApellido AS Paciente, " +
                        "C.FechaCita, " +
                        "C.HoraCita, " +
                        "C.EstadoRegistro, " +
                        "C.FechaCreacion, " +
                        "C.FechaModificacion " +
                 "FROM Cita C " +
                 "JOIN Medico M ON C.IdMedico = M.IdMedico " +
                 "JOIN Persona P1 ON M.IdPersonaMedico = P1.IdPersona " +
                 "JOIN Paciente Pa ON C.IdPaciente = Pa.IdPaciente " +
                 "JOIN Persona P2 ON Pa.IdPersonaPaciente = P2.IdPersona " +
                 "WHERE C.EstadoRegistro = 'A'"; 
        Connection conn = null;
        List<CitaDTO> Cita = new ArrayList<>();
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
                
                    Cita.add(new CitaDTO(
                        rs.getInt("IdCita"),
                        medico,
                        paciente,
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
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
    
}
