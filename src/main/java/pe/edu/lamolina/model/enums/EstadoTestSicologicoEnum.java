package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoTestSicologicoEnum {

    ACT("Activo"), CER("Cerrado");

    private final String value;
    private static final Map<String, EstadoTestSicologicoEnum> lookup = new HashMap<>();

    static {
        for (EstadoTestSicologicoEnum d : EstadoTestSicologicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoTestSicologicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoTestSicologicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoTestSicologicoEnum d : EstadoTestSicologicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
