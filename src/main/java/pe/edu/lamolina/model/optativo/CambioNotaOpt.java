package pe.edu.lamolina.model.optativo;

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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "opt_cambio_nota")
public class CambioNotaOpt implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_evaluacion")
    private AlumnoEvaluacionOptativo alumnoEvaluacionOptativo;

    @Column(name = "nota_inicial")
    private String notaInicial;

    @Column(name = "nota_final")
    private String notaFinal;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @JoinColumn(name = "id_user_ingreso_nota", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario userIngresoNota;

    public CambioNotaOpt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoEvaluacionOptativo getAlumnoEvaluacionOptativo() {
        return alumnoEvaluacionOptativo;
    }

    public void setAlumnoEvaluacionOptativo(AlumnoEvaluacionOptativo alumnoEvaluacionOptativo) {
        this.alumnoEvaluacionOptativo = alumnoEvaluacionOptativo;
    }

    public String getNotaInicial() {
        return notaInicial;
    }

    public void setNotaInicial(String notaInicial) {
        this.notaInicial = notaInicial;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserIngresoNota() {
        return userIngresoNota;
    }

    public void setUserIngresoNota(Usuario userIngresoNota) {
        this.userIngresoNota = userIngresoNota;
    }

}
