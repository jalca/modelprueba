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
@Table(name = "ept_costos_estudios", catalog = "croacia")
public class CostosEstudiosMy implements Serializable {

    

    @EmbeddedId
    protected CostosEstudiosMyPK costosEstudiosPK;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "INICIAL")
    private BigDecimal inicial;

    @Column(name = "MONTO_FRACCIONAR")
    private BigDecimal montoFraccionar;

    @Column(name = "FECHA_MODIFI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifi;

    @Size(max = 30)
    @Column(name = "USUARIO_MODIFI")
    private String usuarioModifi;

    public CostosEstudiosMy() {
    }

    public CostosEstudiosMy(CostosEstudiosMyPK costosEstudiosPK) {
        this.costosEstudiosPK = costosEstudiosPK;
    }

    public CostosEstudiosMy(String tarifa, String epgCodigo, String nacion, String tcosto) {
        this.costosEstudiosPK = new CostosEstudiosMyPK(tarifa, epgCodigo, nacion, tcosto);
    }

    public CostosEstudiosMyPK getCostosEstudiosPK() {
        return costosEstudiosPK;
    }

    public void setCostosEstudiosPK(CostosEstudiosMyPK costosEstudiosPK) {
        this.costosEstudiosPK = costosEstudiosPK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getInicial() {
        return inicial;
    }

    public void setInicial(BigDecimal inicial) {
        this.inicial = inicial;
    }

    public BigDecimal getMontoFraccionar() {
        return montoFraccionar;
    }

    public void setMontoFraccionar(BigDecimal montoFraccionar) {
        this.montoFraccionar = montoFraccionar;
    }

    public Date getFechaModifi() {
        return fechaModifi;
    }

    public void setFechaModifi(Date fechaModifi) {
        this.fechaModifi = fechaModifi;
    }

    public String getUsuarioModifi() {
        return usuarioModifi;
    }

    public void setUsuarioModifi(String usuarioModifi) {
        this.usuarioModifi = usuarioModifi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costosEstudiosPK != null ? costosEstudiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CostosEstudiosMy)) {
            return false;
        }
        CostosEstudiosMy other = (CostosEstudiosMy) object;
        if ((this.costosEstudiosPK == null && other.costosEstudiosPK != null) || (this.costosEstudiosPK != null && !this.costosEstudiosPK.equals(other.costosEstudiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.ept.CostosEstudios[ costosEstudiosPK=" + costosEstudiosPK + " ]";
    }

}
