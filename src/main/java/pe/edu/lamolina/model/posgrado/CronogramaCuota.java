package pe.edu.lamolina.model.posgrado;

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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "epg_cronograma_cuota")
public class CronogramaCuota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "fecha_emision")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "fecha_pago")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPago;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Integer mesesCuota;
    @Transient
    private Integer diaEmision;
    @Transient
    private Integer diaVence;
    @Transient
    private Boolean venceMismoMes;
    @Transient
    private Boolean venceUltimoDiaMes;

    public CronogramaCuota() {
    }

    public CronogramaCuota(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getMesesCuota() {
        return mesesCuota;
    }

    public void setMesesCuota(Integer mesesCuota) {
        this.mesesCuota = mesesCuota;
    }

    public Integer getDiaEmision() {
        return diaEmision;
    }

    public void setDiaEmision(Integer diaEmision) {
        this.diaEmision = diaEmision;
    }

    public Integer getDiaVence() {
        return diaVence;
    }

    public void setDiaVence(Integer diaVence) {
        this.diaVence = diaVence;
    }

    public Boolean getVenceMismoMes() {
        return venceMismoMes;
    }

    public void setVenceMismoMes(Boolean venceMismoMes) {
        this.venceMismoMes = venceMismoMes;
    }

    public Boolean getVenceUltimoDiaMes() {
        return venceUltimoDiaMes;
    }

    public void setVenceUltimoDiaMes(Boolean venceUltimoDiaMes) {
        this.venceUltimoDiaMes = venceUltimoDiaMes;
    }

    public String getCarreraNumeroCuota() {
        if (this.carrera != null) {
            return this.carrera.getId() + "-" + this.numeroCuota;
        }
        return this.numeroCuota + "";
    }

}
