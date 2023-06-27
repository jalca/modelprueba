package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProCursosOptMyPK implements Serializable {

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "ID_PROCURSO")
    private String idProCurso;

    public ProCursosOptMyPK() {
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getIdProCurso() {
        return idProCurso;
    }

    public void setIdProCurso(String idProCurso) {
        this.idProCurso = idProCurso;
    }

    @Override
    public String toString() {
        return "ProCursosOptMyPK{" + "ciclo=" + ciclo + ", idProCurso=" + idProCurso + '}';
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
