package pe.edu.lamolina.model.bean;

public class RestriccionesCursoDirigidoBean {

    Boolean nivel3 = false;
    Boolean cruceHorario = false;
    Boolean sinProgramacion = false;
    Boolean definidoFacultad = false;
    Boolean cursoTeminal = false;
    String motivos;

    public Boolean getNivel3() {
        return nivel3;
    }

    public void setNivel3(Boolean nivel3) {
        this.nivel3 = nivel3;
    }

    public Boolean getCruceHorario() {
        return cruceHorario;
    }

    public void setCruceHorario(Boolean cruceHorario) {
        this.cruceHorario = cruceHorario;
    }

    public Boolean getSinProgramacion() {
        return sinProgramacion;
    }

    public void setSinProgramacion(Boolean sinProgramacion) {
        this.sinProgramacion = sinProgramacion;
    }

    public Boolean getDefinidoFacultad() {
        return definidoFacultad;
    }

    public void setDefinidoFacultad(Boolean definidoFacultad) {
        this.definidoFacultad = definidoFacultad;
    }

    public Boolean getCursoTeminal() {
        return cursoTeminal;
    }

    public void setCursoTeminal(Boolean cursoTeminal) {
        this.cursoTeminal = cursoTeminal;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

}
