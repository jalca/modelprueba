package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CostosEstudiosMyPK implements Serializable {

    @Column(name = "TARIFA")
    private String tarifa;

    @Column(name = "EPG_CODIGO")
    private String epgCodigo;

    @Column(name = "NACION")
    private String nacion;

    @Column(name = "TCOSTO")
    private String tcosto;

    public CostosEstudiosMyPK() {
    }

    public CostosEstudiosMyPK(String tarifa, String epgCodigo, String nacion, String tcosto) {
        this.tarifa = tarifa;
        this.epgCodigo = epgCodigo;
        this.nacion = nacion;
        this.tcosto = tcosto;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getEpgCodigo() {
        return epgCodigo;
    }

    public void setEpgCodigo(String epgCodigo) {
        this.epgCodigo = epgCodigo;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getTcosto() {
        return tcosto;
    }

    public void setTcosto(String tcosto) {
        this.tcosto = tcosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarifa != null ? tarifa.hashCode() : 0);
        hash += (epgCodigo != null ? epgCodigo.hashCode() : 0);
        hash += (nacion != null ? nacion.hashCode() : 0);
        hash += (tcosto != null ? tcosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CostosEstudiosMyPK)) {
            return false;
        }
        CostosEstudiosMyPK other = (CostosEstudiosMyPK) object;
        if ((this.tarifa == null && other.tarifa != null) || (this.tarifa != null && !this.tarifa.equals(other.tarifa))) {
            return false;
        }
        if ((this.epgCodigo == null && other.epgCodigo != null) || (this.epgCodigo != null && !this.epgCodigo.equals(other.epgCodigo))) {
            return false;
        }
        if ((this.nacion == null && other.nacion != null) || (this.nacion != null && !this.nacion.equals(other.nacion))) {
            return false;
        }
        if ((this.tcosto == null && other.tcosto != null) || (this.tcosto != null && !this.tcosto.equals(other.tcosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.ept.CostosEstudiosPK[ tarifa=" + tarifa + ", epgCodigo=" + epgCodigo + ", nacion=" + nacion + ", tcosto=" + tcosto + " ]";
    }

}
