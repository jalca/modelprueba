package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoComiteConsejeroEnum {

    CRE("Creado"), PEND("Pendiente"), REG("Registrando"), ACT("Activo"), ANU("Anulado"), INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoComiteConsejeroEnum> lookup = new HashMap<>();

    static {
        for (EstadoComiteConsejeroEnum d : EstadoComiteConsejeroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoComiteConsejeroEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoComiteConsejeroEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoComiteConsejeroEnum d : EstadoComiteConsejeroEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
