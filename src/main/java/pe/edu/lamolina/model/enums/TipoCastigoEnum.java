package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCastigoEnum {

    DOC("No entregó documentos"), SUPL("Postulante suplantado"), SUPDR("Suplantador del examen"), OTRO("Otros");

    private final String value;
    private static final Map<String, TipoCastigoEnum> lookup = new HashMap<>();

    static {
        for (TipoCastigoEnum d : TipoCastigoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCastigoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCastigoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCastigoEnum d : TipoCastigoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
