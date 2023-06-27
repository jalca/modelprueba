package pe.edu.lamolina.model.employee;

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

@Entity
@Table(name = "empy_tag_oferta_laboral")
public class TagOfertaLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oferta_laboral")
    private OfertaLaboral ofertaLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tag")
    private TagEmpleabilidad tagEmpleabilidad;

    public TagOfertaLaboral() {
    }

    public TagOfertaLaboral(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OfertaLaboral getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(OfertaLaboral ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public TagEmpleabilidad getTagEmpleabilidad() {
        return tagEmpleabilidad;
    }

    public void setTagEmpleabilidad(TagEmpleabilidad tagEmpleabilidad) {
        this.tagEmpleabilidad = tagEmpleabilidad;
    }

}
