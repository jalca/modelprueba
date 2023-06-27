package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Table(name = "traslado_interno", catalog = GlobalConstantine.SCHEMA_CROACIA)
public class TrasladoInternoMy implements Serializable, Cloneable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "ID_TRASLAD")
    private String idTraslad;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "TRAMITE")
    private String tramite;

    @Column(name = "ANUAL")
    private String anual;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ESP_ANTERIOR")
    private String espAnterior;

    @Column(name = "ESP_NUEVA")
    private String espNueva;

    @Column(name = "CCS")
    private BigDecimal ccs;

    @Column(name = "CAPS")
    private BigDecimal caps;

    @Column(name = "PS")
    private Long ps;

    @Column(name = "PPS")
    private BigDecimal pps;

    @Column(name = "CCA")
    private Long cca;

    @Column(name = "CAPA")
    private Long capa;

    @Column(name = "PA")
    private Long pa;

    @Column(name = "PPA")
    private BigDecimal ppa;

    @Column(name = "ID_RESOLUC")
    private String idResoluc;

    @Column(name = "RECONSIDERA")
    private String reconsidera;

    @Column(name = "USUARIO_GENERA")
    private String usuarioGenera;

    @Column(name = "FECHA_GENERA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaGenera;

    @Column(name = "ASIGNARES_USER")
    private String asignaresUser;

    @Column(name = "ASIGNARES_FECHA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date asignaresFecha;

    @Column(name = "ID_CARTA")
    private String idCarta;

    @Column(name = "AUTORIZACION")
    private String autorizacion;

    public TrasladoInternoMy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getIdTraslad() {
        return idTraslad;
    }

    public void setIdTraslad(String idTraslad) {
        this.idTraslad = idTraslad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEspAnterior() {
        return espAnterior;
    }

    public void setEspAnterior(String espAnterior) {
        this.espAnterior = espAnterior;
    }

    public String getEspNueva() {
        return espNueva;
    }

    public void setEspNueva(String espNueva) {
        this.espNueva = espNueva;
    }

    public BigDecimal getCcs() {
        return ccs;
    }

    public void setCcs(BigDecimal ccs) {
        this.ccs = ccs;
    }

    public BigDecimal getCaps() {
        return caps;
    }

    public void setCaps(BigDecimal caps) {
        this.caps = caps;
    }

    public Long getPs() {
        return ps;
    }

    public void setPs(Long ps) {
        this.ps = ps;
    }

    public BigDecimal getPps() {
        return pps;
    }

    public void setPps(BigDecimal pps) {
        this.pps = pps;
    }

    public Long getCca() {
        return cca;
    }

    public void setCca(Long cca) {
        this.cca = cca;
    }

    public Long getCapa() {
        return capa;
    }

    public void setCapa(Long capa) {
        this.capa = capa;
    }

    public Long getPa() {
        return pa;
    }

    public void setPa(Long pa) {
        this.pa = pa;
    }

    public BigDecimal getPpa() {
        return ppa;
    }

    public void setPpa(BigDecimal ppa) {
        this.ppa = ppa;
    }

    public String getIdResoluc() {
        return idResoluc;
    }

    public void setIdResoluc(String idResoluc) {
        this.idResoluc = idResoluc;
    }

    public String getReconsidera() {
        return reconsidera;
    }

    public void setReconsidera(String reconsidera) {
        this.reconsidera = reconsidera;
    }

    public String getUsuarioGenera() {
        return usuarioGenera;
    }

    public void setUsuarioGenera(String usuarioGenera) {
        this.usuarioGenera = usuarioGenera;
    }

    public Date getFechaGenera() {
        return fechaGenera;
    }

    public void setFechaGenera(Date fechaGenera) {
        this.fechaGenera = fechaGenera;
    }

    public String getAsignaresUser() {
        return asignaresUser;
    }

    public void setAsignaresUser(String asignaresUser) {
        this.asignaresUser = asignaresUser;
    }

    public Date getAsignaresFecha() {
        return asignaresFecha;
    }

    public void setAsignaresFecha(Date asignaresFecha) {
        this.asignaresFecha = asignaresFecha;
    }

    public String getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(String idCarta) {
        this.idCarta = idCarta;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

}
