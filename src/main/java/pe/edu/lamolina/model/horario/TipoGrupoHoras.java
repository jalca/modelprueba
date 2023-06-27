package pe.edu.lamolina.model.horario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.EstadoGrupoHorasEnum;
import pe.edu.lamolina.model.enums.TipoGrupoHorasEnum;

@Entity
@Table(name = "hor_tipo_grupo_horas")
public class TipoGrupoHoras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado_grupos")
    private String estadoGrupos;

    @Column(name = "estado")
    private String estado;

//    @Column(name = "tipo_ciclo")
//    private String tipoCiclo;
    @Column(name = "tiene_horas")
    private Boolean tieneHoras;

    public TipoGrupoHoras() {
    }

    public TipoGrupoHoras(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoGrupoHorasEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoGrupoHorasEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipo(TipoGrupoHorasEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public String getEstadoGrupos() {
        return estadoGrupos;
    }

    public void setEstadoGrupos(String estadoGrupos) {
        this.estadoGrupos = estadoGrupos;
    }

    public EstadoGrupoHorasEnum getEstadoGruposEnum() {
        if (estadoGrupos == null) {
            return null;
        }
        return EstadoGrupoHorasEnum.valueOf(estadoGrupos);
    }

    @JsonIgnore
    public void setEstadoGruposEnum(EstadoGrupoHorasEnum estadoGrupos) {
        if (estadoGrupos == null) {
            return;
        }
        this.estadoGrupos = estadoGrupos.name();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

//    public String getTipoCiclo() {
//        return tipoCiclo;
//    }
//
//    public void setTipoCiclo(String tipoCiclo) {
//        this.tipoCiclo = tipoCiclo;
//    }
//
//    public TipoCicloEnum getTipoCicloEnum() {
//        if (tipoCiclo == null) {
//            return null;
//        }
//        return TipoCicloEnum.valueOf(tipoCiclo);
//    }
//
//    @JsonIgnore
//    public void setTipoCicloEnum(TipoCicloEnum tipoCiclo) {
//        if (tipoCiclo == null) {
//            return;
//        }
//        this.tipoCiclo = tipoCiclo.name();
//    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTipoGrupoRegular() {
        if (TipoGrupoHorasEnum.REGULAR.name().equals(this.getTipo())) {
            return true;
        }
        return false;
    }

    public boolean isTipoGrupoZeta() {
        if (TipoGrupoHorasEnum.ZETA.name().equals(this.getTipo())) {
            return true;
        }
        return false;
    }

    public boolean isTipoGrupoEspecial() {
        if (TipoGrupoHorasEnum.ESPECIAL.name().equals(this.getTipo())) {
            return true;
        }
        return false;
    }

    public Boolean getTieneHoras() {
        if (tieneHoras == null) {
            return false;
        }
        return tieneHoras;
    }

    public void setTieneHoras(Boolean tieneHoras) {
        this.tieneHoras = tieneHoras;
    }

    public ObjectNode toJson() {
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ObjectNode jsonObj = JsonHelper.createJson(this, jsonFactory);
        jsonObj.put("esTipoGrupoRegular", this.isTipoGrupoRegular());
        jsonObj.put("esTipoGrupoZeta", this.isTipoGrupoZeta());
        jsonObj.put("esTipoGrupoEspecial", this.isTipoGrupoEspecial());
        return jsonObj;
    }

    @Override
    public String toString() {
        return "TipoGrupoHoras{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", tipo=" + tipo + ", estadoGrupos=" + estadoGrupos + ", estado=" + estado + ", tieneHoras=" + tieneHoras + '}';
    }

}
