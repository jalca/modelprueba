package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Table(name = "ofi_cursos", catalog = GlobalConstantine.SCHEMA_CROACIA)
public class CursosMy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CUR_CODIGO")
    private String curCodigo;

    @Column(name = "CUR_NOMBRE")
    private String curNombre;

    @Column(name = "CUR_NUEVO")
    private String curNuevo;

    @Column(name = "TCURSO")
    private String tcurso;

    @Column(name = "DEP_CODIGO")
    private String depCodigo;

    @Column(name = "CUR_TEORIA")
    private Integer curTeoria;

    @Column(name = "CUR_PRACTI")
    private Integer curPracti;

    @Column(name = "CUR_CREVAR")
    private String curCrevar;

    @Column(name = "CUR_CREDIT")
    private Integer curCredit;

    @Column(name = "NO_ENC")
    private String noEnc;

    @Column(name = "CREDITOS")
    private Integer creditos;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "ACTIVO")
    private String activo;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "SEMESTRE")
    private String semestre;

    @Column(name = "CUR_INGLES")
    private String curIngles;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "TEO_VERANO")
    private Integer teoVerano;

    @Column(name = "PRA_VERANO")
    private Integer praVerano;

    @Column(name = "TEO_INVIERNO")
    private Integer teoInvierno;

    @Column(name = "PRA_INVIERNO")
    private Integer praInvierno;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "ID_RESOLUC")
    private String idResoluc;

    @Size(max = 3)
    @Column(name = "VECES_LLEVAR")
    private String vecesLlevar;

    @Column(name = "TIPO_MODULO")
    private String tipoModulo;

    @Column(name = "RES_FACULTAD")
    private String resFacultad;

    @Column(name = "RES_CONSEJO")
    private String resConsejo;

    @Column(name = "VER_REQUISITO")
    private String verRequisito;

    @Column(name = "C_SISEVA")
    private String cSiseva;

    @Size(max = 3)
    @Column(name = "C_SUBSIS")
    private String cSubsis;

    @Column(name = "CONVENIO")
    private String convenio;

    public CursosMy() {
    }

    public CursosMy(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public CursosMy(String curCodigo, String curNuevo) {
        this.curCodigo = curCodigo;
        this.curNuevo = curNuevo;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public String getCurNuevo() {
        return curNuevo;
    }

    public void setCurNuevo(String curNuevo) {
        this.curNuevo = curNuevo;
    }

    public String getTcurso() {
        return tcurso;
    }

    public void setTcurso(String tcurso) {
        this.tcurso = tcurso;
    }

    public String getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(String depCodigo) {
        this.depCodigo = depCodigo;
    }

    public Integer getCurTeoria() {
        return curTeoria;
    }

    public void setCurTeoria(Integer curTeoria) {
        this.curTeoria = curTeoria;
    }

    public Integer getCurPracti() {
        return curPracti;
    }

    public void setCurPracti(Integer curPracti) {
        this.curPracti = curPracti;
    }

    public String getCurCrevar() {
        return curCrevar;
    }

    public void setCurCrevar(String curCrevar) {
        this.curCrevar = curCrevar;
    }

    public Integer getCurCredit() {
        return curCredit;
    }

    public void setCurCredit(Integer curCredit) {
        this.curCredit = curCredit;
    }

    public String getNoEnc() {
        return noEnc;
    }

    public void setNoEnc(String noEnc) {
        this.noEnc = noEnc;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCurIngles() {
        return curIngles;
    }

    public void setCurIngles(String curIngles) {
        this.curIngles = curIngles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTeoVerano() {
        return teoVerano;
    }

    public void setTeoVerano(Integer teoVerano) {
        this.teoVerano = teoVerano;
    }

    public Integer getPraVerano() {
        return praVerano;
    }

    public void setPraVerano(Integer praVerano) {
        this.praVerano = praVerano;
    }

    public Integer getTeoInvierno() {
        return teoInvierno;
    }

    public void setTeoInvierno(Integer teoInvierno) {
        this.teoInvierno = teoInvierno;
    }

    public Integer getPraInvierno() {
        return praInvierno;
    }

    public void setPraInvierno(Integer praInvierno) {
        this.praInvierno = praInvierno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdResoluc() {
        return idResoluc;
    }

    public void setIdResoluc(String idResoluc) {
        this.idResoluc = idResoluc;
    }

    public String getVecesLlevar() {
        return vecesLlevar;
    }

    public void setVecesLlevar(String vecesLlevar) {
        this.vecesLlevar = vecesLlevar;
    }

    public String getTipoModulo() {
        return tipoModulo;
    }

    public void setTipoModulo(String tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    public String getResFacultad() {
        return resFacultad;
    }

    public void setResFacultad(String resFacultad) {
        this.resFacultad = resFacultad;
    }

    public String getResConsejo() {
        return resConsejo;
    }

    public void setResConsejo(String resConsejo) {
        this.resConsejo = resConsejo;
    }

    public String getVerRequisito() {
        return verRequisito;
    }

    public void setVerRequisito(String verRequisito) {
        this.verRequisito = verRequisito;
    }

    public String getCSiseva() {
        return cSiseva;
    }

    public void setCSiseva(String cSiseva) {
        this.cSiseva = cSiseva;
    }

    public String getCSubsis() {
        return cSubsis;
    }

    public void setCSubsis(String cSubsis) {
        this.cSubsis = cSubsis;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosMy)) {
            return false;
        }
        CursosMy other = (CursosMy) object;
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.oficina.CursosMy[ curCodigo=" + curCodigo + " ]";
    }

}
