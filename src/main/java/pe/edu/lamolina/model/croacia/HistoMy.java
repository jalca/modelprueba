package pe.edu.lamolina.model.croacia;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "histo", catalog = "croacia")
public class HistoMy implements Serializable {

    @EmbeddedId
    protected HistoMyPK histoPK;

    @Size(max = 10)
    @Column(name = "GRUPO")
    private String grupo;

    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Size(max = 2)
    @Column(name = "NOTA")
    private String nota;

    @Column(name = "FECHA_MOV")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;

    @Size(max = 30)
    @Column(name = "USUARIO")
    private String usuario;

    @Size(max = 7)
    @Column(name = "NRO_ACTA")
    private String nroActa;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TRIKA")
    private String trika;

    @Size(max = 70)
    @Column(name = "COMENTARIO")
    private String comentario;

    @Size(max = 2)
    @Column(name = "FLAG_APROBADO")
    private String flagAprobado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CNTDAD_VCES_LLEVA")
    private Integer cntdadVcesLleva;

    @Column(name = "TMOV")
    private String tMov;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "CONSEJERO")
    private String consejero;

    @Column(name = "TIPO")
    private String tipo;

    //histo grad
    @Transient
    private String proCodigo;
    @Transient
    private String tipoRegistroOracle;

    @Transient
    private Boolean indPosGrado;

    public HistoMy() {
    }

    public HistoMy(HistoMyPK histoPK) {
        this.histoPK = histoPK;
    }

    public HistoMyPK getHistoPK() {
        return histoPK;
    }

    public void setHistoPK(HistoMyPK histoPK) {
        this.histoPK = histoPK;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getCurCredit() {
        return curCredit;
    }

    public void setCurCredit(Integer curCredit) {
        this.curCredit = curCredit;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public String getFechaMovString() {
        if (this.getFechaMov() == null) {
            DateTime nullDate = new DateTime()
                    .withYear(2000)
                    .withMonthOfYear(DateTimeConstants.JANUARY)
                    .withDayOfMonth(BigDecimal.ONE.intValue())
                    .withTime(0, 0, 0, 0);
            return TypesUtil.getStringDate(nullDate.toDate(), "dd/MM/yyyy H:mm:ss");
        }
        String fechaMov = TypesUtil.getStringDate(this.getFechaMov(), "dd/MM/yyyy H:mm:ss");
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNroActa() {
        return nroActa;
    }

    public void setNroActa(String nroActa) {
        this.nroActa = nroActa;
    }

    public String getTrika() {
        return trika;
    }

    public void setTrika(String trika) {
        this.trika = trika;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFlagAprobado() {
        return flagAprobado;
    }

    public void setFlagAprobado(String flagAprobado) {
        this.flagAprobado = flagAprobado;
    }

    public Integer getCntdadVcesLleva() {
        return cntdadVcesLleva;
    }

    public void setCntdadVcesLleva(Integer cntdadVcesLleva) {
        this.cntdadVcesLleva = cntdadVcesLleva;
    }

    public String gettMov() {
        return tMov;
    }

    public void settMov(String tMov) {
        this.tMov = tMov;
    }

    public Integer getEstaAprobado() {
        return this.flagAprobado.equals("SI") ? 1 : 0;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public String getConsejero() {
        return consejero;
    }

    public void setConsejero(String consejero) {
        this.consejero = consejero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof HistoMy)) {
            return false;
        }
        HistoMy other = (HistoMy) object;
        if ((this.histoPK == null && other.histoPK != null) || (this.histoPK != null && !this.histoPK.equals(other.histoPK))) {
            return false;
        }
        return true;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Boolean getIndPosGrado() {
        return indPosGrado;
    }

    public void setIndPosGrado(Boolean indPosGrado) {
        this.indPosGrado = indPosGrado;
    }

    public boolean isRegistroActivo() {
        return Arrays.asList("1", "3").contains(this.getHistoPK().getMov());
    }

    public String getTipoRegistroOracle() {
        return tipoRegistroOracle;
    }

    public void setTipoRegistroOracle(String tipoRegistroOracle) {
        this.tipoRegistroOracle = tipoRegistroOracle;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.oficina.academico.Histo[ histoPK=" + histoPK + " ]";
    }

}
