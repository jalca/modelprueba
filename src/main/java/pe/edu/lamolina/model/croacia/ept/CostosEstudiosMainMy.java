package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ept_costos_estudios_main", catalog = "croacia")
public class CostosEstudiosMainMy implements Serializable {

    
    @EmbeddedId
    protected CostosEstudiosMainMyPK costosEstudiosMainPK;

    @Column(name = "MONEDA")
    private String moneda;

    @Column(name = "COSTO_CREDITO")
    private BigDecimal costoCredito;

    @Column(name = "CON_INTERES")
    private String conInteres;

    @Column(name = "FECHA_MODIFI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifi;

    @Column(name = "USUARIO_MODIFI")
    private String usuarioModifi;

    @Column(name = "CUOTAS")
    private Integer cuotas;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "INTERVALO_MESES")
    private Integer intervaloMeses;

    @Column(name = "MES_INICIO")
    private Integer mesInicio;

    @Column(name = "MIN_CRED_MONTO_BASE")
    private Integer minCredMontoBase;

    @Column(name = "TIPO_TARIFA")
    private String tipoTarifa;

    @Column(name = "CRDTOS_EXCSO")
    private Integer crdtosExcso;

    @Column(name = "CSTO_CRDTOS_EXCSO")
    private Integer cstoCrdtosExcso;

    public CostosEstudiosMainMy() {
    }

    public CostosEstudiosMainMy(CostosEstudiosMainMyPK costosEstudiosMainPK) {
        this.costosEstudiosMainPK = costosEstudiosMainPK;
    }

    public CostosEstudiosMainMyPK getCostosEstudiosMainPK() {
        return costosEstudiosMainPK;
    }

    public void setCostosEstudiosMainPK(CostosEstudiosMainMyPK costosEstudiosMainPK) {
        this.costosEstudiosMainPK = costosEstudiosMainPK;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getCostoCredito() {
        return costoCredito;
    }

    public void setCostoCredito(BigDecimal costoCredito) {
        this.costoCredito = costoCredito;
    }

    public String getConInteres() {
        return conInteres;
    }

    public void setConInteres(String conInteres) {
        this.conInteres = conInteres;
    }

    public Date getFechaModifi() {
        return fechaModifi;
    }

    public void setFechaModifi(Date fechaModifi) {
        this.fechaModifi = fechaModifi;
    }

    public String getUsuarioModifi() {
        return usuarioModifi;
    }

    public void setUsuarioModifi(String usuarioModifi) {
        this.usuarioModifi = usuarioModifi;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIntervaloMeses() {
        return intervaloMeses;
    }

    public void setIntervaloMeses(Integer intervaloMeses) {
        this.intervaloMeses = intervaloMeses;
    }

    public Integer getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Integer mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Integer getMinCredMontoBase() {
        return minCredMontoBase;
    }

    public void setMinCredMontoBase(Integer minCredMontoBase) {
        this.minCredMontoBase = minCredMontoBase;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public Integer getCrdtosExcso() {
        return crdtosExcso;
    }

    public void setCrdtosExcso(Integer crdtosExcso) {
        this.crdtosExcso = crdtosExcso;
    }

    public Integer getCstoCrdtosExcso() {
        return cstoCrdtosExcso;
    }

    public void setCstoCrdtosExcso(Integer cstoCrdtosExcso) {
        this.cstoCrdtosExcso = cstoCrdtosExcso;
    }

}
