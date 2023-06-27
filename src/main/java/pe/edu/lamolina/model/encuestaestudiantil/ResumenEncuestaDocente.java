package pe.edu.lamolina.model.encuestaestudiantil;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.edu.lamolina.model.examen.PreguntaExamen;

@Entity
@Table(name = "exam_resumen_encuesta_docente")
public class ResumenEncuestaDocente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "desviacion_standar")
    private BigDecimal desviacionStandar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_docente")
    private EncuestaDocente encuestaDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    private PreguntaExamen pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_likert")
    private OpcionLikert opcionLikert;

    @Transient
    private TipoLikert tipoLikert;

    public ResumenEncuestaDocente() {
    }

    public ResumenEncuestaDocente(Double puntaje, Double desviacionStandar, EncuestaDocente encuestaDocente, PreguntaExamen pregunta, TipoLikert tipoLikert) {
        this.puntaje = new BigDecimal(puntaje);
        this.desviacionStandar = new BigDecimal(desviacionStandar);
        this.encuestaDocente = encuestaDocente;
        this.pregunta = pregunta;
        this.tipoLikert = tipoLikert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EncuestaDocente getEncuestaDocente() {
        return encuestaDocente;
    }

    public void setEncuestaDocente(EncuestaDocente encuestaDocente) {
        this.encuestaDocente = encuestaDocente;
    }

    public PreguntaExamen getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaExamen pregunta) {
        this.pregunta = pregunta;
    }

    public OpcionLikert getOpcionLikert() {
        return opcionLikert;
    }

    public void setOpcionLikert(OpcionLikert opcionLikert) {
        this.opcionLikert = opcionLikert;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public BigDecimal getDesviacionStandar() {
        return desviacionStandar;
    }

    public void setDesviacionStandar(BigDecimal desviacionStandar) {
        this.desviacionStandar = desviacionStandar;
    }

    public TipoLikert getTipoLikert() {
        return tipoLikert;
    }

    public void setTipoLikert(TipoLikert tipoLikert) {
        this.tipoLikert = tipoLikert;
    }

}
