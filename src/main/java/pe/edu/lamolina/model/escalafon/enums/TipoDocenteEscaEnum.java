package pe.edu.lamolina.model.escalafon.enums;

public enum TipoDocenteEscaEnum {

    CONTRATADO("Contratado"), TIEMPO_COMPLETO("Tiempo Completo");

    private final String descripcion;

    private TipoDocenteEscaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
