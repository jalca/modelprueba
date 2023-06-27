package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoArchivoEnum {

    HI("Historico"),
    DI("Diario");

    private final String value;
    private static final Map<String, TipoArchivoEnum> lookup = new HashMap<>();

    static {
        for (TipoArchivoEnum d : TipoArchivoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoArchivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoArchivoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoArchivoEnum d : TipoArchivoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoArchivoEnum e : TipoArchivoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
