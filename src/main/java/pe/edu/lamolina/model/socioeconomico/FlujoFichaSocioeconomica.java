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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.FichaSocioeconomicaEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_flujo_ficha_socioeconomica")
public class FlujoFichaSocioeconomica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ficha_socioeconomica")
    private FichaSocioeconomica fichaSocioeconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public FlujoFichaSocioeconomica() {
    }

    public FlujoFichaSocioeconomica(Object id) {
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
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro);
        ModelUtils.getDataByAttrObject(join, "fichaSocioeconomica", fichaSocioeconomica, "id");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }
}
