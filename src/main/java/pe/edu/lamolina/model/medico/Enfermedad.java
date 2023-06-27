package pe.edu.lamolina.model.medico;

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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Getter
@Setter
@Entity
@Table(name = "med_enfermedad")
public class Enfermedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "con_comentario")
    private Boolean conComentario;

    @Column(name = "tiene_riesgo")
    private Boolean tieneRiesgo;

    @Column(name = "requiere_fecha")
    private Boolean requiereFecha;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enfermedad_categoria")
    private EnfermedadCategoria enfermedadCategoria;

    @Transient
    private boolean disabled;

    public Enfermedad() {
    }

    public Enfermedad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean getConComentario() {
        if (conComentario == null) {
            return false;
        }
        return conComentario;
    }

    public Boolean getTieneRiesgo() {
        if (tieneRiesgo == null) {
            return false;
        }
        return tieneRiesgo;
    }

}
