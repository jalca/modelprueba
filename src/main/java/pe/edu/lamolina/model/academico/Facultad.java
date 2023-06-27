package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EnteAcademicoEstadoEnum;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "aca_facultad")
public class Facultad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_curso")
    private String codigoCurso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "motivo_desactivacion")
    private String motivoDesactivacion;

    @Column(name = "consejeria_requerida")
    private Boolean consejeriaRequerida;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_desactivacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "facultad", fetch = FetchType.LAZY)
    private List<Carrera> carrera;

    @OneToMany(mappedBy = "facultad", fetch = FetchType.LAZY)
    private List<DepartamentoAcademico> departamentoAcademico;

    @Transient
    private BigDecimal montoTotalVerano;

    public Facultad() {
    }

    public Facultad(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EnteAcademicoEstadoEnum getEstadoEnum() {
        return estado == null ? null : EnteAcademicoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EnteAcademicoEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getMontoTotalVeranoFormato() {
        if (this.montoTotalVerano == null) {
            return null;
        }
        return NumberFormat.precio(this.montoTotalVerano);
    }

    public ObjectNode toJson() {
        JsonNodeFactory jc = JsonNodeFactory.instance;
        ObjectNode node = JsonHelper.createJson(this, jc);
        return node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public boolean isTieneRestriccion(List<RestriccionFacultad> restriccionesFacultad) {
        for (RestriccionFacultad restriccionFacultadEach : restriccionesFacultad) {
            if (this.getId().compareTo(restriccionFacultadEach.getFacultad().getId()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static class CompareCodigo implements Comparator<Facultad> {

        @Override
        public int compare(Facultad f1, Facultad f2) {
            return f1.getCodigo().compareTo(f2.getCodigo());
        }
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "codigoCurso", codigoCurso, false);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "simbolo", simbolo, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaDesactivacion", fechaDesactivacion, false);
        ModelUtils.getDataByAttr(join, "motivoDesactivacion", motivoDesactivacion, false);
        ModelUtils.getDataByAttr(join, "consejeriaRequerida", consejeriaRequerida, false);
        ModelUtils.getDataByAttrObject(join, "compania", compania, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
