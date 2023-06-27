package pe.edu.lamolina.model.atencion;

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
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoMensajeTicketAyudaEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Data
@Table(name = "atc_mensaje_ticket_ayuda")
public class MensajeTicketAyuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_ayuda")
    private TicketAyuda ticketAyuda;

    @Transient
    private List<Archivo> archivos;

    public MensajeTicketAyuda() {
    }

    public MensajeTicketAyuda(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public void setTipoEnum(TipoMensajeTicketAyudaEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.name();
        }
    }

    public TipoMensajeTicketAyudaEnum getTipoEnum() {
        if (StringUtils.isBlank(tipo)) {
            return null;
        }
        return TipoMensajeTicketAyudaEnum.valueOf(tipo);
    }

    public String getFechaRegistroStr() {
        if (this.fechaRegistro == null) {
            return null;
        }
        return TypesUtil.getStringDateLongFormat(this.fechaRegistro);
    }

}
