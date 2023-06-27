package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TemaAcronimoEnum {

    RV("Razonamiento Verbal"),
    RM("Razonamiento Matemático"),
    MAT("Matematica"),
    FIS("Física"),
    QUI("Química"),
    BIO("Biología");

    private final String value;
    private static final Map<String, TemaAcronimoEnum> lookup = new HashMap<>();

    static {
        for (TemaAcronimoEnum d : TemaAcronimoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TemaAcronimoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TemaAcronimoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TemaAcronimoEnum d : TemaAcronimoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TemaAcronimoEnum e : TemaAcronimoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
