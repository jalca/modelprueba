package pe.edu.lamolina.model.croacia;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "ofi_histo_grad", catalog = "croacia")
public class HistoGradMy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "CICLO")
    private String ciclo;

    @NotNull
    @Column(name = "MATRICULA")
    private String matricula;

    @NotNull
    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @NotNull
    @Column(name = "MOV")
    private String mov;

//    @EmbeddedId
//    protected HistoGradMyPK histoGradPK;
    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Column(name = "NOTA")
    private String nota;

    @Column(name = "GRUPO")
    private String grupo;

    @Column(name = "FECHA_MOV")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;

    @Column(name = "NIVEL")
    private String nivel;

    @Column(name = "NROACTAS")
    private Integer nroactas;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "NRO_ACTA")
    private String nroActa;

    @NotNull
    @Column(name = "FLAG_APROBADO")
    private String flagAprobado;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "TMOV")
    private String tMov;

    @Column(name = "PRO_CODIGO")
    private String proCodigo;

    @Column(name = "CONSEJERO")
    private String consejero;

    @Transient
    private String tipoRegistroOracle;

    public HistoGradMy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getNroactas() {
        return nroactas;
    }

    public void setNroactas(Integer nroactas) {
        this.nroactas = nroactas;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
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

    public String getFlagAprobado() {
        return flagAprobado;
    }

    public void setFlagAprobado(String flagAprobado) {
        this.flagAprobado = flagAprobado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String gettMov() {
        return tMov;
    }

    public void settMov(String tMov) {
        this.tMov = tMov;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getConsejero() {
        return consejero;
    }

    public void setConsejero(String consejero) {
        this.consejero = consejero;
    }

    public String getTipoRegistroOracle() {
        return tipoRegistroOracle;
    }

    public void setTipoRegistroOracle(String tipoRegistroOracle) {
        this.tipoRegistroOracle = tipoRegistroOracle;
    }

}
