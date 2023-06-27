package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProfeHistoOptMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "PRO_CODIGO")
    private String proCodigo;

    public ProfeHistoOptMyPK() {
    }

    public ProfeHistoOptMyPK(String ciclo, String proCodigo) {
        this.ciclo = ciclo;
        this.proCodigo = proCodigo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ProfeHistoOptMyPK)) {
            return false;
        }
        ProfeHistoOptMyPK other = (ProfeHistoOptMyPK) object;
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.optativo.ProfeHistoOptPK[ ciclo=" + ciclo + ", proCodigo=" + proCodigo + " ]";
    }
}
