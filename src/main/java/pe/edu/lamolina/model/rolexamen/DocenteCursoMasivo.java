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
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.enums.DocenteRolExamenEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rex_docente_curso_masivo")
public class DocenteCursoMasivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "secciones")
    private Integer secciones;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_masivo_examen")
    private CursoMasivoExamen cursoMasivoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public DocenteCursoMasivo() {
    }

    public DocenteCursoMasivo(Object id) {
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(DocenteRolExamenEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public DocenteRolExamenEstadoEnum getEstadoEnum() {
        return DocenteRolExamenEstadoEnum.valueOf(this.getEstado());
    }

    public Integer getSecciones() {
        return secciones;
    }

    public void setSecciones(Integer secciones) {
        this.secciones = secciones;
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

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DocenteCursoMasivo)) {
            return false;
        }
        DocenteCursoMasivo other = (DocenteCursoMasivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && this.id.compareTo(other.id) != 0)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.rolexamen.DocenteCursoMasivo[ id=" + id + " ]";
    }

}
