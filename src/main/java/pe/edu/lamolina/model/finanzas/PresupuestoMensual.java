package pe.edu.lamolina.model.finanzas;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pe.edu.lamolina.model.almacen.Mes;

@Entity
@Table(name = "fin_presupuesto_mensual")
public class PresupuestoMensual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mes")
    private Mes mes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_presupuesto_anual")
    private PresupuestoAnual presupuestoAnual;

    @OneToMany(mappedBy = "presupuestoMensual", fetch = FetchType.LAZY)
    private List<DetallePresupuesto> listDetallePresupuesto;

    public PresupuestoMensual() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public PresupuestoAnual getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(PresupuestoAnual presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public List<DetallePresupuesto> getListDetallePresupuesto() {
        return listDetallePresupuesto;
    }

    public void setListDetallePresupuesto(List<DetallePresupuesto> listDetallePresupuesto) {
        this.listDetallePresupuesto = listDetallePresupuesto;
    }

}
