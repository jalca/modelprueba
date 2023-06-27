package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExamenClinicoEnum {

    EXA_OTRA("Otra Patología", 29L),
    EXA_AGUDEZA("Agudeza Visual", 30L),
    EXA_USA_LENTES("Usa Lentes", 31L),
    EXA_MENARQUIA("Menarquia", 26L),
    EXA_CATAMENIAL("Regimen Catamenial", 27L),
    EXA_GINECOLOGO_OTRO("Otros Ginecológico", 28L);

    private final String nombre;
    private final Long valor;

    private static final Map<String, ExamenClinicoEnum> lookup = new HashMap<>();

    static {
        for (ExamenClinicoEnum d : ExamenClinicoEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private ExamenClinicoEnum(String nombre, Long valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getValor() {
        return valor;
    }

    public static ExamenClinicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ExamenClinicoEnum d : ExamenClinicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getNombre();
            }
        }
        return nombre;
    }
}
