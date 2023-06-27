package pe.edu.lamolina.model.horario;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "hor_grupo_horas_excluido")
public class GrupoHorasExcluido implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_excluye")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExcluye;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas")
    private GrupoHoras grupoHoras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_excluye")
    private Usuario userExcluye;

    public GrupoHorasExcluido() {
    }

    public GrupoHorasExcluido(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaExcluye() {
        return fechaExcluye;
    }

    public void setFechaExcluye(Date fechaExcluye) {
        this.fechaExcluye = fechaExcluye;
    }

    public GrupoHoras getGrupoHoras() {
        return grupoHoras;
    }

    public void setGrupoHoras(GrupoHoras grupoHoras) {
        this.grupoHoras = grupoHoras;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Usuario getUserExcluye() {
        return userExcluye;
    }

    public void setUserExcluye(Usuario userExcluye) {
        this.userExcluye = userExcluye;
    }

}
