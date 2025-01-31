package DataAccess.DTO;

import java.text.SimpleDateFormat;

public class CitaDTO {
    
    private Integer IdCita;
    private Integer IdMedico;
    private Integer IdPaciente;
    private String  FechaCita;
    private String  HoraCita;
    private String  EstadoRegistro;
    private String  FechaCreacion;
    private String  FechaModificacion;
    private String medico;
    private String paciente;
    private String fechaCita;
    private String horaCita;
    private String estadoRegistro;
    private String fechaCreacion;
    private String fechaModificacion;

    public CitaDTO(int idCita, int idPaciente2, int idPaciente3, String fechaCita, String horaCita) {}


    public CitaDTO(Integer idCita, Integer idMedico, Integer idPaciente, String fechaCita, String horaCita, String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdCita = idCita;
        this.IdMedico = idMedico;
        this.IdPaciente = idPaciente;
        this.FechaCita = fechaCita;
        this.HoraCita = horaCita;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public CitaDTO(int idCita, String medico, String paciente, String fechaCita, String horaCita,
                   String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.IdCita = idCita;
        this.medico = medico;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.estadoRegistro = estadoRegistro;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdCita() {
        return IdCita;
    }

    public void setIdCita(Integer idCita) {
        IdCita = idCita;
    }

    public Integer getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(Integer idMedico) {
        IdMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public String getFechaCita() {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return FechaCita;
    }

    public void setFechaCita(String fechaCita) {
        FechaCita = fechaCita;
    }

    public String getHoraCita() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return HoraCita;
    }

    public void setHoraCita(String horaCita) {
        HoraCita = horaCita;
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
    
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdCita:         "+ getIdCita()            
        + "\n IdMedico:       "+ getIdMedico()     
        + "\n IdPaciente:     "+ getIdPaciente()     
        + "\n FechaCita:      "+ getFechaCita()     
        + "\n HoraCita:       "+ getHoraCita()     
        + "\n EstadoRegistro: "+ getEstadoRegistro()  
        + "\n FechaCreacion:  "+ getFechaCreacion()    
        + "\n FechaModifica:  "+ getFechaModificacion();
    }
}
