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
import pe.edu.lamolina.model.enums.subvenciones.JustificacionEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.TipoCantidadEnum;
import pe.edu.lamolina.model.enums.subvenciones.TipoFacturaJustificacionEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "cont_item_justificacion_gasto")
public class ItemJustificacionGasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado_justificacion")
    private String estadoJustificacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_grupo_alumnos")
    private String tipoGrupoAlumnos;

    @Column(name = "tipo_factura")
    private String tipoFactura;

    @Column(name = "otro_tipo_factura")
    private String otroTipoFactura;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "cantidad_alumnos")
    private Integer cantidadAlumnos;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "importe_alumno")
    private BigDecimal importeAlumno;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_observa")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaObserva;

    @Column(name = "fecha_vobo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_justificacion_gasto")
    private JustificacionGasto justificacionGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private Archivo factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_vobo")
    private Colaborador colaboradorVoBo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_observa")
    private Usuario userObserva;

    @Transient
    private List<JustificacionGastoAlumno> justificacionesAlumnos;

    public ItemJustificacionGasto() {
    }

    public ItemJustificacionGasto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public JustificacionEstadoEnum getEstadoEnum() {
        if (estadoJustificacion == null) {
            return null;
        }
        return JustificacionEstadoEnum.valueOf(estadoJustificacion);
    }

    @JsonIgnore
    public void setEstadoEnum(JustificacionEstadoEnum estadoJustificacion) {
        if (estadoJustificacion == null) {
            return;
        }
        this.estadoJustificacion = estadoJustificacion.name();
    }

    public TipoCantidadEnum getTipoGrupoAlumnosEnum() {
        if (tipoGrupoAlumnos == null) {
            return null;
        }
        return TipoCantidadEnum.valueOf(tipoGrupoAlumnos);
    }

    @JsonIgnore
    public void setTipoGrupoAlumnosEnum(TipoCantidadEnum tipoGrupoAlumnos) {
        if (tipoGrupoAlumnos == null) {
            return;
        }
        this.tipoGrupoAlumnos = tipoGrupoAlumnos.name();
    }

    public TipoFacturaJustificacionEnum getTipoFacturaEnum() {
        if (tipoFactura == null) {
            return null;
        }
        return TipoFacturaJustificacionEnum.valueOf(tipoFactura);
    }

    @JsonIgnore
    public void setTipoFacturaEnum(TipoFacturaJustificacionEnum tipoFactura) {
        if (tipoFactura == null) {
            return;
        }
        this.tipoFactura = tipoFactura.name();
    }

    public Boolean isAceptada() {
        if (estadoJustificacion == null) {
            return false;
        }
        return JustificacionEstadoEnum.valueOf(estadoJustificacion) == JustificacionEstadoEnum.ACEPTADA;
    }

    public Boolean isRechazada() {
        if (estadoJustificacion == null) {
            return false;
        }
        return JustificacionEstadoEnum.valueOf(estadoJustificacion) == JustificacionEstadoEnum.RECHAZADA;
    }

    public Boolean isRegistroNuevo() {
        if (estadoJustificacion == null) {
            return false;
        }
        boolean isPendiente = JustificacionEstadoEnum.valueOf(estadoJustificacion) == JustificacionEstadoEnum.PENDIENTE;
        return isPendiente && this.fechaObserva == null;
    }

    public Boolean isObservado() {
        return this.fechaObserva != null;
    }

    public Boolean isAnulada() {
        if (estadoJustificacion == null) {
            return false;
        }
        return JustificacionEstadoEnum.valueOf(estadoJustificacion) == JustificacionEstadoEnum.ANULADA;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estadoJustificacion", estadoJustificacion, false);
        ModelUtils.getDataByAttr(join, "descripcion", descripcion, false);
        ModelUtils.getDataByAttr(join, "tipoGrupoAlumnos", tipoGrupoAlumnos, false);
        ModelUtils.getDataByAttr(join, "observaciones", observaciones, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnos", cantidadAlumnos, false);
        ModelUtils.getDataByAttr(join, "importe", importe, false);
        ModelUtils.getDataByAttr(join, "importeAlumno", importeAlumno, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaAnulacion", fechaAnulacion, false);
        ModelUtils.getDataByAttr(join, "fechaObserva", fechaObserva, false);
        ModelUtils.getDataByAttr(join, "fechaVoBo", fechaVoBo, false);
        ModelUtils.getDataByAttr(join, "justificacionesAlumnos", justificacionesAlumnos, false);
        ModelUtils.getDataByAttrObject(join, "justificacionGasto", justificacionGasto, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "factura", factura, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "colaboradorVoBo", colaboradorVoBo, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userAnulacion", userAnulacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userObserva", userObserva, "id", "google");

        return join.toString();
    }

}
