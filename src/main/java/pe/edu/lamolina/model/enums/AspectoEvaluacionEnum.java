package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AspectoEvaluacionEnum {

    EXAM("Entrevista Virtual o Presencial / Examen de Habilidades"),

    DOCUM("Curriculum Vitae Documentado"),
    NODOCUM("Curriculum Vitae No Documentado"),

    EXPI("Experiencia en Investigación/Propuesta de Investigación"),
    DOCE("Experiencia en Docencia"),
    
    PROY("Proyecto de Tesis"),
    ENTR("Entrevista Virtual/Personal")
    ;
    

    private final String value;

    private static final Map<String, AspectoEvaluacionEnum> lookup = new HashMap<>();

    static {
        for (AspectoEvaluacionEnum d : AspectoEvaluacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AspectoEvaluacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AspectoEvaluacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {
        for (AspectoEvaluacionEnum d : AspectoEvaluacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
