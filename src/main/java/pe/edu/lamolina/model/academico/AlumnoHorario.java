package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import pe.edu.lamolina.model.enums.EstadoAlumnoHorarioEnum;
import pe.edu.lamolina.model.horario.HorarioCachimbos;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_alumno_horario")
public class AlumnoHorario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "errores")
    private String errores;

    @Column(name = "fecha_creacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario_cachimbos")
    private HorarioCachimbos horarioCachimbos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @Transient
    private List<MatriculaCurso> cursosMatriculados;

    @Transient
    private Boolean faltaActividad;

    public AlumnoHorario() {
    }

    public AlumnoHorario(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public HorarioCachimbos getHorarioCachimbos() {
        return horarioCachimbos;
    }

    public void setHorarioCachimbos(HorarioCachimbos horarioCachimbos) {
        this.horarioCachimbos = horarioCachimbos;
    }

    public String getEstado() {
        return estado;
    }

    public EstadoAlumnoHorarioEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoAlumnoHorarioEnum.valueOf(estado);
    }

    public void setEstado(EstadoAlumnoHorarioEnum estado) {
        this.estado = estado.name();
    }

    public Usuario getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(Usuario userCreacion) {
        this.userCreacion = userCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores = errores;
    }

    public List<MatriculaCurso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<MatriculaCurso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    public Boolean getFaltaActividad() {
        if (faltaActividad == null) {
            return false;
        }
        return faltaActividad;
    }

    public void setFaltaActividad(Boolean faltaActividad) {
        this.faltaActividad = faltaActividad;
    }

}
