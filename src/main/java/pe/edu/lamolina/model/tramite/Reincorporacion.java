package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.albatross.zelpers.spring.deserializer.DateTimeDeserializer;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "tram_reincorporacion")
public class Reincorporacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo_desercion")
    private String motivoDesercion;

    @Column(name = "motivo_rechazo")
    private String motivoRechazo;

    @Column(name = "aceptado")
    private Integer aceptado;

    @Column(name = "es_condicional")
    private Boolean esCondicional;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_reincorporacion")
    private CicloAcademico cicloReincorporacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private boolean agendadoReunionConsejo;

    @Transient
    private boolean seleccionado;

    @Transient
    private boolean rechazado;

    public Reincorporacion() {
        this.aceptado = 0;
        this.esCondicional = false;
    }

    public Reincorporacion(Object id) {
        this.id = TypesUtil.getLong(id);
        this.aceptado = 0;
        this.esCondicional = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public String getMotivoDesercion() {
        return motivoDesercion;
    }

    public void setMotivoDesercion(String motivoDesercion) {
        this.motivoDesercion = motivoDesercion;
    }

    public CicloAcademico getCicloReincorporacion() {
        return cicloReincorporacion;
    }

    public void setCicloReincorporacion(CicloAcademico cicloReincorporacion) {
        this.cicloReincorporacion = cicloReincorporacion;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
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

    public Integer getAceptado() {
        return aceptado;
    }

    public void setAceptado(Integer aceptado) {
        this.aceptado = aceptado;
    }

    public boolean getEstaAceptado() {
        if (this.aceptado.compareTo(BigDecimal.ONE.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Boolean getEsCondicional() {
        if (esCondicional == null) {
            return false;
        }
        return esCondicional;
    }

    public void setEsCondicional(Boolean esCondicional) {
        this.esCondicional = esCondicional;
    }

    public boolean getAgendadoReunionConsejo() {
        return agendadoReunionConsejo;
    }

    public void setAgendadoReunionConsejo(boolean agendadoReunionConsejo) {
        this.agendadoReunionConsejo = agendadoReunionConsejo;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public static class CompareCiclo implements Comparator<Reincorporacion> {

        @Override
        public int compare(Reincorporacion s1, Reincorporacion s2) {
            return s1.getCicloReincorporacion().getCodigo().compareTo(s2.getCicloReincorporacion().getCodigo());
        }
    }

    public boolean getEsPosibleRevertirEstadoTram() {
        if (this.getEstadoTramite().getEsSolicitudHistorialRevisado()
                || this.getEstadoTramite().getEsConsejoFacultad()) {
            return true;
        }
        return false;
    }

    public ObjectNode toJson() {
        JsonNodeFactory jc = JsonNodeFactory.instance;
        ObjectNode node = JsonHelper.createJson(this, jc);

        node.putPOJO("estadoTramite", this.estadoTramite == null ? new EstadoTramite() : this.estadoTramite.toJson());
        return node;
    }

    public boolean isRechazado() {
        return rechazado;
    }

    public void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }

}
