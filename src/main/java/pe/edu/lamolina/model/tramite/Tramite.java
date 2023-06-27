package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.academico.MatriculaCurso;
import pe.edu.lamolina.model.bienestar.CitaAsistentaAlumno;
import pe.edu.lamolina.model.enums.TipoSolicitanteEnum;
import pe.edu.lamolina.model.enums.TipoTramiteEnum;
import pe.edu.lamolina.model.enums.TramiteEstadoEnum;
import static pe.edu.lamolina.model.enums.TramiteEstadoEnum.APR;
import static pe.edu.lamolina.model.enums.TramiteEstadoEnum.ENVJ;
import static pe.edu.lamolina.model.enums.TramiteEstadoEnum.RCHJ;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.FichaSocioeconomica;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "tram_tramite")
public class Tramite implements Serializable {

    public static final Integer MAX_RETIRO_CURSO = 6;
    public static final Integer MAX_RETIRO_CICLO = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serie")
    private Long serie;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_ficha")
    private String estadoFicha;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "tipo_solicitante")
    private String tipoSolicitante;

    @Column(name = "numero_visible")
    private String numeroVisible;

    @NotNull
    @Column(name = "finalizado")
    private Boolean finalizado;

    @NotNull
    @Column(name = "aceptado")
    private Boolean aceptado;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_respuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRespuesta;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jurado_tesis")
    private JuradoTesis juradoTesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ficha_socioeconomica")
    private FichaSocioeconomica fichaSocioeconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_respuesta")
    private Usuario userRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<RetiroCiclo> retiroCiclo;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCursos;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<DeudaTramite> deudasTramite;

    @OneToMany(mappedBy = "tramiteAnulacion", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCurso1;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<Reincorporacion> reincorporaciones;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<CursoDirigido> cursoDirigido;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteBachiller> tramiteBachiller;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteReunionConsejo> tramitesReunionConsejo;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteExoneracionAporte> tramiteExoneracion;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteFraccionamiento> tramiteFraccionamiento;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteRecategorizacion> tramiteRecategorizacion;

    @OneToMany(mappedBy = "tramiteAcademico", fetch = FetchType.LAZY)
    private List<FlujoTramiteAcademico> flujoTramiteAcademico;

    @Transient
    List<MatriculaCurso> matriculaCursos;

    @Transient
    private Boolean seleccionado;

    @Transient
    private Boolean activo;

    @Transient
    private String respuesta;

    @Transient
    private FlujoTramiteBienestar flujoTramiteBienestar;

    @Transient
    private CitaAsistentaAlumno citaAsistentaAlumno;

    @Transient
    List<AccionTramiteAcademico> accionesTramitesAcademico;

    @Transient
    List<AccionTramiteDocumento> accionesTramitesDocumentos;

    @Transient
    FormularioEstadoTramite formularioEstadoTramite;

    @Transient
    private EstadoTramite estadoTramite;

    @Transient
    private TramiteReunionConsejo tramiteReunionConsejo;

    @Transient
    private TramiteSubvencion tramiteSubvencion;

    @Transient
    private CicloAcademico cicloAcademicoResolucion;

    @Transient
    private CicloAcademico cicloReincorporacion;

    @Transient
    private TipoDocumentoAcademico tipoDocumentoAcademico;

    @Transient
    private AccionTramiteBienestar accionTramiteBienestar;

    @Transient
    private Resolucion resolucion;

    @Transient
    private String motivoResolucion;

    @Transient
    private Curso cursoResolucion;

    @Transient
    private BigDecimal notaResolucion;

    public Tramite() {
        this.finalizado = false;
        this.aceptado = false;
    }

    public Tramite(Object id) {
        this.id = TypesUtil.getLong(id);
        this.finalizado = false;
        this.aceptado = false;
    }

    public TipoSolicitanteEnum getTipoSolicitanteEnum() {
        if (this.tipoSolicitante == null) {
            return null;
        }
        return TipoSolicitanteEnum.valueOf(this.tipoSolicitante);
    }

    @JsonIgnore
    public void setTipoSolicitanteEnum(TipoSolicitanteEnum tipoSolicitante) {
        if (tipoSolicitante == null) {
            return;
        }
        this.tipoSolicitante = tipoSolicitante.name();
    }

    public TramiteEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return TramiteEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TramiteEstadoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public List<AccionTramiteAcademico> getAccionesTramitesAcademico() {
        if (accionesTramitesAcademico == null) {
            return new ArrayList();
        }
        return accionesTramitesAcademico;
    }

    public boolean isSolicitanteAlumno() {
        return TipoSolicitanteEnum.ALU == this.getTipoSolicitanteEnum();
    }

    public boolean isSolicitanteDocente() {
        return TipoSolicitanteEnum.DOC == this.getTipoSolicitanteEnum();
    }

    public boolean isSolicitanteEmpresa() {
        return TipoSolicitanteEnum.EMP == this.getTipoSolicitanteEnum();
    }

    public boolean isSolicitanteOficina() {
        return TipoSolicitanteEnum.OFI == this.getTipoSolicitanteEnum();
    }

    public boolean isSolicitantePersona() {
        return TipoSolicitanteEnum.PER == this.getTipoSolicitanteEnum();
    }

    public boolean isTipoRetiroCurso() {
        if (this.getTipoTramite() != null) {
            if (this.getTipoTramite().getId() != null) {
                if (TipoTramiteEnum.RCU.getId().equals(this.getTipoTramite().getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTipoRetiroCiclo() {
        if (this.getTipoTramite() != null) {
            if (this.getTipoTramite().getId() != null) {
                if (TipoTramiteEnum.RCI.getId().equals(this.getTipoTramite().getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTipoCursoDirigido() {
        if (this.getTipoTramite() != null) {
            if (this.getTipoTramite().getId() != null) {
                if (TipoTramiteEnum.CURDIR.getId().equals(this.getTipoTramite().getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean getEnviarJefatura() {
        if (Arrays.asList(ENVJ, APR, RCHJ).contains(getEstadoEnum())) {
            return true;
        } else {
            return false;
        }
    }

    public String getDescripcionCorta() {
        if (!StringUtils.isEmpty(numeroVisible)) {
            return String.format("%s", numeroVisible);
        }

        if (numero == null || serie == null) {
            return null;
        }
        String num = numero + "";
        if (numero.toString().length() == 1) {
            num = "00" + numero;
        } else if (numero.toString().length() == 2) {
            num = "0" + numero;
        }
        return String.format("%s/%s", num, serie);
    }

    public String getDescripcion() {
        if (!StringUtils.isEmpty(numeroVisible)) {
            return String.format("%s", numeroVisible);
        }

        if (numero == null || serie == null || oficina == null) {
            return null;
        }
        String num = numero + "";
        if (numero.toString().length() == 1) {
            num = "00" + numero;
        } else if (numero.toString().length() == 2) {
            num = "0" + numero;
        }
        return String.format("%s-%s/%s-%s", num, oficina.getCodigoDocumento(), oficina.getOficinaSuperior().getCodigoDocumento(), serie);
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "serie", serie);
        ModelUtils.getDataByAttr(join, "numero", numero);
        ModelUtils.getDataByAttr(join, "numeroVisible", numeroVisible, false);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "estadoFicha", estadoFicha, false);
        ModelUtils.getDataByAttr(join, "finalizado", finalizado, false);
        ModelUtils.getDataByAttr(join, "aceptado", aceptado, false);
        ModelUtils.getDataByAttr(join, "observacion", observacion, false);
        ModelUtils.getDataByAttr(join, "tipoSolicitante", tipoSolicitante, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaRespuesta", fechaRespuesta, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "empresa", empresa, "id", "razonSocial", "nombreComercial", "numeroDocIdentidad");
        ModelUtils.getDataByAttrObject(join, "docente", docente, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id", "codigo");
        ModelUtils.getDataByAttrObject(join, "oficina", oficina, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "tipoTramite", tipoTramite, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "cicloAcademico", cicloAcademico, "id", "codigo", "descripcion");
        ModelUtils.getDataByAttrObject(join, "juradoTesis", juradoTesis, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "fichaSocioeconomica", fichaSocioeconomica, "id", "estado");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userRespuesta", userRespuesta, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }

}
