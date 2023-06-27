package pe.edu.lamolina.model.general;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoDocIdentidadEnum;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Entity
@Table(name = "gen_tipo_doc_identidad")
public class TipoDocIdentidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "longitud")
    private Integer longitud;

    @Column(name = "longitud_exacta")
    private Integer longitudExacta;

    @Column(name = "es_tributario")
    private Boolean esTributario;

    @Column(name = "id_sunedu")
    private String sunedu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @OneToMany(mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private List<Persona> persona;

    public TipoDocIdentidad() {
    }

    public TipoDocIdentidadEnum getTipoDocIdentidadEnum() {
        if (simbolo == null) {
            return null;
        }
        return TipoDocIdentidadEnum.valueOf(simbolo);
    }

    public TipoDocIdentidad(Object id) {
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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getLongitudExacta() {
        return longitudExacta;
    }

    public void setLongitudExacta(Integer longitudExacta) {
        this.longitudExacta = longitudExacta;
    }

    public Boolean getEsTributario() {
        if (esTributario == null) {
            return false;
        }
        return esTributario;
    }

    public void setEsTributario(Boolean esTributario) {
        this.esTributario = esTributario;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getSunedu() {
        return sunedu;
    }

    public void setSunedu(String sunedu) {
        this.sunedu = sunedu;
    }
    
    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "simbolo", simbolo);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "longitud", longitud, false);
        ModelUtils.getDataByAttr(join, "longitudExacta", longitudExacta, false);
        ModelUtils.getDataByAttr(join, "esTributario", esTributario, false);
        ModelUtils.getDataByAttr(join, "sunedu", sunedu, false);
        ModelUtils.getDataByAttrObject(join, "pais", pais, "id", "codigo", "nombre");

        return join.toString();
    }


}
