package pe.edu.lamolina.model.comedor;

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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.TicketLiberadoEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@Table(name = "com_ticket_liberado")
public class TicketLiberado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_liberacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaLiberacion;

    @Column(name = "fecha_consumo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaConsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_liberado")
    private TicketComedor ticketLiberado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_consumo")
    private TicketComedor ticketConsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_liberacion")
    private Usuario userLiberacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_consumo")
    private Usuario userConsumo;

    public TicketLiberado() {
    }

    public TicketLiberado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TicketLiberadoEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return TicketLiberadoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TicketLiberadoEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getKeyAlumnoServicio() {
        if (this.alumno == null) {
            return null;
        }
        if (this.fecha == null) {
            return null;
        }
        if (this.ticketLiberado == null) {
            return null;
        }
        if (this.ticketLiberado.getTipoServicioComedor() == null) {
            return null;
        }

        return new DateTime(this.fecha).toString("yyyyMMdd") + "-"
                + this.alumno.getId() + "-"
                + this.ticketLiberado.getTipoServicioComedor().getId();
    }
}
