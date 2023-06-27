package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCertificacionEnum {

    DOC("Acta de examen existente"),
    CERT("Certificado Centro de Idiomas"),
    EXA("Examen");

    private final String value;
    private static final Map<String, TipoCertificacionEnum> lookup = new HashMap<>();

    static {
        for (TipoCertificacionEnum d : TipoCertificacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCertificacionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCertificacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCertificacionEnum d : TipoCertificacionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

}
