package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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

@Entity
@Table(name = "matriculables", catalog = "croacia")
public class MatriculablesMy implements Serializable {

    

    @EmbeddedId
    protected MatriculablesMyPK matriculablesPK;

    @Column(name = "PRIORIDAD")
    private Integer prioridad;

    @Column(name = "PRIORIDAD2")
    private Integer prioridad2;

    @Size(max = 1)
    @Column(name = "ULTIMO_CICLO")
    private String ultimoCiclo;

    @Column(name = "CRED_CONVALID")
    private Integer credConvalid;

    @Column(name = "CCS")
    private Integer ccs;

    @Column(name = "CCA")
    private Integer cca;

    @Column(name = "CAPS")
    private Integer caps;

    @Column(name = "CAPA")
    private Integer capa;

    @Column(name = "ESP_CODIGO")
    private String espCodigo;

    @Column(name = "PPS")
    private BigDecimal pps;

    @Column(name = "PUNTAJE")
    private BigDecimal puntaje;

    @Size(max = 3)
    @Column(name = "REZAGADO")
    private String rezagado;

    @Size(max = 4)
    @Column(name = "ORDEN")
    private String orden;

    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;

    @Size(max = 6)
    @Column(name = "HOR")
    private String hor;

    @Size(max = 1)
    @Column(name = "NO_RETIRARSE")
    private String noRetirarse;

    @Size(max = 100)
    @Column(name = "MENSAJE")
    private String mensaje;

    @Size(max = 1)
    @Column(name = "RES_MATRICULA")
    private String resMatricula;

    @Size(max = 1)
    @Column(name = "ASIGNAR_HABIL")
    private String asignarHabil;

    @Size(max = 150)
    @Column(name = "CAMBIO_PRIO")
    private String cambioPrio;

    @Size(max = 3)
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "BLOQUEADO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bloqueadoFecha;

    @Size(max = 30)
    @Column(name = "BLOQUEADO_USUARIO")
    private String bloqueadoUsuario;

    @Size(max = 1)
    @Column(name = "HABILITAR_ULT")
    private String habilitarUlt;

    @Size(max = 30)
    @Column(name = "HABILTAR_ULT_USER")
    private String habiltarUltUser;

