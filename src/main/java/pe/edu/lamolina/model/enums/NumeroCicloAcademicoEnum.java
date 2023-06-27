package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NumeroCicloAcademicoEnum {

    VERANO("0", "V", "XXXX00", "XXXX-V", "XXXX Ciclo Verano", "XXXX Summer Cyclo"),
    PRIMERO("1", "I", "XXXX10", "XXXX-I", "XXXX Primer Ciclo", "XXXX First Cyclo"),
    SEGUNDO("2", "II", "XXXX20", "XXXX-II", "XXXX Segundo Ciclo", "XXXX Second Cyclo"),
    INVIERNO("1.5", "N", "XXXX15", "XXXX-N", "XXXX Ciclo Invierno", "XXXX Winter Cyclo");

    private final String value;
    private final String numeroCiclo;
    private final String codigo;
    private final String descripcion;
    private final String descripcion2;
    private final String descripcion3;

    private static final Map<String, NumeroCicloAcademicoEnum> lookupValue = new HashMap<>();

    static {
        for (NumeroCicloAcademicoEnum d : NumeroCicloAcademicoEnum.values()) {
            lookupValue.put(d.getValue(), d);
        }
    }

    private NumeroCicloAcademicoEnum(String value, String numeroCiclo, String codigo, String descripcion, String descripcion2, String descripcion3) {
        this.value = value;
        this.numeroCiclo = numeroCiclo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.descripcion2 = descripcion2;
        this.descripcion3 = descripcion3;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getValue() {
        return value;
    }

    public String getNumeroCiclo() {
        return numeroCiclo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public String getDescripcion3() {
        return descripcion3;
    }

    public static NumeroCicloAcademicoEnum get(String abbreviation) {
        return lookupValue.get(abbreviation);
    }

}
