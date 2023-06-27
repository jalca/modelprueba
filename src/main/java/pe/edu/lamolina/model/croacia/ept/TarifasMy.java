package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ept_tarifas", catalog = "croacia")
public class TarifasMy implements Serializable {

    @EmbeddedId
    protected TarifasMyPk tarifasMyPk;

    @Column(name = "NOMBRE_TARIFA")
    private String nombreTarifa;

    @Column(name = "DSCTO")
    private BigDecimal dscto;

    @Column(name = "INTERES_MORA")
    private BigDecimal interesMora;

    @Column(name = "FECHA_MODIFI")
    private Date fechaModifi;

    @Column(name = "USUARIO_MODIFI")
    private String usuarioModifi;

    @Column(name = "INTERES_CUOTA")
    private BigDecimal interesCuota;

    @Column(name = "PRCNTJE_CREDITO_MORA")
    private BigDecimal prcntjeCreditoMora;

    @Column(name = "ORDEN")
    private Integer orden;

    @Column(name = "DSCTO_CREDITOS")
    private BigDecimal dsctoCreditos;

    public TarifasMy() {
    }

    public TarifasMyPk getTarifasMyPk() {
        return tarifasMyPk;
    }

    public void setTarifasMyPk(TarifasMyPk tarifasMyPk) {
        this.tarifasMyPk = tarifasMyPk;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
    }

    public BigDecimal getDscto() {
        return dscto;
    }

    public void setDscto(BigDecimal dscto) {
        this.dscto = dscto;
    }

    public BigDecimal getInteresMora() {
        return interesMora;
    }

    public void setInteresMora(BigDecimal interesMora) {
        this.interesMora = interesMora;
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

    public BigDecimal getInteresCuota() {
        return interesCuota;
    }

    public void setInteresCuota(BigDecimal interesCuota) {
        this.interesCuota = interesCuota;
    }

    public BigDecimal getPrcntjeCreditoMora() {
        return prcntjeCreditoMora;
    }

    public void setPrcntjeCreditoMora(BigDecimal prcntjeCreditoMora) {
        this.prcntjeCreditoMora = prcntjeCreditoMora;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BigDecimal getDsctoCreditos() {
        return dsctoCreditos;
    }

    public void setDsctoCreditos(BigDecimal dsctoCreditos) {
        this.dsctoCreditos = dsctoCreditos;
    }

}
