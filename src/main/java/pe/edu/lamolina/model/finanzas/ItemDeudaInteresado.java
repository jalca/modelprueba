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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.inscripcion.DescuentoExamen;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "fin_item_deuda_interesado")
public class ItemDeudaInteresado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_desactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda_interesado")
    private DeudaInteresado deudaInteresado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_precio")
    private ConceptoPrecio conceptoPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_campagna_descuento")
    private CampagnaDescuento campagnaDescuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_descuento_examen")
    private DescuentoExamen descuentoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud_cambio_info")
    private SolicitudCambioInfo solicitudCambioInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_desactivacion")
    private Usuario userDesactivacion;

    public ItemDeudaInteresado() {
    }

    public ItemDeudaInteresado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

    public DeudaInteresado getDeudaInteresado() {
        return deudaInteresado;
    }

    public void setDeudaInteresado(DeudaInteresado deudaInteresado) {
        this.deudaInteresado = deudaInteresado;
    }

    public ConceptoPrecio getConceptoPrecio() {
        return conceptoPrecio;
    }

    public void setConceptoPrecio(ConceptoPrecio conceptoPrecio) {
        this.conceptoPrecio = conceptoPrecio;
    }

    public CampagnaDescuento getCampagnaDescuento() {
        return campagnaDescuento;
    }

    public void setCampagnaDescuento(CampagnaDescuento campagnaDescuento) {
        this.campagnaDescuento = campagnaDescuento;
    }

    public DescuentoExamen getDescuentoExamen() {
        return descuentoExamen;
    }

    public void setDescuentoExamen(DescuentoExamen descuentoExamen) {
        this.descuentoExamen = descuentoExamen;
    }

    public SolicitudCambioInfo getSolicitudCambioInfo() {
        return solicitudCambioInfo;
    }

    public void setSolicitudCambioInfo(SolicitudCambioInfo solicitudCambioInfo) {
        this.solicitudCambioInfo = solicitudCambioInfo;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserDesactivacion() {
        return userDesactivacion;
    }

    public void setUserDesactivacion(Usuario userDesactivacion) {
        this.userDesactivacion = userDesactivacion;
    }

}
