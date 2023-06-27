package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoInformeSubvencionEnum {

    PENDIENTE("Pendiente"),
    ENTREGADO("Entregado"),
    OBSERVA("Observado Supervisor"),
    ACEPTADO("Aceptado Supervisor"),
    VB_OBUAE("VºBº OBU"),
    GASTO_ASIGN("Gasto Asignado"),
    ECONOMIA("Enviado Economía"),
    ORDEN_SERV("Con Ord.Serv."),
    PAGADO("Pagado"),
    ANULADO("Anulado"),
    VENCIDO("Vencido");

    private final String value;
    private static final Map<String, EstadoInformeSubvencionEnum> lookup = new HashMap<>();

    static {
        for (EstadoInformeSubvencionEnum d : EstadoInformeSubvencionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoInformeSubvencionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoInformeSubvencionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoInformeSubvencionEnum d : EstadoInformeSubvencionEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
