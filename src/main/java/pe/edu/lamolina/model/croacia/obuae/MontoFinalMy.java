package pe.edu.lamolina.model.croacia.obuae;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monto_final", catalog = "croacia")
public class MontoFinalMy implements Serializable, Cloneable {

    

    @EmbeddedId
    protected MontoFinalMyPk montoFinalMyPk;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "PAGO")
    private BigDecimal pago;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "AFAVOR")
    private BigDecimal afavor;

    @Column(name = "HABIL")
    private String habil;

    public MontoFinalMy() {
    }

    public MontoFinalMyPk getMontoFinalMyPk() {
        return montoFinalMyPk;
    }

    public void setMontoFinalMyPk(MontoFinalMyPk montoFinalMyPk) {
        this.montoFinalMyPk = montoFinalMyPk;
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

    public String getHabil() {
        return habil;
    }

    public void setHabil(String habil) {
        this.habil = habil;
    }

}
