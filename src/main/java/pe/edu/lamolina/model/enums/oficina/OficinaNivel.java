package pe.edu.lamolina.model.enums.oficina;

import java.util.HashMap;
import java.util.Map;

public enum OficinaNivel {

    OFI("Oficina"), 
    UNA("Unidad");

    private final String value;
    private static final Map<String, OficinaNivel> lookup = new HashMap<>();

    static {
        for (OficinaNivel d : OficinaNivel.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OficinaNivel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OficinaNivel get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OficinaNivel d : OficinaNivel.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
