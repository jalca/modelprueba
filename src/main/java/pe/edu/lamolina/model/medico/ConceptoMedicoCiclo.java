package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;

@Entity
@Table(name = "med_concepto_medico_ciclo")
public class ConceptoMedicoCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_concepto_medico")
    private ConceptoMedico conceptoMedico;

    public ConceptoMedicoCiclo() {
    }

    public ConceptoMedicoCiclo(Object id) {
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

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public ConceptoMedico getConceptoMedico() {
        return conceptoMedico;
    }

    public void setConceptoMedico(ConceptoMedico conceptoMedico) {
        this.conceptoMedico = conceptoMedico;
    }

    public String getMontoStr() {
        if (monto != null) {
            return NumberFormat.precio(monto);
        }
        return "0.00";
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
        final ConceptoMedicoCiclo other = (ConceptoMedicoCiclo) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}
