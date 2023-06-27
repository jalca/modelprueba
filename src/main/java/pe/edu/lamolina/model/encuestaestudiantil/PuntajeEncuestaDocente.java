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
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.examen.TemaExamenVirtual;

@Entity
@Table(name = "exam_puntaje_encuesta_docente")
public class PuntajeEncuestaDocente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "desviacion_standar")
    private BigDecimal desviacionStandar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_docente")
    private EncuestaDocente encuestaDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema_encuesta")
    private TemaExamenVirtual temaEncuesta;

    public PuntajeEncuestaDocente() {
    }

    public PuntajeEncuestaDocente(EncuestaDocente encuestaDocente, TemaExamenVirtual tema, Double puntaje, Double desviacionStandar) {
        this.encuestaDocente = encuestaDocente;
        this.puntaje = new BigDecimal(puntaje);
        this.desviacionStandar = new BigDecimal(desviacionStandar);
        this.temaEncuesta = tema;
    }

    public PuntajeEncuestaDocente(Object id) {
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

    public EncuestaDocente getEncuestaDocente() {
        return encuestaDocente;
    }

    public void setEncuestaDocente(EncuestaDocente encuestaDocente) {
        this.encuestaDocente = encuestaDocente;
    }

    public TemaExamenVirtual getTemaEncuesta() {
        return temaEncuesta;
    }

    public void setTemaEncuesta(TemaExamenVirtual temaEncuesta) {
        this.temaEncuesta = temaEncuesta;
    }

    public static class CompareOrdenEncuesta implements Comparator<PuntajeEncuestaDocente> {

        @Override
        public int compare(PuntajeEncuestaDocente ped1, PuntajeEncuestaDocente ped2) {

            TemaExamenVirtual t1 = ped1.getTemaEncuesta();
            TemaExamenVirtual t2 = ped2.getTemaEncuesta();
            int compara = t1.getNombre().compareTo(t2.getNombre());
            if (compara != 0) {
                return compara;
            }

            Curso c1 = ped1.getEncuestaDocente().getDocenteSeccion().getSeccion().getGrupoSeccion().getCurso();
            Curso c2 = ped2.getEncuestaDocente().getDocenteSeccion().getSeccion().getGrupoSeccion().getCurso();

            compara = c1.getNombre().compareTo(c2.getNombre());
            if (compara != 0) {
                return compara;
            }

            Seccion s1 = ped1.getEncuestaDocente().getDocenteSeccion().getSeccion();
            Seccion s2 = ped2.getEncuestaDocente().getDocenteSeccion().getSeccion();
            return s1.getCodigo2().compareTo(s2.getCodigo2());

        }
    }

}
