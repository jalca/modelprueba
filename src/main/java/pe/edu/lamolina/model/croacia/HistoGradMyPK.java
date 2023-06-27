package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class HistoGradMyPK implements Serializable {

    @NotNull
    @Column(name = "CICLO")
    private String ciclo;

    @NotNull
    @Column(name = "MATRICULA")
    private String matricula;

    @NotNull
    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @NotNull
    @Column(name = "MOV")
    private String mov;

    public HistoGradMyPK() {
    }

    public HistoGradMyPK(String ciclo, String matricula, String mov, String curCodigo) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.curCodigo = curCodigo;
        this.mov = mov;
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
    public int hashCode() {
        int hash = 0;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        hash += (matricula != null ? matricula.hashCode() : 0);
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        hash += (mov != null ? mov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof HistoGradMyPK)) {
            return false;
        }
        HistoGradMyPK other = (HistoGradMyPK) object;
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
        return "pe.albatross.unalmconnector.model.oficina.academico.HistoGradPK[ ciclo=" + ciclo + ", matricula=" + matricula + ", curCodigo=" + curCodigo + ", mov=" + mov + " ]";
    }

}
