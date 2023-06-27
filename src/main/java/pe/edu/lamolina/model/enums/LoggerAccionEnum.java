package pe.edu.lamolina.model.enums;

public enum LoggerAccionEnum {
    ESTRUCTURA_EVALUACION_CRE("Estructura_Evaluacion.cre"),
    ESTRUCTURA_EVALUACION_UPD("Estructura_Evaluacion.upd"),
    RECAUDA_DEUDA_HANDLE_MESSAGE("Recauda_Deuda_Handle_Message"),
    CONSULTAR_DEUDAS("Consultar Deudas"),
    RECAUDA_DEUDA_SAVE("Recauda_Deuda_Save"),
    RECAUDA_DEUDA_ANULAR("Recauda_Deuda_Anular"),
    PAGOS_DEUDA_HANDLE_MESSAGE("Pagos_Deuda_Handle_Message"),
    PAGOS_PROCESAR_PAGO("Pagos_Procesar_Pago"),
    PAGOS_PROCESAR_EXTORNO("Pagos_Procesar_Extorno"),
    GENERAL_QUEUE_HANDLE_MESSAGE("General_Deuda_Handle_Message"),
    GENERAL_QUEUE_ACTUALIZAR_PERSONA("General_Actualizar_Persona"),
    GRABAR_NOTAS_ACADEMICAS("Grabar_Notas_Academicas"),
    GRABAR_NOTAS_ACADEMICAS_CAMBIO_NOTA("Grabar_Notas_Academicas_Cambio_Nota"),
    TRASLADO_NOTAS_A_HISTORIAL("Traslado notas a historial"),
    PROMEDIAR_ALUMNO("Promediar Alumno"),
    GRUPO_SECCION_CRE("Creacion Grupo Seccions"),
    PROCESAR_TARIFAS_EPT("Procesar tarifas EPT"),
    PROCESAR_ALUMNOS_TARIFAS_EPT("Procesar alumnos tarifas EPT"),
    PROCESAR_DEUDAS_CUENTAS_EPT("Procesar deudas cuentas EPT"),
    ACTUALIZAR_DEUDAS("Actualizar Deuda"),
    ACTUALIZAR_ABONO("Actualizar Abono");

    private final String value;

    private LoggerAccionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
