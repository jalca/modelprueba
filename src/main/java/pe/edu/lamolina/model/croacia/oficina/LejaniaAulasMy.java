package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ofi_lejania_aulas", catalog = "croacia")
public class LejaniaAulasMy implements Serializable {

    

    @EmbeddedId
    private LejaniaAulasMyPk lejaniaAulasMyPk;

    @Column(name = "TIPO_DISTANCIA")
    private String tipoDistancia;

    @Column(name = "DEP_CODIGO")
    private String depCodigo;

    public LejaniaAulasMy() {
    }

    public LejaniaAulasMy(LejaniaAulasMyPk lejaniaAulasMyPk) {
        this.lejaniaAulasMyPk = lejaniaAulasMyPk;
    }

    public LejaniaAulasMyPk getLejaniaAulasMyPk() {
        return lejaniaAulasMyPk;
    }

    public void setLejaniaAulasMyPk(LejaniaAulasMyPk lejaniaAulasMyPk) {
        this.lejaniaAulasMyPk = lejaniaAulasMyPk;
    }

    public String getTipoDistancia() {
        return tipoDistancia;
    }

    public void setTipoDistancia(String tipoDistancia) {
        this.tipoDistancia = tipoDistancia;
    }

    public String getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(String depCodigo) {
        this.depCodigo = depCodigo;
    }

}
