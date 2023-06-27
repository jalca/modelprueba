package pe.edu.lamolina.model.enums.encuesta;

public enum FormulaValorColumnaEnum {

    PERUANO("Peruano"),
    EXTRANJERO("Extranjero"),
    LIMA_CALLAO("Distritos Lima Callao"),
    PROVINCIAS_PERU("Distritos fuera de Lima Callao"),
    MENOR_EDAD("Menor de edad"),
    MAYOR_EDAD("Mayor de edad"),
    COLEGIO_ESTATAL("Colegio Estatal"),
    COLEGIO_PRIVADO("Colegio Privado");

    private final String value;

    private FormulaValorColumnaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
