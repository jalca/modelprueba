package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoOpcionPsicologicaEnum {

    SI_NO("Ingrese Si o No"), RIESGO("Ingrese el Nivel de Riesgo"), NOR_BAJ("Ingrese si es Normal o Bajo"), FREC("Ingrese la Frecuencia"), DROGA("Ingrese una Droga"),
     ADECUA("Ingrsese el nivel de Adecuación"), DINAMICA("Dinamica Familiar");

    private final String value;
    private static final Map<String, TipoOpcionPsicologicaEnum> lookup = new HashMap<>();

    static {
        for (TipoOpcionPsicologicaEnum d : TipoOpcionPsicologicaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOpcionPsicologicaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoOpcionPsicologicaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOpcionPsicologicaEnum d : TipoOpcionPsicologicaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
