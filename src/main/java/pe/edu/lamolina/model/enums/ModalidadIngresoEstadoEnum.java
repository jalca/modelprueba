package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ModalidadIngresoEstadoEnum {

    CRE("Creado"), ACT("Activo"), INA("Inactivo");

    private final String value;
    private static final Map<String, ModalidadIngresoEstadoEnum> lookup = new HashMap<>();

    static {
        for (ModalidadIngresoEstadoEnum d : ModalidadIngresoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ModalidadIngresoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModalidadIngresoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ModalidadIngresoEstadoEnum d : ModalidadIngresoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ModalidadIngresoEstadoEnum e : ModalidadIngresoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
