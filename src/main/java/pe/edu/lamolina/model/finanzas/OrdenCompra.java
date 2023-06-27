package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoOrdenCompraEnum;
import pe.edu.lamolina.model.enums.EstadoPagoOrdenCompraEnum;
import pe.edu.lamolina.model.enums.EstadoRecepcionOrdenCompraEnum;
import pe.edu.lamolina.model.finanzas.enums.TipoOrdenCompraEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.posgrado.empresa.ContactoEmpresaEPG;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "fin_orden_compra")
public class OrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pago_dias")
    private Integer pagoDias;

    @Column(name = "incluye_impuestos")
    private Boolean incluyeImpuestos;

    @Column(name = "cotizacion")
    private String cotizacion;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_pago")
    private String estadoPago;

    @Column(name = "estado_recepcion")
    private String estadoRecepcion;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;

    @Column(name = "tipo_orden")
    private String tipoOrden;

    @Column(name = "id_user_vb")
    private Long usuarioVB;

    @Column(name = "fecha_cotizacion")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCotizacion;

    @Column(name = "fecha_vb")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaVB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable_1")
    private Colaborador responsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable_2")
    private Colaborador responsableDos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private Empresa proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contacto")
    private ContactoEmpresaEPG contactoEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_responsable")
    private Oficina oficinaResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<DetalleOrdenCompra> detalleOrdenCompra;

    @Transient
    private Persona director;

    @Transient
    private String texto;

    public OrdenCompra() {
    }

    public OrdenCompra(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoOrdenCompraEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoOrdenCompraEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoOrdenCompraEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoPagoOrdenCompraEnum getEstadoPagoEnum() {
        if (estadoPago == null) {
            return null;
        }
        return EstadoPagoOrdenCompraEnum.valueOf(estadoPago);
    }

    @JsonIgnore
    public void setEstadoPagoEnum(EstadoPagoOrdenCompraEnum estadoPago) {
        if (estadoPago == null) {
            return;
        }
        this.estadoPago = estadoPago.name();
    }

    public EstadoRecepcionOrdenCompraEnum getEstadoRecepcionEnum() {
        if (estadoRecepcion == null) {
            return null;
        }
        return EstadoRecepcionOrdenCompraEnum.valueOf(estadoRecepcion);
    }

    @JsonIgnore
    public void setEstadoRecepcionEnum(EstadoRecepcionOrdenCompraEnum estadoRecepcionEnum) {
        if (estadoRecepcionEnum == null) {
            return;
        }
        this.estadoRecepcion = estadoRecepcionEnum.name();
    }

    public TipoOrdenCompraEnum getTipoOrdenEnum() {
        if (tipoOrden == null) {
            return null;
        }
        return TipoOrdenCompraEnum.valueOf(tipoOrden);
    }

    public String getSerieNumero() {
        return String.format("%s-%04d", serie, Integer.parseInt(numero));
    }

}
