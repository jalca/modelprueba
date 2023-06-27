package pe.edu.lamolina.model.posgrado.admision;

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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_peso_aspecto_evaluacion")
public class PesoAspectoEvaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "peso_fraccion")
    private String pesoFraccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_escuela")
    private CarreraEscuela carreraEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aspecto_evaluacion")
    private AspectoEvaluacion aspectoEvaluacion;

    @Transient
    private BigDecimal totalFraccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getPesoFraccion() {
        return pesoFraccion;
    }

    public void setPesoFraccion(String pesoFraccion) {
        this.pesoFraccion = pesoFraccion;
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

    public CarreraEscuela getCarreraEscuela() {
        return carreraEscuela;
    }

    public void setCarreraEscuela(CarreraEscuela carreraEscuela) {
        this.carreraEscuela = carreraEscuela;
    }

    public AspectoEvaluacion getAspectoEvaluacion() {
        return aspectoEvaluacion;
    }

    public void setAspectoEvaluacion(AspectoEvaluacion aspectoEvaluacion) {
        this.aspectoEvaluacion = aspectoEvaluacion;
    }

    public BigDecimal getTotalFraccion() {
        return totalFraccion;
    }

    public void setTotalFraccion(BigDecimal totalFraccion) {
        this.totalFraccion = totalFraccion;
    }
}
