package pe.edu.lamolina.model.almacen;

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
import pe.edu.lamolina.model.enums.TipoMovimientoAlmacenEnum;

@Entity
@Table(name = "alm_tipo_movimiento")
public class TipoMovimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    public TipoMovimiento() {
    }

    public TipoMovimiento(Object id) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoMovimientoAlmacenEnum getCodigoEnum() {
        if(StringUtils.isBlank(this.codigo)){
            return null;
        }
        return TipoMovimientoAlmacenEnum.valueOf(this.codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoMovimientoAlmacenEnum tipoMovimientoAlmacenEnum) {
        if (tipoMovimientoAlmacenEnum != null) {
            this.codigo = tipoMovimientoAlmacenEnum.name();
        }
    }

}
