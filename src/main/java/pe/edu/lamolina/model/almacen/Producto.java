package pe.edu.lamolina.model.almacen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CategoriaProductoEnum;
import pe.edu.lamolina.model.enums.ControlAlmacenEstadoEnum;
import pe.edu.lamolina.model.enums.TipoArticuloEnum;
import pe.edu.lamolina.model.general.UnidadMedida;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "alm_producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto_superior")
    private Producto productoSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_principal")
    private UnidadMedida unidadPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "producto")
    private List<Inventario> inventario;

    @OneToMany(mappedBy = "producto")
    private List<ResumenInventario> resumenInventario;

    @OneToMany(mappedBy = "categoriaProducto")
    private List<Almacen> almacen;

    @OneToMany(mappedBy = "productoSuperior")
    private List<Producto> productos;

    @Transient
    private BigDecimal cantidad;

    @Transient
    private BigDecimal precio;

    public Producto(CategoriaProductoEnum categoria) {
        this.id = categoria.getId();
        this.codigo = categoria.name();
        this.nombre = categoria.getValue();
    }

    public Producto(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoArticuloEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoArticuloEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipoEnum(ControlAlmacenEstadoEnum tipoEnum) {
        this.tipo = tipoEnum.name();
    }

    public void setPrecioProducto(PrecioProducto precio) {
        if (precio == null) {
            this.precio = BigDecimal.ZERO;
            return;
        }
        this.precio = precio.getPrecio();
    }

}
