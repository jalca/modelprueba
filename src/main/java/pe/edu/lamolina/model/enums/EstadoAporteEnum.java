package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoAporteEnum {

    ACT("Activo"), INA("Inactivo"), ANU("Anulado"), DESCARTA("Descartado"), FRA("Fraccionado"),
    EXO("Exonerado"), CAN("Cancelado"), DEBE("Deuda"), PAGO("Pagado"),
    RCAT("Recategorizado"), REFI("Refinanciado"), RECAL("Recalculado");

    private final String value;
    private static final Map<String, EstadoAporteEnum> lookup = new HashMap<>();

    static {
        for (EstadoAporteEnum d : EstadoAporteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoAporteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoAporteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoAporteEnum d : EstadoAporteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
