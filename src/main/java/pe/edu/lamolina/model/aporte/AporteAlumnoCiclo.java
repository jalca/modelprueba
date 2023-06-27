package pe.edu.lamolina.model.aporte;

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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.enums.EstadoAporteEnum;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.finanzas.DeudaAlumno;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.TramiteExoneracionAporte;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "apo_aporte_alumno_ciclo", catalog = GlobalConstantine.SCHEMA_OCTOPUS)
public class AporteAlumnoCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "detalle_motivo")
    private String detalleMotivo;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "pagado")
    private BigDecimal pagado;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "monto_afavor")
    private BigDecimal montoAfavor;

    @Column(name = "fraccionado")
    private BigDecimal fraccionado;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "numero_cuota_antes")
    private Integer numeroCuotaAntes;

    @Column(name = "numero_poliza")
    private String numeroPoliza;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_registro")
    private String estadoRegistro;

    @Column(name = "compania_seguro")
    private String companiaSeguro;

    @Column(name = "fecha_vencimiento")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "fecha_anula")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnula;

    @Column(name = "fecha_exoneracion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExoneracion;

    @Column(name = "fecha_refinanciado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRefinanciado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aporte_ciclo")
    private AporteCiclo aporteCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa_aseguradora")
    private Empresa aseguradora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resumen_aporte_alumno")
    private ResumenAporteAlumno resumenAporteAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fraccionamiento_aporte")
    private FraccionamientoAporte fraccionamientoAporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_exonera_aporte")
    private TramiteExoneracionAporte exoneracionAporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda_alumno")
    private DeudaAlumno deudaAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_deuda")
    private CicloAcademico cicloDeuda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_saldo_afavor_alumno")
    private SaldoAfavorAlumno saldoAfavorAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_saldo_afavor")
    private ItemSaldoAfavor itemSaldoAfavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aporte_alumno_refinanciador")
    private AporteAlumnoCiclo aporteAlumnoRefinanciador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anula")
    private Usuario usuarioAnula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_exoneracion")
    private Usuario usuarioExoneracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_refinanciado")
    private Usuario userRefinanciado;

    @Transient
    private Boolean seleccionado;

    @Transient
    private Boolean cuotas;

    public AporteAlumnoCiclo() {
        this.estadoRegistro = EstadoEnum.ACT.name();
        this.montoAfavor = BigDecimal.ZERO;
    }

    public AporteAlumnoCiclo(AporteCiclo aporteCiclo, ResumenAporteAlumno resumenAporteAlumno, DeudaAlumno deudaAlumno) {
        this.aporteCiclo = aporteCiclo;
        this.cicloDeuda = aporteCiclo.getCicloAcademico();
        this.estado = EstadoAporteEnum.DEBE.name();
        this.estadoRegistro = EstadoEnum.ACT.name();

        this.monto = aporteCiclo.getMontoFijo();
        this.numeroCuota = 1;
        this.resumenAporteAlumno = resumenAporteAlumno;
        this.saldo = aporteCiclo.getMontoFijo();
        this.deudaAlumno = deudaAlumno;
        this.fraccionado = BigDecimal.ZERO;
        this.pagado = BigDecimal.ZERO;
        this.montoAfavor = BigDecimal.ZERO;
    }

    public AporteAlumnoCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoAporteEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoAporteEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAporteEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public EstadoEnum getEstadoRegistroEnum() {
        if (this.estadoRegistro == null) {
            return null;
        }
        return EstadoEnum.valueOf(this.estadoRegistro);
    }

    @JsonIgnore
    public void setEstadoRegistroEnum(EstadoEnum estadoRegistro) {
        if (estadoRegistro == null) {
            return;
        }
        this.estadoRegistro = estadoRegistro.name();
    }

}
