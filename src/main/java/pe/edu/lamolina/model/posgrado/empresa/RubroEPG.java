package pe.edu.lamolina.model.posgrado.empresa;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.io.Serializable;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(catalog = "lamolina", name = "epg_rubro")
public class RubroEPG implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcion;

    public RubroEPG() {}

    public RubroEPG(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}