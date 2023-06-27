package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.aporte.ItemSaldoAfavor;
import pe.edu.lamolina.model.croacia.ept.DeudasConceptoMy;
import pe.edu.lamolina.model.enums.ConceptoPosgradoEnum;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;
import pe.edu.lamolina.model.finanzas.DeudaAlumno;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "epg_alumno_concepto_matricula")
public class AlumnoConceptoMatricula implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;

    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;

    @NotNull
    @Column(name = "inicial")
    private BigDecimal inicial;

    @NotNull
    @Column(name = "fraccionado")
    private BigDecimal fraccionado;

    @NotNull
    @Column(name = "cuotas")
    private Integer cuotas;

    @Column(name = "estado_inicial")
    private String estadoInicial;

    @Column(name = "abono_inicial")
    private BigDecimal abonoInicial;

    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_abono_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAbonoInicial;

    @JoinColumn(name = "id_concepto_posgrado")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConceptoPosgrado conceptoPosgrado;

    @JoinColumn(name = "id_alumno_resumen_cuotas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AlumnoResumenCuotas alumnoResumenCuotas;

    @JoinColumn(name = "id_deuda_alumno")
    @ManyToOne(fetch = FetchType.LAZY)
    private DeudaAlumno deudaAlumno;

    @JoinColumn(name = "id_becado_posgrado")
    @ManyToOne(fetch = FetchType.LAZY)
    private BecadoPosgrado becadoPosgrado;

    @NotNull
    @JoinColumn(name = "id_user_registro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userRegistro;

    @JoinColumn(name = "id_user_abono_inicial")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario userAbonoInicial;

    @JoinColumn(name = "id_item_saldo_afavor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ItemSaldoAfavor itemSaldoAfavor;

    @Transient
    private Date fechaAnulacion;

    @Transient
    private BigDecimal minimoInicial;

    @Transient
    private String estadoDeudaTrans;

    @Transient
    private BigDecimal montoUsar;

    public AlumnoConceptoMatricula(Long id) {
        this.id = id;
    }

    public AlumnoConceptoMatricula(Long id, BigDecimal monto, BigDecimal descuento, BigDecimal inicial, BigDecimal fraccionado, Integer cuotas, long idUserRegistro, Date fechaRegistro) {
        this.id = id;
        this.monto = monto;
        this.descuento = descuento;
        this.inicial = inicial;
        this.fraccionado = fraccionado;
        this.cuotas = cuotas;
        this.userRegistro = new Usuario(idUserRegistro);
        this.fechaRegistro = fechaRegistro;
    }

    public AlumnoConceptoMatricula(Long id,
            AlumnoResumenCuotas alumnoResumenCuotas,
            DeudasConceptoMy deudasConceptoMy,
            Usuario usuarioRegistro) {
        this.id = id;
        this.alumnoResumenCuotas = alumnoResumenCuotas;
        this.monto = deudasConceptoMy.getMonto();
        this.descuento = deudasConceptoMy.getAyuda();
        this.inicial = deudasConceptoMy.getCancelInicial();
        this.fraccionado = deudasConceptoMy.getFraccionar();
        this.cuotas = BigDecimal.ZERO.intValue();
        this.userRegistro = usuarioRegistro;
        this.fechaRegistro = deudasConceptoMy.getGeneraFecha();
        this.fechaAnulacion = deudasConceptoMy.getAnulaFecha();
        this.conceptoPosgrado = new ConceptoPosgrado(deudasConceptoMy.getDeudasConceptoPK().getConceptoEnum().getConceptoPosgradoEnum());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AlumnoConceptoMatricula)) {
            return false;
        }
        AlumnoConceptoMatricula other = (AlumnoConceptoMatricula) object;
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

    public DeudaEstadoEnum getEstadoInicialEnum() {
        if (StringUtils.isBlank(this.estadoInicial)) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(this.estadoInicial);
    }

    @JsonIgnore
    public void setEstadoInicialEnum(DeudaEstadoEnum estadoInicial) {
        if (estadoInicial != null) {
            this.estadoInicial = estadoInicial.name();
        }
    }

    public BigDecimal getAbonoInicial() {
        if (abonoInicial == null) {
            return BigDecimal.ZERO;
        } else {
            return abonoInicial;
        }
    }

    public DeudaEstadoEnum getEstadoDeudaTransEnum() {
        if (StringUtils.isBlank(this.estadoDeudaTrans)) {
            return null;
        }
        return DeudaEstadoEnum.valueOf(this.estadoDeudaTrans);
    }

    @JsonIgnore
    public void setEstadoDeudaTransEnum(DeudaEstadoEnum estadoDeudaTrans) {
        if (estadoDeudaTrans != null) {
            this.estadoDeudaTrans = estadoDeudaTrans.name();
        }
    }

    public BigDecimal getSaldo() {
        if (abonoInicial == null) {
            return inicial;
        } else {
            return inicial.subtract(abonoInicial);
        }
    }

    public Integer getOrdenByTipo() {
        if (this.conceptoPosgrado.getCodigoEnum() == ConceptoPosgradoEnum.MAT) {
            return 1;
        }
        if (this.conceptoPosgrado.getCodigoEnum() == ConceptoPosgradoEnum.ENZ) {
            return 2;
        }
        if (this.conceptoPosgrado.getCodigoEnum() == ConceptoPosgradoEnum.XTM) {
            return 3;
        }
        return 4;
    }

    public static class CompareOrdenTipo implements Comparator<AlumnoConceptoMatricula> {

        @Override
        public int compare(AlumnoConceptoMatricula s1, AlumnoConceptoMatricula s2) {
            if (s1.getOrdenByTipo() < 4 && s2.getOrdenByTipo() < 4) {
                return s1.getOrdenByTipo().compareTo(s2.getOrdenByTipo());
            }
            if (s1.getOrdenByTipo() < 4 && s2.getOrdenByTipo() >= 4) {
                return -1;
            }
            if (s1.getOrdenByTipo() >= 4 && s2.getOrdenByTipo() < 4) {
                return 1;
            }
            return s1.getConceptoPosgrado().getCodigo().compareTo(s2.getConceptoPosgrado().getCodigo());
        }
    }
}
