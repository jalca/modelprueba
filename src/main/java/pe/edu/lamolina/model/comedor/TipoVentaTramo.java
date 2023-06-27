package pe.edu.lamolina.model.comedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ModoVentaEnum;
import pe.edu.lamolina.model.enums.TipoVentaEnum;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "com_tipo_venta_tramo")
public class TipoVentaTramo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "modo")
    private String modo;

    @Column(name = "tipo_venta")
    private String tipoVenta;

    @Column(name = "raciones_tramo")
    private Integer racionesTramo;

    @Column(name = "dias_antes_inicio")
    private Integer diasAntesInicio;

    @Column(name = "inicio_tramo")
    private String inicioTramo;

    @Column(name = "fin_tramo")
    private String finTramo;

    @Column(name = "inicio_interrumpe_tramo")
    private String inicioInterrumpeTramo;

    @Column(name = "fin_interrumpe_tramo")
    private String finInterrumpeTramo;

    @Column(name = "lapso_tramo")
    private Integer lapsoTramo;

    @Column(name = "racion_total")
    private Integer racionTotal;

    @Column(name = "cantidad_tramos")
    private Integer cantidadTramos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio")
    private TipoServicioComedor tipoServicio;

    @Transient
    private List<ControlVentaTramo> controlVentaTramo;

    @Transient
    private PrecioServicio precioServicio;

    @Transient
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date diaParaControlVenta;

    @Transient
    private Boolean isResto;

    public TipoVentaTramo() {
    }

    public TipoVentaTramo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ModoVentaEnum getModoEnum() {
        if (this.modo == null) {
            return null;
        }
        return ModoVentaEnum.valueOf(this.modo);
    }

    @JsonIgnore
    public void setModoEnum(ModoVentaEnum modo) {
        if (modo == null) {
            return;
        }
        this.modo = modo.name();
    }

    public TipoVentaEnum getTipoVentaEnum() {
        if (this.tipoVenta == null) {
            return null;
        }
        return TipoVentaEnum.valueOf(this.tipoVenta);
    }

    @JsonIgnore
    public void setTipoVentaEnum(TipoVentaEnum tipoVenta) {
        if (tipoVenta == null) {
            return;
        }
        this.tipoVenta = tipoVenta.name();
    }

    public Boolean getIsResto() {
        isResto = false;
        if (racionTotal == 0) {
            isResto = true;
        }
        return isResto;
    }

    public Integer getInicioTramoNumber() {
        if (this.inicioTramo == null) {
            return null;
        }
        return new Integer(this.inicioTramo.replace(":", ""));
    }

    public Integer getFinTramoNumber() {
        if (this.finTramo == null) {
            return null;
        }
        return new Integer(this.finTramo.replace(":", ""));
    }

}
