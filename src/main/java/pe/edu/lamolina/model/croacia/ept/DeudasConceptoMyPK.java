package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import pe.edu.lamolina.model.enums.croacia.ConceptoDeudaEnum;

@Embeddable
public class DeudasConceptoMyPK implements Serializable {

    @Size(min = 1, max = 5)
    @Column(name = "CICLO")
    private String ciclo;

    @Size(min = 1, max = 8)
    @Column(name = "MATRICULA")
    private String matricula;

    @Size(min = 1, max = 3)
    @Column(name = "CONCEPTO")
    private String concepto;

    @Column(name = "MOV")
    private Integer mov;

    public DeudasConceptoMyPK() {
    }

    public DeudasConceptoMyPK(String ciclo, String matricula, String concepto, Integer mov) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.concepto = concepto;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getMov() {
        return mov;
    }

    public void setMov(Integer mov) {
        this.mov = mov;
    }

    public ConceptoDeudaEnum getConceptoEnum() {
        return ConceptoDeudaEnum.valueOf(this.concepto);
    }

    public boolean isConceptoEnsenanza() {
        return ConceptoDeudaEnum.ENZ == this.getConceptoEnum();
    }

    public boolean isConceptoMatricula() {
        return ConceptoDeudaEnum.MAT == this.getConceptoEnum();
    }

    public boolean isConceptoExtemporaneo() {
        return ConceptoDeudaEnum.XTM == this.getConceptoEnum();
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
