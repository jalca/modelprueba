package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "prom_ciclos", catalog = "croacia")
public class PromCiclosMy implements Serializable {

    

    @EmbeddedId
    protected PromCiclosMyPK promCiclosPK;

    @Column(name = "FAC_CODIGO")
    private String facCodigo;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "SITUACION")
    private String situacion;

    @Column(name = "CCS")
    private Integer ccs;

    @Column(name = "CAPS")
    private Integer caps;

    @Column(name = "PS")
    private Integer ps;

    @Column(name = "PPS")
    private BigDecimal pps;

    @Column(name = "CCA")
    private Integer cca;

    @Column(name = "CAPA")
    private Integer capa;

    @Column(name = "PA")
    private Integer pa;

    @Column(name = "PPA")
    private BigDecimal ppa;

    @Column(name = "PPG")
    private BigDecimal ppg;

    @Column(name = "CONVALID")
    private Integer convalid;

    @Column(name = "NIVEL")
    private Integer nivel;

    @Column(name = "ESP_MER")
    private Integer espMer;

    @Column(name = "FAC_MER")
    private Integer facMer;

    @Column(name = "ESP_QUIN")
    private Short espQuin;

    @Column(name = "FAC_QUIN")
    private Integer facQuin;

    @Column(name = "ESP_TERC")
    private Integer espTerc;

    @Column(name = "FAC_TERC")
    private Integer facTerc;

    @Column(name = "ESP_HONOR")
    private Integer espHonor;

    @Column(name = "FAC_HONOR")
    private Integer facHonor;

    @Column(name = "EFI")
    private BigDecimal efi;

    @Size(max = 3)
    @Column(name = "ESP_GRAD")
    private String espGrad;

    @Size(max = 1)
    @Column(name = "OK")
    private String ok;

    @Column(name = "EPG_MERITO")
    private Integer epgMerito;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TRIKA")
    private String trika;

    @Column(name = "IND_GHOST")
    private Boolean indGhost;

    @Column(name = "FE_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feModificacion;

    @Transient
    private List<HistoMy> historial;

    @Transient
    private List<HistoGradMy> historialGrad;

    public PromCiclosMy() {
    }

    public PromCiclosMy(PromCiclosMyPK promCiclosPK) {
        this.promCiclosPK = promCiclosPK;
    }

    public PromCiclosMyPK getPromCiclosPK() {
        return promCiclosPK;
    }

    public void setPromCiclosPK(PromCiclosMyPK promCiclosPK) {
        this.promCiclosPK = promCiclosPK;
    }

    public Integer getCcs() {
        return ccs;
    }

    public void setCcs(Integer ccs) {
        this.ccs = ccs;
    }

    public Integer getCaps() {
        return caps;
    }

    public void setCaps(Integer caps) {
        this.caps = caps;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public BigDecimal getPps() {
        return pps;
    }

    public void setPps(BigDecimal pps) {
        this.pps = pps;
    }

    public Integer getCca() {
        return cca;
    }

    public void setCca(Integer cca) {
        this.cca = cca;
    }

    public Integer getCapa() {
        return capa;
    }

    public void setCapa(Integer capa) {
        this.capa = capa;
    }

    public Integer getPa() {
        return pa;
    }

    public void setPa(Integer pa) {
        this.pa = pa;
    }

    public BigDecimal getPpa() {
        return ppa;
    }

    public void setPpa(BigDecimal ppa) {
        this.ppa = ppa;
    }

    public BigDecimal getPpg() {
        return ppg;
    }

    public void setPpg(BigDecimal ppg) {
        this.ppg = ppg;
    }

    public Integer getConvalid() {
        return convalid;
    }

    public void setConvalid(Integer convalid) {
        this.convalid = convalid;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getEspMer() {
        return espMer;
    }

    public void setEspMer(Integer espMer) {
        this.espMer = espMer;
    }

    public Integer getFacMer() {
        return facMer;
    }

    public void setFacMer(Integer facMer) {
        this.facMer = facMer;
    }

    public Short getEspQuin() {
        return espQuin;
    }

    public void setEspQuin(Short espQuin) {
        this.espQuin = espQuin;
    }

    public Integer getFacQuin() {
        return facQuin;
    }

    public void setFacQuin(Integer facQuin) {
        this.facQuin = facQuin;
    }

    public Integer getEspTerc() {
        return espTerc;
    }

    public void setEspTerc(Integer espTerc) {
        this.espTerc = espTerc;
    }

    public Integer getFacTerc() {
        return facTerc;
    }

    public void setFacTerc(Integer facTerc) {
        this.facTerc = facTerc;
    }

    public Integer getEspHonor() {
        return espHonor;
    }

    public void setEspHonor(Integer espHonor) {
        this.espHonor = espHonor;
    }

    public Integer getFacHonor() {
        return facHonor;
    }

    public void setFacHonor(Integer facHonor) {
        this.facHonor = facHonor;
    }

    public BigDecimal getEfi() {
        return efi;
    }

    public void setEfi(BigDecimal efi) {
        this.efi = efi;
    }

    public String getEspGrad() {
        return espGrad;
    }

    public void setEspGrad(String espGrad) {
        this.espGrad = espGrad;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Integer getEpgMerito() {
        return epgMerito;
    }

    public void setEpgMerito(Integer epgMerito) {
        this.epgMerito = epgMerito;
    }

    public String getTrika() {
        return trika;
    }

    public void setTrika(String trika) {
        this.trika = trika;
    }

    public Date getFeModificacion() {
        return feModificacion;
    }

    public void setFeModificacion(Date feModificacion) {
        this.feModificacion = feModificacion;
    }

    public List<HistoMy> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistoMy> historial) {
        this.historial = historial;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Boolean getIndGhost() {
        return indGhost;
    }

    public void setIndGhost(Boolean indGhost) {
        this.indGhost = indGhost;
    }

    public List<HistoGradMy> getHistorialGrad() {
        return historialGrad;
    }

    public void setHistorialGrad(List<HistoGradMy> historialGrad) {
        this.historialGrad = historialGrad;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PromCiclosMy)) {
            return false;
        }
        PromCiclosMy other = (PromCiclosMy) object;
        if ((this.promCiclosPK == null && other.promCiclosPK != null)
                || (this.promCiclosPK != null && !this.promCiclosPK.equals(other.promCiclosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.oficina.academico.PromCiclos[ promCiclosPK=" + promCiclosPK + " ]";
    }

}
