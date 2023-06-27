package pe.edu.lamolina.model.documental.enums;

public enum TagsTemplate {

    CODIGO_SEGUIMIENTO("Código Interno para Seguimiento del Documento"),
    TIPO_DOCUMENTO("Tipo de Documento"),
    
    FECHA_DOCUMENTO("Fecha del Documento en formato <dd/MM/yyy>"),
    FECHA_DOCUMENTO_TEXT("Fecha del Documento en formato <dd de MMMM del yyyy>"),
    SERIE_DOCUMENTO("Serie del Documento"),
    
    ASUNTO("Asunto del Documento"),
    
    OFICINA_PROCEDENCIA("Oficina de Procedencia del Documento"),
    FIRMANTE("Nombre completo del Firmante"),
    
    OFICINA_DESTINO("Oficina Destino del Documento"),
    DESTINATARIO("Nombre completo del Destinatario")
    ;
    
    

    private final String descripcion;

    private TagsTemplate(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String tag() {
        return "@@" + this.name() + "@@";
    }

}
