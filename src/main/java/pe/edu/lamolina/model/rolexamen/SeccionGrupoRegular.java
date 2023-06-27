package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.horario.HorarioAula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_seccion_grupo_regular")
public class SeccionGrupoRegular implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_exclusion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExclusion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_letra_grupo_regular")
    private LetraGrupoRegular letraGrupoRegular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_exclusion")
    private Usuario usuarioExclusion;

    @OneToMany(mappedBy = "seccionGrupoRegular", fetch = FetchType.LAZY)
    private List<AlumnoGrupoRegular> alumnosGruposRegulares;

    @OneToMany(mappedBy = "seccionGrupoRegular", fetch = FetchType.LAZY)
    private List<HorarioAula> horariosAula;

    @Transient
    @JsonIgnore
    private Integer alumnosCount;

    public SeccionGrupoRegular() {
    }

    public SeccionGrupoRegular(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LetraGrupoRegular getLetraGrupoRegular() {
        return letraGrupoRegular;
    }

    public void setLetraGrupoRegular(LetraGrupoRegular letraGrupoRegular) {
        this.letraGrupoRegular = letraGrupoRegular;
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

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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

    public List<AlumnoGrupoRegular> getAlumnosGruposRegulares() {
        return alumnosGruposRegulares;
    }

    public void setAlumnosGruposRegulares(List<AlumnoGrupoRegular> alumnosGruposRegulares) {
        this.alumnosGruposRegulares = alumnosGruposRegulares;
    }

    public boolean isEstadoActivo() {
        if (this.estado == null) {
            return false;
        }
        return this.getEstadoEnum().equals(SeccionRolExamenEstadoEnum.ACT);
    }

    public boolean isEstadoExcluido() {
        if (this.estado == null) {
            return false;
        }
        return this.getEstadoEnum().equals(SeccionRolExamenEstadoEnum.EXC);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SeccionGrupoRegular)) {
            return false;
        }
        SeccionGrupoRegular other = (SeccionGrupoRegular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Integer getAlumnosCount() {
        return alumnosCount;
    }

    public void setAlumnosCount(Integer alumnosCount) {
        this.alumnosCount = alumnosCount;
    }

    public List<HorarioAula> getHorariosAula() {
        return horariosAula;
    }

    public void setHorariosAula(List<HorarioAula> horariosAula) {
        this.horariosAula = horariosAula;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.rolexamen.SeccionGrupoRegular[ id=" + id + " ]";
    }

}
