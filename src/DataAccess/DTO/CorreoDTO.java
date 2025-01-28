package DataAccess.DTO;

public class CorreoDTO {

    private Integer IdCorreo;
    private Integer IdPersona;
    private String  Correo;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    public CorreoDTO() {}

    public CorreoDTO(Integer idPersona, String correo) {
        this.IdPersona = idPersona;
        this.Correo = correo;
    }

    public CorreoDTO(Integer idCorreo, Integer idPersona, String correo, String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdCorreo = idCorreo;
        this.IdPersona = idPersona;
        this.Correo = correo;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdCorreo() {
        return IdCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        IdCorreo = idCorreo;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
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
        + "\n IdCorreo:       "+ getIdCorreo()            
        + "\n IdPersona:      "+ getIdPersona()     
        + "\n Correo:         "+ getCorreo()      
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }    
}
