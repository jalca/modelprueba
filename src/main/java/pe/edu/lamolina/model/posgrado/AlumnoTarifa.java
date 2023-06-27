package pe.edu.lamolina.model.posgrado;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_alumno_tarifa")
public class AlumnoTarifa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_acepta_tarifa")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAceptaTarifa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activacion")
    private Usuario userActivacion;

    @Column(name = "fecha_activacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desactivacion")
    private Usuario userDesactivacion;

    @Column(name = "fecha_desactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @JoinColumn(name = "id_tarifa_carrera")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TarifaCarrera tarifaCarrera;

    @Column(name = "usuario_migracion")
    private String usuarioMigracion;

    @Transient
    private TarifaCarrera tarifaNueva;

    public AlumnoTarifa() {
    }

    public AlumnoTarifa(Object id) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public boolean isEstadoActivo() {
        return EstadoEnum.ACT.name().equals(this.estado);
    }

    public Date getFechaAceptaTarifa() {
        return fechaAceptaTarifa;
    }

    public void setFechaAceptaTarifa(Date fechaAceptaTarifa) {
        this.fechaAceptaTarifa = fechaAceptaTarifa;
    }

    public Usuario getUserActivacion() {
        return userActivacion;
    }

    public void setUserActivacion(Usuario userActivacion) {
        this.userActivacion = userActivacion;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
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

    public TarifaCarrera getTarifaCarrera() {
        return tarifaCarrera;
    }

    public void setTarifaCarrera(TarifaCarrera tarifaCarrera) {
        this.tarifaCarrera = tarifaCarrera;
    }

    public TarifaCarrera getTarifaNueva() {
        return tarifaNueva;
    }

    public void setTarifaNueva(TarifaCarrera tarifaNueva) {
        this.tarifaNueva = tarifaNueva;
    }

    public String getUsuarioMigracion() {
        return usuarioMigracion;
    }

    public void setUsuarioMigracion(String usuarioMigracion) {
        this.usuarioMigracion = usuarioMigracion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Usuario getUserDesactivacion() {
        return userDesactivacion;
    }

    public void setUserDesactivacion(Usuario userDesactivacion) {
        this.userDesactivacion = userDesactivacion;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

}
