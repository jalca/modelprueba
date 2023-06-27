package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSeccionConcurrenciaEnum {

    SUM_MAT("Sumar matriculados"),
    RES_MAT("Restar matriculados"),
    SUM_VAC("Sumar vacantes "),
    RES_VAC("Restar vacantes "),
    SUM_VAC_MAT("Sumar matriculados si hay vacantes disponibles"),
    SUM_VAC_PMAT("Sumar pre-matriculados si hay vacantes disponibles"),
    RES_VAC_MAT("Restar matriculados"),
    RES_VAC_PMAT("Restar pre-matriculados"),
    SUM_VAC_VAR("Sumar vacantes con parametro"),
    RES_VAC_VAR("Restar vacantes con parametro"),
    SUM_VAC_MAT_RESV("Sumar matriculados restar reservados si hay disponibles"),
    RES_VAC_MAT_RESV("Restar matriculados sumar disponibles"),
    SUM_ABONO_VERANO("Sumar abono verano con parametro"),
    RES_ABONO_VERANO("Restar abono verano con parametro");

    private final String value;
    private static final Map<String, TipoSeccionConcurrenciaEnum> lookup = new HashMap<>();

    static {
        for (TipoSeccionConcurrenciaEnum d : TipoSeccionConcurrenciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoSeccionConcurrenciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoSeccionConcurrenciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSeccionConcurrenciaEnum d : TipoSeccionConcurrenciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
