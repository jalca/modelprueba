package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_vivienda")
public class PersonaVivienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "otro_tipo_vivienda")
    private String otroTipoVivienda;

    @Column(name = "otra_tenencia")
    private String otraTenencia;

    @Column(name = "otro_material_vivienda")
    private String otroMaterialVivienda;

    @Column(name = "otro_servicio_agua")
    private String otroServicioAgua;

    @Column(name = "otro_desague")
    private String otroDesague;

    @Column(name = "otros_bienes_familia")
    private String otrosBienesFamilia;

    @Column(name = "tiene_alumbrado")
    private Integer tieneAlumbrado;

    @Column(name = "comentario_vivienda")
    private String comentarioVivienda;

    @Column(name = "costo_alquiler")
    private BigDecimal costoAlquiler;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vivienda")
    private TipoVivienda tipoVivienda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tenencia")
    private Tenencia tenencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_material_vivienda")
    private MaterialVivienda materialVivienda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_condicion_vivienda")
    private CondicionVivienda condicionVivienda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio_agua")
    private ServicioAgua servicioAgua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desague")
    private Desague desague;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lugar_residencia")
    private LugarResidencia lugarResidencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public PersonaVivienda() {
    }

    public PersonaVivienda(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getComentarioTipoVivienda() {
        if (this.tipoVivienda == null) {
            return null;
        }
        if (this.tipoVivienda.getConComentario() == null) {
            return null;
        }
        if (this.tipoVivienda.getConComentario() == 1) {
            return this.otroTipoVivienda;
        }
        return null;
    }

    public String getComentarioTenencia() {
        if (this.tenencia == null) {
            return null;
        }
        if (this.tenencia.getConComentario() == null) {
            return null;
        }
        if (this.tenencia.getConComentario() == 1) {
            return this.otraTenencia;
        }
        return null;
    }

    public String getComentarioMaterialVivienda() {
        if (this.materialVivienda == null) {
            return null;
        }
        if (this.materialVivienda.getConComentario() == null) {
            return null;
        }
        if (this.materialVivienda.getConComentario() == 1) {
            return this.otroMaterialVivienda;
        }
        return null;
    }

    public String getComentarioServicioAgua() {
        if (this.servicioAgua == null) {
            return null;
        }
        if (this.servicioAgua.getConComentario() == null) {
            return null;
        }
        if (this.servicioAgua.getConComentario() == 1) {
            return this.otroServicioAgua;
        }
        return null;
    }

    public String getComentarioDesague() {
        if (this.desague == null) {
            return null;
        }
        if (this.desague.getConComentario() == null) {
            return null;
        }
        if (this.desague.getConComentario() == 1) {
            return this.otroDesague;
        }
        return null;
    }

    public String getComentarioCondicionVivienda() {
        if (this.condicionVivienda == null) {
            return null;
        }
        if (this.condicionVivienda.getConComentario() == null) {
            return null;
        }
        if (this.condicionVivienda.getConComentario() == 1) {
            return this.comentarioVivienda;
        }
        return null;
    }

    public BigDecimal getComentarioAlquiler() {
        if (this.tenencia == null) {
            return null;
        }
        if (this.tenencia.getEsAlquiler() == null) {
            return null;
        }
        if (this.tenencia.getEsAlquiler() == 1) {
            return this.costoAlquiler;
        }
        return null;
    }

    @Override
    public PersonaVivienda clone() {
        PersonaVivienda clone = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JaneHelper
                    .from(this)
                    .only("id,otroTipoVivienda,otraTenencia,otroMaterialVivienda,otroServicioAgua,otroDesague,otrosBienesFamilia,tieneAlumbrado,comentarioVivienda,costoAlquiler,fechaRegistro,fechaModificacion")
                    .join("persona", "id")
                    .join("cicloAcademico", "id")
                    .join("tipoVivienda")
                    .join("tenencia")
                    .join("materialVivienda")
                    .join("condicionVivienda")
                    .join("servicioAgua")
                    .join("desague")
                    .join("lugarResidencia")
                    .join("userRegistro", "id")
                    .join("userModificacion", "id")
                    .json();

            clone = objectMapper.readValue(json.toString(), this.getClass());
            return clone;

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return clone;
    }

}
