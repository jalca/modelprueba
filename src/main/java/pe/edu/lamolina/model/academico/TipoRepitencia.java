package pe.edu.lamolina.model.academico;

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
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "aca_tipo_repitencia")
public class TipoRepitencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    public TipoRepitencia() {
    }

    public TipoRepitencia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }

    public boolean isTieneRestriccion(List<RestriccionRepitencia> restriccionesRepitencia) {
        for (RestriccionRepitencia restriccionesRepitenciaEach : restriccionesRepitencia) {
            if (this.getId().compareTo(restriccionesRepitenciaEach.getTipoRepitencia().getId()) == 0) {
                return true;
            }
        }
        return false;
    }

    public String getLetra() {
        return this.codigo.substring(0,1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TipoRepitencia)) {
            return false;
        }
        TipoRepitencia other = (TipoRepitencia) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}
