package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "opt_programas", catalog = "croacia")
public class ProgramasOptMy implements Serializable {

    

    @Id
    @NotNull
    @Column(name = "PRG_CODIGO")
    private String prgCodigo;

    @Column(name = "PRG_NOMBRE")
    private String prgNombre;

    @Column(name = "PRG_COMPLETO")
    private String prgCompleto;

    @Column(name = "PRG_INGLES")
    private String prgIngles;

    @Column(name = "P_COORDINADOR")
    private String pCoordinador;

    @Column(name = "P_VICERECTOR")
    private String pVicerector;

    @Column(name = "P_JEFE_OAE")
    private String PJefeOae;

    public ProgramasOptMy() {
    }

    public ProgramasOptMy(String prgCodigo) {
        this.prgCodigo = prgCodigo;
    }

    public String getPrgCodigo() {
        return prgCodigo;
    }

    public void setPrgCodigo(String prgCodigo) {
        this.prgCodigo = prgCodigo;
    }

    public String getPrgNombre() {
        return prgNombre;
    }

    public void setPrgNombre(String prgNombre) {
        this.prgNombre = prgNombre;
    }

    public String getPrgCompleto() {
        return prgCompleto;
    }

    public void setPrgCompleto(String prgCompleto) {
        this.prgCompleto = prgCompleto;
    }

    public String getPrgIngles() {
        return prgIngles;
    }

    public void setPrgIngles(String prgIngles) {
        this.prgIngles = prgIngles;
    }

    public String getpCoordinador() {
        return pCoordinador;
    }

    public void setpCoordinador(String pCoordinador) {
        this.pCoordinador = pCoordinador;
    }

    public String getpVicerector() {
        return pVicerector;
    }

    public void setpVicerector(String pVicerector) {
        this.pVicerector = pVicerector;
    }

    public String getPJefeOae() {
        return PJefeOae;
    }

    public void setPJefeOae(String PJefeOae) {
        this.PJefeOae = PJefeOae;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgramasOptMy other = (ProgramasOptMy) obj;
        if (!Objects.equals(this.prgCodigo, other.prgCodigo)) {
            return false;
        }
        return true;
    }

}
