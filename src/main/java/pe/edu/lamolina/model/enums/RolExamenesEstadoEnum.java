package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RolExamenesEstadoEnum {

    CRE("Creado"), CON("Configurando"), PUB("Publicado"), MOD("Modificando"), CER("Cerrado");

    private final String value;
    private static final Map<String, RolExamenesEstadoEnum> lookup = new HashMap<>();

    static {
        for (RolExamenesEstadoEnum d : RolExamenesEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RolExamenesEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RolExamenesEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RolExamenesEstadoEnum d : RolExamenesEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
