package pe.edu.lamolina.model.almacen;

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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.finanzas.Moneda;
import pe.edu.lamolina.model.finanzas.OrdenCompra;
import pe.edu.lamolina.model.general.DocumentoCompania;
import pe.edu.lamolina.model.general.DocumentoExterno;
import pe.edu.lamolina.model.medico.Consultorio;
import pe.edu.lamolina.model.pedidos.Pedido;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "alm_movimiento_almacen")
public class MovimientoAlmacen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private Integer serie;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "fecha_movimiento")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMovimiento;

    @Column(name = "monto_subtotal")
    private BigDecimal montoSubtotal;

    @Column(name = "monto_impuesto")
    private BigDecimal montoImpuesto;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_movimiento")
    private TipoMovimiento tipoMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_compania")
    private DocumentoCompania documentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_externo")
    private DocumentoExterno documentoExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio_destino")
    private Consultorio consultorioDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @Transient
    private List<ItemMovimientoAlmacen> itemMovimientoAlmacen;

    @Transient
    private Pedido pedido;

    public MovimientoAlmacen() {
    }

    public MovimientoAlmacen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCodigo() {
        if (serie == null || numero == null) {
            return null;
        }
        return "" + serie + "-" + numero;
    }

}
