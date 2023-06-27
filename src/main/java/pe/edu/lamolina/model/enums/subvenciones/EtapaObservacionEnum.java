package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum EtapaObservacionEnum {

    ETAPA1("Observación Administración"),
    ETAPA2("Observación Jefatura OBU"),
    ETAPA3("Observación Docente"),
    ETAPA4("Observación Administración"),
    ETAPA5("Observación Administración");

    private final String value;
    private static final Map<String, EtapaObservacionEnum> lookup = new HashMap<>();

    static {
        for (EtapaObservacionEnum d : EtapaObservacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EtapaObservacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EtapaObservacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EtapaObservacionEnum d : EtapaObservacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
