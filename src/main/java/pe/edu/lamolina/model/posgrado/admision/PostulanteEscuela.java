package pe.edu.lamolina.model.posgrado.admision;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.PostulanteEscuelaEnum;
import pe.edu.lamolina.model.enums.TipoAbonoEnum;
import pe.edu.lamolina.model.enums.TipoEntrevistaEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.posgrado.concepto.TransferenciaSwift;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Resolucion;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "epg_postulante_escuela")
public class PostulanteEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_ingreso")
    private String tipoIngreso;

    @Column(name = "motivo_postulacion")
    private String motivoPostulacion;

    @Column(name = "linea_investigacion")
    private String lineaInvestigacion;

    @Column(name = "operacion_origen_swift")
    private String operacionOrigenSwift;

    @Column(name = "operacion_destino_swift")
    private String operacionDestinoSwift;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "tipo_entrevista")
    private String tipoEntrevista;

    @Column(name = "cuenta_skype")
    private String cuentaSkype;

    @Column(name = "puntaje_final")
    private BigDecimal puntajeFinal;

    @Column(name = "orden_merito")
    private Integer ordenMerito;

    @Column(name = "hora_entrevista")
    private String horaEntrevista;

    @Column(name = "lugar_entrevista")
    private String lugarEntrevista;

    @Column(name = "nota_contacto")
    private String notaContacto;

    @Column(name = "importe_pagar")
    private BigDecimal importePagar;

    @Column(name = "importe_abono")
    private BigDecimal importeAbono;

    @Column(name = "monto_origen_swift")
    private BigDecimal montoOrigenSwift;

    @Column(name = "monto_destino_swift")
    private BigDecimal montoDestinoSwift;

    @Column(name = "documentos_entregados")
    private Integer documentosEntregados;

    @Column(name = "documentos_observados")
    private Integer documentosObservados;

    @Column(name = "avance_actividades")
    private Integer avanceActividades;

    @Column(name = "supernumerario")
    private Boolean supernumerario;

    @Column(name = "revision_documento_coordinador")
    private Boolean revisionDocumentoCoordinador;

    @Column(name = "devolucion_abono")
    private Boolean devolucionAbono;

    @Column(name = "falta_revisar")
    private Integer faltaRevisar;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_registra_swift")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistraSwift;

    @Column(name = "fecha_valida_swift")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaValidaSwift;

    @Column(name = "fecha_origen_swift")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaOrigenSwift;

    @Column(name = "fecha_entrevista")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaEntrevista;

    @Column(name = "fecha_destino_swift")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaDestinoSwift;

    @Column(name = "fecha_fin_evaluacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFinEvaluacion;

    @Column(name = "fecha_ultimo_contacto")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaUltimoContacto;

    @Column(name = "fecha_envio_carta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEnvioCarta;

    @Column(name = "fecha_devolucion_abono")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaDevolucionAbono;

    @Column(name = "fecha_rechazado")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRechazado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_voucher_swift")
    private Archivo archivoVoucherSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_banco_swift")
    private CuentaBancaria cuentaBancoSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado_escuela")
    private InteresadoEscuela interesadoEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_escuela")
    private CicloEscuela cicloEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_escuela")
    private CarreraEscuela carreraEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transferencia_swift")
    private TransferenciaSwift transferenciaSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_condicion_admitido_escuela")
    private CondicionAdmitidoEscuela condicionAdmitidoEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_carta_coordinador")
    private Archivo archivoCartaCoordinador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registra_swift")
    private Usuario userRegistroSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_valida_swift")
    private Usuario userValidaSwift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_fin_evaluacion")
    private Usuario userFinEvaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_envio_carta")
    private Usuario userEnvioCarta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_contacto")
    private Usuario userContacto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_devolucion_abono")
    private Usuario userDevolucionAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_rechazar")
    private Usuario userRechazar;

    @OneToMany(mappedBy = "postulanteEscuela", fetch = FetchType.LAZY)
    private List<PostulanteDocumentoEscuela> postulanteDocumentoEscuela;

    @OneToMany(mappedBy = "postulanteEscuela", fetch = FetchType.LAZY)
    private List<PuntajePostulanteAspecto> puntajePostulanteAspecto;

    @OneToMany(mappedBy = "postulanteEscuela", fetch = FetchType.LAZY)
    private List<ActividadPostulanteEscuela> actividadPostulanteEscuela;

    @OneToMany(mappedBy = "postulanteEscuela", fetch = FetchType.LAZY)
    private List<CursoPostulanteEscuela> cursoPostulanteEscuela;

    @Transient
    private BigDecimal puntajeEvaluacion;

    @Transient
    private Boolean seleccionado;

    @Transient
    private Boolean reqCurso;

    @Transient
    private Boolean isEvaluado;

    @Transient
    private Boolean isCertificado;

    @Transient
    private Alumno alumno;

    public PostulanteEscuela() {
        this.devolucionAbono = Boolean.FALSE;
    }

    public PostulanteEscuela(Object id) {
        this.devolucionAbono = Boolean.FALSE;
        this.id = TypesUtil.getLong(id);
    }

    public PostulanteEscuelaEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return PostulanteEscuelaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(PostulanteEscuelaEnum estado) {
        this.estado = estado.name();
    }

    public TipoAbonoEnum getTipoAbonoEnum() {
        if (StringUtils.isBlank(tipoAbono)) {
            return null;
        }
        return TipoAbonoEnum.valueOf(tipoAbono);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoAbonoEnum tipoAbono) {
        this.tipoAbono = tipoAbono.name();
    }

    public TipoEntrevistaEnum getTipoEntrevistaEnum() {
        if (StringUtils.isBlank(tipoEntrevista)) {
            return null;
        }
        return TipoEntrevistaEnum.valueOf(tipoEntrevista);
    }

    @JsonIgnore
    public void setTipoEntrevistaEnum(TipoEntrevistaEnum tipoEntrevista) {
        this.tipoEntrevista = tipoEntrevista.name();
    }

    public Boolean getSupernumerario() {
        if (supernumerario == null) {
            return false;
        }
        return supernumerario;
    }

    public Boolean getSeleccionado() {
        if (seleccionado == null) {
            return false;
        }
        return seleccionado;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "tipoIngreso", tipoIngreso, false);
        ModelUtils.getDataByAttr(join, "motivoPostulacion", motivoPostulacion, false);
        ModelUtils.getDataByAttr(join, "lineaInvestigacion", lineaInvestigacion, false);
        ModelUtils.getDataByAttr(join, "operacionOrigenSwift", operacionOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "operacionDestinoSwift", operacionDestinoSwift, false);
        ModelUtils.getDataByAttr(join, "operacionDestinoSwift", operacionDestinoSwift, false);
        ModelUtils.getDataByAttr(join, "tipoAbono", tipoAbono, false);
        ModelUtils.getDataByAttr(join, "tipoEntrevista", tipoEntrevista, false);
        ModelUtils.getDataByAttr(join, "cuentaSkype", cuentaSkype, false);
        ModelUtils.getDataByAttr(join, "puntajeFinal", puntajeFinal, false);
        ModelUtils.getDataByAttr(join, "ordenMerito", ordenMerito, false);
        ModelUtils.getDataByAttr(join, "horaEntrevista", horaEntrevista, false);
        ModelUtils.getDataByAttr(join, "lugarEntrevista", lugarEntrevista, false);
        ModelUtils.getDataByAttr(join, "notaContacto", notaContacto, false);
        ModelUtils.getDataByAttr(join, "importePagar", importePagar, false);
        ModelUtils.getDataByAttr(join, "importeAbono", importeAbono, false);
        ModelUtils.getDataByAttr(join, "montoOrigenSwift", montoOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "montoDestinoSwift", montoDestinoSwift, false);
        ModelUtils.getDataByAttr(join, "documentosEntregados", documentosEntregados, false);
        ModelUtils.getDataByAttr(join, "documentosObservados", documentosObservados, false);
        ModelUtils.getDataByAttr(join, "avanceActividades", avanceActividades, false);
        ModelUtils.getDataByAttr(join, "supernumerario", supernumerario, false);
        ModelUtils.getDataByAttr(join, "revisionDocumentoCoordinador", revisionDocumentoCoordinador, false);
        ModelUtils.getDataByAttr(join, "devolucionAbono", devolucionAbono, false);
        ModelUtils.getDataByAttr(join, "faltaRevisar", faltaRevisar, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaRegistraSwift", fechaRegistraSwift, false);
        ModelUtils.getDataByAttr(join, "fechaValidaSwift", fechaValidaSwift, false);
        ModelUtils.getDataByAttr(join, "fechaOrigenSwift", fechaOrigenSwift, false);
        ModelUtils.getDataByAttr(join, "fechaEntrevista", fechaEntrevista, false);
        ModelUtils.getDataByAttr(join, "fechaDestinoSwift", fechaDestinoSwift, false);
        ModelUtils.getDataByAttr(join, "fechaFinEvaluacion", fechaFinEvaluacion, false);
        ModelUtils.getDataByAttr(join, "fechaUltimoContacto", fechaUltimoContacto, false);
        ModelUtils.getDataByAttr(join, "fechaUltimoContacto", fechaUltimoContacto, false);
        ModelUtils.getDataByAttr(join, "fechaDevolucionAbono", fechaDevolucionAbono, false);
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userRegistroSwift", userRegistroSwift, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userValidaSwift", userValidaSwift, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userFinEvaluacion", userFinEvaluacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userContacto", userContacto, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userDevolucionAbono", userDevolucionAbono, "id", "google");
        ModelUtils.getDataByAttrObject(join, "cuentaBancoSwift", cuentaBancoSwift, "id", "numero");
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "interesadoEscuela", interesadoEscuela, "id", "numeroDocIdentidad", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "archivoVoucherSwift", archivoVoucherSwift, "id", "ruta");

        ModelUtils.getDataByAttrObject(join, "cicloEscuela", cicloEscuela, "id");
        if (cicloEscuela != null && cicloEscuela.getCicloAcademico() != null) {
            ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloEscuela.getCicloAcademico(), "id", "descripcion");
        }

        ModelUtils.getDataByAttrObject(join, "carreraEscuela", carreraEscuela, "id");
        if (carreraEscuela != null && carreraEscuela.getCarrera() != null) {
            ModelUtils.getDataByAttrObject(join, "carrera", carreraEscuela.getCarrera(), "id", "nombre");
        }

        ModelUtils.getDataByAttrObject(join, "transferenciaSwift", transferenciaSwift, "id", "bancoOrigen");
        ModelUtils.getDataByAttrObject(join, "condicionAdmitidoEscuela", condicionAdmitidoEscuela, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "resolucion", resolucion, "id", "serie", "numero", "fecha");

        return join.toString();
    }

}
