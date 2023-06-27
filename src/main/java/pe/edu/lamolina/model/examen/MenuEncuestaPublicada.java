package pe.edu.lamolina.model.examen;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.activadorficha.TipoActivacionFichaEnum;
import pe.edu.lamolina.model.seguridad.Menu;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_menu_encuesta_publicada")
public class MenuEncuestaPublicada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_activacion")
    private String tipoActivacion;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_publicada")
    private EncuestaPublicada encuestaPublicada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public MenuEncuestaPublicada(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoActivacionFichaEnum getTipoActivacionEnum() {
        if (tipoActivacion == null) {
            return null;
        }
        return TipoActivacionFichaEnum.valueOf(tipoActivacion);
    }

    @JsonIgnore
    public void setTipoActivacionEnum(TipoActivacionFichaEnum tipoActivacion) {
        if (tipoActivacion == null) {
            return;
        }
        this.tipoActivacion = tipoActivacion.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tipoActivacion", tipoActivacion, false);
        ModelUtils.getDataByAttr(join, "mensaje", mensaje, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "encuestaPublicada", encuestaPublicada, "id");
        ModelUtils.getDataByAttrObject(join, "menu", menu, "id", "nombre", "ruta");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }
}
