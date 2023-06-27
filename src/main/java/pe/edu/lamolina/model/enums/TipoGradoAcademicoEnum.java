package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoGradoAcademicoEnum {

    BACH("Bachiller"),
    TIT("Título"),
    MAE("Maestría"),
    DOC("Doctorado");

    private final String value;
    private static final Map<String, TipoGradoAcademicoEnum> lookup = new HashMap<>();

    static {
        for (TipoGradoAcademicoEnum d : TipoGradoAcademicoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoGradoAcademicoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoGradoAcademicoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoGradoAcademicoEnum d : TipoGradoAcademicoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (TipoGradoAcademicoEnum e : TipoGradoAcademicoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
