package pe.edu.lamolina.model.encuestaestudiantil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EncuestaEstudiantilEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "exam_encuesta_alumno")
public class EncuestaAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_encuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEncuesta;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_docente")
    private EncuestaDocente encuestaDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_curso")
    private EncuestaCurso encuestaCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_encuesta")
    private Usuario userEncuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Integer ordenTemporal;

    public EncuestaAlumno() {
    }

    public EncuestaAlumno(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public EncuestaDocente getEncuestaDocente() {
        return encuestaDocente;
    }

    public void setEncuestaDocente(EncuestaDocente encuestaDocente) {
        this.encuestaDocente = encuestaDocente;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Usuario getUserEncuesta() {
        return userEncuesta;
    }

    public void setUserEncuesta(Usuario userEncuesta) {
        this.userEncuesta = userEncuesta;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(Date fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EncuestaEstudiantilEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EncuestaEstudiantilEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EncuestaEstudiantilEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EncuestaCurso getEncuestaCurso() {
        return encuestaCurso;
    }

    public void setEncuestaCurso(EncuestaCurso encuestaCurso) {
        this.encuestaCurso = encuestaCurso;
    }

    public Integer getOrdenTemporal() {
        return ordenTemporal;
    }

    public void setOrdenTemporal(Integer ordenTemporal) {
        this.ordenTemporal = ordenTemporal;
    }

    public static class CompareOrden implements Comparator<EncuestaAlumno> {

        @Override
        public int compare(EncuestaAlumno p1, EncuestaAlumno p2) {
            if (p1.getOrdenTemporal() != p2.getOrdenTemporal().intValue()) {
                return p1.getOrdenTemporal().compareTo(p2.getOrdenTemporal());
            }
            return p1.getId().compareTo(p2.getId());
        }
    }
}
