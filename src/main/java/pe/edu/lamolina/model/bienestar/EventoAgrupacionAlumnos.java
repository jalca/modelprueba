package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import pe.edu.lamolina.model.contabilidad.JustificacionGasto;
import pe.edu.lamolina.model.contabilidad.OrdenSubvencionEconomia;
import pe.edu.lamolina.model.contabilidad.PartidaPresupuestal;
import pe.edu.lamolina.model.enums.agrupaciones.DeudaRepresentanteEstadoEnum;
import pe.edu.lamolina.model.enums.agrupaciones.EventoAlumnosEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.SubvencionViajeEstadoEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.PersonaCuentaBancaria;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_evento_agrupacion_alumnos")
public class EventoAgrupacionAlumnos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_evento")
    private String tipoEvento;

    @Column(name = "cargo_representante")
    private String cargoRepresentante;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_subvencion")
    private String estadoSubvencion;

    @Column(name = "estado_deuda")
    private String estadoDeuda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "importe_solicitado")
    private BigDecimal importeSolicitado;

    @Column(name = "importe_aprobado")
    private BigDecimal importeAprobado;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @Column(name = "importe_proforma")
    private BigDecimal importeProforma;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tiene_objeciones")
    private Boolean tieneObjeciones;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_aprobacion_jefatura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAprobacionJefatura;

    @Column(name = "fecha_aprobacion_representantes")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAprobacionRepresentantes;

    @Column(name = "fecha_vobo_justificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVoBoJustificacion;

    @Column(name = "fecha_rechazar")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRechazar;

    @Column(name = "fecha_solicitud")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agrupacion_alumnos")
    private AgrupacionAlumnos agrupacionAlumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_representante")
    private Alumno alumnoRepresentante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_cuenta_bancaria")
    private PersonaCuentaBancaria personaCuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador_aprobacion")
    private Colaborador colaboradorAprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida_presupuestal")
    private PartidaPresupuestal partidaPresupuestal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_solicitud")
    private Usuario userSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_vobo_justificacion")
    private Usuario userVoBoJustificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_rechazar")
    private Usuario userRechazar;

    @Transient
    private List<AprobacionEventoRepresentante> aprobadoresEvento;
    @Transient
    private List<CronogramaEventoSubvencionado> cronogramasEvento;
    @Transient
    private List<ProformaEventoSubvencionado> proformasEvento;
    @Transient
    private List<BeneficiarioSubvencionEvento> beneficiariosEvento;
    @Transient
    private List<ObjecionViajeEvento> objeciones;
    @Transient
    private JustificacionGasto justificacion;
    @Transient
    private OrdenSubvencionEconomia ordenSubvencionEconomia;
    @Transient
    private RepresentanteAgrupacion representanteCreador;
    @Transient
    private AprobacionEventoRepresentante aprobadorActual;
    @Transient
    private BeneficiarioSubvencionEvento beneficiarioActual;
    @Transient
    private ObjecionViajeEvento objecionActual;
    @Transient
    private Boolean esDelegado;

    public EventoAgrupacionAlumnos() {
        this.tieneObjeciones = Boolean.FALSE;
    }

    public EventoAgrupacionAlumnos(Object id) {
        this.id = TypesUtil.getLong(id);
        this.tieneObjeciones = Boolean.FALSE;
    }

    public EventoAlumnosEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EventoAlumnosEstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EventoAlumnosEstadoEnum estado) {
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

    public DeudaRepresentanteEstadoEnum getEstadoDeudaEnum() {
        if (estadoDeuda == null) {
            return null;
        }
        return DeudaRepresentanteEstadoEnum.valueOf(estadoDeuda);
    }

    @JsonIgnore
    public void setEstadoDeudaEnum(DeudaRepresentanteEstadoEnum estadoDeuda) {
        if (estadoDeuda == null) {
            return;
        }
        this.estadoDeuda = estadoDeuda.name();
    }
}
