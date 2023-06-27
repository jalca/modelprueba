package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoPlanCalificaEnum;
import pe.edu.lamolina.model.enums.OrigenPlanCalificaEnum;
import pe.edu.lamolina.model.enums.TipoCicloEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_plan_calificacion")
public class PlanCalificacion implements Serializable, Cloneable {

    public static String PREFIJO_CODIGO = "SC";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_aprobacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAprobacion;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "nota_base")
    private Integer notaBase;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "formula")
    private String formula;

    @Column(name = "sustento")
    private String sustento;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "origen")
    private String origen;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento_academico")
    private DepartamentoAcademico departamentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sistema_notas")
    private SistemaNotas sistemaNotas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion_superior")
    private PlanCalificacion planCalificacionSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "planCalificacion", fetch = FetchType.LAZY)
    private List<Curso> curso;

    @OneToMany(mappedBy = "planCalificacion", fetch = FetchType.LAZY)
    private List<PlanCalificacionCurso> planCalificacionCursos;

    @OneToMany(mappedBy = "planCalificacionRegular", fetch = FetchType.LAZY)
    private List<Curso> cursosPlanRegular;

    @OneToMany(mappedBy = "planCalificacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EvaluacionPlan> evaluacionPlan;

    @OneToMany(mappedBy = "planCalificacion", fetch = FetchType.LAZY)
    private List<EvaluacionSeccion> evaluacionSeccion;

    @OneToMany(mappedBy = "sistemaAcademico", fetch = FetchType.LAZY)
    private List<LoggerPlanCalificacion> loggerPlanCalificacion;

    public PlanCalificacion() {
        this.setTipo("0");
    }

    public PlanCalificacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartamentoAcademico getDepartamentoAcademico() {
        return departamentoAcademico;
    }

    public void setDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) {
        this.departamentoAcademico = departamentoAcademico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoPlanCalificaEnum getEstadoEnum() {
        if (estado.isEmpty()) {
            return null;
        }
        return EstadoPlanCalificaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoPlanCalificaEnum estadoPlanCalificaEnum) {
        this.estado = estadoPlanCalificaEnum.name();
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public SistemaNotas getSistemaNotas() {
        return sistemaNotas;
    }

    public void setSistemaNotas(SistemaNotas sistemaNotas) {
        this.sistemaNotas = sistemaNotas;
    }

    public Integer getNotaBase() {
        return notaBase;
    }

    public void setNotaBase(Integer notaBase) {
        this.notaBase = notaBase;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    public List<EvaluacionPlan> getEvaluacionPlan() {
        return evaluacionPlan;
    }

    public void setEvaluacionPlan(List<EvaluacionPlan> evaluacionPlan) {
        this.evaluacionPlan = evaluacionPlan;
    }

    public List<EvaluacionSeccion> getEvaluacionSeccion() {
        return evaluacionSeccion;
    }

    public void setEvaluacionSeccion(List<EvaluacionSeccion> evaluacionSeccion) {
        this.evaluacionSeccion = evaluacionSeccion;
    }

    public List<LoggerPlanCalificacion> getLoggerPlanCalificacion() {
        return loggerPlanCalificacion;
    }

    public void setLoggerPlanCalificacion(List<LoggerPlanCalificacion> loggerPlanCalificacion) {
        this.loggerPlanCalificacion = loggerPlanCalificacion;
    }

//    @Override
//    public String toString() {
//        return "PlanCalificacion{" + "id=" + id + ", estado=" + estado + ", fechaAprobacion=" + fechaAprobacion + ", numero=" + numero + ", notaBase=" + notaBase + ", idUserRegistro=" + userRegistro + ", fechaRegistro=" + fechaRegistro + ", departamentoAcademico=" + departamentoAcademico + ", sistemaNotas=" + sistemaNotas + '}';
//    }
    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public OrigenPlanCalificaEnum getOrigenEnum() {
        if (this.origen == null) {
            return null;
        }
        return OrigenPlanCalificaEnum.valueOf(this.origen);
    }

    @JsonIgnore
    public void setOrigenEnum(OrigenPlanCalificaEnum origenPlanCalificaEnum) {
        if (origenPlanCalificaEnum == null) {
            return;
        }
        this.origen = origenPlanCalificaEnum.name();
    }

    public boolean isEstadoSolicitado() {
        if (EstadoPlanCalificaEnum.SOL.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoExpandido() {
        if (EstadoPlanCalificaEnum.EXP.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoExpandir() {
        if (EstadoPlanCalificaEnum.EXPR.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoReenviado() {
        if (EstadoPlanCalificaEnum.REE.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCreado() {
        if (EstadoPlanCalificaEnum.CRE.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoPropuesto() {
        if (EstadoPlanCalificaEnum.PRO.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoActivado() {
        if (EstadoPlanCalificaEnum.ACT.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoObservado() {
        if (EstadoPlanCalificaEnum.OBS.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoRechazado() {
        if (EstadoPlanCalificaEnum.RHZ.name().equals(estado)) {
            return true;
        }
        return false;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static String getPREFIJO_CODIGO() {
        return PREFIJO_CODIGO;
    }

    public static void setPREFIJO_CODIGO(String PREFIJO_CODIGO) {
        PlanCalificacion.PREFIJO_CODIGO = PREFIJO_CODIGO;
    }

    public PlanCalificacion getPlanCalificacionSuperior() {
        return planCalificacionSuperior;
    }

    public void setPlanCalificacionSuperior(PlanCalificacion planCalificacionSuperior) {
        this.planCalificacionSuperior = planCalificacionSuperior;
    }

    public void generateCodigo() {
        StringBuilder codigoGen = new StringBuilder(PlanCalificacion.PREFIJO_CODIGO);
        codigoGen.append(String.format("%05d", this.getNumero()));
        codigoGen.append(this.getDepartamentoAcademico().getCodigo());
        this.codigo = codigoGen.toString();
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public TipoCicloEnum getTipoCicloEnum() {
        if (this.tipoCiclo == null) {
            return null;
        }
        return TipoCicloEnum.valueOf(this.getTipoCiclo());
    }

    @JsonIgnore
    public void setTipoCicloEnum(TipoCicloEnum tipoCicloEnum) {
        if (tipoCicloEnum == null) {
            return;
        }
        this.tipoCiclo = tipoCicloEnum.name();
    }

    public List<Curso> getCursosPlanRegular() {
        return cursosPlanRegular;
    }

    public void setCursosPlanRegular(List<Curso> cursosPlanRegular) {
        this.cursosPlanRegular = cursosPlanRegular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<PlanCalificacionCurso> getPlanCalificacionCursos() {
        return planCalificacionCursos;
    }

    public void setPlanCalificacionCursos(List<PlanCalificacionCurso> planCalificacionCursos) {
        this.planCalificacionCursos = planCalificacionCursos;
    }

    public boolean isTipoCicloRegular() {
        if (this.getTipoCiclo() != null) {
            if (TipoCicloEnum.REG.name().equals(this.getTipoCiclo())) {
                return true;
            }
        }
        return false;
    }

    public boolean isTipoCicloNivelacion() {
        if (this.getTipoCiclo() != null) {
            if (TipoCicloEnum.NIV.name().equals(this.getTipoCiclo())) {
                return true;
            }
        }
        return false;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory);
        return json;
    }

    @Override
    public PlanCalificacion clone() {
        PlanCalificacion clone = null;
        try {
            clone = (PlanCalificacion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
