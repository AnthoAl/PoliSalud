package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class TelefonoDAO extends DataHelper{
    public void create(TelefonoDTO Telefono) throws Exception{
        String sql = "INSERT INTO Telefono (IdPersona, NumeroTelefono) VALUES (?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Telefono.getIdPersona());
            pstmt.setString(2, Telefono.getNumeroTelefono());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public TelefonoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Telefono WHERE EstadoRegistro ='A' AND IdTelefono = ?";
        Connection conn = null;
        TelefonoDTO Telefono = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Telefono = new TelefonoDTO(
                    rs.getInt("IdTelefono"),
                    rs.getInt("IdPersona"),
                    rs.getString("NumeroTelefono"),
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
        return Telefono;
    }

    public List<TelefonoDTO> readAll() throws Exception{
        String sql = "SELECT * FROM Telefono WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<TelefonoDTO> Telefono = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Telefono.add(new TelefonoDTO(
                    rs.getInt("IdTelefono"),
                    rs.getInt("IdPersona"),
                    rs.getString("NumeroTelefono"),
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
        return Telefono;
    }

    public void update(TelefonoDTO Telefono) throws Exception{
        String sql = "UPDATE Telefono NumeroTelefono = ?, FechaModificacion = datetime('now','localtime') WHERE IdTelefono = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Telefono.getNumeroTelefono());
            pstmt.setInt(2, Telefono.getIdTelefono());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE Telefono SET EstadoRegistro = 'X' WHERE IdTelefono = ?";
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
