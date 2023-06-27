package pe.edu.lamolina.model.graduacion;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.enums.EstadoComiteConsejeroEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.EstadoTramite;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_comite_consejero")
public class ComiteConsejero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentario_actual")
    private String comentarioActual;

    @Column(name = "fecha_aprobacion_coordinador")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAprobacionCoordinador;

    @Column(name = "fecha_aprobacion_director")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAprobacionDirector;

    @Column(name = "fecha_aprobacion_secretario")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAprobacionSecretario;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActivacion;

    @Column(name = "fecha_inactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coordinador_aprobador")
    private Persona coordinadorAprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director_aprobador")
    private Persona directorAprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_secretario_aprobador")
    private Persona secretarioAprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activacion")
    private Usuario usuarioActivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inactivacion")
    private Usuario usuarioInactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @Transient
    List<MiembroComiteConsejero> miembroComiteComsejeros;

    @Transient
    List<AsesorSugerido> asesores;

    public ComiteConsejero() {
    }

    public ComiteConsejero(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public EstadoTramite getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoComiteConsejeroEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoComiteConsejeroEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoComiteConsejeroEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public String getComentarioActual() {
        return comentarioActual;
    }

    public void setComentarioActual(String comentarioActual) {
        this.comentarioActual = comentarioActual;
    }

    public Persona getCoordinadorAprobador() {
        return coordinadorAprobador;
    }

    public void setCoordinadorAprobador(Persona coordinadorAprobador) {
        this.coordinadorAprobador = coordinadorAprobador;
    }

    public Date getFechaAprobacionCoordinador() {
        return fechaAprobacionCoordinador;
    }

    public void setFechaAprobacionCoordinador(Date fechaAprobacionCoordinador) {
        this.fechaAprobacionCoordinador = fechaAprobacionCoordinador;
    }

    public Persona getSecretarioAprobador() {
        return secretarioAprobador;
    }

    public void setSecretarioAprobador(Persona secretarioAprobador) {
        this.secretarioAprobador = secretarioAprobador;
    }

    public Date getFechaAprobacionSecretario() {
        return fechaAprobacionSecretario;
    }

    public void setFechaAprobacionSecretario(Date fechaAprobacionSecretario) {
        this.fechaAprobacionSecretario = fechaAprobacionSecretario;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Usuario getUsuarioInactivacion() {
        return usuarioInactivacion;
    }

    public void setUsuarioInactivacion(Usuario usuarioInactivacion) {
        this.usuarioInactivacion = usuarioInactivacion;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<MiembroComiteConsejero> getMiembroComiteComsejeros() {
        return miembroComiteComsejeros;
    }

    public void setMiembroComiteComsejeros(List<MiembroComiteConsejero> miembroComiteComsejeros) {
        this.miembroComiteComsejeros = miembroComiteComsejeros;
    }

    public List<AsesorSugerido> getAsesores() {
        return asesores;
    }

    public void setAsesores(List<AsesorSugerido> asesores) {
        this.asesores = asesores;
    }

    public Persona getDirectorAprobador() {
        return directorAprobador;
    }

    public void setDirectorAprobador(Persona directorAprobador) {
        this.directorAprobador = directorAprobador;
    }

    public Date getFechaAprobacionDirector() {
        return fechaAprobacionDirector;
    }

    public void setFechaAprobacionDirector(Date fechaAprobacionDirector) {
        this.fechaAprobacionDirector = fechaAprobacionDirector;
    }

    public Usuario getUsuarioActivacion() {
        return usuarioActivacion;
    }

    public void setUsuarioActivacion(Usuario usuarioActivacion) {
        this.usuarioActivacion = usuarioActivacion;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

}
