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

@Entity
@Table(name = "ept_transacc_fracciones", catalog = "croacia")
public class TransaccFraccionesMy implements Serializable {

    
    @EmbeddedId
    protected TransaccFraccionesMyPK transaccFraccionesPK;

    @Column(name = "CTA")
    private String cta;

    @Column(name = "FRACCION")
    private Integer fraccion;

    @Column(name = "MOV")
    private Integer mov;

    @Column(name = "ANUAL")
    private String anual;

    @Column(name = "TRANSACC")
    private Integer transacc;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "GENER_USER")
    private String generUser;

    @Column(name = "GENERA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generaFecha;

    @Column(name = "ANULADO")
    private String anulado;

    @Column(name = "ANULA_USER")
    private String anulaUser;

    @Column(name = "ANULA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anulaFecha;

    @Column(name = "MORA")
    private BigDecimal mora;

    public TransaccFraccionesMy() {
    }

    public TransaccFraccionesMy(TransaccFraccionesMyPK transaccFraccionesMyPK) {
        this.transaccFraccionesPK = transaccFraccionesMyPK;
    }

    public TransaccFraccionesMyPK getTransaccFraccionesPK() {
        return transaccFraccionesPK;
    }

    public void setTransaccFraccionesPK(TransaccFraccionesMyPK transaccFraccionesPK) {
        this.transaccFraccionesPK = transaccFraccionesPK;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public Integer getFraccion() {
        return fraccion;
    }

    public void setFraccion(Integer fraccion) {
        this.fraccion = fraccion;
    }

    public Integer getMov() {
        return mov;
    }

    public void setMov(Integer mov) {
        this.mov = mov;
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public Integer getTransacc() {
        return transacc;
    }

    public void setTransacc(Integer transacc) {
        this.transacc = transacc;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getGenerUser() {
        return generUser;
    }

    public void setGenerUser(String generUser) {
        this.generUser = generUser;
    }

    public Date getGeneraFecha() {
        return generaFecha;
    }

    public void setGeneraFecha(Date generaFecha) {
        this.generaFecha = generaFecha;
    }

    public String getAnulado() {
        return anulado;
    }

    public void setAnulado(String anulado) {
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

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public boolean isAnulado() {
        return BigDecimal.ONE.toString().equals(this.anulado);
    }

}
