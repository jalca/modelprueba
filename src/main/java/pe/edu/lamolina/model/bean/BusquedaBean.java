package pe.edu.lamolina.model.bean;

import java.util.List;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.enums.TipoBusquedaReporteEgresadoEnum;

public class BusquedaBean {

    List<TipoBusquedaReporteEgresadoEnum> tipoBusquedaEnum;
    CicloAcademico cicloAcademico;
    Facultad facultad;
    Carrera carrera;

    public List<TipoBusquedaReporteEgresadoEnum> getBusquedaReporteEgresadoEnums() {
        return tipoBusquedaEnum;
    }

    public void setBusquedaReporteEgresadoEnums(List<TipoBusquedaReporteEgresadoEnum> busquedaReporteEgresadoEnums) {
        this.tipoBusquedaEnum = busquedaReporteEgresadoEnums;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

}
