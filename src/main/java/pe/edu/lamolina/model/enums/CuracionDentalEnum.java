package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CuracionDentalEnum {

    RESINA("Curación Resina"),
    AMAL("Curación Amalgama"),
    PROFIL("Profilaxis"),
    EXTRAC("Extracción Simple");

    private final String value;
    private static final Map<String, CuracionDentalEnum> lookup = new HashMap<>();

    static {
        for (CuracionDentalEnum d : CuracionDentalEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CuracionDentalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CuracionDentalEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CuracionDentalEnum d : CuracionDentalEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
