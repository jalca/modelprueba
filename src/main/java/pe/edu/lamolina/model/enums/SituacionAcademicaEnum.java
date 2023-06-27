package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SituacionAcademicaEnum {

    S_N("N", "Normal", 1L),
    S_A("A", "Normal A", 2L),
    S_1("1", "Observado 1", 3L),
    S_2("2", "Observado 2", 4L),
    S_3("3", "Prueba", 5L),
    S_4("4", "Separado", 6L),
    S_5("5", "Normal con antecedente", 7L),
    S_6("6", "Suspendido", 8L),
    S_7("7", "Ingresante separado", 9L),
    S_8("8", "Ingresante", 10L),
    S_9("9", "Ingresante no matriculado", 11L),
    S_E("E", "Egresado", 12L),
    S_X("X", "Separado definitivo", 13L),
    S_Y("Y", "Ingreso Anulado", 14L),
    S_U("U", "Suspendido-Separado Ult", 15L),
    S_3U("3U", "A prueba último ciclo", 16L),
    S_EM("EM", "Egresado matriculable", 17L),
    S_G("G", "Graduado", 18L),
    S_MD("MD", "Medida disciplinaria", 19L),
    S_2U("2U", "Observado último ciclo", 20L),
    S_Q("Q", "Quinto Secundaria", 21L),
    S_XD("XD", "Separado disciplina", 22L),
    S_4U("4U", "Separado último ciclo", 23L),
    S_6B("6B", "Suspendido OBU", 24L),
    S_6U("6U", "Suspendido último ciclo", 25L),
    S_T("T", "Trikeado", 26L),
    S_TU("TU", "Trikeado último ciclo", 27L),
    S_D("D", "Desertor", 28L),
    S_R("R", "Ingresante Renunciante", 29L),
    S_4T("4T", "Separado Trika", 30L),
    S_SS("FL", "Sin Situación Académica", 31L),
    S_RA("RA", "Alumno Renunciante", 32L),
    S_00("00", "Comodín", 0L);

    private final String value;
    private final String nombre;
    private final Long id;

    private static final Map<String, SituacionAcademicaEnum> lookup = new HashMap<>();

    static {
        for (SituacionAcademicaEnum d : SituacionAcademicaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private SituacionAcademicaEnum(String value, String nombre, Long id) {
        this.value = value;
        this.nombre = nombre;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public static SituacionAcademicaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (SituacionAcademicaEnum d : SituacionAcademicaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getNombre();
            }
        }

        return nombre;
    }
}
