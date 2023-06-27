package pe.edu.lamolina.model.cms;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.cms.enums.TipoUbicacionEnum;

@Entity
@Table(catalog = "lamolina", name = "cms_ubicacion_bloque")
public class UbicacionBloque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "instancia")
    private Long instancia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bloque")
    private Bloque bloque;

    public UbicacionBloque() {
    }

    public UbicacionBloque(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoUbicacionEnum getTipoEnum() {
        return TipoUbicacionEnum.valueOf(tipo);
    }

    public void setTipoEnum(TipoUbicacionEnum tipo) {
        this.tipo = tipo.name();
    }

    public Long getInstancia() {
        return instancia;
    }

    public void setInstancia(Long instancia) {
        this.instancia = instancia;
    }

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

}
