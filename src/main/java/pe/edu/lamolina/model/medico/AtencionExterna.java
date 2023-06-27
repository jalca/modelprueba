package pe.edu.lamolina.model.medico;

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
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.AtencionExternaEnum;
import pe.edu.lamolina.model.enums.EstadoAtencionExternaEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "med_atencion_externa")
public class AtencionExterna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "consignado")
    private Boolean consignado;

    @Column(name = "estado")
    private String estado;

    @Column(name = "inmediato")
    private Boolean inmediato;

    @Column(name = "laboratorio_clinica")
    private String laboratorioClinica;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamiento")
    private String tratamiento;

    @Column(name = "fecha_planificada")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPlanificada;

    @Column(name = "fecha_realizada")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRealizada;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_resultado_atencion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaResultadoAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_atencion")
    private HistoriaAtencion historiaAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_laboratorio_externo")
    private LaboratorioExterno laboratorioExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_examen_auxiliar")
    private TipoExamenAuxiliar tipoExamenAuxiliar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoriaAtencion getHistoriaAtencion() {
        return historiaAtencion;
    }

    public void setHistoriaAtencion(HistoriaAtencion historiaAtencion) {
        this.historiaAtencion = historiaAtencion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonIgnore
    public void setTipoEnum(AtencionExternaEnum tipo) {
        this.tipo = tipo.name();
    }

    public AtencionExternaEnum getTipoEnum() {
        if (StringUtils.isBlank(tipo)) {
            return null;
        }
        return AtencionExternaEnum.valueOf(tipo);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(EstadoAtencionExternaEnum estado) {
        this.estado = estado.name();
    }

    public EstadoAtencionExternaEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoAtencionExternaEnum.valueOf(estado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getConsignado() {
        return consignado;
    }

    public void setConsignado(Boolean consignado) {
        this.consignado = consignado;
    }

    public Boolean getInmediato() {
        return inmediato;
    }

    public void setInmediato(Boolean inmediato) {
        this.inmediato = inmediato;
    }

    public Date getFechaPlanificada() {
        return fechaPlanificada;
    }

    public void setFechaPlanificada(Date fechaPlanificada) {
        this.fechaPlanificada = fechaPlanificada;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public String getLaboratorioClinica() {
        return laboratorioClinica;
    }

    public void setLaboratorioClinica(String laboratorioClinica) {
        this.laboratorioClinica = laboratorioClinica;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
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

    public Date getFechaResultadoAtencion() {
        return fechaResultadoAtencion;
    }

    public void setFechaResultadoAtencion(Date fechaResultadoAtencion) {
        this.fechaResultadoAtencion = fechaResultadoAtencion;
    }

    public LaboratorioExterno getLaboratorioExterno() {
        return laboratorioExterno;
    }

    public void setLaboratorioExterno(LaboratorioExterno laboratorioExterno) {
        this.laboratorioExterno = laboratorioExterno;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public TipoExamenAuxiliar getTipoExamenAuxiliar() {
        return tipoExamenAuxiliar;
    }

    public void setTipoExamenAuxiliar(TipoExamenAuxiliar tipoExamenAuxiliar) {
        this.tipoExamenAuxiliar = tipoExamenAuxiliar;
    }

}
