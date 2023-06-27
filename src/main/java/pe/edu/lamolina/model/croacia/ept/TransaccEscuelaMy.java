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
import pe.edu.lamolina.model.enums.croacia.ConceptoDeudaEnum;

@Entity
@Table(name = "ept_transacc_escuela", catalog = "croacia")
public class TransaccEscuelaMy implements Serializable {

    
    @EmbeddedId
    protected TransaccEscuelaMyPK transaccEscuelaPK;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "INSCRITO")
    private String inscrito;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "EPG_CODIGO")
    private String epgCodigo;

    @Column(name = "ANUAL_BCO")
    private String anualBco;

    @Column(name = "TRANSACC_BCO")
    private Long transaccBco;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "TIPO_PAGO")
    private String tipoPago;

    @Column(name = "USUARIO_CREADO")
    private String usuarioCreado;

    @Column(name = "FECHA_CREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreado;

    @Column(name = "ANULADO")
    private String anulado;

    @Column(name = "USUARIO_ANULA")
    private String usuarioAnula;

    @Column(name = "FECHA_ANULA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnula;

    @Column(name = "PERSO")
    private Integer perso;

    @Column(name = "MONTO_USADO")
    private BigDecimal montoUsado;

    public TransaccEscuelaMy() {
    }

    public TransaccEscuelaMy(TransaccEscuelaMyPK transaccEscuelaPK) {
        this.transaccEscuelaPK = transaccEscuelaPK;
    }

    public TransaccEscuelaMy(String anual, int transacc) {
        this.transaccEscuelaPK = new TransaccEscuelaMyPK(anual, transacc);
    }

    public TransaccEscuelaMyPK getTransaccEscuelaPK() {
        return transaccEscuelaPK;
    }

    public void setTransaccEscuelaPK(TransaccEscuelaMyPK transaccEscuelaPK) {
        this.transaccEscuelaPK = transaccEscuelaPK;
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

    public String getAnualBco() {
        return anualBco;
    }

    public void setAnualBco(String anualBco) {
        this.anualBco = anualBco;
    }

    public Long getTransaccBco() {
        return transaccBco;
    }

    public void setTransaccBco(Long transaccBco) {
        this.transaccBco = transaccBco;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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

    public BigDecimal getMontoUsado() {
        return montoUsado;
    }

    public void setMontoUsado(BigDecimal montoUsado) {
        this.montoUsado = montoUsado;
    }

    public boolean isAnulado() {
        return BigDecimal.ONE.toString().equals(this.anulado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccEscuelaPK != null ? transaccEscuelaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof TransaccEscuelaMy)) {
            return false;
        }
        TransaccEscuelaMy other = (TransaccEscuelaMy) object;
        if ((this.transaccEscuelaPK == null && other.transaccEscuelaPK != null) || (this.transaccEscuelaPK != null && !this.transaccEscuelaPK.equals(other.transaccEscuelaPK))) {
            return false;
        }
        return true;
    }

    public boolean isTipoPagoMatricula() {
        return ConceptoDeudaEnum.MAT.name().equals(this.getTipoPago());
    }

    public boolean isTipoPagoEnsenanza() {
        return ConceptoDeudaEnum.ENZ.name().equals(this.getTipoPago());
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.ept.TransaccEscuela[ transaccEscuelaPK=" + transaccEscuelaPK + " ]";
    }

}
