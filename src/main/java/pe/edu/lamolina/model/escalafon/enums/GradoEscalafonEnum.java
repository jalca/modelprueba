package pe.edu.lamolina.model.escalafon.enums;

public enum GradoEscalafonEnum {

    MAGISTER("Magister"),
    DOCTORADO("Doctorado"),
    LICENCIADO_TITULADO("Licenciado / Títulado");

    private final String descripcion;

    private GradoEscalafonEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
