package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "opt_ciclos", catalog = "croacia")
public class CiclosOptMy implements Serializable {

    @Id
    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "TRIMESTRE")
    private String trimestre;

    @Column(name = "SEMESTRE")
    private String sem;

    public CiclosOptMy() {
    }

    public CiclosOptMy(Object id) {
        this.ciclo = TypesUtil.getString(id);
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CiclosOptMy other = (CiclosOptMy) obj;
        if (!Objects.equals(this.ciclo, other.ciclo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

}
