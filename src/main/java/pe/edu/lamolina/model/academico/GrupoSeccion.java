package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.enums.EstadoGrupoSeccionEnum;
import pe.edu.lamolina.model.enums.EstadoPlanCalificaEnum;
import pe.edu.lamolina.model.enums.SeccionEstadoEnum;
import pe.edu.lamolina.model.enums.TipoDictadoGrupoSeccionEnum;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Getter
@Setter
@Table(name = "aca_grupo_seccion")
public class GrupoSeccion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo2")
    private String codigo2;

    @Column(name = "codigo3")
    private String codigo3;

    @Column(name = "orden")
    private Integer orden;

    @NotNull
    @Column(name = "version")
    private String version;

    @NotNull
    @Column(name = "estado_plan")
    private String estadoPlan;

    @NotNull
    @Column(name = "estado_grupo")
    private String estadoGrupo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "horas_teoria")
    private Integer horasTeoria;

    @Column(name = "horas_practica")
    private Integer horasPractica;

    @Column(name = "curso_dirigido")
    private Boolean cursoDirigido;

    @Column(name = "tipo_dictado")
    private String tipoDictado;

    @Column(name = "fecha_cierre_acta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreActa;

    @Column(name = "fecha_inicio_modular")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicioModular;

    @Column(name = "fecha_fin_modular")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFinModular;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anexo_boletin")
    private AnexoBoletin anexoBoletin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierre_acta")
    private Usuario usuarioCierraActa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_modificacion")
    private Usuario usuarioModificacion;

    @OneToMany(mappedBy = "grupoSeccion", fetch = FetchType.LAZY)
    private List<EvaluacionSeccion> evaluacionSecciones;

    @OneToMany(mappedBy = "grupoSeccion", fetch = FetchType.LAZY)
    private List<Seccion> secciones;

    @Transient
    private String codigo200;
    @Transient
    private String codigoCurso;
    @Transient
    private Docente docenteResponsable;
    @Transient
    private String codigoAnexo;
    @Transient
    private Integer cantidad;
    @Transient
    private boolean tipoDictadoCheck;

    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicioPeriodo;
    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFinPeriodo;

    public GrupoSeccion() {
    }

    public GrupoSeccion(String codigo, String codigoCurso, String codigoAnexo, String dirigido) {
        this.codigo3 = codigo;
        this.codigoCurso = codigoCurso;
        this.codigoAnexo = codigoAnexo;
        this.cursoDirigido = "1".equals(dirigido);
    }

    public GrupoSeccion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoPlanCalificaEnum getEstadoPlanEnum() {
        if (StringUtils.isEmpty(estadoPlan)) {
            return null;
        }
        return EstadoPlanCalificaEnum.valueOf(estadoPlan);
    }

    @JsonIgnore
    public void setEstadoPlanEnum(EstadoPlanCalificaEnum estadoPlanCalificaEnum) {
        if (estadoPlanCalificaEnum == null) {
            return;
        }
        this.estadoPlan = estadoPlanCalificaEnum.name();
    }

    public boolean isEstadoSolicitado() {
        if (EstadoPlanCalificaEnum.SOL.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoExpandido() {
        if (EstadoPlanCalificaEnum.EXP.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoExpandir() {
        if (EstadoPlanCalificaEnum.EXPR.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoReenviado() {
        if (EstadoPlanCalificaEnum.REE.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCreado() {
        if (EstadoPlanCalificaEnum.CRE.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCerrado() {
        if (EstadoPlanCalificaEnum.CER.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoPropuesto() {
        if (EstadoPlanCalificaEnum.PRO.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoActivado() {
        if (EstadoPlanCalificaEnum.ACT.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoObservado() {
        if (EstadoPlanCalificaEnum.OBS.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoAceptado() {
        if (EstadoPlanCalificaEnum.ACEP.name().equals(estadoPlan)) {
            return true;
        }
        return false;
    }

    public EstadoGrupoSeccionEnum getEstadoGrupoEnum() {
        return EstadoGrupoSeccionEnum.valueOf(estadoGrupo);
    }

    @JsonIgnore
    public void setEstadoGrupoEnum(EstadoGrupoSeccionEnum estadoGrupoEnum) {
        if (estadoGrupoEnum == null) {
            return;
        }
        this.estadoGrupo = estadoGrupoEnum.name();
    }

    public boolean isEstadoGrupoAbierto() {
        if (EstadoGrupoSeccionEnum.ABI.equals(this.getEstadoGrupoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoGrupoCerrado() {
        if (EstadoGrupoSeccionEnum.CER.equals(this.getEstadoGrupoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoGrupoReabierto() {
        if (EstadoGrupoSeccionEnum.RAB.equals(this.getEstadoGrupoEnum())) {
            return true;
        }
        return false;
    }

    public SeccionEstadoEnum getEstadoEnum() {
        return SeccionEstadoEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(SeccionEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public Boolean getCursoDirigido() {
        if (cursoDirigido == null) {
            return false;
        }
        return cursoDirigido;
    }

    public boolean isEstadoActivo() {
        if (SeccionEstadoEnum.ACT == this.getEstadoEnum()) {
            return true;
        }
        return false;
    }

    public boolean isEstadoInactivo() {
        if (SeccionEstadoEnum.ANU == this.getEstadoEnum()) {
            return true;
        }
        return false;
    }

    public boolean isTieneSecciones() {
        if (this.getSecciones() != null && !this.getSecciones().isEmpty()) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public TipoDictadoGrupoSeccionEnum getTipoDictadoEnum() {
        return this.tipoDictado == null ? null : TipoDictadoGrupoSeccionEnum.valueOf(this.tipoDictado);
    }

    @JsonIgnore
    public void setTipoDictadoEnum(TipoDictadoGrupoSeccionEnum estado) {
        if (estado == null) {
            return;
        }
        this.tipoDictado = estado.name();
    }

    public static class CompareCodigo implements Comparator<GrupoSeccion> {

        @Override
        public int compare(GrupoSeccion gs1, GrupoSeccion gs2) {
            return gs1.getCodigo().compareTo(gs2.getCodigo());
        }
    }

    public static class CompareCodigo2 implements Comparator<GrupoSeccion> {

        @Override
        public int compare(GrupoSeccion gs1, GrupoSeccion gs2) {
            return gs1.getCodigo2().compareTo(gs2.getCodigo2());
        }
    }

    public static class CompareNombreCurso implements Comparator<GrupoSeccion> {

        @Override
        public int compare(GrupoSeccion gs1, GrupoSeccion gs2) {
            return gs1.getCurso().getNombre().compareTo(gs2.getCurso().getNombre());
        }
    }

    public String getIdCursoIdAnexo() {
        return this.getCurso().getId() + "-" + this.getAnexoBoletin().getId();
    }

    @Override
    public GrupoSeccion clone() {
        try {
            return (GrupoSeccion) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
