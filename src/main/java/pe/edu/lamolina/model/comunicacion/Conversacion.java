package pe.edu.lamolina.model.comunicacion;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.util.CollectionUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.MessageOriginEnum;

@Entity
@Table(name = "sip_conversacion")
public class Conversacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identificador")
    private String identificador;

    @Column(name = "origen")
    private String origen;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "contenido")
    @Convert(converter = MensajeJsonConverter.class)
    private List<Mensaje> mensajes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comunicacion")
    private Comunicacion comunicacion;

    public Conversacion() {
    }

    public Conversacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public String getOrigen() {
        return origen;
    }

    public MessageOriginEnum getOrigenEnum() {
        return MessageOriginEnum.valueOf(origen);
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Comunicacion getComunicacion() {
        return comunicacion;
    }

    public void setComunicacion(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }

    public String getEstado() {
        return estado;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void addMensaje(Mensaje mensaje) {
        if (CollectionUtils.isEmpty(this.mensajes)) {
            this.mensajes = new ArrayList();
        }
        this.mensajes.add(mensaje);
    }

    public Mensaje getUltimoMensaje() {
        return this.mensajes.get(this.mensajes.size() - 1);
    }

    public ObjectNode toJson(boolean onlyLast) {

        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance, true);

        json.set("comunicacion", this.comunicacion.toJson());

        this.addJsonMensajes(json, onlyLast);

        return json;
    }

    private void addJsonMensajes(ObjectNode json, boolean onlyLast) {

        if (onlyLast) {
            ObjectNode mensajeJson = this.getUltimoMensaje().toJson();
            json.set("mensajes", mensajeJson);

        } else {

            ArrayNode mensajesArray = new ArrayNode(JsonNodeFactory.instance);

            for (Mensaje mensaje : this.mensajes) {
                mensajesArray.add(mensaje.toJson());
            }

            json.set("mensajes", mensajesArray);
        }

    }

}
