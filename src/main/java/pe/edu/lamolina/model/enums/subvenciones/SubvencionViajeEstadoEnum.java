package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum SubvencionViajeEstadoEnum {

    // Estados para Viaje-Curso
    SIN_PRESUPUESTO("Sin Presupuesto"),
    GASTO_ASIGN("Gasto Asignado"),
    ECONOMIA("Enviado Economía"),
    ORDEN_SERV("Con Ord.Serv."),
    PAGADO("Pagado"),
    ANULADO("Anulado"),
    VENCIDO("Vencido"),
    // Estados para Alumno-Viaje-Curso
    DENEGADO_ACADEMICO("Denegación Académica"),
    CON_LISTA_NEGRA("Sin Subvención"),
    NO_LISTA_NEGRA("Por Aprobar (L.N.)"),
    SIN_SUBVENCION("Sin Subvención"),
    CON_SUBVENCION("Con Subvención"),
    POR_APROBAR("Por Aprobar"),
    POR_VERIFICAR("Por Verificar"),
    SEPARADO("Separado");

    private final String value;
    private static final Map<String, SubvencionViajeEstadoEnum> lookup = new HashMap<>();

    static {
        for (SubvencionViajeEstadoEnum d : SubvencionViajeEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SubvencionViajeEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SubvencionViajeEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SubvencionViajeEstadoEnum d : SubvencionViajeEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
