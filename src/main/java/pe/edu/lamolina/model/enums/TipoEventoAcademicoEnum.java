package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoEventoAcademicoEnum {

    PROHOR("Programación Horario"),
    MAT("Matrícula"),
    CLASES("Clases"),
    EXAMEN("Exámenes"),
    RCI("Retiro Ciclo"),
    RCU("Retiro Curso"),
    ENCU("Encuesta");

    private final String value;
    private static final Map<String, TipoEventoAcademicoEnum> lookup = new HashMap<>();

    static {
        for (TipoEventoAcademicoEnum d : TipoEventoAcademicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoEventoAcademicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoEventoAcademicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoEventoAcademicoEnum d : TipoEventoAcademicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
