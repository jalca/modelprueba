package pe.edu.lamolina.model.dto;

public class AnexoResumen {

    private Long ingresantes;
    private Long departamentos;
    private Long postGrados;
    private Long actividades;

    public AnexoResumen(Long ingresantes, Long departamentos, Long postGrados, Long actividades) {
        this.ingresantes = ingresantes;
        this.departamentos = departamentos;
        this.postGrados = postGrados;
        this.actividades = actividades;
    }

    public Long getIngresantes() {
        return ingresantes;
    }

    public void setIngresantes(Long ingresantes) {
        this.ingresantes = ingresantes;
    }

    public Long getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Long departamentos) {
        this.departamentos = departamentos;
    }

    public Long getPostGrados() {
        return postGrados;
    }

    public void setPostGrados(Long postGrados) {
        this.postGrados = postGrados;
    }

    public Long getActividades() {
        return actividades;
    }

    public void setActividades(Long actividades) {
        this.actividades = actividades;
    }

}
