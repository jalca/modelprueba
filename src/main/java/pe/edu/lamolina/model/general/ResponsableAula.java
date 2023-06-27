package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Transient;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TipoResponsableEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "gen_responsable_aula")
public class ResponsableAula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_actualizacion")
    private Usuario userActualizacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_actualizacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaActualizacion;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "responsableAula", fetch = FetchType.LAZY)
    private List<ResponsableAulaAsignacion> responsableAulasAsignacion;

    @Transient
    private List<TurnoAtencionAula> turnosAtencionAulas;

    public ResponsableAula() {
    }

    public ResponsableAula(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserActualizacion() {
        return userActualizacion;
    }

    public void setUserActualizacion(Usuario userActualizacion) {
        this.userActualizacion = userActualizacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEstadoEnum(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoResponsableEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoResponsableEnum.valueOf(this.tipo);
    }

    public List<ResponsableAulaAsignacion> getResponsableAulasAsignacion() {
        return responsableAulasAsignacion;
    }

    public void setResponsableAulasAsignacion(List<ResponsableAulaAsignacion> responsableAulasAsignacion) {
        this.responsableAulasAsignacion = responsableAulasAsignacion;
    }

    public List<TurnoAtencionAula> getTurnosAtencionAulas() {
        return turnosAtencionAulas;
    }

    public void setTurnosAtencionAulas(List<TurnoAtencionAula> turnosAtencionAulas) {
        this.turnosAtencionAulas = turnosAtencionAulas;
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
        final ResponsableAula other = (ResponsableAula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

//    public String getPerAulTur() {
//        return this.getPersona().getId() + "-" + this.aula.getId() + "-" + this.getTurnoAtencionAula().getId();
//    }
}
