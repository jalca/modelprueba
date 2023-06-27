package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoValidacionSubvencionEnum {

    PROM_SEM("Último promedio semestral debe ser mayor igual a 11"), 
    PROM_ACUM("Último promedio acumulado debe sar mayor igual a 11"),
    CRE_APRO("Créditos aprobados acumulados debe ser mayor igual a 15"), 
    SIT_ACA_NOR("Debe tener una Situación Académica Normal"),
    CICLO_REG("No debe superar los 12 ciclos regulares"), 
    CURS_DESA("No haber desaprobado ningun curso"), 
    ALUM_MAT("Estar matriculado"), 
    MAT_CRE("Estar matriculado como mínimo en 12 créditos"), 
    TRAM_SUBV("Está permitido un solo trámite de subvención");

    private final String value;
    private static final Map<String, CodigoValidacionSubvencionEnum> lookup = new HashMap<>();

    static {
        for (CodigoValidacionSubvencionEnum d : CodigoValidacionSubvencionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoValidacionSubvencionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoValidacionSubvencionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoValidacionSubvencionEnum d : CodigoValidacionSubvencionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
