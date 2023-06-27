package pe.edu.lamolina.model.croacia.retiros;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "retiro_ciclo", catalog = "croacia")
public class RetiroCicloMy implements Serializable {

    

    @EmbeddedId
    private RetiroCicloMyPk retiroCicloMyPk;

    @Column(name = "CICLO")
    private String ciclo;

    @Column(name = "TRAMITE")
    private String tramite;

    @Column(name = "ANUAL")
    private String anual;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "ID_RESOLUC")
    private String idResoluc;

    @Column(name = "MODO")
    private String modo;

    @Column(name = "RECONSIDERA")
    private String reconsidera;

    @Column(name = "USR_GENERA")
    private String usrGenera;

    @Column(name = "USR_ASIGNA_RES")
    private String usrAsignaRes;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "FECHA_GENERA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaGenera;

    @Column(name = "FECHA_ASIGNA_RES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAsignaRes;

    public RetiroCicloMy() {
    }

    public RetiroCicloMy(RetiroCicloMyPk lejaniaAulasMyPk) {
        this.retiroCicloMyPk = lejaniaAulasMyPk;
    }

    public RetiroCicloMyPk getRetiroCicloMyPk() {
        return retiroCicloMyPk;
    }

    public void setRetiroCicloMyPk(RetiroCicloMyPk retiroCicloMyPk) {
        this.retiroCicloMyPk = retiroCicloMyPk;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdResoluc() {
        return idResoluc;
    }

    public void setIdResoluc(String idResoluc) {
        this.idResoluc = idResoluc;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getReconsidera() {
        return reconsidera;
    }

    public void setReconsidera(String reconsidera) {
        this.reconsidera = reconsidera;
    }

    public String getUsrGenera() {
        return usrGenera;
    }

    public void setUsrGenera(String usrGenera) {
        this.usrGenera = usrGenera;
    }

    public String getUsrAsignaRes() {
        return usrAsignaRes;
    }

    public void setUsrAsignaRes(String usrAsignaRes) {
        this.usrAsignaRes = usrAsignaRes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaGenera() {
        return fechaGenera;
    }

    public void setFechaGenera(Date fechaGenera) {
        this.fechaGenera = fechaGenera;
    }

    public Date getFechaAsignaRes() {
        return fechaAsignaRes;
    }

    public void setFechaAsignaRes(Date fechaAsignaRes) {
        this.fechaAsignaRes = fechaAsignaRes;
    }

}
