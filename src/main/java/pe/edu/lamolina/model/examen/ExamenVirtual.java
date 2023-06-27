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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.encuestaestudiantil.ConfiguraEncuesta;
import pe.edu.lamolina.model.encuestaestudiantil.EncuestaEstudiantil;
import pe.edu.lamolina.model.enums.encuesta.ExamenVirtualEstadoEnum;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_examen_virtual")
public class ExamenVirtual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "preguntas_disponibles")
    private Integer preguntasDisponibles;

    @Column(name = "preguntas_visibles")
    private Integer preguntasVisibles;
    
    @Column(name = "preguntas_ocultas")
    private Integer cantidadPreguntasOcultas;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "presentacion")
    private String presentacion;

    @Column(name = "orden_aleatorio_preguntas")
    private Integer ordenAleatorioPreguntas;

    @Column(name = "orden_aleatorio_opciones")
    private Integer ordenAleatorioOpciones;

    @Column(name = "puntaje_respuesta_correcta")
    private BigDecimal puntajeRespuestaCorrecta;

    @Column(name = "puntaje_respuesta_incorrecta")
    private BigDecimal puntajeRespuestaIncorrecta;

    @Column(name = "puntaje_respuesta_vacia")
    private BigDecimal puntajeRespuestaVacia;

    @Column(name = "tiempo_pregunta")
    private BigDecimal tiempoPregunta;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActivacion;

    @Column(name = "fecha_inactivacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_examen")
    private TipoExamenVirtual tipoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activacion")
    private Usuario userActivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inactivacion")
    private Usuario userInactivacion;

    @Transient
    List<CategoriaPreguntas> categorias;
    @Transient
    private List<PreguntaExamen> preguntas;
    @Transient
    private List<TemaExamenVirtual> temas;
    @Transient
    private List<EncuestaEstudiantil> encuestasEstudiantiles;
    @Transient
    private List<TestSicologico> testSicologicos;
    @Transient
    private List<EncuestaPublicada> encuestasPublicadas;
    @Transient
    private List<EncuestaTablaColumna> preguntasOcultas;

    @Transient
    private CicloPostula cicloInicio;
    @Transient
    private CicloPostula cicloFin;

    @Transient
    private CicloAcademico cicloAcademicoInicio;
    @Transient
    private CicloAcademico cicloAcademicoFin;
    @Transient
    private ConfiguraEncuesta configuraEncuesta;

    public ExamenVirtual(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ExamenVirtualEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }

        return ExamenVirtualEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(ExamenVirtualEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getCodigoNombre() {
        return this.codigo + " - " + this.nombre;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre, false);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "preguntasDisponibles", preguntasDisponibles, false);
        ModelUtils.getDataByAttr(join, "preguntasVisibles", preguntasVisibles, false);
        ModelUtils.getDataByAttr(join, "codigo", codigo, false);
        ModelUtils.getDataByAttr(join, "presentacion", presentacion, false);
        ModelUtils.getDataByAttr(join, "ordenAleatorioPreguntas", ordenAleatorioPreguntas, false);
        ModelUtils.getDataByAttr(join, "puntajeRespuestaCorrecta", puntajeRespuestaCorrecta, false);
        ModelUtils.getDataByAttr(join, "puntajeRespuestaIncorrecta", puntajeRespuestaIncorrecta, false);
        ModelUtils.getDataByAttr(join, "puntajeRespuestaVacia", puntajeRespuestaVacia, false);
        ModelUtils.getDataByAttr(join, "tiempoPregunta", tiempoPregunta, false);
        ModelUtils.getDataByAttr(join, "fechaCreacion", fechaCreacion, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttr(join, "fechaActivacion", fechaActivacion, false);
        ModelUtils.getDataByAttr(join, "fechaInactivacion", fechaInactivacion, false);
        ModelUtils.getDataByAttrObject(join, "tipoExamen", tipoExamen, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userCreacion", userCreacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userActivacion", userActivacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userInactivacion", userInactivacion, "id", "google");

        return join.toString();
    }

}
