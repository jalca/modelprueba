package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.edu.lamolina.model.enums.TipoAlumnoEnum;

@Entity
@Table(name = "aca_tope_matricula")
public class TopeMatricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_alumno")
    private String tipoAlumno;

    @Column(name = "creditos")
    private Integer creditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_matricula")
    private CicloAcademico cicloAcademico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(String tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    public TipoAlumnoEnum getTipoAlumnoEnum() {
        if (this.tipoAlumno == null) {
            return null;
        }
        return TipoAlumnoEnum.valueOf(this.tipoAlumno);
    }

    @JsonIgnore
    public void setTipoAlumnoEnum(TipoAlumnoEnum tipoAlumno) {
        if (tipoAlumno == null) {
            return;
        }
        this.tipoAlumno = tipoAlumno.name();
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }
}
