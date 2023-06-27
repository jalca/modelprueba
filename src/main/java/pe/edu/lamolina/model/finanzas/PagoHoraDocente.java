package pe.edu.lamolina.model.finanzas;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;

@Entity
@Table(name = "fin_pago_hora_docente")
public class PagoHoraDocente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @Column(name = "alumnos_inicio")
    private Long alumnosInicio;

    @Column(name = "alumnos_fin")
    private Long alumnosFin;

    @Column(name = "monto_hora")
    private BigDecimal montoHora;

    public PagoHoraDocente() {
    }

    public PagoHoraDocente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Long getAlumnosInicio() {
        return alumnosInicio;
    }

    public void setAlumnosInicio(Long alumnosInicio) {
        this.alumnosInicio = alumnosInicio;
    }

    public Long getAlumnosFin() {
        return alumnosFin;
    }

    public void setAlumnosFin(Long alumnosFin) {
        this.alumnosFin = alumnosFin;
    }

    public BigDecimal getMontoHora() {
        return montoHora;
    }

    public void setMontoHora(BigDecimal montoHora) {
        this.montoHora = montoHora;
    }

}
