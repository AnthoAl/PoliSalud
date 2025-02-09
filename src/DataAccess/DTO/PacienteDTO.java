package DataAccess.DTO;

public class PacienteDTO {

    private Integer IdPaciente;
    private Integer IdPersonaPaciente;
    private Integer IdCatalogoAfiliacion;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;
    
    // Nuevas propiedades para el nombre del médico y la fecha de la cita
    private String MedicoNombre;
    private String FechaCita;
    
    public PacienteDTO() {
    }

    public PacienteDTO(Integer idPersonaPaciente, Integer idCatalogoAfiliacion) {
        this.IdPersonaPaciente = idPersonaPaciente;
        this.IdCatalogoAfiliacion = idCatalogoAfiliacion;
    }
    
    public PacienteDTO(Integer idPaciente, Integer idPersonaPaciente, Integer idCatalogoAfiliacion, String estadoRegistro, String fechaCreacion, String fechaModificacion, String medicoNombre, String fechaCita) {
        this.IdPaciente = idPaciente;
        this.IdPersonaPaciente = idPersonaPaciente;
        this.IdCatalogoAfiliacion = idCatalogoAfiliacion;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
        this.MedicoNombre = medicoNombre;
        this.FechaCita = fechaCita;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public Integer getIdPersonaPaciente() {
        return IdPersonaPaciente;
    }

    public void setIdPersonaPaciente(Integer idPersonaPaciente) {
        IdPersonaPaciente = idPersonaPaciente;
    }

    public Integer getIdCatalogoAfiliacion() {
        return IdCatalogoAfiliacion;
    }

    public void setIdCatalogoAfiliacion(Integer idCatalogoAfiliacion) {
        IdCatalogoAfiliacion = idCatalogoAfiliacion;
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

    // Nuevos métodos getter y setter para MedicoNombre y FechaCita
    public String getMedicoNombre() {
        return MedicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        MedicoNombre = medicoNombre;
    }

    public String getFechaCita() {
        return FechaCita;
    }

    public void setFechaCita(String fechaCita) {
        FechaCita = fechaCita;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdPaciente:           "+ getIdPaciente()            
        + "\n IdPersonaPaciente:    "+ getIdPersonaPaciente()     
        + "\n IdCatalogoAfiliacion: "+ getIdCatalogoAfiliacion()      
        + "\n EstadoRegistro:       "+ getEstadoRegistro()  
        + "\n FechaCreacion:        "+ getFechaCreacion()    
        + "\n FechaModificacion:    "+ getFechaModificacion()
        + "\n MedicoNombre:         "+ getMedicoNombre()
        + "\n FechaCita:            "+ getFechaCita();
    }
}
