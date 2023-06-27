package pe.edu.lamolina.model.encuestaestudiantil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import pe.edu.lamolina.model.examen.TemaExamenVirtual;

@Entity
@Table(name = "exam_puntaje_encuesta_docente_modalidad")
public class PuntajeEncuestaDocenteModalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "desviacion_standar")
    private BigDecimal desviacionStandar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_docente_modalidad")
    private EncuestaDocenteModalidad encuestaDocenteModalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema_encuesta")
    private TemaExamenVirtual temaEncuesta;

    public PuntajeEncuestaDocenteModalidad() {
    }

    public PuntajeEncuestaDocenteModalidad(TemaExamenVirtual temaEncuesta, Double puntaje, Double desviacionStandar) {
        this.temaEncuesta = temaEncuesta;
        this.puntaje = new BigDecimal(puntaje);
        this.desviacionStandar = new BigDecimal(desviacionStandar);
    }

    public PuntajeEncuestaDocenteModalidad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public BigDecimal getDesviacionStandar() {
        return desviacionStandar;
    }

    public void setDesviacionStandar(BigDecimal desviacionStandar) {
        this.desviacionStandar = desviacionStandar;
    }

    public EncuestaDocenteModalidad getEncuestaDocenteModalidad() {
        return encuestaDocenteModalidad;
    }

    public void setEncuestaDocenteModalidad(EncuestaDocenteModalidad encuestaDocenteModalidad) {
        this.encuestaDocenteModalidad = encuestaDocenteModalidad;
    }

    public TemaExamenVirtual getTemaEncuesta() {
        return temaEncuesta;
    }

    public void setTemaEncuesta(TemaExamenVirtual temaEncuesta) {
        this.temaEncuesta = temaEncuesta;
    }

    public static class CompareOrdenEncuesta implements Comparator<PuntajeEncuestaDocenteModalidad> {

        @Override
        public int compare(PuntajeEncuestaDocenteModalidad ped1, PuntajeEncuestaDocenteModalidad ped2) {

            TemaExamenVirtual t1 = ped1.getTemaEncuesta();
            TemaExamenVirtual t2 = ped1.getTemaEncuesta();
            return t1.getNombre().compareTo(t2.getNombre());

        }
    }

}
