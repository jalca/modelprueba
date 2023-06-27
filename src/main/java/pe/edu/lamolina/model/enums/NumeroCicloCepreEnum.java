package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NumeroCicloCepreEnum {

    INT("Intensivo", "INTENSIVO", 0, 2000),
    REG1("Regular I", "REGULAR", 1, 2000),
    REG2("Regular II", "REGULAR", 2, 2000);

    private final String value;
    private final String value2;
    private final Integer numeroCiclo;
    private Integer year;
    // private final Integer descuento;
    private static final Map<String, NumeroCicloCepreEnum> lookup = new HashMap<>();

    static {
        for (NumeroCicloCepreEnum d : NumeroCicloCepreEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private NumeroCicloCepreEnum(String value, String value2, Integer numeroCiclo, Integer year) {
        this.value = value;
        this.value2 = value2;
        this.numeroCiclo = numeroCiclo;
        this.year = year;
        //this.descuento = descuento;
    }

    public String getValue() {
        return value;
    }

    public String getValue2() {
        return value2;
    }

    public Integer getNumeroCiclo() {
        return numeroCiclo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public static NumeroCicloCepreEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (NumeroCicloCepreEnum d : NumeroCicloCepreEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static NumeroCicloCepreEnum getByNumeroCiclo(Integer numeroCiclo) {

        for (NumeroCicloCepreEnum d : NumeroCicloCepreEnum.values()) {
            if (d.getNumeroCiclo().compareTo(numeroCiclo) == 0) {
                return d;
            }
        }

        return null;
    }

    public static NumeroCicloCepreEnum getEnumValue2(String value2) {
        for (NumeroCicloCepreEnum v : values()) {
            if (v.getValue2().equalsIgnoreCase(value2)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }
}
