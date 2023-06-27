package pe.edu.lamolina.model.medico;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.enums.CitaConsultorioEstadoEnum;
import pe.edu.lamolina.model.enums.InyectableEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "med_atencion_topico")
public class AtencionTopico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atencion_consultorio")
    private AtencionConsultorio atencionConsultorio;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "otro_topico")
    private String otroTopico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_topico")
    private TipoTopico tipoTopico;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_inyectable")
    private String tipoInyectable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @OneToMany(mappedBy = "atencionTopico", fetch = FetchType.LAZY)
    private List<ParametroPaciente> parametroPaciente;

    public AtencionTopico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtencionConsultorio getAtencionConsultorio() {
        return atencionConsultorio;
    }

    public void setAtencionConsultorio(AtencionConsultorio atencionConsultorio) {
        this.atencionConsultorio = atencionConsultorio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOtroTopico() {
        return otroTopico;
    }

    public void setOtroTopico(String otroTopico) {
        this.otroTopico = otroTopico;
    }

    public TipoTopico getTipoTopico() {
        return tipoTopico;
    }

    public void setTipoTopico(TipoTopico tipoTopico) {
        this.tipoTopico = tipoTopico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public CitaConsultorioEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return CitaConsultorioEstadoEnum.valueOf(estado);
    }

    public void setEstado(CitaConsultorioEstadoEnum estado) {
        this.estado = estado.name();
    }

    public String getTipoInyectable() {
        return tipoInyectable;
    }

    public InyectableEnum getTipoInyectableEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return InyectableEnum.valueOf(estado);
    }

    public void setTipoInyectable(InyectableEnum tipoInyectable) {
        if (tipoInyectable == null) {
            this.tipoInyectable = null;
        } else {
            this.tipoInyectable = tipoInyectable.name();
        }
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

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<ParametroPaciente> getParametroPaciente() {
        return parametroPaciente;
    }

    public void setParametroPaciente(List<ParametroPaciente> parametroPaciente) {
        this.parametroPaciente = parametroPaciente;
    }

}
