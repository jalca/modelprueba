package pe.edu.lamolina.model.enums.medico;

import java.util.HashMap;
import java.util.Map;

public enum TipoOperacionCitaEnum {

    RESERVAR_CITA("Reservar cita del Centro Médico"),
    LIBERAR_CITA("Liberar cita del Centro Médico"),
    ATENDER_CITA("Atender cita del Centro Médico"),
    CANCELAR_CITA("Cancelar cita del Centro Médico"),
    PAUSAR_CITA("Pausar cita del Centro Médico"),
    REACTIVAR_CITA("Reactivar cita del Centro Médico"),
    POSPONER_CITA("Posponer cita del Centro Médico"),
    INTERCAMBIAR_CITAS("Intercambiar pacientes de citas del Centro Médico"),
    HABILITAR_CITA("Habilitar cita del Centro Médico"),
    INHABILITAR_CITA("Inhabilitar cita del Centro Médico"),
    CITA_ATENDIDA("Configurar cita como atendida"),
    CONFIGURAR_PARA_ALUMNOS("Configurar cita para alumnos"),
    CONFIGURAR_PARA_DOCENTES("Configurar cita para docentes"),
    CONFIGURAR_PARA_EMPLEADOS("Configurar cita para empleados"),
    CONFIGURAR_CITA_ESPERA("Configurar cita En Espera"),
    CAMBIAR_TIPO_SESION("Cambiar Tipo de Sesión");

    private final String value;
    private static final Map<String, TipoOperacionCitaEnum> lookup = new HashMap<>();

    static {
        for (TipoOperacionCitaEnum d : TipoOperacionCitaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoOperacionCitaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoOperacionCitaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoOperacionCitaEnum d : TipoOperacionCitaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
