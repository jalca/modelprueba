package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.DepartamentoAcademico;
import pe.edu.lamolina.model.academico.Facultad;

public enum TipoOficinaEnum {

    OFI("Oficina", null),
    UNA("Unidad", null),
    MEDICO("Centro Médico", null),
    RECT("Rectorado", null),
    VICE("Vicerrectorado", null),
    EPG("Escuela Posgrado", null),
    DUPG("Dirección Unidad Posgrado", Facultad.class),
    FAC("Facultad", Facultad.class),
    DPTO("Departamento Académico", DepartamentoAcademico.class),
    ESP("Especialidad", Carrera.class),
    CUN("Consejo Universitario", null);

    private final String value;
    private final Class clazz;

    private static final Map<String, TipoOficinaEnum> lookup = new HashMap<>();

    static {
        for (TipoOficinaEnum d : TipoOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOficinaEnum(String value, Class clase) {
        this.value = value;
        this.clazz = clase;
    }

    public String getValue() {
        return value;
    }

    public Class getClazz() {
        return clazz;
    }

    public static TipoOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOficinaEnum d : TipoOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
