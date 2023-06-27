package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.enums.NivelOficinaEnum;
import pe.edu.lamolina.model.enums.TipoOficinaEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "gen_tipo_oficina")
public class TipoOficina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nivel")
    private String nivel;

    public TipoOficinaEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoOficinaEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoOficinaEnum codigo) {
        this.codigo = codigo.name();
    }

    public boolean isTipoFacultad() {
        if (StringUtils.isNotBlank(this.getCodigo()) && this.getCodigoEnum().equals(TipoOficinaEnum.FAC)) {
            return true;
        }
        return false;
    }

    public NivelOficinaEnum getNivelEnum() {
        return NivelOficinaEnum.valueOf(nivel);
    }

    @JsonIgnore
    public void setNivelEnum(NivelOficinaEnum nivel) {
        this.nivel = nivel.name();
    }

}
