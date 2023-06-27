package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "med_estado_nutricional")
public class EstadoNutricional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "imc_inicio")
    private Double imcInicio;

    @Column(name = "imc_fin")
    private Double imcFin;

    @Column(name = "estado")
    private String estado;

    @Column(name = "grado_obesidad")
    private String gradoObesidad;

    public EstadoNutricional() {
    }

    public EstadoNutricional(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getImcInicio() {
        return imcInicio;
    }

    public void setImcInicio(Double imcInicio) {
        this.imcInicio = imcInicio;
    }

    public Double getImcFin() {
        return imcFin;
    }

    public void setImcFin(Double imcFin) {
        this.imcFin = imcFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGradoObesidad() {
        return gradoObesidad;
    }

    public void setGradoObesidad(String gradoObesidad) {
        this.gradoObesidad = gradoObesidad;
    }

}
