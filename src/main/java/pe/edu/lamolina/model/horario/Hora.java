package pe.edu.lamolina.model.horario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Dia;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hor_hora")
public class Hora implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descripcion_fin")
    private String descripcionFin;

    @Column(name = "descripcion2")
    private String descripcion2;

    @Column(name = "descripcion2_fin")
    private String descripcion2Fin;

    @Column(name = "hora")
    private Integer hora;

    @Column(name = "minutos")
    private Integer minutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_hora")
    private TipoHora tipoHora;

    @OneToMany(mappedBy = "hora", fetch = FetchType.LAZY)
    private List<DiaHoraGrupo> diaHoraGrupo;

    @OneToMany(mappedBy = "hora", fetch = FetchType.LAZY)
    private List<HorarioSeccion> horarioSeccion;

    @Transient
    private List<Dia> dias;

    @Transient
    @JsonIgnore
    private Hora horaSiguiente;

    public Hora(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public static class CompareCodigo implements Comparator<Hora> {

        @Override
        public int compare(Hora h1, Hora h2) {
            return h1.getCodigo().compareTo(h2.getCodigo());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Hora)) {
            return false;
        }
        Hora other = (Hora) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public Hora clone() {
        Hora clone = null;
        try {
            clone = (Hora) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Hora{" + "id=" + id + ", numero=" + numero + ", codigo=" + codigo + ", descripcion=" + descripcion + ", hora=" + hora + ", minutos=" + minutos + ", tipoHora=" + tipoHora + ", horaSiguiente=" + horaSiguiente + '}';
    }

}
