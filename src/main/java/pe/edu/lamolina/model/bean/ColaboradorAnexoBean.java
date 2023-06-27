package pe.edu.lamolina.model.bean;

import java.util.List;
import pe.edu.lamolina.model.academico.AnexoBoletin;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.permisoprogramacion.PermisosProgramacionHorarios;

public class ColaboradorAnexoBean {

    Long id;
    Long idPermiso;
    Colaborador colaborador;
    AnexoBoletin anexoBoletin;
    List<PermisosProgramacionHorarios> permisosCurso;
    List<PermisosProgramacionHorarios> permisosGpoSec;
    List<PermisosProgramacionHorarios> permisosSecc;
    List<PermisosProgramacionHorarios> permisosDocente;
    List<PermisosProgramacionHorarios> permisosProgramacionHorarios;

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public AnexoBoletin getAnexoBoletin() {
        return anexoBoletin;
    }

    public void setAnexoBoletin(AnexoBoletin anexoBoletin) {
        this.anexoBoletin = anexoBoletin;
    }

    public List<PermisosProgramacionHorarios> getPermisosCurso() {
        return permisosCurso;
    }

    public void setPermisosCurso(List<PermisosProgramacionHorarios> permisosCurso) {
        this.permisosCurso = permisosCurso;
    }

    public List<PermisosProgramacionHorarios> getPermisosGpoSec() {
        return permisosGpoSec;
    }

    public void setPermisosGpoSec(List<PermisosProgramacionHorarios> permisosGpoSec) {
        this.permisosGpoSec = permisosGpoSec;
    }

    public List<PermisosProgramacionHorarios> getPermisosSecc() {
        return permisosSecc;
    }

    public void setPermisosSecc(List<PermisosProgramacionHorarios> permisosSecc) {
        this.permisosSecc = permisosSecc;
    }

    public List<PermisosProgramacionHorarios> getPermisosDocente() {
        return permisosDocente;
    }

    public void setPermisosDocente(List<PermisosProgramacionHorarios> permisosDocente) {
        this.permisosDocente = permisosDocente;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PermisosProgramacionHorarios> getPermisosProgramacionHorarios() {
        return permisosProgramacionHorarios;
    }

    public void setPermisosProgramacionHorarios(List<PermisosProgramacionHorarios> permisosProgramacionHorarios) {
        this.permisosProgramacionHorarios = permisosProgramacionHorarios;
    }

}
