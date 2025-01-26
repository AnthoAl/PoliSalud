import DataAccess.DAO.*;
import DataAccess.DTO.*;
import java.util.List;

public class TestApp {
    
    // // TEST DE CORREO
    // public static void testCorreoDAO() throws Exception {
    //     CorreoDAO correoDAO = new CorreoDAO();

    //     // Crear un correo
    //     System.out.println("Crear un Correo");
    //     CorreoDTO nuevoCorreo = new CorreoDTO(0, 1, "correo@ejemplo.com", "A", null, null);
    //     correoDAO.create(nuevoCorreo);
    //     System.out.println("Correo creado con éxito");

    //     // Leer un correo por ID
    //     System.out.println("Leer un Correo por ID");
    //     CorreoDTO correoLeido = correoDAO.read(1);
    //     if (correoLeido != null) {
    //         System.out.println("ID: " + correoLeido.getIdCorreo());
    //         System.out.println("Correo: " + correoLeido.getCorreo());
    //     } else {
    //         System.out.println("No se encontró el correo");
    //     }

    //     // Leer todos los correos
    //     System.out.println("Leer todos los Correos");
    //     List<CorreoDTO> listaCorreos = correoDAO.readAll();
    //     for (CorreoDTO correo : listaCorreos) {
    //         System.out.println(correo.getIdCorreo() + " - " + correo.getCorreo());
    //     }

    //     // Actualizar un correo
    //     System.out.println("Actualizar un Correo");
    //     correoLeido.setCorreo("nuevo_correo@ejemplo.com");
    //     correoDAO.update(correoLeido);
    //     System.out.println("Correo actualizado con éxito");

    //     // Eliminar un correo
    //     System.out.println("Eliminar un Correo");
    //     correoDAO.delete(1);
    //     System.out.println("Correo eliminado con éxito");
    // }

    // // TEST DE CATALOGO
    // public static void testCatalogoTipoDAO() throws Exception {
    //     CatalogoTipoDAO catalogoTipoDAO = new CatalogoTipoDAO();
    //     CatalogoDAO catalogoDAO = new CatalogoDAO();

    //     // Crear un registro de CatalogoTipo
    //     System.out.println("Crear un Tipo de Catalogo");
    //     CatalogoTipoDTO catalogoTipoDTO = new CatalogoTipoDTO(0, "Tipo de prueba", "A", null, null);
    //     catalogoTipoDAO.create(catalogoTipoDTO);
    //     System.out.println("Tipo de Catalogo creado con éxito");

    //     // Crear un registro en Catalogo
    //     System.out.println("Crear un Registro en Catalogo");
    //     CatalogoDTO catalogoDTO = new CatalogoDTO(0, catalogoTipoDTO.getIdCatalogoTipo(), "Catalogo de prueba", "A", null, null);
    //     catalogoDAO.create(catalogoDTO);
    //     System.out.println("Registro en Catalogo creado con éxito");

    //     // Leer un registro de Catalogo
    //     System.out.println("Leer un Registro de Catalogo por ID");
    //     CatalogoDTO catalogoLeido = catalogoDAO.read(1);
    //     if (catalogoLeido != null) {
    //         System.out.println("ID: " + catalogoLeido.getIdCatalogo());
    //         System.out.println("Nombre: " + catalogoLeido.getNombre());
    //     } else {
    //         System.out.println("No se encontró el registro de Catalogo");
    //     }

    //     // Actualizar un registro de Catalogo
    //     System.out.println("Actualizar un Registro de Catalogo");
    //     catalogoLeido.setNombre("Nombre Actualizado");
    //     catalogoDAO.update(catalogoLeido);
    //     System.out.println("Registro actualizado con éxito.");

    //     // Eliminar un registro de Catalogo
    //     System.out.println("Eliminar un Registro de Catalogo");
    //     catalogoDAO.delete(1);
    //     System.out.println("Registro eliminado con éxito");
    // }

    // // TEST DE CENTRO MEDICO
    // public static void testCentroMedicoDAO() throws Exception {
    //     CentroMedicoDAO centroMedicoDAO = new CentroMedicoDAO();

    //     // Crear un registro en CentroMedico
    //     System.out.println("Crear un Centro Medico");
    //     CentroMedicoDTO centroMedicoDTO = new CentroMedicoDTO(0, "Centro Médico Prueba", "Dirección de prueba", "A", null, null);
    //     centroMedicoDAO.create(centroMedicoDTO);
    //     System.out.println("Centro Médico creado con éxito");

    //     // Leer un registro de CentroMedico
    //     System.out.println("Leer un Registro de CentroMedico por ID");
    //     CentroMedicoDTO centroMedicoLeido = centroMedicoDAO.read(0);
    //     if (centroMedicoLeido != null) {
    //         System.out.println("ID: " + centroMedicoLeido.getIdCentroMedico());
    //         System.out.println("Nombre: " + centroMedicoLeido.getNombre());
    //     } else {
    //         System.out.println("No se encontró el registro de Centro Médico");
    //     }

    //     // Actualizar un registro de CentroMedico
    //     System.out.println("Actualizar un Registro de CentroMedico");
    //     centroMedicoLeido.setNombre("Centro Médico Actualizado");
    //     centroMedicoDAO.update(centroMedicoLeido);
    //     System.out.println("Registro actualizado con éxito.");

    //     // Eliminar un registro de CentroMedico
    //     System.out.println("Eliminar un Registro de CentroMedico");
    //     centroMedicoDAO.delete(1);
    //     System.out.println("Registro eliminado con éxito");
    // }
}
