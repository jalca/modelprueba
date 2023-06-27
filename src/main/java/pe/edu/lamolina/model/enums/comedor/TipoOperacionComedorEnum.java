package pe.edu.lamolina.model.enums.comedor;

import java.util.HashMap;
import java.util.Map;

public enum TipoOperacionComedorEnum {

    // Operaciones genericas
    APERTURA("Aperturar Registro Abonos"),
    RECARGA("Recarga Saldo"),
    ANULAR_RECARGA("Anular Recarga"),
    TRASLADAR_SALDO("Trasladar Saldo"),
    DEVOLVER_SALDO("Devolver Saldo"),
    RESERVA("Reservar Ticket"),
    COMPRAR_TICKET("Comprar Ticket"),
    POSTERGAR("Postegar Consumo"),
    CANCELAR("Cancelar Reserva"),
    REVISAR_TRAMOS("Revisar Tramos"),
    LIBERAR_TICKETS("Liberar Tickets"),
    SALIR_COMEDOR("Salir del Comedor"),
    CONSUMO_LIBERADO("Consumo Liberado"), // ?? NO SE SABE Q ES
    // Operaciones de importes
    ABONO("Abonar"), // para recargar
    COMPRA("Comprar"), // para venta libre
    ANULA_ABONO("Anular abono"),
    TRASLADO("Trasladar saldo"),
    DEVUELVE_SALDO("Devuelver saldo"),
    DEVUELVE("Devuelver abono"),
    CONSUMO("Consumo"),
    CONSUMO_DIRECTO("Consumo Directo"),
    // Tipos transferencia
    MISMO_ALUMNO("Transferencia del mismo alumno"),
    OTRO_ALUMNO("Transferencia a otro alumno");

    private final String value;
    private static final Map<String, TipoOperacionComedorEnum> lookup = new HashMap<>();

    static {
        for (TipoOperacionComedorEnum d : TipoOperacionComedorEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOperacionComedorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoOperacionComedorEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOperacionComedorEnum d : TipoOperacionComedorEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
