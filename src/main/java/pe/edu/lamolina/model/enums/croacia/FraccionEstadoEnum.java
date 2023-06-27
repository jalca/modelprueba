package pe.edu.lamolina.model.enums.croacia;

import java.util.HashMap;
import java.util.Map;
import pe.edu.lamolina.model.enums.DeudaEstadoEnum;

public enum FraccionEstadoEnum {
    CAN("CAN", DeudaEstadoEnum.PAG),
    DEU("DEU", DeudaEstadoEnum.DEU),
    PAR("PAR", DeudaEstadoEnum.PAR); //must be xtm

    private final String value;
    private final DeudaEstadoEnum deudaEstadoEnum;
    private static final Map<String, FraccionEstadoEnum> lookup = new HashMap<>();

    static {
        for (FraccionEstadoEnum d : FraccionEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private FraccionEstadoEnum(String value, DeudaEstadoEnum deudaEstadoEnum) {
        this.value = value;
        this.deudaEstadoEnum = deudaEstadoEnum;
    }

    public String getValue() {
        return value;
    }

    public DeudaEstadoEnum getDeudaEstadoEnum() {
        return deudaEstadoEnum;
    }

}
