package DataAccess.DTO;

public class TelefonoDTO {

    private Integer IdTelefono;
    private Integer IdPersona;
    private String  NumeroTelefono;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;
    
    public TelefonoDTO() {
    }
    
    public TelefonoDTO(Integer idPersona, String numeroTelefono) {
        this.IdPersona = idPersona;
        this.NumeroTelefono = numeroTelefono;
    }
    
    public TelefonoDTO(Integer idTelefono, Integer idPersona, String numeroTelefono, String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdTelefono = idTelefono;
        this.IdPersona = idPersona;
        this.NumeroTelefono = numeroTelefono;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }
    
    public Integer getIdTelefono() {
        return IdTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        IdTelefono = idTelefono;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        NumeroTelefono = numeroTelefono;
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
        + "\n IdTelefono:     "+ getIdTelefono()            
        + "\n IdPersona:      "+ getIdPersona()     
        + "\n NumeroTelefono: "+ getNumeroTelefono()      
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }
}
