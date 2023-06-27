package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class MatriculablesMyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MATRICULA")
    private String matricula;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CICLO")
    private String ciclo;

    public MatriculablesMyPK() {
    }

    public MatriculablesMyPK(String matricula, String ciclo) {
        this.matricula = matricula;
        this.ciclo = ciclo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof MatriculablesMyPK)) {
            return false;
        }
        MatriculablesMyPK other = (MatriculablesMyPK) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

}
