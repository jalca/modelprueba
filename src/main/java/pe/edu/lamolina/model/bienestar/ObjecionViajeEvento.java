package pe.edu.lamolina.model.bienestar;

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
import pe.edu.lamolina.model.enums.agrupaciones.EventoAlumnosEstadoEnum;
import static pe.edu.lamolina.model.enums.agrupaciones.EventoAlumnosEstadoEnum.REQUIERE_VB;
import pe.edu.lamolina.model.enums.subvenciones.ContextoObjecionEnum;
import pe.edu.lamolina.model.enums.subvenciones.ObjecionEstadoEnum;
import pe.edu.lamolina.model.enums.subvenciones.ViajeCursoEstadoEnum;
import static pe.edu.lamolina.model.enums.subvenciones.ViajeCursoEstadoEnum.INSCRITOS;
import static pe.edu.lamolina.model.enums.subvenciones.ViajeCursoEstadoEnum.VB_ADMIN;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_objecion_viaje_evento")
public class ObjecionViajeEvento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contexto")
    private String contexto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_inicio")
    private String estadoInicio;

    @Column(name = "estado_final")
    private String estadoFinal;

    @Column(name = "objecion")
    private String objecion;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "fecha_inspeccion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInspeccion;

    @Column(name = "fecha_correccion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCorreccion;

    @Column(name = "fecha_aceptacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAceptacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_viaje_curso")
    private ViajeCurso viajeCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_agrupacion")
    private EventoAgrupacionAlumnos eventoAgrupacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_objecion_origen")
    private ObjecionViajeEvento objecionOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_inspeccion")
    private Usuario userInspeccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_correcion")
    private Usuario userCorrecion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aceptacion")
    private Usuario userAceptacion;

    public ObjecionViajeEvento() {
    }

    public ObjecionViajeEvento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ContextoObjecionEnum getContextoEnum() {
        if (contexto == null) {
            return null;
        }
        return ContextoObjecionEnum.valueOf(contexto);
    }

    @JsonIgnore
    public void setContextoEnum(ContextoObjecionEnum contexto) {
        if (contexto == null) {
            return;
        }
        this.contexto = contexto.name();
    }

    public ObjecionEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ObjecionEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(ObjecionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public ViajeCursoEstadoEnum getEstadoInicioViajeEnum() {
        if (estadoInicio == null) {
            return null;
        }
        for (ViajeCursoEstadoEnum value : ViajeCursoEstadoEnum.values()) {
            if (value.name().equals(estadoInicio)) {
                return ViajeCursoEstadoEnum.valueOf(estadoInicio);
            }
        }
        return null;
    }

    @JsonIgnore
    public void setEstadoInicioViajeEnum(ViajeCursoEstadoEnum estadoInicio) {
        if (estadoInicio == null) {
            return;
        }
        this.estadoInicio = estadoInicio.name();
    }

    public EventoAlumnosEstadoEnum getEstadoInicioEventoEnum() {
        if (estadoInicio == null) {
            return null;
        }
        for (EventoAlumnosEstadoEnum value : EventoAlumnosEstadoEnum.values()) {
            if (value.name().equals(estadoInicio)) {
                return EventoAlumnosEstadoEnum.valueOf(estadoInicio);
            }
        }
        return null;
    }

    @JsonIgnore
    public void setEstadoInicioEventoEnum(EventoAlumnosEstadoEnum estadoInicio) {
        if (estadoInicio == null) {
            return;
        }
        this.estadoInicio = estadoInicio.name();
    }

    public ViajeCursoEstadoEnum getEstadoFinalViajeEnum() {
        if (estadoFinal == null) {
            return null;
        }
        for (ViajeCursoEstadoEnum value : ViajeCursoEstadoEnum.values()) {
            if (value.name().equals(estadoFinal)) {
                return ViajeCursoEstadoEnum.valueOf(estadoFinal);
            }
        }
        return null;
    }

    @JsonIgnore
    public void setEstadoFinalViajeEnum(ViajeCursoEstadoEnum estadoFinal) {
        if (estadoFinal == null) {
            return;
        }
        this.estadoFinal = estadoFinal.name();
    }

    public EventoAlumnosEstadoEnum getEstadoFinalEventoEnum() {
        if (estadoFinal == null) {
            return null;
        }
        for (EventoAlumnosEstadoEnum value : EventoAlumnosEstadoEnum.values()) {
            if (value.name().equals(estadoFinal)) {
                return EventoAlumnosEstadoEnum.valueOf(estadoFinal);
            }
        }
        return null;
    }

    @JsonIgnore
    public void setEstadoFinalEventoEnum(EventoAlumnosEstadoEnum estadoFinal) {
        if (estadoFinal == null) {
            return;
        }
        this.estadoFinal = estadoFinal.name();
    }

    public String tipo() {
        if (this.estado == null) {
            return "Origen Indefinido";
        }

        if (this.viajeCurso != null) {
            if (getEstadoInicioViajeEnum() == INSCRITOS) {
                return "Observación de la Administración OBU";
            }
            if (getEstadoInicioViajeEnum() == VB_ADMIN) {
                return "Observación de la Jefatura OBU";
            }
        }

        if (this.eventoAgrupacion != null) {
            if (getEstadoInicioEventoEnum() == REQUIERE_VB) {
                return "Observación de la Jefatura OBU";
            }
        }

        return "Origen Indefinido";
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "contexto", contexto, false);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "estadoInicio", estadoInicio, false);
        ModelUtils.getDataByAttr(join, "estadoFinal", estadoFinal, false);
        ModelUtils.getDataByAttr(join, "objecion", objecion, false);
        ModelUtils.getDataByAttr(join, "respuesta", respuesta, false);
        ModelUtils.getDataByAttr(join, "fechaInspeccion", fechaInspeccion, false);
        ModelUtils.getDataByAttr(join, "fechaCorreccion", fechaCorreccion, false);
        ModelUtils.getDataByAttr(join, "fechaAceptacion", fechaAceptacion, false);
        ModelUtils.getDataByAttrObject(join, "viajeCurso", viajeCurso, "id", "estadoViaje");
        ModelUtils.getDataByAttrObject(join, "eventoAgrupacion", eventoAgrupacion, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "objecionOrigen", objecionOrigen, "id");
        ModelUtils.getDataByAttrObject(join, "userInspeccion", userInspeccion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userCorrecion", userCorrecion, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userAceptacion", userAceptacion, "id", "google");

        return join.toString();
    }

}
