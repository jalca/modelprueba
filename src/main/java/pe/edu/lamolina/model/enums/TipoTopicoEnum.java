package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoTopicoEnum {

    IN("Inyectables"), CU("Curación"), FV("Funciones Vitales"), NE("Nebulización"), OA("Otras Atenciones");

    private final String value;
    private static final Map<String, TipoTopicoEnum> lookup = new HashMap<>();

    static {
        for (TipoTopicoEnum d : TipoTopicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTopicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoTopicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoTopicoEnum d : TipoTopicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
