package pe.edu.lamolina.model.academico;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_asignacion_aula")
public class AsignacionAula implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAsignacion;

    @Column(name = "secciones_programadas")
    private Integer seccionesProgramadas;

    @NotNull
    @Column(name = "secciones_tipo_lab")
    private Integer seccionesTipoLab;

    @NotNull
    @Column(name = "secciones_tipo_aula")
    private Integer seccionesTipoAula;

    @NotNull
    @Column(name = "secciones_asignadas")
    private Integer seccionesAsignadas;

    @NotNull
    @Column(name = "secciones_modificadas")
    private Integer seccionesModificadas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActualizacion;

    @Transient
    private String idsGpoSecciones;

    public AsignacionAula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getSeccionesProgramadas() {
        return seccionesProgramadas;
    }

    public void setSeccionesProgramadas(Integer seccionesProgramadas) {
        this.seccionesProgramadas = seccionesProgramadas;
    }

    public Integer getSeccionesTipoLab() {
        return seccionesTipoLab;
    }

    public void setSeccionesTipoLab(Integer seccionesTipoLab) {
        this.seccionesTipoLab = seccionesTipoLab;
    }

    public Integer getSeccionesTipoAula() {
        return seccionesTipoAula;
    }

    public void setSeccionesTipoAula(Integer seccionesTipoAula) {
        this.seccionesTipoAula = seccionesTipoAula;
    }

    public Integer getSeccionesAsignadas() {
        return seccionesAsignadas;
    }

    public void setSeccionesAsignadas(Integer seccionesAsignadas) {
        this.seccionesAsignadas = seccionesAsignadas;
    }

    public Integer getSeccionesModificadas() {
        return seccionesModificadas;
    }

    public void setSeccionesModificadas(Integer seccionesModificadas) {
        this.seccionesModificadas = seccionesModificadas;
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

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getIdsGpoSecciones() {
        return idsGpoSecciones;
    }

    public void setIdsGpoSecciones(String idsGpoSecciones) {
        this.idsGpoSecciones = idsGpoSecciones;
    }

    @Override
    public String toString() {
        return "AsignacionAula{" + "id=" + id + ", fechaAsignacion=" + fechaAsignacion + ", seccionesProgramadas=" + seccionesProgramadas + ", seccionesTipoLab=" + seccionesTipoLab + ", seccionesTipoAula=" + seccionesTipoAula + ", seccionesAsignadas=" + seccionesAsignadas + ", seccionesModificadas=" + seccionesModificadas + ", userRegistro=" + userRegistro + ", fechaRegistro=" + fechaRegistro + ", userModificacion=" + userModificacion + ", fechaActualizacion=" + fechaActualizacion + '}';
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
        final AsignacionAula other = (AsignacionAula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
