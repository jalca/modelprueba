package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.SimboloUnidadMedidaEnum;

@Data
@Entity
@NoArgsConstructor
@Table(name = "gen_unidad_medida")
public class UnidadMedida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "cantidad_unidad_conversion")
    private BigDecimal cantidadUnidadConversion;

    @Column(name = "es_base")
    private Boolean esBase;

    @Column(name = "es_superior")
    private Boolean esSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_conversion")
    private UnidadMedida unidadConversion;

    @Transient
    private List<UnidadMedida> derivados;

    public UnidadMedida(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public SimboloUnidadMedidaEnum getSimboloEnum() {
        if (StringUtils.isBlank(simbolo)) {
            return null;
        }
        return SimboloUnidadMedidaEnum.valueOf(simbolo);
    }

    @JsonIgnore
    public void setSimboloEnum(SimboloUnidadMedidaEnum simboloEnum) {
        if (simboloEnum == null) {
            return;
        }
        this.simbolo = simboloEnum.name();
    }

}
