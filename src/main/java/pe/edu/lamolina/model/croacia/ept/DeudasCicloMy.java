package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ept_deudas_ciclo", catalog = "croacia")
public class DeudasCicloMy implements Serializable {

    

    @EmbeddedId
    protected DeudasCicloMyPK deudasCicloPK;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "AYUDA")
    private BigDecimal ayuda;

    @Column(name = "INICIAL")
    private BigDecimal inicial;

    @Column(name = "FRACCIONAR")
    private BigDecimal fraccionar;

    @Column(name = "CANCELADO")
    private BigDecimal cancelado;

    public DeudasCicloMy() {
    }

    public DeudasCicloMy(DeudasCicloMyPK deudasCicloPK) {
        this.deudasCicloPK = deudasCicloPK;
    }

    public DeudasCicloMyPK getDeudasCicloPK() {
        return deudasCicloPK;
    }

    public void setDeudasCicloPK(DeudasCicloMyPK deudasCicloPK) {
        this.deudasCicloPK = deudasCicloPK;
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

    public BigDecimal getCancelado() {
        return cancelado;
    }

    public void setCancelado(BigDecimal cancelado) {
        this.cancelado = cancelado;
    }

}
