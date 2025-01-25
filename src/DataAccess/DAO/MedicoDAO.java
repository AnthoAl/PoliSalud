package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class MedicoDAO extends DataHelper{
        public void create(MedicoDTO Medico) throws Exception{
        String sql = "INSERT INTO Medico (IdMedico, IdPersonaMedico, IdCentroMedico, IdCatalogoEspecialidad, NumeroLicencia, EstadoRegistro) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Medico.getIdMedico());
            pstmt.setInt(2, Medico.getIdPersonaMedico());
            pstmt.setInt(3, Medico.getIdCentroMedico());
            pstmt.setInt(4, Medico.getIdCatalogoEspecialidad());
            pstmt.setString(5, Medico.getNumeroLicencia());
            pstmt.setString(6, Medico.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public MedicoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Medico WHERE IdMedico = ?";
        Connection conn = null;
        MedicoDTO Medico = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Medico = new MedicoDTO(
                    rs.getInt("IdMedico"),
                    rs.getInt("IdPersonaMedico"),
                    rs.getInt("IdCentroMedico"),
                    rs.getInt("IdCatalogoEspecialidad"),
                    rs.getString("NumeroLicencia"),
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
        return Medico;
    }

    public List<MedicoDTO> readAll() throws Exception{
        String sql = "SELECT * FROM Medico";
        Connection conn = null;
        List<MedicoDTO> Medico = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Medico.add(new MedicoDTO(
                    rs.getInt("IdMedico"),
                    rs.getInt("IdPersonaMedico"),
                    rs.getInt("IdCentroMedico"),
                    rs.getInt("IdCatalogoEspecialidad"),
                    rs.getString("NumeroLicencia"),
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
        return Medico;
    }

    public void update(MedicoDTO Medico) throws Exception{
        String sql = "UPDATE Medico NumeroLicencia = ?, EstadoRegistro = ?, FechaModificacion = ? WHERE IdMedico = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Medico.getIdMedico());
            pstmt.setInt(2, Medico.getIdPersonaMedico());
            pstmt.setInt(3, Medico.getIdCentroMedico());
            pstmt.setInt(4, Medico.getIdCatalogoEspecialidad());
            pstmt.setString(5, Medico.getNumeroLicencia());
            pstmt.setString(6, Medico.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "DELETE FROM Medico WHERE IdMedico = ?";
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
