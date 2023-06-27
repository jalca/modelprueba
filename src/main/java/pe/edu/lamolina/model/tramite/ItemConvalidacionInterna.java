package pe.edu.lamolina.model.tramite;

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
import pe.edu.lamolina.model.academico.AlumnoCicloCurso;

@Entity
@Table(name = "tram_item_convalidacion_interna")
public class ItemConvalidacionInterna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_convalidacion_interna")
    private ConvalidacionInterna convalidacionInterna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_historial_convalidado")
    private AlumnoCicloCurso cursoHistorialConvalidado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_historial_convalidador")
    private AlumnoCicloCurso cursoHistorialConvalidador;

    public ItemConvalidacionInterna() {
    }

    public ItemConvalidacionInterna(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConvalidacionInterna getConvalidacionInterna() {
        return convalidacionInterna;
    }

    public void setConvalidacionInterna(ConvalidacionInterna convalidacionInterna) {
        this.convalidacionInterna = convalidacionInterna;
    }

    public AlumnoCicloCurso getCursoHistorialConvalidado() {
        return cursoHistorialConvalidado;
    }

    public void setCursoHistorialConvalidado(AlumnoCicloCurso cursoHistorialConvalidado) {
        this.cursoHistorialConvalidado = cursoHistorialConvalidado;
    }

    public AlumnoCicloCurso getCursoHistorialConvalidador() {
        return cursoHistorialConvalidador;
    }

    public void setCursoHistorialConvalidador(AlumnoCicloCurso cursoHistorialConvalidador) {
        this.cursoHistorialConvalidador = cursoHistorialConvalidador;
    }

}
