package pe.edu.lamolina.model.graduacion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoMiembroComisionEnum;

@Entity
@Table(name = "epg_tipo_miembro_comision_academica")
public class TipoMiembroComision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "orden")
    private Integer orden;

    public TipoMiembroComision() {
    }

    public TipoMiembroComision(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoMiembroComisionEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoMiembroComisionEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoMiembroComisionEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
