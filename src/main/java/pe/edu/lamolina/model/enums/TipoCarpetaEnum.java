package pe.edu.lamolina.model.enums;

public enum TipoCarpetaEnum {
    AUL("Aula", 1L),
    LAB("Laboratorio", 2L);

    private final String value;
    private final Long id;

    private TipoCarpetaEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

}
