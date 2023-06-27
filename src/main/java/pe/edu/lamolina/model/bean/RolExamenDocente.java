package pe.edu.lamolina.model.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.RolExamenesEstadoEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.rolexamen.GrupoHorasExamen;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

public class RolExamenDocente {

    Curso curso;
    Aula aula;
    List<Aula> aulas;
    @JsonDeserialize(using = DateDeserializer.class)
    String estado;
    Long idRolExamen;
    String nombreRolExamen;
    GrupoHorasExamen grupoHorasExamen;
    Seccion seccion;
    List<Seccion> secciones;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public RolExamenesEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return RolExamenesEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(RolExamenesEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public GrupoHorasExamen getGrupoHorasExamen() {
        return grupoHorasExamen;
    }

    public void setGrupoHorasExamen(GrupoHorasExamen grupoHorasExamen) {
        this.grupoHorasExamen = grupoHorasExamen;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public Long getIdRolExamen() {
        return idRolExamen;
    }

    public void setIdRolExamen(Long idRolExamen) {
        this.idRolExamen = idRolExamen;
    }

    public String getNombreRolExamen() {
        return nombreRolExamen;
    }

    public void setNombreRolExamen(String nombreRolExamen) {
        this.nombreRolExamen = nombreRolExamen;
    }

    public RolExamenDocente() {
    }

    public RolExamenDocente(Curso curso, GrupoHorasExamen grupoHorasExamen, List<Aula> aulas, List<Seccion> secciones, String estado, Long idRolExamen, String nombreRolExamen) {
        this.curso = curso;
        this.aulas = aulas;
        this.estado = estado;
        this.grupoHorasExamen = grupoHorasExamen;
        this.secciones = secciones;
        this.idRolExamen = idRolExamen;
        this.nombreRolExamen = nombreRolExamen;
    }

    public RolExamenDocente(Curso curso, GrupoHorasExamen grupoHorasExamen, Aula aula, Seccion seccion, String estado, Long idRolExamen, String nombreRolExamen) {
        this.curso = curso;
        this.aula = aula;
        this.estado = estado;
        this.grupoHorasExamen = grupoHorasExamen;
        this.seccion = seccion;
        this.idRolExamen = idRolExamen;
        this.nombreRolExamen = nombreRolExamen;
    }

}
