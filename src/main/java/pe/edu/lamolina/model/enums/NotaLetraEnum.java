package pe.edu.lamolina.model.enums;

public enum NotaLetraEnum {

    APROBADO("AP", "A"),
    DESAPROBADO("DE", "D");

    private final String valor1;
    private final String valor2;

    private NotaLetraEnum(String valor1, String valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }

}
