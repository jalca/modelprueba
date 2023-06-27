package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FraccionadoMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "CTA")
    private String cta;

    @Column(name = "FRACCION")
    private Integer fraccion;

    @Column(name = "MOV")
    private Integer mov;

    public FraccionadoMyPK() {
    }

    public FraccionadoMyPK(String ciclo, String matricula, String cta, Integer fraccion, Integer mov) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.cta = cta;
        this.fraccion = fraccion;
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

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public Integer getFraccion() {
        return fraccion;
    }

    public void setFraccion(Integer fraccion) {
        this.fraccion = fraccion;
    }

    public Integer getMov() {
        return mov;
    }

    public void setMov(Integer mov) {
        this.mov = mov;
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
