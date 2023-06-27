package pe.edu.lamolina.model.posgrado.empresa;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.general.Empresa;

@Getter
@Setter
@Entity
@Table(catalog = "lamolina", name = "epg_empresa_rubro")
public class EmpresaRubroEPG implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    private RubroEPG rubro;

    public EmpresaRubroEPG() {}

    public EmpresaRubroEPG(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}