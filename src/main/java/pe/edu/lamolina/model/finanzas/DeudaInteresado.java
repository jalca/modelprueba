package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.inscripcion.Interesado;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "fin_deuda_interesado")
public class DeudaInteresado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "monto_anterior")
    private BigDecimal montoAnterior;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_modificacion")
    private String motivoModificacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "id_user_abono")
    private Long idUserAbono;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAbono;

    @Column(name = "fecha_descuento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDescuento;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_precio")
    private ConceptoPrecio conceptoPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_anterior")
    private ConceptoPrecio conceptoAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_descuento")
    private Usuario userDescuento;

    @Column(name = "fecha_envio_recaudacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnvioRecaudacion;

    @Column(name = "fecha_anulacion_recaudacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacionRecaudacion;

    @Transient
    private List<ItemDeudaInteresado> itemDeudaInteresado;

    @Transient
    private Integer numero;

    public DeudaInteresado() {
    }

    public DeudaInteresado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean isCancelada() {
        return (monto.compareTo(abono) <= 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public ConceptoPrecio getConceptoPrecio() {
        return conceptoPrecio;
    }

    public void setConceptoPrecio(ConceptoPrecio conceptoPrecio) {
        this.conceptoPrecio = conceptoPrecio;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdUserAbono() {
        return idUserAbono;
    }

    public void setIdUserAbono(Long idUserAbono) {
        this.idUserAbono = idUserAbono;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public Date getFechaEnvioRecaudacion() {
        return fechaEnvioRecaudacion;
    }

    public void setFechaEnvioRecaudacion(Date fechaEnvioRecaudacion) {
        this.fechaEnvioRecaudacion = fechaEnvioRecaudacion;
    }

    public Date getFechaAnulacionRecaudacion() {
        return fechaAnulacionRecaudacion;
    }

    public void setFechaAnulacionRecaudacion(Date fechaAnulacionRecaudacion) {
        this.fechaAnulacionRecaudacion = fechaAnulacionRecaudacion;
    }

    public BigDecimal getMontoAnterior() {
        return montoAnterior;
    }

    public void setMontoAnterior(BigDecimal montoAnterior) {
        this.montoAnterior = montoAnterior;
    }

    public String getEstado() {
        return estado;
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getMotivoModificacion() {
        return motivoModificacion;
    }

    public void setMotivoModificacion(String motivoModificacion) {
        this.motivoModificacion = motivoModificacion;
    }

    public Date getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(Date fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public ConceptoPrecio getConceptoAnterior() {
        return conceptoAnterior;
    }

    public void setConceptoAnterior(ConceptoPrecio conceptoAnterior) {
        this.conceptoAnterior = conceptoAnterior;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public Usuario getUserDescuento() {
        return userDescuento;
    }

    public void setUserDescuento(Usuario userDescuento) {
        this.userDescuento = userDescuento;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<ItemDeudaInteresado> getItemDeudaInteresado() {
        return itemDeudaInteresado;
    }

    public void setItemDeudaInteresado(List<ItemDeudaInteresado> itemDeudaInteresado) {
        this.itemDeudaInteresado = itemDeudaInteresado;
    }

    public static class CompareCtaBanco implements Comparator<DeudaInteresado> {

        @Override
        public int compare(DeudaInteresado d2, DeudaInteresado d1) {
            CuentaBancaria cta1 = d1.cuentaBancaria;
            CuentaBancaria cta2 = d2.cuentaBancaria;
            if (cta1 == null && cta2 == null) {
                return 0;
            }
            if (cta1 != null && cta2 == null) {
                return -1;
            }
            if (cta1 == null && cta2 != null) {
                return 1;
            }
            return cta1.getCodigo().compareTo(cta2.getCodigo());
        }
    }

}
