package DataAccess.DTO;

public class HistorialClinicoDTO {

    private Integer IdHistorialClinico;
    private Integer IdPaciente;
    private Integer IdCita;
    private String  Diagnostico;
    private String  Tratamiento;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;

    public HistorialClinicoDTO() {}

    public HistorialClinicoDTO(Integer idPaciente, Integer idCita, String diagnostico, String tratamiento) {
        this.IdPaciente = idPaciente;
        this.IdCita = idCita;
        this.Diagnostico = diagnostico;
        this.Tratamiento = tratamiento;
    }

    public HistorialClinicoDTO(Integer idHistorialClinico, Integer idPaciente, Integer idCita, String diagnostico,String tratamiento, String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdHistorialClinico = idHistorialClinico;
        this.IdPaciente = idPaciente;
        this.IdCita = idCita;
        this.Diagnostico = diagnostico;
        this.Tratamiento = tratamiento;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdHistorialClinico() {
        return IdHistorialClinico;
    }

    public void setIdHistorialClinico(Integer idHistorialClinico) {
        IdHistorialClinico = idHistorialClinico;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public Integer getIdCita() {
        return IdCita;
    }

    public void setIdCita(Integer idCita) {
        IdCita = idCita;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        Diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
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
        + "\n IdHistorialClinico: "+ getIdHistorialClinico()            
        + "\n IdPaciente:         "+ getIdPaciente()     
        + "\n IdCita:             "+ getIdCita()      
        + "\n Diagnostico:        "+ getDiagnostico()      
        + "\n Tratamiento:        "+ getTratamiento()      
        + "\n EstadoRegistro:     "+ getEstadoRegistro()  
        + "\n FechaCreacion:      "+ getFechaCreacion()    
        + "\n FechaModifica:      "+ getFechaModificacion();
    } 
}
