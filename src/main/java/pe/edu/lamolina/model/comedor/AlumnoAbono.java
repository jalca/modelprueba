package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.comedor.TipoOperacionComedorEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_alumno_abono")
public class AlumnoAbono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "tipo_operacion")
    private String tipoOperacion;

    @Column(name = "tipo_transferencia")
    private String tipoTransferencia;

    @Column(name = "numero_recibo")
    private String numeroRecibo;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_comedor")
    private TicketComedor ticketComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_comedor")
    private AlumnoComedor alumnoComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operacion_abono_origen")
    private AlumnoAbono operacionAbonoOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operacion_abono_destino")
    private AlumnoAbono operacionAbonoDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @Transient
    private BigDecimal saldo;

    public AlumnoAbono(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getRecibo() {
        if (this.serie == null) {
            return null;
        }
        if (this.numero == null) {
            return null;
        }
        return this.serie
                .concat("-")
                .concat(NumberFormat.codigo(this.numero, 5));
    }

    public void seTipoOperacionEnum(TipoOperacionComedorEnum tipoOperacion) {
        if (tipoOperacion == null) {
            return;
        }
        this.tipoOperacion = tipoOperacion.name();
    }

    public TipoOperacionComedorEnum getTipoOperacionEnum() {
        if (StringUtils.isBlank(tipoOperacion)) {
            return null;
        }
        return TipoOperacionComedorEnum.valueOf(tipoOperacion);
    }

    public void setTipoTransferenciaEnum(TipoOperacionComedorEnum tipoTransferencia) {
        if (tipoTransferencia == null) {
            return;
        }
        this.tipoTransferencia = tipoTransferencia.name();
    }

    public TipoOperacionComedorEnum getTipoTransferenciaEnum() {
        if (StringUtils.isBlank(tipoTransferencia)) {
            return null;
        }
        return TipoOperacionComedorEnum.valueOf(tipoTransferencia);
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

}
