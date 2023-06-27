package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.TemporalType;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "fin_cheque_pedido")
public class ChequePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "comprobante_egreso")
    private String comprobanteEgreso;

    @Column(name = "recibe_cheque")
    private String recibeCheque;

    @Column(name = "numero_equis")
    private Integer numeroEquis;

    @Column(name = "codigo_cheque")
    private String codigoCheque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido_gasto")
    private PedidoGasto pedidoGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_pedido_gasto")
    private DetallePedidoGasto detallePedidoGasto;

    @Column(name = "fecha_cheque")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCheque;

    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_entrega")
    private Usuario userEntrega;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public ChequePedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigoCheque() {
        return codigoCheque;
    }

    public void setCodigoCheque(String codigoCheque) {
        this.codigoCheque = codigoCheque;
    }

    public Date getFechaCheque() {
        return fechaCheque;
    }

    public void setFechaCheque(Date fechaCheque) {
        this.fechaCheque = fechaCheque;
    }

    public PedidoGasto getPedidoGasto() {
        return pedidoGasto;
    }

    public void setPedidoGasto(PedidoGasto pedidoGasto) {
        this.pedidoGasto = pedidoGasto;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Usuario getUserEntrega() {
        return userEntrega;
    }

    public void setUserEntrega(Usuario userEntrega) {
        this.userEntrega = userEntrega;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getComprobanteEgreso() {
        return comprobanteEgreso;
    }

    public void setComprobanteEgreso(String comprobanteEgreso) {
        this.comprobanteEgreso = comprobanteEgreso;
    }

    public String getRecibeCheque() {
        return recibeCheque;
    }

    public void setRecibeCheque(String recibeCheque) {
        this.recibeCheque = recibeCheque;
    }

    public Integer getNumeroEquis() {
        return numeroEquis;
    }

    public void setNumeroEquis(Integer numeroEquis) {
        this.numeroEquis = numeroEquis;
    }

    public DetallePedidoGasto getDetallePedidoGasto() {
        return detallePedidoGasto;
    }

    public void setDetallePedidoGasto(DetallePedidoGasto detallePedidoGasto) {
        this.detallePedidoGasto = detallePedidoGasto;
    }
}
