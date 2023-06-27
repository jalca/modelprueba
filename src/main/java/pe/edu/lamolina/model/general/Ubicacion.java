package pe.edu.lamolina.model.general;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@Table(name = "gen_ubicacion")
public class Ubicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_superior")
    private Ubicacion ubicacionSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ubicacion")
    private TipoUbicacion tipoUbicacion;

    @OneToMany(mappedBy = "ubicacionNacer", fetch = FetchType.LAZY)
    private List<Persona> persona;

    @OneToMany(mappedBy = "ubicacionDomicilio", fetch = FetchType.LAZY)
    private List<Persona> persona1;

    @OneToMany(mappedBy = "ubicacionSuperior", fetch = FetchType.LAZY)
    private List<Ubicacion> ubicaciones;

    public Ubicacion() {
    }

    public Ubicacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getDistrito() {
        if (ubicacionSuperior == null) {
            return null;
        }
        if (ubicacionSuperior.getUbicacionSuperior() == null) {
            return null;
        }
        if (tipoUbicacion == null) {
            return null;
        }
        if (ubicacionSuperior.getTipoUbicacion() == null) {
            return null;
        }
        if (ubicacionSuperior.getUbicacionSuperior().getTipoUbicacion() == null) {
            return null;
        }


        Ubicacion dpto = ubicacionSuperior.getUbicacionSuperior();
        String zona3 = dpto.getTipoUbicacion().getSimbolo() + ": " + dpto.getNombre();
        String zona2 = ubicacionSuperior.getTipoUbicacion().getSimbolo() + ": " + ubicacionSuperior.getNombre();
        String zona1 = tipoUbicacion.getSimbolo() + ": " + this.getNombre();
        return zona1 + " / " + zona2 + " / " + zona3;
    }

    public String getDistrito2() {
        if (ubicacionSuperior == null) {
            return null;
        }
        if (ubicacionSuperior.getUbicacionSuperior() == null) {
            return null;
        }

        Ubicacion dpto = ubicacionSuperior.getUbicacionSuperior();
        String provincia = ubicacionSuperior.getNombre();
        String departamento = dpto.getNombre();
        String distrito = this.getNombre();
        return distrito + ", " + provincia + ", " + departamento;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "tipoUbicacion", tipoUbicacion);
        ModelUtils.getDataByAttrObject(join, "ubicacionSuperior", ubicacionSuperior, "id", "nombre", "codigo");

        return join.toString();
    }

}
