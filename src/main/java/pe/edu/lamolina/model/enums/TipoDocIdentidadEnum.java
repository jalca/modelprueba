package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDocIdentidadEnum {

    CE("Carné de Extrajería"),
    CEX("Carné de Extrajería"),
    DNI("Documento Nacional de Identidad"),
    PAS("Pasaporte"),
    RUC("Registro Único de Contribuyentes");

    private final String value;
    private static final Map<String, TipoDocIdentidadEnum> lookup = new HashMap<>();

    static {
        for (TipoDocIdentidadEnum d : TipoDocIdentidadEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoDocIdentidadEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDocIdentidadEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDocIdentidadEnum d : TipoDocIdentidadEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
