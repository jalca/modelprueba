package pe.edu.lamolina.model.socioeconomico;

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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.FichaSocioeconomicaEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "isec_ficha_socioeconomica")
public class FichaSocioeconomica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_enviado")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEnviado;

    @Column(name = "fecha_revisado")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRevisado;

    @Column(name = "fecha_aceptado")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAceptado;

    @Column(name = "fecha_observa")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaObserva;

    @Column(name = "fecha_declaracion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaDeclaracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_procesando")
    private Tramite tramiteProcesando;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_enviado")
    private Usuario userEnviado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_revisado")
    private Usuario userRevisado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aceptado")
    private Usuario userAceptado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_observa")
    private Usuario userObserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_declaracion")
    private Usuario userDeclaracion;

    @Transient
    private Tramite tramite;
    @Transient
    private Boolean paraFinalizar;

    public FichaSocioeconomica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public FichaSocioeconomicaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return FichaSocioeconomicaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(FichaSocioeconomicaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "observacion", observacion, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaEnviado", fechaEnviado, false);
        ModelUtils.getDataByAttr(join, "fechaRevisado", fechaRevisado, false);
        ModelUtils.getDataByAttr(join, "fechaAceptado", fechaAceptado, false);
        ModelUtils.getDataByAttr(join, "fechaObserva", fechaObserva, false);
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "tramiteProcesando", tramiteProcesando, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRevisado, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userEnviado", userRevisado, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userRevisado", userRevisado, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userAceptado", userAceptado, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userObserva", userObserva, "id", "google");

        return join.toString();
    }
}
