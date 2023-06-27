package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CursosCicloOfiMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    public CursosCicloOfiMyPK() {
    }

    public CursosCicloOfiMyPK(String ciclo, String curCodigo) {
        this.ciclo = ciclo;
        this.curCodigo = curCodigo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CursosCicloOfiMyPK)) {
            return false;
        }
        CursosCicloOfiMyPK other = (CursosCicloOfiMyPK) object;
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.oficina.CursosCicloOficinaMyPK[ ciclo=" + ciclo + ", curCodigo=" + curCodigo + " ]";
    }

}
