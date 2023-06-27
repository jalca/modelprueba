package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnteAcademicoEstadoEnum {

    ACT("Activo", "badge-success"),
    CRE("Creado", "badge-secondary"),
    INA("Inactivo", "badge-danger"),
    RES("Resolución", "badge-primary");

    private final String value;
    private final String badge;
    private static final Map<String, EnteAcademicoEstadoEnum> lookup = new HashMap<>();

    static {
        for (EnteAcademicoEstadoEnum d : EnteAcademicoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public static EnteAcademicoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EnteAcademicoEstadoEnum d : EnteAcademicoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
