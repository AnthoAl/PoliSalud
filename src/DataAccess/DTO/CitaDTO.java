package DataAccess.DTO;

public class CitaDTO {

    private Integer idCita;
    private Integer idMedico;
    private Integer idPaciente;
    private String fechaCita;
    private Integer horaCita;
    private String estadoRegistro;
    private String fechaCreacion;
    private String fechaModificacion;
    private String medico;
    private String paciente;

    public CitaDTO(Integer idCita, Integer idMedico, Integer idPaciente, String fechaCita, Integer horaCita,
                   String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.idCita = idCita;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.estadoRegistro = estadoRegistro;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public CitaDTO(Integer idCita, String medico, String paciente, String fechaCita, Integer horaCita,
                   String estadoRegistro, String fechaCreacion, String fechaModificacion) {
        this.idCita = idCita;
        this.medico = medico;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.estadoRegistro = estadoRegistro;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters and setters
    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Integer getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Integer horaCita) {
        this.horaCita = horaCita;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
    public String toString() {
        return "CitaDTO{" +
                "idCita=" + idCita +
                ", idMedico=" + idMedico +
                ", idPaciente=" + idPaciente +
                ", fechaCita='" + fechaCita + '\'' +
                ", horaCita=" + horaCita +
                ", estadoRegistro='" + estadoRegistro + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                ", medico='" + medico + '\'' +
                ", paciente='" + paciente + '\'' +
                '}';
    }
}
