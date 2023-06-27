package pe.edu.lamolina.model.bienestar;

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
import pe.edu.lamolina.model.contabilidad.PartidaPresupuestal;
import pe.edu.lamolina.model.contabilidad.PresupuestoAgrupacionAlumnos;
import pe.edu.lamolina.model.enums.agrupaciones.TipoAgrupacionAlumnosEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "obu_agrupacion_alumnos")
public class AgrupacionAlumnos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<RepresentanteAgrupacion> representantes;
    
    @Transient
    private RepresentanteAgrupacion cargoAlumno;

    @Transient
    private List<EventoAgrupacionAlumnos> eventosAgrupaciones;

    @Transient
    private PartidaPresupuestal partidaSuperior;

    @Transient
    private PartidaPresupuestal partidaAsignada;

    @Transient
    private PresupuestoAgrupacionAlumnos presupuestoYearCiclo;

    @Transient
    private Boolean asignarPartidaPresupuestal;

    public AgrupacionAlumnos() {
    }

    public AgrupacionAlumnos(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoAgrupacionAlumnosEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoAgrupacionAlumnosEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoAgrupacionAlumnosEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }
}
