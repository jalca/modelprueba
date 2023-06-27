package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MenuTipoEnum {

    TITULO("Título"),
    MENU("Menú"),
    MENU_PADRE("Menú-Padre"),
    SUB_MENU("Sub-Menú"),
    OPCION("Opción"),
    BOTON("Botón"),
    BOTON_MENU_SUP("Botón Menú Superior"),
    BOTON_MENU_INF("Botón Menú Inferior")
    ;
    

    private final String value;
    private static final Map<String, MenuTipoEnum> lookup = new HashMap<>();

    static {
        for (MenuTipoEnum d : MenuTipoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MenuTipoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MenuTipoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MenuTipoEnum d : MenuTipoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
