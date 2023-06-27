package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.ExamenMedicoEstadoEnum;
import pe.edu.lamolina.model.enums.TipoEfectivoEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.finanzas.DeudaAlumno;
import pe.edu.lamolina.model.inscripcion.TurnoEntrevistaObuae;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "med_examen_medico")
public class ExamenMedico implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "abono_total")
    private BigDecimal abonoTotal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_examen")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExamen;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAbono;

    @Column(name = "tipo_abono")
    private String tipoAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno_entrevista")
    private TurnoEntrevistaObuae turnoEntrevistaObuae;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda_alumno")
    private DeudaAlumno deudaAlumno;

    @Transient
    private CuentaBancaria cuentaBancaria;

    @OneToMany(mappedBy = "examenMedico", fetch = FetchType.LAZY)
    private List<ConceptoExamenMedico> conceptosExamenMedico;

    public ExamenMedico() {
    }

    public ExamenMedico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getAbonoTotal() {
        return abonoTotal;
    }

    public void setAbonoTotal(BigDecimal abonoTotal) {
        this.abonoTotal = abonoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ExamenMedicoEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return ExamenMedicoEstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(ExamenMedicoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TurnoEntrevistaObuae getTurnoEntrevistaObuae() {
        return turnoEntrevistaObuae;
    }

    public void setTurnoEntrevistaObuae(TurnoEntrevistaObuae turnoEntrevistaObuae) {
        this.turnoEntrevistaObuae = turnoEntrevistaObuae;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public String getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(String tipoAbono) {
        this.tipoAbono = tipoAbono;
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

    public DeudaAlumno getDeudaAlumno() {
        return deudaAlumno;
    }

    public void setDeudaAlumno(DeudaAlumno deudaAlumno) {
        this.deudaAlumno = deudaAlumno;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public List<ConceptoExamenMedico> getConceptosExamenMedico() {
        return conceptosExamenMedico;
    }

    public void setConceptosExamenMedico(List<ConceptoExamenMedico> conceptosExamenMedico) {
        this.conceptosExamenMedico = conceptosExamenMedico;
    }

    public boolean isEstadoPendiente() {
        return ExamenMedicoEstadoEnum.PEND.name().equals(this.estado);
    }

    public boolean isEstadoExtemporaneo() {
        return ExamenMedicoEstadoEnum.EXTEM.name().equals(this.estado);
    }

    public boolean isEstadoPago() {
        return ExamenMedicoEstadoEnum.PAGO.name().equals(this.estado);
    }

    @Override
    public ExamenMedico clone() {
        ExamenMedico clone = null;
        try {
            clone = (ExamenMedico) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
