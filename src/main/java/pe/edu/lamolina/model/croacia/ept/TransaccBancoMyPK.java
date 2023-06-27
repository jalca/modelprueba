package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransaccBancoMyPK implements Serializable {

    @Column(name = "ANUAL")
    private String anual;

    @Column(name = "TRANSACC")
    private Long transacc;

    public TransaccBancoMyPK() {
    }

    public TransaccBancoMyPK(String anual, Long transacc) {
        this.anual = anual;
        this.transacc = transacc;
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public Long getTransacc() {
        return transacc;
    }

    public void setTransacc(Long transacc) {
        this.transacc = transacc;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof TransaccBancoMyPK)) {
            return false;
        }
        TransaccBancoMyPK other = (TransaccBancoMyPK) object;
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
        return "pe.edu.lamolina.model.croacia.ept.TransaccBancoPK[ anual=" + anual + ", transacc=" + transacc + " ]";
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

}
