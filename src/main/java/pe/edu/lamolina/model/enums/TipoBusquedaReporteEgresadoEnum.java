package pe.edu.lamolina.model.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoBusquedaReporteEgresadoEnum {

    FAC("Facultad", Arrays.asList("CICLO", "PRIM_FAC", "DIES_PRIM")),
    CAR("Carrera", Arrays.asList("CICLO", "DIES_PRIM")),
    CICLO("Ciclo", Arrays.asList("FAC", "CAR", "PRIM_FAC", "DIES_PRIM")),
    PRIM_FAC("Primer Puesto por facultad", Arrays.asList("FAC", "CICLO")),
    DIES_PRIM("10 Primer Puesto", Arrays.asList("FAC", "CAR", "CICLO"));

    private final String value;
    private final List<String> permisos;
    private static final Map<String, TipoBusquedaReporteEgresadoEnum> lookup = new HashMap<>();

    static {
        for (TipoBusquedaReporteEgresadoEnum d : TipoBusquedaReporteEgresadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoBusquedaReporteEgresadoEnum(String value, List<String> permisos) {
        this.value = value;
        this.permisos = permisos;
    }

    public String getValue() {
        return value;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public static TipoBusquedaReporteEgresadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoBusquedaReporteEgresadoEnum d : TipoBusquedaReporteEgresadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
