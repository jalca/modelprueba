package pe.edu.lamolina.model.almacen;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.finanzas.Moneda;
import pe.edu.lamolina.model.general.UnidadMedida;

@Entity
@Table(name = "alm_existencia")
public class Existencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year_mes")
    private String yearMes;

    @Column(name = "cantidad_inicial")
    private BigDecimal cantidadInicial;

    @Column(name = "cantidad_final")
    private BigDecimal cantidadFinal;

    @Column(name = "precio_unitario_inicial")
    private BigDecimal precioUnitarioInicial;

    @Column(name = "precio_total_inicial")
    private BigDecimal precioTotalInicial;

    @Column(name = "precio_unitario_final")
    private BigDecimal precioUnitarioFinal;

    @Column(name = "precio_total_final")
    private BigDecimal precioTotalFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    public Existencia() {
    }

    public Existencia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public String getYearMes() {
        return yearMes;
    }

    public void setYearMes(String yearMes) {
        this.yearMes = yearMes;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(BigDecimal cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public BigDecimal getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(BigDecimal cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getPrecioUnitarioInicial() {
        return precioUnitarioInicial;
    }

    public void setPrecioUnitarioInicial(BigDecimal precioUnitarioInicial) {
        this.precioUnitarioInicial = precioUnitarioInicial;
    }

    public BigDecimal getPrecioTotalInicial() {
        return precioTotalInicial;
    }

    public void setPrecioTotalInicial(BigDecimal precioTotalInicial) {
        this.precioTotalInicial = precioTotalInicial;
    }

    public BigDecimal getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public void setPrecioUnitarioFinal(BigDecimal precioUnitarioFinal) {
        this.precioUnitarioFinal = precioUnitarioFinal;
    }

    public BigDecimal getPrecioTotalFinal() {
        return precioTotalFinal;
    }

    public void setPrecioTotalFinal(BigDecimal precioTotalFinal) {
        this.precioTotalFinal = precioTotalFinal;
    }
    
    public ObjectNode toJson() {
        
        JsonNodeFactory factory = JsonNodeFactory.instance;
        Almacen almacen = this.almacen != null ? this.almacen : new Almacen();
        Producto producto = this.producto != null ? this.producto : new Producto();
        Producto productoSuperior = producto.getProductoSuperior() != null ? producto.getProductoSuperior()  : new Producto();
        Moneda moneda = this.moneda != null ? this.moneda :  new Moneda();
        UnidadMedida unidadMedida = this.unidadMedida != null ? this.unidadMedida : new UnidadMedida();
        
        ObjectNode productoJson = JsonHelper.createJson(producto, factory);
        productoJson.set("productoSuperior", JsonHelper.createJson(productoSuperior, factory));
        
        ObjectNode json = JsonHelper.createJson(this, factory);
        json.set("almacen",JsonHelper.createJson(almacen, factory));
        json.set("producto", productoJson);
        json.set("moneda", JsonHelper.createJson(moneda, factory));
        json.set("unidadMedida", JsonHelper.createJson(unidadMedida, factory));
        
        return json;
    }

}

