package pe.edu.lamolina.model.escalafon.enums;

public enum TipoExperienciaEnum {

    DOCENTE("Docente"), EXPERIENCIA("Experiencia Normal");

    private final String descripcion;

    private TipoExperienciaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
