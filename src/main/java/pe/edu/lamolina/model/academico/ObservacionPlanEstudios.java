package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.edu.lamolina.model.general.Persona;

@Entity
@Table(name = "observacion_plan_estudios")
public class ObservacionPlanEstudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "tipo_aprobador")
    private String tipoAprobador;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aprobador")
    private Persona aprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_estudio_alumno")
    private PlanEstudioAlumno planEstudioAlumno;

    public ObservacionPlanEstudios() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTipoAprobador() {
        return tipoAprobador;
    }

    public void setTipoAprobador(String tipoAprobador) {
        this.tipoAprobador = tipoAprobador;
    }

    public Persona getAprobador() {
        return aprobador;
    }

    public void setAprobador(Persona aprobador) {
        this.aprobador = aprobador;
    }

    public PlanEstudioAlumno getPlanEstudioAlumno() {
        return planEstudioAlumno;
    }

    public void setPlanEstudioAlumno(PlanEstudioAlumno planEstudioAlumno) {
        this.planEstudioAlumno = planEstudioAlumno;
    }

}
