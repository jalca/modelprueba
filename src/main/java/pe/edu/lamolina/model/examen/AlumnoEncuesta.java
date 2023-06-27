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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.encuesta.AlumnoEncuestaEstadoEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_alumno_encuesta")
public class AlumnoEncuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "procesado")
    private String procesado;

    @Column(name = "preguntas_respondidas")
    private Integer preguntasRespondidas;

    @Column(name = "total_preguntas")
    private Integer totalPreguntas;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "fecha_procesado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaProcesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @Transient
    private List<AlumnoCategoriaEncuesta> categoriasEncuesta;

    public AlumnoEncuesta(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AlumnoEncuestaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return AlumnoEncuestaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(AlumnoEncuestaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public AlumnoEncuestaEstadoEnum getProcesadoEnum() {
        if (procesado == null) {
            return null;
        }
        return AlumnoEncuestaEstadoEnum.valueOf(procesado);
    }

    @JsonIgnore
    public void setProcesadoEnum(AlumnoEncuestaEstadoEnum procesado) {
        if (procesado == null) {
            return;
        }
        this.procesado = procesado.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "procesado", procesado, false);
        ModelUtils.getDataByAttr(join, "preguntasRespondidas", preguntasRespondidas, false);
        ModelUtils.getDataByAttr(join, "totalPreguntas", totalPreguntas, false);
        ModelUtils.getDataByAttr(join, "puntaje", puntaje, false);
        ModelUtils.getDataByAttr(join, "fechaInicio", fechaInicio, false);
        ModelUtils.getDataByAttr(join, "fechaFin", fechaFin, false);
        ModelUtils.getDataByAttr(join, "fechaProcesado", fechaProcesado, false);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "descripcion");
        ModelUtils.getDataByAttrObject(join, "examenVirtual", examenVirtual, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");

        return join.toString();
    }

}
