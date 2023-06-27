package pe.edu.lamolina.model.medico;

import java.util.List;

public class IngresoAtencionExternaAdapter {

    private List<Long> listaIds;
    private HistoriaAtencion historiaAtencion;

    public List<Long> getListaIds() {
        return listaIds;
    }

    public void setListaIds(List<Long> listaIds) {
        this.listaIds = listaIds;
    }

    public HistoriaAtencion getHistoriaAtencion() {
        return historiaAtencion;
    }

    public void setHistoriaAtencion(HistoriaAtencion historiaAtencion) {
        this.historiaAtencion = historiaAtencion;
    }

}
