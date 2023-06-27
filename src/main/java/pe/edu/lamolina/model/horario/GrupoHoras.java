package pe.edu.lamolina.model.horario;

import java.io.Serializable;
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
import pe.edu.lamolina.model.academico.CuotasGrupoHoras;
import pe.edu.lamolina.model.academico.Seccion;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hor_grupo_horas")
public class GrupoHoras implements Serializable, Cloneable {

    public static final String CODIGO_GRUPO_ZETA = "Z";
    public static final String CODIGO_GRUPO_ZETA_ASTERISK = "Z*";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "letra")
    private String letra;

    @Column(name = "tipo_ciclo")
    private String tipoCiclo;

    @Column(name = "tipo_seccion")
    private String tipoSeccion;

    @Column(name = "color")
    private String color;

    @Column(name = "con_horario")
    private String conHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_grupo_horas")
    private TipoGrupoHoras tipoGrupoHoras;

    @OneToMany(mappedBy = "grupoHoras", fetch = FetchType.LAZY)
    private List<Seccion> seccion;

    @OneToMany(mappedBy = "grupoHorario", fetch = FetchType.LAZY)
    private List<DiaHoraGrupo> diaHoraGrupo;

    @Transient
    private Boolean horasMismoDia;
    @Transient
    private Boolean horasMismaSemana;

    @Transient
    private CuotasGrupoHoras cuotasGrupoHoras;

    public GrupoHoras(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public boolean isPermiteCeroHoras() {
        if (this.isCodigoZeta() || this.isCodigoZetaAsterisk()) {
            return true;
        }
        return false;
    }

    public boolean isCodigoZeta() {
        if (CODIGO_GRUPO_ZETA.equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isCodigoZetaAsterisk() {

        if (CODIGO_GRUPO_ZETA_ASTERISK.equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    @Override
    public GrupoHoras clone() {
        GrupoHoras clone = null;
        try {
            clone = (GrupoHoras) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GrupoHoras)) {
            return false;
        }
        GrupoHoras other = (GrupoHoras) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoHoras{" + "id=" + id + ", codigo=" + codigo + ", letra=" + letra + ", tipoCiclo=" + tipoCiclo + ", tipoSeccion=" + tipoSeccion + ", conHorario=" + conHorario + '}';
    }

}
