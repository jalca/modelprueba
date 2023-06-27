package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "opt_ciclos_programas", catalog = "croacia")
public class CiclosProgramasOptMy implements Serializable {

    @EmbeddedId
    CiclosProgramasOptMyPK ciclosProgramasOptMyPK;

    @Column(name = "SEMESTRE")
    private String semestre;

    @Column(name = "TRIMESTRE")
    private String trimestre;

    public CiclosProgramasOptMy() {
    }

    public CiclosProgramasOptMyPK getCiclosProgramasOptMyPK() {
        return ciclosProgramasOptMyPK;
    }

    public void setCiclosProgramasOptMyPK(CiclosProgramasOptMyPK ciclosProgramasOptMyPK) {
        this.ciclosProgramasOptMyPK = ciclosProgramasOptMyPK;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

}
