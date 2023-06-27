package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ModalidadIngresoEnum {
    ORDINARIO(1L, "01"),
    PRIMEROS_PUESTOS(3L, "02"),
    CEPRE(16L, "03"),
    DISCAPACITADOS(6L, "11"),
    QUINTO_SECUNDARIA(26L, "24");

    private final Long value;
    private final String code;
    private static final Map<Long, ModalidadIngresoEnum> lookup = new HashMap<>();

    static {
        for (ModalidadIngresoEnum d : ModalidadIngresoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ModalidadIngresoEnum(Long value, String code) {
        this.value = value;
        this.code = code;
    }

    public Long getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

}
