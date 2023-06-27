package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoHorarioAulaEnum {

    DICT("Dictado", "Dictado de Clases"),
    RESERV("Reserva", "Reserva de Aula"),
    EXAM("Examen", "Rol de Exámenes");

    private final String value;
    private final String descripcion;
    private static final Map<String, TipoHorarioAulaEnum> lookup = new HashMap<>();

    static {
        for (TipoHorarioAulaEnum d : TipoHorarioAulaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoHorarioAulaEnum(String value, String descripcion) {
        this.value = value;
        this.descripcion = descripcion;
    }

    public String getValue() {
        return value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoHorarioAulaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoHorarioAulaEnum d : TipoHorarioAulaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoHorarioAulaEnum e : TipoHorarioAulaEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
