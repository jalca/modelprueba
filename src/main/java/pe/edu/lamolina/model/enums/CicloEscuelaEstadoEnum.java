package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CicloEscuelaEstadoEnum {

    ACT("Activo"), CER("Cerrado"), CRE("Creado"), CFG("Configurando");

    private final String value;
    private static final Map<String, CicloEscuelaEstadoEnum> lookup = new HashMap<>();

    static {
        for (CicloEscuelaEstadoEnum d : CicloEscuelaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CicloEscuelaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CicloEscuelaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CicloEscuelaEstadoEnum d : CicloEscuelaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (CicloEscuelaEstadoEnum e : CicloEscuelaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
