package pe.edu.lamolina.model.zelper.scanclass;

import java.math.BigDecimal;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.lamolina.model.examen.ConfiguracionTablaColumna;
import pe.edu.lamolina.model.examen.ValorTablaColumna;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@NoArgsConstructor
public class PuntajeDatosPersona {

    private String className;
    private String tableName;
    private String pregunta;
    private ColumnModelClass columna;
    private String valor;
    private String descripcion;
    private BigDecimal puntaje;
    private ValorTablaColumna valorTablaColumna;
    private ConfiguracionTablaColumna configuracionTablaColumna;

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "className", className, false);
        ModelUtils.getDataByAttr(join, "tableName", tableName, false);
        ModelUtils.getDataByAttr(join, "pregunta", pregunta, false);
        ModelUtils.getDataByAttr(join, "valor", valor, false);
        ModelUtils.getDataByAttr(join, "descripcion", descripcion, false);
        ModelUtils.getDataByAttr(join, "puntaje", puntaje, false);
        ModelUtils.getDataByAttrObject(join, "columna", columna, "attributeName", "columnName");
        ModelUtils.getDataByAttrObject(join, "valorTablaColumna", valorTablaColumna, "id", "puntaje");
        ModelUtils.getDataByAttrObject(join, "configuracionTablaColumna", configuracionTablaColumna, "id", "pregunta");

        return join.toString();
    }
}
