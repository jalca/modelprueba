package pe.edu.lamolina.model.bienestar;

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
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.contabilidad.JustificacionGasto;
import pe.edu.lamolina.model.contabilidad.OrdenSubvencionEconomia;
import pe.edu.lamolina.model.enums.subvenciones.EtapaObservacionEnum;
import pe.edu.lamolina.model.enums.subvenciones.SubvencionViajeEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.ViajeCursoEstadoEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_viaje_curso")
public class ViajeCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "solicitar_subvencion")
    private Boolean solicitarSubvencion;

    @Column(name = "estado_viaje")
    private String estadoViaje;

    @Column(name = "estado_subvencion")
    private String estadoSubvencion;

    @Column(name = "etapa_observacion")
    private String etapaObservacion;

    @Column(name = "ruta_viaje")
    private String rutaViaje;

    @Column(name = "descripcion_viaje")
    private String descripcionViaje;

    @Column(name = "importe_proforma")
    private BigDecimal importeProforma;

    @Column(name = "importe_solicitado")
    private BigDecimal importeSolicitado;

    @Column(name = "importe_alumno")
    private BigDecimal importeAlumno;

    @Column(name = "importe_entregado")
    private BigDecimal importeEntregado;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @Column(name = "importe_devuelto")
    private BigDecimal importeDevuelto;

    @Column(name = "cantidad_alumnos_matriculados")
    private Integer cantidadAlumnosMatriculados;

    @Column(name = "cantidad_alumnos_registrados")
    private Integer cantidadAlumnosRegistrados;

    @Column(name = "cantidad_alumnos_aprobados")
    private Integer cantidadAlumnosAprobados;

    @Column(name = "cantidad_alumnos_separados")
    private Integer cantidadAlumnosSeparados;

    @Column(name = "cantidad_alumnos_viajaron")
    private Integer cantidadAlumnosViajaron;

    @Column(name = "tiene_objeciones")
    private Boolean tieneObjeciones;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_creacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_vobo_departamento")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoDepartamento;

    @Column(name = "fecha_cierre_descripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreDescripcion;

    @Column(name = "fecha_fin_registro_alumnos")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinRegistroAlumnos;

    @Column(name = "fecha_importe_alumno")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaImporteAlumno;

    @Column(name = "fecha_vobo_jefatura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoJefatura;

    @Column(name = "fecha_vobo_asistencia")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoAsistencia;

    @Column(name = "fecha_vobo_justificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoJustificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente_creador")
    private Docente docenteCreador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_delegado")
    private Alumno alumnoDelegado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jefe_departamento_vobo")
    private Colaborador jefeDepartamentoVobo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_vobo_jefatura")
    private Colaborador colaboradorVoBoJefatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierre_descripcion")
    private Usuario userCierreDescripcion;

    @Transient
    private List<CronogramaEventoSubvencionado> cronogramasViaje;
    @Transient
    private List<ProformaEventoSubvencionado> proformasViaje;
    @Transient
    private List<AlumnoViajeCurso> alumnosViaje;
    @Transient
    private List<ObjecionViajeEvento> objeciones;
    @Transient
    private JustificacionGasto justificacion;
    @Transient
    private OrdenSubvencionEconomia ordenSubvencionEconomia;
    @Transient
    private String motivoCambio;

    public ViajeCurso() {
        this.tieneObjeciones = Boolean.FALSE;
    }

    public ViajeCurso(Object id) {
        this.tieneObjeciones = Boolean.FALSE;
        this.id = TypesUtil.getLong(id);
    }

    public ViajeCursoEstadoEnum getEstadoViajeEnum() {
        if (estadoViaje == null) {
            return null;
        }
        return ViajeCursoEstadoEnum.valueOf(estadoViaje);
    }

    @JsonIgnore
    public void setEstadoViajeEnum(ViajeCursoEstadoEnum estadoViaje) {
        if (estadoViaje == null) {
            return;
        }
        this.estadoViaje = estadoViaje.name();
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

    public EtapaObservacionEnum getEtapaObservacionEnum() {
        if (etapaObservacion == null) {
            return null;
        }
        return EtapaObservacionEnum.valueOf(etapaObservacion);
    }

    @JsonIgnore
    public void setEtapaObservacionEnum(EtapaObservacionEnum etapaObservacion) {
        if (etapaObservacion == null) {
            return;
        }
        this.etapaObservacion = etapaObservacion.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estadoViaje", estadoViaje, false);
        ModelUtils.getDataByAttr(join, "estadoSubvencion", estadoSubvencion, false);
        ModelUtils.getDataByAttr(join, "etapaObservacion", etapaObservacion, false);
        ModelUtils.getDataByAttr(join, "descripcionViaje", descripcionViaje, false);
        ModelUtils.getDataByAttr(join, "importeProforma", importeProforma, false);
        ModelUtils.getDataByAttr(join, "importeSolicitado", importeSolicitado, false);
        ModelUtils.getDataByAttr(join, "importeAlumno", importeAlumno, false);
        ModelUtils.getDataByAttr(join, "importeEntregado", importeEntregado, false);
        ModelUtils.getDataByAttr(join, "importeUtilizado", importeUtilizado, false);
        ModelUtils.getDataByAttr(join, "importeDevuelto", importeDevuelto, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnosMatriculados", cantidadAlumnosMatriculados, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnosRegistrados", cantidadAlumnosRegistrados, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnosAprobados", cantidadAlumnosAprobados, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnosSeparados", cantidadAlumnosSeparados, false);
        ModelUtils.getDataByAttr(join, "cantidadAlumnosViajaron", cantidadAlumnosViajaron, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaCreacion", fechaCreacion, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoDepartamento", fechaVoBoDepartamento, false);
        ModelUtils.getDataByAttr(join, "fechaCierreDescripcion", fechaCierreDescripcion, false);
        ModelUtils.getDataByAttr(join, "fechaFinRegistroAlumnos", fechaFinRegistroAlumnos, false);
        ModelUtils.getDataByAttr(join, "fechaImporteAlumno", fechaImporteAlumno, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoJefatura", fechaVoBoJefatura, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoAsistencia", fechaVoBoAsistencia, false);
        ModelUtils.getDataByAttr(join, "fechaVoBoJustificacion", fechaVoBoJustificacion, false);
        ModelUtils.getDataByAttr(join, "tieneObjeciones", tieneObjeciones, false);
        ModelUtils.getDataByAttr(join, "justificacion", justificacion, false);
        ModelUtils.getDataByAttrObject(join, "curso", curso, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "descripcion");
        ModelUtils.getDataByAttrObject(join, "seccion", seccion, "id", "codigo2");
        ModelUtils.getDataByAttrObject(join, "docenteCreador", docenteCreador, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "alumnoDelegado", alumnoDelegado, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "jefeDepartamentoVobo", jefeDepartamentoVobo, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "colaboradorVoBoJefatura", colaboradorVoBoJefatura, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userCierreDescripcion", userCierreDescripcion, "id", "google");

        return join.toString();
    }
}
