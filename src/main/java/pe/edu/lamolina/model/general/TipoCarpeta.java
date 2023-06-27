package pe.edu.lamolina.model.general;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "gen_tipo_carpeta")
public class TipoCarpeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "buscar_aula")
    private Integer buscarAula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta_superior")
    private TipoCarpeta tipoCarpetaSuperior;

    @OneToMany(mappedBy = "tipoCarpetaSuperior", fetch = FetchType.LAZY)
    private List<TipoCarpeta> tipoCarpetas;

    @Transient
    private boolean tipoCarpetaPadre;

    public TipoCarpeta() {
    }

    public TipoCarpeta(Object id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBuscarAula() {
        return buscarAula;
    }

    public void setBuscarAula(Integer buscarAula) {
        this.buscarAula = buscarAula;
    }

    public TipoCarpeta getTipoCarpetaSuperior() {
        return tipoCarpetaSuperior;
    }

    public void setTipoCarpetaSuperior(TipoCarpeta tipoCarpetaSuperior) {
        this.tipoCarpetaSuperior = tipoCarpetaSuperior;
    }

    public List<TipoCarpeta> getTipoCarpetas() {
        return tipoCarpetas;
    }

    public void setTipoCarpetas(List<TipoCarpeta> tipoCarpetas) {
        this.tipoCarpetas = tipoCarpetas;
    }

    public boolean isTipoCarpetaPadre() {
        return tipoCarpetaPadre;
    }

    public void setTipoCarpetaPadre(boolean tipoCarpetaPadre) {
        this.tipoCarpetaPadre = tipoCarpetaPadre;
    }

    @Override
    public String toString() {
        return "TipoCarpeta{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TipoCarpeta)) {
            return false;
        }
        final TipoCarpeta other = (TipoCarpeta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
