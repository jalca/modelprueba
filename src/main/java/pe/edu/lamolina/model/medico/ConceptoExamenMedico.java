package pe.edu.lamolina.model.medico;

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
import org.joda.time.DateTime;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "med_concepto_examen_medico")
public class ConceptoExamenMedico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "abono")
    private BigDecimal abono;

    @Column(name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_abono")
    private Usuario userAbono;

    @Column(name = "fecha_abono")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAbono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_medico")
    private ExamenMedico examenMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_medico_ciclo")
    private ConceptoMedicoCiclo conceptoMedicoCiclo;

    public ConceptoExamenMedico() {
    }

    public ConceptoExamenMedico(ConceptoMedicoCiclo conceptoMedicoCiclo,
            ExamenMedico examenMedico,
            DateTime fechaRegistro,
            Usuario usuario) {
        this.abono = BigDecimal.ZERO;
        this.conceptoMedicoCiclo = conceptoMedicoCiclo;
        this.examenMedico = examenMedico;
        this.fechaRegistro = fechaRegistro.toDate();
        this.fechaVencimiento = examenMedico.getFechaVencimiento();
        this.monto = conceptoMedicoCiclo.getMonto();
        this.userRegistro = usuario;
        this.abono = BigDecimal.ZERO;
    }

    public ConceptoExamenMedico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Usuario getUserAbono() {
        return userAbono;
    }

    public void setUserAbono(Usuario userAbono) {
        this.userAbono = userAbono;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ExamenMedico getExamenMedico() {
        return examenMedico;
    }

    public void setExamenMedico(ExamenMedico examenMedico) {
        this.examenMedico = examenMedico;
    }

    public ConceptoMedicoCiclo getConceptoMedicoCiclo() {
        return conceptoMedicoCiclo;
    }

    public void setConceptoMedicoCiclo(ConceptoMedicoCiclo conceptoMedicoCiclo) {
        this.conceptoMedicoCiclo = conceptoMedicoCiclo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConceptoExamenMedico other = (ConceptoExamenMedico) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}
