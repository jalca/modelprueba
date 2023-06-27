package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ept_deudas_cuentas", catalog = "croacia")
public class DeudasCuentasMy implements Serializable {

    

    @EmbeddedId
    protected DeudasCuentasMyPK deudasCuentasPK;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "AYUDA")
    private BigDecimal ayuda;

    @Column(name = "INICIAL")
    private BigDecimal inicial;

    @Column(name = "FRACCIONAR")
    private BigDecimal fraccionar;

    @Column(name = "CANCELADO")
    private BigDecimal cancelado;

    @Column(name = "CUOTAS")
    private Integer cuotas;

    @Column(name = "INTERES")
    private BigDecimal interes;

    @Column(name = "INTERES_MORA")
    private BigDecimal interesMora;

    @Column(name = "FECHA_BASE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBase;

    @Column(name = "DSCTO")
    private Integer dscto;

    @Column(name = "CRED_MAT")
    private Integer credMat;

    @Column(name = "MES_INICIO")
    private Integer mesInicio;

    @Column(name = "INTERVALO_MESE")
    private Integer intervaloMese;

    @Size(max = 10)
    @Column(name = "TIPO_TARIFA")
    private String tipoTarifa;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deudasCuentas", fetch = FetchType.LAZY)
    @Transient
    private List<FraccionadoMy> fraccionadoList;

    public DeudasCuentasMy() {
    }

    public DeudasCuentasMy(DeudasCuentasMyPK deudasCuentasPK) {
        this.deudasCuentasPK = deudasCuentasPK;
    }

    public DeudasCuentasMyPK getDeudasCuentasPK() {
        return deudasCuentasPK;
    }

    public void setDeudasCuentasPK(DeudasCuentasMyPK deudasCuentasPK) {
        this.deudasCuentasPK = deudasCuentasPK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getAyuda() {
        return ayuda;
    }

    public void setAyuda(BigDecimal ayuda) {
        this.ayuda = ayuda;
    }

    public BigDecimal getInicial() {
        return inicial;
    }

    public void setInicial(BigDecimal inicial) {
        this.inicial = inicial;
    }

    public BigDecimal getFraccionar() {
        return fraccionar;
    }

    public void setFraccionar(BigDecimal fraccionar) {
        this.fraccionar = fraccionar;
    }

    public BigDecimal getCancelado() {
        return cancelado;
    }

    public void setCancelado(BigDecimal cancelado) {
        this.cancelado = cancelado;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getInteresMora() {
        return interesMora;
    }

    public void setInteresMora(BigDecimal interesMora) {
        this.interesMora = interesMora;
    }

    public Date getFechaBase() {
        return fechaBase;
    }

    public void setFechaBase(Date fechaBase) {
        this.fechaBase = fechaBase;
    }

    public Integer getDscto() {
        return dscto;
    }

    public void setDscto(Integer dscto) {
        this.dscto = dscto;
    }

    public Integer getCredMat() {
        return credMat;
    }

    public void setCredMat(Integer credMat) {
        this.credMat = credMat;
    }

    public Integer getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Integer mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Integer getIntervaloMese() {
        return intervaloMese;
    }

    public void setIntervaloMese(Integer intervaloMese) {
        this.intervaloMese = intervaloMese;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public List<FraccionadoMy> getFraccionadoList() {
        return fraccionadoList;
    }

    public void setFraccionadoList(List<FraccionadoMy> fraccionadoList) {
        this.fraccionadoList = fraccionadoList;
    }

}
