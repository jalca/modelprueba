package pe.edu.lamolina.model.medico;

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
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "med_historia_dificultad_permanente")
public class HistoriaDificultadPermanente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dificultad_permanente")
    private DificultadPermanente dificultadPermanente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Boolean escogido;

    public HistoriaDificultadPermanente() {

    }

    public HistoriaDificultadPermanente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @Override
    public HistoriaDificultadPermanente clone() {
        HistoriaDificultadPermanente clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .only("id,fechaRegistro")
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
                    .join("dificultadPermanente")
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
