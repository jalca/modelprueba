package pe.edu.lamolina.model.seguridad;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.RolEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Getter
@Setter
@Entity
@Table(name = "seg_rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_superior")
    private Rol rolSuperior;

    @OneToMany(mappedBy = "rolSuperior", fetch = FetchType.LAZY)
    private List<Rol> rolesInferiores;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<UsuarioRol> usuarioRol;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<RolSistema> rolSistema;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<MenuRol> menuRol;

    public Rol() {
    }

    public Rol(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public RolEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        RolEnum rolEnum = null;
        try {
            rolEnum = RolEnum.valueOf(codigo);
        } catch (Exception e) {
        }
        return rolEnum;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre, false);
        ModelUtils.getDataByAttr(join, "codigo", codigo, false);
        ModelUtils.getDataByAttrObject(join, "rolSuperior", rolSuperior, "id", "codigo", "nombre");

        return join.toString();
    }

}
