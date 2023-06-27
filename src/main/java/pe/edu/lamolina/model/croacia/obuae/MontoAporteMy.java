package pe.edu.lamolina.model.croacia.obuae;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "monto_aporte", catalog = "croacia")
public class MontoAporteMy implements Serializable, Cloneable {

    

    @EmbeddedId
    protected MontoAporteMyPk montoAporteMyPk;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "PAGO")
    private BigDecimal pago;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "AFAVOR")
    private BigDecimal afavor;

    @Column(name = "FECHA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;

    @Column(name = "MODO_PRESTAMO")
    private String modoPrestamo;

    @Column(name = "MONTO_INICIAL")
    private BigDecimal montoInicial;

    @Column(name = "FECHA_GER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGer;

    @Column(name = "USR_GER")
    private String usrGer;

    public MontoAporteMy() {
    }

    public MontoAporteMyPk getMontoAporteMyPk() {
        return montoAporteMyPk;
    }

    public void setMontoAporteMyPk(MontoAporteMyPk montoAporteMyPk) {
        this.montoAporteMyPk = montoAporteMyPk;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getPago() {
        return pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getAfavor() {
        return afavor;
    }

    public void setAfavor(BigDecimal afavor) {
        this.afavor = afavor;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getModoPrestamo() {
        return modoPrestamo;
    }

    public void setModoPrestamo(String modoPrestamo) {
        this.modoPrestamo = modoPrestamo;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Date getFechaGer() {
        return fechaGer;
    }

    public void setFechaGer(Date fechaGer) {
        this.fechaGer = fechaGer;
    }

    public String getUsrGer() {
        return usrGer;
    }

    public void setUsrGer(String usrGer) {
        this.usrGer = usrGer;
    }

}
