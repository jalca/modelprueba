package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import pe.edu.lamolina.model.bienestar.EncuestaAlumnoObuae;
import pe.edu.lamolina.model.encuestaestudiantil.TipoLikert;
import pe.edu.lamolina.model.enums.PreguntaEstadoEnum;
import pe.edu.lamolina.model.enums.encuesta.TipoPreguntaEncuestaEnum;
import pe.edu.lamolina.model.inscripcion.EncuestaPostulante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_pregunta_examen")
public class PreguntaExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "texto")
    private String texto;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "respuesta_multiple")
    private Integer respuestaMultiple;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "peso_categoria")
    private BigDecimal pesoCategoria;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaPreguntas categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bloque_preguntas")
    private BloquePreguntas bloquePreguntas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subtitulo")
    private SubTituloExamen subtitulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema")
    private TemaExamenVirtual tema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion_referencia")
    private OpcionPregunta opcionReferencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_likert")
    private TipoLikert tipoLikert;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<OpcionPregunta> opcionesPregunta;
    @Transient
    private EncuestaPostulante encuesta;
    @Transient
    private EncuestaAlumnoObuae encuestaObuae;
    @Transient
    private Integer delta;
    @Transient
    private Integer orden;

    public PreguntaExamen(PreguntaExamen preview) {
        this.estado = preview.getEstado();
        this.numero = preview.getNumero();
        this.texto = preview.getTexto();
        this.respuestaMultiple = preview.getRespuestaMultiple();
        this.tipo = preview.getTipo();
    }

    public PreguntaExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public PreguntaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PreguntaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PreguntaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getLetra() {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (this.numero == null) {
            return "a";
        }
        if (this.numero > 25) {
            return "a";
        }
        if (this.numero < 1) {
            return "a";
        }
        return Character.toString(alphabet[this.numero]).toUpperCase();
    }

    public TipoPreguntaEncuestaEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoPreguntaEncuestaEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoPreguntaEncuestaEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public static class CompareOrden implements Comparator<PreguntaExamen> {

        @Override
        public int compare(PreguntaExamen p1, PreguntaExamen p2) {
            return p1.getNumero().compareTo(p2.getNumero());
        }
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "numero", numero, false);
        ModelUtils.getDataByAttr(join, "texto", texto, false);
        ModelUtils.getDataByAttr(join, "rutaImagen", rutaImagen, false);
        ModelUtils.getDataByAttr(join, "respuestaMultiple", respuestaMultiple, false);
        ModelUtils.getDataByAttr(join, "tipo", tipo, false);
        ModelUtils.getDataByAttr(join, "pesoCategoria", pesoCategoria, false);
        ModelUtils.getDataByAttr(join, "fechaCreacion", fechaCreacion, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "examenVirtual", examenVirtual, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "categoria", categoria, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "bloquePreguntas", bloquePreguntas, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "subtitulo", subtitulo, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "tema", tema, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "opcionReferencia", opcionReferencia, "id", "contenido");
        ModelUtils.getDataByAttrObject(join, "tipoLikert", tipoLikert, "id", "grupo");
        ModelUtils.getDataByAttrObject(join, "userCreacion", userCreacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
