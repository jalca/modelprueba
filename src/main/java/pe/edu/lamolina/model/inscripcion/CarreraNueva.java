package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoCarreraNuevaEnum;

@Entity
@Table(name = "sip_carrera_nueva")
public class CarreraNueva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "estado")
    private String estado;

    public CarreraNueva() {
    }

    public CarreraNueva(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarreraNuevaEnum estado) {
        this.estado = estado.name();
    }

    public EstadoCarreraNuevaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoCarreraNuevaEnum.valueOf(estado);
    }

    public static class CompareOrden implements Comparator<CarreraNueva> {

        @Override
        public int compare(CarreraNueva carr1, CarreraNueva carr2) {
            return carr1.getOrden().compareTo(carr2.getOrden());
        }
    }

}
