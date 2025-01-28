package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class CentroMedicoDAO extends DataHelper{
    
    public void create(CentroMedicoDTO centroMedico) throws Exception{
        String sql = "INSERT INTO CentroMedico (Nombre, Direccion) VALUES (?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, centroMedico.getNombre());
            pstmt.setString(2, centroMedico.getDireccion());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public CentroMedicoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM CentroMedico WHERE EstadoRegistro ='A' AND IdCentroMedico = ?";
        Connection conn = null;
        CentroMedicoDTO centroMedico = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                centroMedico = new CentroMedicoDTO(
                    rs.getInt("IdCentroMedico"),
                    rs.getString("Nombre"),
                    rs.getString("Direccion"),
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
        return centroMedico;
    }

    public List<CentroMedicoDTO> readAll() throws Exception{
        String sql = "SELECT * FROM CentroMedico  WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<CentroMedicoDTO> CentroMedico = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                CentroMedico.add(new CentroMedicoDTO(
                    rs.getInt("IdCentroMedico"),
                    rs.getString("Nombre"),
                    rs.getString("Direccion"),
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
        return CentroMedico;
    }

    public void update(CentroMedicoDTO centroMedico) throws Exception{
        String sql = "UPDATE CentroMedico SET Nombre = ?, Direccion = ?, FechaModificacion = datetime('now','localtime') WHERE IdCentroMedico = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, centroMedico.getNombre());
            pstmt.setString(2, centroMedico.getDireccion());
            pstmt.setInt(3, centroMedico.getIdCentroMedico());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE CentroMedico SET EstadoRegistro = 'X' WHERE idCentroMedico = ?";
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
