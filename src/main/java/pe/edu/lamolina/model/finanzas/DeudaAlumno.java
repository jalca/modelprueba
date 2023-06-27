package pe.edu.lamolina.model.finanzas;

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
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.aporte.AporteAlumnoCiclo;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.enums.TipoDeudaEnum;
import pe.edu.lamolina.model.enums.TipoEfectivoEnum;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.posgrado.AlumnoConceptoMatricula;
import pe.edu.lamolina.model.posgrado.AlumnoCuotaMatricula;
import pe.edu.lamolina.model.posgrado.ConceptoPosgrado;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "fin_deuda_alumno")
public class DeudaAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "mora_diaria")
    private BigDecimal moraDiaria;

    @Column(name = "mora")
    private BigDecimal mora;

    @Column(name = "detalle_json")
    private String detalleJson;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "tipo_deuda")
    private String tipoDeuda;

    @Column(name = "proceso_registro")
    private String procesoRegistro;

    @Column(name = "proceso_actualizacion")
    private String procesoActualizacion;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @Column(name = "fecha_emision")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEmision;

    @Column(name = "fecha_preinicio_mora")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaPreinicioMora;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaVencimiento;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAbono;

    @Column(name = "fecha_actualizacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActualizacion;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_factura_empresa")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFacturaEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_pago_verano")
    private AlumnoPagoVerano alumnoPagoVerano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura_empresa")
    private Empresa facturaEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_abono")
    private Usuario userAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_actualizacion")
    private Usuario userActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_factura_empresa")
    private Usuario userFacturaEmpresa;

    @Transient
    private List<AporteAlumnoCiclo> aportesAlumnosCiclo;
    @Transient
    private List<AlumnoCuotaMatricula> cuotasPosgrado;
    @Transient
    private List<AlumnoConceptoMatricula> conceptosPosgrado;

    @Transient
    private Acreencia acreencia;
    @Transient
    private BigDecimal montoInicial;

    public DeudaAlumno() {
        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
    }

    public DeudaAlumno(
            Alumno alumno,
            DeudaEstadoEnum estadoEnum,
            ConceptoPosgrado conceptoPosgrado,
            BigDecimal monto,
            TipoDeudaEnum tipoDeuda,
            Integer numeroCuota,
            Date fechaEmision,
            Date fechaVencimiento,
            Usuario userRegistro) {

        this.alumno = alumno;
        this.estado = estadoEnum.name();
        this.concepto = conceptoPosgrado.getNombre();
        this.monto = monto;
        this.abono = BigDecimal.ZERO;
        this.numeroCuota = numeroCuota;
        this.fechaRegistro = new Date();
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPreinicioMora = fechaVencimiento;
        this.tipoDeuda = tipoDeuda.name();
        this.cuentaBancaria = conceptoPosgrado.getCuentaBancaria();
        this.userRegistro = userRegistro;

        this.moraDiaria = BigDecimal.ZERO;
        this.mora = BigDecimal.ZERO;
    }

    public DeudaAlumno(
            Alumno alumno,
            DeudaEstadoEnum estadoEnum,
            ConceptoPosgrado conceptoPosgrado,
            AlumnoCuotaMatricula cuotaAlumno,
            TipoDeudaEnum tipoDeuda,
            Date fechaVencimiento,
            Usuario userRegistro) {

        this.alumno = alumno;
        this.estado = estadoEnum.name();
        this.concepto = conceptoPosgrado.getNombre();
        this.abono = BigDecimal.ZERO;
        this.monto = cuotaAlumno.getMontoCuota();
        this.numeroCuota = cuotaAlumno.getNumeroCuota();
        this.fechaEmision = cuotaAlumno.getFechaEmision();
        this.fechaPreinicioMora = cuotaAlumno.getFechaVencimiento();
        this.moraDiaria = cuotaAlumno.getMoraDiaria();
        this.mora = cuotaAlumno.getMora();
        this.fechaVencimiento = fechaVencimiento;
        this.tipoDeuda = tipoDeuda.name();
        this.cuentaBancaria = conceptoPosgrado.getCuentaBancaria();

        this.userRegistro = userRegistro;
        this.fechaRegistro = new Date();
    }

    public DeudaAlumno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public DeudaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public BigDecimal getMonto() {
        if (monto == null) {
            return BigDecimal.ZERO;
        }
        return monto;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        if (this.fechaPreinicioMora == null && fechaVencimiento != null) {
            this.fechaPreinicioMora = fechaVencimiento;
        }
    }

    @JsonIgnore
    public void setTipoDeudaEnum(TipoDeudaEnum tipoDeuda) {
        this.tipoDeuda = tipoDeuda.name();
    }

    public TipoDeudaEnum getTipoDeudaEnum() {
        if (tipoDeuda == null) {
            return null;
        }
        return TipoDeudaEnum.valueOf(tipoDeuda);
    }

    public TipoEfectivoEnum getTipoAbonoEnum() {
        if (tipoAbono == null) {
            return null;
        }
        return TipoEfectivoEnum.valueOf(tipoAbono);
    }

    @JsonIgnore
    public void setTipoAbonoEnum(TipoEfectivoEnum efectivoEnum) {
        if (efectivoEnum == null) {
            return;
        }
        tipoAbono = efectivoEnum.name();
    }

    public boolean isEstadoPagado() {
        return DeudaEstadoEnum.PAG.name().equals(this.estado);
    }

    public boolean isEstadoPendiente() {
        return DeudaEstadoEnum.DEU.name().equals(this.estado);
    }

    public BigDecimal getMontoTotal() {
        return this.monto.add(this.mora);
    }

    public String getKeyAlumnoCtaBanco() {
        if (this.alumno == null) {
            return null;
        }
        if (this.cuentaBancaria == null) {
            return null;
        }

        return this.alumno.getId() + "-" + this.cuentaBancaria.getId();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "concepto", concepto, false);
        ModelUtils.getDataByAttr(join, "monto", monto, false);
        ModelUtils.getDataByAttr(join, "abono", abono, false);
        ModelUtils.getDataByAttr(join, "moraDiaria", moraDiaria, false);
        ModelUtils.getDataByAttr(join, "mora", mora, false);
        ModelUtils.getDataByAttr(join, "detalleJson", detalleJson, false);
        ModelUtils.getDataByAttr(join, "numeroCuota", numeroCuota, false);
        ModelUtils.getDataByAttr(join, "tipoDeuda", tipoDeuda);
        ModelUtils.getDataByAttr(join, "procesoRegistro", procesoRegistro, false);
        ModelUtils.getDataByAttr(join, "procesoActualizacion", procesoActualizacion, false);
        ModelUtils.getDataByAttr(join, "tipoAbono", tipoAbono, false);
        ModelUtils.getDataByAttr(join, "fechaEmision", fechaEmision, false);
        ModelUtils.getDataByAttr(join, "fechaPreinicioMora", fechaPreinicioMora, false);
        ModelUtils.getDataByAttr(join, "fechaVencimiento", fechaVencimiento, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaAbono", fechaAbono, false);
        ModelUtils.getDataByAttr(join, "fechaActualizacion", fechaActualizacion, false);
        ModelUtils.getDataByAttr(join, "fechaAnulacion", fechaAnulacion, false);
        ModelUtils.getDataByAttrObject(join, "alumnoPagoVerano", alumnoPagoVerano, "id");
        ModelUtils.getDataByAttrObject(join, "cuentaBancaria", cuentaBancaria, "id", "numero");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "seccion", seccion, "id", "codigo2");
        ModelUtils.getDataByAttrObject(join, "tramite", tramite, "id", "serie", "numero");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userAbono", userAbono, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userAnulacion", userAnulacion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userActualizacion", userActualizacion, "id", "google");

        return join.toString();
    }

}
