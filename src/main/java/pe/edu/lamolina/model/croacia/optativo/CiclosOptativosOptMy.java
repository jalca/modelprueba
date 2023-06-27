package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "opt_ciclos_optativos", catalog = "croacia")
public class CiclosOptativosOptMy implements Serializable {

    @Id
    @Column(name = "CICLO_OPTA")
    private String cicloOpta;

    @Column(name = "NUMERO")
    private Integer numero;

    public CiclosOptativosOptMy() {
    }

    public CiclosOptativosOptMy(Object id) {
        this.cicloOpta = TypesUtil.getString(id);
    }

    public String getCicloOpta() {
        return cicloOpta;
    }

    public void setCicloOpta(String cicloOpta) {
        this.cicloOpta = cicloOpta;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
