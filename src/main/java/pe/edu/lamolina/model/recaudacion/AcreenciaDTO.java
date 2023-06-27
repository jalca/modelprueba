package pe.edu.lamolina.model.recaudacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AcreenciaDTO implements Serializable {

    private Integer esExtorno;
    private Integer esAnulacion;

    //Deuda
    private Long idAcreenciaLamo;
    private Date fechaAnulacion;
    private Date fechaGeneracion;
    private Date fechaVencimiento;
    private Date fechaDocumento;
    private Date fechaEmision;
    private Date fechaPreinicioMora;
    private BigDecimal montoBase;
    private BigDecimal montoTotal;
    private BigDecimal moraDiaria;
    private String estado;

    private Boolean reenvio; // reenvio add column
    private BigDecimal mora; // reenvio add column

    //persona
    private Long idPersonaLamo;
    private String paterno;
    private String materno;
    private String nombres;
    private String sexo;
    private String email;
    private String emailCompania;
    private String celular;
    private String telefono;
    private String dni;
    private String tipoDocumento;
    private String estadoPersona;

    //concepto
    //  private Long idConceptoLamo;
    private String nombreConceptoLamo;

    //servicio
    private Long idCuentaBancariaLamo;
    private String nombreServicio;
    private String empresaServicio;
    private String bancoServicio;
    private String numeroServicio;

    //
    private String numeroOperacionCanal;
    private String numeroOperacion;
    private String numeroOperacionExtornar;
    private String sucursal;
    private String usuarioBanco;
    private Date fechaAbono;
    private String referenciaOperacion;
    private Long idAbonoRecauda;
    private Long idAbonoRecaudaExtornado;
    private String codigoServicioWs;
    private String sufijoCola;

    public AcreenciaDTO() {
        this.esAnulacion = BigDecimal.ZERO.intValue();
        this.esExtorno = BigDecimal.ZERO.intValue();
        this.reenvio = false;
    }

    public Long getIdAcreenciaLamo() {
        return idAcreenciaLamo;
    }

    public void setIdAcreenciaLamo(Long idAcreenciaLamo) {
        this.idAcreenciaLamo = idAcreenciaLamo;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(BigDecimal montoBase) {
        this.montoBase = montoBase;
    }

    public BigDecimal getMoraDiaria() {
        return moraDiaria;
    }

    public void setMoraDiaria(BigDecimal moraDiaria) {
        this.moraDiaria = moraDiaria;
    }

    public Date getFechaPreinicioMora() {
        return fechaPreinicioMora;
    }

    public void setFechaPreinicioMora(Date fechaPreinicioMora) {
        this.fechaPreinicioMora = fechaPreinicioMora;
    }

    public Long getIdPersonaLamo() {
        return idPersonaLamo;
    }

    public void setIdPersonaLamo(Long idPersonaLamo) {
        this.idPersonaLamo = idPersonaLamo;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCompania() {
        return emailCompania;
    }

    public void setEmailCompania(String emailCompania) {
        this.emailCompania = emailCompania;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreConceptoLamo() {
        return nombreConceptoLamo;
    }

    public void setNombreConceptoLamo(String nombreConceptoLamo) {
        this.nombreConceptoLamo = nombreConceptoLamo;
    }

    public Long getIdCuentaBancariaLamo() {
        return idCuentaBancariaLamo;
    }

    public void setIdCuentaBancariaLamo(Long idCuentaBancariaLamo) {
        this.idCuentaBancariaLamo = idCuentaBancariaLamo;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getEmpresaServicio() {
        return empresaServicio;
    }

    public void setEmpresaServicio(String empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    public String getBancoServicio() {
        return bancoServicio;
    }

    public void setBancoServicio(String bancoServicio) {
        this.bancoServicio = bancoServicio;
    }

    public String getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(String numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getNumeroOperacionExtornar() {
        return numeroOperacionExtornar;
    }

    public void setNumeroOperacionExtornar(String numeroOperacionExtornar) {
        this.numeroOperacionExtornar = numeroOperacionExtornar;
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

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public String getReferenciaOperacion() {
        return referenciaOperacion;
    }

    public void setReferenciaOperacion(String referenciaOperacion) {
        this.referenciaOperacion = referenciaOperacion;
    }

    public Long getIdAbonoRecauda() {
        return idAbonoRecauda;
    }

    public void setIdAbonoRecauda(Long idAbonoRecauda) {
        this.idAbonoRecauda = idAbonoRecauda;
    }

    public String getCodigoServicioWs() {
        return codigoServicioWs;
    }

    public void setCodigoServicioWs(String codigoServicioWs) {
        this.codigoServicioWs = codigoServicioWs;
    }

    public Integer getEsExtorno() {
        return esExtorno;
    }

    public void setEsExtorno(Integer esExtorno) {
        this.esExtorno = esExtorno;
    }

    public Long getIdAbonoRecaudaExtornado() {
        return idAbonoRecaudaExtornado;
    }

    public void setIdAbonoRecaudaExtornado(Long idAbonoRecaudaExtornado) {
        this.idAbonoRecaudaExtornado = idAbonoRecaudaExtornado;
    }

    public Integer getEsAnulacion() {
        return esAnulacion;
    }

    public void setEsAnulacion(Integer esAnulacion) {
        this.esAnulacion = esAnulacion;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public boolean isExtorno() {
        if (this.getEsExtorno().intValue() == BigDecimal.ONE.intValue()) {
            return true;
        }
        return false;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public boolean isAnulacion() {
        if (this.getEsAnulacion().intValue() == BigDecimal.ONE.intValue()) {
            return true;
        }
        return false;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(String estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getSufijoCola() {
        return sufijoCola;
    }

    public void setSufijoCola(String sufijoCola) {
        this.sufijoCola = sufijoCola;
    }

    public Boolean getReenvio() {
        return reenvio;
    }

    public void setReenvio(Boolean reenvio) {
        this.reenvio = reenvio;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNumeroOperacionCanal() {
        return numeroOperacionCanal;
    }

    public void setNumeroOperacionCanal(String numeroOperacionCanal) {
        this.numeroOperacionCanal = numeroOperacionCanal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
