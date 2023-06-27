package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.edu.lamolina.model.enums.encuesta.FormulaValorColumnaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_valor_tabla_columna")
public class ValorTablaColumna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "instancia_referenciada")
    private Long instanciaReferenciada;

    @Column(name = "valor_especifico")
    private String valorEspecifico;

    @Column(name = "formula")
    private String formula;

    @Column(name = "rango_inicio")
    private String rangoInicio;

    @Column(name = "rango_fin")
    private String rangoFin;

    @Column(name = "puntaje")
    private BigDecimal puntaje;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_configuracion_tabla_columna")
    private ConfiguracionTablaColumna configuracionTablaColumna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private String descripcion;

    public ValorTablaColumna(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public FormulaValorColumnaEnum getFormulaEnum() {
        if (this.formula == null) {
            return null;
        }
        return FormulaValorColumnaEnum.valueOf(this.formula);
    }

    @JsonIgnore
    public void setFormulaEnum(FormulaValorColumnaEnum formula) {
        if (formula == null) {
            return;
        }
        this.formula = formula.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "instanciaReferenciada", instanciaReferenciada, false);
        ModelUtils.getDataByAttr(join, "valorEspecifico", valorEspecifico, false);
        ModelUtils.getDataByAttr(join, "formula", formula, false);
        ModelUtils.getDataByAttr(join, "rangoInicio", rangoInicio, false);
        ModelUtils.getDataByAttr(join, "rangoFin", rangoFin, false);
        ModelUtils.getDataByAttr(join, "puntaje", puntaje, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "configuracionTablaColumna", configuracionTablaColumna, "id", "tablaGeneral", "columnaGeneral");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
