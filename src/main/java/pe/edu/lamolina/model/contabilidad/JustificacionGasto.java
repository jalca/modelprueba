package pe.edu.lamolina.model.contabilidad;

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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.bienestar.EventoAgrupacionAlumnos;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.bienestar.ViajeCurso;
import pe.edu.lamolina.model.enums.subvenciones.JustificacionEstadoEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "cont_justificacion_gasto")
public class JustificacionGasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "alumnos_asistentes")
    private Integer alumnosAsistentes;

    @Column(name = "importe_justificado")
    private BigDecimal importeJustificado;

    @Column(name = "importe_aceptado")
    private BigDecimal importeAceptado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_envia_justificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnviaJustificacion;

    @Column(name = "fecha_vobo_justificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoJustificacion;

    @Column(name = "fecha_acepta_justificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAceptaJustificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_subvencion")
    private TipoSubvencion tipoSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_viaje_curso")
    private ViajeCurso viajeCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_agrupacion_alumnos")
    private EventoAgrupacionAlumnos eventoAgrupacionAlumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_responsable")
    private Alumno alumnoResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_vobo")
    private Colaborador colaboradorVoBo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_aceptacion")
    private Colaborador colaboradorAceptacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private List<ItemJustificacionGasto> itemsJustificacion;

    @Transient
    private BigDecimal importeDeuda;

    public JustificacionGasto() {
    }

    public JustificacionGasto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public JustificacionEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return JustificacionEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(JustificacionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Boolean isAbierta() {
        if (this.estado == null) {
            return false;
        }
        return JustificacionEstadoEnum.valueOf(estado) == JustificacionEstadoEnum.ABIERTA;
    }

    public Boolean isCerrada() {
        if (this.estado == null) {
            return false;
        }
        return JustificacionEstadoEnum.valueOf(estado) == JustificacionEstadoEnum.CERRADA;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "alumnosAsistentes", alumnosAsistentes, false);
        ModelUtils.getDataByAttr(join, "importeJustificado", importeJustificado, false);
        ModelUtils.getDataByAttr(join, "importeAceptado", importeAceptado, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaEnviaJustificacion", fechaEnviaJustificacion, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoJustificacion", fechaVoBoJustificacion, false);
        ModelUtils.getDataByAttr(join, "fechaAceptaJustificacion", fechaAceptaJustificacion, false);
        ModelUtils.getDataByAttr(join, "itemsJustificacion", itemsJustificacion, false);
        ModelUtils.getDataByAttrObject(join, "tipoSubvencion", tipoSubvencion, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "viajeCurso", viajeCurso, "id", "estadoViaje");
        ModelUtils.getDataByAttrObject(join, "eventoAgrupacionAlumnos", eventoAgrupacionAlumnos, "id", "tipoEvento", "estado");
        ModelUtils.getDataByAttrObject(join, "alumnoResponsable", alumnoResponsable, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "colaboradorVoBo", colaboradorVoBo, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "colaboradorAceptacion", colaboradorAceptacion, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
