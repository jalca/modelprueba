package pe.edu.lamolina.model.enums.encuesta;

import java.util.HashMap;
import java.util.Map;

public enum TipoPreguntaEncuestaEnum {

    SIMPLE("Pregunta Simple"),
    MULTIPLE("Pregunta Multiple"),
    RPTA_MULTIPLE("Respuesta Multiple"),
    SINO("Sí/No"),
    VEFA("Verdadero/Falso"),
    LIKERT("Escala Likert"),
    ABIERTA("Pregunta Abierta");

    private final String value;
    private static final Map<String, TipoPreguntaEncuestaEnum> lookup = new HashMap<>();

    static {
        for (TipoPreguntaEncuestaEnum d : TipoPreguntaEncuestaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPreguntaEncuestaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPreguntaEncuestaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPreguntaEncuestaEnum d : TipoPreguntaEncuestaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
