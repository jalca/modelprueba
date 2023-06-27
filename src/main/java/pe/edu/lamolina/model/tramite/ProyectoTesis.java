package pe.edu.lamolina.model.tramite;

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
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EstadoProyectoTesisEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_proyecto_tesis")
public class ProyectoTesis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_presentacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaPresentacion;

    @Column(name = "fecha_aprobacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAprobacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_aceptacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAceptacion;

    @Column(name = "fecha_observacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaObservacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_presentacion")
    private Usuario userPresentacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aceptacion")
    private Usuario userAceptacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_observacion")
    private Usuario userObservacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_tesis")
    private Archivo documentoTesis;

    @OneToMany(mappedBy = "proyectoTesis", fetch = FetchType.LAZY)
    private List<ObservacionProyectoTesis> observacionProyectoTesis;

    @OneToMany(mappedBy = "proyectoTesis", fetch = FetchType.LAZY)
    private List<AprobadorProyectoTesis> aprobadorProyectoTesis;

    @Transient
    private boolean agendadoReunionConsejo;

    public ProyectoTesis() {
    }

    public ProyectoTesis(Object id) {
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

    public EstadoProyectoTesisEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoProyectoTesisEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoProyectoTesisEnum estado) {
        this.estado = estado.name();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public Date getFechaObservacion() {
        return fechaObservacion;
    }

    public void setFechaObservacion(Date fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }

    public Usuario getUserPresentacion() {
        return userPresentacion;
    }

    public void setUserPresentacion(Usuario userPresentacion) {
        this.userPresentacion = userPresentacion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserAceptacion() {
        return userAceptacion;
    }

    public void setUserAceptacion(Usuario userAceptacion) {
        this.userAceptacion = userAceptacion;
    }

    public Usuario getUserObservacion() {
        return userObservacion;
    }

    public void setUserObservacion(Usuario userObservacion) {
        this.userObservacion = userObservacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public List<ObservacionProyectoTesis> getObservacionProyectoTesis() {
        return observacionProyectoTesis;
    }

    public void setObservacionProyectoTesis(List<ObservacionProyectoTesis> observacionProyectoTesis) {
        this.observacionProyectoTesis = observacionProyectoTesis;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public List<AprobadorProyectoTesis> getAprobadorProyectoTesis() {
        return aprobadorProyectoTesis;
    }

    public void setAprobadorProyectoTesis(List<AprobadorProyectoTesis> aprobadorProyectoTesis) {
        this.aprobadorProyectoTesis = aprobadorProyectoTesis;
    }

    public Archivo getDocumentoTesis() {
        return documentoTesis;
    }

    public void setDocumentoTesis(Archivo documentoTesis) {
        this.documentoTesis = documentoTesis;
    }

    public boolean isAgendadoReunionConsejo() {
        return agendadoReunionConsejo;
    }

    public void setAgendadoReunionConsejo(boolean agendadoReunionConsejo) {
        this.agendadoReunionConsejo = agendadoReunionConsejo;
    }

}
