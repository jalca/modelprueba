package pe.edu.lamolina.model.bienestar;

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
import pe.edu.lamolina.model.general.Colegio;

@Entity
@Table(name = "obu_colegio_categoria_bienestar")
public class ColegioCategoriaBienestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio")
    private Colegio colegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_bienestar")
    private CategoriaBienestar categoriaBienestar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public CategoriaBienestar getCategoriaBienestar() {
        return categoriaBienestar;
    }

    public void setCategoriaBienestar(CategoriaBienestar categoriaBienestar) {
        this.categoriaBienestar = categoriaBienestar;
    }

    public ColegioCategoriaBienestar() {
    }

    public ColegioCategoriaBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
