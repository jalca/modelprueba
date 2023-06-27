package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoTipoPedidoGastoEnum {

    PAG_DOC("Pago Docente"),
    CAR_REN_CUE("Cargo Rendir Cuenta"),
    PAG_PRO("Pago Proveedor"),
    TRANS("Transferencia"),
    PAG_COL("Pago Colaborador"),
    PAG_DIR_DUPG("Pago Director DUPG"),
    PAG_ORD_COM("Pago Orden de Compra"),
    OTROS("Otros");

    private final String value;
    private static final Map<String, CodigoTipoPedidoGastoEnum> lookup = new HashMap<>();

    static {
        for (CodigoTipoPedidoGastoEnum d : CodigoTipoPedidoGastoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoTipoPedidoGastoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CodigoTipoPedidoGastoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoTipoPedidoGastoEnum d : CodigoTipoPedidoGastoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
