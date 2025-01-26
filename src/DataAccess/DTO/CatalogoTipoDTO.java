package DataAccess.DTO;

public class CatalogoTipoDTO {

    private Integer IdCatalogoTipo;
    private String  Nombre;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    public CatalogoTipoDTO() {}

    public CatalogoTipoDTO(String nombre) {
        this.Nombre = nombre;
    }
    
    public CatalogoTipoDTO(Integer idCatalogoTipo, String nombre, String estadoRegistro, String fechaCreacion,String fechaModificacion) {
        this.IdCatalogoTipo = idCatalogoTipo;
        this.Nombre = nombre;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdCatalogoTipo() {
        return IdCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        IdCatalogoTipo = idCatalogoTipo;
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
        + "\n IdCatalogoTipo: "+ getIdCatalogoTipo()            
        + "\n Nombre:         "+ getNombre()     
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }

}
