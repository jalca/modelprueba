package pe.edu.lamolina.model.inscripcion;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.examen.ExamenVirtual;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "sip_examen_interesado")
public class ExamenInteresado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "respuestas_correctas")
    private Integer respuestasCorrectas;

    @Column(name = "respuestas_incorrectas")
    private Integer respuestasIncorrectas;

    @Column(name = "respuestas_vacias")
    private Integer respuestasVacias;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "nota")
    private BigDecimal nota;

    @Column(name = "tiempo_evaluacion")
    private Integer tiempoEvaluacion;

    @Column(name = "preguntas_json")
    private String preguntasJson;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen")
    private ExamenVirtual examen;

    public ExamenInteresado() {
    }

    public ExamenInteresado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public ExamenVirtual getExamen() {
        return examen;
    }

    public void setExamen(ExamenVirtual examen) {
        this.examen = examen;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    @JsonDeserialize(using = DateTimeDeserializer.class)
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    @JsonDeserialize(using = DateTimeDeserializer.class)
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public void setRespuestasCorrectas(Integer respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public Integer getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }

    public void setRespuestasIncorrectas(Integer respuestasIncorrectas) {
        this.respuestasIncorrectas = respuestasIncorrectas;
    }

    public Integer getRespuestasVacias() {
        return respuestasVacias;
    }

    public void setRespuestasVacias(Integer respuestasVacias) {
        this.respuestasVacias = respuestasVacias;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Integer getTiempoEvaluacion() {
        return tiempoEvaluacion;
    }

    public void setTiempoEvaluacion(Integer tiempoEvaluacion) {
        this.tiempoEvaluacion = tiempoEvaluacion;
    }

    public String getPreguntasJson() {
        return preguntasJson;
    }

    public void setPreguntasJson(String preguntasJson) {
        this.preguntasJson = preguntasJson;
    }

    public boolean isVigente() {
        Long tiempoActual = TypesUtil.getUnixTime();
        Long tiempoFinal = fechaInicio.getTime() + tiempoEvaluacion;
        return tiempoActual < tiempoFinal;
    }

}
