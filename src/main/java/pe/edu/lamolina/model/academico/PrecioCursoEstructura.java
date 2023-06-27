package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import javax.persistence.Transient;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_precio_curso_estructura")
public class PrecioCursoEstructura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tpc")
    private String tpc;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "creditos")
    private Integer creditos;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_precio")
    private Date fechaPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_precio")
    private Usuario userPrecio;

    @Transient
    private Long cantidadGrupos;

    public PrecioCursoEstructura() {
    }

    public PrecioCursoEstructura(Long id, String tpc, Integer creditos, BigDecimal precio, String estado, Long cantidadGrupos) {
        this.id = id;
        this.tpc = tpc;
        this.creditos = creditos;
        this.precio = precio;
        this.estado = estado;
        this.cantidadGrupos = cantidadGrupos;
    }

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

    public String getTpc() {
        return tpc;
    }

    public void setTpc(String tpc) {
        this.tpc = tpc;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Usuario getUserPrecio() {
        return userPrecio;
    }

    public void setUserPrecio(Usuario userPrecio) {
        this.userPrecio = userPrecio;
    }

    public Date getFechaPrecio() {
        return fechaPrecio;
    }

    public void setFechaPrecio(Date fechaPrecio) {
        this.fechaPrecio = fechaPrecio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(Long cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

}