    @Column(name = "HABILITAR_ULT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date habilitarUltFecha;

    @Size(max = 1)
    @Column(name = "EXTEMPORANEO")
    private String extemporaneo;

    @Column(name = "PIORIDADB")
    private Short pioridadb;

    @Size(max = 20)
    @Column(name = "COD_BARRA")
    private String codBarra;

    @Size(max = 200)
    @Column(name = "COMENTARIO")
    private String comentario;

    @Size(max = 30)
    @Column(name = "GENERA_USER")
    private String generaUser;

    @Column(name = "GENERA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generaFecha;

    @Size(max = 30)
    @Column(name = "REPRIORIZA_USER")
    private String repriorizaUser;

    @Column(name = "REPRIORIZA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repriorizaFecha;

    @Column(name = "REPRIORIZA_VECES")
    private BigDecimal repriorizaVeces;

    @Size(max = 100)
    @Column(name = "BLOQUEADO_SESSION_WEB")
    private String bloqueadoSessionWeb;

    @Size(max = 2)
    @Column(name = "FLAG_ENCSTA_EPG")
    private String flagEncstaEpg;

    @Column(name = "FCHA_ENCSTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fchaEncsta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CRSOS_MTRCLDOS")
    private Integer crsosMtrcldos;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CRDTOS_MTRCLDOS")
    private Integer crdtosMtrcldos;

    @Transient
    List<PromCiclosMy> promediosCiclos;

    public MatriculablesMy() {
    }

    public MatriculablesMy(MatriculablesMyPK matriculablesPK) {
        this.matriculablesPK = matriculablesPK;
    }

    public MatriculablesMy(MatriculablesMyPK matriculablesPK, Integer prioridad, Integer prioridad2, String ultimoCiclo, Integer credConvalid, Integer ccs, Integer cca, Integer caps, Integer capa, BigDecimal pps, BigDecimal puntaje, String rezagado, String orden, String activo, String hor, String noRetirarse, String mensaje, String resMatricula, String asignarHabil, String cambioPrio, String estado, Date bloqueadoFecha, String bloqueadoUsuario, String habilitarUlt, String habiltarUltUser, Date habilitarUltFecha, String extemporaneo, Short pioridadb, String codBarra, String comentario, String generaUser, Date generaFecha, String repriorizaUser, Date repriorizaFecha, BigDecimal repriorizaVeces, String bloqueadoSessionWeb, String flagEncstaEpg, Date fchaEncsta, Integer crsosMtrcldos, Integer crdtosMtrcldos) {
        this.matriculablesPK = matriculablesPK;
        this.prioridad = prioridad;
        this.prioridad2 = prioridad2;
        this.ultimoCiclo = ultimoCiclo;
        this.credConvalid = credConvalid;
        this.ccs = ccs;
        this.cca = cca;
        this.caps = caps;
        this.capa = capa;
        this.pps = pps;
        this.puntaje = puntaje;
        this.rezagado = rezagado;
        this.orden = orden;
        this.activo = activo;
        this.hor = hor;
        this.noRetirarse = noRetirarse;
        this.mensaje = mensaje;
        this.resMatricula = resMatricula;
        this.asignarHabil = asignarHabil;
        this.cambioPrio = cambioPrio;
        this.estado = estado;
        this.bloqueadoFecha = bloqueadoFecha;
        this.bloqueadoUsuario = bloqueadoUsuario;
        this.habilitarUlt = habilitarUlt;
        this.habiltarUltUser = habiltarUltUser;
        this.habilitarUltFecha = habilitarUltFecha;
        this.extemporaneo = extemporaneo;
        this.pioridadb = pioridadb;
        this.codBarra = codBarra;
        this.comentario = comentario;
        this.generaUser = generaUser;
        this.generaFecha = generaFecha;
        this.repriorizaUser = repriorizaUser;
        this.repriorizaFecha = repriorizaFecha;
        this.repriorizaVeces = repriorizaVeces;
        this.bloqueadoSessionWeb = bloqueadoSessionWeb;
        this.flagEncstaEpg = flagEncstaEpg;
        this.fchaEncsta = fchaEncsta;
        this.crsosMtrcldos = crsosMtrcldos;
        this.crdtosMtrcldos = crdtosMtrcldos;
    }

    public MatriculablesMyPK getMatriculablesPK() {
        return matriculablesPK;
    }

    public void setMatriculablesPK(MatriculablesMyPK matriculablesPK) {
        this.matriculablesPK = matriculablesPK;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPrioridad2() {
        return prioridad2;
    }

    public void setPrioridad2(Integer prioridad2) {
        this.prioridad2 = prioridad2;
    }

    public String getUltimoCiclo() {
        return ultimoCiclo;
    }

    public void setUltimoCiclo(String ultimoCiclo) {
        this.ultimoCiclo = ultimoCiclo;
    }

    public Integer getCredConvalid() {
        return credConvalid;
    }

    public void setCredConvalid(Integer credConvalid) {
        this.credConvalid = credConvalid;
    }

    public Integer getCcs() {
        return ccs;
    }

    public void setCcs(Integer ccs) {
        this.ccs = ccs;
    }

    public Integer getCca() {
        return cca;
    }

    public void setCca(Integer cca) {
        this.cca = cca;
    }

    public Integer getCaps() {
        return caps;
    }

    public void setCaps(Integer caps) {
        this.caps = caps;
    }

    public Integer getCapa() {
        return capa;
    }

    public void setCapa(Integer capa) {
        this.capa = capa;
    }

    public BigDecimal getPps() {
        return pps;
    }

    public void setPps(BigDecimal pps) {
        this.pps = pps;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public String getRezagado() {
        return rezagado;
    }

    public void setRezagado(String rezagado) {
        this.rezagado = rezagado;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public String getNoRetirarse() {
        return noRetirarse;
    }

    public void setNoRetirarse(String noRetirarse) {
        this.noRetirarse = noRetirarse;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getResMatricula() {
        return resMatricula;
    }

    public void setResMatricula(String resMatricula) {
        this.resMatricula = resMatricula;
    }

    public String getAsignarHabil() {
        return asignarHabil;
    }

    public void setAsignarHabil(String asignarHabil) {
        this.asignarHabil = asignarHabil;
    }

    public String getCambioPrio() {
        return cambioPrio;
    }

    public void setCambioPrio(String cambioPrio) {
        this.cambioPrio = cambioPrio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getBloqueadoFecha() {
        return bloqueadoFecha;
    }

    public void setBloqueadoFecha(Date bloqueadoFecha) {
        this.bloqueadoFecha = bloqueadoFecha;
    }

    public String getBloqueadoUsuario() {
        return bloqueadoUsuario;
    }

    public void setBloqueadoUsuario(String bloqueadoUsuario) {
        this.bloqueadoUsuario = bloqueadoUsuario;
    }

    public String getHabilitarUlt() {
        return habilitarUlt;
    }

    public void setHabilitarUlt(String habilitarUlt) {
        this.habilitarUlt = habilitarUlt;
    }

    public String getHabiltarUltUser() {
        return habiltarUltUser;
    }

    public void setHabiltarUltUser(String habiltarUltUser) {
        this.habiltarUltUser = habiltarUltUser;
    }

    public Date getHabilitarUltFecha() {
        return habilitarUltFecha;
    }

    public void setHabilitarUltFecha(Date habilitarUltFecha) {
        this.habilitarUltFecha = habilitarUltFecha;
    }

    public String getExtemporaneo() {
        return extemporaneo;
    }

    public void setExtemporaneo(String extemporaneo) {
        this.extemporaneo = extemporaneo;
    }

    public Short getPioridadb() {
        return pioridadb;
    }

    public void setPioridadb(Short pioridadb) {
        this.pioridadb = pioridadb;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getGeneraUser() {
        return generaUser;
    }

    public void setGeneraUser(String generaUser) {
        this.generaUser = generaUser;
    }

    public Date getGeneraFecha() {
        return generaFecha;
    }

    public void setGeneraFecha(Date generaFecha) {
        this.generaFecha = generaFecha;
    }

    public String getRepriorizaUser() {
        return repriorizaUser;
    }

    public void setRepriorizaUser(String repriorizaUser) {
        this.repriorizaUser = repriorizaUser;
    }

    public Date getRepriorizaFecha() {
        return repriorizaFecha;
    }

    public void setRepriorizaFecha(Date repriorizaFecha) {
        this.repriorizaFecha = repriorizaFecha;
    }

    public BigDecimal getRepriorizaVeces() {
        return repriorizaVeces;
    }

    public void setRepriorizaVeces(BigDecimal repriorizaVeces) {
        this.repriorizaVeces = repriorizaVeces;
    }

    public String getBloqueadoSessionWeb() {
        return bloqueadoSessionWeb;
    }

    public void setBloqueadoSessionWeb(String bloqueadoSessionWeb) {
        this.bloqueadoSessionWeb = bloqueadoSessionWeb;
    }

    public String getFlagEncstaEpg() {
        return flagEncstaEpg;
    }

    public void setFlagEncstaEpg(String flagEncstaEpg) {
        this.flagEncstaEpg = flagEncstaEpg;
    }

    public Date getFchaEncsta() {
        return fchaEncsta;
    }

    public void setFchaEncsta(Date fchaEncsta) {
        this.fchaEncsta = fchaEncsta;
    }

    public Integer getCrsosMtrcldos() {
        return crsosMtrcldos;
    }

    public void setCrsosMtrcldos(Integer crsosMtrcldos) {
        this.crsosMtrcldos = crsosMtrcldos;
    }

    public Integer getCrdtosMtrcldos() {
        return crdtosMtrcldos;
    }

    public void setCrdtosMtrcldos(Integer crdtosMtrcldos) {
        this.crdtosMtrcldos = crdtosMtrcldos;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof MatriculablesMy)) {
            return false;
        }
        MatriculablesMy other = (MatriculablesMy) object;
        if ((this.matriculablesPK == null && other.matriculablesPK != null) || (this.matriculablesPK != null && !this.matriculablesPK.equals(other.matriculablesPK))) {
            return false;
        }
        return true;
    }

    public List<PromCiclosMy> getPromediosCiclos() {
        return promediosCiclos;
    }

    public void setPromediosCiclos(List<PromCiclosMy> promediosCiclos) {
        this.promediosCiclos = promediosCiclos;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    @Override
    public String toString() {
        return "pe.albatross.unalmconnector.model.oficina.academico.Matriculables[ matriculablesPK=" + matriculablesPK + " ]";
    }

}
