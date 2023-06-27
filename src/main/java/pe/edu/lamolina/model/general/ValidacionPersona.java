package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;
import pe.edu.lamolina.model.enums.persona.OrigenValidacionEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@Entity
@Table(name = "gen_validacion_persona")
public class ValidacionPersona implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "instancia_origen")
    private Long instanciaOrigen;

    @Column(name = "data_inicio")
    private String dataInicio;

    @Column(name = "data_final")
    private String dataFinal;

    @Column(name = "fecha_validacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_validacion")
    private Usuario userValidacion;

    public ValidacionPersona() {
    }

    public ValidacionPersona(Persona persona, Long instancia, Usuario user, Date fecha) {
        this.persona = persona;
        this.instanciaOrigen = instancia;
        this.userValidacion = user;
        this.fechaValidacion = fecha;
    }

    public ValidacionPersona(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public OrigenValidacionEnum getOrigenEnum() {
        if (origen == null) {
            return null;
        }
        return OrigenValidacionEnum.valueOf(origen);
    }

    @JsonIgnore
    public void setOrigenEnum(OrigenValidacionEnum origen) {
        if (origen == null) {
            return;
        }
        this.origen = origen.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "origen", origen, false);
        ModelUtils.getDataByAttr(join, "dataInicio", dataInicio, false);
        ModelUtils.getDataByAttr(join, "dataFinal", dataFinal, false);
        ModelUtils.getDataByAttr(join, "fechaValidacion", fechaValidacion, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "userValidacion", userValidacion, "id", "google");

        return join.toString();
    }
}
