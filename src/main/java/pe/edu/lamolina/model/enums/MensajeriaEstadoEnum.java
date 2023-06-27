package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MensajeriaEstadoEnum {

    ENV("Enviando"),
    FIN("Finalizado"),
    CAN("Cancelado"),
    SOP("Llame al Soporte");

    private final String value;
    private static final Map<String, MensajeriaEstadoEnum> lookup = new HashMap<>();

    static {
        for (MensajeriaEstadoEnum d : MensajeriaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MensajeriaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MensajeriaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MensajeriaEstadoEnum d : MensajeriaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (MensajeriaEstadoEnum e : MensajeriaEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
