package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.aporte.ItemSaldoAfavor;
import pe.edu.lamolina.model.enums.TipoDepositoEnum;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.posgrado.admision.PostulanteEscuela;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "fin_item_carga_abono")
public class ItemCargaAbono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_abono_recauda")
    private Long idAbonoRecauda;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "redundante")
    private Integer redundante;

    @Column(name = "extornado")
    private Integer extornado;

    @Column(name = "es_extorno ")
    private Integer esExtorno;

    @Column(name = "utilizado")
    private Integer utilizado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "numero_operacion")
    private String numeroOperacion;

    @Column(name = "numero_operacion_canal")
    private String numeroOperacionCanal;

    @Column(name = "sucursal")
    private String sucursal;

    @Column(name = "usuario_banco")
    private String usuarioBanco;

    @Column(name = "banco_origen")
    private String bancoOrigen;

    @Column(name = "tipo_deposito")
    private String tipoDeposito;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAbono;

    @Column(name = "fecha_extornado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExtornado;

    @Column(name = "fecha_impresion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaImpresion;

    @Column(name = "fecha_utilizado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaUtilizado;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_acreencia")
    private Acreencia acreencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carga_abonos")
    private CargaAbonos cargaAbonos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_pago")
    private ConceptoPago conceptoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_no_redundante")
    private ItemCargaAbono noRedundante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_extornador")
    private ItemCargaAbono extornador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_saldo_afavor")
    private ItemSaldoAfavor itemSaldoAfavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_extornado")
    private Usuario usuarioExtornado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_utilizado")
    private Usuario usuarioUtilizado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_impresion")
    private Usuario usuarioImpresion;

    @OneToMany(mappedBy = "abono", fetch = FetchType.LAZY)
    private List<AbonoPostulante> abonoPostulante;

    @OneToMany(mappedBy = "noRedundante", fetch = FetchType.LAZY)
    private List<ItemCargaAbono> itemCargaAbono;

    @Transient
    private boolean validado;
    @Transient
    private Integer linea;
    @Transient
    private Integer afectadoExtorno;

    public ItemCargaAbono() {
        validado = false;
        this.esExtorno = BigDecimal.ZERO.intValue();
        this.tipoDeposito = TipoDepositoEnum.DEP.name();
    }

    public ItemCargaAbono(Object id) {
        this.id = TypesUtil.getLong(id);
        validado = false;
        this.tipoDeposito = TipoDepositoEnum.DEP.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CargaAbonos getCargaAbonos() {
        return cargaAbonos;
    }

    public void setCargaAbonos(CargaAbonos cargaAbonos) {
        this.cargaAbonos = cargaAbonos;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public DateTime getFechaAbonoDateTime() {
        return new DateTime(this.fechaAbono);
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public ConceptoPago getConceptoPago() {
        return conceptoPago;
    }

    public void setConceptoPago(ConceptoPago conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public Integer getRedundante() {
        return redundante;
    }

    public void setRedundante(Integer redundante) {
        this.redundante = redundante;
    }

    public ItemCargaAbono getNoRedundante() {
        return noRedundante;
    }

    public void setNoRedundante(ItemCargaAbono noRedundante) {
        this.noRedundante = noRedundante;
    }

    public Integer getExtornado() {
        return extornado;
    }

    public void setExtornado(Integer extornado) {
        this.extornado = extornado;
    }

    public Date getFechaExtornado() {
        return fechaExtornado;
    }

    public void setFechaExtornado(Date fechaExtornado) {
        this.fechaExtornado = fechaExtornado;
    }

    public Integer getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(Integer utilizado) {
        this.utilizado = utilizado;
    }

    public Date getFechaUtilizado() {
        return fechaUtilizado;
    }

    public void setFechaUtilizado(Date fechaUtilizado) {
        this.fechaUtilizado = fechaUtilizado;
    }

    public List<AbonoPostulante> getAbonoPostulante() {
        return abonoPostulante;
    }

    public void setAbonoPostulante(List<AbonoPostulante> abonoPostulante) {
        this.abonoPostulante = abonoPostulante;
    }

    public List<ItemCargaAbono> getItemCargaAbono() {
        return itemCargaAbono;
    }

    public void setItemCargaAbono(List<ItemCargaAbono> itemCargaAbono) {
        this.itemCargaAbono = itemCargaAbono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getUsuarioBanco() {
        return usuarioBanco;
    }

    public void setUsuarioBanco(String usuarioBanco) {
        this.usuarioBanco = usuarioBanco;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Usuario getUsuarioExtornado() {
        return usuarioExtornado;
    }

    public void setUsuarioExtornado(Usuario usuarioExtornado) {
        this.usuarioExtornado = usuarioExtornado;
    }

    public Usuario getUsuarioUtilizado() {
        return usuarioUtilizado;
    }

    public void setUsuarioUtilizado(Usuario usuarioUtilizado) {
        this.usuarioUtilizado = usuarioUtilizado;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public Usuario getUsuarioImpresion() {
        return usuarioImpresion;
    }

    public void setUsuarioImpresion(Usuario usuarioImpresion) {
        this.usuarioImpresion = usuarioImpresion;
    }

    public ItemCargaAbono getExtornador() {
        return extornador;
    }

    public void setExtornador(ItemCargaAbono extornador) {
        this.extornador = extornador;
    }

    public Integer getAfectadoExtorno() {
        return afectadoExtorno;
    }

    public void setAfectadoExtorno(Integer afectadoExtorno) {
        this.afectadoExtorno = afectadoExtorno;
    }

    public Long getIdAbonoRecauda() {
        return idAbonoRecauda;
    }

    public void setIdAbonoRecauda(Long idAbonoRecauda) {
        this.idAbonoRecauda = idAbonoRecauda;
    }

    public Acreencia getAcreencia() {
        return acreencia;
    }

    public void setAcreencia(Acreencia acreencia) {
        this.acreencia = acreencia;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEsExtorno() {
        return esExtorno;
    }

    public void setEsExtorno(Integer esExtorno) {
        this.esExtorno = esExtorno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PostulanteEscuela getPostulanteEscuela() {
        return postulanteEscuela;
    }

    public void setPostulanteEscuela(PostulanteEscuela postulanteEscuela) {
        this.postulanteEscuela = postulanteEscuela;
    }

    public String getNumeroOperacionCanal() {
        return numeroOperacionCanal;
    }

    public void setNumeroOperacionCanal(String numeroOperacionCanal) {
        this.numeroOperacionCanal = numeroOperacionCanal;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }

    public TipoDepositoEnum getTipoDepositoEnum() {
        if (StringUtils.isBlank(this.tipoDeposito)) {
            return null;
        }
        return TipoDepositoEnum.valueOf(this.tipoDeposito);
    }

    @JsonIgnore
    public void setTipoDepositoEnum(TipoDepositoEnum tipoDepositoEnum) {
        if (tipoDepositoEnum != null) {
            this.tipoDeposito = tipoDepositoEnum.name();
        }
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    public ItemSaldoAfavor getItemSaldoAfavor() {
        return itemSaldoAfavor;
    }

    public void setItemSaldoAfavor(ItemSaldoAfavor itemSaldoAfavor) {
        this.itemSaldoAfavor = itemSaldoAfavor;
    }

}
