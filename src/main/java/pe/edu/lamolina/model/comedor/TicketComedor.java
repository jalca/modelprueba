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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.TicketComedorEstadoEnum;
import pe.edu.lamolina.model.enums.comedor.TipoClienteComedorEnum;
import pe.edu.lamolina.model.enums.comedor.TipoComensalEnum;
import pe.edu.lamolina.model.general.TipoDocumentoCompania;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "com_ticket_comedor")
public class TicketComedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private Integer serie;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "es_becado")
    private Integer esBecado;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_comensal")
    private String tipoComensal;

    @Column(name = "hora_postergado")
    private String horaPostergado;

    @Column(name = "reservado")
    private Integer reservado;

    @Column(name = "liberado")
    private Integer liberado;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "postergado")
    private Integer postergado;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_postergacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPostergacion;

    @Column(name = "fecha_venta")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVenta;

    @Column(name = "fecha_consumo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaConsumo;

    @Column(name = "fecha_salida")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoCompania tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio_comedor")
    private TipoServicioComedor tipoServicioComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comensal_generico")
    private ComensalGenerico comensalGenerico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_becado_comedor")
    private BecadoComedor becadoComedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control_venta_tramo")
    private ControlVentaTramo controlVentaTramo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @Transient
    private String motivoOperacion;

    public TicketComedor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TicketComedor(Integer serie, Long numero) {
        this.serie = serie;
        this.numero = numero;
    }

    public TicketComedorEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return TicketComedorEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TicketComedorEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getNumeroTicket() {
        if (this.serie == null) {
            return null;
        }
        if (this.numero == null) {
            return null;
        }
        return this.serie.toString().concat("-").concat(NumberFormat.codigo(this.numero, 6));
    }

    @JsonIgnore
    public void setTipoComensalEnum(TipoComensalEnum tipoComensal) {
        if (tipoComensal == null) {
            return;
        }
        this.tipoComensal = tipoComensal.name();
    }

    public TipoComensalEnum getTipoComensalEnum() {
        if (StringUtils.isBlank(tipoComensal)) {
            return null;
        }
        return TipoComensalEnum.valueOf(tipoComensal);
    }

    public String getNumeroCodigo() {
        if (this.numero == null) {
            return null;
        }
        return NumberFormat.codigo(this.numero, 6);
    }

    public TipoClienteComedorEnum getTipoClienteEnum() {
        if (this.becadoComedor != null) {
            return TipoClienteComedorEnum.BECADO;
        } else {
            return TipoClienteComedorEnum.ALUMNO;
        }
    }

    public String getTipoCliente() {
        return this.getTipoClienteEnum().getValue();
    }

}
