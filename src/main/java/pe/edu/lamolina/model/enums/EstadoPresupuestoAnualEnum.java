package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPresupuestoAnualEnum {

    CRE("Creado"), ENV("Enviado"), DEV("Devuelto"), ACEP("Aceptado");
    // OBSV("Observado")

    private final String value;
    private static final Map<String, EstadoPresupuestoAnualEnum> lookup = new HashMap<>();

    static {
        for (EstadoPresupuestoAnualEnum d : EstadoPresupuestoAnualEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoPresupuestoAnualEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPresupuestoAnualEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPresupuestoAnualEnum d : EstadoPresupuestoAnualEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
