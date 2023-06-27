package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
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
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_aprobador_plan_estudios")
public class AprobadorPlanEstudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden_grupo")
    private Integer ordenGrupo;

    @Column(name = "tipo_aprobador")
    private String tipoAprobador;

    @Column(name = "fecha_aprobacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_estudio_alumno")
    private PlanEstudioAlumno planEstudioAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aprobador")
    private Persona aprobador;

    public AprobadorPlanEstudios() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdenGrupo() {
        return ordenGrupo;
    }

    public void setOrdenGrupo(Integer ordenGrupo) {
        this.ordenGrupo = ordenGrupo;
    }

    public String getTipoAprobador() {
        return tipoAprobador;
    }

    public void setTipoAprobador(String tipoAprobador) {
        this.tipoAprobador = tipoAprobador;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public PlanEstudioAlumno getPlanEstudioAlumno() {
        return planEstudioAlumno;
    }

    public void setPlanEstudioAlumno(PlanEstudioAlumno planEstudioAlumno) {
        this.planEstudioAlumno = planEstudioAlumno;
    }

    public Persona getAprobador() {
        return aprobador;
    }

    public void setAprobador(Persona aprobador) {
        this.aprobador = aprobador;
    }

    
}
