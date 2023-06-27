package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DistractorEnum {

    FB("Facebook"), INS("Instagram"), WAT("WhatsApp"), YOU("Youtube"), TWI("Twitter");

    private final String value;
    private static final Map<String, DistractorEnum> lookup = new HashMap<>();

    static {
        for (DistractorEnum d : DistractorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DistractorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DistractorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DistractorEnum d : DistractorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
