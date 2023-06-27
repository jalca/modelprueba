package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TallerTitulosEnum {

    TACA("Taller de Carreras"),
    CARR("Charla de Carreras"),
    DIAG("Un día en La Agraria"),
    CGC("Charla General de Carreras"),
    CMOD("Charla de modalidades");

    private final String value;
    private static final Map<String, TallerTitulosEnum> lookup = new HashMap<>();

    static {
        for (TallerTitulosEnum d : TallerTitulosEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TallerTitulosEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TallerTitulosEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TallerTitulosEnum d : TallerTitulosEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TallerTitulosEnum e : TallerTitulosEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
