package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "opt_profe_histo", catalog = "croacia")
public class ProfeHistoOptMy implements Serializable {

    

    @EmbeddedId
    protected ProfeHistoOptMyPK profeHistoOptPK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRO_CODIGO", insertable = false, updatable = false)
    private ProfesoresOptMy profesoresOpt;

    public ProfeHistoOptMy() {
    }

    public ProfeHistoOptMy(ProfeHistoOptMyPK profeHistoOptPK) {
        this.profeHistoOptPK = profeHistoOptPK;
    }

    public ProfeHistoOptMy(String ciclo, String proCodigo) {
        this.profeHistoOptPK = new ProfeHistoOptMyPK(ciclo, proCodigo);
    }

    public ProfeHistoOptMyPK getProfeHistoOptPK() {
        return profeHistoOptPK;
    }

    public void setProfeHistoOptPK(ProfeHistoOptMyPK profeHistoOptPK) {
        this.profeHistoOptPK = profeHistoOptPK;
    }

    public ProfesoresOptMy getProfesoresOpt() {
        return profesoresOpt;
    }

    public void setProfesoresOpt(ProfesoresOptMy profesoresOpt) {
        this.profesoresOpt = profesoresOpt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profeHistoOptPK != null ? profeHistoOptPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ProfeHistoOptMy)) {
            return false;
        }
        ProfeHistoOptMy other = (ProfeHistoOptMy) object;
        if ((this.profeHistoOptPK == null && other.profeHistoOptPK != null) || (this.profeHistoOptPK != null && !this.profeHistoOptPK.equals(other.profeHistoOptPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.optativo.ProfeHistoOpt[ profeHistoOptPK=" + profeHistoOptPK + " ]";
    }

}
