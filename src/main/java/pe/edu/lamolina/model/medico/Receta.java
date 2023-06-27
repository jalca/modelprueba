package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.RecetaEstadoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "med_receta")
public class Receta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "indicacion")
    private String indicacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_receta")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaReceta;

    @Column(name = "fecha_entrega")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_entrega")
    private Usuario userEntrega;

    @Transient
    private List<RecetaDetalle> recetaDetalle;

    @Transient
    private Persona persona;

    public Receta() {

    }

    public Receta(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public RecetaEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return RecetaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(RecetaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

}
