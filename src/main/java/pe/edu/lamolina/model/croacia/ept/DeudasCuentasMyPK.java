package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DeudasCuentasMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "CTA")
    private String cta;

    public DeudasCuentasMyPK() {
    }

    public DeudasCuentasMyPK(String ciclo, String matricula, String cta) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.cta = cta;
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

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
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
