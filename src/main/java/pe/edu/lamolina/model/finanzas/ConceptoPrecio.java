package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "fin_concepto_precio")
public class ConceptoPrecio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "es_antes_examen")
    private Integer esAntesExamen;

    @Column(name = "fecha_registra")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistra;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registra")
    private Usuario userRegistra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_pago")
    private ConceptoPago conceptoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cambio_info")
    private TipoCambioInfo tipoCambioInfo;

    @Transient
    private String color;
    @Transient
    private Integer numero;
    @Transient
    private ModalidadIngreso modalidadIngreso;
    @Transient
    private Colegio colegio;
    @Transient
    private Pais paisColegio;
    @Transient
    private Universidad universidad;
    @Transient
    private Pais paisUniversidad;
    @Transient
    private String universidadExtranjera;
    @Transient
    private String colegioExtranjero;
    @Transient
    private Postulante postulante;

    public ConceptoPrecio() {
    }

    public ConceptoPrecio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public ConceptoPago getConceptoPago() {
        return conceptoPago;
    }

    public void setConceptoPago(ConceptoPago conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(Date fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public Usuario getUserRegistra() {
        return userRegistra;
    }

    public void setUserRegistra(Usuario userRegistra) {
        this.userRegistra = userRegistra;
    }

    public Usuario getUserModifica() {
        return userModifica;
    }

    public void setUserModifica(Usuario userModifica) {
        this.userModifica = userModifica;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    public Integer getEsAntesExamen() {
        return esAntesExamen;
    }

    public void setEsAntesExamen(Integer esAntesExamen) {
        this.esAntesExamen = esAntesExamen;
    }

    public TipoCambioInfo getTipoCambioInfo() {
        return tipoCambioInfo;
    }

    public void setTipoCambioInfo(TipoCambioInfo tipoCambioInfo) {
        this.tipoCambioInfo = tipoCambioInfo;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public String getUniversidadExtranjera() {
        return universidadExtranjera;
    }

    public void setUniversidadExtranjera(String universidadExtranjera) {
        this.universidadExtranjera = universidadExtranjera;
    }

    public String getColegioExtranjero() {
        return colegioExtranjero;
    }

    public void setColegioExtranjero(String colegioExtranjero) {
        this.colegioExtranjero = colegioExtranjero;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Pais getPaisColegio() {
        return paisColegio;
    }

    public void setPaisColegio(Pais paisColegio) {
        this.paisColegio = paisColegio;
    }

    public Pais getPaisUniversidad() {
        return paisUniversidad;
    }

    public void setPaisUniversidad(Pais paisUniversidad) {
        this.paisUniversidad = paisUniversidad;
    }

}
