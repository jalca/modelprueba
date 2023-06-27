package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ofi_ciclos", catalog = "croacia")
public class OfiCiclosMy implements Serializable {

    

    @Id
    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "ACTIVO")
    private Integer activo;

    @Column(name = "ENC_REP")
    private String encRep;

    @Column(name = "ENC_WEB")
    private String encWeb;

    @Column(name = "ORD")
    private Integer ord;

    @Column(name = "SEM")
    private String sem;

    @Column(name = "LETRAS")
    private String letras;

    @Column(name = "RCA")
    private String rca;

    @Column(name = "PROGRAM")
    private String program;

    @Column(name = "FECHA_PAGO")
    private String fechaPago;

    @Column(name = "INGLES")
    private String ingles;

    @Column(name = "ACONSEJAR")
    private String aconsejar;

    @Column(name = "EPG_ACTIVO")
    private String epgActivo;

    @Column(name = "ANUAL")
    private Integer anual;

    public OfiCiclosMy() {
    }

    public OfiCiclosMy(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getEncRep() {
        return encRep;
    }

    public void setEncRep(String encRep) {
        this.encRep = encRep;
    }

    public String getEncWeb() {
        return encWeb;
    }

    public void setEncWeb(String encWeb) {
        this.encWeb = encWeb;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getAconsejar() {
        return aconsejar;
    }

    public void setAconsejar(String aconsejar) {
        this.aconsejar = aconsejar;
    }

    public String getEpgActivo() {
        return epgActivo;
    }

    public void setEpgActivo(String epgActivo) {
        this.epgActivo = epgActivo;
    }

    public Integer getAnual() {
        return anual;
    }

    public void setAnual(Integer anual) {
        this.anual = anual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OfiCiclosMy)) {
            return false;
        }
        OfiCiclosMy other = (OfiCiclosMy) object;
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.oficina.OfiCiclos[ ciclo=" + ciclo + " ]";
    }

}
