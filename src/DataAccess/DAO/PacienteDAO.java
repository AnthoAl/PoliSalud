package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class PacienteDAO extends DataHelper{
    
    public void create(PacienteDTO Paciente) throws Exception{
        String sql = "INSERT INTO Paciente (IdPersonaPaciente, IdCatalogoAfiliacion) VALUES (?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Paciente.getIdPersonaPaciente());
            pstmt.setInt(2, Paciente.getIdCatalogoAfiliacion());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public PacienteDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Paciente WHERE EstadoRegistro ='A' AND IdPaciente = ?";
        Connection conn = null;
        PacienteDTO Paciente = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Paciente = new PacienteDTO(
                    rs.getInt("IdPaciente"),
                    rs.getInt("IdPersonaPaciente"),
                    rs.getInt("IdCatalogoAfiliacion"),
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
        return Paciente;
    }

    public List<PacienteDTO> readAll() throws Exception{
        String sql = "SELECT * FROM Paciente WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<PacienteDTO> Paciente = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Paciente.add(new PacienteDTO(
                    rs.getInt("IdPaciente"),
                    rs.getInt("IdPersonaPaciente"),
                    rs.getInt("IdCatalogoAfiliacion"),
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
        return Paciente;
    }

    public void update(PacienteDTO Paciente) throws Exception{
        String sql = "UPDATE Paciente SET IdCatalogoAfiliacion = ?, FechaModificacion = datetime('now','localtime') WHERE IdPaciente = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Paciente.getIdCatalogoAfiliacion());
            pstmt.setInt(2, Paciente.getIdPaciente());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE Paciente SET EstadoRegistro = 'X' WHERE IdPaciente = ?";
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
