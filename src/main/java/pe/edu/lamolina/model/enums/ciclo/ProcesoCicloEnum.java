package pe.edu.lamolina.model.enums.ciclo;

import java.util.HashMap;
import java.util.Map;

public enum ProcesoCicloEnum {

    // Tipos de procesos
    TIPO_OBU("Tipo DBU"),
    TIPO_ADMISION("Tipo Admisión"),
    TIPO_SUBVENCION("Tipo Subvención"),
    // Visibilizar/Ocultar en login
    VISIBLE_LOGIN("Visibilizar en Login"),
    OCULTAR_LOGIN("Ocultar en Login"),
    // Activar tipos ciclos
    ACTIVAR_CICLO_OBU("Activar ciclo DBU"),
    ACTIVAR_CICLO_ADMISION("Activar ciclo ingresantes"),
    ACTIVAR_CICLO_SUBVENCION("Activar ciclo subvenciones"),
    // Desactivar tipos ciclos
    DESACTIVAR_CICLO_OBU("Desactivar ciclo OBU"),
    DESACTIVAR_CICLO_ADMISION("Desactivar ciclo ingresantes"),
    DESACTIVAR_CICLO_SUBVENCION("Desactivar ciclo subvenciones");

    private final String value;
    private static final Map<String, ProcesoCicloEnum> lookup = new HashMap<>();

    static {
        for (ProcesoCicloEnum d : ProcesoCicloEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ProcesoCicloEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProcesoCicloEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ProcesoCicloEnum d : ProcesoCicloEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
