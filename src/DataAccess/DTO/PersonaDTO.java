package DataAccess.DTO;

public class PersonaDTO {

    private Integer   IdPersona;
    private Integer   IdCatalogoRol;
    private Integer   IdCatalogoSexo;
    private Integer   IdCatalogoTipoIdentificacion;
    private String    NumeroIdentificacion;
    private String    PrimerNombre;
    private String    SegundoNombre;
    private String    PrimerApellido;
    private String    SegundoApellido;
    private String    FechaNacimiento;
    private String    Direccion;
    private String    EstadoRegistro;
    private String    FechaCreacion;
    private String    FechaModificacion;

    public PersonaDTO() {
    }

    public PersonaDTO(Integer idCatalogoRol, Integer idCatalogoSexo,
            Integer idCatalogoTipoIdentificacion, String numeroIdentificacion, String primerNombre,
            String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento,
            String direccion) {

        this.IdCatalogoRol = idCatalogoRol;
        this.IdCatalogoSexo = idCatalogoSexo;
        this.IdCatalogoTipoIdentificacion = idCatalogoTipoIdentificacion;
        this.NumeroIdentificacion = numeroIdentificacion;
        this.PrimerNombre = primerNombre;
        this.SegundoNombre = segundoNombre;
        this.PrimerApellido = primerApellido;
        this.SegundoApellido = segundoApellido;
        this.FechaNacimiento = fechaNacimiento;
        this.Direccion = direccion;
    }

    public PersonaDTO(Integer idPersona, Integer idCatalogoRol, Integer idCatalogoSexo, 
                      Integer idCatalogoTipoIdentificacion, String numeroIdentificacion, String primerNombre,
                      String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento,
                      String direccion, String estadoRegistro, String fechaCreacion, String fechaModificacion) {

        this.IdPersona = idPersona;
        this.IdCatalogoRol = idCatalogoRol;
        this.IdCatalogoSexo = idCatalogoSexo;
        this.IdCatalogoTipoIdentificacion = idCatalogoTipoIdentificacion;
        this.NumeroIdentificacion = numeroIdentificacion;
        this.PrimerNombre = primerNombre;
        this.SegundoNombre = segundoNombre;
        this.PrimerApellido = primerApellido;
        this.SegundoApellido = segundoApellido;
        this.FechaNacimiento = fechaNacimiento;
        this.Direccion = direccion;
        this.EstadoRegistro = estadoRegistro;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }

    public Integer getIdCatalogoRol() {
        return IdCatalogoRol;
    }

    public void setIdCatalogoRol(Integer idCatalogoRol) {
        IdCatalogoRol = idCatalogoRol;
    }

    public Integer getIdCatalogoSexo() {
        return IdCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        IdCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoTipoIdentificacion() {
        return IdCatalogoTipoIdentificacion;
    }

    public void setIdCatalogoTipoIdentificacion(Integer idCatalogoTipoIdentificacion) {
        IdCatalogoTipoIdentificacion = idCatalogoTipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        NumeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
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
        + "\n IdPersona:                    "+ getIdPersona()            
        + "\n IdCatalogoRol:                "+ getIdCatalogoRol()     
        + "\n IdCatalogoSexo:               "+ getIdCatalogoSexo()      
        + "\n IdCatalogoTipoIdentificacion: "+ getIdCatalogoTipoIdentificacion()      
        + "\n NumeroIdentificacion:         "+ getNumeroIdentificacion()      
        + "\n PrimerNombre:                 "+ getPrimerNombre()      
        + "\n SegundoNombre:                "+ getSegundoNombre()      
        + "\n PrimerApellido:               "+ getPrimerApellido()      
        + "\n SegundoApellido:              "+ getSegundoApellido()      
        + "\n FechaNacimiento:              "+ getFechaNacimiento()      
        + "\n Direccion:                    "+ getDireccion()      
        + "\n EstadoRegistro:               "+ getEstadoRegistro()  
        + "\n FechaCreacion:                "+ getFechaCreacion()    
        + "\n FechaModifica:                "+ getFechaModificacion();
    } 
    
}
