package pe.edu.lamolina.model.optativo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.PlanCalificacion;
import pe.edu.lamolina.model.enums.EstadoCursoCicloOptativoEnum;
import pe.edu.lamolina.model.enums.EstadoGrupoSeccionEnum;
import pe.edu.lamolina.model.enums.EstadoPlanCalificaEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "opt_curso_ciclo_optativo")
public class CursoCicloOptativo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "vacantes")
    private Integer vacantes;

    @Column(name = "matriculados")
    private Integer matriculados;

    @Column(name = "reservados")
    private Integer reservados;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "horas_ciclo")
    private Integer horasCiclo;

    @JoinColumn(name = "id_curso")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    @JoinColumn(name = "id_ciclo_programa")
    @ManyToOne(fetch = FetchType.LAZY)
    private CicloOptativoPrograma cicloOptativoPrograma;

    @JoinColumn(name = "id_aula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @Column(name = "estado_plan")
    private String estadoPlan;

    @Column(name = "estado_acta")
    private String estadoActa;

    @OneToMany(mappedBy = "cursoCicloOptativo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DocenteCursoOptativo> cursoCicloOptativoDocente;

    @Transient
    private DocenteCursoOptativo cursoCicloOptativoDocenteTransient;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicio;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFin;

    public DocenteCursoOptativo getCursoCicloOptativoDocenteTransient() {
        return cursoCicloOptativoDocenteTransient;
    }

    public void setCursoCicloOptativoDocenteTransient(DocenteCursoOptativo cursoCicloOptativoDocenteTransient) {
        this.cursoCicloOptativoDocenteTransient = cursoCicloOptativoDocenteTransient;
    }

    public CursoCicloOptativo() {
    }

    public CursoCicloOptativo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CicloOptativoPrograma getCicloOptativoPrograma() {
        return cicloOptativoPrograma;
    }

    public void setCicloOptativoPrograma(CicloOptativoPrograma cicloOptativoPrograma) {
        this.cicloOptativoPrograma = cicloOptativoPrograma;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public Integer getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(Integer matriculados) {
        this.matriculados = matriculados;
    }

    public Integer getReservados() {
        return reservados;
    }

    public void setReservados(Integer reservados) {
        this.reservados = reservados;
    }

    public List<DocenteCursoOptativo> getCursoCicloOptativoDocente() {
        return cursoCicloOptativoDocente;
    }

    public void setCursoCicloOptativoDocente(List<DocenteCursoOptativo> cursoCicloOptativoDocente) {
        this.cursoCicloOptativoDocente = cursoCicloOptativoDocente;
    }

    public EstadoCursoCicloOptativoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoCursoCicloOptativoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoCursoCicloOptativoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public boolean isEstadoActivo() {
        if (this.getEstadoEnum() == EstadoCursoCicloOptativoEnum.ACT) {
            return true;
        }
        return false;
    }

    public boolean isEstadoAnulado() {
        if (this.getEstadoEnum() == EstadoCursoCicloOptativoEnum.ANU) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCreado() {
        if (this.getEstadoEnum() == EstadoCursoCicloOptativoEnum.CRE) {
            return true;
        }
        return false;
    }

    public boolean isEstadoBloqueado() {
        if (this.getEstadoEnum() == EstadoCursoCicloOptativoEnum.BLO) {
            return true;
        }
        return false;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getHorasCiclo() {
        return horasCiclo;
    }

    public void setHorasCiclo(Integer horasCiclo) {
        this.horasCiclo = horasCiclo;
    }

    public PlanCalificacion getPlanCalificacion() {
        return planCalificacion;
    }

    public void setPlanCalificacion(PlanCalificacion planCalificacion) {
        this.planCalificacion = planCalificacion;
    }

    public String getEstadoPlan() {
        return estadoPlan;
    }

    public void setEstadoPlan(String estadoPlan) {
        this.estadoPlan = estadoPlan;
    }

    @JsonIgnore
    public void setEstadoPlanEnum(EstadoPlanCalificaEnum estadoPlanCalificaEnum) {
        this.estadoPlan = estadoPlanCalificaEnum.name();
    }

    public EstadoPlanCalificaEnum getEstadoPlanEnum() {
        if (this.estadoPlan == null) {
            return null;
        }
        return EstadoPlanCalificaEnum.valueOf(this.estadoPlan);
    }

    public String getEstadoActa() {
        return estadoActa;
    }

    public void setEstadoActa(String estadoActa) {
        this.estadoActa = estadoActa;
    }

    @JsonIgnore
    public void setEstadoActaEnum(EstadoGrupoSeccionEnum estado) {
        this.estadoActa = estado.name();
    }

    public EstadoGrupoSeccionEnum getEstadoActaEnum() {
        if (StringUtils.isBlank(this.estadoActa)) {
            return null;
        }
        return EstadoGrupoSeccionEnum.valueOf(this.estadoActa);
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
        final CursoCicloOptativo other = (CursoCicloOptativo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
