package pe.edu.lamolina.model.cms;

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
import pe.edu.lamolina.model.cms.enums.TipoRecursoPlantillaEnum;

@Entity
@Table(catalog = "lamolina", name = "cms_recurso_plantilla")
public class RecursoPlantilla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla")
    private Plantilla plantilla;

    public RecursoPlantilla() {
    }

    public RecursoPlantilla(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoRecursoPlantillaEnum getTipoEnum() {
        return TipoRecursoPlantillaEnum.valueOf(tipo);
    }

    public void setTipo(TipoRecursoPlantillaEnum tipo) {
        this.tipo = tipo.name();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }
}
