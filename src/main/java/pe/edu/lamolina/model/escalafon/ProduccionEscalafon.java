package pe.edu.lamolina.model.escalafon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
import javax.persistence.Id;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.escalafon.enums.TipoProduccionEscaEnum;

@Entity
@Table(catalog = "lamolina", name = "esc_produccion_escalafon")
public class ProduccionEscalafon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "sub_tipo")
    private String subTipo;

    @Column(name = "titulo_fuente")
    private String tituloFuente;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autores")
    private String autores;

    @Column(name = "anio_produccion")
    private Integer anioProduccion;

    @Column(name = "url_repositorio")
    private String urlRepositorio;

    @Column(name = "confirmado")
    private Boolean confirmado;

    @Column(name = "nota_confirmacion")
    private String notaConfirmacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escalafon")
    private Escalafon escalafon;

    public ProduccionEscalafon() {
    }

    public ProduccionEscalafon(Object id) {
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

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getTituloFuente() {
        return tituloFuente;
    }

    public void setTituloFuente(String tituloFuente) {
        this.tituloFuente = tituloFuente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Integer getAnioProduccion() {
        return anioProduccion;
    }

    public void setAnioProduccion(Integer anioProduccion) {
        this.anioProduccion = anioProduccion;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getNotaConfirmacion() {
        return notaConfirmacion;
    }

    public void setNotaConfirmacion(String notaConfirmacion) {
        this.notaConfirmacion = notaConfirmacion;
    }

    public Escalafon getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Escalafon escalafon) {
        this.escalafon = escalafon;
    }

    public TipoProduccionEscaEnum getTipoProduccionEscaEnum() {
        if (StringUtils.isBlank(tipo)) {
            return null;
        }
        return TipoProduccionEscaEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoProduccionEscaEnum(TipoProduccionEscaEnum tipoEnum) {
        this.tipo = tipoEnum.name();
    }
}
