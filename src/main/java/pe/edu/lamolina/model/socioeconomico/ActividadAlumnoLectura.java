package pe.edu.lamolina.model.socioeconomico;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;

@Entity
@Getter
@Setter
@Table(name = "obu_actividad_alumno_lectura")
public class ActividadAlumnoLectura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otro_libro")
    private String otroLibro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_libro")
    private TipoLibro tipoLibro;

    public ActividadAlumnoLectura() {
    }

    public ActividadAlumnoLectura(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}
