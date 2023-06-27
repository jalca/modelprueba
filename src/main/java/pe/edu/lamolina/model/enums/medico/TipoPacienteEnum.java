package pe.edu.lamolina.model.enums.medico;

import java.util.HashMap;
import java.util.Map;

public enum TipoPacienteEnum {

    ALU("Alumno"), DOC("Docente"), COL("Colaborador"), VIS("Visitante");

    private final String value;
    private static final Map<String, TipoPacienteEnum> lookup = new HashMap<>();

    static {
        for (TipoPacienteEnum d : TipoPacienteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoPacienteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoPacienteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPacienteEnum d : TipoPacienteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
