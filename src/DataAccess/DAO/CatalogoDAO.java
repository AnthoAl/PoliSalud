package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.CatalogoDTO;
import DataAccess.DataHelper;
import DataAccess.IDAO;


public class CatalogoDAO extends DataHelper{
    
    public void create(CatalogoDTO catalogo) throws Exception{
        String sql = "INSERT INTO Catalogo("
                   + "IdTipoCatalogo,"
                   + "Nombre)"
                   + "VALUES(?,?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, catalogo.getIdTipoCatalogo());
            pstmt.setString(2, catalogo.getNombre());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public CatalogoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM Catalogo WHERE EstadoRegistro ='A' AND IdCatalogo = ?";
        Connection conn = null;
        CatalogoDTO catalogo = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                catalogo = new CatalogoDTO(
                            rs.getInt("IdCatalogo"),
                            rs.getInt("IdTipoCatalogo"),
                            rs.getString("Nombre"),
                            rs.getString("EstadoRegistro"),
                            rs.getString("FechaCreacion"),
                            rs.getString("FechaModificacion")
                );
            }
            rs.close();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        } finally{
            closeConnection();
        }
        return catalogo;
    }

    public List<CatalogoDTO> readAll() throws Exception {
        String sql = "SELECT * FROM Catalogo WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<CatalogoDTO> catalogos = new ArrayList<>();
        try {
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                catalogos.add(new CatalogoDTO(
                        rs.getInt("IdCatalogo"),
                        rs.getInt("IdTipoCatalogo"),
                        rs.getString("Nombre"),
                        rs.getString("EstadoRegistro"),
                        rs.getString("FechaCreacion"),
                        rs.getString("FechaModificacion")
                ));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
        return catalogos;
    }

    public void update(CatalogoDTO catalogo) throws Exception {
        String sql = "UPDATE Catalogo SET IdTipoCatalogo = ?, Nombre = ?, FechaModificacion = datetime('now','localtime') WHERE IdCatalogo = ?";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, catalogo.getIdTipoCatalogo());
            pstmt.setString(2, catalogo.getNombre());
            pstmt.setInt(3, catalogo.getIdCatalogo());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "UPDATE Catalogo SET EstadoRegistro = 'X' WHERE IdCatalogo = ?";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

}
