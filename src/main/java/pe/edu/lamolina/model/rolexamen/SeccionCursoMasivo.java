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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.SeccionRolExamenEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rex_seccion_curso_masivo")
public class SeccionCursoMasivo implements Serializable {

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

    @Column(name = "fecha_exclusion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExclusion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_masivo_examen")
    private CursoMasivoExamen cursoMasivoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_exclusion")
    private Usuario usuarioExclusion;

    @Transient
    @JsonIgnore
    private Integer alumnosCount;

    public SeccionCursoMasivo() {
    }

    public SeccionCursoMasivo(Object id) {
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

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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
    public void setEstadoEnum(SeccionRolExamenEstadoEnum estado) {
        this.estado = estado.name();
    }

    public SeccionRolExamenEstadoEnum getEstadoEnum() {
        return SeccionRolExamenEstadoEnum.valueOf(this.getEstado());
    }

    public Usuario getUsuarioExclusion() {
        return usuarioExclusion;
    }

    public void setUsuarioExclusion(Usuario usuarioExclusion) {
        this.usuarioExclusion = usuarioExclusion;
    }

    public Date getFechaExclusion() {
        return fechaExclusion;
    }

    public void setFechaExclusion(Date fechaExclusion) {
        this.fechaExclusion = fechaExclusion;
    }

    public Integer getAlumnosCount() {
        return alumnosCount;
    }

    public void setAlumnosCount(Integer alumnosCount) {
        this.alumnosCount = alumnosCount;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public boolean isEstadoExcluido() {
        if (this.estado == null) {
            return false;
        }
        return SeccionRolExamenEstadoEnum.EXC.equals(this.getEstadoEnum());
    }

    public boolean isEstadoActivo() {
        if (this.estado == null) {
            return false;
        }
        return SeccionRolExamenEstadoEnum.ACT.equals(this.getEstadoEnum());
    }

}
