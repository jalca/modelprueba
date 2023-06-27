package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarifasMyPk implements Serializable {

    @Column(name = "TARIFA")
    private String tarifa;

    @Column(name = "EPG_CODIGO")
    private String epgCodigo;

    public TarifasMyPk() {
    }

    public TarifasMyPk(String tarifa, String espCodigo) {
        this.tarifa = tarifa;
        this.epgCodigo = espCodigo;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getEpgCodigo() {
        return epgCodigo;
    }

    public void setEpgCodigo(String epgCodigo) {
        this.epgCodigo = epgCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "TarifasMyPk{" + "tarifa=" + tarifa + ", epgCodigo=" + epgCodigo + '}';
    }

}
