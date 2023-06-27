package pe.edu.lamolina.model.socioeconomico;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;

@Entity
@Table(name = "obu_antecedente_cultural_colegio")
public class AntecedenteCulturalColegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otra_actividad")
    private String otraActividad;

    @Column(name = "participante")
    private Boolean participante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad_cultural")
    private ActividadCultural actividadCultural;

    public AntecedenteCulturalColegio() {
    }

    public AntecedenteCulturalColegio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtraActividad() {
        return otraActividad;
    }

    public void setOtraActividad(String otraActividad) {
        this.otraActividad = otraActividad;
    }

    public Boolean getParticipante() {
        return participante;
    }

    public void setParticipante(Boolean participante) {
        this.participante = participante;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ActividadCultural getActividadCultural() {
        return actividadCultural;
    }

    public void setActividadCultural(ActividadCultural actividadCultural) {
        this.actividadCultural = actividadCultural;
    }

}
