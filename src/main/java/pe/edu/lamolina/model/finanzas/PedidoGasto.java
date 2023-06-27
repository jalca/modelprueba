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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CodigoTipoPedidoGastoEnum;
import pe.edu.lamolina.model.enums.EstadoPedidoGastoEnum;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.general.DocumentoCompania;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "fin_pedido_gasto")
public class PedidoGasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_gasto")
    private String tipoGasto;

    @Column(name = "serie")
    private Integer serie;

    @Column(name = "numero_pedido")
    private Integer numeroPedido;

    @Column(name = "descripcion_gasto")
    private String descripcionGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_dupg")
    private Oficina oficinaDupg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_solicita")
    private Oficina oficinaSolicitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_responsable")
    private Oficina oficinaResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_compania")
    private DocumentoCompania documentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaPedido;

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

    @OneToMany(mappedBy = "pedidoGasto", fetch = FetchType.LAZY)
    private List<DetallePedidoGasto> detallePedidoGasto;

    @OneToMany(mappedBy = "pedidoGasto", fetch = FetchType.LAZY)
    private List<ChequePedido> chequePedido;

    @OneToMany(mappedBy = "pedidoGasto", fetch = FetchType.LAZY)
    private List<DistribucionGasto> distribucionGasto;

    public PedidoGasto() {
    }

    public PedidoGasto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getDescripcionGasto() {
        return descripcionGasto;
    }

    public void setDescripcionGasto(String descripcionGasto) {
        this.descripcionGasto = descripcionGasto;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public Oficina getOficinaSolicitante() {
        return oficinaSolicitante;
    }

    public void setOficinaSolicitante(Oficina oficinaSolicitante) {
        this.oficinaSolicitante = oficinaSolicitante;
    }

    public Oficina getOficinaResponsable() {
        return oficinaResponsable;
    }

    public void setOficinaResponsable(Oficina oficinaResponsable) {
        this.oficinaResponsable = oficinaResponsable;
    }

    public DocumentoCompania getDocumentoCompania() {
        return documentoCompania;
    }

    public void setDocumentoCompania(DocumentoCompania documentoCompania) {
        this.documentoCompania = documentoCompania;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public EstadoPedidoGastoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoPedidoGastoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoPedidoGastoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public List<DetallePedidoGasto> getDetallePedidoGasto() {
        return detallePedidoGasto;
    }

    public void setDetallePedidoGasto(List<DetallePedidoGasto> detallePedidoGasto) {
        this.detallePedidoGasto = detallePedidoGasto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public CodigoTipoPedidoGastoEnum getTipoGastoEnum() {
        if (StringUtils.isBlank(tipoGasto)) {
            return null;
        }
        return CodigoTipoPedidoGastoEnum.valueOf(tipoGasto);
    }

    @JsonIgnore
    public void setTipoGastoEnum(CodigoTipoPedidoGastoEnum codigoEnum) {
        if (codigoEnum == null) {
            return;
        }
        this.tipoGasto = codigoEnum.name();
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public List<ChequePedido> getChequePedido() {
        return chequePedido;
    }

    public void setChequePedido(List<ChequePedido> chequePedido) {
        this.chequePedido = chequePedido;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Oficina getOficinaDupg() {
        return oficinaDupg;
    }

    public void setOficinaDupg(Oficina oficinaDupg) {
        this.oficinaDupg = oficinaDupg;
    }

    public List<DistribucionGasto> getDistribucionGasto() {
        return distribucionGasto;
    }

    public void setDistribucionGasto(List<DistribucionGasto> distribucionGasto) {
        this.distribucionGasto = distribucionGasto;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

}
