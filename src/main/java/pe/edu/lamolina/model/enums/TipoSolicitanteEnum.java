package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSolicitanteEnum {

    EMP("Empresa"), 
    PER("Persona"),
    COL("Colaborador"),
    ALU("Alumno"), 
    DOC("Docente"), 
    OFI("Oficina");

    private final String value;
    private static final Map<String, TipoSolicitanteEnum> lookup = new HashMap<>();

    static {
        for (TipoSolicitanteEnum d : TipoSolicitanteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoSolicitanteEnum(String value) {
        this.value = value;
    }

    public String getId() {
        return this.name();
    }

    public String getValue() {
        return value;
    }

    public static TipoSolicitanteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSolicitanteEnum d : TipoSolicitanteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
