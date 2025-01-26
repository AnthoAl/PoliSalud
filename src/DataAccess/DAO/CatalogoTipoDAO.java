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

    public CatalogoTipoDTO read(int id) throws Exception {
        String sql = "SELECT * FROM CatalogoTipo WHERE IdCatalogoTipo = ?";
        Connection conn = null;
        CatalogoTipoDTO catalogoTipoDTO = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
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
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
            throw e;
        } finally {
            if (conn != null) {
                closeConnection();
            }
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

    public void update(CatalogoTipoDTO catalogoTipoDTO) throws Exception {
        String sql = "UPDATE CatalogoTipo SET Nombre = ?, EstadoRegistro = ?, FechaModificacion = datetime('now','localtime') WHERE IdCatalogoTipo = ?";
        Connection conn = null;
        try {
            conn = openConnection();  // Usar la conexión por instancia
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            if (catalogoTipoDTO.getNombre() == null || catalogoTipoDTO.getNombre().isEmpty()) {
                throw new IllegalArgumentException("El campo 'Nombre' no puede ser nulo o vacío.");
            }
    
            pstmt.setString(1, catalogoTipoDTO.getNombre());
            pstmt.setString(2, catalogoTipoDTO.getEstadoRegistro() != null ? catalogoTipoDTO.getEstadoRegistro() : "A");
            pstmt.setInt(3, catalogoTipoDTO.getIdCatalogoTipo());
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro actualizado con éxito.");
            } else {
                System.out.println("No se encontró un registro con el ID especificado.");
            }
    
            pstmt.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el registro: " + e.getMessage());
            throw e;
        } finally {
            if (conn != null && !conn.isClosed()) {
                closeConnection();  // Solo cerrar si la conexión está abierta
            }
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
