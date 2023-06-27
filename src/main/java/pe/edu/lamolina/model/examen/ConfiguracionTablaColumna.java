package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import pe.edu.lamolina.model.enums.encuesta.TipoConfiguracionTablaColumnaEnum;
import pe.edu.lamolina.model.enums.encuesta.TipoValorColumnaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_configuracion_tabla_columna")
public class ConfiguracionTablaColumna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pregunta")
    private String pregunta;

    @Column(name = "tabla_general")
    private String tablaGeneral;

    @Column(name = "columna_general")
    private String columnaGeneral;

    @Column(name = "nombre_atributo")
    private String nombreAtributo;

    @Column(name = "tipo_configuracion")
    private String tipoConfiguracion;

    @Column(name = "tipo_valor")
    private String tipoValor;

    @Column(name = "tabla_referenciada")
    private String tablaReferenciada;

    @Column(name = "columna_referenciada")
    private String columnaReferenciada;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<ValorTablaColumna> valoresTablaColumna;

    public ConfiguracionTablaColumna(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoConfiguracionTablaColumnaEnum getTipoConfiguracionEnum() {
        if (this.tipoConfiguracion == null) {
            return null;
        }
        return TipoConfiguracionTablaColumnaEnum.valueOf(this.tipoConfiguracion);
    }

    @JsonIgnore
    public void setTipoConfiguracionEnum(TipoConfiguracionTablaColumnaEnum tipoConfiguracion) {
        if (tipoConfiguracion == null) {
            return;
        }
        this.tipoConfiguracion = tipoConfiguracion.name();
    }

    public TipoValorColumnaEnum getTipoValorEnum() {
        if (this.tipoValor == null) {
            return null;
        }
        return TipoValorColumnaEnum.valueOf(this.tipoValor);
    }

    @JsonIgnore
    public void setTipoValorEnum(TipoValorColumnaEnum tipoValor) {
        if (tipoValor == null) {
            return;
        }
        this.tipoValor = tipoValor.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tablaGeneral", tablaGeneral, false);
        ModelUtils.getDataByAttr(join, "columnaGeneral", columnaGeneral, false);
        ModelUtils.getDataByAttr(join, "nombreAtributo", nombreAtributo, false);
        ModelUtils.getDataByAttr(join, "tipoConfiguracion", tipoConfiguracion, false);
        ModelUtils.getDataByAttr(join, "tipoValor", tipoValor, false);
        ModelUtils.getDataByAttr(join, "tablaReferenciada", tablaReferenciada, false);
        ModelUtils.getDataByAttr(join, "columnaReferenciada", columnaReferenciada, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
