package pe.edu.lamolina.model.optativo;

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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "opt_alumno_evaluacion_optativo")
public class AlumnoEvaluacionOptativo implements Serializable {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @Column(name = "nota")
    private String nota;

    @Column(name = "valor_numerico")
    private BigDecimal valorNumerico;

    @Column(name = "valor_letra")
    private String valorLetra;

    @Column(name = "fecha_ingreso_nota")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresoNota;

    @Column(name = "creditos")
    private Integer creditos;

    @JoinColumn(name = "id_evaluacion_optativo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaluacionOptativo evaluacionOptativo;

    @JoinColumn(name = "id_user_ingreso_nota", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario userIngresoNota;

    public AlumnoEvaluacionOptativo() {
    }

    public AlumnoEvaluacionOptativo(Long id) {
        this.id = id;
    }

    public AlumnoEvaluacionOptativo(Long id, Alumno alumno) {
        this.id = id;
        this.alumno = alumno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public BigDecimal getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(BigDecimal valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorLetra() {
        return valorLetra;
    }

    public void setValorLetra(String valorLetra) {
        this.valorLetra = valorLetra;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public EvaluacionOptativo getEvaluacionOptativo() {
        return evaluacionOptativo;
    }

    public void setEvaluacionOptativo(EvaluacionOptativo evaluacionOptativo) {
        this.evaluacionOptativo = evaluacionOptativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof AlumnoEvaluacionOptativo)) {
            return false;
        }
        AlumnoEvaluacionOptativo other = (AlumnoEvaluacionOptativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.optativo.AlumnoEvaluacionOptativo[ id=" + id + " ]";
    }

    public Date getFechaIngresoNota() {
        return fechaIngresoNota;
    }

    public void setFechaIngresoNota(Date fechaIngresoNota) {
        this.fechaIngresoNota = fechaIngresoNota;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Usuario getUserIngresoNota() {
        return userIngresoNota;
    }

    public void setUserIngresoNota(Usuario userIngresoNota) {
        this.userIngresoNota = userIngresoNota;
    }

}
