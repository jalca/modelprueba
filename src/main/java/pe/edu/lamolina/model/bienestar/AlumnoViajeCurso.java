package pe.edu.lamolina.model.bienestar;

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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.TipoCursoCurricula;
import pe.edu.lamolina.model.contabilidad.OrdenSubvencionEconomia;
import pe.edu.lamolina.model.enums.subvenciones.AlumnoViajeCursoEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.AsistenciaEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.SaludEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.SubvencionViajeEstadoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.TramiteSubvencion;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_alumno_viaje_curso")
public class AlumnoViajeCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe_asignado")
    private BigDecimal importeAsignado;

    @Column(name = "importe_justificado")
    private BigDecimal importeJustificado;

    @Column(name = "importe_devuelto")
    private BigDecimal importeDevuelto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_subvencion")
    private String estadoSubvencion;

    @Column(name = "estado_salud")
    private String estadoSalud;

    @Column(name = "estado_asistencia")
    private String estadoAsistencia;

    @Column(name = "impedimentos_academicos")
    private String impedimentosAcademicos;

    @Column(name = "celular_apoderado")
    private String celularApoderado;

    @Column(name = "es_menor_edad")
    private Boolean esMenorEdad;

    @Column(name = "estoy_sano")
    private Boolean estoySano;

    @Column(name = "motivo_no_estoy_sano")
    private String motivoNoEstoySano;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_inscripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    @Column(name = "fecha_separacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSeparacion;

    @Column(name = "fecha_vobo_separacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoSeparacion;

    @Column(name = "fecha_renuncia")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRenuncia;

    @Column(name = "fecha_video")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVideo;

    @Column(name = "fecha_estado_salud")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEstadoSalud;

    @Column(name = "fecha_dictamen_medico")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDictamenMedico;

    @Column(name = "fecha_vobo_menores")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoMenores;

    @Column(name = "fecha_exclusion_menores")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExclusionMenores;

    @Column(name = "fecha_registro_asistencia")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistroAsistencia;

    @Column(name = "fecha_estoy_sano")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEstoySano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_viaje_curso")
    private ViajeCurso viajeCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_delegado_separador")
    private Alumno delegadoSeparador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formulario_apoderado")
    private Archivo formularioApoderado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_video_apoderado")
    private Archivo videoApoderado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_vobo_menores")
    private Colaborador colaboradorVoBoMenores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_subvencion")
    private TramiteSubvencion tramiteSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_subvencion_economia")
    private OrdenSubvencionEconomia ordenSubvencionEconomia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AlumnoViajeCurso() {
        this.esMenorEdad = Boolean.FALSE;
    }

    public AlumnoViajeCurso(Object id) {
        this.id = TypesUtil.getLong(id);
        this.esMenorEdad = Boolean.FALSE;
    }

    public AlumnoViajeCursoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return AlumnoViajeCursoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(AlumnoViajeCursoEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public SubvencionViajeEstadoEnum getEstadoSubvencionEnum() {
        if (estadoSubvencion == null) {
            return null;
        }
        return SubvencionViajeEstadoEnum.valueOf(estadoSubvencion);
    }

    @JsonIgnore
    public void setEstadoSubvencionEnum(SubvencionViajeEstadoEnum estadoSubvencion) {
        if (estadoSubvencion == null) {
            return;
        }
        this.estadoSubvencion = estadoSubvencion.name();
    }

    public SaludEstadoEnum getEstadoSaludEnum() {
        if (estadoSalud == null) {
            return null;
        }
        return SaludEstadoEnum.valueOf(estadoSalud);
    }

    @JsonIgnore
    public void setEstadoSaludEnum(SaludEstadoEnum estadoSalud) {
        if (estadoSalud == null) {
            return;
        }
        this.estadoSalud = estadoSalud.name();
    }

    public AsistenciaEstadoEnum getEstadoAsistenciaEnum() {
        if (estadoAsistencia == null) {
            return null;
        }
        return AsistenciaEstadoEnum.valueOf(estadoAsistencia);
    }

    @JsonIgnore
    public void setEstadoAsistenciaEnum(AsistenciaEstadoEnum estadoAsistencia) {
        if (estadoAsistencia == null) {
            return;
        }
        this.estadoAsistencia = estadoAsistencia.name();
    }

    public Boolean isAsistioViaje() {
        if (estadoAsistencia == null) {
            return false;
        }
        return AsistenciaEstadoEnum.valueOf(estadoAsistencia) == AsistenciaEstadoEnum.CON_ASISTENCIA;
    }

    public Boolean isNoAsistioViaje() {
        if (estadoAsistencia == null) {
            return false;
        }
        return AsistenciaEstadoEnum.valueOf(estadoAsistencia) == AsistenciaEstadoEnum.SIN_ASISTENCIA;
    }

    public BigDecimal getImporteDeuda() {
        if (this.getEstadoEnum() == AlumnoViajeCursoEstadoEnum.DEUDA) {
            return this.importeAsignado.subtract(this.importeJustificado);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "importeAsignado", importeAsignado, false);
        ModelUtils.getDataByAttr(join, "importeJustificado", importeJustificado, false);
        ModelUtils.getDataByAttr(join, "importeDevuelto", importeDevuelto, false);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "estadoSubvencion", estadoSubvencion, false);
        ModelUtils.getDataByAttr(join, "estadoSalud", estadoSalud, false);
        ModelUtils.getDataByAttr(join, "estadoAsistencia", estadoAsistencia, false);
        ModelUtils.getDataByAttr(join, "impedimentosAcademicos", impedimentosAcademicos, false);
        ModelUtils.getDataByAttr(join, "celularApoderado", celularApoderado, false);
        ModelUtils.getDataByAttr(join, "esMenorEdad", esMenorEdad, false);
        ModelUtils.getDataByAttr(join, "estoySano", estoySano, false);
        ModelUtils.getDataByAttr(join, "motivoNoEstoySano", motivoNoEstoySano, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaInscripcion", fechaInscripcion, false);
        ModelUtils.getDataByAttr(join, "fechaSeparacion", fechaSeparacion, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoSeparacion", fechaVoBoSeparacion, false);
        ModelUtils.getDataByAttr(join, "fechaRenuncia", fechaRenuncia, false);
        ModelUtils.getDataByAttr(join, "fechaVideo", fechaVideo, false);
        ModelUtils.getDataByAttr(join, "fechaEstadoSalud", fechaEstadoSalud, false);
        ModelUtils.getDataByAttr(join, "fechaDictamenMedico", fechaDictamenMedico, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoMenores", fechaVoBoMenores, false);
        ModelUtils.getDataByAttr(join, "fechaExclusionMenores", fechaExclusionMenores, false);
        ModelUtils.getDataByAttr(join, "fechaRegistroAsistencia", fechaRegistroAsistencia, false);
        ModelUtils.getDataByAttr(join, "fechaEstoySano", fechaEstoySano, false);
        ModelUtils.getDataByAttrObject(join, "viajeCurso", viajeCurso, "id", "estadoViaje");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "tipoCursoCurricula", tipoCursoCurricula, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "personaCuentaBancaria", personaCuentaBancaria, "id", "numeroCuenta");
        ModelUtils.getDataByAttrObject(join, "delegadoSeparador", delegadoSeparador, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "formularioApoderado", formularioApoderado, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "videoApoderado", videoApoderado, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "colaboradorVoBoMenores", colaboradorVoBoMenores, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "tramiteSubvencion", tramiteSubvencion, "id");
        ModelUtils.getDataByAttrObject(join, "ordenSubvencionEconomia", ordenSubvencionEconomia, "id");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
