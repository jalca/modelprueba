package pe.edu.lamolina.model.croacia.optativo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "opt_cursos", catalog = "croacia")
public class CursosOptMy implements Serializable {

    

    @Id
    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @JoinColumn(name = "PRG_CODIGO", referencedColumnName = "PRG_CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgramasOptMy programa;

    @Column(name = "CUR_NOMBRE")
    private String curNombre;

    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Column(name = "CUR_INGLES")
    private String curIngles;

    @Column(name = "TRIMESTRE")
    private String trimes;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CURSO_LIBRE")
    private String cLibres;

    @Column(name = "HORAS")
    private String horas;

    @Column(name = "CARTA_MOD")
    private String cartaMod;

    @Column(name = "FECHA_CARTA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCarta;

    @Column(name = "USUARIO_CARTA")
    private String usuarioCarta;

    public CursosOptMy() {
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public ProgramasOptMy getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramasOptMy programa) {
        this.programa = programa;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public Integer getCurCredit() {
        return curCredit;
    }

    public void setCurCredit(Integer curCredit) {
        this.curCredit = curCredit;
    }

    public String getTrimes() {
        return trimes;
    }

    public void setTrimes(String trimes) {
        this.trimes = trimes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getcLibres() {
        return cLibres;
    }

    public void setcLibres(String cLibres) {
        this.cLibres = cLibres;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public Date getFechaCarta() {
        return fechaCarta;
    }

    public void setFechaCarta(Date fechaCarta) {
        this.fechaCarta = fechaCarta;
    }

    public String getUsuarioCarta() {
        return usuarioCarta;
    }

    public void setUsuarioCarta(String usuarioCarta) {
        this.usuarioCarta = usuarioCarta;
    }

    public String getCurIngles() {
        return curIngles;
    }

    public void setCurIngles(String curIngles) {
        this.curIngles = curIngles;
    }

    public String getCartaMod() {
        return cartaMod;
    }

    public void setCartaMod(String cartaMod) {
        this.cartaMod = cartaMod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CursosOptMy)) {
            return false;
        }
        CursosOptMy other = (CursosOptMy) object;
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.optativo.CursosOpt[ curCodigo=" + curCodigo + " ]";
    }

}
