package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "isec_resumen_socioeconomico")
public class ResumenSocioeconomico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "situacion_socio_familiar")
    private String situacionSocioFamiliar;

    @Column(name = "situacion_economica_familiar")
    private String situacionEconomicaFamiliar;

    @Column(name = "situacion_economica_individual")
    private String situacionEconomicaIndividual;

    @Column(name = "situacion_vivienda")
    private String situacionVivienda;

    @Column(name = "relacion_familiar")
    private String relacionFamiliar;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @Transient
    private Alumno alumno;
    @Transient
    private Tramite tramite;

    public ResumenSocioeconomico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public ResumenSocioeconomico clone() {
        ResumenSocioeconomico clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
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
