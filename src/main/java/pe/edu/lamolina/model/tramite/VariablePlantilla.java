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
import org.hibernate.annotations.Type;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "tram_variable_plantilla")
public class VariablePlantilla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ejemplo")
    private String ejemplo;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "es_parametro")
    private Boolean esParametro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla_documento")
    private PlantillaDocumentoAcademico plantillaDocumentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_variable_generica")
    private VariableGenerica variableGenerica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public VariablePlantilla() {
    }

    public VariablePlantilla(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public PlantillaDocumentoAcademico getPlantillaDocumentoAcademico() {
        return plantillaDocumentoAcademico;
    }

    public void setPlantillaDocumentoAcademico(PlantillaDocumentoAcademico plantillaDocumentoAcademico) {
        this.plantillaDocumentoAcademico = plantillaDocumentoAcademico;
    }

    public VariableGenerica getVariableGenerica() {
        return variableGenerica;
    }

    public void setVariableGenerica(VariableGenerica variableGenerica) {
        this.variableGenerica = variableGenerica;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public Boolean getEsParametro() {
        return esParametro;
    }

    public void setEsParametro(Boolean esParametro) {
        if (esParametro == null) {
            this.esParametro = false;
        } else {
            this.esParametro = esParametro;

        }
    }

}
