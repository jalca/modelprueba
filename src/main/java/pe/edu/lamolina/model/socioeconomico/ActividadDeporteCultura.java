package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "obu_actividad_deporte_cultura")
public class ActividadDeporteCultura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "practica_actividad")
    private Boolean practicaActividad;

    @Column(name = "practicaba_deporte_colegio")
    private Boolean practicaDeporteColegio;

    @Column(name = "experiencia_cultural_colegio")
    private Boolean experienciaCulturalColegio;

    @Column(name = "deporte")
    private String deporte;

    @Column(name = "comentario")
    private String comentario;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad_cultural")
    private ActividadCultural actividadCultural;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deporte_unalm")
    private ActividadDeporte deporteUnalm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultural_unalm")
    private ActividadCultural culturalUnalm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private Boolean isCulturalUnalm;

    @Transient
    private Boolean isDeporteUnalm;

    @Transient
    private Long idAlumno;

    public ActividadDeporteCultura() {
    }

    public ActividadDeporteCultura(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean getIsCulturalUnalm() {
        if (isCulturalUnalm == null) {
            return false;
        }
        return isCulturalUnalm;
    }

    public Boolean getIsDeporteUnalm() {
        if (isDeporteUnalm == null) {
            return false;
        }
        return isDeporteUnalm;
    }

}
