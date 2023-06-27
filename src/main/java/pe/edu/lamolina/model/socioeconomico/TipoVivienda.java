package pe.edu.lamolina.model.socioeconomico;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Getter
@Setter
@Entity
@Table(name = "isec_tipo_vivienda")
public class TipoVivienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "con_comentario")
    private Integer conComentario;

    public TipoVivienda() {
    }

    public TipoVivienda(Object id) {
        this.id = TypesUtil.getLong(id);
    }
}
