package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.SeccionRolExamenEstadoEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_seccion_grupo_especial")
public class SeccionGrupoEspecial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_examen")
    private GrupoHorasExamen grupoHorasExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seccionGrupoEspecial")
    private List<AlumnoGrupoEspecial> alumnosGrupoEspecial;

    @Transient
    @JsonIgnore
    private Integer alumnosEspecialesActivosCount;

    @Transient
    private CursoMasivoExamen cursoMasivoExamen;
    @Transient
    private Boolean crearCurMasiv;

    public SeccionGrupoEspecial() {
    }

    public SeccionGrupoEspecial(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public SeccionGrupoEspecial(RolExamenes rolExamenes, Seccion seccion, Usuario usuario, Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        this.rolExamenes = rolExamenes;
        this.seccion = seccion;
        this.userRegistro = usuario;
        this.alumnosGrupoEspecial = new ArrayList<>();
        this.estado = SeccionRolExamenEstadoEnum.ACT.name();
        this.aula = seccion.getAula();
        this.docente = seccion.getDocenteSeccion().get(0).getDocente();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolExamenes getRolExamenes() {
        return rolExamenes;
    }

    public void setRolExamenes(RolExamenes rolExamenes) {
        this.rolExamenes = rolExamenes;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
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

    public List<AlumnoGrupoEspecial> getAlumnosGrupoEspecial() {
        return alumnosGrupoEspecial;
    }

    public void setAlumnosGrupoEspecial(List<AlumnoGrupoEspecial> alumnosGrupoEspecial) {
        this.alumnosGrupoEspecial = alumnosGrupoEspecial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(SeccionRolExamenEstadoEnum estado) {
        this.estado = estado.name();
    }

    public SeccionRolExamenEstadoEnum getEstadoEnum() {
        return SeccionRolExamenEstadoEnum.valueOf(this.getEstado());
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Integer getAlumnosEspecialesActivosCount() {
        return alumnosEspecialesActivosCount;
    }

    public void setAlumnosEspecialesActivosCount(Integer alumnosEspecialesActivosCount) {
        this.alumnosEspecialesActivosCount = alumnosEspecialesActivosCount;
    }

    public GrupoHorasExamen getGrupoHorasExamen() {
        return grupoHorasExamen;
    }

    public void setGrupoHorasExamen(GrupoHorasExamen grupoHorasExamen) {
        this.grupoHorasExamen = grupoHorasExamen;
    }

    public boolean isEstadoActivo() {
        if (this.estado == null) {
            return false;
        }
        return SeccionRolExamenEstadoEnum.ACT.equals(this.getEstadoEnum());
    }

    public boolean isEstadoExcluido() {
        if (this.estado == null) {
            return false;
        }
        return SeccionRolExamenEstadoEnum.EXC.equals(this.getEstadoEnum());
    }

    public CursoMasivoExamen getCursoMasivoExamen() {
        return cursoMasivoExamen;
    }

    public void setCursoMasivoExamen(CursoMasivoExamen cursoMasivoExamen) {
        this.cursoMasivoExamen = cursoMasivoExamen;
    }

    public Boolean getCrearCurMasiv() {
        if (crearCurMasiv == null) {
            return false;
        }
        return crearCurMasiv;
    }

    public void setCrearCurMasiv(Boolean crearCurMasiv) {
        this.crearCurMasiv = crearCurMasiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof SeccionGrupoEspecial)) {
            return false;
        }
        SeccionGrupoEspecial other = (SeccionGrupoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && this.id.compareTo(other.id) != 0)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.rolexamen.SeccionGrupoEspecial[ id=" + id + " ]";
    }

}
