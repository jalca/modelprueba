package pe.edu.lamolina.model.calificacion;

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
import pe.edu.lamolina.model.inscripcion.CicloPostula;

@Entity
@Table(name = "sce_info_examen")
public class InfoExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "puntaje_correcto")
    private BigDecimal puntajeCorrecto;

    @Column(name = "puntaje_incorrecto")
    private BigDecimal puntajeIncorrecto;

    @Column(name = "puntaje_vacio")
    private BigDecimal puntajeVacio;

    @Column(name = "puntaje_multiple")
    private BigDecimal puntajeMultiple;

    @Column(name = "cantidad_preguntas")
    private Integer cantidadPreguntas;

    @Column(name = "cantidad_opciones")
    private Integer cantidadOpciones;

    @Column(name = "decimales_puntaje")
    private Integer decimalesPuntaje;

    @Column(name = "nota_base")
    private Integer notaBase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    public InfoExamen() {
    }

    public InfoExamen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPuntajeCorrecto() {
        return puntajeCorrecto;
    }

    public void setPuntajeCorrecto(BigDecimal puntajeCorrecto) {
        this.puntajeCorrecto = puntajeCorrecto;
    }

    public BigDecimal getPuntajeIncorrecto() {
        return puntajeIncorrecto;
    }

    public void setPuntajeIncorrecto(BigDecimal puntajeIncorrecto) {
        this.puntajeIncorrecto = puntajeIncorrecto;
    }

    public BigDecimal getPuntajeVacio() {
        return puntajeVacio;
    }

    public void setPuntajeVacio(BigDecimal puntajeVacio) {
        this.puntajeVacio = puntajeVacio;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public Integer getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public void setCantidadPreguntas(Integer cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public Integer getCantidadOpciones() {
        return cantidadOpciones;
    }

    public void setCantidadOpciones(Integer cantidadOpciones) {
        this.cantidadOpciones = cantidadOpciones;
    }

    public BigDecimal getPuntajeMultiple() {
        return puntajeMultiple;
    }

    public void setPuntajeMultiple(BigDecimal puntajeMultiple) {
        this.puntajeMultiple = puntajeMultiple;
    }

    public Integer getDecimalesPuntaje() {
        return decimalesPuntaje;
    }

    public void setDecimalesPuntaje(Integer decimalesPuntaje) {
        this.decimalesPuntaje = decimalesPuntaje;
    }

    public Integer getNotaBase() {
        return notaBase;
    }

    public void setNotaBase(Integer notaBase) {
        this.notaBase = notaBase;
    }

}
