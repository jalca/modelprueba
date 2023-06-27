package pe.edu.lamolina.model.enums;

public enum TipoEvaluacionEnum {

    NF(50L, "NF", "Nota Final"),
    EF(2L, "EF", "EXamen Final");

    private final Long id;
    private final String codigo;
    private final String nombre;

    private TipoEvaluacionEnum(Long id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

}
