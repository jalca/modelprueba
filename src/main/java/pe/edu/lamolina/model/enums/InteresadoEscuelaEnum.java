package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum InteresadoEscuelaEnum {

    REG("Registrado"), INT("Interesado"), ACT("Activo/validado");

    private final String value;
    private static final Map<String, InteresadoEscuelaEnum> lookup = new HashMap<>();

    static {
        for (InteresadoEscuelaEnum d : InteresadoEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private InteresadoEscuelaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InteresadoEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (InteresadoEscuelaEnum d : InteresadoEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
