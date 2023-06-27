package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ModalidadEstudioEnum {

    PRE("Pregrado"),
    EPG("Posgrado"),
    ESP("Especial"),
    VIS("Visitante"),
    IDIOM("Cursos de Ingles"),
    CUR_VER("Cursos de Verano"),
    CLIB("Cursos Libres"),
    OPT("Optativo"),
    DIPLO("Diplomado"),
    TALL("Talleres");
    

    private final String value;
    private static final Map<String, ModalidadEstudioEnum> lookup = new HashMap<>();

    static {
        for (ModalidadEstudioEnum d : ModalidadEstudioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ModalidadEstudioEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ModalidadEstudioEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ModalidadEstudioEnum d : ModalidadEstudioEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ModalidadEstudioEnum e : ModalidadEstudioEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
