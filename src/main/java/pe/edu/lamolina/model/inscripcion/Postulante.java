package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Puerta;
import pe.edu.lamolina.model.academico.RecorridoIngresante;
import pe.edu.lamolina.model.academico.TipoActividadIngresante;
import pe.edu.lamolina.model.constantines.AcademicoConstantine;
import pe.edu.lamolina.model.enums.EstadoCareoEnum;
import pe.edu.lamolina.model.enums.MotivoDescuemtoEnum;
import pe.edu.lamolina.model.enums.PostulanteEstadoEnum;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.IDOC;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.ING;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.INS;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.NEXM;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.NING;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.PAGO;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.PDOC;
import static pe.edu.lamolina.model.enums.PostulanteEstadoEnum.PRE;
import pe.edu.lamolina.model.examen.ExamenVirtual;
import pe.edu.lamolina.model.finanzas.AbonoPostulante;
import pe.edu.lamolina.model.finanzas.ItemCargaAbono;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.GradoSecundaria;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "sip_postulante")
public class Postulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "email")
    private String email;

    @Column(name = "clave")
    private String clave;

    @Column(name = "orden_atencion")
    private String ordenAtencion;

    @Column(name = "colegio_extranjero")
    private String colegioExtranjero;

    @Column(name = "year_egreso_colegio")
    private Integer yearEgresoColegio;

    @Column(name = "numero_asiento")
    private Integer numeroAsiento;

    @Column(name = "importe_pagar")
    private BigDecimal importePagar;

    @Column(name = "importe_abonado")
    private BigDecimal importeAbonado;

    @Column(name = "importe_descuento")
    private BigDecimal importeDescuento;

    @Column(name = "importe_total")
    private BigDecimal importeTotal;

    @Column(name = "importe_utilizado")
    private BigDecimal importeUtilizado;

    @Column(name = "pension_colegio")
    private BigDecimal pensionColegio;

    @Column(name = "motivo_descuento")
    private String motivoDescuento;

    @Column(name = "universidad_extranjera")
    private String universidadExtranjera;

    @Column(name = "motivo_cambio")
    private String motivoCambio;

    @Column(name = "tipo_gestion")
    private String tipoGestion;

    @Column(name = "codigo_alumno")
    private String codigoAlumno;

    @Column(name = "grado_titulo")
    private String gradoTitulo;

    @Column(name = "grado_universidad")
    private String gradoUniversidad;

    @Column(name = "ruta_foto_postulante")
    private String rutaFotoPostulante;

    @Column(name = "documentos_recibidos")
    private Integer documentosRecibidos;

    @Column(name = "solicita_anulacion")
    private Integer solicitaAnulacion;

    @Column(name = "url_documento_renuncia")
    private String urlDocumentoRenuncia;

    @Column(name = "direccion_lima")
    private String direccionLima;

    @Column(name = "direccion_origen")
    private String direccionOrigen;

    @Column(name = "coordenada_lima")
    private String coordenadaLima;

    @Column(name = "coordenada_origen")
    private String coordenadaOrigen;

    @Column(name = "pov_origen")
    private String povOrigen;

    @Column(name = "url_foto_fachada_Lima")
    private String urlFotoFachadaLima;

    @Column(name = "url_foto_fachada_Origen")
    private String urlFotoFachadaOrigen;

    @Column(name = "telefono_lima")
    private String telefonoLima;

    @Column(name = "telefono_origen")
    private String telefonoOrigen;

    @Column(name = "especialidad_universidad")
    private String especialidadUniversidad;

    @Column(name = "institucion_estudio_simultaneo")
    private String institucionEstudioSimultaneo;

    @Column(name = "sede_universidad")
    private String sedeUniversidad;

    @Column(name = "estado_careo")
    private String estadoCareo;

    @Column(name = "cambio_dni")
    private Integer cambioDni;

    @Column(name = "revision_minedu")
    private String revisionMinedu;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_descuento")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDescuento;

    @Column(name = "fecha_inscripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    @Column(name = "fecha_documentos")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDocumentos;

    @Column(name = "fecha_preinscripcion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPreinscripcion;

    @Column(name = "fecha_ingreso")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name = "fecha_cambio_modalidad")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCambioModalidad;

    @Column(name = "fecha_validacion_minedu")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacionMinedu;

    @Column(name = "fecha_anulacion_renuncia")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacionRenuncia;

    @Column(name = "fecha_encuesta")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEncuesta;

    @Column(name = "fecha_careo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCareo;

    @Column(name = "fecha_confirma_educacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaConfirmaEducacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta")
    private ExamenVirtual encuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_simulacion")
    private ModalidadIngreso modalidadSimulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_colegio")
    private Pais paisColegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio_procedencia")
    private Colegio colegioProcedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad_procedencia")
    private Universidad universidadProcedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_universidad")
    private Pais paisUniversidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_origen")
    private Pais paisOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prospecto")
    private Prospecto prospecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_descuento_examen")
    private DescuentoExamen descuentoExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula_examen")
    private AulaExamen aulaExamen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado_secundaria")
    private GradoSecundaria gradoSecundaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_lima")
    private Ubicacion ubicacionLima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_origen")
    private Ubicacion ubicacionOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_documentos")
    private Usuario userDocumentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion_minedu")
    private Usuario userValidacionMinedu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_descuento")
    private Usuario userDescuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion_renuncia")
    private Usuario userAnulacionRenuncia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_careo")
    private Usuario userCareo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_confirma_educacion")
    private Usuario userConfirmaEducacion;

    @OneToMany(mappedBy = "postulante", fetch = FetchType.LAZY)
    private List<AbonoPostulante> abonoPostulante;

    @OneToMany(mappedBy = "postulante", fetch = FetchType.LAZY)
    private List<ItemCargaAbono> itemCargaAbono;

    @OneToMany(mappedBy = "postulante", fetch = FetchType.LAZY)
    private List<OpcionCarrera> opcionCarrera;

    @OneToMany(mappedBy = "postulante", fetch = FetchType.LAZY)
    private List<PostulanteDocumento> postulanteDocumento;

    @Column(name = "radicaba_fuera_lima")
    private Boolean radicabaFueraLima;

    @Transient
    private String aula;
    @Transient
    private String numeroOperacionTrans;
    @Transient
    private String numeroDocumentoTrans;
    @Transient
    private Integer pagos;
    @Transient
    private BigDecimal pagosProspecto;
    @Transient
    private BigDecimal pagosInscripcion;
    @Transient
    private BigDecimal pagosExtemporaneo;
    @Transient
    private Integer documentosCompletos;
    @Transient
    private ModalidadIngresoCiclo modalidadIngresoCiclo;
    @Transient
    private Ingresante ingresante;
    @Transient
    private Integer aleatorio;
    @Transient
    private String codigoCepre;
    @Transient
    private Prelamolina prelamolina;
    @Transient
    private String tipoProspecto;
    @Transient
    private TurnoEntrevistaObuae turnoEntrevistaObuae;
    @Transient
    private List<String> observaciones;
    @Transient
    private MetalesPostulante metalesPostulante;
    @Transient
    private TipoActividadIngresante tipo;
    @Transient
    private RecorridoIngresante recorrido;
    @Transient
    private Puerta puerta;

    public Postulante() {
        solicitaAnulacion = 0;
    }

    public Postulante(Long id, String codigo, BigDecimal pagosProspecto, String tipo) {
        this.id = id;
        this.codigo = codigo;
        if (tipo.equals("PROSPECTO")) {
            this.pagosProspecto = pagosProspecto;
        }
        if (tipo.equals("INSCRIPCION")) {
            this.pagosInscripcion = pagosProspecto;
        }
        if (tipo.equals("EXTEMPORANEO")) {
            this.pagosExtemporaneo = pagosProspecto;
        }
    }

    public Postulante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getTipoInstitucion() {
        if (this.getColegioProcedencia() != null) {
            return "Colegio";
        }
        if (!StringUtils.isEmpty(this.getColegioExtranjero())) {
            return "Colegio";
        }
        return "Universidad";
    }

    public boolean esDummy() {
        return codigo.equals(AcademicoConstantine.CODE_POSTULANTE_DUMMY);
    }

    public boolean isColegioCoar() {
        if (colegioProcedencia == null) {
            return false;
        }
        return colegioProcedencia.isCoar();
    }

    public PostulanteEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return PostulanteEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstado(PostulanteEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoCareoEnum getEstadoCareoEnum() {
        if (estadoCareo == null) {
            return EstadoCareoEnum.PEND;
        }
        return EstadoCareoEnum.valueOf(estadoCareo);
    }

    public MotivoDescuemtoEnum getMotivoDescuentoEnum() {
        if (this.motivoDescuento == null) {
            return null;
        }
        return MotivoDescuemtoEnum.valueOf(this.motivoDescuento);
    }

    public void setMotivoDescuentoEnum(MotivoDescuemtoEnum motivodDescuemtoEnum) {
        if (motivodDescuemtoEnum == null) {
            return;
        }
        this.motivoDescuento = motivodDescuemtoEnum.name();
    }

    public Integer getDocumentosRecibidos() {
        if (documentosRecibidos == null) {
            return 0;
        }
        return documentosRecibidos;
    }

    public boolean isEstadoPreInscrito() {
        return Arrays.asList(PRE, PDOC).contains(this.getEstadoEnum());
    }

    public boolean isIngresante() {
        if (Arrays.asList(ING, IDOC).contains(this.getEstadoEnum())) {
            return true;
        }
        if (this.modalidadIngreso == null) {
            return false;
        }
        return PAGO == this.getEstadoEnum() && this.modalidadIngreso.isPreLaMolina();
    }

    public boolean isEstadoCreado() {
        if (PostulanteEstadoEnum.CRE.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isInscrito() {
        if (estado == null) {
            return false;
        }

        return Arrays.asList(INS, PAGO).contains(getEstadoEnum());
    }

    public boolean isSinVacante() {
        if (estado == null) {
            return false;
        }

        return Arrays.asList(NING, NEXM).contains(getEstadoEnum());
    }

    public boolean isCepre() {
        return this.modalidadIngreso.isPreLaMolina();
    }

    public static class CompareCantidadDocs implements Comparator<Postulante> {

        @Override
        public int compare(Postulante cp1, Postulante cp2) {
            return cp2.getDocumentosCompletos().compareTo(cp1.getDocumentosCompletos());
        }
    }

    public static class CompareAleatorio implements Comparator<Postulante> {

        @Override
        public int compare(Postulante cp1, Postulante cp2) {
            return cp1.getAleatorio().compareTo(cp2.getAleatorio());
        }
    }

    @Override
    public String toString() {
        return "Postulante{id=" + this.id + "}";
    }

}
