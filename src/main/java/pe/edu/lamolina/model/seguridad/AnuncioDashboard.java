package pe.edu.lamolina.model.seguridad;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.activadorficha.TipoVigenciaEnum;
import pe.edu.lamolina.model.enums.anunciodashboard.TipoAnuncioEnum;
import pe.edu.lamolina.model.enums.anunciodashboard.TipoEnlacePredefinidoEnum;
import pe.edu.lamolina.model.enums.anunciodashboard.TipoRastreoRespuestaEnum;
import pe.edu.lamolina.model.enums.anunciodashboard.TipoRespuestaAnuncioEnum;
import pe.edu.lamolina.model.enums.anunciodashboard.TipoTargetUrlEnum;
import pe.edu.lamolina.model.examen.EncuestaPublicada;
import pe.edu.lamolina.model.examen.GrupoObjetivo;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.socioeconomico.ActivadorFicha;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "seg_anuncio_dashboard")
public class AnuncioDashboard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "color_tipo")
    private String colorTipo;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "target_url")
    private String targetUrl;

    @Column(name = "texto_boton")
    private String textoBoton;

    @Column(name = "color_boton")
    private String colorBoton;

    @Column(name = "columnas")
    private Integer columnas;

    @Column(name = "icono")
    private String icono;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "tipo_respuesta")
    private String tipoRespuesta;

    @Column(name = "tipo_rastreo_respuesta")
    private String tipoRastreoRespuesta;

    @Column(name = "veces_visible")
    private Integer vecesVisible;

    @Column(name = "veces_clics")
    private Integer vecesClics;

    @Column(name = "audiencia")
    private Integer audiencia;

    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFin;

    @Column(name = "fecha_primer_clic")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaPrimerClic;

    @Column(name = "fecha_ultimo_clic")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaUltimoClic;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sistema")
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_activador_ficha")
    private ActivadorFicha activadorFicha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_publicada")
    private EncuestaPublicada encuestaPublicada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<GrupoObjetivo> gruposObjetivos;

    public AnuncioDashboard(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoEnum getEstadoEnum() {
        if (this.estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoRastreoRespuestaEnum getTipoRastreoRespuestaEnum() {
        if (this.tipoRastreoRespuesta == null) {
            return null;
        }
        return TipoRastreoRespuestaEnum.valueOf(this.tipoRastreoRespuesta);
    }

    @JsonIgnore
    public void setTipoRastreoRespuestaEnum(TipoRastreoRespuestaEnum tipoRastreoRespuesta) {
        if (tipoRastreoRespuesta == null) {
            return;
        }
        this.tipoRastreoRespuesta = tipoRastreoRespuesta.name();
    }

    public TipoAnuncioEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoAnuncioEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipoEnum(TipoAnuncioEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public TipoRespuestaAnuncioEnum getTipoRespuestaEnum() {
        if (this.tipoRespuesta == null) {
            return null;
        }
        return TipoRespuestaAnuncioEnum.valueOf(this.tipoRespuesta);
    }

    @JsonIgnore
    public void setTipoRespuestaEnum(TipoRespuestaAnuncioEnum tipoRespuesta) {
        if (tipoRespuesta == null) {
            return;
        }
        this.tipoRespuesta = tipoRespuesta.name();
    }

    public TipoTargetUrlEnum getTargetUrlEnum() {
        if (this.targetUrl == null) {
            return null;
        }
        return TipoTargetUrlEnum.valueOf(this.targetUrl);
    }

    @JsonIgnore
    public void setTargetUrlEnum(TipoTargetUrlEnum targetUrl) {
        if (targetUrl == null) {
            return;
        }
        this.targetUrl = targetUrl.name();
    }

    public TipoVigenciaEnum getVigenciaEnum() {
        Date hoy = new LocalDate().toDate();
        Date fin = this.fechaFin;
        if (fin == null) {
            fin = new LocalDate(hoy).plusDays(5).toDate();
        }

        if (hoy.compareTo(this.fechaInicio) >= 0
                && hoy.compareTo(fin) <= 0) {
            return TipoVigenciaEnum.VIGENTE;
        }

        if (hoy.compareTo(fin) > 0) {
            return TipoVigenciaEnum.PASADO;
        }

        return TipoVigenciaEnum.FUTURO;
    }

    public TipoEnlacePredefinidoEnum getTipoEnlaceEnum() {
        if (this.encuestaPublicada != null) {
            return TipoEnlacePredefinidoEnum.ENCUESTA;
        }
        if (this.activadorFicha != null) {
            return TipoEnlacePredefinidoEnum.FICHA_SEC;
        }

        return TipoEnlacePredefinidoEnum.NINGUNO;
    }

    public String getTipoEnlace() {
        if (this.encuestaPublicada != null) {
            return TipoEnlacePredefinidoEnum.ENCUESTA.name();
        }
        if (this.activadorFicha != null) {
            return TipoEnlacePredefinidoEnum.FICHA_SEC.name();
        }

        return TipoEnlacePredefinidoEnum.NINGUNO.name();
    }

}
