package pe.edu.lamolina.model.enums;

public enum OrigenDataSituacionAcademicaEnum {

    ACTA("Acta"),
    TA_REI("Tramite Reincorporacion"),
    TA_CORR_HISTO("Tramite Corrección historial"),
    TR_DOCUMENTO("Tramite Documento"),
    RES("Resolución"),
    CARTA("Carta"),
    RCI("Retiro de Ciclo"),
    ANCI("Anulación de Ciclo"),
    ANT("ANT"),
    FIS("FIS"),
    CEL("CEL"),
    CNO("CNO"),
    RET("RET"),
    MIGRA("MIGRA"),
    MOD("MOD"),
    ACT("ACT"),
    PP("PP"),
    ANB("ANB"),
    ACI("ACI"),
    CNV("CNV"),
    RAC("RAC"),
    TE("TE");

    private final String value;

    private OrigenDataSituacionAcademicaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
