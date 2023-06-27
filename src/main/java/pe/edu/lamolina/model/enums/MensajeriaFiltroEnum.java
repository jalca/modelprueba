package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MensajeriaFiltroEnum {

    INTE("Interesados de Ciclos Anteriores", "ANTERIORES"),
    NOING("No Ingresantes de Ciclos Anteriores", "ANTERIORES"),
    NOINGCEPRE("CEPRE No Ingresantes y Pre-Inscritos del Ciclo Actual y Anteriores", "ANTERIORES"),
    CEPRENOPREINS("CEPRE No Ingresantes y No Pre-Inscritos del Ciclo Actual", "ANTES"),
    PAGPROS("Solo Pagaron Prospecto", "ANTES"),
    INSNOPAG("Pre-Inscrito sin pagos", "ANTES"),
    PAGINS("Pre-Inscrito que pagó solo Inscripción", "ANTES"),
    INSPROSPAG("Pre-Inscrito que pagó solo prospecto", "ANTES"),
    ING("Ingresantes del Examen de Admisión", "DESPUES"),
    MODAULA("Inscritos al examen con aula y asiento asignado", "ANTES"),
    INGCEPRE("Ingresantes CEPRE", "DESPUES"),
    INGNODOC("Ingresantes sin documentos", "DESPUES"),
    TALLER("Inscritos en Taller", "OTROS"),
    PRESMEDICA("Personas con prescripción médica", "ANTES"),
    VALIMINEDU("Validados por Minedu", "ANTES"),
    NOVALIMINEDU("No validados por Minedu", "ANTES"),
    NOVALIROSTRO("No validados por Rostro", "ANTES"),
    DISCAP("Personas con discapacidad", "ANTES"),
    CEPRENOEXAMDIR("Cepre que no llegaron al examen directo", "ANTES"),
    CEPREEXAMDIR("Cepre que llegaron al examen directo", "ANTES"),
    VISITANTE("Visitantes", "OTROS");

    private final String value, tipo;
    private static final Map<String, MensajeriaFiltroEnum> lookup = new HashMap<>();

    static {
        for (MensajeriaFiltroEnum d : MensajeriaFiltroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private MensajeriaFiltroEnum(String value, String tipo) {
        this.value = value;
        this.tipo = tipo;
    }

    public String getValue() {
        return value;
    }

    public String getTipo() {
        return tipo;
    }

    public static MensajeriaFiltroEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (MensajeriaFiltroEnum d : MensajeriaFiltroEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (MensajeriaFiltroEnum e : MensajeriaFiltroEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
