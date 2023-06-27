package pe.edu.lamolina.model.calificacion;

import java.io.Serializable;
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
import pe.edu.lamolina.model.inscripcion.CicloPostula;

@Entity
@Table(name = "sce_tema_ciclo")
public class TemaCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "pregunta_inicio")
    private Integer preguntaInicio;

    @Column(name = "pregunta_fin")
    private Integer preguntaFin;

    @Column(name = "preguntas")
    private Integer preguntas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema_examen")
    private TemaExamen temaExamen;

    public TemaCiclo() {
    }

    public TemaCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getPreguntaInicio() {
        return preguntaInicio;
    }

    public void setPreguntaInicio(Integer preguntaInicio) {
        this.preguntaInicio = preguntaInicio;
    }

    public Integer getPreguntaFin() {
        return preguntaFin;
    }

    public void setPreguntaFin(Integer preguntaFin) {
        this.preguntaFin = preguntaFin;
    }

    public Integer getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Integer Preguntas) {
        this.preguntas = Preguntas;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public TemaExamen getTemaExamen() {
        return temaExamen;
    }

    public void setTemaExamen(TemaExamen temaExamen) {
        this.temaExamen = temaExamen;
    }

    public static class CompareOrden implements Comparator<TemaCiclo> {

        @Override
        public int compare(TemaCiclo tc1, TemaCiclo tc2) {
            return tc1.getOrden().compareTo(tc2.getOrden());
        }
    }

}
