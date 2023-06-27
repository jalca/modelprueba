package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.encuesta.EstadoOpcionPreguntaEnum;
import pe.edu.lamolina.model.inscripcion.EncuestaPostulante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_opcion_pregunta")
public class OpcionPregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "letra")
    private String letra;

    @Column(name = "es_correcta")
    private Integer esCorrecta;

    @Column(name = "es_otro")
    private Integer esOtro;

    @Column(name = "es_texto")
    private Integer esTexto;

    @Column(name = "es_multi")
    private Integer esMulti;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "pregunta_comentario")
    private String preguntaComentario;

    @Column(name = "peso_categoria")
    private BigDecimal pesoCategoria;

    @Column(name = "fecha_creacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_examen")
    private PreguntaExamen pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<PreguntaExamen> preguntaReferencia;
    @Transient
    private String frase0;
    @Transient
    private String frase1;
    @Transient
    private Integer indiceFrase;
    @Transient
    private EncuestaPostulante respuesta;

    public OpcionPregunta(OpcionPregunta opcion) {
        this.estado = opcion.getEstado();
        this.numero = opcion.getNumero();
        this.letra = opcion.getLetra();
        this.letra = opcion.getLetra();
        this.esCorrecta = opcion.getEsCorrecta();
        this.esOtro = opcion.getEsOtro();
        this.esTexto = opcion.getEsTexto();
        this.esMulti = opcion.getEsMulti();
        this.contenido = opcion.getContenido();
        this.rutaImagen = opcion.getRutaImagen();
        this.rutaImagen = opcion.getRutaImagen();
        this.preguntaComentario = opcion.getPreguntaComentario();
    }

    public OpcionPregunta(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoOpcionPreguntaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoOpcionPreguntaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoOpcionPreguntaEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getItemsReferencias() {
        if (preguntaReferencia == null) {
            return null;
        }
        if (preguntaReferencia.isEmpty()) {
            return null;
        }

        String items = "";
        for (PreguntaExamen pregunta : preguntaReferencia) {
            items += items.equals("") ? "" : ",";
            items += pregunta.getId();
        }
        return items;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "numero", numero, false);
        ModelUtils.getDataByAttr(join, "letra", letra, false);
        ModelUtils.getDataByAttr(join, "esCorrecta", esCorrecta, false);
        ModelUtils.getDataByAttr(join, "esOtro", esOtro, false);
        ModelUtils.getDataByAttr(join, "esTexto", esTexto, false);
        ModelUtils.getDataByAttr(join, "esMulti", esMulti, false);
        ModelUtils.getDataByAttr(join, "contenido", contenido, false);
        ModelUtils.getDataByAttr(join, "rutaImagen", rutaImagen, false);
        ModelUtils.getDataByAttr(join, "peso", peso, false);
        ModelUtils.getDataByAttr(join, "preguntaComentario", preguntaComentario, false);
        ModelUtils.getDataByAttr(join, "pesoCategoria", pesoCategoria, false);
        ModelUtils.getDataByAttr(join, "fechaCreacion", fechaCreacion, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "userCreacion", userCreacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }
}
