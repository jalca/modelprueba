package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TurnoAtencionEnum {

    MNA("Mañana"),
    TAR("Tarde");

    private final String value;
    private static final Map<String, TurnoAtencionEnum> lookup = new HashMap<>();

    static {
        for (TurnoAtencionEnum d : TurnoAtencionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TurnoAtencionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TurnoAtencionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TurnoAtencionEnum d : TurnoAtencionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TurnoAtencionEnum e : TurnoAtencionEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
