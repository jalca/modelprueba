package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PostulanteEscuelaEnum {

    INT("Interesado", ""),
    PRE("Preinscrito", ""),
    INS("Inscrito", ""),
    POST("Postulante", ""),
    ADM("Admitido", "Regular"),
    ADC("Admitido Condicional", "Condicional"),
    ADE("Admitido Especial", "Especial"),
    ALU("Alumno con Resolucion", "Regular"),
    ALC("Alumno Condicional con Resolucion", "Condicional"),
    ALE("Alumno Especial con Resolucion", "Especial"),
    RCH("Rechazado", "");

    private final String value;
    private final String condicion;
    private static final Map<String, PostulanteEscuelaEnum> lookup = new HashMap<>();

    static {
        for (PostulanteEscuelaEnum d : PostulanteEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PostulanteEscuelaEnum(String value, String condicion) {
        this.value = value;
        this.condicion = condicion;
    }

    public String getValue() {
        return value;
    }

    public String getCondicion() {
        return condicion;
    }

    public static PostulanteEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PostulanteEscuelaEnum d : PostulanteEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
