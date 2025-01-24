package DataAccess.DTO;

public class CentroMedicoDTO {

    private Integer IdCentroMedico;
    private String  Nombre;
    private String  Direccion;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    public CentroMedicoDTO() {}

    public CentroMedicoDTO(String nombre, String direccion) {
        this.Nombre = nombre;
        this.Direccion = direccion;
    }

    public CentroMedicoDTO(Integer idCentroMedico, String nombre, String direccion, String estadoRegistro,String fechaCreacion, String fechaModificacion) {
        this.IdCentroMedico = idCentroMedico;
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdCentroMedico() {
        return IdCentroMedico;
    }

    public void setIdCentroMedico(Integer idCentroMedico) {
        IdCentroMedico = idCentroMedico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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
        + "\n IdCentroMedico: "+ getIdCentroMedico()            
        + "\n Nombre:         "+ getNombre()     
        + "\n Direccion:      "+ getDireccion()     
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }
}
