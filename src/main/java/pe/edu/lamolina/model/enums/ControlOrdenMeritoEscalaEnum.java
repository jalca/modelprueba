package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ControlOrdenMeritoEscalaEnum {

    CICLO("Ciclo"),
    FAC("Facultad"),
    ESPE("Programa");

    private final String value;
    private static final Map<String, ControlOrdenMeritoEscalaEnum> lookup = new HashMap<>();

    static {
        for (ControlOrdenMeritoEscalaEnum d : ControlOrdenMeritoEscalaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ControlOrdenMeritoEscalaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlOrdenMeritoEscalaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ControlOrdenMeritoEscalaEnum d : ControlOrdenMeritoEscalaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
