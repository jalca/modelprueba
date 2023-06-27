package pe.edu.lamolina.model.posgrado;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "epg_tarifa_concepto")
public class TarifaConcepto implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "monto_minimo_inicial")
    private BigDecimal montoMinimoInicial;

    @Column(name = "porcentaje_minimo_inicial")
    private BigDecimal porcentajeMinimoInicial;

    @Column(name = "porcentaje_inicial")
    private BigDecimal porcentajeInicial;

    @Column(name = "fraccion_porcentaje_min_inicial")
    private String fraccionPorcentajeMinimoInicial;

    @Column(name = "fraccion_porcentaje_inicial")
    private String fraccionPorcentajeInicial;

    @Column(name = "fraccionable")
    private Boolean fraccionable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarifa_carrera")
    private TarifaCarrera tarifaCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_posgrado")
    private ConceptoPosgrado conceptoPosgrado;

    @Transient
    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TarifaCarrera getTarifaCarrera() {
        return tarifaCarrera;
    }

    public void setTarifaCarrera(TarifaCarrera tarifaCarrera) {
        this.tarifaCarrera = tarifaCarrera;
    }

    public ConceptoPosgrado getConceptoPosgrado() {
        return conceptoPosgrado;
    }

    public void setConceptoPosgrado(ConceptoPosgrado conceptoPosgrado) {
        this.conceptoPosgrado = conceptoPosgrado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoMinimoInicial() {
        return montoMinimoInicial;
    }

    public void setMontoMinimoInicial(BigDecimal montoMinimoInicial) {
        this.montoMinimoInicial = montoMinimoInicial;
    }

    public BigDecimal getPorcentajeMinimoInicial() {
        return porcentajeMinimoInicial;
    }

    public void setPorcentajeMinimoInicial(BigDecimal porcentajeMinimoInicial) {
        this.porcentajeMinimoInicial = porcentajeMinimoInicial;
    }

    public BigDecimal getPorcentajeInicial() {
        return porcentajeInicial;
    }

    public void setPorcentajeInicial(BigDecimal porcentajeInicial) {
        this.porcentajeInicial = porcentajeInicial;
    }

    public Boolean getFraccionable() {
        return fraccionable;
    }

    public void setFraccionable(Boolean fraccionable) {
        this.fraccionable = fraccionable;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getFraccionPorcentajeMinimoInicial() {
        return fraccionPorcentajeMinimoInicial;
    }

    public void setFraccionPorcentajeMinimoInicial(String fraccionPorcentajeMinimoInicial) {
        this.fraccionPorcentajeMinimoInicial = fraccionPorcentajeMinimoInicial;
    }

    public String getFraccionPorcentajeInicial() {
        return fraccionPorcentajeInicial;
    }

    public void setFraccionPorcentajeInicial(String fraccionPorcentajeInicial) {
        this.fraccionPorcentajeInicial = fraccionPorcentajeInicial;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
