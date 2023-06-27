package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "med_respuesta_psicologica_historia")
public class RespuestaPsicologicaHistoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_psicologica")
    private PreguntaPsicologica preguntaPsicologica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_1")
    private OpcionPsicologica opcionUno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_2")
    private OpcionPsicologica opcionDos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_3")
    private OpcionPsicologica opcionTres;

    @Column(name = "comentario_1")
    private String comentarioUno;

    @Column(name = "comentario_2")
    private String comentarioDos;

    @Column(name = "comentario_3")
    private String comentarioTres;

    @Column(name = "observaciones")
    private String observaciones;

    public RespuestaPsicologicaHistoria() {
    }

    public RespuestaPsicologicaHistoria(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public PreguntaPsicologica getPreguntaPsicologica() {
        return preguntaPsicologica;
    }

    public void setPreguntaPsicologica(PreguntaPsicologica preguntaPsicologica) {
        this.preguntaPsicologica = preguntaPsicologica;
    }

    public OpcionPsicologica getOpcionUno() {
        return opcionUno;
    }

    public void setOpcionUno(OpcionPsicologica opcionUno) {
        this.opcionUno = opcionUno;
    }

    public OpcionPsicologica getOpcionDos() {
        return opcionDos;
    }

    public void setOpcionDos(OpcionPsicologica opcionDos) {
        this.opcionDos = opcionDos;
    }

    public OpcionPsicologica getOpcionTres() {
        return opcionTres;
    }

    public void setOpcionTres(OpcionPsicologica opcionTres) {
        this.opcionTres = opcionTres;
    }

    public String getComentarioUno() {
        return comentarioUno;
    }

    public void setComentarioUno(String comentarioUno) {
        this.comentarioUno = comentarioUno;
    }

    public String getComentarioDos() {
        return comentarioDos;
    }

    public void setComentarioDos(String comentarioDos) {
        this.comentarioDos = comentarioDos;
    }

    public String getComentarioTres() {
        return comentarioTres;
    }

    public void setComentarioTres(String comentarioTres) {
        this.comentarioTres = comentarioTres;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }
}
