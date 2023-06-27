package pe.edu.lamolina.model.finanzas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.enums.CodigoTipoPedidoGastoEnum;

@Entity
@Table(name = "fin_tipo_pedido_gasto")
public class TipoPedidoGasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    public TipoPedidoGasto() {
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

    public CodigoTipoPedidoGastoEnum getCodigoEnum() {
        if (StringUtils.isBlank(codigo)) {
            return null;
        }
        return CodigoTipoPedidoGastoEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(CodigoTipoPedidoGastoEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
