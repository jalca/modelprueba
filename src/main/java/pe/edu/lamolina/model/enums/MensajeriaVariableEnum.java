package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MensajeriaVariableEnum {

    __NOMBRE__("Nombre de la Persona"),
    __AULA__("Aula del Postulante"),
    __MODULO__("Módulo del Postulante"),
    __ESTIMADO__("Estimado(a) basado en el Sexo de la Persona"),
    __CARRERA__("Carrera"),
    __DOCUMENTO__("Documento de Identidad de la Persona");

    private final String value;
    private static final Map<String, MensajeriaVariableEnum> lookup = new HashMap<>();

    static {
        for (MensajeriaVariableEnum d : MensajeriaVariableEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MensajeriaVariableEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MensajeriaVariableEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MensajeriaVariableEnum d : MensajeriaVariableEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
