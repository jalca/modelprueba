package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPerfilCompaniaEnum {

    CARGO("Cargo"), FUNCION("Función");

    private final String value;
    private static final Map<String, TipoPerfilCompaniaEnum> lookup = new HashMap<>();

    static {
        for (TipoPerfilCompaniaEnum d : TipoPerfilCompaniaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPerfilCompaniaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPerfilCompaniaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPerfilCompaniaEnum d : TipoPerfilCompaniaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
