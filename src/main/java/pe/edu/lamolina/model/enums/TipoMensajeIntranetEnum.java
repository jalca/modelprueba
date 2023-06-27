package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMensajeIntranetEnum {

    FICHA_ISEC("Ficha Socio-económica Ingresantes"),
    FICHA_RSEC("Ficha Socio-económica Regulares"),
    BIENVE("Pantalla de Bienvenida"),
    CITAS("Citas Médicas"),
    MSG_GRAL("Mensaje Genérico"),
    ENC_ESTD("Encuesta");

    private final String value;
    private static final Map<String, TipoMensajeIntranetEnum> lookup = new HashMap<>();

    static {
        for (TipoMensajeIntranetEnum d : TipoMensajeIntranetEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMensajeIntranetEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoMensajeIntranetEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMensajeIntranetEnum d : TipoMensajeIntranetEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
