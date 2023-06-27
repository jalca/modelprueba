package pe.edu.lamolina.model.posgrado.concepto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoAyudaPosgradoEnum;

@Entity
@Table(name = "epg_tipo_ayuda_posgrado")
public class TipoAyudaPosgrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    public TipoAyudaPosgrado() {
    }

    public TipoAyudaPosgrado(Object id) {
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

    public TipoAyudaPosgradoEnum getCodigoEnum() {
        if (StringUtils.isBlank(this.codigo)) {
            return null;
        }
        return TipoAyudaPosgradoEnum.valueOf(this.codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoAyudaPosgradoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.codigo = estadoEnum.name();
        }
    }

}
