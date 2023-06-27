package pe.edu.lamolina.model.tramite;

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
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_deuda_tramite")
public class DeudaTramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_descuento")
    private String motivoDescuento;

    @Column(name = "monto")
    BigDecimal monto;

    @Column(name = "monto_inicial")
    BigDecimal montoInicial;

    @Column(name = "descuento")
    BigDecimal descuento;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "fecha_emision")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVencimiento;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAbono;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_descuento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDescuento;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_tramite")
    private ConceptoTramite conceptoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_descuento")
    private Usuario userDescuento;

    @Transient
    private CuentaBancaria cuentaBancaria;

    public DeudaTramite() {
        this.descuento = BigDecimal.ZERO;
    }

    public DeudaTramite(BigDecimal monto, ConceptoTramite conceptoTramite, Tramite tramite, Date fechaVencimiento, Usuario usuario) {
        this.descuento = BigDecimal.ZERO;
        this.abono = BigDecimal.ZERO;
        this.conceptoTramite = conceptoTramite;
        this.estado = DeudaEstadoEnum.DEU.name();
        this.fechaEmision = new Date();
        this.fechaRegistro = new Date();
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.montoInicial = monto;
        this.tramite = tramite;
        this.userRegistro = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public ConceptoTramite getConceptoTramite() {
        return conceptoTramite;
    }

    public void setConceptoTramite(ConceptoTramite conceptoTramite) {
        this.conceptoTramite = conceptoTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
        if (this.id == null) {
            this.montoInicial = monto;
        }
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public BigDecimal getSaldo() {
        return monto.subtract(abono);
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
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

    public String getMotivoDescuento() {
        return motivoDescuento;
    }

    public void setMotivoDescuento(String motivoDescuento) {
        this.motivoDescuento = motivoDescuento;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Date getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(Date fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public Usuario getUserDescuento() {
        return userDescuento;
    }

    public void setUserDescuento(Usuario userDescuento) {
        this.userDescuento = userDescuento;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

}
