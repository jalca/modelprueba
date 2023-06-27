package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CargoContactoEmpresaEnum {

    ADM("Administrativo");

    private final String value;
    private static final Map<String, CargoContactoEmpresaEnum> lookup = new HashMap<>();

    static {
        for (CargoContactoEmpresaEnum d : CargoContactoEmpresaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CargoContactoEmpresaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CargoContactoEmpresaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CargoContactoEmpresaEnum d : CargoContactoEmpresaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
