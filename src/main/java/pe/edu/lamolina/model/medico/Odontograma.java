package pe.edu.lamolina.model.medico;

import java.io.Serializable;
import java.util.List;

public class Odontograma implements Serializable {

    PiezaDental piezaDental;
    Boolean posicion = Boolean.TRUE;
    Boolean vacio = Boolean.TRUE;
    List<PiezaDentalHallazgo> hallazgos;
    List<PiezaDentalPrestacion> prestaciones;
    Long idHistoriaOdontograma;

    public Boolean getPosicion() {
        return posicion;
    }

    public void setPosicion(Boolean posicion) {
        this.posicion = posicion;
    }

    public PiezaDental getPiezaDental() {
        return piezaDental;
    }

    public void setPiezaDental(PiezaDental piezaDental) {
        this.piezaDental = piezaDental;
    }

    public List<PiezaDentalHallazgo> getHallazgos() {
        return hallazgos;
    }

    public void setHallazgos(List<PiezaDentalHallazgo> hallazgos) {
        this.hallazgos = hallazgos;
    }

    public List<PiezaDentalPrestacion> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(List<PiezaDentalPrestacion> prestaciones) {
        this.prestaciones = prestaciones;
    }

    public Boolean getVacio() {
        return vacio;
    }

    public void setVacio(Boolean vacio) {
        this.vacio = vacio;
    }

    public Long getIdHistoriaOdontograma() {
        return idHistoriaOdontograma;
    }

    public void setIdHistoriaOdontograma(Long idHistoriaOdontograma) {
        this.idHistoriaOdontograma = idHistoriaOdontograma;
    }

}
