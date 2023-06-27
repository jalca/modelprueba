package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoObservacionProyectoTesisEnum {

    CRE("Sin enviar"), CER("Cerrada"), INC("Inconcluso"), REV("Revisar"), INA("Inactivo"), LEV("Levantada");

    private final String value;
    private static final Map<String, EstadoObservacionProyectoTesisEnum> lookup = new HashMap<>();

    static {
        for (EstadoObservacionProyectoTesisEnum d : EstadoObservacionProyectoTesisEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoObservacionProyectoTesisEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoObservacionProyectoTesisEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (EstadoObservacionProyectoTesisEnum d : EstadoObservacionProyectoTesisEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
