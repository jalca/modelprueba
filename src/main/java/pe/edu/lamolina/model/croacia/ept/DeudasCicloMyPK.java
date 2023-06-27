package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class DeudasCicloMyPK implements Serializable {

    @Size(min = 1, max = 5)
    @Column(name = "CICLO")
    private String ciclo;

    @Size(min = 1, max = 8)
    @Column(name = "MATRICULA")
    private String matricula;

    public DeudasCicloMyPK() {
    }

    public DeudasCicloMyPK(String ciclo, String matricula) {
        this.ciclo = ciclo;
        this.matricula = matricula;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
}
