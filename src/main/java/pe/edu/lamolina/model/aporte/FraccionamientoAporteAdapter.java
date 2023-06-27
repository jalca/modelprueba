package pe.edu.lamolina.model.aporte;

import java.util.List;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.tramite.TramiteFraccionamiento;

public class FraccionamientoAporteAdapter {

    private Tramite tramite;
    private TramiteFraccionamiento tramiteFraccionamiento;
    private ResumenAporteAlumno resumenAporteAlumno;
    private List<AporteAlumnoCiclo> aporteAlumnoCiclo;

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public TramiteFraccionamiento getTramiteFraccionamiento() {
        return tramiteFraccionamiento;
    }

    public void setTramiteFraccionamiento(TramiteFraccionamiento tramiteFraccionamiento) {
        this.tramiteFraccionamiento = tramiteFraccionamiento;
    }

    public ResumenAporteAlumno getResumenAporteAlumno() {
        return resumenAporteAlumno;
    }

    public void setResumenAporteAlumno(ResumenAporteAlumno resumenAporteAlumno) {
        this.resumenAporteAlumno = resumenAporteAlumno;
    }

    public List<AporteAlumnoCiclo> getAporteAlumnoCiclo() {
        return aporteAlumnoCiclo;
    }

    public void setAporteAlumnoCiclo(List<AporteAlumnoCiclo> aporteAlumnoCiclo) {
        this.aporteAlumnoCiclo = aporteAlumnoCiclo;
    }
}
