package pe.edu.lamolina.model.academico;

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
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "aca_mensaje_intranet")
public class MensajeIntranet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "por_fecha")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean porFecha;

    @Column(name = "es_obligatorio")
    private Integer esObligatorio;

    @Column(name = "es_mensaje_appmovil")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean esMensajeAppmovil;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "con_cronograma")
    private Integer conCronograma;

    @Column(name = "veces_visible")
    private Integer vecesVisible;

//    @Column(name = "pre_obligatorio")
//    private Integer preObligatorio;
    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "fecha_inicio_obligatoriedad")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicioObligatoriedad;

    @Column(name = "fecha_fin_obligatoriedad")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFinObligatoriedad;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_alumno")
    private GrupoAlumno grupoAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_mensaje")
    private TipoMensajeIntranet tipoMensajeIntranet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private String contenidoHtml;
    @Transient
    private Integer visualizado;
    @Transient
    private String arryNodeMgsExtras;
    @Transient
    private Boolean omitir;

    public MensajeIntranet() {
        this.visualizado = 0;
    }

    public MensajeIntranet(Object id) {
        this.visualizado = 0;
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(Integer esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getConCronograma() {
        return conCronograma;
    }

    public void setConCronograma(Integer conCronograma) {
        this.conCronograma = conCronograma;
    }

    public Integer getVecesVisible() {
        return vecesVisible;
    }

    public void setVecesVisible(Integer vecesVisible) {
        this.vecesVisible = vecesVisible;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public GrupoAlumno getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(GrupoAlumno grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    public TipoMensajeIntranet getTipoMensajeIntranet() {
        return tipoMensajeIntranet;
    }

    public void setTipoMensajeIntranet(TipoMensajeIntranet tipoMensajeIntranet) {
        this.tipoMensajeIntranet = tipoMensajeIntranet;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getContenidoHtml() {
        return contenidoHtml;
    }

    public void setContenidoHtml(String contenidoHtml) {
        this.contenidoHtml = contenidoHtml;
    }

    public Integer getVisualizado() {
        return visualizado;
    }

    public void setVisualizado(Integer visualizado) {
        this.visualizado = visualizado;
    }

    public String getArryNodeMgsExtras() {
        return arryNodeMgsExtras;
    }

    public void setArryNodeMgsExtras(String arryNodeMgsExtras) {
        this.arryNodeMgsExtras = arryNodeMgsExtras;
    }

//    public Integer getPreObligatorio() {
//        if (preObligatorio == null) {
//            return 0;
//        }
//        return preObligatorio;
//    }
//
//    public void setPreObligatorio(Integer preObligatorio) {
//        this.preObligatorio = preObligatorio;
//    }
    public Boolean getPorFecha() {
        if (porFecha == null) {
            return false;
        }
        return porFecha;
    }

    public void setPorFecha(Boolean porFecha) {
        if (porFecha == null) {
            this.porFecha = false;
        }
        this.porFecha = porFecha;
    }

    public Date getFechaInicioObligatoriedad() {
        return fechaInicioObligatoriedad;
    }

    public void setFechaInicioObligatoriedad(Date fechaInicioObligatoriedad) {
        this.fechaInicioObligatoriedad = fechaInicioObligatoriedad;
    }

    public Date getFechaFinObligatoriedad() {
        return fechaFinObligatoriedad;
    }

    public void setFechaFinObligatoriedad(Date fechaFinObligatoriedad) {
        this.fechaFinObligatoriedad = fechaFinObligatoriedad;
    }

    public Boolean getOmitir() {
        return omitir;
    }

    public void setOmitir(Boolean omitir) {
        this.omitir = omitir;
    }

    public Boolean getEsMensajeAppmovil() {
        if (esMensajeAppmovil == null) {
            return false;
        }
        return esMensajeAppmovil;
    }

    public void setEsMensajeAppmovil(Boolean esMensajeAppmovil) {
        this.esMensajeAppmovil = esMensajeAppmovil;
    }

}
