package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.posgrado.admision.CarreraEscuela;

@Entity
@Table(name = "aca_area_posgrado")
public class AreaPosgrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @OneToMany(mappedBy = "areaPosgrado", fetch = FetchType.LAZY)
    private List<Carrera> carreras;
    
    @Transient
    private List<CarreraEscuela> carrerasEscuela;

    public AreaPosgrado() {
    }

    public AreaPosgrado(Object id) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<CarreraEscuela> getCarrerasEscuela() {
        return carrerasEscuela;
    }

    public void setCarrerasEscuela(List<CarreraEscuela> carrerasEscuela) {
        this.carrerasEscuela = carrerasEscuela;
    }
    
}
