package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.CatalogoTipoDTO;
import DataAccess.DataHelper;

public class CatalogoTipoDAO extends DataHelper{
    
    public void create(CatalogoTipoDTO catalogoTipoDTO) throws Exception{
        String sql = "INSERT INTO CatalogoTipo (Nombre, EstadoRegistro) Values (?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, catalogoTipoDTO.getNombre());
            pstmt.setString(2, catalogoTipoDTO.getEstadoRegistro());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public CatalogoTipoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM CatalogoTipo WHERE IdCatalogoTipo = ?";
        Connection conn = null;
        CatalogoTipoDTO catalogoTipoDTO = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                catalogoTipoDTO = new CatalogoTipoDTO(
                    rs.getInt("IdCatalogoTipo"),
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
        }finally{
            closeConnection();
        }
        return catalogoTipoDTO;
    }

    public List<CatalogoTipoDTO> readAll() throws Exception {
        String sql = "SELECT * FROM CatalogoTipo";
        Connection conn = null;
        List<CatalogoTipoDTO> catalogoTipos = new ArrayList<>();
        try {
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                catalogoTipos.add(new CatalogoTipoDTO(
                        rs.getInt("IdCatalogoTipo"),
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
        return catalogoTipos;
    }

    public void update(CatalogoTipoDTO catalogoTipoDTO) throws Exception{
        String sql = "UPDATE CatalogoTipo SET Nombre = ?, EstadoRegistro = ?, FechaModificacion = ? WHERE IdCatalogoTipo = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, catalogoTipoDTO.getNombre());
            pstmt.setString(2, catalogoTipoDTO.getEstadoRegistro());
            pstmt.setInt(3, catalogoTipoDTO.getIdCatalogoTipo());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "DELETE FROM CatalogoTipo WHERE IdCatalogoTipo = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }
}
