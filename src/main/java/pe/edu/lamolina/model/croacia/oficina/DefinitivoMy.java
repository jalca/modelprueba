package pe.edu.lamolina.model.croacia.oficina;

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

@Entity
@Table(name = "definitivo", catalog = "croacia")
public class DefinitivoMy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "CLAVE")
    private String clave;

    @Column(name = "NRO_VAC")
    private Integer nroVac;

    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "REG_CREDIT")
    private Integer regCredit;

    @Column(name = "REG_RCUR")
    private String regRcur;

    @Column(name = "TCLAVE")
    private String tclave;

    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Column(name = "MOV")
    private String mov;

    @Column(name = "NRO")
    private Integer nro;

    @Column(name = "SIMULT")
    private String simult;

    @Column(name = "SIMULT_ULT")
    private String simultUlt;

    @Column(name = "CURZE_HOR")
    private String curzeHor;

    @Column(name = "NRO_CRUZES")
    private Integer nroCruzes;

    @Column(name = "TRANSACC")
    private Long transacc;

    @Column(name = "EVENTO")
    private String evento;

    @Column(name = "TRNSACC_PAGO")
    private Long transaccPago;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "TRIKA")
    private Integer trika;

    @Column(name = "TPO_CRSO_CRRCLA")
    private String tipoCursoCurricula;

    public DefinitivoMy() {
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getNroVac() {
        return nroVac;
    }

    public void setNroVac(Integer nroVac) {
        this.nroVac = nroVac;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getRegCredit() {
        return regCredit;
    }

    public void setRegCredit(Integer regCredit) {
        this.regCredit = regCredit;
    }

    public String getRegRcur() {
        return regRcur;
    }

    public void setRegRcur(String regRcur) {
        this.regRcur = regRcur;
    }

    public String getTclave() {
        return tclave;
    }

    public void setTclave(String tclave) {
        this.tclave = tclave;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public Integer getCurCredit() {
        return curCredit;
    }

    public void setCurCredit(Integer curCredit) {
        this.curCredit = curCredit;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public String getSimult() {
        return simult;
    }

    public void setSimult(String simult) {
        this.simult = simult;
    }

    public String getSimultUlt() {
        return simultUlt;
    }

    public void setSimultUlt(String simultUlt) {
        this.simultUlt = simultUlt;
    }

    public String getCurzeHor() {
        return curzeHor;
    }

    public void setCurzeHor(String curzeHor) {
        this.curzeHor = curzeHor;
    }

    public Integer getNroCruzes() {
        return nroCruzes;
    }

    public void setNroCruzes(Integer nroCruzes) {
        this.nroCruzes = nroCruzes;
    }

    public Long getTransacc() {
        return transacc;
    }

    public void setTransacc(Long transacc) {
        this.transacc = transacc;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Long getTransaccPago() {
        return transaccPago;
    }

    public void setTransaccPago(Long transaccPago) {
        this.transaccPago = transaccPago;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public Integer getTrika() {
        return trika;
    }

    public void setTrika(Integer trika) {
        this.trika = trika;
    }

    public String getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(String tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

}
