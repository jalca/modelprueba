package pe.edu.lamolina.model.enums.subvenciones;

import java.util.HashMap;
import java.util.Map;

public enum AlumnoViajeCursoEstadoEnum {

    SIN_REGISTRO("Sin registro"),
    PENDIENTE("Pendiente"),
    DENEGADO_EDAD("Denegado por edad"),
    // DENEGADO_CURRICULA("Denegado por currícula"),
    CONFIRMADO("Confirmado"),
    RENUNCIA("Renuncia"),
    FORM_SALUD("Llenar datos salud"),
    VER_MEDICO("Debe visitar médico"),
    SALUD_NO_OK("Denegado por salud"),
    SALUD_OK("VºBº Médico"),
    FIRMA_APODERADO("Requiere VºBº Apoderado"),
    FICHA_SEC_OK("Completó Ficha SEC"),
    INSCRITO("Inscrito"),
    SEPARADO("Separado"),
    // ANTE_LISTA_NEGRA("Antecedente Lista Negra"),
    ENTREV_APODERADO("Entrevista con apoderado"),
    // NO_AUTORIZADO("No autorizado por Administración"),
    NO_LISTA_NEGRA("Activado temporalmente"),
    // DENEGADO_LN("Denegado por Lista Negra"),
    JUSTIFICADO_SIN_VB("Justificado sin VºBº"),
    JUSTIFICADO("Justificado"),
    DEUDA("Justificación con deuda"),
    DEVUELTO("Deuda devuelta"),
    LISTA_NEGRA("Lista Negra");

    private final String value;
    private static final Map<String, AlumnoViajeCursoEstadoEnum> lookup = new HashMap<>();

    static {
        for (AlumnoViajeCursoEstadoEnum d : AlumnoViajeCursoEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AlumnoViajeCursoEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlumnoViajeCursoEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AlumnoViajeCursoEstadoEnum d : AlumnoViajeCursoEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
