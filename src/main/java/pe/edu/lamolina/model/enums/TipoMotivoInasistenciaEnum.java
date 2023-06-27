package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMotivoInasistenciaEnum {

    PRE_AVI("Pre aviso"), POST_JUST("Justifiación posterior");

    private final String value;
    private static final Map<String, TipoMotivoInasistenciaEnum> lookup = new HashMap<>();

    static {
        for (TipoMotivoInasistenciaEnum d : TipoMotivoInasistenciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMotivoInasistenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMotivoInasistenciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMotivoInasistenciaEnum d : TipoMotivoInasistenciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
