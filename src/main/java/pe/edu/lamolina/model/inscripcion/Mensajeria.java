package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.MensajeriaEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_mensajeria")
public class Mensajeria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "mensajes_planificados")
    private Integer mensajesPlanificados;

    @Column(name = "mensajes_enviados")
    private Integer mensajesEnviados;

    @Column(name = "mensajes_aceptados")
    private Integer mensajesAceptados;

    @Column(name = "filtro")
    private String filtro;

    @Column(name = "ciclos")
    private String ciclos;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_envio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario usuarioCreacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @Transient
    private String adicionales;

    @Transient
    private boolean anular;

    @Transient
    private Integer mensajesPendientes;

    @Transient
    private boolean error;

    public Mensajeria() {
        anular = false;
        error = false;
    }

    public Mensajeria(Object id) {
        this.id = TypesUtil.getLong(id);
        anular = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MensajeriaEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return MensajeriaEstadoEnum.valueOf(estado);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getMensajesPlanificados() {
        return mensajesPlanificados;
    }

    public void setMensajesPlanificados(Integer mensajesPlanificados) {
        this.mensajesPlanificados = mensajesPlanificados;
    }

    public Integer getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(Integer mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public String getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(String adicionales) {
        this.adicionales = adicionales;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Integer getMensajesAceptados() {
        return mensajesAceptados;
    }

    public void setMensajesAceptados(Integer mensajesAceptados) {
        this.mensajesAceptados = mensajesAceptados;
    }

    public Integer getMensajesPendientes() {
        return mensajesPendientes;
    }

    public void setMensajesPendientes(Integer mensajesPendientes) {
        this.mensajesPendientes = mensajesPendientes;
    }

    public boolean isAnular() {
        return anular;
    }

    public void setAnular(boolean anular) {
        this.anular = anular;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}
