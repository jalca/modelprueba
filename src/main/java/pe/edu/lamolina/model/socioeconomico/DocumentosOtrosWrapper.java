package pe.edu.lamolina.model.socioeconomico;

import java.util.List;

public class DocumentosOtrosWrapper {

    private DatosOtrosAdapter datosOtrosAdapter;

    private List<PersonaDocumento> documentos;

    public DatosOtrosAdapter getDatosOtrosAdapter() {
        return datosOtrosAdapter;
    }

    public void setDatosOtrosAdapter(DatosOtrosAdapter datosOtrosAdapter) {
        this.datosOtrosAdapter = datosOtrosAdapter;
    }

    public List<PersonaDocumento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<PersonaDocumento> documentos) {
        this.documentos = documentos;
    }

}
