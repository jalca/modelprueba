package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ept_transacc_banco", catalog = "croacia")
public class TransaccBancoMy implements Serializable {

    

    @EmbeddedId
    protected TransaccBancoMyPK transaccBancoPK;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "INSCRITO")
    private String inscrito;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "EPG_CODIGO")
    private String epgCodigo;

    @Column(name = "VOUCHER")
    private String voucher;

    @Column(name = "FECHA_VOUCHER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVoucher;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "MONTO_ASIGNADO")
    private BigDecimal montoAsignado;

    @Column(name = "USUARIO_CREADO")
    private String usuarioCreado;

    @Column(name = "FECHA_CREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreado;

    @Size(max = 1)
    @Column(name = "ANULADO")
    private String anulado;

    @Size(max = 30)
    @Column(name = "USUARIO_ANULA")
    private String usuarioAnula;

    @Column(name = "FECHA_ANULA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnula;

    @Column(name = "PERSO")
    private Integer perso;

    @Size(max = 3)
    @Column(name = "TIPO_DEPOSITO")
    private String tipoDeposito;

    @Column(name = "CTA")
    private Integer cta;

    @Column(name = "CTA2")
    private Integer cta2;

    public TransaccBancoMy() {
    }

    public TransaccBancoMy(TransaccBancoMyPK transaccBancoPK) {
        this.transaccBancoPK = transaccBancoPK;
    }

    public TransaccBancoMy(String anual, Long transacc) {
        this.transaccBancoPK = new TransaccBancoMyPK(anual, transacc);
    }

    public TransaccBancoMyPK getTransaccBancoPK() {
        return transaccBancoPK;
    }

    public void setTransaccBancoPK(TransaccBancoMyPK transaccBancoPK) {
        this.transaccBancoPK = transaccBancoPK;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getInscrito() {
        return inscrito;
    }

    public void setInscrito(String inscrito) {
        this.inscrito = inscrito;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEpgCodigo() {
        return epgCodigo;
    }

    public void setEpgCodigo(String epgCodigo) {
        this.epgCodigo = epgCodigo;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Date getFechaVoucher() {
        return fechaVoucher;
    }

    public void setFechaVoucher(Date fechaVoucher) {
        this.fechaVoucher = fechaVoucher;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoAsignado() {
        return montoAsignado;
    }

    public void setMontoAsignado(BigDecimal montoAsignado) {
        this.montoAsignado = montoAsignado;
    }

    public String getUsuarioCreado() {
        return usuarioCreado;
    }

    public void setUsuarioCreado(String usuarioCreado) {
        this.usuarioCreado = usuarioCreado;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getAnulado() {
        return anulado;
    }

    public void setAnulado(String anulado) {
        this.anulado = anulado;
    }

    public String getUsuarioAnula() {
        return usuarioAnula;
    }

    public void setUsuarioAnula(String usuarioAnula) {
        this.usuarioAnula = usuarioAnula;
    }

    public Date getFechaAnula() {
        return fechaAnula;
    }

    public void setFechaAnula(Date fechaAnula) {
        this.fechaAnula = fechaAnula;
    }

    public Integer getPerso() {
        return perso;
    }

    public void setPerso(Integer perso) {
        this.perso = perso;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }

    public Integer getCta() {
        return cta;
    }

    public void setCta(Integer cta) {
        this.cta = cta;
    }

    public Integer getCta2() {
        return cta2;
    }

    public void setCta2(Integer cta2) {
        this.cta2 = cta2;
    }

    public boolean isAnulado() {
        return BigDecimal.ONE.toString().equals(this.anulado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccBancoPK != null ? transaccBancoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof TransaccBancoMy)) {
            return false;
        }
        TransaccBancoMy other = (TransaccBancoMy) object;
        if ((this.transaccBancoPK == null && other.transaccBancoPK != null) || (this.transaccBancoPK != null && !this.transaccBancoPK.equals(other.transaccBancoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.ept.TransaccBanco[ transaccBancoPK=" + transaccBancoPK + " ]";
    }

}
