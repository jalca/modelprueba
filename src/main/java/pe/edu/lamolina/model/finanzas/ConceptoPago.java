package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.constantines.AdmisionConstantine;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TipoGestionEnum;
import static pe.edu.lamolina.model.enums.TipoProspectoEnum.conexamen;
import static pe.edu.lamolina.model.enums.TipoProspectoEnum.regular;
import static pe.edu.lamolina.model.enums.TipoProspectoEnum.sinexamen;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;

@Entity
@Table(name = "fin_concepto_pago")
public class ConceptoPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_banco")
    private String codigoBanco;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descuento")
    private Integer descuento;

    @Column(name = "ambito_descuento")
    private String ambitoDescuento;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_origen")
    private ConceptoPago conceptoOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @OneToMany(mappedBy = "concepto", fetch = FetchType.LAZY)
    private List<AbonoPostulante> abonoPostulante;

    @OneToMany(mappedBy = "conceptoPago", fetch = FetchType.LAZY)
    private List<ConceptoPrecio> conceptoPrecio;

    @OneToMany(mappedBy = "conceptoPago", fetch = FetchType.LAZY)
    private List<ItemCargaAbono> itemCargaAbono;

    @OneToMany(mappedBy = "conceptoOrigen", fetch = FetchType.LAZY)
    private List<ConceptoPago> conceptoHijo;

    @Transient
    private BigDecimal monto;

    @Transient
    private Integer esAntesExamen;

    public ConceptoPago() {
    }

    public ConceptoPago(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean isProspecto() {
        if (codigo == null) {
            return false;
        }
        return Arrays.asList(conexamen.getDisplayName(), sinexamen.getDisplayName(), regular.getDisplayName()).contains(codigo);
    }

    public boolean isExtemporaneo() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_EXTEMPORANEO);
    }

    public boolean isSinDescripcion() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_SIN_DESCRIPCION);
    }

    public boolean haveModalidadIngreso() {
        return this.modalidadIngreso != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonIgnore
    public void setTipoEnum(TipoGestionEnum tipo) {
        this.tipo = tipo.name();
    }

    public TipoGestionEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoGestionEnum.valueOf(tipo);
    }

    public List<AbonoPostulante> getAbonoPostulante() {
        return abonoPostulante;
    }

    public void setAbonoPostulante(List<AbonoPostulante> abonoPostulante) {
        this.abonoPostulante = abonoPostulante;
    }

    public List<ConceptoPrecio> getConceptoPrecio() {
        return conceptoPrecio;
    }

    public void setConceptoPrecio(List<ConceptoPrecio> conceptoPrecio) {
        this.conceptoPrecio = conceptoPrecio;
    }

    public List<ItemCargaAbono> getItemCargaAbono() {
        return itemCargaAbono;
    }

    public void setItemCargaAbono(List<ItemCargaAbono> itemCargaAbono) {
        this.itemCargaAbono = itemCargaAbono;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getAmbitoDescuento() {
        return ambitoDescuento;
    }

    public void setAmbitoDescuento(String ambitoDescuento) {
        this.ambitoDescuento = ambitoDescuento;
    }

    public ConceptoPago getConceptoOrigen() {
        return conceptoOrigen;
    }

    public void setConceptoOrigen(ConceptoPago conceptoOrigen) {
        this.conceptoOrigen = conceptoOrigen;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<ConceptoPago> getConceptoHijo() {
        return conceptoHijo;
    }

    public void setConceptoHijo(List<ConceptoPago> conceptoHijo) {
        this.conceptoHijo = conceptoHijo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getEsAntesExamen() {
        return esAntesExamen;
    }

    public void setEsAntesExamen(Integer esAntesExamen) {
        this.esAntesExamen = esAntesExamen;
    }

    public TipoGestionEnum getTipoGestion() {
        if (tipo.startsWith("PUB")) {
            return TipoGestionEnum.PUB;
        }
        if (tipo.startsWith("PRIV")) {
            return TipoGestionEnum.PRIV;
        }
        if (tipo.startsWith("AMB")) {
            return TipoGestionEnum.AMB;
        }
        return TipoGestionEnum.INDEF;
    }

}
