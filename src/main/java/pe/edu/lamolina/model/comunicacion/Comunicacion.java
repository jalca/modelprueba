package pe.edu.lamolina.model.comunicacion;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
import org.springframework.util.CollectionUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.enums.MessageOriginEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.inscripcion.Interesado;

@Entity
@Table(name = "sip_comunicacion")
public class Comunicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "leido")
    private Boolean leido;

    @Column(name = "origen")
    private String origen;

    @Column(name = "identificador")
    private String identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona encargado;

    @Transient
    private List<Conversacion> conversaciones;

    @Transient
    private String celular;

    @Transient
    private String dni;

    public Comunicacion() {
    }

    public Comunicacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Conversacion> getConversaciones() {
        return conversaciones;
    }

    public void setConversaciones(List<Conversacion> conversaciones) {
        this.conversaciones = conversaciones;
    }

    public void addConversacion(Conversacion conversacion) {
        if (CollectionUtils.isEmpty(this.conversaciones)) {
            this.conversaciones = new ArrayList();
        }
        this.conversaciones.add(conversacion);
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance, true);

        json.set("interesado", JsonHelper.createJson(this.interesado, JsonNodeFactory.instance, true));

        if (this.encargado != null) {

            ObjectNode jsonEncargado = new ObjectNode(JsonNodeFactory.instance);
            jsonEncargado.put("nombreCompleto", this.encargado.getNombreCompleto());

            json.set("encargado", jsonEncargado);
        }

        return json;
    }

}
