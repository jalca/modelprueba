package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import pe.edu.lamolina.model.enums.RecorridoIngresanteEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "aca_actividad_ingresante")
public class ActividadIngresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_ejecucion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEjecucion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recorrido_ingresante")
    private RecorridoIngresante recorridoIngresante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_actividad_ingresante")
    private TipoActividadIngresante tipoActividadIngresante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_ejecucion")
    private Usuario userEjecucion;

    @Transient
    private String exigeCareo;
    @Transient
    private Integer orden;

    public ActividadIngresante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getKey() {
        if (this.id == null) {
            return null;
        }
        if (this.recorridoIngresante == null) {
            return null;
        }
        if (this.recorridoIngresante.getId() == null) {
            return null;
        }
        return this.recorridoIngresante.getId() + "-" + this.id;
    }

    public RecorridoIngresanteEstadoEnum getEstadoEnum() {
        return estado != null ? RecorridoIngresanteEstadoEnum.valueOf(estado) : null;
    }

    @JsonIgnore
    public void setEstadoEnum(RecorridoIngresanteEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public boolean isEstadoInc() {
        if (this.estado == null) {
            return false;
        }
        return RecorridoIngresanteEstadoEnum.INC.equals(this.getEstadoEnum());
    }

    public boolean isEstadoPend() {
        if (this.estado == null) {
            return false;
        }
        return RecorridoIngresanteEstadoEnum.PEND.equals(this.getEstadoEnum());
    }

    public boolean isEstadoAct() {
        if (this.estado == null) {
            return false;
        }
        return RecorridoIngresanteEstadoEnum.ACT.equals(this.getEstadoEnum());
    }

    public boolean isEstadoSUPL() {
        if (this.estado == null) {
            return false;
        }
        return RecorridoIngresanteEstadoEnum.SUPL.equals(this.getEstadoEnum());
    }

    public static class CompareOrden implements Comparator<ActividadIngresante> {

        @Override
        public int compare(ActividadIngresante actIng1, ActividadIngresante actIng2) {
            return actIng1.getOrden().compareTo(actIng2.getOrden());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ActividadIngresante)) {
            return false;
        }
        ActividadIngresante other = (ActividadIngresante) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "fechaEjecucion", fechaEjecucion, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttrObject(join, "recorridoIngresante", recorridoIngresante, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "tipoActividadIngresante", tipoActividadIngresante, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "estado", "google");
        ModelUtils.getDataByAttrObject(join, "userEjecucion", userEjecucion, "id", "estado", "google");

        return join.toString();
    }

}
