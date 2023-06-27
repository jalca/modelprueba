package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoDocumentoCompaniaEnum;

@Entity
@Table(name = "gen_tipo_documento_compania")
public class TipoDocumentoCompania implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "requiere_cia")
    private Boolean requiereCia;

    @Column(name = "activo_documental")
    private Boolean activoDocumental;

    public TipoDocumentoCompania() {
    }

    public TipoDocumentoCompania(Object id) {
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

    public TipoDocumentoCompaniaEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        TipoDocumentoCompaniaEnum envm = null;
        try {
            envm = TipoDocumentoCompaniaEnum.valueOf(codigo);
        } catch (Exception e) {
        }
        return envm;
    }

    @JsonIgnore
    public void setCodigoEnum(TipoDocumentoCompaniaEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Boolean getRequiereCia() {
        return requiereCia;
    }

    public void setRequiereCia(Boolean requiereCia) {
        this.requiereCia = requiereCia;
    }

    public Boolean getActivoDocumental() {
        return activoDocumental;
    }

    public void setActivoDocumental(Boolean activoDocumental) {
        this.activoDocumental = activoDocumental;
    }

}
