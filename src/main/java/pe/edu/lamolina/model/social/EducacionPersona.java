package pe.edu.lamolina.model.social;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.EstadoEducacionPersonaEnum;
import pe.edu.lamolina.model.enums.NivelGradoNetworkingEnum;
import pe.edu.lamolina.model.enums.SituacionAcademicaNetworkingEnum;
import pe.edu.lamolina.model.enums.TipoGradoEnum;
import pe.edu.lamolina.model.enums.ValidadorDocumentoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "soc_educacion_persona")
public class EducacionPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "principal")
    private Boolean principal;

    @Column(name = "nombre_colegio")
    private String nombreColegio;

    @Column(name = "fecha_inicio")
    private Integer fechaInicio;

    @Column(name = "fecha_fin")
    private Integer fechaFin;

    @Column(name = "otro_titulo_academico")
    private String otroTituloAcademico;

    @Column(name = "numero_registro")
    private String numeroRegistro;

    @Column(name = "numero_resolucion")
    private String numeroResolucion;

    @Column(name = "otro_disciplina_academica")
    private String otroDisciplinaAcademica;

    @Column(name = "carrera_otro")
    private String carreraOtro;

    @Column(name = "universidad_otro")
    private String universidadOtro;

    @Column(name = "ruta_foto_diploma")
    private String rutaFotoDiploma;

    @Column(name = "year_inicio")
    private Integer yearInicio;

    @Column(name = "year_fin")
    private Integer yearFin;

    @Column(name = "validador")
    private String validador;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "tipo_grado")
    private String tipoGrado;

    @Column(name = "nivel_grado")
    private String nivelGrado;

    @Column(name = "situacion")
    private String situacion;

    @Column(name = "promedio_ponderado")
    private BigDecimal promedioPonderado;

    @Column(name = "orden_merito")
    private Integer ordenMerito;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "gestion_universidad")
    private String gestionUniversidad;

    @Column(name = "fecha_validacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaValidacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio")
    private Colegio colegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_colegio")
    private Pais paisColegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_universidad")
    private Pais paisUniversidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_titulo_academico")
    private TituloAcademico tituloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina_academica")
    private DisciplinaAcademica disciplinaAcademica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_diploma")
    private Archivo archivoDiploma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_certificado")
    private Archivo archivoCertificado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_merito")
    private Archivo archivoMerito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion")
    private Usuario userValidacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private boolean carreraProcedenciaSelected;

    @Transient
    private List<EducacionPersona> educacionPersona;

    @Transient
    private String descripcion;

    @Transient
    private String institucion;

    @Transient
    private String paisProc;

    @Transient
    private String tipoInst;

    public EducacionPersona() {
        this.principal = false;
    }

    public EducacionPersona(Object id) {
        this.id = TypesUtil.getLong(id);
        this.principal = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getCarreraOtro() {
        return carreraOtro;
    }

    public void setCarreraOtro(String carreraOtro) {
        this.carreraOtro = carreraOtro;
    }

    public Pais getPaisColegio() {
        return paisColegio;
    }

    public void setPaisColegio(Pais paisColegio) {
        this.paisColegio = paisColegio;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Integer getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Integer fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Integer fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TituloAcademico getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(TituloAcademico tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public String getOtroTituloAcademico() {
        return otroTituloAcademico;
    }

    public void setOtroTituloAcademico(String otroTituloAcademico) {
        this.otroTituloAcademico = otroTituloAcademico;
    }

    public DisciplinaAcademica getDisciplinaAcademica() {
        return disciplinaAcademica;
    }

    public void setDisciplinaAcademica(DisciplinaAcademica disciplinaAcademica) {
        this.disciplinaAcademica = disciplinaAcademica;
    }

    public String getOtroDisciplinaAcademica() {
        return otroDisciplinaAcademica;
    }

    public void setOtroDisciplinaAcademica(String otroDisciplinaAcademica) {
        this.otroDisciplinaAcademica = otroDisciplinaAcademica;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Integer getYearInicio() {
        return yearInicio;
    }

    public void setYearInicio(Integer yearInicio) {
        this.yearInicio = yearInicio;
    }

    public Integer getYearFin() {
        return yearFin;
    }

    public void setYearFin(Integer yearFin) {
        this.yearFin = yearFin;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoGrado() {
        return tipoGrado;
    }

    public void setTipoGrado(String tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

    public Date getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(Date fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }

    public Archivo getArchivoDiploma() {
        return archivoDiploma;
    }

    public void setArchivoDiploma(Archivo archivoDiploma) {
        this.archivoDiploma = archivoDiploma;
    }

    public Archivo getArchivoCertificado() {
        return archivoCertificado;
    }

    public void setArchivoCertificado(Archivo archivoCertificado) {
        this.archivoCertificado = archivoCertificado;
    }

    public Archivo getArchivoMerito() {
        return archivoMerito;
    }

    public void setArchivoMerito(Archivo archivoMerito) {
        this.archivoMerito = archivoMerito;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getUniversidadOtro() {
        return universidadOtro;
    }

    public void setUniversidadOtro(String universidadOtro) {
        this.universidadOtro = universidadOtro;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public String getRutaFotoDiploma() {
        return rutaFotoDiploma;
    }

    public void setRutaFotoDiploma(String rutaFotoDiploma) {
        this.rutaFotoDiploma = rutaFotoDiploma;
    }

    public boolean isCarreraProcedenciaSelected() {
        return carreraProcedenciaSelected;
    }

    public void setCarreraProcedenciaSelected(boolean carreraProcedenciaSelected) {
        this.carreraProcedenciaSelected = carreraProcedenciaSelected;
    }

    public Pais getPaisUniversidad() {
        return paisUniversidad;
    }

    public void setPaisUniversidad(Pais paisUniversidad) {
        this.paisUniversidad = paisUniversidad;
    }

    public EstadoEducacionPersonaEnum getEstadoEnum() {
        if (Strings.isNullOrEmpty(this.estado)) {
            return null;
        }
        return EstadoEducacionPersonaEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEducacionPersonaEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public ValidadorDocumentoEnum getValidadorEnum() {
        if (Strings.isNullOrEmpty(this.validador)) {
            return null;
        }
        return ValidadorDocumentoEnum.valueOf(this.validador);
    }

    @JsonIgnore
    public void setValidadorEnum(ValidadorDocumentoEnum validadorEnum) {
        if (validadorEnum == null) {
            return;
        }
        this.validador = validadorEnum.name();
    }

    public TipoGradoEnum getTipoGradoEnum() {
        if (Strings.isNullOrEmpty(this.tipoGrado)) {
            return null;
        }
        return TipoGradoEnum.valueOf(this.tipoGrado);
    }

    @JsonIgnore
    public void setTipoGradoEnum(TipoGradoEnum tipoGradoEnum) {
        if (tipoGradoEnum == null) {
            return;
        }
        this.tipoGrado = tipoGradoEnum.name();
    }

    public BigDecimal getPromedioPonderado() {
        return promedioPonderado;
    }

    public void setPromedioPonderado(BigDecimal promedioPonderado) {
        this.promedioPonderado = promedioPonderado;
    }

    public Integer getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(Integer ordenMerito) {
        this.ordenMerito = ordenMerito;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPaisProc() {
        return paisProc;
    }

    public void setPaisProc(String paisProc) {
        this.paisProc = paisProc;
    }

    public String getTipoInst() {
        return tipoInst;
    }

    public void setTipoInst(String tipoInst) {
        this.tipoInst = tipoInst;
    }

    public List<EducacionPersona> getEducacionPersona() {
        return educacionPersona;
    }

    public void setEducacionPersona(List<EducacionPersona> educacionPersona) {
        this.educacionPersona = educacionPersona;
    }

    public String getGestionUniversidad() {
        return gestionUniversidad;
    }

    public void setGestionUniversidad(String gestionUniversidad) {
        this.gestionUniversidad = gestionUniversidad;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getNivelGrado() {
        return nivelGrado;
    }

    public void setNivelGrado(String nivelGrado) {
        this.nivelGrado = nivelGrado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Usuario getUserValidacion() {
        return userValidacion;
    }

    public void setUserValidacion(Usuario userValidacion) {
        this.userValidacion = userValidacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public NivelGradoNetworkingEnum getNivelGradoEnum() {
        if (Strings.isNullOrEmpty(this.nivelGrado)) {
            return null;
        }
        return NivelGradoNetworkingEnum.valueOf(this.nivelGrado);
    }

    @JsonIgnore
    public void setNivelGradoEnum(NivelGradoNetworkingEnum nivelGradoNetworkingEnum) {
        if (nivelGradoNetworkingEnum == null) {
            return;
        }
        this.nivelGrado = nivelGradoNetworkingEnum.name();
    }

    public SituacionAcademicaNetworkingEnum getSituacionEnum() {
        if (Strings.isNullOrEmpty(this.situacion)) {
            return null;
        }
        return SituacionAcademicaNetworkingEnum.valueOf(this.situacion);
    }

    @JsonIgnore
    public void setSituacionEnum(SituacionAcademicaNetworkingEnum situacionAcademicaNetworkingEnum) {
        if (situacionAcademicaNetworkingEnum == null) {
            return;
        }
        this.nivelGrado = situacionAcademicaNetworkingEnum.name();
    }

    public static class CompareGradoYear implements Comparator<EducacionPersona> {

        @Override
        public int compare(EducacionPersona ep1, EducacionPersona ep2) {
            TipoGradoEnum tipo1 = ep1.getTipoGradoEnum();
            TipoGradoEnum tipo2 = ep2.getTipoGradoEnum();
            if (tipo1 == null && tipo2 != null) {
                return -1;
            }
            if (tipo1 != null && tipo2 == null) {
                return 1;
            }
            if (tipo1 != null && tipo2 != null) {
                if (tipo1.getPeso().intValue() != tipo2.getPeso()) {
                    return tipo2.getPeso().compareTo(tipo1.getPeso());
                }
            }

            if (ep2.getYearFin() == null && ep1.getYearFin() != null) {
                return -1;
            }
            if (ep2.getYearFin() != null && ep1.getYearFin() == null) {
                return 1;
            }
            if (ep2.getYearFin() == null && ep1.getYearFin() == null) {
                return 0;
            }
            if (ep2.getYearFin().compareTo(ep1.getYearFin()) != 0) {
                return ep2.getYearFin().compareTo(ep1.getYearFin());
            }

            if (ep2.getSemestre() == null && ep1.getSemestre() != null) {
                return -1;
            }
            if (ep2.getSemestre() != null && ep1.getSemestre() == null) {
                return 1;
            }
            if (ep2.getSemestre() == null && ep1.getSemestre() == null) {
                return 0;
            }
            return ep2.getSemestre().compareTo(ep1.getSemestre());

        }
    }

}
