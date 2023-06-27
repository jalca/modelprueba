package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.activadorficha.TipoVigenciaEnum;
import pe.edu.lamolina.model.enums.encuesta.ExamenVirtualEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_encuesta_publicada")
public class EncuestaPublicada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo_visible")
    private Long codigoVisible;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "encuestables")
    private Integer encuestables;

    @Column(name = "encuestados")
    private Integer encuestados;

    @Column(name = "activaciones")
    private String activaciones;

    @Column(name = "mensaje_obligatorio")
    private String mensajeObligatorio;

    @Column(name = "mensaje_opcional")
    private String mensajeOpcional;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFin;

    @Column(name = "fecha_inicio_encuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicioEncuesta;

    @Column(name = "fecha_fin_encuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFinEncuesta;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<GrupoObjetivo> gruposObjetivos;
    @Transient
    private List<ResumenEncuesta> resumenesEncuestas;
    @Transient
    private List<MenuEncuestaPublicada> menusEncuesta;
    @Transient
    private String rutaCrearEncuesta;
    @Transient
    private Long cantidadComentarios;

    public EncuestaPublicada(Object id) {
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

    public TipoVigenciaEnum getVigenciaEnum() {
        Date hoy = new LocalDate().toDate();
        Date fin = this.fechaFin;
        if (fin == null) {
            fin = new LocalDate(hoy).plusDays(5).toDate();
        }

        if (hoy.compareTo(this.fechaInicio) >= 0
                && hoy.compareTo(fin) <= 0) {
            return TipoVigenciaEnum.VIGENTE;
        }

        if (hoy.compareTo(fin) > 0) {
            return TipoVigenciaEnum.PASADO;
        }

        return TipoVigenciaEnum.FUTURO;
    }

    public String getNombre() {
        if (this.fechaInicio == null) {
            return null;
        }
        if (this.fechaFin == null) {
            return null;
        }
        if (this.codigo == null) {
            return null;
        }

        String inicio = new DateTime(this.fechaInicio).toString("dd/MM/yyyy");
        String fin = new DateTime(this.fechaFin).toString("dd/MM/yyyy");
        return this.codigo + " - [" + inicio + " hasta " + fin + "]";
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo, false);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "encuestables", encuestables, false);
        ModelUtils.getDataByAttr(join, "encuestados", encuestados, false);
        ModelUtils.getDataByAttr(join, "activaciones", activaciones, false);
        ModelUtils.getDataByAttr(join, "fechaInicio", fechaInicio, false);
        ModelUtils.getDataByAttr(join, "fechaFin", fechaFin, false);
        ModelUtils.getDataByAttr(join, "fechaInicioEncuesta", fechaInicioEncuesta, false);
        ModelUtils.getDataByAttr(join, "fechaFinEncuesta", fechaFinEncuesta, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "examenVirtual", examenVirtual, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
