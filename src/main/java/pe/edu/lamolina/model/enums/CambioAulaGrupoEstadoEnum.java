package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CambioAulaGrupoEstadoEnum {

    PENDIENTE("Pendiente"), ACEPTADO("Aceptado"), RECHAZADO("Rechazado"), ANULADA("Anulada");

    private final String value;
    private static final Map<String, CambioAulaGrupoEstadoEnum> lookup = new HashMap<>();

    static {
        for (CambioAulaGrupoEstadoEnum d : CambioAulaGrupoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CambioAulaGrupoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CambioAulaGrupoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CambioAulaGrupoEstadoEnum d : CambioAulaGrupoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
