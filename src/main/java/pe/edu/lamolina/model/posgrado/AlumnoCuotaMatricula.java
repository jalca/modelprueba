package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.aporte.ItemSaldoAfavor;
import pe.edu.lamolina.model.croacia.ept.FraccionadoMy;
import pe.edu.lamolina.model.enums.ConceptoPosgradoEnum;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.finanzas.DeudaAlumno;
import pe.edu.lamolina.model.finanzas.ItemCargaAbono;
import pe.edu.lamolina.model.finanzas.RefinanciarCuotasPosgrado;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "epg_alumno_cuota_matricula")
public class AlumnoCuotaMatricula implements Serializable, Cloneable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_concepto")
    private String tipoConcepto;

    @NotNull
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;

    @NotNull
    @Column(name = "monto_base")
    private BigDecimal montoBase;

    @NotNull
    @Column(name = "monto_amortizador")
    private BigDecimal montoAmortizador;

    @NotNull
    @Column(name = "interes")
    private BigDecimal interes;

    @NotNull
    @Column(name = "mora")
    private BigDecimal mora;

    @NotNull
    @Column(name = "mora_diaria")
    private BigDecimal moraDiaria;

    @NotNull
    @Column(name = "mora_impagada")
    private BigDecimal moraImpagada;

    @NotNull
    @Column(name = "amortizado")
    private BigDecimal amortizado;

    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "motivo_cambio_mora")
    private String motivoCambioMora;

    @Column(name = "motivo_modifica_cuota")
    private String motivoModificaCuota;

    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEmision;

    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaPago;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaVencimiento;

    @Column(name = "fecha_ultimo_dia_pago")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaUltimoDiaPago;

    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAnulacion;

    @Column(name = "fecha_cambio_mora")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCambioMora;

    @Column(name = "fecha_modifica_cuota")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificaCuota;

    @JoinColumn(name = "id_alumno_resumen_cuotas")
    @ManyToOne(fetch = FetchType.LAZY)
    private AlumnoResumenCuotas alumnoResumenCuotas;

    @JoinColumn(name = "id_deuda_alumno")
    @ManyToOne(fetch = FetchType.LAZY)
    private DeudaAlumno deudaAlumno;

    @JoinColumn(name = "id_item_saldo_afavor")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemSaldoAfavor itemSaldoAfavor;

    @JoinColumn(name = "id_refinanciar_origen")
    @ManyToOne(fetch = FetchType.LAZY)
    private RefinanciarCuotasPosgrado refinanciarOrigen;

    @JoinColumn(name = "id_refinanciar_destino")
    @ManyToOne(fetch = FetchType.LAZY)
    private RefinanciarCuotasPosgrado refinanciarDestino;

    @JoinColumn(name = "id_user_registro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userRegistro;

    @JoinColumn(name = "id_user_anulacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userAnulacion;

    @JoinColumn(name = "id_user_cambio_mora")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userCambioMora;

    @JoinColumn(name = "id_user_modifica_cuota")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userModificaCuota;

    @Transient
    private Boolean fucionar;

    @Transient
    private BigDecimal montoInicial;

    @Transient
    private ItemCargaAbono itemCargaAbono;

    public AlumnoCuotaMatricula() {
        this.moraImpagada = BigDecimal.ZERO;
    }

    public AlumnoCuotaMatricula(Long id) {
        this.id = id;
        this.moraImpagada = BigDecimal.ZERO;
    }

    public AlumnoCuotaMatricula(
            Long id,
            Integer numeroCuota,
            DeudaEstadoEnum deudaEstadoEnum,
            Date fechaEmision,
            Date fechaPago,
            BigDecimal montoCuota,
            BigDecimal montoBase,
            BigDecimal interes,
            BigDecimal mora,
            BigDecimal amortizado,
            BigDecimal saldo) {

        this.id = id;
        this.numeroCuota = numeroCuota;
        this.estado = deudaEstadoEnum.name();
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.montoCuota = montoCuota;
        this.montoBase = montoBase;
        this.interes = interes;
        this.mora = mora;
        this.amortizado = amortizado;
        this.saldo = saldo;
        this.moraImpagada = BigDecimal.ZERO;
    }

    public AlumnoCuotaMatricula(
            Long id,
            ConceptoPosgradoEnum tipoConcepEnum,
            CronogramaCuota cronogramaCuota,
            DeudaEstadoEnum deudaEstadoEnum,
            BigDecimal montoCuota,
            BigDecimal montoBase,
            BigDecimal montoAmortizador,
            BigDecimal interes,
            BigDecimal mora,
            BigDecimal moraDiaria,
            BigDecimal amortizado,
            BigDecimal saldo) {

        this.id = id;
        this.tipoConcepto = tipoConcepEnum.name();
        this.numeroCuota = cronogramaCuota.getNumeroCuota();
        this.estado = deudaEstadoEnum.name();
        this.fechaEmision = cronogramaCuota.getFechaEmision();
        this.fechaVencimiento = cronogramaCuota.getFechaPago();
        this.montoCuota = montoCuota;
        this.montoBase = montoBase;
        this.montoAmortizador = montoAmortizador;
        this.interes = interes;
        this.mora = mora;
        this.moraDiaria = moraDiaria;
        this.amortizado = amortizado;
        this.saldo = saldo;
        this.moraImpagada = BigDecimal.ZERO;
    }

    public AlumnoCuotaMatricula(Long id,
            AlumnoResumenCuotas alumnoResumenCuotas,
            FraccionadoMy fraccionado) {
        this.id = id;
        this.alumnoResumenCuotas = alumnoResumenCuotas;
        //  this.amortizado=fraccionado.get
        this.deudaAlumno = null;
        this.estado = fraccionado.getEstadoEnum().getDeudaEstadoEnum().name();
        this.fechaEmision = new DateTime(fraccionado.getFechaVcmto()).minusDays(5).toDate();
        // this.fechaPago=fraccionado.getFracciona
        this.fechaRegistro = fraccionado.getGeneraFecha();
        this.fechaVencimiento = fraccionado.getFechaVcmto();
        this.interes = fraccionado.getMontoPagar().subtract(fraccionado.getMontoBase());
        this.montoBase = fraccionado.getMontoBase();
        this.montoCuota = fraccionado.getMontoFracc();
        this.amortizado = fraccionado.getCancelado();
        this.saldo = fraccionado.getSaldo();
        //this.amortizado = BigDecimal.ZERO;
        //this.saldo = BigDecimal.ZERO;
        this.mora = fraccionado.getMora();
        this.numeroCuota = fraccionado.getFraccionadoPK().getFraccion();
        //  this.
        if (this.interes == null) {
            this.interes = BigDecimal.ZERO;
        }
        if (this.mora == null) {
            this.mora = BigDecimal.ZERO;
        }
        this.moraImpagada = BigDecimal.ZERO;
    }

    public DeudaEstadoEnum getEstadoEnum() {
        return StringUtils.isNotBlank(estado) ? DeudaEstadoEnum.valueOf(this.estado) : null;
    }

    @JsonIgnore
    public void setEstadoEnum(DeudaEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public Boolean getFucionar() {
        if (this.fucionar == null) {
            return Boolean.FALSE;
        }
        return fucionar;
    }

    public ConceptoPosgradoEnum getTipoConceptoEnum() {
        if (tipoConcepto == null) {
            return null;
        }
        return ConceptoPosgradoEnum.valueOf(tipoConcepto);
    }

    @JsonIgnore
    public void setTipoConceptoEnum(ConceptoPosgradoEnum tipoConcepto) {
        if (tipoConcepto == null) {
            return;
        }
        this.tipoConcepto = tipoConcepto.name();
    }

    public String getDescripcion() {
        if (this.alumnoResumenCuotas == null) {
            return null;
        }
        if (this.alumnoResumenCuotas.getCicloAcademico() == null) {
            return null;
        }
        CicloAcademico ciclo = this.alumnoResumenCuotas.getCicloAcademico();
        return ciclo.getDescripcion() + " Nº " + this.numeroCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof AlumnoCuotaMatricula)) {
            return false;
        }
        AlumnoCuotaMatricula other = (AlumnoCuotaMatricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
