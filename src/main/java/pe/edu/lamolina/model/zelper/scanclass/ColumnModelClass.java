package pe.edu.lamolina.model.zelper.scanclass;

import java.lang.reflect.Field;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColumnModelClass {

    private String attributeName;
    private String columnName;
    private Field field;
}
