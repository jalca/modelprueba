package pe.edu.lamolina.model.tramite;

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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.TipoRetiroCicloEnum;
import pe.edu.lamolina.model.enums.TramiteEstadoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "tram_retiro_ciclo")
public class RetiroCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "es_condicional")
    private Boolean esCondicional;

    @Column(name = "es_contable")
    private Boolean esContable;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_registro")
    private CicloAcademico cicloRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @Transient
    private List<Alumno> alumnos;

    @Transient
    private List<Archivo> archivos;

    @Transient
    private List<SustentoRetiroCiclo> sustentos;

    @Transient
    private Boolean aplicado;

    @Transient
    private boolean seleccionado;

    @Transient
    private boolean rechazado;

    public RetiroCiclo() {
        this.esCondicional = false;
    }

    public RetiroCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
        this.esCondicional = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getEstado() {
        return estado;
    }

    public TramiteEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return TramiteEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TramiteEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public CicloAcademico getCicloRegistro() {
        return cicloRegistro;
    }

    public void setCicloRegistro(CicloAcademico cicloRegistro) {
        this.cicloRegistro = cicloRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoRetiroCicloEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoRetiroCicloEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoRetiroCicloEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getEsCondicional() {
        if (esCondicional == null) {
            return false;
        }
        return esCondicional;
    }

    public void setEsCondicional(Boolean esCondicional) {
        this.esCondicional = esCondicional;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

    public EstadoTramite getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public List<SustentoRetiroCiclo> getSustentos() {
        return sustentos;
    }

    public void setSustentos(List<SustentoRetiroCiclo> sustentos) {
        this.sustentos = sustentos;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isRechazado() {
        return rechazado;
    }

    public void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }

    public Boolean getAplicado() {
        return aplicado;
    }

    public void setAplicado(Boolean aplicado) {
        this.aplicado = aplicado;
    }

    public Boolean getEsContable() {
        return esContable;
    }

    public void setEsContable(Boolean esContable) {
        this.esContable = esContable;
    }

}
