package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NivelExamenClinicoEnum {

    NIVEL1("Neurológico", 1L),
    NIVEL2("Locomotor", 2L),
    NIVEL3("Piel", 3L),
    NIVEL4("Cardiológico", 4L),
    NIVEL5("Respiratorio", 5L),
    NIVEL6("Abdomen", 6L),
    NIVEL7("Uro Genital", 7L),
    NIVEL8("Oído", 8L),
    NIVEL9("Nariz", 9L),
    NIVEL10("Garganta", 10L),
    NIVEL11("Observ.Foniátricas", 11L),
    NIVEL12("Oftalmológico", 12L);

    private final String nombre;
    private final Long valor;

    private static final Map<String, NivelExamenClinicoEnum> lookup = new HashMap<>();

    static {
        for (NivelExamenClinicoEnum d : NivelExamenClinicoEnum.values()) {
            lookup.put(d.name(), d);
        }
    }

    private NivelExamenClinicoEnum(String nombre, Long valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getValor() {
        return valor;
    }

    public static NivelExamenClinicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (NivelExamenClinicoEnum d : NivelExamenClinicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getNombre();
            }
        }
        return nombre;
    }
}
