package pe.edu.lamolina.model.contabilidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.contabilidad.CodigoMovimientoPresupuestoEnum;
import pe.edu.lamolina.model.enums.contabilidad.TipoMovimientoPresupuestoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@Table(name = "cont_movimiento_partida_presupuestal")
public class MovimientoPartidaPresupuestal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "direccion_movimiento")
    private String direccionMovimiento;

    @Column(name = "codigo_movimiento")
    private String codigoMovimiento;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_movimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMovimiento;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida_presupuesto")
    private PartidaPresupuestal partidaPresupuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida_presupuesto_destino")
    private PartidaPresupuestal partidaPresupuestoDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida_presupuesto_origen")
    private PartidaPresupuestal partidaPresupuestoOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_subvencion")
    private OrdenSubvencionEconomia ordenSubvencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_superior")
    private MovimientoPartidaPresupuestal movimientoSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public MovimientoPartidaPresupuestal() {
    }

    public MovimientoPartidaPresupuestal(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoMovimientoPresupuestoEnum getDireccionMovimientoEnum() {
        if (direccionMovimiento == null) {
            return null;
        }
        return TipoMovimientoPresupuestoEnum.valueOf(direccionMovimiento);
    }

    @JsonIgnore
    public void setDireccionMovimientoEnum(TipoMovimientoPresupuestoEnum direccionMovimiento) {
        if (direccionMovimiento == null) {
            return;
        }
        this.direccionMovimiento = direccionMovimiento.name();
    }

    public CodigoMovimientoPresupuestoEnum getCodigoMovimientoEnum() {
        if (codigoMovimiento == null) {
            return null;
        }
        return CodigoMovimientoPresupuestoEnum.valueOf(codigoMovimiento);
    }

    @JsonIgnore
    public void setCodigoMovimientoEnum(CodigoMovimientoPresupuestoEnum codigoMovimiento) {
        if (codigoMovimiento == null) {
            return;
        }
        this.codigoMovimiento = codigoMovimiento.name();
    }

}
