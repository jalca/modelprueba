package pe.edu.lamolina.model.almacen;

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
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.finanzas.DetalleOrdenCompra;
import pe.edu.lamolina.model.general.UnidadMedida;
import pe.edu.lamolina.model.pedidos.DetallePedido;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "alm_item_movimiento_almacen")
public class ItemMovimientoAlmacen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inventariar")
    private Boolean inventariar;

    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "cantidad_final")
    private BigDecimal cantidadFinal;

    @Column(name = "precio_unitario_final")
    private BigDecimal precioUnitarioFinal;

    @Column(name = "precio_total_final")
    private BigDecimal precioTotalFinal;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_almacen")
    private MovimientoAlmacen movimientoAlmacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lote_producto")
    private LoteProducto loteProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida_final")
    private UnidadMedida unidadMedidaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_orden_compra")
    private DetalleOrdenCompra detalleOrdenCompra;

    @Transient
    private DetallePedido detallePedido;

    @Transient
    private List<Inventario> inventarios;

    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaVencimiento;

    @Transient
    private String codigoLote;

    public ItemMovimientoAlmacen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

}
