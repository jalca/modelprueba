package pe.edu.lamolina.model.finanzas;

import pe.edu.lamolina.model.finanzas.MovimientoCaja;
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
import pe.edu.lamolina.model.general.Oficina;

@Entity
@Table(name = "fin_resumen_movimiento_caja")
public class ResumenMovimientoCaja implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "ingresos")
    private BigDecimal ingresos;

    @Column(name = "salidas")
    private BigDecimal salidas;

    @Column(name = "total_caja")
    private BigDecimal totalCaja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "resumenAbonos")
    private List<MovimientoCaja> movimientoCaja;

    public ResumenMovimientoCaja() {
    }

    public ResumenMovimientoCaja(Long id) {
        this.id = id;
    }

    public ResumenMovimientoCaja(Long id, Date fecha, BigDecimal ingresos, BigDecimal salidas, BigDecimal totalCaja) {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.salidas = salidas;
        this.totalCaja = totalCaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getSalidas() {
        return salidas;
    }

    public void setSalidas(BigDecimal salidas) {
        this.salidas = salidas;
    }

    public BigDecimal getTotalCaja() {
        return totalCaja;
    }

    public void setTotalCaja(BigDecimal totalCaja) {
        this.totalCaja = totalCaja;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<MovimientoCaja> getMovimientoCaja() {
        return movimientoCaja;
    }

    public void setMovimientoCaja(List<MovimientoCaja> movimientoCaja) {
        this.movimientoCaja = movimientoCaja;
    }

}
