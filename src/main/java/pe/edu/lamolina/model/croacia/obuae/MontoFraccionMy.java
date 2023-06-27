package pe.edu.lamolina.model.croacia.obuae;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "monto_fraccion", catalog = "croacia")
public class MontoFraccionMy implements Serializable, Cloneable {

    @EmbeddedId
    protected MontoFraccionMyPk montoFraccionMyPk;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "PAGO")
    private BigDecimal pago;

    @Column(name = "FECHA_PAGAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagar;

    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;

    @Column(name = "VOUCHER")
    private String voucher;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "FECHA_HABIL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHabil;

    @Column(name = "CTA")
    private String cta;

    @Column(name = "TRANSACC_BCO")
    private Long transaccBco;

    @Column(name = "EPG_ANUAL")
    private String epgAnual;

    @Column(name = "EPG_TRANSACC")
    private Long epgTransacc;

    @Column(name = "CTA_BANCO")
    private Long ctaBanco;

    public MontoFraccionMy() {
    }

    public MontoFraccionMyPk getMontoFraccionMyPk() {
        return montoFraccionMyPk;
    }

    public void setMontoFraccionMyPk(MontoFraccionMyPk montoFraccionMyPk) {
        this.montoFraccionMyPk = montoFraccionMyPk;
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

    public Date getFechaPagar() {
        return fechaPagar;
    }

    public void setFechaPagar(Date fechaPagar) {
        this.fechaPagar = fechaPagar;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaHabil() {
        return fechaHabil;
    }

    public void setFechaHabil(Date fechaHabil) {
        this.fechaHabil = fechaHabil;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getEpgAnual() {
        return epgAnual;
    }

    public void setEpgAnual(String epgAnual) {
        this.epgAnual = epgAnual;
    }

    public Long getTransaccBco() {
        return transaccBco;
    }

    public void setTransaccBco(Long transaccBco) {
        this.transaccBco = transaccBco;
    }

    public Long getEpgTransacc() {
        return epgTransacc;
    }

    public void setEpgTransacc(Long epgTransacc) {
        this.epgTransacc = epgTransacc;
    }

    public Long getCtaBanco() {
        return ctaBanco;
    }

    public void setCtaBanco(Long ctaBanco) {
        this.ctaBanco = ctaBanco;
    }

    public static class CompareFraccion implements Comparator<MontoFraccionMy> {

        @Override
        public int compare(MontoFraccionMy mf1, MontoFraccionMy mf2) {
            return mf1.getMontoFraccionMyPk().getFraccion().compareTo(mf2.getMontoFraccionMyPk().getFraccion());
        }
    }

}
