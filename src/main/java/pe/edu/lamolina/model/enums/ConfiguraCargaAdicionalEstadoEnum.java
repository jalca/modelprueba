package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConfiguraCargaAdicionalEstadoEnum {

    CRE("Creado"),
    CARGA("Con carga académica"),
    MONTO("Con monto"),
    CERR("Cerrado");

    private final String value;
    private static final Map<String, ConfiguraCargaAdicionalEstadoEnum> lookup = new HashMap<>();

    static {
        for (ConfiguraCargaAdicionalEstadoEnum d : ConfiguraCargaAdicionalEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ConfiguraCargaAdicionalEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ConfiguraCargaAdicionalEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ConfiguraCargaAdicionalEstadoEnum d : ConfiguraCargaAdicionalEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ConfiguraCargaAdicionalEstadoEnum e : ConfiguraCargaAdicionalEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
