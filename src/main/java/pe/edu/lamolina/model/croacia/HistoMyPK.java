package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class HistoMyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CICLO")
    private String ciclo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MATRICULA")
    private String matricula;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MOV")
    private String mov;

    public HistoMyPK() {
    }

    public HistoMyPK(String ciclo, String matricula, String mov, String curCodigo) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.mov = mov;
        this.curCodigo = curCodigo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof HistoMyPK)) {
            return false;
        }
        HistoMyPK other = (HistoMyPK) object;
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        if ((this.mov == null && other.mov != null) || (this.mov != null && !this.mov.equals(other.mov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.oficina.academico.HistoPK[ ciclo=" + ciclo + ", matricula=" + matricula + ", curCodigo=" + curCodigo + ", mov=" + mov + " ]";
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

}
