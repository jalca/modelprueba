package pe.edu.lamolina.model.finanzas;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.inscripcion.Postulante;

@Entity
@Table(name = "fin_abono_postulante")
public class AbonoPostulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "numero_operacion")
    private String numeroOperacion;

    @Column(name = "fecha_impresion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaImpresion;

    @Column(name = "fecha_deposito")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDeposito;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abono")
    private ItemCargaAbono abono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto")
    private ConceptoPago concepto;

    public AbonoPostulante() {
    }

    public AbonoPostulante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public ItemCargaAbono getAbono() {
        return abono;
    }

    public void setAbono(ItemCargaAbono abono) {
        this.abono = abono;
    }

    public ConceptoPago getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoPago concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public BigDecimal getImporteUtilizado() {
        return importeUtilizado;
    }

    public void setImporteUtilizado(BigDecimal importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public Date getFechaDeposito() {
        return fechaDeposito;
    }

    public void setFechaDeposito(Date fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }

}
