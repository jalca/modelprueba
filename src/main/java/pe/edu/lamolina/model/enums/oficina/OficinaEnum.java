package pe.edu.lamolina.model.enums.oficina;

import java.util.HashMap;
import java.util.Map;

public enum OficinaEnum {

    UNA("Consejo Universitario", 1L),
    // Oficinas de Admision
    CAP("Centro de Admisión y Promoción", 81L),
    EPG("Escuela de Posgrado", 57L),
    SECRE_ACA("Secretaria Académica de la Escuela de Posgrado", 151L),
    // Oficinas de Estudios
    OERA("Oficina de Estudios y Registros Académicos", 50L),
    UR("Unidad Registros Académicos", 54L),
    ASOERA("Área de Sistemas", 70L),
    PAULA("Personal de Aulas", 199L),
    UPH("Unidad de Programación y Servicios Académicos", 55L),
    // Oficinas de Bienestar
    OBUAE("Oficina de Bienestar Universitario y Asuntos Estudiantiles", 53L),
    CENMED("Centro Médico", 60L),
    ASUNEST("Asuntos Estudiantiles", 61L),
    FARMA("Farmacia", 77L),
    // Otras oficinas
    BAN("Biblioteca Agrícola Nacional", 194L),
    DEPFIS("Departamento de Actividades Deportivas", 64L),
    DEPACT("Departamento de Actividades Culturales", 65L),
    RECT("Rectorado", 2L),
    VACA("Vicerectorado Académico", 3L);

    private Long id;
    private final String value;
    private static final Map<String, OficinaEnum> lookup = new HashMap();

    static {
        for (OficinaEnum d : OficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private OficinaEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static OficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (OficinaEnum d : OficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
