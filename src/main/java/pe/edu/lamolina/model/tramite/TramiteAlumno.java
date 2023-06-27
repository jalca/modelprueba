package pe.edu.lamolina.model.tramite;

import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.finanzas.Acreencia;

public class TramiteAlumno {

    Tramite tramite;
    Resolucion resolucion;
    CicloAcademico cicloAcademico;
    String estadoTramite;
    String tabla;
    Acreencia acreencia;

    public TramiteAlumno() {
    }

    public TramiteAlumno(Tramite tramite, Resolucion resolucion, CicloAcademico cicloAcademico, String estadoTramite, String tabla, Acreencia acreencia) {
        this.tramite = tramite;
        this.resolucion = resolucion;
        this.cicloAcademico = cicloAcademico;
        this.estadoTramite = estadoTramite;
        this.tabla = tabla;
        this.acreencia = acreencia;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Acreencia getAcreencia() {
        return acreencia;
    }

    public void setAcreencia(Acreencia acreencia) {
        this.acreencia = acreencia;
    }
}
