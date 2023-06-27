package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoExamenVirtualEnum {

    EVA("Examen Virtual de Admisión"),
    ENC("Encuesta de Postulante"),
    ENC_PSC("Test Psicológico"),
    ENC_OBU("Encuesta DBU"),
    ENC_CUR("Encuesta Curso"),
    ENC_DOC("Encuesta Docente");

    private final String value;
    private static final Map<String, TipoExamenVirtualEnum> lookup = new HashMap<>();

    static {
        for (TipoExamenVirtualEnum d : TipoExamenVirtualEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoExamenVirtualEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoExamenVirtualEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoExamenVirtualEnum d : TipoExamenVirtualEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoExamenVirtualEnum e : TipoExamenVirtualEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
