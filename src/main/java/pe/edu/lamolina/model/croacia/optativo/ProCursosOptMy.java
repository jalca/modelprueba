package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "opt_pro_cursos", catalog = "croacia")
public class ProCursosOptMy implements Serializable {

    

    @EmbeddedId
    protected ProCursosOptMyPK profeHistoOptPK;

    @Column(name = "PRG_CODIGO")
    private String prgCodigo;

    @Column(name = "PRO_CODIGO")
    private String proCodigo;

    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @Column(name = "ENCU_PROM")
    private Integer encuProm;

    @Column(name = "TPROFE")
    private String tprofe;

    public ProCursosOptMy() {
    }

    public String getKey() {
        return this.profeHistoOptPK.getCiclo() + "-" + this.prgCodigo + "-" + this.curCodigo;
    }

    public ProCursosOptMyPK getProfeHistoOptPK() {
        return profeHistoOptPK;
    }

    public void setProfeHistoOptPK(ProCursosOptMyPK profeHistoOptPK) {
        this.profeHistoOptPK = profeHistoOptPK;
    }

    public String getPrgCodigo() {
        return prgCodigo;
    }

    public void setPrgCodigo(String prgCodigo) {
        this.prgCodigo = prgCodigo;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public Integer getEncuProm() {
        return encuProm;
    }

    public void setEncuProm(Integer encuProm) {
        this.encuProm = encuProm;
    }

    public String getTprofe() {
        return tprofe;
    }

    public void setTprofe(String tprofe) {
        this.tprofe = tprofe;
    }

}
