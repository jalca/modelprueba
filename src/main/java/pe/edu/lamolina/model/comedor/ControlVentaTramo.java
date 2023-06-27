package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "com_control_venta_tramo")
public class ControlVentaTramo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tramo")
    private Integer tramo;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Column(name = "raciones")
    private Integer raciones;

    @Column(name = "reservas")
    private Integer reservas;

    @Column(name = "disponibles")
    private Integer disponibles;

    @Column(name = "recibido")
    private Integer recibido;

    @Column(name = "enviado")
    private Integer enviado;

    @Column(name = "utilizado")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean utilizado;

    @Column(name = "fecha_venta")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVenta;

    @Column(name = "fecha_comedor")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_venta_tramo")
    private TipoVentaTramo tipoVentaTramo;

    @Transient
    private TicketComedor ticketComedor;

    public ControlVentaTramo() {
    }

    public ControlVentaTramo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getKeyFechaVenta() {
        if (this.tipoVentaTramo == null) {
            return null;
        }
        if (this.fechaVenta == null) {
            return null;
        }
        return this.tipoVentaTramo.getId() + "-" + new DateTime(this.fechaVenta).toString("dd/MM/yyyy");
    }

    public Integer getRecibido() {
        if (recibido == null) {
            return 0;
        }
        return recibido;
    }

    public Integer getEnviado() {
        if (enviado == null) {
            return 0;
        }
        return enviado;
    }

    public Boolean getUtilizado() {
        if (utilizado == null) {
            return false;
        }
        return utilizado;
    }

    public Integer getHoraInicioNumber() {
        if (this.horaInicio == null) {
            return null;
        }
        return new Integer(this.horaInicio.replace(":", ""));
    }

    public Integer getHoraFinNumber() {
        if (this.horaFin == null) {
            return null;
        }
        return new Integer(this.horaFin.replace(":", ""));
    }

    public Date getFechaHoraInicioVenta() {
        if (this.fechaVenta == null) {
            return null;
        }
        if (this.horaInicio == null) {
            return null;
        }

        String fecha = new DateTime(this.fechaVenta).toString("yyyy-MM-dd");
        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        long millis = df.parseMillis(fecha + " " + this.horaInicio);

        return new Date(millis);
    }

    public Date getFechaHoraFinVenta() {
        if (this.fechaVenta == null) {
            return null;
        }
        if (this.horaFin == null) {
            return null;
        }

        String fecha = new DateTime(this.fechaVenta).toString("yyyy-MM-dd");
        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        long millis = df.parseMillis(fecha + " " + this.horaFin);

        return new Date(millis);
    }

    public Date getFechaHoraInicioAtencion() {
        if (this.fechaComedor == null) {
            return null;
        }
        if (this.tipoVentaTramo == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio() == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio().getHoraInicioAtencion() == null) {
            return null;
        }

        String fecha = new DateTime(this.fechaComedor).toString("yyyy-MM-dd");
        String hora = this.tipoVentaTramo.getTipoServicio().getHoraInicioAtencion();

        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        long millis = df.parseMillis(fecha + " " + hora);

        return new Date(millis);
    }

    public Date getFechaHoraFinAtencion() {
        if (this.fechaComedor == null) {
            return null;
        }
        if (this.tipoVentaTramo == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio() == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio().getHoraFinAtencion() == null) {
            return null;
        }

        String fecha = new DateTime(this.fechaComedor).toString("yyyy-MM-dd");
        String hora = this.tipoVentaTramo.getTipoServicio().getHoraFinAtencion();

        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        long millis = df.parseMillis(fecha + " " + hora);

        return new Date(millis);
    }
    
    public Date getFechaHoraInicioAlerta() {
        if (this.fechaComedor == null) {
            return null;
        }
        if (this.tipoVentaTramo == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio() == null) {
            return null;
        }
        if (this.tipoVentaTramo.getTipoServicio().getHoraInicioAtencion() == null) {
            return null;
        }

        String fecha = new DateTime(this.fechaComedor).toString("yyyy-MM-dd");
        String hora = this.tipoVentaTramo.getTipoServicio().getHoraAlerta();

        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        long millis = df.parseMillis(fecha + " " + hora);

        return new Date(millis);
    }

    public static class CompareOrdenAtencio implements Comparator<ControlVentaTramo> {

        @Override
        public int compare(ControlVentaTramo tramo1, ControlVentaTramo tramo2) {
            int comparacion = tramo1.getFechaComedor().compareTo(tramo2.getFechaComedor());
            if (comparacion == 0) {
                TipoServicioComedor tipo1 = tramo1.getTipoVentaTramo().getTipoServicio();
                TipoServicioComedor tipo2 = tramo2.getTipoVentaTramo().getTipoServicio();
                comparacion = tipo1.getId().compareTo(tipo2.getId());
            }

            return comparacion;
        }
    }

}
