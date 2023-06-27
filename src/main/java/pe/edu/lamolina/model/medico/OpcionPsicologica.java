package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoOpcionPsicologicaEnum;

@Entity
@Table(name = "med_opcion_psicologica")
public class OpcionPsicologica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_opcion")
    private String tipoOpcion;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "con_comentario")
    private Boolean conComentario;

    @Column(name = "estado_activo")
    private Boolean estadoActivo;

    public OpcionPsicologica() {
    }

    public OpcionPsicologica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoOpcion() {
        return tipoOpcion;
    }

    public TipoOpcionPsicologicaEnum getTipoOpcionEnum() {
        if (tipoOpcion == null) {
            return null;
        }
        return TipoOpcionPsicologicaEnum.valueOf(tipoOpcion);
    }

    public void setTipoOpcion(TipoOpcionPsicologicaEnum opcionPsicologica) {
        this.tipoOpcion = opcionPsicologica.name();
    }

    public Boolean getConComentario() {
        return conComentario;
    }

    public void setConComentario(Boolean conComentario) {
        this.conComentario = conComentario;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Boolean getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(Boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, true, new String[]{
            "*",});
    }

}
