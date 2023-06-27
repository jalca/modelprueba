package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.agrupaciones.AprobacionEventoEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_aprobacion_evento_representante")
public class AprobacionEventoRepresentante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cargo_representante")
    private String cargoRepresentante;
    
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_aprobacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_agrupacion_alumnos")
    private EventoAgrupacionAlumnos eventoAgrupacionAlumnos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_representante_agrupacion")
    private RepresentanteAgrupacion representanteAgrupacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aprobacion")
    private Usuario userAprobacion;

    public AprobacionEventoRepresentante() {
    }

    public AprobacionEventoRepresentante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AprobacionEventoEstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return AprobacionEventoEstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(AprobacionEventoEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }
}
