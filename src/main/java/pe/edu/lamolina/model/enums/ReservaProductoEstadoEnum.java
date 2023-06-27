package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReservaProductoEstadoEnum {

    CRE("Creada"), ANU("Anulada"), PAR("Parcial"), COM("Completo");
    
    private final String value;
    private static final Map<String, ReservaProductoEstadoEnum> lookup = new HashMap<>();

    static {
        for (ReservaProductoEstadoEnum d : ReservaProductoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ReservaProductoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReservaProductoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ReservaProductoEstadoEnum d : ReservaProductoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ReservaProductoEstadoEnum e : ReservaProductoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }

}
