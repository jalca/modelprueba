package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@Entity
@Table(name = "med_examen_clinico")
public class ExamenClinico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "con_comentario")
    private Boolean conComentario;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "orden_pregunta")
    private String ordenPregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_examen_clinico")
    private NivelExamenClinico nivelExamenClinico;

    public ExamenClinico() {
    }

    public ExamenClinico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "conComentario", conComentario);
        ModelUtils.getDataByAttr(join, "sexo", sexo, false);
        ModelUtils.getDataByAttr(join, "ordenPregunta", ordenPregunta, false);
        ModelUtils.getDataByAttrObject(join, "nivelExamenClinico", nivelExamenClinico, "id", "nombre");

        return join.toString();
    }

}
