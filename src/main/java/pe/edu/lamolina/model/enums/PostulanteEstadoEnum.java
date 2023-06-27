package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PostulanteEstadoEnum {
    PRE("Preinscrito"), PDOC("Preinscrito docs"), INS("Inscrito"), NINS("No inscrito"),
    NEXM("No rindió examen"), ING("Ingresante"), NING("No ingreso"),
    IDOC("Ingresante docs"), ANU("Anulado"), CRE("Creado"), PROS("Prospecto"), PAGO("Inscrito Pagó"),
    AING("Ingr. Anulado"), SUPL("Suplantación"),
    REN("Ingr. Renunciante"), // Ingresante que renuncia antes del examen
    REND("Ingr. Renunciante") // Ingresante que renuncia despues del examen
    ;

    private final String value;
    private static final Map<String, PostulanteEstadoEnum> lookup = new HashMap<>();

    static {
        for (PostulanteEstadoEnum d : PostulanteEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private PostulanteEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PostulanteEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (PostulanteEstadoEnum d : PostulanteEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

}
