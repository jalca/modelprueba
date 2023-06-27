package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAcreenciaTramiteEnum {

    DEU("Deuda"),
    PAGO("Pagago"),
    ANU("Anulado");

    private final String value;
    private static final Map<String, EstadoAcreenciaTramiteEnum> lookup = new HashMap<>();

    static {
        for (EstadoAcreenciaTramiteEnum d : EstadoAcreenciaTramiteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAcreenciaTramiteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAcreenciaTramiteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAcreenciaTramiteEnum d : EstadoAcreenciaTramiteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoAcreenciaTramiteEnum e : EstadoAcreenciaTramiteEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
