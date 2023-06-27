package pe.edu.lamolina.model.optativo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.PlanCalificacion;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "opt_calificacion_optativo")
public class CalificacionOptativo implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_ciclo_optativo")
    private CursoCicloOptativo cursoCicloOptativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aceptacion")
    private Usuario usuarioAceptacion;

    @Column(name = "fecha_aceptacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAceptacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "calificacionOptativo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EvaluacionCalificacionOptativo> evaluacionesCalificacionOptativo;

    public CalificacionOptativo() {
    }

    public CalificacionOptativo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoCicloOptativo getCursoCicloOptativo() {
        return cursoCicloOptativo;
    }

    public void setCursoCicloOptativo(CursoCicloOptativo cursoCicloOptativo) {
        this.cursoCicloOptativo = cursoCicloOptativo;
    }

    public Usuario getUsuarioAceptacion() {
        return usuarioAceptacion;
    }

    public void setUsuarioAceptacion(Usuario usuarioAceptacion) {
        this.usuarioAceptacion = usuarioAceptacion;
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<EvaluacionCalificacionOptativo> getEvaluacionesCalificacionOptativo() {
        return evaluacionesCalificacionOptativo;
    }

    public void setEvaluacionesCalificacionOptativo(List<EvaluacionCalificacionOptativo> evaluacionesCalificacionOptativo) {
        this.evaluacionesCalificacionOptativo = evaluacionesCalificacionOptativo;
    }

    public PlanCalificacion getPlanCalificacion() {
        return planCalificacion;
    }

    public void setPlanCalificacion(PlanCalificacion planCalificacion) {
        this.planCalificacion = planCalificacion;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CalificacionOptativo)) {
            return false;
        }
        CalificacionOptativo other = (CalificacionOptativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.optativo.CalificacionOptativo[ id=" + id + " ]";
    }

}
