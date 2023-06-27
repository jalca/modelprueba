package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import pe.edu.lamolina.model.enums.croacia.FraccionEstadoEnum;

@Entity
@Table(name = "ept_fraccionado", catalog = "croacia")
public class FraccionadoMy implements Serializable {

    

    @EmbeddedId
    protected FraccionadoMyPK fraccionadoPK;

    @Column(name = "MONTO_BASE")
    private BigDecimal montoBase;

    @Column(name = "MONTO_FRACC")
    private BigDecimal montoFracc;

    @Column(name = "AYUDA")
    private BigDecimal ayuda;

    @Column(name = "MONTO_PAGAR")
    private BigDecimal montoPagar;

    @Column(name = "CANCELADO")
    private BigDecimal cancelado;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    //CAN, DEU, PAR
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "GENERA_USER")
    private String generaUser;

    @Column(name = "GENERA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generaFecha;

    @Column(name = "ANULADO")
    private Integer anulado;

    @Column(name = "ANULA_USER")
    private String anulaUser;

    @Column(name = "ANULA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anulaFecha;

    @Column(name = "FECHA_VCMTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVcmto;

    @Column(name = "BLOQUEAR")
    private Integer bloquear;

    @Column(name = "MORA")
    private BigDecimal mora;

//    @JoinColumns({
//        @JoinColumn(name = "CICLO", referencedColumnName = "CICLO", insertable = false, updatable = false),
//        @JoinColumn(name = "MATRICULA", referencedColumnName = "MATRICULA", insertable = false, updatable = false),
//        @JoinColumn(name = "CTA", referencedColumnName = "CTA", insertable = false, updatable = false)})
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Transient
    private DeudasCuentasMy deudasCuentas;

    public FraccionadoMy() {
    }

    public FraccionadoMy(FraccionadoMyPK fraccionadoPK) {
        this.fraccionadoPK = fraccionadoPK;
    }

    public FraccionadoMyPK getFraccionadoPK() {
        return fraccionadoPK;
    }

    public void setFraccionadoPK(FraccionadoMyPK fraccionadoPK) {
        this.fraccionadoPK = fraccionadoPK;
    }

    public BigDecimal getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(BigDecimal montoBase) {
        this.montoBase = montoBase;
    }

    public BigDecimal getMontoFracc() {
        return montoFracc;
    }

    public void setMontoFracc(BigDecimal montoFracc) {
        this.montoFracc = montoFracc;
    }

    public BigDecimal getAyuda() {
        return ayuda;
    }

    public void setAyuda(BigDecimal ayuda) {
        this.ayuda = ayuda;
    }

    public BigDecimal getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(BigDecimal montoPagar) {
        this.montoPagar = montoPagar;
    }

    public BigDecimal getCancelado() {
        return cancelado;
    }

    public void setCancelado(BigDecimal cancelado) {
        this.cancelado = cancelado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public FraccionEstadoEnum getEstadoEnum() {
        return FraccionEstadoEnum.valueOf(this.estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGeneraUser() {
        return generaUser;
    }

    public void setGeneraUser(String generaUser) {
        this.generaUser = generaUser;
    }

    public Date getGeneraFecha() {
        return generaFecha;
    }

    public void setGeneraFecha(Date generaFecha) {
        this.generaFecha = generaFecha;
    }

    public Integer getAnulado() {
        return anulado;
    }

    public void setAnulado(Integer anulado) {
        this.anulado = anulado;
    }

    public String getAnulaUser() {
        return anulaUser;
    }

    public void setAnulaUser(String anulaUser) {
        this.anulaUser = anulaUser;
    }

    public Date getAnulaFecha() {
        return anulaFecha;
    }

    public void setAnulaFecha(Date anulaFecha) {
        this.anulaFecha = anulaFecha;
    }

    public Date getFechaVcmto() {
        return fechaVcmto;
    }

    public void setFechaVcmto(Date fechaVcmto) {
        this.fechaVcmto = fechaVcmto;
    }

    public Integer getBloquear() {
        return bloquear;
    }

    public void setBloquear(Integer bloquear) {
        this.bloquear = bloquear;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public DeudasCuentasMy getDeudasCuentas() {
        return deudasCuentas;
    }

    public void setDeudasCuentas(DeudasCuentasMy deudasCuentas) {
        this.deudasCuentas = deudasCuentas;
    }

}
