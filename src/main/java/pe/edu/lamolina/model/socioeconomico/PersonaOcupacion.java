package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.RangoIngresoEconomicoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_ocupacion")
public class PersonaOcupacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "centro_estudios")
    private String centroEstudios;

    @Column(name = "pension_estudios")
    private BigDecimal pensionEstudios;

    @Column(name = "otro_grado_instruccion")
    private String otroGradoInstruccion;

    @Column(name = "otra_profesion")
    private String otraProfesion;

    @Column(name = "otra_ocupacion")
    private String otraOcupacion;

    @Column(name = "otra_condicion")
    private String otraCondicion;

    @Column(name = "centro_trabajo")
    private String centroTrabajo;

    @Column(name = "trabajo_realiza")
    private String trabajoRealiza;

    @Column(name = "rango_ingreso")
    private String rangoIngreso;

    @Column(name = "ingreso_mensual")
    private BigDecimal ingresoMensual;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado_instruccion")
    private GradoInstruccion gradoInstruccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_economica")
    private SituacionEconomica situacionEconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesion")
    private Profesion profesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ocupacion")
    private Ocupacion ocupacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_condicion_trabajo")
    private CondicionTrabajo condicionTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public PersonaOcupacion() {
    }

    public PersonaOcupacion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public RangoIngresoEconomicoEnum getRangoIngresoEnum() {
        if (StringUtils.isBlank(rangoIngreso)) {
            return null;
        }
        return RangoIngresoEconomicoEnum.valueOf(rangoIngreso);
    }

    @JsonIgnore
    public void setRangoIngresoEnum(RangoIngresoEconomicoEnum rangoIngreso) {
        this.rangoIngreso = rangoIngreso.name();
    }

    @Override
    public PersonaOcupacion clone() {
        PersonaOcupacion clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
                    .join("gradoInstruccion")
                    .join("situacionEconomica")
                    .join("profesion")
                    .join("ocupacion")
                    .join("condicionTrabajo")
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
