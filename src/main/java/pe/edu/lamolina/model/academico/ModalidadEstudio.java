package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.Aporte;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;
import pe.edu.lamolina.model.enums.ModalidadEstudioEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@Table(name = "aca_modalidad_estudio")
public class ModalidadEstudio implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @OneToMany(mappedBy = "modalidadEstudio", fetch = FetchType.LAZY)
    private List<Carrera> carrera;

    @OneToMany(mappedBy = "modalidadEstudio", fetch = FetchType.LAZY)
    private List<CicloAcademico> cicloAcademico;

    @OneToMany(mappedBy = "modalidadEstudio", fetch = FetchType.LAZY)
    private List<Docente> docente;

    @OneToMany(mappedBy = "modalidadEstudio", fetch = FetchType.LAZY)
    private List<ModalidadIngreso> modalidadIngreso;

    @OneToMany(mappedBy = "modalidadEstudio", fetch = FetchType.LAZY)
    private List<Aporte> aporte;

    @Transient
    private Long cantidadAlumnoAporte;

    public ModalidadEstudio() {
    }

    public ModalidadEstudio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ModalidadEstudioEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return ModalidadEstudioEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(ModalidadEstudioEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public ModalidadEstudioEnum getOperativeModalidadEnum() {
        if (this.getCodigoEnum() == null) {
            return null;
        }
        ModalidadEstudioEnum modalidadEstudioAlumnoEnum = this.getCodigoEnum();
        if (modalidadEstudioAlumnoEnum == ModalidadEstudioEnum.ESP) {
            modalidadEstudioAlumnoEnum = ModalidadEstudioEnum.EPG;
        }
        if (modalidadEstudioAlumnoEnum == ModalidadEstudioEnum.VIS) {
            modalidadEstudioAlumnoEnum = ModalidadEstudioEnum.PRE;
        }
        return modalidadEstudioAlumnoEnum;
    }

    public boolean isOperativePRE() {
        return ModalidadEstudioEnum.PRE == this.getOperativeModalidadEnum();
    }

    public boolean isOperativeEPG() {
        return ModalidadEstudioEnum.EPG == this.getOperativeModalidadEnum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ModalidadEstudio)) {
            return false;
        }

        ModalidadEstudio other = (ModalidadEstudio) obj;
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

    public boolean isTieneRestriccion(List<RestriccionModalidad> restriccionesModalidad) {
        return false;
    }

    public boolean isPregrado() {
        if (ModalidadEstudioEnum.PRE.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isOptativo() {
        if (ModalidadEstudioEnum.OPT.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isPostgrado() {
        if (ModalidadEstudioEnum.EPG.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getIsEspecial() {
        if (ModalidadEstudioEnum.ESP.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean getIsVisitante() {
        if (ModalidadEstudioEnum.VIS.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    public boolean isIdiomas() {
        if (ModalidadEstudioEnum.IDIOM.name().equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttrObject(join, "compania", compania, "id", "nombre");
        ModelUtils.getDataByAttr(join, "cantidadAlumnoAporte", cantidadAlumnoAporte, false);

        return join.toString();
    }

}
