package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Strings;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.edu.lamolina.model.enums.TipoActividadEscuelaEnum;

@Entity
@Table(name = "epg_actividad_admision_escuela")
public class ActividadAdmisionEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "tipo_enlace")
    private String tipoEnlace;

    @Column(name = "url_menu")
    private String urlMenu;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getTipoEnlace() {
        return tipoEnlace;
    }

    public void setTipoEnlace(String tipoEnlace) {
        this.tipoEnlace = tipoEnlace;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public void setCodigoEnum(TipoActividadEscuelaEnum tipoActividadEscuelaEnum) {
        if (tipoActividadEscuelaEnum == null) {
            this.codigo = null;
        }
        this.codigo = tipoActividadEscuelaEnum.name();
    }

    @JsonIgnore
    public TipoActividadEscuelaEnum getCodigoEnum() {
        if (Strings.isNullOrEmpty(this.codigo)) {
            return null;
        }
        return TipoActividadEscuelaEnum.valueOf(codigo);
    }

}
