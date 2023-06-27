package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_alumno_evaluacion_elim", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_evaluacion_eliminada"})
})
public class AlumnoEvaluacionElim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nota")
    private String nota;

    @Column(name = "valor_numerico")
    private BigDecimal valorNumerico;

    @Column(name = "fecha_ingreso_nota")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaIngresoNota;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion_eliminada")
    private EvaluacionEliminada evaluacionEliminada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_ingreso_nota")
    private Usuario usuarioIngresoNota;

    public void create(AlumnoEvaluacion alumnoEvaluacion) {
        this.setAlumno(alumnoEvaluacion.getAlumno());
        this.setEstado(alumnoEvaluacion.getEstado());
        this.setFechaAnulacion(alumnoEvaluacion.getFechaAnulacion());
        this.setFechaIngresoNota(alumnoEvaluacion.getFechaIngresoNota());
        this.setUserAnulacion(alumnoEvaluacion.getUserAnulacion());
        this.setMotivoAnulacion(alumnoEvaluacion.getMotivoAnulacion());
        this.setNota(alumnoEvaluacion.getNota());
        this.setUsuarioIngresoNota(alumnoEvaluacion.getUsuarioIngresoNota());
        this.setValorNumerico(alumnoEvaluacion.getValorNumerico());

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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public BigDecimal getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(BigDecimal valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public Usuario getUsuarioIngresoNota() {
        return usuarioIngresoNota;
    }

    public void setUsuarioIngresoNota(Usuario usuarioIngresoNota) {
        this.usuarioIngresoNota = usuarioIngresoNota;
    }

    public Date getFechaIngresoNota() {
        return fechaIngresoNota;
    }

    public void setFechaIngresoNota(Date fechaIngresoNota) {
        this.fechaIngresoNota = fechaIngresoNota;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public EvaluacionEliminada getEvaluacionEliminada() {
        return evaluacionEliminada;
    }

    public void setEvaluacionEliminada(EvaluacionEliminada evaluacionEliminada) {
        this.evaluacionEliminada = evaluacionEliminada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
