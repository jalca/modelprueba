package pe.edu.lamolina.model.enums.dashboard;

import java.util.HashMap;
import java.util.Map;

public enum AmbitoAnuncioEnum {

    MODALIDADES_ESTUDIOS("Modalidades Estudios"),
    INGRESANTES("Alumnos Ingresantes"),
    MATRICULABLES("Matriculables"),
    FACULTADES("Facultades"),
    CARRERAS("Carreras"),
    CURSOS("Cursos"),
    SECCIONES("Secciones");

    private final String value;
    private static final Map<String, AmbitoAnuncioEnum> lookup = new HashMap<>();

    static {
        for (AmbitoAnuncioEnum d : AmbitoAnuncioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmbitoAnuncioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
