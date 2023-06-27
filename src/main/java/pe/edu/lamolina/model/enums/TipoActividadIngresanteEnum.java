package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoActividadIngresanteEnum {

    CAREO("Careo"),
    DOCS("Entrega de Documentos"),
    RPAGOADM("Revisión Pagos Admisión"),
    FISOEC("Ficha Socio-Económica"),
    TESTPSIC("Test Psicológico"),
    ENTREV("Entrevista Trabajadora Social"),
    RECEP("Recepción Centro Médico"),
    PAGOEXAMED("Pago Examen Médico"),
    EXAMED("Examen Médico"),
    ODONTO("Odontograma"),
    TOPIC("Tópico"),
    TRIAJE("Triaje"),
    VACUNA("Vacunas"),
    PSICO("Psicología"),
    PAGOMATRI("Pago Aportes Matrícula"),
    MATRI("Matrícula"),
    LAB("Muestra de Sangre");

    private final String value;
    private static final Map<String, TipoActividadIngresanteEnum> lookup = new HashMap<>();

    static {
        for (TipoActividadIngresanteEnum d : TipoActividadIngresanteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoActividadIngresanteEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoActividadIngresanteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoActividadIngresanteEnum d : TipoActividadIngresanteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
