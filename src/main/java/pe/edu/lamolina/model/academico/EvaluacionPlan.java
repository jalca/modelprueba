package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "aca_evaluacion_plan")
public class EvaluacionPlan implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad_evaluaciones")
    private Integer cantidadEvaluaciones;

    @Column(name = "evaluaciones_obligatorias")
    private Integer evaluacionesObligatorias;

    @Column(name = "peso_evaluacion")
    private BigDecimal pesoEvaluacion;

    @Column(name = "peso_total")
    private BigDecimal pesoTotal;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nivel")
    private Integer nivel;

//    @NotNull
//    @Column(name = "nota_minima_anulable")
//    private Integer notaMinimaAnulable;
//    @NotNull
//    @Column(name = "ind_porcentaje_variable")
//    private Integer indPorcentajeVariable;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evaluacion")
    private TipoEvaluacion tipoEvaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion_plan_superior")
    private EvaluacionPlan evaluacionPlanSuperior;

    @OneToMany(mappedBy = "evaluacionPlanSuperior", fetch = FetchType.LAZY)
    private List<EvaluacionPlan> evaluacionesPlanHijas;

    @Transient
    private boolean validarPesoTotal;
    @Transient
    private List<EvaluacionExpandida> evaluacionesExpandidas;

    public List<EvaluacionPlan> getEvaluacionesPlanHijas() {
        return evaluacionesPlanHijas;
    }

    public void setEvaluacionesPlanHijas(List<EvaluacionPlan> evaluacionesPlanHijas) {
        this.evaluacionesPlanHijas = evaluacionesPlanHijas;
    }

    public EvaluacionPlan() {
//        this.indPorcentajeVariable = 0;
//        this.notaMinimaAnulable = 0;
    }

    public EvaluacionPlan(Object id) {
        this.id = TypesUtil.getLong(id);
//        this.indPorcentajeVariable = 0;
//        this.notaMinimaAnulable = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanCalificacion getPlanCalificacion() {
        return planCalificacion;
    }

    public void setPlanCalificacion(PlanCalificacion planCalificacion) {
        this.planCalificacion = planCalificacion;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Integer getCantidadEvaluaciones() {
        return cantidadEvaluaciones;
    }

    public void setCantidadEvaluaciones(Integer cantidadEvaluaciones) {
        this.cantidadEvaluaciones = cantidadEvaluaciones;
    }

    public Integer getEvaluacionesObligatorias() {
        return evaluacionesObligatorias;
    }

    public void setEvaluacionesObligatorias(Integer evaluacionesObligatorias) {
        this.evaluacionesObligatorias = evaluacionesObligatorias;
    }

    public BigDecimal getPesoEvaluacion() {
        return pesoEvaluacion;
    }

    public void setPesoEvaluacion(BigDecimal pesoEvaluacion) {
        this.pesoEvaluacion = pesoEvaluacion;
    }

    public BigDecimal getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(BigDecimal pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

//    public Integer getNotaMinimaAnulable() {
//        return notaMinimaAnulable;
//    }
//
//    public void setNotaMinimaAnulable(Integer notaMinimaAnulable) {
//        this.notaMinimaAnulable = notaMinimaAnulable;
//    }
//
//    public Integer getIndPorcentajeVariable() {
//        return indPorcentajeVariable;
//    }
//
//    public void setIndPorcentajeVariable(Integer indPorcentajeVariable) {
//        this.indPorcentajeVariable = indPorcentajeVariable;
//    }
    public boolean isValidarPesoTotal() {
        return validarPesoTotal;
    }

    public void setValidarPesoTotal(boolean validarPesoTotal) {
        this.validarPesoTotal = validarPesoTotal;
    }

    public List<EvaluacionExpandida> getEvaluacionesExpandidas() {
        return evaluacionesExpandidas;
    }

    public void setEvaluacionesExpandidas(List<EvaluacionExpandida> evaluacionesExpandidas) {
        this.evaluacionesExpandidas = evaluacionesExpandidas;
    }

    public EvaluacionPlan getEvaluacionPlanSuperior() {
        return evaluacionPlanSuperior;
    }

    public void setEvaluacionPlanSuperior(EvaluacionPlan evaluacionPlanSuperior) {
        this.evaluacionPlanSuperior = evaluacionPlanSuperior;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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
        final EvaluacionPlan other = (EvaluacionPlan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public EvaluacionPlan clone() {
        EvaluacionPlan clone = null;
        try {
            clone = (EvaluacionPlan) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
