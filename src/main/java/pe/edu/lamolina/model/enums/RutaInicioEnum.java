package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RutaInicioEnum {

    FICHA_ING("bienestar/fichaalumno/datosalumno2/SOCIOECONO"),
    TEST_PSIC("bienestar/testsicologico");

    private final String value;
    private static final Map<String, RutaInicioEnum> lookup = new HashMap<>();

    static {
        for (RutaInicioEnum d : RutaInicioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RutaInicioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RutaInicioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RutaInicioEnum d : RutaInicioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
