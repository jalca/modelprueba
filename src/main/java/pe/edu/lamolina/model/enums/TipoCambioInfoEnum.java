package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCambioInfoEnum {

    CMODAAI("Cambio de Modalidad AI"),
    CMODADI("Cambio de Modalidad DI"),
    COPCIONAI("Cambio de Carreras AI"),
    COPCIONDI("Cambio de Carreras DI"),
    CDATGEN("Cambio de Datos Personales"),
    CCOLEUNIAI("Cambio de Colegio o Universidad AI"),
    CCOLEUNIDI("Cambio de Colegio o Universidad DI"),
    CCOLEUNIDE("Cambio de Colegio o Universidad DE"),
    CNUMDOC("Cambio de Numero de Documento"),
    CNDEM("Cambio de Número de Documento y/o Email"),
    CDIFEMOD("Diferencia Modalidad");

    private final String value;
    private static final Map<String, TipoCambioInfoEnum> lookup = new HashMap<>();

    static {
        for (TipoCambioInfoEnum d : TipoCambioInfoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCambioInfoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCambioInfoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCambioInfoEnum d : TipoCambioInfoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
