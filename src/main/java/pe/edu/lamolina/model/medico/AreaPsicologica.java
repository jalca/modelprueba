package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "med_area_psicologica")
public class AreaPsicologica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Transient
    private List<PreguntaPsicologica> preguntas;

    public AreaPsicologica() {
    }

    public AreaPsicologica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PreguntaPsicologica> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaPsicologica> preguntas) {
        this.preguntas = preguntas;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }

}
