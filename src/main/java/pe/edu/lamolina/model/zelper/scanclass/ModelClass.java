package pe.edu.lamolina.model.zelper.scanclass;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelClass {

    private String className;
    private String classUrl;
    private String tableName;
    private Class clazz;
    private List<ColumnModelClass> columnas;
}
