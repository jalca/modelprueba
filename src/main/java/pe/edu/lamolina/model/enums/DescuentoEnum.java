package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DescuentoEnum {

    HTPUB("Descuento 100% Hijo de Docente/Administrativo"),
    //    HTPRIV("Descuento 100% Hijo de Trabajador (PRIV)"),
    //    HDPUB("Descuento 100% Hijo de Docente (PUB)"),
    //    HDPRIV("Descuento 100% Hijo de Docente (PRIV)"),
    D50PUB("Descuento 50%"),
    //    D50PRIV("Descuento 50% (PRIV)"),
    D25PUB("Descuento 25%"),
    //    D25PRIV("Descuento 25% (PRIV)"),
    D30PUB("Descuento 30%"),
    D50PRIM("Descuento 50% para modalidad primeros puestos"),
    //    D30PRIV("Descuento 30% (PRIV)"),
    HAPRIM("Dscto 100% Primeros Puestos para Hijo de Docente/Administrativo"),
    //    HDPRIM("Dscto 100% Primeros Puestos para Hijo de Docente"),
    //    HA5TO("Dscto 100% Quinto Secundaria para Hijo de Administrativo"),
    HD5TO("Dscto 100% Quinto Secundaria para Hijo de Docente/Administrativo");

    private final String value;
    private static final Map<String, DescuentoEnum> lookup = new HashMap<>();

    static {
        for (DescuentoEnum d : DescuentoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private DescuentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DescuentoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (DescuentoEnum d : DescuentoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (DescuentoEnum e : DescuentoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }

}
