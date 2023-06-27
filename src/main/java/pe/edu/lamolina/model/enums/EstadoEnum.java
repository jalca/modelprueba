package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoEnum {

    ACT("Activo", "badge-success"),
    ACP("Aceptado", "badge-success"),
    CRE("Creado", "badge-secondary"),
    INA("Inactivo", "badge-success"),
    ANU("Anulado", "badge-danger"),
    PEN("Pendiente", "badge-primary"),
    FIN("Finalizado", "badge-success"),
    EJE("Ejecutado", "badge-success");

    private final String value;
    private final String badge;
    private static final Map<String, EstadoEnum> lookup = new HashMap<>();

    static {
        for (EstadoEnum d : EstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public static EstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoEnum d : EstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
