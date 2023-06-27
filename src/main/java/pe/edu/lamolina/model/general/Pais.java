package pe.edu.lamolina.model.general;

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
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.constantines.GlobalConstantine;
import pe.edu.lamolina.model.inscripcion.Postulante;

@Getter
@Setter
@Entity
@Table(name = "gen_pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "convenio_andres_bello")
    private Integer convenioAndresBello;

    @OneToMany(mappedBy = "paisNacer", fetch = FetchType.LAZY)
    private List<Persona> persona;

    @OneToMany(mappedBy = "nacionalidad", fetch = FetchType.LAZY)
    private List<Persona> persona1;

    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    private List<Universidad> universidad;

    @OneToMany(mappedBy = "paisColegio", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @OneToMany(mappedBy = "paisUniversidad", fetch = FetchType.LAZY)
    private List<Postulante> postulante1;

    @Transient
    private TipoDocIdentidad tipoDocIdentidad;

    public Pais() {
    }

    public Pais(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean esPeru() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(GlobalConstantine.CODE_PERU);
    }

    public boolean getEsPeru() {
        return this.esPeru();
    }

    public String getNacionalidadForm() {
        if (StringUtils.isBlank(this.nacionalidad)) {
            return StringUtils.isBlank(this.nombre) ? null : "De " + this.nombre;
        }
        return this.nacionalidad;
    }
}
