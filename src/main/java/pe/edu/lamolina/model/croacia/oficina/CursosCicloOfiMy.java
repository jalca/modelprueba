package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ofi_cursos_ciclo", catalog = "croacia")
public class CursosCicloOfiMy implements Serializable {

    

    @EmbeddedId
    protected CursosCicloOfiMyPK cursosCicloOficinaMyPK;

    @Column(name = "HORAS_TEORIA")
    private Integer horasTeoria;

    @Column(name = "HORAS_PRACTICA")
    private Integer horasPractica;

    @Column(name = "CREDITOS")
    private Integer creditos;

    @Column(name = "CREDIT_VARIABLE")
    private Integer creditVariable;

    @Column(name = "CREDITOS_REQUISITO")
    private Integer creditosRequisito;

    @Column(name = "NO_EXAM")
    private String noExam;

    @Column(name = "TCURSO")
    private String tcurso;

    @Column(name = "MODO_AULA_TEO")
    private String modoAulaTeo;

    @Column(name = "MODO_AULA_PRA")
    private String modoAulaPra;

    @Column(name = "VECES_LLEVAR")
    private Integer vecesLlevar;

    @Column(name = "TIPO_MODULAR")
    private String tipoModular;

    @Column(name = "NOCONSIDERAR_CA")
    private String noconsiderarCa;

    @Column(name = "CRED_TEORIA")
    private Integer credTeoria;

    @Column(name = "CRED_PRACTICA")
    private Integer credPractica;

    @Column(name = "NO_ENC")
    private String noEnc;

    public CursosCicloOfiMy() {
    }

    public CursosCicloOfiMy(CursosCicloOfiMyPK cursosCicloOficinaMyPK) {
        this.cursosCicloOficinaMyPK = cursosCicloOficinaMyPK;
    }

    public CursosCicloOfiMy(String ciclo, String curCodigo) {
        this.cursosCicloOficinaMyPK = new CursosCicloOfiMyPK(ciclo, curCodigo);
    }

    public CursosCicloOfiMyPK getCursosCicloOficinaMyPK() {
        return cursosCicloOficinaMyPK;
    }

    public void setCursosCicloOficinaMyPK(CursosCicloOfiMyPK cursosCicloOficinaMyPK) {
        this.cursosCicloOficinaMyPK = cursosCicloOficinaMyPK;
    }

    public Integer getHorasTeoria() {
        return horasTeoria;
    }

    public void setHorasTeoria(Integer horasTeoria) {
        this.horasTeoria = horasTeoria;
    }

    public Integer getHorasPractica() {
        return horasPractica;
    }

    public void setHorasPractica(Integer horasPractica) {
        this.horasPractica = horasPractica;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCreditVariable() {
        return creditVariable;
    }

    public void setCreditVariable(Integer creditVariable) {
        this.creditVariable = creditVariable;
    }

    public Integer getCreditosRequisito() {
        return creditosRequisito;
    }

    public void setCreditosRequisito(Integer creditosRequisito) {
        this.creditosRequisito = creditosRequisito;
    }

    public String getNoExam() {
        return noExam;
    }

    public void setNoExam(String noExam) {
        this.noExam = noExam;
    }

    public String getTcurso() {
        return tcurso;
    }

    public void setTcurso(String tcurso) {
        this.tcurso = tcurso;
    }

    public String getModoAulaTeo() {
        return modoAulaTeo;
    }

    public void setModoAulaTeo(String modoAulaTeo) {
        this.modoAulaTeo = modoAulaTeo;
    }

    public String getModoAulaPra() {
        return modoAulaPra;
    }

    public void setModoAulaPra(String modoAulaPra) {
        this.modoAulaPra = modoAulaPra;
    }

    public Integer getVecesLlevar() {
        return vecesLlevar;
    }

    public void setVecesLlevar(Integer vecesLlevar) {
        this.vecesLlevar = vecesLlevar;
    }

    public String getTipoModular() {
        return tipoModular;
    }

    public void setTipoModular(String tipoModular) {
        this.tipoModular = tipoModular;
    }

    public String getNoconsiderarCa() {
        return noconsiderarCa;
    }

    public void setNoconsiderarCa(String noconsiderarCa) {
        this.noconsiderarCa = noconsiderarCa;
    }

    public Integer getCredTeoria() {
        return credTeoria;
    }

    public void setCredTeoria(Integer credTeoria) {
        this.credTeoria = credTeoria;
    }

    public Integer getCredPractica() {
        return credPractica;
    }

    public void setCredPractica(Integer credPractica) {
        this.credPractica = credPractica;
    }

    public String getNoEnc() {
        return noEnc;
    }

    public void setNoEnc(String noEnc) {
        this.noEnc = noEnc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursosCicloOficinaMyPK != null ? cursosCicloOficinaMyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CursosCicloOfiMy)) {
            return false;
        }
        CursosCicloOfiMy other = (CursosCicloOfiMy) object;
        if ((this.cursosCicloOficinaMyPK == null && other.cursosCicloOficinaMyPK != null) || (this.cursosCicloOficinaMyPK != null && !this.cursosCicloOficinaMyPK.equals(other.cursosCicloOficinaMyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.oficina.CursosCicloOficinaMy[ cursosCicloOficinaMyPK=" + cursosCicloOficinaMyPK + " ]";
    }

}
