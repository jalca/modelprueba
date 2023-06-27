package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ModoDictadoSeccionEnum {

    PRES("Presencial"), 
    SEMI("Semi Presencial"), 
    VIRTUAL("Virtual"), 
    ;

    private final String value;
    private static final Map<String, ModoDictadoSeccionEnum> lookup = new HashMap<>();

    static {
        for (ModoDictadoSeccionEnum d : ModoDictadoSeccionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ModoDictadoSeccionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModoDictadoSeccionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ModoDictadoSeccionEnum d : ModoDictadoSeccionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
