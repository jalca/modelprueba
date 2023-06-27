package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DeudaEstadoEnum {

    PEN("Pendiente"),
    REF("Refinanciado"),
    PAG("Pagado"),
    INA("Inactiva"),
    ANU("Anulado"),
    ANT("Anterior"),
    EXT("Extornado"),
    ACT("Activo"),
    DEU("Deuda"),
    DEV("Devuelto"),
    PAR("Parcial"),
    FRA("Fraccionado");

    private final String value;
    private static final Map<String, DeudaEstadoEnum> lookup = new HashMap<>();

    private DeudaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DeudaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DeudaEstadoEnum d : DeudaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
