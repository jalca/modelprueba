package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "obu_actividad_cultural")
public class ActividadCultural implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "con_comentario")
    private Integer conComentario;

    public ActividadCultural() {
    }

    public ActividadCultural(Object id) {
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

    public Integer getConComentario() {
        return conComentario;
    }

    public void setConComentario(Integer conComentario) {
        this.conComentario = conComentario;
    }

    public ObjectNode toJson() {

        ObjectNode json = new ObjectNode(JsonNodeFactory.instance);
        json.put("id", this.id);
        json.put("nombre", this.nombre);
        json.put("conComentario", this.conComentario);

        return json;
    }
}
