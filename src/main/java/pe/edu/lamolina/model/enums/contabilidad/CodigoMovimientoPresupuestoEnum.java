package pe.edu.lamolina.model.enums.contabilidad;

import java.util.HashMap;
import java.util.Map;

public enum CodigoMovimientoPresupuestoEnum {

    // consumo-partida
    ENTRADA_DINERO("Entrada Dinero"),
    SALIDA_DINERO("Salida Dinero"),
    // creacion-partida
    INICIO_PRESUPUESTO("Inicio Presupuesto"),
    // partida-padre
    CONSUMO_PRESUPUESTO("Consumo Presupuesto"),
    DEVUELVE_PRESUPUESTO("Devuelve Presupuesto"),
    // partida-operacion
    MENOS_PRESUPUESTO("Disminución Presupuesto"),
    MAS_PRESUPUESTO("Incremento Presupuesto");

    private final String value;
    private static final Map<String, CodigoMovimientoPresupuestoEnum> lookup = new HashMap<>();

    static {
        for (CodigoMovimientoPresupuestoEnum d : CodigoMovimientoPresupuestoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoMovimientoPresupuestoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoMovimientoPresupuestoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoMovimientoPresupuestoEnum d : CodigoMovimientoPresupuestoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
