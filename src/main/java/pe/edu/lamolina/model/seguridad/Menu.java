package pe.edu.lamolina.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.MenuTipoEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Getter
@Setter
@Table(name = "seg_menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "icono")
    private String icono;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "clave")
    private String clave;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "entornos")
    private String entornos;

    @Column(name = "modalidades")
    private String modalidades;

    @Column(name = "bucle_activar")
    private String bucleActivar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sistema")
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_superior")
    private Menu menuSuperior;

    @OneToMany(mappedBy = "menuSuperior", fetch = FetchType.LAZY)
    private List<Menu> menus;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<MenuRol> menuRol;

    @Transient
    private String estado;
    @Transient
    private String pregrado;
    @Transient
    private String posgrado;
    @Transient
    private String especial;
    @Transient
    private String visitante;

    public Menu() {
    }

    public Menu(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    private String getRutaPadre(Menu menu) {
        String rutaPadre = "";
        if (menu.getMenuSuperior() != null) {
            rutaPadre = getRutaPadre(menu.menuSuperior);
        }
        return rutaPadre + (rutaPadre.equals("") ? "" : "\\") + menu.getNombre();
    }

    public String getRutaPadre() {
        if (this.getMenuSuperior() == null) {
            return "";
        }
        return getRutaPadre(this.getMenuSuperior());
    }

    public String getRutaCompleta() {
        return getRutaPadre(this);
    }

    public MenuTipoEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return MenuTipoEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(MenuTipoEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public String getIconoClass(String htmlClass) {
        if (StringUtils.isBlank(this.icono)) {
            return null;
        }
        return htmlClass + " " + this.icono;
    }

    public static class CompareOrden implements Comparator<Menu> {

        @Override
        public int compare(Menu menu1, Menu menu2) {
            return menu1.getOrden().compareTo(menu2.getOrden());
        }
    }

    public EstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre, false);
        ModelUtils.getDataByAttr(join, "icono", icono, false);
        ModelUtils.getDataByAttr(join, "ruta", ruta, false);
        ModelUtils.getDataByAttr(join, "tipo", tipo, false);
        ModelUtils.getDataByAttr(join, "clave", clave, false);
        ModelUtils.getDataByAttr(join, "orden", orden, false);
        ModelUtils.getDataByAttr(join, "entornos", entornos, false);
        ModelUtils.getDataByAttr(join, "modalidades", modalidades, false);
        ModelUtils.getDataByAttr(join, "bucleActivar", bucleActivar, false);
        ModelUtils.getDataByAttrObject(join, "sistema", sistema, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "menuSuperior", menuSuperior, "id", "nombre", "tipo", "ruta");

        return join.toString();
    }

}
