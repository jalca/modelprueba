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
import javax.validation.constraints.Size;

@Entity
@Table(name = "ept_deudas_concepto", catalog = "croacia")
public class DeudasConceptoMy implements Serializable {

    

    @EmbeddedId
    protected DeudasConceptoMyPK deudasConceptoPK;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "AYUDA")
    private BigDecimal ayuda;

    @Column(name = "INICIAL")
    private BigDecimal inicial;

    @Column(name = "FRACCIONAR")
    private BigDecimal fraccionar;

    @Size(max = 2)
    @Column(name = "CTA")
    private String cta;

    @Size(max = 30)
    @Column(name = "GENERA_USER")
    private String generaUser;

    @Column(name = "GENERA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generaFecha;

    @Column(name = "ANULADO")
    private Integer anulado;

    @Size(max = 30)
    @Column(name = "ANULA_USER")
    private String anulaUser;

    @Column(name = "ANULA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anulaFecha;

    @Column(name = "CANCELADO")
    private Integer cancelado;

    @Size(max = 30)
    @Column(name = "CANCELO_USER")
    private String canceloUser;

    @Column(name = "CANCELO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date canceloFecha;

    @Column(name = "CANCEL_INICIAL")
    private BigDecimal cancelInicial;

    @Column(name = "CANCEL_FRACCION")
    private BigDecimal cancelFraccion;

    public DeudasConceptoMy() {
    }

    public DeudasConceptoMy(DeudasConceptoMyPK deudasConceptoPK) {
        this.deudasConceptoPK = deudasConceptoPK;
    }

    public DeudasConceptoMyPK getDeudasConceptoPK() {
        return deudasConceptoPK;
    }

    public void setDeudasConceptoPK(DeudasConceptoMyPK deudasConceptoPK) {
        this.deudasConceptoPK = deudasConceptoPK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getAyuda() {
        return ayuda;
    }

    public void setAyuda(BigDecimal ayuda) {
        this.ayuda = ayuda;
    }

    public BigDecimal getInicial() {
        return inicial;
    }

    public void setInicial(BigDecimal inicial) {
        this.inicial = inicial;
    }

    public BigDecimal getFraccionar() {
        return fraccionar;
    }

    public void setFraccionar(BigDecimal fraccionar) {
        this.fraccionar = fraccionar;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
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

    public Integer getCancelado() {
        return cancelado;
    }

    public void setCancelado(Integer cancelado) {
        this.cancelado = cancelado;
    }

    public String getCanceloUser() {
        return canceloUser;
    }

    public void setCanceloUser(String canceloUser) {
        this.canceloUser = canceloUser;
    }

    public Date getCanceloFecha() {
        return canceloFecha;
    }

    public void setCanceloFecha(Date canceloFecha) {
        this.canceloFecha = canceloFecha;
    }

    public BigDecimal getCancelInicial() {
        return cancelInicial;
    }

    public void setCancelInicial(BigDecimal cancelInicial) {
        this.cancelInicial = cancelInicial;
    }

    public BigDecimal getCancelFraccion() {
        return cancelFraccion;
    }

    public void setCancelFraccion(BigDecimal cancelFraccion) {
        this.cancelFraccion = cancelFraccion;
    }

}
