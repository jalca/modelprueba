package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_tarifa_concepto_eliminado")
public class TarifaConceptoEliminado implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_original")
    private Long idOriginal;

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

    @Column(name = "fecha_destruccion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaDestruccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarifa_carrera")
    private TarifaCarrera tarifaCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_posgrado")
    private ConceptoPosgrado conceptoPosgrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_destructor")
    private Usuario userDestructor;

    public TarifaConceptoEliminado(TarifaConcepto tcon, Usuario user) {
        this.idOriginal = tcon.getId();
        this.monto = tcon.getMonto();
        this.montoMinimoInicial = tcon.getMontoMinimoInicial();
        this.porcentajeInicial = tcon.getPorcentajeInicial();
        this.porcentajeMinimoInicial = tcon.getPorcentajeMinimoInicial();
        this.fraccionable = tcon.getFraccionable();
        this.fraccionPorcentajeInicial = tcon.getFraccionPorcentajeInicial();
        this.fraccionPorcentajeMinimoInicial = tcon.getFraccionPorcentajeMinimoInicial();
        this.tarifaCarrera = tcon.getTarifaCarrera();
        this.conceptoPosgrado = tcon.getConceptoPosgrado();
        this.userDestructor = user;
        this.fechaDestruccion = new Date();
    }

    public TarifaConceptoEliminado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOriginal() {
        return idOriginal;
    }

    public void setIdOriginal(Long idOriginal) {
        this.idOriginal = idOriginal;
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

    public Boolean getFraccionable() {
        return fraccionable;
    }

    public void setFraccionable(Boolean fraccionable) {
        this.fraccionable = fraccionable;
    }

    public Date getFechaDestruccion() {
        return fechaDestruccion;
    }

    public void setFechaDestruccion(Date fechaDestruccion) {
        this.fechaDestruccion = fechaDestruccion;
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

    public Usuario getUserDestructor() {
        return userDestructor;
    }

    public void setUserDestructor(Usuario userDestructor) {
        this.userDestructor = userDestructor;
    }

}
