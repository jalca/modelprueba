package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransaccEscuelaMyPK implements Serializable {

    @Column(name = "ANUAL")
    private String anual;

    @Column(name = "TRANSACC")
    private Integer transacc;

    public TransaccEscuelaMyPK() {
    }

    public TransaccEscuelaMyPK(String anual, Integer transacc) {
        this.anual = anual;
        this.transacc = transacc;
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public int getTransacc() {
        return transacc;
    }

    public void setTransacc(Integer transacc) {
        this.transacc = transacc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anual != null ? anual.hashCode() : 0);
        hash += (int) transacc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof TransaccEscuelaMyPK)) {
            return false;
        }
        TransaccEscuelaMyPK other = (TransaccEscuelaMyPK) object;
        if ((this.anual == null && other.anual != null) || (this.anual != null && !this.anual.equals(other.anual))) {
            return false;
        }
        if (this.transacc != other.transacc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.ept.TransaccEscuelaPK[ anual=" + anual + ", transacc=" + transacc + " ]";
    }

}
