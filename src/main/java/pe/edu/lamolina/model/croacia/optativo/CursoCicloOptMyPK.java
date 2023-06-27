package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CursoCicloOptMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @Column(name = "PRG_CODIGO")
    private String prgCodigo;

    public CursoCicloOptMyPK() {
    }

    public CursoCicloOptMyPK(String ciclo, String curCodigo, String prgCodigo) {
        this.ciclo = ciclo;
        this.curCodigo = curCodigo;
        this.prgCodigo = prgCodigo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getPrgCodigo() {
        return prgCodigo;
    }

    public void setPrgCodigo(String prgCodigo) {
        this.prgCodigo = prgCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        hash += (prgCodigo != null ? prgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CursoCicloOptMyPK)) {
            return false;
        }
        CursoCicloOptMyPK other = (CursoCicloOptMyPK) object;
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        if ((this.prgCodigo == null && other.prgCodigo != null) || (this.prgCodigo != null && !this.prgCodigo.equals(other.prgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.optativo.CursoCicloOptPK[ ciclo=" + ciclo + ", curCodigo=" + curCodigo + ", prgCodigo=" + prgCodigo + " ]";
    }

}
