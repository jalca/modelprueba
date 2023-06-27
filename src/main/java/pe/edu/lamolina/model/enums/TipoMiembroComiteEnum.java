package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoMiembroComiteEnum {

    ASE("Asesor", 1, 2),
    COA("Co-Asesor", 2, 3),
    MBR("Miembro del Comité Consejero", 3, 4),
    COORD("Coordinador del Programa", 4, 5),
    SEC_ACAD("Secretario Académico", 6, 7),
    PRESID("Presidente", 0, 1),
    DIR_UPG("Director de la Unidad de Posgrado", 5, 6),
    DIR_EPG("Director de la Escuela Posgrado", 7, 8);

    private final String value;
    private final Integer ordenProyectoTesis;
    private final Integer ordenTesis;

    private static final Map<String, TipoMiembroComiteEnum> lookup = new HashMap<>();

    static {
        for (TipoMiembroComiteEnum d : TipoMiembroComiteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoMiembroComiteEnum(String value, Integer ordenProyectoTesis, Integer ordenTesis) {
        this.value = value;
        this.ordenProyectoTesis = ordenProyectoTesis;
        this.ordenTesis = ordenTesis;
    }

    public String getValue() {
        return value;
    }

    public Integer getOrdenProyectoTesis() {
        return ordenProyectoTesis;
    }

    public Integer getOrdenTesis() {
        return ordenTesis;
    }

    public static TipoMiembroComiteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoMiembroComiteEnum d : TipoMiembroComiteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
