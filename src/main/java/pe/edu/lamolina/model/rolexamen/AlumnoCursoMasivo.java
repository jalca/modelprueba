package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.TemporalType;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.AlumnoRolExamenEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rex_alumno_curso_masivo")
public class AlumnoCursoMasivo implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_masivo_examen")
    private CursoMasivoExamen cursoMasivoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion_curso_masivo")
    private SeccionCursoMasivo seccionCursoMasivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AlumnoCursoMasivo() {
    }

    public AlumnoCursoMasivo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoMasivoExamen getCursoMasivoExamen() {
        return cursoMasivoExamen;
    }

    public void setCursoMasivoExamen(CursoMasivoExamen cursoMasivoExamen) {
        this.cursoMasivoExamen = cursoMasivoExamen;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @JsonIgnore
    public void setEstadoEnum(AlumnoRolExamenEstadoEnum estado) {
        this.estado = estado.name();
    }

    public AlumnoRolExamenEstadoEnum getEstadoEnum() {
        return AlumnoRolExamenEstadoEnum.valueOf(this.getEstado());
    }

    public boolean isEstadoActivo() {
        if (StringUtils.isNotBlank(this.getEstado())) {
            if (this.getEstadoEnum().equals(AlumnoRolExamenEstadoEnum.ACT)) {
                return true;
            }
        }
        return false;
    }

    public SeccionCursoMasivo getSeccionCursoMasivo() {
        return seccionCursoMasivo;
    }

    public void setSeccionCursoMasivo(SeccionCursoMasivo seccionCursoMasivo) {
        this.seccionCursoMasivo = seccionCursoMasivo;
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
        final AlumnoCursoMasivo other = (AlumnoCursoMasivo) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}
