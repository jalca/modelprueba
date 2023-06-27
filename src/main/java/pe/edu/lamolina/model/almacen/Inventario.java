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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.enums.CondicionInventarioEnum;
import pe.edu.lamolina.model.enums.EstadoInventarioEnum;
import pe.edu.lamolina.model.finanzas.DetalleOrdenCompra;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@Entity
@Table(name = "alm_inventario")
public class Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "numero_inventario")
    private String numeroInventario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "serie")
    private String serie;

    @Column(name = "material")
    private String material;

    @Column(name = "largo")
    private String largo;

    @Column(name = "alto")
    private String alto;

    @Column(name = "ancho")
    private String ancho;

    @Column(name = "marca")
    private String marca;

    @Column(name = "color")
    private String color;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "vida_util")
    private BigDecimal vidaUtil;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaIngreso;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaBaja;

    @Temporal(TemporalType.DATE)
    @Column(name = "ano_fabricacion")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date anoFabricacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento_garantia")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaVencimientoGarantia;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_movimiento_almacen")
    private ItemMovimientoAlmacen itemMovimientoAlmacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_gestora")
    private Oficina oficinaGestora;

    @OneToMany(mappedBy = "inventario")
    private List<EstadoInventario> estadoInventario;

    @OneToMany(mappedBy = "inventario")
    private List<PrestamoInventario> prestamoInventario;

    @Transient
    private String comentarioEstado;

    @Transient
    private Integer times;

    @Transient
    private String imagen;

    @Transient
    private String imagentemporal;

    @Transient
    private String caracteristica;

    @Transient
    private Boolean codeEdit;

    @Transient
    private DetalleOrdenCompra detalleOrdenCompra;

    @Transient
    private Aula aula;

    public Inventario() {
    }

    public Inventario(Long id) {
        this.id = id;
    }

    public Inventario(Long id, String codigo, Date fechaIngreso, String estado, Usuario userRegistro, Date fechaRegistro) {
        this.id = id;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.userRegistro = userRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoInventarioEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoInventarioEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoInventarioEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public CondicionInventarioEnum getCondicionEnum() {
        if (this.condicion == null) {
            return null;
        }
        return CondicionInventarioEnum.valueOf(this.condicion);
    }

    @JsonIgnore
    public void setTipoEnum(CondicionInventarioEnum condicionEnum) {
        this.condicion = condicionEnum.name();
    }

    @Override
    public String toString() {
        return "db.AlmInventario[ id=" + id + " ]";
    }

}
