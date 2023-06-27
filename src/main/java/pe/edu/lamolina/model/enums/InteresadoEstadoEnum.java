package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum InteresadoEstadoEnum {

    CRE("Creado"),
    REG("Registrado"),
    NPOST("No postula"),
    PROS("Prospecto"),
    POST("Postula"),
    AING("Ingr. Anulado"),
    REN("Ingr. Renunciante");

    private final String value;
    private static final Map<String, InteresadoEstadoEnum> lookup = new HashMap<>();

    static {
        for (InteresadoEstadoEnum d : InteresadoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private InteresadoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InteresadoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (InteresadoEstadoEnum d : InteresadoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (InteresadoEstadoEnum e : InteresadoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
