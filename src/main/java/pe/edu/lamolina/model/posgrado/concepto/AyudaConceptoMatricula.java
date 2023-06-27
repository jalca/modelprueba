package pe.edu.lamolina.model.posgrado.concepto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.edu.lamolina.model.posgrado.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoAyudaConceptoMatriculaEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_ayuda_concepto_matricula")
public class AyudaConceptoMatricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_autoriza")
    private Persona personaAutoriza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_resumen_cuotas")
    private AlumnoResumenCuotas alumnoResumenCuotas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ayuda_posgrado")
    private TipoAyudaPosgrado tipoAyudaPosgrado;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;
    
    @Transient
    private Boolean seleccionado;
    
    @Transient
    private List<AyudaConceptoMatricula> ayudas;

    public AyudaConceptoMatricula() {
    }

    public AyudaConceptoMatricula(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public Persona getPersonaAutoriza() {
        return personaAutoriza;
    }

    public void setPersonaAutoriza(Persona personaAutoriza) {
        this.personaAutoriza = personaAutoriza;
    }

    public TipoAyudaPosgrado getTipoAyudaPosgrado() {
        return tipoAyudaPosgrado;
    }

    public void setTipoAyudaPosgrado(TipoAyudaPosgrado tipoAyudaPosgrado) {
        this.tipoAyudaPosgrado = tipoAyudaPosgrado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(Usuario userCreacion) {
        this.userCreacion = userCreacion;
    }

    public EstadoAyudaConceptoMatriculaEnum getEstadoEnum() {
        if (StringUtils.isBlank(this.estado)) {
            return null;
        }
        return EstadoAyudaConceptoMatriculaEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoAyudaConceptoMatriculaEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<AyudaConceptoMatricula> getAyudas() {
        return ayudas;
    }

    public void setAyudas(List<AyudaConceptoMatricula> ayudas) {
        this.ayudas = ayudas;
    }

    public AlumnoResumenCuotas getAlumnoResumenCuotas() {
        return alumnoResumenCuotas;
    }

    public void setAlumnoResumenCuotas(AlumnoResumenCuotas alumnoResumenCuotas) {
        this.alumnoResumenCuotas = alumnoResumenCuotas;
    }
 
}
