package pe.edu.lamolina.model.tramite;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_tramite_documento_parametro")
public class TramiteDocumentoParametro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecharegistro;

    @Column(name = "valor")
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_variable_generica")
    private VariableGenerica variableGenerica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla_documento_academico")
    private PlantillaDocumentoAcademico plantillaDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite_documento_academico")
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuario;

    public TramiteDocumentoParametro() {
    }

    public TramiteDocumentoParametro(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TramiteDocumentoParametro(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public VariableGenerica getVariableGenerica() {
        return variableGenerica;
    }

    public void setVariableGenerica(VariableGenerica variableGenerica) {
        this.variableGenerica = variableGenerica;
    }

    public PlantillaDocumentoAcademico getPlantillaDocumento() {
        return plantillaDocumento;
    }

    public void setPlantillaDocumento(PlantillaDocumentoAcademico plantillaDocumento) {
        this.plantillaDocumento = plantillaDocumento;
    }

    public TipoDocumentoAcademico getTipoDocumentoAcademico() {
        return tipoDocumentoAcademico;
    }

    public void setTipoDocumentoAcademico(TipoDocumentoAcademico tipoDocumentoAcademico) {
        this.tipoDocumentoAcademico = tipoDocumentoAcademico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
