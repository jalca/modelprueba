package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPostulanteDocumentoEscuelaEnum {

    ANU("Anulado"),
    CRE("Creado"),
    PEND("Pendiente"),
    ENV("Enviado"),
    ACEP("Aceptado"),
    OBSV("Observado");

    private final String value;
    private static final Map<String, EstadoPostulanteDocumentoEscuelaEnum> lookup = new HashMap<>();

    static {
        for (EstadoPostulanteDocumentoEscuelaEnum d : EstadoPostulanteDocumentoEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoPostulanteDocumentoEscuelaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPostulanteDocumentoEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoPostulanteDocumentoEscuelaEnum d : EstadoPostulanteDocumentoEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
