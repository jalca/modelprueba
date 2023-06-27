package pe.edu.lamolina.model.enums.medico;

import java.util.HashMap;
import java.util.Map;

public enum TipoOperadorCentroMedicoEnum {

    ALUMNO("Alumno"),
    MEDICO("Médico"),
    CONFIGURADOR("Configurador");

    private final String value;
    private static final Map<String, TipoOperadorCentroMedicoEnum> lookup = new HashMap<>();

    static {
        for (TipoOperadorCentroMedicoEnum d : TipoOperadorCentroMedicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOperadorCentroMedicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoOperadorCentroMedicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOperadorCentroMedicoEnum d : TipoOperadorCentroMedicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
