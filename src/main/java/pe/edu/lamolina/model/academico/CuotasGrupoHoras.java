package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import pe.edu.lamolina.model.horario.GrupoHoras;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_cuotas_grupo_horas")
public class CuotasGrupoHoras implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cuotas_teoria")
    private Integer cuotasTeoria;

    @Column(name = "cuotas_practica")
    private Integer cuotasPractica;

    @Column(name = "utilizadas_teoria")
    private Integer utilizadasTeoria;

    @Column(name = "utilizadas_practica")
    private Integer utilizadasPractica;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anexo_boletin")
    private AnexoBoletin anexoBoletin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas")
    private GrupoHoras grupoHoras;

    @Transient
    private Long gruposUtilizadosTeoria;
    @Transient
    private Long gruposUtilizadosPractica;
    @Transient
    private Long horasUtilizadasTeoria;
    @Transient
    private Long horasUtilizadasPractica;
    @Transient
    private String detalleGruposTeoria;
    @Transient
    private String detalleGruposPractica;
    @Transient
    private String idsGposSeccionesTeoria;
    @Transient
    private String idsGposSeccionesPractica;

    public CuotasGrupoHoras() {

    }

    public CuotasGrupoHoras(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public AnexoBoletin getAnexoBoletin() {
        return anexoBoletin;
    }

    public void setAnexoBoletin(AnexoBoletin anexoBoletin) {
        this.anexoBoletin = anexoBoletin;
    }

    public GrupoHoras getGrupoHoras() {
        return grupoHoras;
    }

    public void setGrupoHoras(GrupoHoras grupoHoras) {
        this.grupoHoras = grupoHoras;
    }

    public Long getGruposUtilizadosTeoria() {
        return gruposUtilizadosTeoria;
    }

    public void setGruposUtilizadosTeoria(Long gruposUtilizadosTeoria) {
        this.gruposUtilizadosTeoria = gruposUtilizadosTeoria;
    }

    public Long getHorasUtilizadasTeoria() {
        return horasUtilizadasTeoria;
    }

    public void setHorasUtilizadasTeoria(Long horasUtilizadasTeoria) {
        this.horasUtilizadasTeoria = horasUtilizadasTeoria;
    }

    public String getDetalleGruposTeoria() {
        return detalleGruposTeoria;
    }

    public void setDetalleGruposTeoria(String detalleGruposTeoria) {
        this.detalleGruposTeoria = detalleGruposTeoria;
    }

    public String getIdsGposSeccionesTeoria() {
        return idsGposSeccionesTeoria;
    }

    public void setIdsGposSeccionesTeoria(String idsGposSeccionesTeoria) {
        this.idsGposSeccionesTeoria = idsGposSeccionesTeoria;
    }

    public Integer getCuotasTeoria() {
        return cuotasTeoria;
    }

    public void setCuotasTeoria(Integer cuotasTeoria) {
        this.cuotasTeoria = cuotasTeoria;
    }

    public Integer getCuotasPractica() {
        return cuotasPractica;
    }

    public void setCuotasPractica(Integer cuotasPractica) {
        this.cuotasPractica = cuotasPractica;
    }

    public Integer getUtilizadasTeoria() {
        return utilizadasTeoria;
    }

    public void setUtilizadasTeoria(Integer utilizadasTeoria) {
        this.utilizadasTeoria = utilizadasTeoria;
    }

    public Integer getUtilizadasPractica() {
        return utilizadasPractica;
    }

    public void setUtilizadasPractica(Integer utilizadasPractica) {
        this.utilizadasPractica = utilizadasPractica;
    }

    public Long getGruposUtilizadosPractica() {
        return gruposUtilizadosPractica;
    }

    public void setGruposUtilizadosPractica(Long gruposUtilizadosPractica) {
        this.gruposUtilizadosPractica = gruposUtilizadosPractica;
    }

    public Long getHorasUtilizadasPractica() {
        return horasUtilizadasPractica;
    }

    public void setHorasUtilizadasPractica(Long horasUtilizadasPractica) {
        this.horasUtilizadasPractica = horasUtilizadasPractica;
    }

    public String getDetalleGruposPractica() {
        return detalleGruposPractica;
    }

    public void setDetalleGruposPractica(String detalleGruposPractica) {
        this.detalleGruposPractica = detalleGruposPractica;
    }

    public String getIdsGposSeccionesPractica() {
        return idsGposSeccionesPractica;
    }

    public void setIdsGposSeccionesPractica(String idsGposSeccionesPractica) {
        this.idsGposSeccionesPractica = idsGposSeccionesPractica;
    }

    @Override
    public CuotasGrupoHoras clone() {
        CuotasGrupoHoras clone = null;
        try {
            clone = (CuotasGrupoHoras) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
