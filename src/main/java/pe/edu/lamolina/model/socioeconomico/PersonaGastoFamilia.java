package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_gasto_familia")
public class PersonaGastoFamilia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto_lima")
    private BigDecimal montoLima;

    @Column(name = "monto_provincia")
    private BigDecimal montoProvincia;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gasto_familia")
    private GastoFamilia gastoFamilia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public PersonaGastoFamilia() {
        this.montoLima = BigDecimal.ZERO;
        this.montoProvincia = BigDecimal.ZERO;
    }

    public PersonaGastoFamilia(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getMontoLimaStr() {
        if (montoLima != null) {
            return NumberFormat.precio(montoLima);
        }
        return "0.00";
    }

    public String getMontoProvinciaStr() {
        if (montoLima != null) {
            return NumberFormat.precio(montoLima);
        }
        return "0.00";
    }

    @Override
    public PersonaGastoFamilia clone() {
        PersonaGastoFamilia clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .only("id,montoLima,montoProvincia,fechaRegistro")
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
                    .join("gastoFamilia")
                    .join("userRegistro", "id")
                    .json();

            clone = objectMapper.readValue(json.toString(), this.getClass());
            return clone;

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return clone;
    }

}
