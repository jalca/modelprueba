package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.enums.ActividadPostulanteEscuelaEstadoEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "epg_actividad_postulante_escuela")
public class ActividadPostulanteEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_ejecucion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaEjecucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante_escuela")
    private PostulanteEscuela postulanteEscuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad_admision_escuela")
    private ActividadAdmisionEscuela actividadAdmisionEscuela;

    @Transient
    private Integer ready;

    public void setEstadoEnum(ActividadPostulanteEscuelaEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            this.estado = null;
        }
        this.estado = estadoEnum.name();
    }

    @JsonIgnore
    public ActividadPostulanteEscuelaEstadoEnum getEstadoEnum() {
        if (Strings.isNullOrEmpty(this.estado)) {
            return null;
        }
        return ActividadPostulanteEscuelaEstadoEnum.valueOf(estado);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaEjecucion", fechaEjecucion, false);
        ModelUtils.getDataByAttrObject(join, "postulanteEscuela", postulanteEscuela, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "actividadAdmisionEscuela", actividadAdmisionEscuela, "id", "codigo", "nombre");

        return join.toString();
    }

}
