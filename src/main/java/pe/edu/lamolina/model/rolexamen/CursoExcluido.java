package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_curso_excluido")
public class CursoExcluido implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "secciones_excluidas")
    private Integer seccionesExcluidas;

    @Column(name = "secciones_totales")
    private Integer seccionesTotales;

    @Column(name = "es_exclusion_completa")
    public Boolean esExclusionCompleta;

    public CursoExcluido() {
    }

    public CursoExcluido(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(this.estado);
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

    public RolExamenes getRolExamenes() {
        return rolExamenes;
    }

    public void setRolExamenes(RolExamenes rolExamenes) {
        this.rolExamenes = rolExamenes;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEsExclusionCompleta() {
        return esExclusionCompleta;
    }

    public void setEsExclusionCompleta(Boolean esExclusionCompleta) {
        this.esExclusionCompleta = esExclusionCompleta;
    }

    public Integer getSeccionesExcluidas() {
        return seccionesExcluidas;
    }

    public void setSeccionesExcluidas(Integer seccionesExcluidas) {
        this.seccionesExcluidas = seccionesExcluidas;
    }

    public Integer getSeccionesTotales() {
        return seccionesTotales;
    }

    public void setSeccionesTotales(Integer seccionesTotales) {
        this.seccionesTotales = seccionesTotales;
    }

    public boolean isEstadoAnulado() {
        if (this.estado == null) {
            return false;
        }
        return EstadoEnum.ANU.equals(this.getEstadoEnum());
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
        final CursoExcluido other = (CursoExcluido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
