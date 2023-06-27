package pe.edu.lamolina.model.finanzas;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fin_movimiento_caja_acreencia")
public class MovimientoCajaAcreencia implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_acreencia")
    private Acreencia acreencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_caja")
    private MovimientoCaja movimientoCaja;

    public MovimientoCajaAcreencia() {
    }

    public MovimientoCajaAcreencia(Long id) {
        this.id = id;
    }

    public MovimientoCajaAcreencia(Long id, BigDecimal importe) {
        this.id = id;
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Acreencia getAcreencia() {
        return acreencia;
    }

    public void setAcreencia(Acreencia acreencia) {
        this.acreencia = acreencia;
    }

    public MovimientoCaja getMovimientoCaja() {
        return movimientoCaja;
    }

    public void setMovimientoCaja(MovimientoCaja movimientoCaja) {
        this.movimientoCaja = movimientoCaja;
    }

}
