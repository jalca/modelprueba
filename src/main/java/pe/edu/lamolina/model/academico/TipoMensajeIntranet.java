package pe.edu.lamolina.model.academico;

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
import pe.edu.lamolina.model.enums.TipoMensajeIntranetEnum;

@Entity
@Table(name = "aca_tipo_mensaje_intranet")
public class TipoMensajeIntranet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "tipo_pantalla")
    private String tipoPantalla;

    @Column(name = "boton")
    private String boton;

    @Column(name = "url")
    private String url;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_mensaje_medida")
//    private MensajeMedida mensajeMedida;
    public TipoMensajeIntranet() {
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

    public TipoMensajeIntranetEnum getCodigoEnum() {
        return TipoMensajeIntranetEnum.valueOf(codigo);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonIgnore
    public void setCodigoEnum(TipoMensajeIntranetEnum codigoEnum) {
        if (codigoEnum == null) {
            return;
        }
        this.codigo = codigoEnum.name();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


//    public MensajeMedida getMensajeMedida() {
//        return mensajeMedida;
//    }
//
//    public void setMensajeMedida(MensajeMedida mensajeMedida) {
//        this.mensajeMedida = mensajeMedida;
//    }
    public ObjectNode toJson() {

        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
//        MensajeMedida msjMedida = this.mensajeMedida == null ? new MensajeMedida() : this.mensajeMedida;

//        json.set("mensajeMedida", msjMedida.toJson());
        return json;
    }
}
