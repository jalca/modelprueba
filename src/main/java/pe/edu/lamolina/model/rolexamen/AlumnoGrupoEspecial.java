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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.AlumnoRolExamenEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_alumno_grupo_especial")
public class AlumnoGrupoEspecial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @JoinColumn(name = "id_seccion_grupo_especial")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeccionGrupoEspecial seccionGrupoEspecial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AlumnoGrupoEspecial() {
    }

    public AlumnoGrupoEspecial(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AlumnoGrupoEspecial(
            Alumno alumno,
            AlumnoRolExamenEstadoEnum alumnoRolExamenEstadoEnum,
            Usuario usuario,
            Date fechaAccionAudit,
            SeccionGrupoEspecial seccionGrupoEspecial) {
        this.alumno = alumno;
        this.setEstadoEnum(alumnoRolExamenEstadoEnum);
        this.userRegistro = usuario;
        this.fechaRegistro = fechaAccionAudit;
        this.seccionGrupoEspecial = seccionGrupoEspecial;
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

    public AlumnoRolExamenEstadoEnum getEstadoEnum() {
        return AlumnoRolExamenEstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(AlumnoRolExamenEstadoEnum estado) {
        this.estado = estado.name();
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

    public SeccionGrupoEspecial getSeccionGrupoEspecial() {
        return seccionGrupoEspecial;
    }

    public void setSeccionGrupoEspecial(SeccionGrupoEspecial seccionGrupoEspecial) {
        this.seccionGrupoEspecial = seccionGrupoEspecial;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof AlumnoGrupoEspecial)) {
            return false;
        }
        AlumnoGrupoEspecial other = (AlumnoGrupoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && this.id.compareTo(other.id) != 0)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.rolexamen.AlumnoGrupoEspecial[ id=" + id + " ]";
    }

    public boolean isEstadoExcluido() {
        if (this.estado == null) {
            return false;
        }
        return AlumnoRolExamenEstadoEnum.EXC.equals(this.getEstadoEnum());
    }

    public boolean isEstadoActivo() {
        if (this.estado == null) {
            return false;
        }
        return AlumnoRolExamenEstadoEnum.ACT.equals(this.getEstadoEnum());
    }

}
