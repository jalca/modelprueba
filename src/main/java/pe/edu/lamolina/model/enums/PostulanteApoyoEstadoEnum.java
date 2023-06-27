package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PostulanteApoyoEstadoEnum {

    POST("Postulante"),
    RET("Retirado"),
    ELE("Elegido"),
    NEL("No Elegido"),
    NAS("No Asistió");

    private final String value;
    private static final Map<String, PostulanteApoyoEstadoEnum> lookup = new HashMap<>();

    static {
        for (PostulanteApoyoEstadoEnum d : PostulanteApoyoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PostulanteApoyoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PostulanteApoyoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PostulanteApoyoEstadoEnum d : PostulanteApoyoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (PostulanteApoyoEstadoEnum e : PostulanteApoyoEstadoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
