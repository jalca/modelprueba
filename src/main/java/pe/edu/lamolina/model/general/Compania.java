package pe.edu.lamolina.model.general;

import java.io.Serializable;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@Table(name = "gen_compania")
public class Compania implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "telefonos")
    private String telefonos;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "direccion")
    private String direccion;

    public Compania() {
    }

    public Compania(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "telefonos", telefonos, false);
        ModelUtils.getDataByAttr(join, "ruc", ruc, false);
        ModelUtils.getDataByAttr(join, "direccion", direccion, false);

        return join.toString();
    }

}
