package pe.edu.lamolina.model.enums.comedor;

import java.util.HashMap;
import java.util.Map;

public enum TipoComensalEnum {

    // Para determinar el tipo Comensal Generico
    ALUMNO("Alumno"),
    ALUMNO_NOMAT("Alumno no matriculado"),
    ALUMNO_RETIRADO("Alumno retirado"),
    ALUMNO_IRREGULAR("Alumno irregular"),
    DOCENTE_PREGRADO("Docente pregrado"),
    DOCENTE_POSGRADO("Docente posgrado"),
    COLABORADOR("Colaborador"),
    VISITANTE("Visitante"),
    // Para determinar el tipo Comensal del Ticket
    INDEFINIDO("Indefinido"),
    ALUMNO_REGULAR("Alumno Regular"),
    ALUMNO_BECADO("Alumno Becado"),
    ACCESO_LIBRE("Pase Libre"),
    VENTA_LIBRE("Venta Libre");

    private final String value;
    private static final Map<String, TipoComensalEnum> lookup = new HashMap<>();

    static {
        for (TipoComensalEnum d : TipoComensalEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoComensalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoComensalEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoComensalEnum d : TipoComensalEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
