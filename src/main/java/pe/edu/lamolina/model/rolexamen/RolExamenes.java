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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.EventoCicloAcademico;
import pe.edu.lamolina.model.enums.RolExamenesEstadoEnum;
import pe.edu.lamolina.model.enums.SituacionRolExamenesEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "rex_rol_examenes")
public class RolExamenes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "horas_examen")
    private Integer horasExamen;

    @Column(name = "situacion")
    private String situacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_ciclo_academico")
    private EventoCicloAcademico eventoCicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "rolExamenes", fetch = FetchType.LAZY)
    private List<SemanaExamen> semanasExamen;

    @Transient
    private Integer semanas;

    public RolExamenes() {
    }

    public RolExamenes(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EventoCicloAcademico getEventoCicloAcademico() {
        return eventoCicloAcademico;
    }

    public void setEventoCicloAcademico(EventoCicloAcademico eventoCicloAcademico) {
        this.eventoCicloAcademico = eventoCicloAcademico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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
    public void setEstadoEnum(RolExamenesEstadoEnum estado) {
        this.estado = estado.name();
    }

    public RolExamenesEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return RolExamenesEstadoEnum.valueOf(this.getEstado());
    }

    public boolean isEstadoCreado() {
        return estado != null && this.getEstadoEnum() == RolExamenesEstadoEnum.CRE;
    }

    public boolean isEstadoConfigurando() {
        return estado != null && this.getEstadoEnum() == RolExamenesEstadoEnum.CON;
    }

    public boolean isEstadoPublicado() {
        return estado != null && this.getEstadoEnum() == RolExamenesEstadoEnum.PUB;
    }

    public boolean isEstadoModificando() {
        return estado != null && this.getEstadoEnum() == RolExamenesEstadoEnum.MOD;
    }

    public boolean isEstadoCerrado() {
        return estado != null && this.getEstadoEnum() == RolExamenesEstadoEnum.CER;
    }

    public Integer getSemanas() {
        return semanas;
    }

    public void setSemanas(Integer semanas) {
        this.semanas = semanas;
    }

    public List<SemanaExamen> getSemanasExamen() {
        return semanasExamen;
    }

    public void setSemanasExamen(List<SemanaExamen> semanasExamen) {
        this.semanasExamen = semanasExamen;
    }

    public Integer getHorasExamen() {
        return horasExamen;
    }

    public void setHorasExamen(Integer horasExamen) {
        this.horasExamen = horasExamen;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @JsonIgnore
    public void setSituacionEnum(SituacionRolExamenesEnum situacionRolExamenesEnum) {
        this.situacion = situacionRolExamenesEnum.name();
    }

    public SituacionRolExamenesEnum getSituacionEnum() {
        if (this.situacion == null) {
            return null;
        }
        return SituacionRolExamenesEnum.valueOf(this.situacion);
    }

    public boolean isSituacionConfigurarRol() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_ROL)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionConfigurarHorario() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_HOR)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionHorarioConfirmado() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CONF_HOR)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionConfigurarCursoMasivo() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_MAS)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionConfigurarGrupoRegular() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_REG)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionAsignarHorarioCursosMasivos() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_HOR_MAS)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSituacionConfigurarGrupoEspecial() {
        if (this.getSituacion() != null) {
            if (this.getSituacionEnum().equals(SituacionRolExamenesEnum.CFG_ESP)) {
                return true;
            }
        }
        return false;
    }

}
