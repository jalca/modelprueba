package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.RangoIngresoEconomicoEnum;
import pe.edu.lamolina.model.general.EstadoCivil;
import pe.edu.lamolina.model.general.Idioma;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.PersonaIdioma;
import pe.edu.lamolina.model.general.TipoDocIdentidad;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.seguridad.Usuario;

public class AbcDatosAlumnoAdapter1234 implements Serializable {
    
    /*

    private Long idAlumno;
    private Long idPersona;
    private Long idCicloAcademico;
    private String nroDocumento;
    private String paterno;
    private String materno;
    private String nombres;
    private String fechaNac;
    private Integer edad;
    private String sexo;
    private String matricula;
    private String direccionLima;
    private String telefonoLima;
    private String celularLima;
    private String direccionOrigen;
    private String telefonoOrigen;
    private String estadoFamilia;
    private String comentarioFamilia;
    private BigDecimal ingresoEconomico;
    private RangoIngresoEconomicoEnum ingresoEconomicoEnum;
    private String rangoIngreso;
    private String lugarTrabajo;
    private String laboraRealiza;
    private Usuario usuarioRegistro;
    private String emailPersonal;
    private String tipoFoto;
    private CicloAcademico cicloAcademico;
    private TipoDocIdentidad documentoIdentidad;
    private Ubicacion ubicacionNacer;
    private Pais paisNacer;
    private Pais paisDomicilio;
    private Pais paisOrigen;
    private Pais nacionalidad1;
    private Pais nacionalidad2;
    private EstadoCivil estadoCivil;
    private Idioma lenguaMaterna;
    private PersonaIdioma personaIdioma;
    private Ubicacion ubicacionLima;
    private Ubicacion ubicacionOrigen;
    private EstadoCivilPadres estadoCivilPadres;
    private ResideCon resideCon;
    private SituacionEconomica situacionEconomica;
    private CondicionTrabajo condicionTrabajo;
    private Boolean isGuardar;
    private ActividadDeporteCultura actividadDeporteCultura;
    private List<PersonaEnfermedad> personaEnfermedad;
    private List<AntecedenteDeporteColegio> antecedenteDeporteColegio;
    private List<AntecedenteCulturalColegio> antecedenteCulturalColegio;

    public AbcDatosAlumnoAdapter1234() {
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Ubicacion getUbicacionNacer() {
        return ubicacionNacer;
    }

    public void setUbicacionNacer(Ubicacion ubicacionNacer) {
        this.ubicacionNacer = ubicacionNacer;
    }

    public Pais getPaisNacer() {
        return paisNacer;
    }

    public void setPaisNacer(Pais paisNacer) {
        this.paisNacer = paisNacer;
    }

    public Pais getPaisDomicilio() {
        return paisDomicilio;
    }

    public void setPaisDomicilio(Pais paisDomicilio) {
        this.paisDomicilio = paisDomicilio;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Idioma getLenguaMaterna() {
        return lenguaMaterna;
    }

    public void setLenguaMaterna(Idioma lenguaMaterna) {
        this.lenguaMaterna = lenguaMaterna;
    }

    public String getDireccionLima() {
        return direccionLima;
    }

    public void setDireccionLima(String direccionLima) {
        this.direccionLima = direccionLima;
    }

    public Ubicacion getUbicacionLima() {
        return ubicacionLima;
    }

    public void setUbicacionLima(Ubicacion ubicacionLima) {
        this.ubicacionLima = ubicacionLima;
    }

    public String getTelefonoLima() {
        return telefonoLima;
    }

    public void setTelefonoLima(String telefonoLima) {
        this.telefonoLima = telefonoLima;
    }

    public String getCelularLima() {
        return celularLima;
    }

    public void setCelularLima(String celularLima) {
        this.celularLima = celularLima;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public Ubicacion getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(Ubicacion ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public String getTelefonoOrigen() {
        return telefonoOrigen;
    }

    public void setTelefonoOrigen(String telefonoOrigen) {
        this.telefonoOrigen = telefonoOrigen;
    }

    public EstadoCivilPadres getEstadoCivilPadres() {
        return estadoCivilPadres;
    }

    public void setEstadoCivilPadres(EstadoCivilPadres estadoCivilPadres) {
        this.estadoCivilPadres = estadoCivilPadres;
    }

    public ResideCon getResideCon() {
        return resideCon;
    }

    public void setResideCon(ResideCon resideCon) {
        this.resideCon = resideCon;
    }

    public String getEstadoFamilia() {
        return estadoFamilia;
    }

    public void setEstadoFamilia(String estadoFamilia) {
        this.estadoFamilia = estadoFamilia;
    }

    public String getComentarioFamilia() {
        return comentarioFamilia;
    }

    public void setComentarioFamilia(String comentarioFamilia) {
        this.comentarioFamilia = comentarioFamilia;
    }

    public SituacionEconomica getSituacionEconomica() {
        return situacionEconomica;
    }

    public void setSituacionEconomica(SituacionEconomica situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }

    public BigDecimal getIngresoEconomico() {
        return ingresoEconomico;
    }

    public void setIngresoEconomico(BigDecimal ingresoEconomico) {
        this.ingresoEconomico = ingresoEconomico;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getLaboraRealiza() {
        return laboraRealiza;
    }

    public void setLaboraRealiza(String laboraRealiza) {
        this.laboraRealiza = laboraRealiza;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public Long getIdCicloAcademico() {
        return idCicloAcademico;
    }

    public void setIdCicloAcademico(Long idCicloAcademico) {
        this.idCicloAcademico = idCicloAcademico;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Boolean getIsGuardar() {
        return isGuardar;
    }

    public void setIsGuardar(Boolean isGuardar) {
        this.isGuardar = isGuardar;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Pais getNacionalidad1() {
        return nacionalidad1;
    }

    public void setNacionalidad1(Pais nacionalidad1) {
        this.nacionalidad1 = nacionalidad1;
    }

    public Pais getNacionalidad2() {
        return nacionalidad2;
    }

    public void setNacionalidad2(Pais nacionalidad2) {
        this.nacionalidad2 = nacionalidad2;
    }

    public PersonaIdioma getPersonaIdioma() {
        return personaIdioma;
    }

    public void setPersonaIdioma(PersonaIdioma personaIdioma) {
        this.personaIdioma = personaIdioma;
    }

    public CondicionTrabajo getCondicionTrabajo() {
        return condicionTrabajo;
    }

    public void setCondicionTrabajo(CondicionTrabajo condicionTrabajo) {
        this.condicionTrabajo = condicionTrabajo;
    }

    public RangoIngresoEconomicoEnum getIngresoEconomicoEnum() {
        if (StringUtils.isBlank(rangoIngreso)) {
            return null;
        }
        return RangoIngresoEconomicoEnum.valueOf(rangoIngreso);
    }

    @JsonIgnore
    public void setIngresoEconomicoEnum(RangoIngresoEconomicoEnum ingresoEconomicoEnum) {
        this.ingresoEconomicoEnum = ingresoEconomicoEnum;
    }

    public String getRangoIngreso() {
        return rangoIngreso;
    }

    public void setRangoIngreso(String rangoIngreso) {
        this.rangoIngreso = rangoIngreso;
    }

    public ObjectNode toJson() {

        return JsonHelper.createJson(this, JsonNodeFactory.instance, true, new String[]{
            "*",
            "ingresoEconomicoEnum",
            "cicloAcademico.*",
            "documentoIdentidad.*",
            "ubicacionNacer.*",
            "paisNacer.*",
            "paisOrigen.*",
            "paisDomicilio.*",
            "estadoCivil.*",
            "lenguaMaterna.*",
            "ubicacionLima.*",
            "ubicacionOrigen.*",
            "estadoCivilPadres.*",
            "resideCon.*",
            "situacionEconomica.*",
            "nacionalidad1.*",
            "nacionalidad2.*",
            "personaIdioma.*",
            "condicionTrabajo.*",
            "personaEnfermedad.*",
            "actividadDeporteCultura.*",
            "actividadDeporteCultura.actividadCultural.*",
            "actividadDeporteCultura.alumno.id",
            "actividadDeporteCultura.deporteUnalm.id",
            "actividadDeporteCultura.culturalUnalm.id",
            "personaEnfermedad.*",
            "personaEnfermedad.persona.id",
            "personaEnfermedad.cicloAcademico.id",
            "antecedenteDeporteColegio.*",
            "antecedenteDeporteColegio.alumno.id",
            "antecedenteDeporteColegio.actividadDeporte.*",
            "antecedenteCulturalColegio.*",
            "antecedenteCulturalColegio.alumno.id",
            "antecedenteCulturalColegio.actividadCultural.id"
        });
    }

    public String getTipoFoto() {
        return tipoFoto;
    }

    public void setTipoFoto(String tipoFoto) {
        this.tipoFoto = tipoFoto;
    }

    public ActividadDeporteCultura getActividadDeporteCultura() {
        return actividadDeporteCultura;
    }

    public void setActividadDeporteCultura(ActividadDeporteCultura actividadDeporteCultura) {
        this.actividadDeporteCultura = actividadDeporteCultura;
    }

    public List<PersonaEnfermedad> getPersonaEnfermedad() {
        return personaEnfermedad;
    }

    public void setPersonaEnfermedad(List<PersonaEnfermedad> personaEnfermedad) {
        this.personaEnfermedad = personaEnfermedad;
    }

    public List<AntecedenteDeporteColegio> getAntecedenteDeporteColegio() {
        return antecedenteDeporteColegio;
    }

    public void setAntecedenteDeporteColegio(List<AntecedenteDeporteColegio> antecedenteDeporteColegio) {
        this.antecedenteDeporteColegio = antecedenteDeporteColegio;
    }

    public List<AntecedenteCulturalColegio> getAntecedenteCulturalColegio() {
        return antecedenteCulturalColegio;
    }

    public void setAntecedenteCulturalColegio(List<AntecedenteCulturalColegio> antecedenteCulturalColegio) {
        this.antecedenteCulturalColegio = antecedenteCulturalColegio;
    }
    
    //*****/

}
