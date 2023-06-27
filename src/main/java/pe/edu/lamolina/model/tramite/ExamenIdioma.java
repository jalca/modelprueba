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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoAprobadorTesisEnum;
import pe.edu.lamolina.model.enums.NivelIdiomaEnum;
import pe.edu.lamolina.model.enums.TipoCertificacionEnum;
import pe.edu.lamolina.model.general.DocumentoCompania;
import pe.edu.lamolina.model.general.DocumentoExterno;
import pe.edu.lamolina.model.general.EmpresaEtiquetada;
import pe.edu.lamolina.model.general.Idioma;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "epg_examen_idioma")
public class ExamenIdioma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_certificacion")
    private String tipoCertificacion;

    @Column(name = "no_calendarizado")
    private Integer noCalendarizado;

    @Column(name = "otro_centro_idiomas")
    private String otroCentroIdiomas;

    @Column(name = "nivel_idioma")
    private String nivelIdioma;

    @Column(name = "nota")
    private String nota;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reunion_comite_evaluador")
    private ReunionComiteEvaluador reunionComiteEvaluador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_compania")
    private DocumentoCompania documentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_externo")
    private DocumentoExterno documentoExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro_idiomas")
    private EmpresaEtiquetada centroIdiomas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public ExamenIdioma(Idioma idioma, TipoCertificacionEnum tipoCertificacionEnum, Integer noCalendarizado) {
        this.tipoCertificacion = tipoCertificacionEnum.name();
        this.noCalendarizado = noCalendarizado;
        this.idioma = idioma;
    }

    public ExamenIdioma(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public TipoCertificacionEnum getTipoCertificacionEnum() {
        if (tipoCertificacion == null) {
            return null;
        }
        return TipoCertificacionEnum.valueOf(tipoCertificacion);

    }

    @JsonIgnore
    public void setTipoCertificacionEnum(TipoCertificacionEnum estadoEnum) {
        if (estadoEnum != null) {
            this.tipoCertificacion = estadoEnum.name();
        }
    }

    public NivelIdiomaEnum getNivelIdiomaEnum() {
        if (nivelIdioma == null) {
            return null;
        }
        return NivelIdiomaEnum.valueOf(nivelIdioma);
    }

    @JsonIgnore
    public void setNivelIdiomaEnun(NivelIdiomaEnum nivelIdioma) {
        if (nivelIdioma == null) {
            return;
        }
        this.nivelIdioma = nivelIdioma.name();
    }

}
