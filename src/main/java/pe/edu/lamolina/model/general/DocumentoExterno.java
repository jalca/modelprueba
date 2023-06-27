package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.albatross.zelpers.spring.deserializer.DateDeserializer;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "gen_documento_externo")
public class DocumentoExterno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;

    @Column(name = "numero_visual")
    private String numeroVisual;

    @Column(name = "fecha_documento")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaDocumento;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_compania")
    private TipoDocumentoCompania tipoDocumentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public DocumentoExterno() {
    }

    public DocumentoExterno(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoDocumentoCompania getTipoDocumentoCompania() {
        return tipoDocumentoCompania;
    }

    public void setTipoDocumentoCompania(TipoDocumentoCompania tipoDocumentoCompania) {
        this.tipoDocumentoCompania = tipoDocumentoCompania;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        if (StringUtils.isBlank(numeroVisual)) {
            return numero;
        }
        return numeroVisual;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public String getNumeroVisual() {
        return numeroVisual;
    }

    public void setNumeroVisual(String numeroVisual) {
        this.numeroVisual = numeroVisual;
    }

    public String getDescripcion() {
        if (this.tipoDocumentoCompania == null) {
            return null;
        }
        if (this.numero == null) {
            return null;
        }
        if (this.serie == null) {
            return null;
        }
        if (StringUtils.isBlank(this.numeroVisual)) {
            return this.numero + "-" + this.serie + "/" + this.tipoDocumentoCompania.getSimbolo();
        }
        return this.numeroVisual + "/" + this.tipoDocumentoCompania.getSimbolo();
    }

}
