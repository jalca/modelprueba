package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_familia")
public class PersonaFamilia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado_relacion_familiar")
    private String estadoRelacionFamiliar;

    @Column(name = "comentario_relacion_familiar")
    private String comentarioRelacionFamiliar;

    @Column(name = "ingresos")
    private BigDecimal ingresos;

    @Column(name = "egresos")
    private BigDecimal egresos;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reside_con")
    private ResideCon resideCon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_civil_padres")
    private EstadoCivilPadres estadoCivilPadres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public PersonaFamilia() {
    }

    public PersonaFamilia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public PersonaFamilia clone() {
        PersonaFamilia clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
                    .join("resideCon")
                    .join("estadoCivilPadres")
                    .json();

            clone = objectMapper.readValue(json.toString(), this.getClass());
            return clone;

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estadoRelacionFamiliar", estadoRelacionFamiliar, false);
        ModelUtils.getDataByAttr(join, "comentarioRelacionFamiliar", comentarioRelacionFamiliar, false);
        ModelUtils.getDataByAttr(join, "ingresos", ingresos, false);
        ModelUtils.getDataByAttr(join, "egresos", egresos, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "resideCon", resideCon, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "estadoCivilPadres", estadoCivilPadres, "id", "nombre");

        return join.toString();
    }

}
