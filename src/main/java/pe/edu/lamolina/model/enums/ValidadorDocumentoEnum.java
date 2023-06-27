package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ValidadorDocumentoEnum {

    USER("Usuario", "Usuario"),
    MINEDU("Ministerio de Educación del Perú", "MINEDU"),
    SUNEDU("Superintendencia Nacional de Educación Superior Universitaria", "SUNEDU"),
    CEPRE("Centro Pre Universitario", "CEPRE-UNALM");

    private final String value;
    private final String nombreCorto;
    private static final Map<String, ValidadorDocumentoEnum> lookup = new HashMap<>();

    static {
        for (ValidadorDocumentoEnum d : ValidadorDocumentoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ValidadorDocumentoEnum(String value, String nombreCorto) {
        this.value = value;
        this.nombreCorto = nombreCorto;
    }

    public String getValue() {
        return value;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public static ValidadorDocumentoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ValidadorDocumentoEnum d : ValidadorDocumentoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
