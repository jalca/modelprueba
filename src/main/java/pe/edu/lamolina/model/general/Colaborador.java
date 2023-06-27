package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.consejeria.Consejero;
import pe.edu.lamolina.model.consejeria.CoordinadorConsejeria;
import pe.edu.lamolina.model.enums.ColaboradorEstadoEnum;
import pe.edu.lamolina.model.permisoprogramacion.ColaboradorAnexo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gen_colaborador")
public class Colaborador implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_estado")
    private String motivoEstado;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "es_jefe_oficina")
    private Boolean esJefeOficina;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private PerfilCompania cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<CoordinadorConsejeria> coordinadorConsejeria;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Consejero> consejero;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<FuncionColaborador> funcionColaborador;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<ColaboradorAnexo> colaboradorAnexos;

    public Colaborador(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ColaboradorEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ColaboradorEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(ColaboradorEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Boolean getEsJefeOficina() {
        if (esJefeOficina == null) {
            return false;
        }
        return esJefeOficina;
    }

    @Override
    public Colaborador clone() {
        Colaborador clone = null;
        try {
            clone = (Colaborador) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "motivoEstado", motivoEstado, false);
        ModelUtils.getDataByAttr(join, "telefono", telefono, false);
        ModelUtils.getDataByAttr(join, "esJefeOficina", esJefeOficina, false);
        ModelUtils.getDataByAttr(join, "fechaInicio", fechaInicio, false);
        ModelUtils.getDataByAttr(join, "fechaFin", fechaFin, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "oficina", oficina, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "cargo", cargo, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
