package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "med_nivel_examen_clinico")
public class NivelExamenClinico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Transient
    private List<ExamenClinico> examenClinico;

    public NivelExamenClinico() {
    }

    public NivelExamenClinico(Object id) {
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

    public List<ExamenClinico> getExamenClinico() {
        return examenClinico;
    }

    public void setExamenClinico(List<ExamenClinico> examenClinico) {
        this.examenClinico = examenClinico;
    }

}
