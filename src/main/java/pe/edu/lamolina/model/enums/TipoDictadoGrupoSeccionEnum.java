package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDictadoGrupoSeccionEnum {

    SEM("Semestral"), MOD("Modular");

    private final String value;
    private static final Map<String, TipoDictadoGrupoSeccionEnum> lookup = new HashMap<>();

    static {
        for (TipoDictadoGrupoSeccionEnum d : TipoDictadoGrupoSeccionEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private TipoDictadoGrupoSeccionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoDictadoGrupoSeccionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoDictadoGrupoSeccionEnum d : TipoDictadoGrupoSeccionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
