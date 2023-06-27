package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.encuesta.TipoResumenEncuestaEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exam_resumen_encuesta")
public class ResumenEncuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_resumen")
    private String tipoResumen;

    @Column(name = "encuestados")
    private Integer encuestados;

    @Column(name = "puntaje_final")
    private BigDecimal puntajeFinal;

    @Column(name = "puntaje_total")
    private BigDecimal puntajeTotal;

    @Column(name = "fecha_inicio_resumen")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicioResumen;

    @Column(name = "fecha_fin_resumen")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFinResumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_ingreso")
    private CicloAcademico cicloIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_pregunta")
    private CategoriaPreguntas categoriaPreguntas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    public ResumenEncuesta(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual) {
        this.tipoResumen = TipoResumenEncuestaEnum.GENERAL.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas) {
        this.tipoResumen = TipoResumenEncuestaEnum.CATEGORIA_PREGUNTA.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, ModalidadEstudio modalidadEstudio) {
        this.tipoResumen = TipoResumenEncuestaEnum.MODALIDAD_ESTUDIO.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.modalidadEstudio = modalidadEstudio;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, ModalidadEstudio modalidadEstudio, CicloAcademico cicloIngreso) {
        this.tipoResumen = TipoResumenEncuestaEnum.CICLO_INGRESO.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.modalidadEstudio = modalidadEstudio;
        this.cicloIngreso = cicloIngreso;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, Facultad facultad) {
        this.tipoResumen = TipoResumenEncuestaEnum.FACULTAD.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.facultad = facultad;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, Carrera carrera) {
        this.tipoResumen = TipoResumenEncuestaEnum.CARRERA.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.carrera = carrera;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, Curso curso) {
        this.tipoResumen = TipoResumenEncuestaEnum.CURSO.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.curso = curso;
    }

    public ResumenEncuesta(CicloAcademico cicloAcademico, ExamenVirtual examenVirtual, CategoriaPreguntas categoriaPreguntas, Seccion seccion) {
        this.tipoResumen = TipoResumenEncuestaEnum.SECCION.name();
        this.cicloAcademico = cicloAcademico;
        this.examenVirtual = examenVirtual;
        this.categoriaPreguntas = categoriaPreguntas;
        this.seccion = seccion;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoResumenEncuestaEnum getTipoResumenEnum() {
        if (tipoResumen == null) {
            return null;
        }
        return TipoResumenEncuestaEnum.valueOf(tipoResumen);
    }

    @JsonIgnore
    public void setTipoResumenEnum(TipoResumenEncuestaEnum tipoResumen) {
        if (tipoResumen == null) {
            return;
        }
        this.tipoResumen = tipoResumen.name();
    }

    public String getKey() {
        String key = this.cicloAcademico.getId() + "-"
                + this.examenVirtual.getId() + "-"
                + this.tipoResumen;

        if (this.categoriaPreguntas != null) {
            key += "-" + this.categoriaPreguntas.getId();
        }

        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.MODALIDAD_ESTUDIO) {
            key += "-" + this.modalidadEstudio.getId();
        }
        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.CICLO_INGRESO) {
            key += "-" + this.modalidadEstudio.getId();
            key += "-" + this.cicloIngreso.getId();
        }
        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.FACULTAD) {
            key += "-" + this.facultad.getId();
        }
        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.CARRERA) {
            key += "-" + this.carrera.getId();
        }
        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.CURSO) {
            key += "-" + this.curso.getId();
        }
        if (this.getTipoResumenEnum() == TipoResumenEncuestaEnum.SECCION) {
            key += "-" + this.seccion.getId();
        }

        return key;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tipoResumen", tipoResumen, false);
        ModelUtils.getDataByAttr(join, "encuestados", encuestados, false);
        ModelUtils.getDataByAttr(join, "puntajeFinal", puntajeFinal, false);
        ModelUtils.getDataByAttr(join, "puntajeTotal", puntajeTotal, false);
        ModelUtils.getDataByAttr(join, "fechaInicioResumen", fechaInicioResumen, false);
        ModelUtils.getDataByAttr(join, "fechaFinResumen", fechaFinResumen, false);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "descripcion");
        ModelUtils.getDataByAttrObject(join, "cicloIngreso", cicloIngreso, "id", "descripcion");
        ModelUtils.getDataByAttrObject(join, "examenVirtual", examenVirtual, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "categoriaPreguntas", categoriaPreguntas, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "modalidadEstudio", modalidadEstudio, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "facultad", facultad, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "carrera", carrera, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "curso", curso, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "seccion", seccion, "id", "codigo2");

        return join.toString();
    }

}
