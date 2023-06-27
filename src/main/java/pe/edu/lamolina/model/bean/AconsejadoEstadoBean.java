package pe.edu.lamolina.model.bean;

import java.util.List;
import pe.edu.lamolina.model.consejeria.AlumnoConsejero;

public class AconsejadoEstadoBean {

    Long activos;
    Long sinConsejero;
    Long sinAsignar;
    Long matriculados;
    Long noMatriculados;
    Long retiroCiclo;
    List<AlumnoConsejero> alumnosConsejeros;

    public Long getActivos() {
        return activos;
    }

    public void setActivos(Long activos) {
        this.activos = activos;
    }

    public Long getSinConsejero() {
        return sinConsejero;
    }

    public void setSinConsejero(Long sinConsejero) {
        this.sinConsejero = sinConsejero;
    }

    public Long getSinAsignar() {
        return sinAsignar;
    }

    public void setSinAsignar(Long consejeroInha) {
        this.sinAsignar = consejeroInha;
    }

    public Long getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(Long matriculados) {
        this.matriculados = matriculados;
    }

    public Long getNoMatriculados() {
        return noMatriculados;
    }

    public void setNoMatriculados(Long noMatriculados) {
        this.noMatriculados = noMatriculados;
    }

    public Long getRetiroCiclo() {
        return retiroCiclo;
    }

    public void setRetiroCiclo(Long retiroCiclo) {
        this.retiroCiclo = retiroCiclo;
    }

    public List<AlumnoConsejero> getAlumnosConsejeros() {
        return alumnosConsejeros;
    }

    public void setAlumnosConsejeros(List<AlumnoConsejero> alumnosConsejeros) {
        this.alumnosConsejeros = alumnosConsejeros;
    }

}
