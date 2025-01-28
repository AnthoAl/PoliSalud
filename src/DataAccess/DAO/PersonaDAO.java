package DataAccess.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.PersonaDTO;
import DataAccess.DataHelper;

public class PersonaDAO extends DataHelper {

    public void create(PersonaDTO persona) throws Exception {
        String sql = "INSERT INTO Persona (IdCatalogoRol,"
                                          +"IdCatalogoSexo,"
                                          +"IdCatalogoTipoIdentificacion," 
                                          +"NumeroIdentificacion," 
                                          +"PrimerNombre," 
                                          +"SegundoNombre," 
                                          +"PrimerApellido," 
                                          +"SegundoApellido," 
                                          +"FechaNacimiento," 
                                          +"Direccion)" 
                    +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, persona.getIdCatalogoRol());
            pstmt.setInt(2, persona.getIdCatalogoSexo());
            pstmt.setInt(3, persona.getIdCatalogoTipoIdentificacion());
            pstmt.setString(4, persona.getNumeroIdentificacion());
            pstmt.setString(5, persona.getPrimerNombre());
            pstmt.setString(6, persona.getSegundoNombre());
            pstmt.setString(7, persona.getPrimerApellido());
            pstmt.setString(8, persona.getSegundoApellido());
            pstmt.setString(9, persona.getFechaNacimiento());
            pstmt.setString(10, persona.getDireccion());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

    public PersonaDTO read(int id) throws Exception {
        String sql = "SELECT * FROM Persona WHERE EstadoRegistro ='A' AND IdPersona = ?";
        Connection conn = null;
        PersonaDTO persona = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                persona = new PersonaDTO(
                        rs.getInt("IdPersona"),
                        rs.getInt("IdCatalogoRol"),
                        rs.getInt("IdCatalogoSexo"),
                        rs.getInt("IdCatalogoTipoIdentificacion"),
                        rs.getString("NumeroIdentificacion"),
                        rs.getString("PrimerNombre"),
                        rs.getString("SegundoNombre"),
                        rs.getString("PrimerApellido"),
                        rs.getString("SegundoApellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Direccion"), sql, sql, sql
                );
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
        return persona;
    }

    public List<PersonaDTO> readAll() throws Exception {
        String sql = "SELECT * FROM Persona WHERE EstadoRegistro ='A'";
        Connection conn = null;
        List<PersonaDTO> personas = new ArrayList<>();
        try {
            conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                personas.add(new PersonaDTO(
                        rs.getInt("IdPersona"),
                        rs.getInt("IdCatalogoRol"),
                        rs.getInt("IdCatalogoSexo"),
                        rs.getInt("IdCatalogoTipoIdentificacion"),
                        rs.getString("NumeroIdentificacion"),
                        rs.getString("PrimerNombre"),
                        rs.getString("SegundoNombre"),
                        rs.getString("PrimerApellido"),
                        rs.getString("SegundoApellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Direccion"),
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
        return personas;
    }

    public void update(PersonaDTO persona) throws Exception {
        String sql = "UPDATE Persona SET IdCatalogoRol = ?, IdCatalogoSexo = ?, IdCatalogoTipoIdentificacion = ?, NumeroIdentificacion = ?, PrimerNombre = ?, SegundoNombre = ?, PrimerApellido = ?, SegundoApellido = ?, FechaNacimiento = ?,  Direccion = ?, FechaModificacion = datetime('now','localtime') WHERE IdPersona = ?";
        Connection conn = null;
        try {
            conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, persona.getIdCatalogoRol());
            pstmt.setInt(2, persona.getIdCatalogoSexo());
            pstmt.setInt(3, persona.getIdCatalogoTipoIdentificacion());
            pstmt.setString(4, persona.getNumeroIdentificacion());
            pstmt.setString(5, persona.getPrimerNombre());
            pstmt.setString(6, persona.getSegundoNombre());
            pstmt.setString(7, persona.getPrimerApellido());
            pstmt.setString(8, persona.getSegundoApellido());
            pstmt.setString(9, persona.getFechaNacimiento());
            pstmt.setString(10, persona.getDireccion());
            pstmt.setInt(11, persona.getIdPersona());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "UPDATE Persona SET EstadoRegistro = 'X' WHERE IdPersona = ?";
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
