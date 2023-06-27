package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "opt_profesores", catalog = "croacia")
public class ProfesoresOptMy implements Serializable {

    

    @Id
    @Column(name = "PRO_CODIGO")
    private String proCodigo;

    @Column(name = "PRO_NOMBRE")
    private String proNombre;

    @Column(name = "PATERNO")
    private String paterno;

    @Column(name = "MATERNO")
    private String materno;

    @Column(name = "NOMBRES")
    private String nombres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesoresOpt", fetch = FetchType.LAZY)
    private List<ProfeHistoOptMy> profesHistosOpt;

    public ProfesoresOptMy() {
    }

    public ProfesoresOptMy(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public List<ProfeHistoOptMy> getProfesHistosOpt() {
        return profesHistosOpt;
    }

    public void setProfesHistosOpt(List<ProfeHistoOptMy> profesHistosOpt) {
        this.profesHistosOpt = profesHistosOpt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ProfesoresOptMy)) {
            return false;
        }
        ProfesoresOptMy other = (ProfesoresOptMy) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.optativo.ProfesoresOpt[ proCodigo=" + proCodigo + " ]";
    }

}
