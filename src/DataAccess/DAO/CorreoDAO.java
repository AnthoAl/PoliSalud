package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class CorreoDAO extends DataHelper{
    
        public void create(CorreoDTO correo) throws Exception{
        String sql = "INSERT INTO Correo (IdPersona, Correo) VALUES (?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, correo.getIdPersona());
            pstmt.setString(2, correo.getCorreo());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public CorreoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Correo WHERE EstadoRegistro ='A' AND IdCorreo = ?";
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
        String sql = "SELECT * FROM Correo WHERE EstadoRegistro ='A'";
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
        String sql = "UPDATE Correo SET Correo = ?, FechaModificacion = datetime('now','localtime') WHERE IdCorreo = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, correo.getCorreo());
            pstmt.setInt(2, correo.getIdCorreo());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE Correo SET EstadoRegistro = 'X' WHERE IdCorreo = ?";
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
