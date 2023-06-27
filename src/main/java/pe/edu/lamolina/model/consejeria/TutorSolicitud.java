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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TutorSolicitudEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "aca_tutor_solicitud")
public class TutorSolicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_verifica")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVerifica;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_consejero")
    private AlumnoConsejero alumnoConsejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_registra")
    private Usuario usuarioRegistra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_verifica")
    private Usuario usuarioVerifica;

    public TutorSolicitud() {
    }

    public TutorSolicitud(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public TutorSolicitudEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return TutorSolicitudEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TutorSolicitudEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Date getFechaVerifica() {
        return fechaVerifica;
    }

    public void setFechaVerifica(Date fechaVerifica) {
        this.fechaVerifica = fechaVerifica;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public AlumnoConsejero getAlumnoConsejero() {
        return alumnoConsejero;
    }

    public void setAlumnoConsejero(AlumnoConsejero alumnoConsejero) {
        this.alumnoConsejero = alumnoConsejero;
    }

    public Usuario getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(Usuario usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public Usuario getUsuarioVerifica() {
        return usuarioVerifica;
    }

    public void setUsuarioVerifica(Usuario usuarioVerifica) {
        this.usuarioVerifica = usuarioVerifica;
    }

}
