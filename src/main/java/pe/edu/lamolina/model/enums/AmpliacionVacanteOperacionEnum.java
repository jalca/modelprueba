package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmpliacionVacanteOperacionEnum {

    MAT("MAT"),
    SOL("SOL"),
    CONF("CONF"),
    RHZR("RHZR");

    private final String value;
    private static final Map<String, AmpliacionVacanteOperacionEnum> lookup = new HashMap<>();

    static {
        for (AmpliacionVacanteOperacionEnum d : AmpliacionVacanteOperacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AmpliacionVacanteOperacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmpliacionVacanteOperacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AmpliacionVacanteOperacionEnum d : AmpliacionVacanteOperacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
