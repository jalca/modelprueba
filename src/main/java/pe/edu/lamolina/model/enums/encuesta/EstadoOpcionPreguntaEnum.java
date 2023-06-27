package pe.edu.lamolina.model.enums.encuesta;

import java.util.HashMap;
import java.util.Map;

public enum EstadoOpcionPreguntaEnum {

    ACT("Activo"),
    INA("Inactivo");

    private final String value;
    private static final Map<String, EstadoOpcionPreguntaEnum> lookup = new HashMap<>();

    static {
        for (EstadoOpcionPreguntaEnum d : EstadoOpcionPreguntaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoOpcionPreguntaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoOpcionPreguntaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoOpcionPreguntaEnum d : EstadoOpcionPreguntaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (EstadoOpcionPreguntaEnum e : EstadoOpcionPreguntaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
