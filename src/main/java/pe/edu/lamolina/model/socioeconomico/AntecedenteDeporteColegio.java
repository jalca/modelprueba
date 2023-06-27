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
@Table(name = "obu_antecedente_deporte_colegio")
public class AntecedenteDeporteColegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otro_deporte")
    private String otroDeporte;

    @Column(name = "seleccionado")
    private Boolean seleccionado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad_deporte")
    private ActividadDeporte actividadDeporte;

    public AntecedenteDeporteColegio() {
    }

    public AntecedenteDeporteColegio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtroDeporte() {
        return otroDeporte;
    }

    public void setOtroDeporte(String otroDeporte) {
        this.otroDeporte = otroDeporte;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ActividadDeporte getActividadDeporte() {
        return actividadDeporte;
    }

    public void setActividadDeporte(ActividadDeporte actividadDeporte) {
        this.actividadDeporte = actividadDeporte;
    }

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

}
