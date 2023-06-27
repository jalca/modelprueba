package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoOpcionPsicologicaEnum;
import pe.edu.lamolina.model.enums.EstadoEnum;

@Entity
@Table(name = "med_pregunta_psicologica")
public class PreguntaPsicologica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_opcion_1")
    private String tipoOpcion1;

    @Column(name = "tipo_opcion_2")
    private String tipoOpcion2;

    @Column(name = "tipo_opcion_3")
    private String tipoOpcion3;

    @Column(name = "estado")
    private String estado;

    @Column(name = "con_comentario")
    private Boolean conComentario;

    @Column(name = "pregunta")
    private String pregunta;

    @Column(name = "orden_pregunta")
    private Integer ordenPregunta;

    @Column(name = "activable")
    private Boolean activable;

    @Column(name = "imp_diagnostica")
    private Boolean impDiagnostica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_psicologica")
    private AreaPsicologica areaPsicologica;

    @Transient
    private RespuestaPsicologicaHistoria respuesta;

    @Transient
    private List<OpcionPsicologica> opciones1;

    @Transient
    private List<OpcionPsicologica> opciones2;

    @Transient
    private List<OpcionPsicologica> opciones3;

    public PreguntaPsicologica() {
    }

    public PreguntaPsicologica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoOpcion1() {
        return tipoOpcion1;
    }

    public TipoOpcionPsicologicaEnum getTipoOpcion1Enum() {
        if (tipoOpcion1 == null) {
            return null;
        }
        return TipoOpcionPsicologicaEnum.valueOf(tipoOpcion1);
    }

    public void setTipoOpcion1(TipoOpcionPsicologicaEnum opcionPsicologica) {
        this.tipoOpcion1 = opcionPsicologica.name();
    }

    public String getTipoOpcion2() {
        return tipoOpcion2;
    }

    public TipoOpcionPsicologicaEnum getTipoOpcion2Enum() {
        if (tipoOpcion2 == null) {
            return null;
        }
        return TipoOpcionPsicologicaEnum.valueOf(tipoOpcion2);
    }

    public void setTipoOpcion2(TipoOpcionPsicologicaEnum opcionPsicologica) {
        this.tipoOpcion2 = opcionPsicologica.name();
    }

    public String getTipoOpcion3() {
        return tipoOpcion3;
    }

    public TipoOpcionPsicologicaEnum getTipoOpcion3Enum() {
        if (tipoOpcion3 == null) {
            return null;
        }
        return TipoOpcionPsicologicaEnum.valueOf(tipoOpcion3);
    }

    public void setTipoOpcion3(TipoOpcionPsicologicaEnum opcionPsicologica) {
        this.tipoOpcion3 = opcionPsicologica.name();
    }

    public String getEstado() {
        return estado;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public Boolean getConComentario() {
        return conComentario;
    }

    public void setConComentario(Boolean conComentario) {
        this.conComentario = conComentario;
    }

    public AreaPsicologica getAreaPsicologica() {
        return areaPsicologica;
    }

    public void setAreaPsicologica(AreaPsicologica areaPsicologica) {
        this.areaPsicologica = areaPsicologica;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getOrdenPregunta() {
        return ordenPregunta;
    }

    public void setOrdenPregunta(Integer ordenPregunta) {
        this.ordenPregunta = ordenPregunta;
    }

    public RespuestaPsicologicaHistoria getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaPsicologicaHistoria respuesta) {
        this.respuesta = respuesta;
    }

    public List<OpcionPsicologica> getOpciones1() {
        return opciones1;
    }

    public void setOpciones1(List<OpcionPsicologica> opciones1) {
        this.opciones1 = opciones1;
    }

    public List<OpcionPsicologica> getOpciones2() {
        return opciones2;
    }

    public void setOpciones2(List<OpcionPsicologica> opciones2) {
        this.opciones2 = opciones2;
    }

    public List<OpcionPsicologica> getOpciones3() {
        return opciones3;
    }

    public void setOpciones3(List<OpcionPsicologica> opciones3) {
        this.opciones3 = opciones3;
    }

    public Boolean getActivable() {
        return activable;
    }

    public void setActivable(Boolean activable) {
        this.activable = activable;
    }

    public Boolean getImpDiagnostica() {
        return impDiagnostica;
    }

    public void setImpDiagnostica(Boolean impDiagnostica) {
        this.impDiagnostica = impDiagnostica;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, true, new String[]{
            "*",
            "areaPsicologica.*"
        });
    }
}
