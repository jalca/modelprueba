package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "opt_cursos_ciclos", catalog = "croacia")
public class CursoCicloOptMy implements Serializable {

    

    @EmbeddedId
    protected CursoCicloOptMyPK cursoCicloOptMyPK;

    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Column(name = "HORAS")
    private Integer horas;

    public CursoCicloOptMy() {
    }

    public CursoCicloOptMy(CursoCicloOptMyPK cursoCicloOptMyPK) {
        this.cursoCicloOptMyPK = cursoCicloOptMyPK;
    }

    public CursoCicloOptMyPK getCursoCicloOptMyPK() {
        return cursoCicloOptMyPK;
    }

    public void setCursoCicloOptMyPK(CursoCicloOptMyPK cursoCicloOptMyPK) {
        this.cursoCicloOptMyPK = cursoCicloOptMyPK;
    }

    public Integer getCurCredit() {
        return curCredit;
    }

    public void setCurCredit(Integer curCredit) {
        this.curCredit = curCredit;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoCicloOptMyPK != null ? cursoCicloOptMyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CursoCicloOptMy)) {
            return false;
        }
        CursoCicloOptMy other = (CursoCicloOptMy) object;
        if ((this.cursoCicloOptMyPK == null && other.cursoCicloOptMyPK != null) || (this.cursoCicloOptMyPK != null && !this.cursoCicloOptMyPK.equals(other.cursoCicloOptMyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.optativo.CursoCicloOpt[ cursoCicloOptPK=" + cursoCicloOptMyPK + " ]";
    }

}
