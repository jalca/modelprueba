package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CargoTrabajadorEnum {

    ADM("Administrativo"), DOC("Docente");

    private final String value;
    private static final Map<String, CargoTrabajadorEnum> lookup = new HashMap<>();

    static {
        for (CargoTrabajadorEnum d : CargoTrabajadorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CargoTrabajadorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CargoTrabajadorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CargoTrabajadorEnum d : CargoTrabajadorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
