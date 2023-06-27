package pe.edu.lamolina.model.finanzas;

import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.almacen.Producto;

@Getter
@Setter
@Entity
@Table(name = "fin_detalle_orden_compra")
public class DetalleOrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "marca")
    private String marca;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "inventario")
    private Boolean inventario;

    @Column(name = "ingreso")
    private BigDecimal ingreso;

    @Column(name = "registrar")
    private BigDecimal registrar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    public DetalleOrdenCompra() {
    }

    public DetalleOrdenCompra(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
