package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum GrupoIngresantesEnum {

    CEPRE("Ingresantes Cepre"), 
    OTROS("Otros Ingresantes"), 
    EXTEM("Ingresantes Extemporaneos");

    private final String value;
    private static final Map<String, GrupoIngresantesEnum> lookup = new HashMap<>();

    static {
        for (GrupoIngresantesEnum d : GrupoIngresantesEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private GrupoIngresantesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GrupoIngresantesEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (GrupoIngresantesEnum d : GrupoIngresantesEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
