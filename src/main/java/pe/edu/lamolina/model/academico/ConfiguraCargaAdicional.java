package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.edu.lamolina.model.enums.ConfiguraCargaAdicionalEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_configura_carga_adicional")
public class ConfiguraCargaAdicional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @Column(name = "estado")
    private String estado;

    @Column(name = "rca")
    private BigDecimal rca;

    @Column(name = "minimo_alumnos")
    private Integer minimoAlumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_calcula_carga")
    private Usuario userCalculaCarga;

    @Column(name = "fecha_calcula_carga")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCalculaCarga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_calcula_montos")
    private Usuario userCalculaMontos;

    @Column(name = "fecha_calcula_montos")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCalculaMontos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierre")
    private Usuario userCierre;

    @Column(name = "fecha_cierre")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierre;
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getEstado() {
        return estado;
    }

    public ConfiguraCargaAdicionalEstadoEnum getEstadoEnum() {
        return ConfiguraCargaAdicionalEstadoEnum.valueOf(estado);
    }

    public void setEstado(ConfiguraCargaAdicionalEstadoEnum estado) {
        this.estado = estado.name();
    }

    public BigDecimal getRca() {
        return rca;
    }

    public void setRca(BigDecimal rca) {
        this.rca = rca;
    }

    public Integer getMinimoAlumnos() {
        return minimoAlumnos;
    }

    public void setMinimoAlumnos(Integer minimoAlumnos) {
        this.minimoAlumnos = minimoAlumnos;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserCalculaCarga() {
        return userCalculaCarga;
    }

    public void setUserCalculaCarga(Usuario userCalculaCarga) {
        this.userCalculaCarga = userCalculaCarga;
    }

    public Date getFechaCalculaCarga() {
        return fechaCalculaCarga;
    }

    public void setFechaCalculaCarga(Date fechaCalculaCarga) {
        this.fechaCalculaCarga = fechaCalculaCarga;
    }

    public Usuario getUserCalculaMontos() {
        return userCalculaMontos;
    }

    public void setUserCalculaMontos(Usuario userCalculaMontos) {
        this.userCalculaMontos = userCalculaMontos;
    }

    public Date getFechaCalculaMontos() {
        return fechaCalculaMontos;
    }

    public void setFechaCalculaMontos(Date fechaCalculaMontos) {
        this.fechaCalculaMontos = fechaCalculaMontos;
    }

    public Usuario getUserCierre() {
        return userCierre;
    }

    public void setUserCierre(Usuario userCierre) {
        this.userCierre = userCierre;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

}
