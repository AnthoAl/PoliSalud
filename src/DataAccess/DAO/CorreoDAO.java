package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class CorreoDAO extends DataHelper{
    
        public void create(CorreoDTO correo) throws Exception{
        String sql = "INSERT INTO Correo (IdCorreo, IdPersona, Correo, EstadoRegistro) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, correo.getIdCorreo());
            pstmt.setInt(2, correo.getIdPersona());
            pstmt.setString(3, correo.getCorreo());
            pstmt.setString(4, correo.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public CorreoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Correo WHERE IdCorreo = ?";
        Connection conn = null;
        CorreoDTO correo = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                correo = new CorreoDTO(
                    rs.getInt("IdCorreo"),
                    rs.getInt("IdPersona"),
                    rs.getString("Correo"),
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
        return correo;
    }

    public List<CorreoDTO> readAll() throws Exception{
        String sql = "SELECT * FROM Correo";
        Connection conn = null;
        List<CorreoDTO> Correo = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Correo.add(new CorreoDTO(
                    rs.getInt("IdCorreo"),
                    rs.getInt("IdPersona"),
                    rs.getString("Correo"),
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
        return Correo;
    }

    public void update(CorreoDTO correo) throws Exception{
        String sql = "UPDATE Correo SET Correo = ?, EstadoRegistro = ?, FechaModificacion = ? WHERE IdCorreo = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, correo.getIdCorreo());
            pstmt.setInt(2, correo.getIdPersona());
            pstmt.setString(3, correo.getCorreo());
            pstmt.setString(4, correo.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "DELETE FROM Correo WHERE IdCorreo = ?";
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
