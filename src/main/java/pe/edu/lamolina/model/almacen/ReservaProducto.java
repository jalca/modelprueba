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
import pe.edu.lamolina.model.enums.ReservaProductoEstadoEnum;
import pe.edu.lamolina.model.general.UnidadMedida;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "alm_reserva_producto")
public class ReservaProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tabla_reserva")
    private String tablaReserva;

    @Column(name = "instancia_reserva")
    private Long instanciaReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lote_producto")
    private LoteProducto loteProducto;

    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Column(name = "cantidad_entregada")
    private BigDecimal cantidadEntregada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

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

    public String getTablaReserva() {
        return tablaReserva;
    }

    public void setTablaReserva(String tablaReserva) {
        this.tablaReserva = tablaReserva;
    }

    public Long getInstanciaReserva() {
        return instanciaReserva;
    }

    public void setInstanciaReserva(Long instanciaReserva) {
        this.instanciaReserva = instanciaReserva;
    }

    public LoteProducto getLoteProducto() {
        return loteProducto;
    }

    public void setLoteProducto(LoteProducto loteProducto) {
        this.loteProducto = loteProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(BigDecimal cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ReservaProductoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ReservaProductoEstadoEnum.valueOf(estado);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(ReservaProductoEstadoEnum estado) {
        this.estado = estado.name();
    }

}
