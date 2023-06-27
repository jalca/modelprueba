package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoDeudaPostulanteEscuelaEnum {

    DEU("Deuda"), PAG("Pagado"), ANU("Anulado");

    private final String value;
    private static final Map<String, EstadoDeudaPostulanteEscuelaEnum> lookup = new HashMap<>();

    static {
        for (EstadoDeudaPostulanteEscuelaEnum d : EstadoDeudaPostulanteEscuelaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoDeudaPostulanteEscuelaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoDeudaPostulanteEscuelaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoDeudaPostulanteEscuelaEnum d : EstadoDeudaPostulanteEscuelaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
