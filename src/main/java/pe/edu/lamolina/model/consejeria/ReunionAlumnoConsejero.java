package pe.edu.lamolina.model.consejeria;

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
import pe.edu.lamolina.model.enums.ReunionAlumnoConsejeroEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_reunion_alumno_consejero")
public class ReunionAlumnoConsejero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "es_riesgo_academico")
    private Boolean esRiesgoAcademico;

    @Column(name = "es_problema_sicologico")
    private Boolean esProblemaSicologico;

    @Column(name = "es_problema_economico")
    private Boolean esProblemaEconomico;

    @Column(name = "es_problema_familiar")
    private Boolean esProblemaFamiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_consejero")
    private AlumnoConsejero alumnoConsejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agenda_consejero")
    private AgendaConsejero agendaConsejero;

    @Column(name = "fecha_asistencia")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private Date fechaAsistencia;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @Transient
    Boolean seleccionado;

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

    @JsonIgnore
    public void setEstadoEnum(ReunionAlumnoConsejeroEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public ReunionAlumnoConsejeroEstadoEnum getEstadoEnum() {
        return ReunionAlumnoConsejeroEstadoEnum.valueOf(estado);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public AlumnoConsejero getAlumnoConsejero() {
        return alumnoConsejero;
    }

    public void setAlumnoConsejero(AlumnoConsejero alumnoConsejero) {
        this.alumnoConsejero = alumnoConsejero;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserModifica() {
        return userModifica;
    }

    public void setUserModifica(Usuario userModifica) {
        this.userModifica = userModifica;
    }

    public AgendaConsejero getAgendaConsejero() {
        return agendaConsejero;
    }

    public void setAgendaConsejero(AgendaConsejero agendaConsejero) {
        this.agendaConsejero = agendaConsejero;
    }

    public Boolean getSeleccionado() {
        if (seleccionado == null) {
            return false;
        }
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {

        this.seleccionado = seleccionado;
    }

    public Boolean getEsRiesgoAcademico() {
        if (esRiesgoAcademico == null) {
            return false;
        }
        return esRiesgoAcademico;
    }

    public void setEsRiesgoAcademico(Boolean esRiesgoAcademico) {
        this.esRiesgoAcademico = esRiesgoAcademico;
    }

    public Boolean getEsProblemaSicologico() {
        if (esProblemaSicologico == null) {
            return false;
        }
        return esProblemaSicologico;
    }

    public void setEsProblemaSicologico(Boolean esProblemaSicologico) {
        this.esProblemaSicologico = esProblemaSicologico;
    }

    public Boolean getEsProblemaEconomico() {
        if (esProblemaEconomico == null) {
            return false;
        }
        return esProblemaEconomico;
    }

    public void setEsProblemaEconomico(Boolean esProblemaEconomico) {
        this.esProblemaEconomico = esProblemaEconomico;
    }

    public Boolean getEsProblemaFamiliar() {
        if (esProblemaFamiliar == null) {
            return false;
        }
        return esProblemaFamiliar;
    }

    public void setEsProblemaFamiliar(Boolean esProblemaFamiliar) {
        this.esProblemaFamiliar = esProblemaFamiliar;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

}
