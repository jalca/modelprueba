package pe.edu.lamolina.model.croacia.retiros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RetiroCicloMyPk implements Serializable {

    @Column(name = "ID_RETIRO")
    private String idRetiro;

    @Column(name = "MATRICULA")
    private String matricula;

    public RetiroCicloMyPk() {
    }

    public RetiroCicloMyPk(String idRetiro, String matricula) {
        this.idRetiro = idRetiro;
        this.matricula = matricula;
    }

    public String getIdRetiro() {
        return idRetiro;
    }

    public void setIdRetiro(String idRetiro) {
        this.idRetiro = idRetiro;
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
