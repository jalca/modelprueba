package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.finanzas.ConceptoPrecio;

@Entity
@Table(name = "sip_modalidad_ingreso_ciclo")
public class ModalidadIngresoCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "presentar_documentos")
    private Integer presentarDocumentos;

    @Column(name = "requiere_colegio")
    private Integer requiereColegio;

    @Column(name = "requiere_universidad")
    private Integer requiereUniversidad;

    @Column(name = "solo_colegio_peruano")
    private Integer soloColegioPeruano;

    @Column(name = "solo_colegio_extranjero")
    private Integer soloColegioExtranjero;

    @Column(name = "solo_universidad_peruana")
    private Integer soloUniversidadPeruana;

    @Column(name = "solo_universidad_extranjera")
    private Integer soloUniversidadExtranjera;

    @Column(name = "exonerado_pago")
    private Integer exoneradoPago;

    @Column(name = "rinde_examen_admision")
    private Integer rindeExamenAdmision;

    @Column(name = "opciones")
    private Integer opciones;

    @Column(name = "tiene_descuento_coar")
    private Integer tieneDescuentoCoar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @Transient
    private Integer porcentajeAumentoNota;

    @Transient
    private Integer controlNotaMinimaOrdinario;

    @Transient
    private BigDecimal notaMinima;
    @Transient
    private List<ConceptoPrecio> conceptoPrecio;

    public ModalidadIngresoCiclo() {
    }

    public ModalidadIngresoCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPresentarDocumentos() {
        return presentarDocumentos;
    }

    public void setPresentarDocumentos(Integer presentarDocumentos) {
        this.presentarDocumentos = presentarDocumentos;
    }

    public Integer getRequiereColegio() {
        return requiereColegio;
    }

    public void setRequiereColegio(Integer requiereColegio) {
        this.requiereColegio = requiereColegio;
    }

    public Integer getRequiereUniversidad() {
        return requiereUniversidad;
    }

    public void setRequiereUniversidad(Integer requiereUniversidad) {
        this.requiereUniversidad = requiereUniversidad;
    }

    public Integer getSoloColegioPeruano() {
        return soloColegioPeruano;
    }

    public void setSoloColegioPeruano(Integer soloColegioPeruano) {
        this.soloColegioPeruano = soloColegioPeruano;
    }

    public Integer getSoloColegioExtranjero() {
        return soloColegioExtranjero;
    }

    public void setSoloColegioExtranjero(Integer soloColegioExtranjero) {
        this.soloColegioExtranjero = soloColegioExtranjero;
    }

    public Integer getExoneradoPago() {
        return exoneradoPago;
    }

    public void setExoneradoPago(Integer exoneradoPago) {
        this.exoneradoPago = exoneradoPago;
    }

    public Integer getRindeExamenAdmision() {
        return rindeExamenAdmision;
    }

    public void setRindeExamenAdmision(Integer rindeExamenAdmision) {
        this.rindeExamenAdmision = rindeExamenAdmision;
    }

    public Integer getOpciones() {
        return opciones;
    }

    public void setOpciones(Integer opciones) {
        this.opciones = opciones;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Integer getPorcentajeAumentoNota() {
        return porcentajeAumentoNota;
    }

    public void setPorcentajeAumentoNota(Integer porcentajeAumentoNota) {
        this.porcentajeAumentoNota = porcentajeAumentoNota;
    }

    public Integer getControlNotaMinimaOrdinario() {
        return controlNotaMinimaOrdinario;
    }

    public void setControlNotaMinimaOrdinario(Integer controlNotaMinimaOrdinario) {
        this.controlNotaMinimaOrdinario = controlNotaMinimaOrdinario;
    }

    public BigDecimal getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(BigDecimal notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Integer getTieneDescuentoCoar() {
        return tieneDescuentoCoar;
    }

    public void setTieneDescuentoCoar(Integer tieneDescuentoCoar) {
        this.tieneDescuentoCoar = tieneDescuentoCoar;
    }

    public Integer getSoloUniversidadPeruana() {
        return soloUniversidadPeruana;
    }

    public void setSoloUniversidadPeruana(Integer soloUniversidadPeruana) {
        this.soloUniversidadPeruana = soloUniversidadPeruana;
    }

    public Integer getSoloUniversidadExtranjera() {
        return soloUniversidadExtranjera;
    }

    public void setSoloUniversidadExtranjera(Integer soloUniversidadExtranjera) {
        this.soloUniversidadExtranjera = soloUniversidadExtranjera;
    }

    public boolean isTieneDescuentoCoar() {
        if (tieneDescuentoCoar == null) {
            return false;
        }
        return tieneDescuentoCoar == 1;
    }

    public boolean isVerColegiosExtranjeros() {
        if (this.soloColegioExtranjero == 1) {
            return true;
        }
        return this.soloColegioExtranjero == 0 && this.soloColegioPeruano == 0;
    }

    public boolean isRequiereSoloColegio() {
        return (this.requiereColegio == 1 && this.requiereUniversidad == 0);
    }

    public boolean isRequiereSoloUniversidad() {
        return (this.requiereColegio == 0 && this.requiereUniversidad == 1);
    }

    public boolean isRequiereColegioUniversidad() {
        return (this.requiereColegio == 1 && this.requiereUniversidad == 1);
    }

    public static class CompareCodigoModalidad implements Comparator<ModalidadIngresoCiclo> {

        @Override
        public int compare(ModalidadIngresoCiclo mc1, ModalidadIngresoCiclo mc2) {
            ModalidadIngreso mi1 = mc1.modalidadIngreso;
            ModalidadIngreso mi2 = mc2.modalidadIngreso;
            return mi1.getCodigo().compareTo(mi2.getCodigo());
        }
    }

    public List<ConceptoPrecio> getConceptoPrecio() {
        return conceptoPrecio;
    }

    public void setConceptoPrecio(List<ConceptoPrecio> conceptoPrecio) {
        this.conceptoPrecio = conceptoPrecio;
    }

}
