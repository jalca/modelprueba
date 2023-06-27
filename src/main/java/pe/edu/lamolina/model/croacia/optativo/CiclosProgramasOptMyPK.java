package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CiclosProgramasOptMyPK implements Serializable {

    @NotNull
    @Column(name = "CICLO")
    private String ciclo;

    @NotNull
    @Column(name = "PRG_CODIGO")
    private String prgCodigo;

    public CiclosProgramasOptMyPK() {
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getPrgCodigo() {
        return prgCodigo;
    }

    public void setPrgCodigo(String prgCodigo) {
        this.prgCodigo = prgCodigo;
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
