package pe.edu.lamolina.model.enums.encuesta;

public enum TipoPreguntaLikertEnum {

    LIKERT("Likert"),
    NUMERICO("Numérico"),
    NOMINAL("Nominal");

    private final String value;

    private TipoPreguntaLikertEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
