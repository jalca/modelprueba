package pe.edu.lamolina.model.posgrado.admision;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CondicionAdmitidoEnum;

@Entity
@Table(name = "epg_condicion_admitido_escuela")
public class CondicionAdmitidoEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    public CondicionAdmitidoEscuela() {
    }

    public CondicionAdmitidoEscuela(Object id) {
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

    public CondicionAdmitidoEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return CondicionAdmitidoEnum.valueOf(codigo);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{id:" + this.id + ", codigo:\"" + this.codigo + "\", nombre:\"" + this.nombre + "\"}";
    }

}
