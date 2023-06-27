package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "sip_resumen_descuentos")
public class ResumenDescuentos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hijo_empleado")
    private HijoEmpleado hijoEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_descuento_examen")
    private DescuentoExamen descuentoExamen;

    public ResumenDescuentos() {
    }

    public ResumenDescuentos(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HijoEmpleado getHijoEmpleado() {
        return hijoEmpleado;
    }

    public void setHijoEmpleado(HijoEmpleado hijoEmpleado) {
        this.hijoEmpleado = hijoEmpleado;
    }

    public DescuentoExamen getDescuentoExamen() {
        return descuentoExamen;
    }

    public void setDescuentoExamen(DescuentoExamen descuentoExamen) {
        this.descuentoExamen = descuentoExamen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

