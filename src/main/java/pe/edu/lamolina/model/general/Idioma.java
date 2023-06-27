package pe.edu.lamolina.model.general;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.NombreCurso;
import pe.edu.lamolina.model.tramite.PlantillaDocumentoAcademico;
import pe.edu.lamolina.model.tramite.TramiteDocumentoAcademico;

@Entity
@Getter
@Setter
@Table(name = "gen_idioma")
public class Idioma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "orden_obu")
    private Integer ordenObu;

    @Column(name = "con_comentario")
    private Boolean conComentario;

    @OneToMany(mappedBy = "idioma", fetch = FetchType.LAZY)
    private List<NombreCurso> nombreCurso;

    @OneToMany(mappedBy = "idioma", fetch = FetchType.LAZY)
    private List<PlantillaDocumentoAcademico> plantillaDocumentoAcademico;

    @OneToMany(mappedBy = "idioma", fetch = FetchType.LAZY)
    private List<TramiteDocumentoAcademico> tramiteDocumentoAcademico;

    public Idioma() {
    }

    public Idioma(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Idioma other = (Idioma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
