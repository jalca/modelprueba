package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoTipoProductoEnum {

    BIENES("Bienes"),
    MEDICA("Medicamentos"),
    INSMED("Insumos Médicos"),
    IMPLEM("Implementos Taller de Verano"),
    SERVTV("Servicios de Taller de Verano"),
    PRESEPG("Presupuesto Posgrado"),
    COMEPG("Compras Posgrado")
    ;

    private final String value;
    private static final Map<String, CodigoTipoProductoEnum> lookup = new HashMap<>();

    static {
        for (CodigoTipoProductoEnum d : CodigoTipoProductoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoTipoProductoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoTipoProductoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoTipoProductoEnum d : CodigoTipoProductoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
