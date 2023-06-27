package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.albatross.zelpers.spring.deserializer.DateDeserializer;
import pe.edu.lamolina.model.extensionobu.TallerVerano;
import pe.edu.lamolina.model.consejeria.AlumnoConsejero;
import pe.edu.lamolina.model.consejeria.Consejero;
import static pe.edu.lamolina.model.constantines.AcademicoConstantine.CAPA_ULTIMO_CICLO;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.tramite.AutorizacionRegistro;
import pe.edu.lamolina.model.tramite.RetiroCiclo;
import pe.edu.lamolina.model.tramite.RetiroCurso;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.enums.AlumnoEstadoEnum;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G01;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G02;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G03;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G04;
import pe.edu.lamolina.model.enums.ModalidadEstudioEnum;
import pe.edu.lamolina.model.enums.SituacionAcademicaEnum;
import static pe.edu.lamolina.model.enums.SituacionAcademicaEnum.S_5;
import static pe.edu.lamolina.model.enums.SituacionAcademicaEnum.S_N;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.posgrado.AlumnoResumenCuotas;
import pe.edu.lamolina.model.posgrado.admision.PostulanteEscuela;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.social.EducacionPersona;
import pe.edu.lamolina.model.socioeconomico.PersonaVinculoFamiliar;
import pe.edu.lamolina.model.tramite.Resolucion;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "aca_alumno")
public class Alumno implements Serializable, Cloneable, Comparable<Alumno> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "con_error")
    private Boolean conError;

    @Column(name = "retiros_cursos")
    private Integer retirosCursos;

    @Column(name = "retiros_ciclos")
    private Integer retirosCiclos;

    @Column(name = "retiros_extemporaneos")
    private Integer retirosExtemporaneos;

    @Column(name = "creditos_cursados")
    private Integer creditosCursados;

    @Column(name = "creditos_aprobados")
    private Integer creditosAprobados;

    @Column(name = "creditos_convalidados")
    private Integer creditosConvalidados;

    @Column(name = "puntaje")
    private Integer puntaje;

    @Column(name = "cursos_inscritos")
    private Integer cursosInscritos;

    @Column(name = "cursos_aprobados")
    private Integer cursosAprobados;

    @Column(name = "creditos_carrera_cursados")
    private Integer creditosCarreraCursados;

    @Column(name = "creditos_carrera_aprobados")
    private Integer creditosCarreraAprobados;

    @Column(name = "cursos_carrera_inscritos")
    private Integer cursosCarreraInscritos;

    @Column(name = "cursos_carrera_aprobados")
    private Integer cursosCarreraAprobados;

    @Column(name = "promedio_acumulado")
    private BigDecimal promedioAcumulado;

    @Column(name = "promedio_carrera_acumulado")
    private BigDecimal promedioCarreraAcumulado;

    @Column(name = "promedio_ultimo_ciclo")
    private BigDecimal promedioUltimoCiclo;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @Column(name = "email_ingresante")
    private String emailIngresante;

    @Column(name = "clave_email_ingresante")
    private String claveEmailIngresante;

    @Column(name = "ciclos_estudiados")
    private Integer ciclosEstudiados;

    @Column(name = "promedio_procesado")
    private Boolean promedioProcesado;

    @Column(name = "ciclos_regulares_estudiados")
    private Integer ciclosRegularesEstudiados;

    @Column(name = "ciclos_consecutivos_sin_estudiar")
    private Integer ciclosConsecutivosSinEstudiar;

    @Column(name = "ciclos_alternos_sin_estudiar")
    private Integer ciclosAlternosSinEstudiar;

    @Column(name = "ingreso_alumno_historico")
    private String ingresoAlumnoHistorico;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_resolucion_ingreso")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaResolucionIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orientacion_carrera")
    private OrientacionCarrera orientacionCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_ingreso")
    private CicloAcademico cicloIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_activo")
    private CicloAcademico cicloActivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_activo_regular")
    private CicloAcademico cicloActivoRegular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ultimo_retiro")
    private CicloAcademico ultimoRetiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_academica")
    private SituacionAcademica situacionAcademica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_pregrado")
    private Postulante postulantePregrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_curricular")
    private PlanCurricular planCurricular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consejero")
    private Consejero consejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_procedencia")
    private EducacionPersona carreraProcedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_optativo")
    private ModalidadOptativo modalidadOptativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion_ingreso")
    private Resolucion resolucionIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_resolucion_ingreso")
    private Usuario userResolucionIngreso;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AlumnoCiclo> alumnoCiclo;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AlumnoEvaluacion> alumnoEvaluacion;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<LoggerMatricula> loggerMatricula;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<MatriculaResumen> matriculaResumen;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<ReclamoNota> reclamoNota;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AutorizacionRegistro> autorizacionRegistro;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<RetiroCiclo> retiroCiclo;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCurso;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<Tramite> tramite;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AlumnoConsejero> alumnoConsejero;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AlumnoOmisoEleccion> alumnoOmisoEleccions;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<TallerVerano> talleresVerano;

    @Transient
    private String codigoEspecialidad;
    @Transient
    private String codigoPostgrado;
    @Transient
    private String situacion;
    @Transient
    private String email;
    @Transient
    private String codigoCicloIngreso;
    @Transient
    private String codigoCicloActivo;
    @Transient
    private String motivoMatriculable;
    @Transient
    private String motivoAnulacion;
    @Transient
    private Long numeroTicket;
    @Transient
    private String tipoPrioridadComedor;
    @Transient
    private Boolean hayCruceHorario;
    @Transient
    private AlumnoResumenCuotas alumnoResumenCuotas;

    @Transient
    private Boolean ticketComedorAuto;

    @Transient
    private Boolean esMatriculaCondicional;

    @Transient
    private Boolean esMatriculableSuspendido;

    @Transient
    private Boolean esMatBeneficioUltCicl;

    @Transient
    private Integer index;

    @Transient
    @JsonIgnore
    private AlumnoCiclo alumnoCicloActivoRegular;

    @Transient
    @JsonIgnore
    private AlumnoCiclo alumnoCicloActivo;

    @Transient
    private EducacionPersona educacionPersona;

    @Transient
    private List<TipoEvaluacion> tipoEvaluacionesTransient;

    @Transient
    private int creditosConvalidadosTransient;

    @Transient
    private List<PersonaVinculoFamiliar> personaVinculoFamiliars;

    @Transient
    private Long ciclosRegularesTransient;

    @Transient
    private Long ciclosVeranosTransient;

    @Transient
    private String resolucionTitulo;

    @Transient
    private String resolucionBachiller;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaTitulo;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaBachiller;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaEgreso;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaMatricula;

    @Transient
    private String promedioPonderadoGraduacion;

    @Transient
    private String tutorOcoordinador;
    
    @Transient
    private String resolucionBachillerFacultad;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaBachillerFacultad;

    public Alumno(String codigo, String codigoEspecialidad, String codigoPostgrado, String situacion, String email) {
        this.codigo = codigo;
        this.codigoEspecialidad = codigoEspecialidad;
        this.codigoPostgrado = codigoPostgrado;
        this.situacion = situacion;
        this.email = email;
    }

    public Alumno(Long id, String codigo, Persona persona) {
        this.id = id;
        this.codigo = codigo;
        this.persona = persona;
    }

    public Alumno() {
        this.promedioAcumulado = BigDecimal.ZERO;
        this.promedioCarreraAcumulado = BigDecimal.ZERO;

        this.retirosCiclos = 0;
        this.retirosCursos = 0;
        this.retirosExtemporaneos = 0;
        this.creditosAprobados = 0;
        this.creditosCarreraAprobados = 0;
        this.creditosCarreraCursados = 0;
        this.creditosCursados = 0;
        this.creditosConvalidados = 0;
        this.ciclosAlternosSinEstudiar = 0;
        this.ciclosConsecutivosSinEstudiar = 0;
        this.ciclosEstudiados = 0;
        this.ciclosRegularesEstudiados = 0;
        this.puntaje = 0;
        this.cursosAprobados = 0;
        this.cursosCarreraAprobados = 0;
        this.cursosCarreraInscritos = 0;
        this.cursosInscritos = 0;
    }

    public Alumno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getCreditosAprobadosConvalidados() {
        int convalidados = creditosConvalidados == null ? 0 : creditosConvalidados;
        int aprobados = creditosAprobados == null ? 0 : creditosAprobados;
        return convalidados + aprobados;
    }

    public boolean isPerteneceUltimoCiclo() {
        int convalidados = creditosConvalidados == null ? 0 : creditosConvalidados;
        int aprobados = creditosAprobados == null ? 0 : creditosAprobados;
        return convalidados + aprobados >= CAPA_ULTIMO_CICLO;
    }

    public double getPromedioAcumuladoFixed() {
        double scale = Math.pow(10, 2);
        if (this.promedioAcumulado == null) {
            return 0d;
        }
        return Math.round(promedioAcumulado.doubleValue() * scale) / scale;
    }

    @JsonIgnore
    public void setEstadoEnum(AlumnoEstadoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public AlumnoEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return AlumnoEstadoEnum.valueOf(estado);
    }

    public boolean isPostgrado() {
        if (modalidadEstudio == null) {
            return false;
        }
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.EPG);
    }

    public boolean isEspecial() {
        if (modalidadEstudio == null) {
            return false;
        }
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.ESP);
    }

    public boolean isVisitante() {
        if (modalidadEstudio == null) {
            return false;
        }
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.VIS);
    }

    public boolean isPregrado() {
        if (modalidadEstudio == null) {
            return false;
        }
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.PRE);
    }

    public Boolean getIsPostgrado() {
        return this.isPostgrado();
    }

    public Boolean getIsPregrado() {
        return this.isPregrado();
    }

    public Boolean getIsEspecial() {
        return this.isEspecial();
    }

    public Boolean getIsVisitante() {
        return this.isVisitante();
    }

    public Boolean getHayCruceHorario() {
        if (hayCruceHorario == null) {
            return false;
        }
        return hayCruceHorario;
    }

    public Boolean getTicketComedorAuto() {
        if (ticketComedorAuto == null) {
            return false;
        }
        return ticketComedorAuto;
    }

    public void setTicketComedorAuto(Boolean ticketComedorAuto) {
        if (ticketComedorAuto == null) {
            this.ticketComedorAuto = false;
        }
        this.ticketComedorAuto = ticketComedorAuto;
    }

    public boolean getIsTipoRegular() {
        List<SituacionAcademicaEnum> situacionesReg = Arrays.asList(
                SituacionAcademicaEnum.S_N,
                SituacionAcademicaEnum.S_5,
                SituacionAcademicaEnum.S_8,
                SituacionAcademicaEnum.S_9,
                SituacionAcademicaEnum.S_E,
                SituacionAcademicaEnum.S_EM,
                SituacionAcademicaEnum.S_A,
                SituacionAcademicaEnum.S_G,
                SituacionAcademicaEnum.S_1,
                SituacionAcademicaEnum.S_4,
                SituacionAcademicaEnum.S_MD,
                SituacionAcademicaEnum.S_T,
                SituacionAcademicaEnum.S_U,
                SituacionAcademicaEnum.S_X,
                SituacionAcademicaEnum.S_XD
        );

        if (this.alumnoCicloActivoRegular == null) {
            if (this.getSituacionAcademica() == null) {
                return false;
            }
            return situacionesReg.contains(this.getSituacionAcademica().getCodigoEnum());
        }
        if (this.alumnoCicloActivoRegular.getSituacionFinal() == null) {
            return false;
        }

        return situacionesReg.contains(this.alumnoCicloActivoRegular.getSituacionFinal().getCodigoEnum());
    }

    public boolean getIsTipoAltoRendimiento() {
        if (this.getAlumnoCicloActivoRegular() == null) {
            return false;
        }
        if (this.getAlumnoCicloActivoRegular().getPromedioCiclo() == null) {
            return false;
        }

        if (this.getAlumnoCicloActivoRegular().getPromedioCiclo().compareTo(new BigDecimal(14)) >= 0
                || this.getAlumnoCicloActivoRegular().getPromedioAcumulado().compareTo(new BigDecimal(14)) >= 0) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoBajoRendimiento() {
        if (this.alumnoCicloActivo == null) {
            return false;
        }
        if (this.alumnoCicloActivo.getSituacionFinal() == null) {
            return false;
        }
        List<SituacionAcademicaEnum> situacionesBajoRend = Arrays.asList(
                SituacionAcademicaEnum.S_6,
                SituacionAcademicaEnum.S_3,
                SituacionAcademicaEnum.S_3U,
                SituacionAcademicaEnum.S_6U,
                SituacionAcademicaEnum.S_2,
                SituacionAcademicaEnum.S_4,
                SituacionAcademicaEnum.S_4T,
                SituacionAcademicaEnum.S_X
        );
        return (situacionesBajoRend.contains(this.alumnoCicloActivo.getSituacionFinal().getCodigoEnum()));
    }

    public boolean getIsTipoUltimoCiclo() {
        if (this.alumnoCicloActivo == null) {
            return false;
        }
        return (this.alumnoCicloActivo.getCreditosAprobadosAcumulados() >= 172
                && Arrays.asList(S_5, S_N).contains(this.alumnoCicloActivo.getSituacionFinal().getCodigoEnum()));
    }

    public boolean isQuintoSecundaria() {
        if (this.getCodigo() == null) {
            return false;
        }
        return this.getCodigo().substring(0, 1).equals("Q");
    }

    public void setTipoEvaluacionesTransient(List<TipoEvaluacion> tipoEvaluacionesTransient) {
        this.tipoEvaluacionesTransient = tipoEvaluacionesTransient;
    }

    public List<TipoEvaluacion> getTipoEvaluacionesTransient() {
        return tipoEvaluacionesTransient;
    }

    public Boolean getEsMatriculaCondicional() {
        if (esMatriculaCondicional == null) {
            return false;
        }
        return esMatriculaCondicional;
    }

    public Boolean getEsMatriculableSuspendido() {
        if (esMatriculableSuspendido == null) {
            return false;
        }
        return esMatriculableSuspendido;
    }

    public List<String> getCodigoAnexoBoletin() {
        if (this.modalidadEstudio == null) {
            return null;
        }
        if (this.modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.PRE || this.modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.VIS) {
            return Arrays.asList(G01.name(), G02.name(), G03.name());
        } else {
            return Arrays.asList(G04.name(), G02.name());
        }
    }

    public Boolean getEsMatBeneficioUltCicl() {
        if (esMatBeneficioUltCicl == null) {
            return false;
        }
        return esMatBeneficioUltCicl;
    }

    public Long getCiclosRegularesTransient() {
        if (ciclosRegularesTransient == null) {
            ciclosRegularesTransient = 0L;
        }
        return ciclosRegularesTransient;
    }

    public Long getCiclosVeranosTransient() {
        if (ciclosVeranosTransient == null) {
            ciclosVeranosTransient = 0L;
        }
        return ciclosVeranosTransient;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public Alumno clone() {
        Alumno clone = null;
        try {
            clone = (Alumno) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "carrera", carrera, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "situacionAcademica", situacionAcademica, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "modalidadEstudio", modalidadEstudio, "id", "codigo", "nombre");

        return join.toString();
    }

    @Override
    public int compareTo(Alumno obj) {
        if (this == obj) {
            return 0;
        }
        return this.getId().compareTo(obj.getId());
    }

}
