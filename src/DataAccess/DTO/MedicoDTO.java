package DataAccess.DTO;

public class MedicoDTO {

    private Integer IdMedico;
    private Integer IdPersonaMedico;
    private Integer IdCentroMedico;
    private Integer IdCatalogoEspecialidad;
    private String  NumeroLicencia;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    public MedicoDTO() {}

    public MedicoDTO(Integer idPersonaMedico, Integer idCentroMedico, Integer idCatalogoEspecialidad,String numeroLicencia) {
        this.IdPersonaMedico = idPersonaMedico;
        this.IdCentroMedico = idCentroMedico;
        this.IdCatalogoEspecialidad = idCatalogoEspecialidad;
        this.NumeroLicencia = numeroLicencia;
    }

    public MedicoDTO(Integer idMedico, Integer idPersonaMedico, Integer idCentroMedico, Integer idCatalogoEspecialidad, String numeroLicencia, String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdMedico = idMedico;
        this.IdPersonaMedico = idPersonaMedico;
        this.IdCentroMedico = idCentroMedico;
        this.IdCatalogoEspecialidad = idCatalogoEspecialidad;
        this.NumeroLicencia = numeroLicencia;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(Integer idMedico) {
        IdMedico = idMedico;
    }

    public Integer getIdPersonaMedico() {
        return IdPersonaMedico;
    }

    public void setIdPersonaMedico(Integer idPersonaMedico) {
        IdPersonaMedico = idPersonaMedico;
    }

    public Integer getIdCentroMedico() {
        return IdCentroMedico;
    }

    public void setIdCentroMedico(Integer idCentroMedico) {
        IdCentroMedico = idCentroMedico;
    }

    public Integer getIdCatalogoEspecialidad() {
        return IdCatalogoEspecialidad;
    }

    public void setIdCatalogoEspecialidad(Integer idCatalogoEspecialidad) {
        IdCatalogoEspecialidad = idCatalogoEspecialidad;
    }

    public String getNumeroLicencia() {
        return NumeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        NumeroLicencia = numeroLicencia;
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
        + "\n IdMedico:               "+ getIdMedico()            
        + "\n IdPersonaMedico:        "+ getIdPersonaMedico()     
        + "\n IdCentroMedico:         "+ getIdCentroMedico()      
        + "\n IdCatalogoEspecialidad: "+ getIdCatalogoEspecialidad()      
        + "\n NumeroLicencia:         "+ getNumeroLicencia()      
        + "\n EstadoRegistro:         "+ getEstadoRegistro()  
        + "\n FechaCreacion:          "+ getFechaCreacion()    
        + "\n FechaModifica:          "+ getFechaModificacion();
    } 
}
