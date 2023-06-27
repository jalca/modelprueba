package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MotivoOmisoEnum {

    NVOTO("Por no votar"),
    NMBR("Inasistencia miembro de mesa");

    private final String value;
    private static final Map<String, MotivoOmisoEnum> lookup = new HashMap<>();

    static {
        for (MotivoOmisoEnum d : MotivoOmisoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MotivoOmisoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MotivoOmisoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MotivoOmisoEnum d : MotivoOmisoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
