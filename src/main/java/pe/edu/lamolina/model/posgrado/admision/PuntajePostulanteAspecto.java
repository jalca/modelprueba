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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_puntaje_postulante_aspecto")
public class PuntajePostulanteAspecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aspecto_evaluacion")
    private AspectoEvaluacion aspectoEvaluacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
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

    public PostulanteEscuela getPostulanteEscuela() {
        return postulanteEscuela;
    }

    public void setPostulanteEscuela(PostulanteEscuela postulanteEscuela) {
        this.postulanteEscuela = postulanteEscuela;
    }

    public AspectoEvaluacion getAspectoEvaluacion() {
        return aspectoEvaluacion;
    }

    public void setAspectoEvaluacion(AspectoEvaluacion aspectoEvaluacion) {
        this.aspectoEvaluacion = aspectoEvaluacion;
    }

}
