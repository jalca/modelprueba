package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.enums.EstadoDetallePedidoGastoEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.DocumentoEmitePersona;
import pe.edu.lamolina.model.general.DocumentoExterno;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.EmpresaCuentaBancaria;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "fin_detalle_pedido_gasto")
public class DetallePedidoGasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido_gasto")
    private PedidoGasto pedidoGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pedido_gasto")
    private TipoPedidoGasto tipoPedidoGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_contable")
    private ConceptoContable conceptoContable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa_cuenta_bancaria")
    private EmpresaCuentaBancaria empresaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_externo")
    private DocumentoExterno documentoExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_guia_remision")
    private DocumentoExterno documentoGuiaRemision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_emite_persona")
    private DocumentoEmitePersona documentoEmitePersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_suspension_retenciones")
    private DocumentoEmitePersona documentoSuspensionRetenciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "detallePedidoGasto", fetch = FetchType.LAZY)
    private List<LiquidacionGasto> liquidacionGasto;

    @OneToMany(mappedBy = "detallePedidoGasto", fetch = FetchType.LAZY)
    private List<DistribucionGasto> distribucionGasto;

    public DetallePedidoGasto() {
    }

    public DetallePedidoGasto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public PedidoGasto getPedidoGasto() {
        return pedidoGasto;
    }

    public void setPedidoGasto(PedidoGasto pedidoGasto) {
        this.pedidoGasto = pedidoGasto;
    }

    public TipoPedidoGasto getTipoPedidoGasto() {
        return tipoPedidoGasto;
    }

    public void setTipoPedidoGasto(TipoPedidoGasto tipoPedidoGasto) {
        this.tipoPedidoGasto = tipoPedidoGasto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Oficina getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(Oficina oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoDetallePedidoGastoEnum getEstadoDetallePedidoGastoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoDetallePedidoGastoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoDetallePedidoGastoEnum(EstadoDetallePedidoGastoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public List<LiquidacionGasto> getLiquidacionGasto() {
        return liquidacionGasto;
    }

    public void setLiquidacionGasto(List<LiquidacionGasto> liquidacionGasto) {
        this.liquidacionGasto = liquidacionGasto;
    }

    public List<DistribucionGasto> getDistribucionGasto() {
        return distribucionGasto;
    }

    public void setDistribucionGasto(List<DistribucionGasto> distribucionGasto) {
        this.distribucionGasto = distribucionGasto;
    }

    public ConceptoContable getConceptoContable() {
        return conceptoContable;
    }

    public void setConceptoContable(ConceptoContable conceptoContable) {
        this.conceptoContable = conceptoContable;
    }

    public PersonaCuentaBancaria getPersonaCuentaBancaria() {
        return personaCuentaBancaria;
    }

    public void setPersonaCuentaBancaria(PersonaCuentaBancaria personaCuentaBancaria) {
        this.personaCuentaBancaria = personaCuentaBancaria;
    }

    public EmpresaCuentaBancaria getEmpresaCuentaBancaria() {
        return empresaCuentaBancaria;
    }

    public void setEmpresaCuentaBancaria(EmpresaCuentaBancaria empresaCuentaBancaria) {
        this.empresaCuentaBancaria = empresaCuentaBancaria;
    }

    public DocumentoExterno getDocumentoExterno() {
        return documentoExterno;
    }

    public void setDocumentoExterno(DocumentoExterno documentoExterno) {
        this.documentoExterno = documentoExterno;
    }

    public DocumentoExterno getDocumentoGuiaRemision() {
        return documentoGuiaRemision;
    }

    public void setDocumentoGuiaRemision(DocumentoExterno documentoGuiaRemision) {
        this.documentoGuiaRemision = documentoGuiaRemision;
    }

    public DocumentoEmitePersona getDocumentoEmitePersona() {
        return documentoEmitePersona;
    }

    public void setDocumentoEmitePersona(DocumentoEmitePersona documentoEmitePersona) {
        this.documentoEmitePersona = documentoEmitePersona;
    }

    public DocumentoEmitePersona getDocumentoSuspensionRetenciones() {
        return documentoSuspensionRetenciones;
    }

    public void setDocumentoSuspensionRetenciones(DocumentoEmitePersona documentoSuspensionRetenciones) {
        this.documentoSuspensionRetenciones = documentoSuspensionRetenciones;
    }

}
