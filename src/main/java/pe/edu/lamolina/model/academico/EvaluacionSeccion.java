package pe.edu.lamolina.model.academico;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoPlanCalificaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_evaluacion_seccion")
public class EvaluacionSeccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_aceptacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAceptacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_seccion")
    private GrupoSeccion grupoSeccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sistema_notas")
    private SistemaNotas sistemaNotas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aceptacion")
    private Usuario userAceptacion;

    @OneToMany(mappedBy = "evaluacionSeccion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evaluacion> evaluaciones;

    @OneToMany(mappedBy = "evaluacionSeccion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EvaluacionExpandida> evaluacionExpandida;

    public EvaluacionSeccion() {
    }

    public EvaluacionSeccion(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public GrupoSeccion getGrupoSeccion() {
        return grupoSeccion;
    }

    public void setGrupoSeccion(GrupoSeccion grupoSeccion) {
        this.grupoSeccion = grupoSeccion;
    }

    public SistemaNotas getSistemaNotas() {
        return sistemaNotas;
    }

    public void setSistemaNotas(SistemaNotas sistemaNotas) {
        this.sistemaNotas = sistemaNotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoPlanCalificaEnum getEstadoEnum() {
        return EstadoPlanCalificaEnum.valueOf(estado);
    }

    public void setEstadoEnum(EstadoPlanCalificaEnum estadoPlanCalificaEnum) {
        this.estado = estadoPlanCalificaEnum.name();
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public Usuario getUserAceptacion() {
        return userAceptacion;
    }

    public void setUserAceptacion(Usuario userAceptacion) {
        this.userAceptacion = userAceptacion;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public List<EvaluacionExpandida> getEvaluacionExpandida() {
        return evaluacionExpandida;
    }

    public void setEvaluacionExpandida(List<EvaluacionExpandida> evaluacionExpandida) {
        this.evaluacionExpandida = evaluacionExpandida;
    }

    public boolean isEstadoPro() {
        if (EstadoPlanCalificaEnum.PRO.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

}
