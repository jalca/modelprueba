package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CuentaBancariaEnum {

    INS_UNLM("Inscripcion Unalm", "1001", 0L),
    GUIA_POST("Guia Postulante", "2001", 0L),
    FDA_CURSOS("FDA-CURSOS NIV", "2003", 0L),
    MAT_UNALM("Credipago Matricula", "1002", 0L),
    MAT_FDA("Credipago Bienestar", "2002", 0L),
    ADM_EPG("Admisión Posgrado", "1004", 0L),
    OBU("Bienestar Universitario", "2002", 7L),
    CUENTA_POSGRADO_UNALM("Concepto Enseñanza Posgrado", "1003", 5L),
    CUENTA_POSGRADO_FDA("Cuota Enseñanza Posgrado", "2004", 9L),
    EPG_TRAM_GRADO("FDA-CURSOS EPG", "2005", 12L);

    private final String value;
    private Long id;
    private final String codigoServ;
    private static final Map<String, CuentaBancariaEnum> lookup = new HashMap<>();

    static {
        for (CuentaBancariaEnum d : CuentaBancariaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CuentaBancariaEnum(String value, String codigoServ, Long id) {
        this.value = value;
        this.codigoServ = codigoServ;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public String getCodigoServ() {
        return codigoServ;
    }

    public static CuentaBancariaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CuentaBancariaEnum d : CuentaBancariaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
