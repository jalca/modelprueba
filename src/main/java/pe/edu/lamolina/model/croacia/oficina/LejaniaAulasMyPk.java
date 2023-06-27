package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LejaniaAulasMyPk implements Serializable {

    @Column(name = "MODULO")
    private String modulo;

    @Column(name = "FAC_CODIGO")
    private String facCodigo;

    public LejaniaAulasMyPk() {
    }

    public LejaniaAulasMyPk(String modulo, String facCodigo) {
        this.modulo = modulo;
        this.facCodigo = facCodigo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    @Override
    public String toString() {
        return "LejaniaAulasMyPk{" + "modulo=" + modulo + ", facCodigo=" + facCodigo + '}';
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
