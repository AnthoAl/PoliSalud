package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.*;
import DataAccess.DataHelper;

public class HistorialClinicoDAO extends DataHelper{

    public void create(HistorialClinicoDTO HistorialClinico) throws Exception{
        String sql = "INSERT INTO HistorialClinico (IdPaciente, IdCita, Diagnostico, Tratamiento) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, HistorialClinico.getIdPaciente());
            pstmt.setInt(2, HistorialClinico.getIdCita());
            pstmt.setString(3, HistorialClinico.getDiagnostico());
            pstmt.setString(4, HistorialClinico.getTratamiento());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public HistorialClinicoDTO read(int id) throws Exception{
        String sql = "SELECT * FROM HistorialClinico WHERE EstadoRegistro ='A' AND IdHistorialClinico = ?";
        Connection conn = null;
        HistorialClinicoDTO HistorialClinico = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                HistorialClinico= new HistorialClinicoDTO(
                    rs.getInt("IdHistorialClinico"),
                    rs.getInt("IdPaciente"),
                    rs.getInt("IdCita"),
                    rs.getString("Diagnostico"),
                    rs.getString("Tratamiento"),
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
        return HistorialClinico;
    }

    public List<HistorialClinicoDTO> readAll() throws Exception{
        String sql = "SELECT * FROM HistorialClinico WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<HistorialClinicoDTO> HistorialClinico = new ArrayList<>();
        try{
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                HistorialClinico.add(new HistorialClinicoDTO(
                    rs.getInt("IdHistorialClinico"),
                    rs.getInt("IdPaciente"),
                    rs.getInt("IdCita"),
                    rs.getString("Diagnostico"),
                    rs.getString("Tratamiento"),
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
        return HistorialClinico;
    }

    public void update(HistorialClinicoDTO HistorialClinico) throws Exception{
        String sql = "UPDATE HistorialClinico SET Diagnostico = ?, Tratamiento = ?, FechaModificacion = datetime('now','localtime') WHERE IdHistorialClinico = ?";
        Connection conn = null;
        try{
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, HistorialClinico.getDiagnostico());
            pstmt.setString(2, HistorialClinico.getTratamiento());
            pstmt.setInt(3, HistorialClinico.getIdHistorialClinico());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            throw e;
        }finally{
            closeConnection();
        }
    }

    public void delete(int id) throws Exception{
        String sql = "UPDATE HistorialClinico SET EstadoRegistro = 'X' WHERE IdHistorialClinico = ?";
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
