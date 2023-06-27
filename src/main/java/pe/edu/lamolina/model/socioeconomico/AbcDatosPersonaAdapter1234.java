package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.RangoIngresoEconomicoEnum;
import pe.edu.lamolina.model.general.EstadoCivil;
import pe.edu.lamolina.model.general.TipoDocIdentidad;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

public class AbcDatosPersonaAdapter1234 implements Serializable {

    private Long idPersonaAlumno;
    private Long idPersonaVinculada;
    private String nroDocumento;
    private String paterno;
    private String materno;
    private String nombres;
    private Integer edad;
    private Integer vive;
    private Integer tutor;
    private Integer casoEmergencia;
    private String telefono;
    private String celular;
    private String correo;
    private String especificaGradoInstruccion;
    private String especificaProfesion;
    private String especificaOcupacion;
    private String especificaCondicionTrabajo;
    private String centroTrabajo;
    private BigDecimal ingreso;
    private String rangoIngreso;
    private Integer tieneEnfermedad;
    private String centroEstudios;
    private BigDecimal pensionEstudios;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaNac;

    private CicloAcademico cicloAcademico;
    private TipoDocIdentidad documentoIdentidad;
    private EstadoCivil estadoCivil;
    private GradoInstruccion gradoInstruccion;
    private Profesion profesion;
    private Ocupacion ocupacion;
    private CondicionTrabajo condicionTrabajo;
    private VinculoFamiliar parentesco;
    private Usuario usuarioRegistro;
    private List<PersonaEnfermedad> enfermedades;

    public AbcDatosPersonaAdapter1234() {
    }

    public Long getIdPersonaAlumno() {
        return idPersonaAlumno;
    }

    public void setIdPersonaAlumno(Long idPersonaAlumno) {
        this.idPersonaAlumno = idPersonaAlumno;
    }

    public Long getIdPersonaVinculada() {
        return idPersonaVinculada;
    }

    public void setIdPersonaVinculada(Long idPersonaVinculada) {
        this.idPersonaVinculada = idPersonaVinculada;
    }

    public TipoDocIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(TipoDocIdentidad documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getVive() {
        return vive;
    }

    public void setVive(Integer vive) {
        this.vive = vive;
    }

    public Integer getTutor() {
        return tutor;
    }

    public void setTutor(Integer tutor) {
        this.tutor = tutor;
    }

    public Integer getCasoEmergencia() {
        return casoEmergencia;
    }

    public void setCasoEmergencia(Integer casoEmergencia) {
        this.casoEmergencia = casoEmergencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public GradoInstruccion getGradoInstruccion() {
        return gradoInstruccion;
    }

    public void setGradoInstruccion(GradoInstruccion gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }

    public String getEspecificaGradoInstruccion() {
        return especificaGradoInstruccion;
    }

    public void setEspecificaGradoInstruccion(String especificaGradoInstruccion) {
        this.especificaGradoInstruccion = especificaGradoInstruccion;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public String getEspecificaProfesion() {
        return especificaProfesion;
    }

    public void setEspecificaProfesion(String especificaProfesion) {
        this.especificaProfesion = especificaProfesion;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEspecificaOcupacion() {
        if (especificaOcupacion == null) {
            return "Ninguno";
        }
        return especificaOcupacion;
    }

    public void setEspecificaOcupacion(String especificaOcupacion) {
        this.especificaOcupacion = especificaOcupacion;
    }

    public CondicionTrabajo getCondicionTrabajo() {
        return condicionTrabajo;
    }

    public void setCondicionTrabajo(CondicionTrabajo condicionTrabajo) {
        this.condicionTrabajo = condicionTrabajo;
    }

    public String getEspecificaCondicionTrabajo() {
        return especificaCondicionTrabajo;
    }

    public void setEspecificaCondicionTrabajo(String especificaCondicionTrabajo) {
        this.especificaCondicionTrabajo = especificaCondicionTrabajo;
    }

    public String getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(String centroTrabajo) {
        this.centroTrabajo = centroTrabajo;
    }

    public BigDecimal getIngreso() {
        return ingreso;
    }

    public void setIngreso(BigDecimal ingreso) {
        this.ingreso = ingreso;
    }

    public Integer getTieneEnfermedad() {
        return tieneEnfermedad;
    }

    public void setTieneEnfermedad(Integer tieneEnfermedad) {
        this.tieneEnfermedad = tieneEnfermedad;
    }

    public VinculoFamiliar getParentesco() {
        return parentesco;
    }

    public void setParentesco(VinculoFamiliar parentesco) {
        this.parentesco = parentesco;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCentroEstudios() {
        return centroEstudios;
    }

    public void setCentroEstudios(String centroEstudios) {
        this.centroEstudios = centroEstudios;
    }

    public BigDecimal getPensionEstudios() {
        return pensionEstudios;
    }

    public void setPensionEstudios(BigDecimal pensionEstudios) {
        this.pensionEstudios = pensionEstudios;
    }

    public List<PersonaEnfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<PersonaEnfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getRangoIngreso() {
        return rangoIngreso;
    }

    public void setRangoIngreso(String rangoIngreso) {
        this.rangoIngreso = rangoIngreso;
    }

    @JsonIgnore
    public RangoIngresoEconomicoEnum getRangoIngresoEnum() {
        if (StringUtils.isBlank(rangoIngreso)) {
            return null;
        }
        return RangoIngresoEconomicoEnum.valueOf(rangoIngreso);
    }

    @JsonIgnore
    public void setRangoIngresoEnum(RangoIngresoEconomicoEnum rangoIngreso) {
        this.rangoIngreso = rangoIngreso.name();
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, new String[]{
            "*",
            "cicloAcademico.*",
            "documentoIdentidad.*",
            "estadoCivil.*",
            "gradoInstruccion.*",
            "profesion.*",
            "ocupacion.*",
            "condicionTrabajo.*",
            "parentesco.*",
            "usuarioRegistro.*",
            "enfermedades.*",
            "enfermedades.persona.id",
            "enfermedades.persona.paterno",
            "enfermedades.persona.materno",
            "enfermedades.persona.nombres",
            "enfermedades.persona.sexo",
            "enfermedades.persona.email",
            "enfermedades.persona.emailCompania",
            "enfermedades.persona.celular",
            "enfermedades.persona.telefono",
            "enfermedades.persona.direccion",
            "enfermedades.persona.numeroDocIdentidad",
            "enfermedades.persona.tituloAcademico",
            "enfermedades.persona.tipoDocumento.*",
            "enfermedades.cicloAcademico.*"
        });
    }
}
