package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.enums.AportesEnum;
import pe.edu.lamolina.model.enums.EstadoAporteEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "apo_aporte")
public class Aporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fraccionable")
    private Boolean fraccionable;

    @Column(name = "exonerable")
    private Boolean exonerable;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    public Aporte(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCodigo() {
        return codigo;
    }

    @JsonIgnore
    public void setCodigoEnum(AportesEnum estadoEnum) {
        if (estadoEnum != null) {
            this.codigo = estadoEnum.name();
        }
    }

    public AportesEnum getCodigoEnum() {
        if (StringUtils.isBlank(codigo)) {
            return null;
        }
        try {
            return AportesEnum.valueOf("A".concat(codigo));
        } catch (Exception e) {
        }
        return null;
    }

    public EstadoAporteEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoAporteEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAporteEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public boolean isMatriculaExtemporanea() {
        return AportesEnum.A06.name().equals(this.codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Aporte)) {
            return false;
        }

        Aporte other = (Aporte) obj;
        if (this.id == null && other.getId() == null) {
            return true;
        }

        if ((this.id == null && other.getId() != null)
                || (this.id != null && other.getId() == null)
                || (this.id.compareTo(other.getId()) != 0)) {
            return false;
        }
        return true;
    }
}
