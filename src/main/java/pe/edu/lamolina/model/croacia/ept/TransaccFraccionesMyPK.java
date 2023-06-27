package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransaccFraccionesMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "ID_NUMERO")
    private Integer idNumero;

    public TransaccFraccionesMyPK() {
    }

    public TransaccFraccionesMyPK(String ciclo, String matricula, int idNumero) {
        this.ciclo = ciclo;
        this.matricula = matricula;
        this.idNumero = idNumero;
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

    public Integer getIdNumero() {
        return idNumero;
    }

    public void setIdNumero(Integer idNumero) {
        this.idNumero = idNumero;
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
