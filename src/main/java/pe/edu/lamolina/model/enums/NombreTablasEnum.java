package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum NombreTablasEnum {

    ARCHIVO_PERSONA_DOCUMENTO("isec_archivo_persona_documento"),
    EXTN_DEUDA_TALLER_VERANO("FIN_DEUDA_TALLER_VERANO"),
    FIN_ACREENCIA_TRAMITE_DOCUMENTO("FIN_ACREENCIA_TRAMITE_DOCUMENTO"),
    FIN_ALUMNO_PAGO_VERANO("FIN_ALUMNO_PAGO_VERANO"),
    FIN_DEUDA_ALUMNO("FIN_DEUDA_ALUMNO"),
    FIN_DEUDA_INTERESADO("FIN_DEUDA_INTERESADO"),
    FIN_DEUDA_POSTULANTE_ESCUELA("fin_deuda_postulante_escuela"),
    FIN_DEUDA_TRAMITE("tram_deuda_tramite"),
    INSTALL("extn_inscripcion_taller"),
    MED_EXAMEN_MEDICO("MED_EXAMEN_MEDICO"),
    OBU_CRONOGRAMA_EVENTO_SUBVENCIONADO("OBU_CRONOGRAMA_EVENTO_SUBVENCIONADO"),
    OBU_VIAJE_CURSO("OBU_VIAJE_CURSO"),
    GEN_PERSONA("GEN_PERSONA"),
    // cualquier otra tabla
    OTRA_TABLA("otra_tabla");

    private final String value;
    private static final Map<String, NombreTablasEnum> lookup = new HashMap<>();

    static {
        for (NombreTablasEnum d : NombreTablasEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private NombreTablasEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NombreTablasEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (NombreTablasEnum d : NombreTablasEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
