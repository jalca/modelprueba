package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import pe.edu.lamolina.model.constantines.GlobalConstantine;

@Entity
@Table(name = "alumnos", catalog = GlobalConstantine.SCHEMA_CROACIA)
public class AlumnosMy implements Serializable, Cloneable {

    @Id
    @Column(name = "MATRICULA")
    private String matricula;

    @NotNull
    @Column(name = "ALU_NOMBRE")
    private String aluNombre;

    @Column(name = "ESP_GRAD")
    private String espGrad;

    @Column(name = "FAC_CODIGO")
    private String facCodigo;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "PRO_CODIGO")
    private String proCodigo;

    @Column(name = "SITUACION")
    private String situacion;

    @Column(name = "CICLO_ULT")
    private String cicloUlt;

    @Column(name = "CICLO_R")
    private String cicloR;

    @Column(name = "CURRICULA")
    private String curricula;

    @Column(name = "PERSO")
    private Integer perso;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USUARIO")
    private String usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "CAMBIO_CURRICULA")
    private String cambioCurricula;

    @Column(name = "FL_NO_CENSADO")
    private String flNoCensado;

    @Column(name = "CONVENIO")
    private String convenio;

    @Column(name = "BECA")
    private String beca;

    @Column(name = "BEMI")
    private String bemi;

    @Column(name = "RENUNCIA")
    private String renuncia;

    @Column(name = "ESP_ANTERIOR")
    private Short espAnterior;

    @Column(name = "PRONABEC")
    private String pronabec;

    @Column(name = "IND_HISTORIAL_PROCESADO")
    private Boolean indHistorialProcesado;

    public AlumnosMy() {
    }

    public AlumnosMy(String matricula) {
        this.matricula = matricula;
    }

    public AlumnosMy(String matricula, String aluNombre) {
        this.matricula = matricula;
        this.aluNombre = aluNombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAluNombre() {
        return aluNombre;
    }

    public void setAluNombre(String aluNombre) {
        this.aluNombre = aluNombre;
    }

    public String getEspGrad() {
        return espGrad;
    }

    public void setEspGrad(String espGrad) {
        this.espGrad = espGrad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCambioCurricula() {
        return cambioCurricula;
    }

    public void setCambioCurricula(String cambioCurricula) {
        this.cambioCurricula = cambioCurricula;
    }

    public String getFlNoCensado() {
        return flNoCensado;
    }

    public void setFlNoCensado(String flNoCensado) {
        this.flNoCensado = flNoCensado;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getBemi() {
        return bemi;
    }

    public void setBemi(String bemi) {
        this.bemi = bemi;
    }

    public String getRenuncia() {
        return renuncia;
    }

    public void setRenuncia(String renuncia) {
        this.renuncia = renuncia;
    }

    public Short getEspAnterior() {
        return espAnterior;
    }

    public void setEspAnterior(Short espAnterior) {
        this.espAnterior = espAnterior;
    }

    public String getPronabec() {
        return pronabec;
    }

    public void setPronabec(String pronabec) {
        this.pronabec = pronabec;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getCicloUlt() {
        return cicloUlt;
    }

    public void setCicloUlt(String cicloUlt) {
        this.cicloUlt = cicloUlt;
    }

    public String getCicloR() {
        return cicloR;
    }

    public void setCicloR(String cicloR) {
        this.cicloR = cicloR;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public Integer getPerso() {
        return perso;
    }

    public void setPerso(Integer perso) {
        this.perso = perso;
    }

    @Override
    public AlumnosMy clone() {
        AlumnosMy clone = null;
        try {
            clone = (AlumnosMy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof AlumnosMy)) {
            return false;
        }
        AlumnosMy other = (AlumnosMy) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    public Boolean getIndHistorialProcesado() {
        return indHistorialProcesado;
    }

    public void setIndHistorialProcesado(Boolean indHistorialProcesado) {
        this.indHistorialProcesado = indHistorialProcesado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.oficina.academico.Alumnos[ matricula=" + matricula + " ]";
    }

}
