package DataAccess.DTO;

public class CatalogoDTO {
    
    private Integer IdCatalogo;         
    private Integer IdTipoCatalogo;
    private String  Nombre;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    
    public CatalogoDTO() { };
    
    public CatalogoDTO(String nombre) {
        this.Nombre = nombre;
    }
    
    public CatalogoDTO(Integer idCatalogo, Integer idTipoCatalogo, String nombre, String estadoRegistro,
            String fechaCreacion, String fechaModificacion) {
        IdCatalogo = idCatalogo;
        IdTipoCatalogo = idTipoCatalogo;
        Nombre = nombre;
        EstadoRegistro = estadoRegistro;
        FechaCreacion = fechaCreacion;
        FechaModificacion = fechaModificacion;
    }

    public Integer getIdCatalogo() {
        return IdCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        IdCatalogo = idCatalogo;
    }

    public Integer getIdTipoCatalogo() {
        return IdTipoCatalogo;
    }

    public void setIdTipoCatalogo(Integer idTipoCatalogo) {
        IdTipoCatalogo = idTipoCatalogo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEstadoRegistro() {
        return EstadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        EstadoRegistro = estadoRegistro;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdCatalogo:     "+ getIdCatalogo()       
        + "\n IdTipoCatalogo: "+ getIdTipoCatalogo()       
        + "\n Nombre:         "+ getNombre()     
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }
}
