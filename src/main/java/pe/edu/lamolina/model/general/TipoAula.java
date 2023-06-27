package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoAmbienteEnum;
import pe.edu.lamolina.model.enums.TipoAulaEnum;

@Entity
@Table(name = "gen_tipo_aula")
public class TipoAula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "tipo_ambiente")
    private String tipoAmbiente;

    public TipoAula() {
    }

    public TipoAula(Object id) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public TipoAmbienteEnum getTipoAmbienteEnum() {
        if (tipoAmbiente == null) {
            return null;
        }
        return TipoAmbienteEnum.valueOf(tipoAmbiente);
    }

    public boolean isTipoAulaMOD() {
        if (StringUtils.isBlank(this.codigo)) {
            return false;
        }
        return TipoAulaEnum.MOD.name().equals(this.codigo);
    }

    public boolean isTipoAulaAUL() {
        if (StringUtils.isBlank(this.codigo)) {
            return false;
        }
        return TipoAulaEnum.AUL.name().equals(this.codigo);
    }

    public void setTipoAmbiente(TipoAmbienteEnum tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente.name();
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance);
    }

}
