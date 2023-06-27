package pe.edu.lamolina.model.almacen;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.finanzas.Moneda;
import pe.edu.lamolina.model.general.UnidadMedida;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "alm_lote_producto")
public class LoteProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "cantidad_inicial")
    private BigDecimal cantidadInicial;

    @Column(name = "cantidad_disponible")
    private BigDecimal cantidadDisponible;

    @Column(name = "cantidad_reservada")
    private BigDecimal cantidadReservada;

    @Column(name = "cantidad_merma")
    private BigDecimal cantidadMerma;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "precio_total_inicial")
    private BigDecimal precioTotalInicial;

    @Column(name = "precio_total_final")
    private BigDecimal precioTotalFinal;

    @Column(name = "fecha_vencimiento")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_movimiento_almacen")
    private ItemMovimientoAlmacen itemMovimientoAlmacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    public LoteProducto() {
    }

    public LoteProducto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getNombre() {
        String nombre = this.codigo;
        if (this.fechaVencimiento != null) {
            nombre += " FV.:" + TypesUtil.getStringDate(this.fechaVencimiento, "dd/MM/yyyy");
        }
        return nombre;
    }

}
