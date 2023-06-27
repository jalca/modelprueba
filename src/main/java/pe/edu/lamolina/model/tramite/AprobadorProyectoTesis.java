package pe.edu.lamolina.model.tramite;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoAprobadorTesisEnum;
import pe.edu.lamolina.model.enums.TipoMiembroComiteEnum;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.graduacion.MiembroComiteConsejero;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_aprobador_proyecto_tesis")
public class AprobadorProyectoTesis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "orden_aprobacion")
    private Integer ordenAprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_aprobador")
    private Persona personaAprobador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto_tesis")
    private ProyectoTesis proyectoTesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembro_comite_consejero")
    private MiembroComiteConsejero miembroComiteConsejero;

    @Column(name = "fecha_aprobacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_aprobacion")
    private Usuario userAprobacion;

    public AprobadorProyectoTesis() {
    }

    public AprobadorProyectoTesis(Object id) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersonaAprobador() {
        return personaAprobador;
    }

    public void setPersonaAprobador(Persona personaAprobador) {
        this.personaAprobador = personaAprobador;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public ProyectoTesis getProyectoTesis() {
        return proyectoTesis;
    }

    public void setProyectoTesis(ProyectoTesis proyectoTesis) {
        this.proyectoTesis = proyectoTesis;
    }

    public MiembroComiteConsejero getMiembroComiteConsejero() {
        return miembroComiteConsejero;
    }

    public void setMiembroComiteConsejero(MiembroComiteConsejero miembroComiteConsejero) {
        this.miembroComiteConsejero = miembroComiteConsejero;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Usuario getUserAprobacion() {
        return userAprobacion;
    }

    public void setUserAprobacion(Usuario userAprobacion) {
        this.userAprobacion = userAprobacion;
    }

    public TipoMiembroComiteEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoMiembroComiteEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipo(TipoMiembroComiteEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public EstadoAprobadorTesisEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoAprobadorTesisEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAprobadorTesisEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Integer getOrdenAprobacion() {
        return ordenAprobacion;
    }

    public void setOrdenAprobacion(Integer ordenAprobacion) {
        this.ordenAprobacion = ordenAprobacion;
    }

}
