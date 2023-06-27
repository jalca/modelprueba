package pe.edu.lamolina.model.finanzas;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.enums.NombreTablasEnum;
import pe.edu.lamolina.model.enums.ProcesoMethodEnum;
import pe.edu.lamolina.model.enums.TipoAbonoEnum;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.medico.ExamenMedico;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.DeudaTramite;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "fin_acreencia")
public class Acreencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tabla")
    private String tabla;

    @Column(name = "instancia_tabla")
    private Long instanciaTabla;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "mora_diaria")
    private BigDecimal moraDiaria;

    @Column(name = "mora")
    private BigDecimal mora;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "reenviar_recauda")
    private Integer reenviarRecauda;

    @Column(name = "veces_reenvio")
    private Integer vecesReenvio;

    @Column(name = "desvinculado")
    private Boolean desvinculado;

    @Column(name = "proceso_registro")
    private String procesoRegistro;

    @Column(name = "proceso_actualizacion")
    private String procesoActualizacion;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_documento")
    private Date fechaDocumento;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_reenvio_recauda")
    private Date fechaReenvioRecauda;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_preinicio_mora")
    private Date fechaPreinicioMora;

    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_abono")
    private Date fechaAbono;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_envio_recauda")
    private Date fechaEnvioRecauda;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_envio_anulacion")
    private Date fechaEnvioAnulacion;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_lectura")
    private Date fechaLectura;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_lectura")
    private Usuario usuarioLectura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario usuarioAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "acreencia", fetch = FetchType.LAZY)
    private List<MovimientoCajaAcreencia> movimientoCajaAcreencia;

    @OneToMany(mappedBy = "acreencia", fetch = FetchType.LAZY)
    private List<ItemCargaAbono> itemCargaAbono;

    @Transient
    private DeudaAlumno deudaAlumno;

    @Transient
    private boolean seleccionado;

    @Transient
    private String tipoAbono;

    public Acreencia() {
        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
        this.desvinculado = false;
    }

    public Acreencia(
            Oficina oficina,
            CuentaBancaria cuentaBancaria,
            ExamenMedico examenMedico,
            Persona persona) {
        this.oficina = oficina;
        this.abono = BigDecimal.ZERO;
        this.monto = examenMedico.getMontoTotal();
        this.fechaDocumento = examenMedico.getFechaRegistro();
        this.fechaVencimiento = examenMedico.getFechaVencimiento();
        this.fechaPreinicioMora = examenMedico.getFechaVencimiento();
        this.cuentaBancaria = cuentaBancaria;
        this.descripcion = cuentaBancaria.getNombre();
        this.instanciaTabla = examenMedico.getId();
        this.tabla = NombreTablasEnum.MED_EXAMEN_MEDICO.name();
        this.estado = DeudaEstadoEnum.DEU.name();
        this.fechaRegistro = examenMedico.getFechaRegistro();
        this.usuarioRegistro = examenMedico.getUserRegistro();
        this.persona = persona;
        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
        this.desvinculado = false;
    }

    public Acreencia(
            Oficina oficina,
            Persona persona,
            DeudaAlumno deudaAlumno) {

        this.oficina = oficina;
        this.abono = BigDecimal.ZERO;
        this.monto = deudaAlumno.getMonto().subtract(deudaAlumno.getAbono());
        this.fechaDocumento = deudaAlumno.getFechaEmision();
        this.fechaVencimiento = deudaAlumno.getFechaVencimiento();
        this.fechaPreinicioMora = deudaAlumno.getFechaPreinicioMora();
        this.cuentaBancaria = deudaAlumno.getCuentaBancaria();
        this.instanciaTabla = deudaAlumno.getId();
        this.tabla = NombreTablasEnum.FIN_DEUDA_ALUMNO.name();
        this.persona = persona;
        this.descripcion = deudaAlumno.getConcepto();
        this.estado = DeudaEstadoEnum.DEU.name();
        this.fechaRegistro = new Date();
        this.usuarioRegistro = deudaAlumno.getUserRegistro();
        this.moraDiaria = deudaAlumno.getMoraDiaria();
        this.mora = deudaAlumno.getMora();
        this.desvinculado = false;
    }

    public Acreencia(
            Oficina oficina,
            Persona persona,
            DeudaTramite deudaTramite) {

        this.oficina = oficina;
        this.abono = BigDecimal.ZERO;
        this.monto = deudaTramite.getMonto();
        this.fechaDocumento = deudaTramite.getFechaEmision();
        this.fechaVencimiento = deudaTramite.getFechaVencimiento();
        this.fechaPreinicioMora = deudaTramite.getFechaVencimiento();
        this.cuentaBancaria = deudaTramite.getCuentaBancaria();
        this.instanciaTabla = deudaTramite.getId();
        this.tabla = NombreTablasEnum.FIN_DEUDA_TRAMITE.name();
        this.persona = persona;
        this.descripcion = deudaTramite.getConceptoTramite().getNombre();
        this.estado = DeudaEstadoEnum.DEU.name();
        this.fechaRegistro = new Date();
        this.usuarioRegistro = deudaTramite.getUserRegistro();
        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
        this.desvinculado = false;
    }

    public Acreencia(
            Oficina oficina,
            Persona persona,
            CuentaBancaria cuentaBancaria,
            DeudaTramite deudaTramite) {

        this.oficina = oficina;
        this.abono = BigDecimal.ZERO;
        this.monto = deudaTramite.getSaldo();
        this.fechaDocumento = deudaTramite.getFechaEmision();
        this.fechaVencimiento = deudaTramite.getFechaVencimiento();
        this.fechaPreinicioMora = deudaTramite.getFechaVencimiento();
        this.cuentaBancaria = cuentaBancaria;
        this.instanciaTabla = deudaTramite.getId();
        this.tabla = NombreTablasEnum.FIN_DEUDA_TRAMITE.name();
        this.persona = persona;
        this.descripcion = deudaTramite.getConceptoTramite().getNombre();
        this.estado = DeudaEstadoEnum.DEU.name();
        this.fechaRegistro = new Date();
        this.usuarioRegistro = deudaTramite.getUserRegistro();
        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
        this.desvinculado = false;
    }

    public Acreencia(Object id) {
        this.id = TypesUtil.getLong(id);
        this.desvinculado = false;
    }

    public NombreTablasEnum getTablaEnum() {
        if (tabla == null) {
            return null;
        }
        return NombreTablasEnum.valueOf(tabla);
    }

    @JsonIgnore
    public void setTablaEnum(NombreTablasEnum tablaEnum) {
        if (tablaEnum == null) {
            return;
        }
        tabla = tablaEnum.name();
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        estado = estadoEnum.name();
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoAbonoEnum tipoAbono) {
        if (tipoAbono == null) {
            return;
        }
        this.tipoAbono = tipoAbono.name();
    }

    public TipoAbonoEnum getTipoAbonoEnum() {
        if (tipoAbono == null) {
            return null;
        }
        return TipoAbonoEnum.valueOf(tipoAbono);
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        if (this.fechaPreinicioMora == null && fechaVencimiento != null) {
            this.fechaPreinicioMora = fechaVencimiento;
        }
    }

    public boolean isEstadoAnulado() {
        return DeudaEstadoEnum.ANU.name().equals(this.estado);
    }

    @JsonIgnore
    public void setProcesoRegistroEnum(ProcesoMethodEnum procesoEnum) {
        if (procesoEnum == null) {
            return;
        }
        this.procesoRegistro = procesoEnum.name();
    }

    @JsonIgnore
    public void setProcesoActualizacionEnum(ProcesoMethodEnum procesoEnum) {
        if (procesoEnum == null) {
            return;
        }
        this.procesoActualizacion = procesoEnum.name();
    }

    public boolean isTablaDeudaAlumno() {
        return NombreTablasEnum.FIN_DEUDA_ALUMNO == this.getTablaEnum();
    }

    public boolean isTablaDeudaTallerVerano() {
        return NombreTablasEnum.EXTN_DEUDA_TALLER_VERANO == this.getTablaEnum();
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public String toString() {
        return "Acreencia{" + "id=" + id + ", tabla=" + tabla + ", instanciaTabla=" + instanciaTabla + ", estado=" + estado + ", descripcion=" + descripcion + ", monto=" + monto + ", abono=" + abono + ", fechaDocumento=" + fechaDocumento + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

}
