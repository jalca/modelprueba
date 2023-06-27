package pe.edu.lamolina.model.extensionobu;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.edu.lamolina.model.enums.CodigoDescuentoEnum;

@Entity
@Table(name = "extn_descuento_taller")
public class DescuentoTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "monto_descuento")
    private Integer montoDescuento;

    @Column(name = "cantidad_cursos")
    private Integer cantidadCursos;

    @Column(name = "prioridad")
    private Integer prioridad;

    public DescuentoTaller() {
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

    public CodigoDescuentoEnum getCodigoEnum() {
        return CodigoDescuentoEnum.valueOf(codigo);
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

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(Integer cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    public Integer getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Integer montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

}
