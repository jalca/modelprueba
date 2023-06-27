package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AporteAlumnoCicloMotivoEnum {

    DOC_UNALM("Es docente"), TRAB_UNALM("Es trabajador"), OTRO("Otros");

    private final String value;
    private static final Map<String, AporteAlumnoCicloMotivoEnum> lookup = new HashMap<>();

    static {
        for (AporteAlumnoCicloMotivoEnum d : AporteAlumnoCicloMotivoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AporteAlumnoCicloMotivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AporteAlumnoCicloMotivoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (AporteAlumnoCicloMotivoEnum d : AporteAlumnoCicloMotivoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
