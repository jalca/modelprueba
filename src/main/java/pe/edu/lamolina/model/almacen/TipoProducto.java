package pe.edu.lamolina.model.almacen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CodigoTipoProductoEnum;

@Entity
@Table(name = "alm_tipo_producto")
public class TipoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> producto;

    @Transient
    private List<Producto> categorias;

    public TipoProducto() {
    }

    public TipoProducto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
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

    public List<Producto> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Producto> categorias) {
        this.categorias = categorias;
    }

    public CodigoTipoProductoEnum getCodigoEnum() {
        if (this.codigo == null) {
            return null;
        }
        return CodigoTipoProductoEnum.valueOf(this.codigo);
    }

    public void setTipoEnum(CodigoTipoProductoEnum codigoEnum) {
        this.codigo = codigoEnum.name();
    }

}
