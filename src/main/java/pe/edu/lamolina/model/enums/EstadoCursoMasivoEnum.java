package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCursoMasivoEnum {

    ACT("Activo"), EXC("Excluido");

    private final String value;
    private static final Map<String, EstadoCursoMasivoEnum> lookup = new HashMap<>();

    static {
        for (EstadoCursoMasivoEnum d : EstadoCursoMasivoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoCursoMasivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoCursoMasivoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoCursoMasivoEnum d : EstadoCursoMasivoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
