package pe.edu.lamolina.model.inscripcion;

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

@Entity
@Table(name = "sip_destinatario_mensajeria")
public class DestinatarioMensajeria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_envio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @Column(name = "elemento_destino")
    private String elementoDestino;

    @Column(name = "codigo_uuid")
    private String codigoUuid;

    @Column(name = "mensaje_error")
    private String mensajeError;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mensajeria")
    private Mensajeria mensajeria;

    public DestinatarioMensajeria() {
    }

    public DestinatarioMensajeria(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mensajeria getMensajeria() {
        return mensajeria;
    }

    public void setMensajeria(Mensajeria mensajeria) {
        this.mensajeria = mensajeria;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getElementoDestino() {
        return elementoDestino;
    }

    public void setElementoDestino(String elementoDestino) {
        this.elementoDestino = elementoDestino;
    }

    public String getCodigoUuid() {
        return codigoUuid;
    }

    public void setCodigoUuid(String codigoUuid) {
        this.codigoUuid = codigoUuid;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}

