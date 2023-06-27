package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CicloAcademicoEstadoEnum;
import pe.edu.lamolina.model.inscripcion.CicloPostula;
import pe.edu.lamolina.model.tramite.RetiroCiclo;
import pe.edu.lamolina.model.tramite.RetiroCurso;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.enums.TipoCicloEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "aca_ciclo_academico")
public class CicloAcademico implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "numero_ciclo")
    private String numeroCiclo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_anterior")
    private String codigoAnterior;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_obu")
    private String estadoObu;

    @Column(name = "estado_admision")
    private String estadoAdmision;

    @Column(name = "estado_subvenciones")
    private String estadoSubvenciones;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descripcion2")
    private String descripcion2;

    @Column(name = "descripcion3")
    private String descripcion3;

    @Column(name = "matricula_inicio")
    private Integer matriculaInicio;

    @Column(name = "matricula_siguiente")
    private Integer matriculaSiguiente;

    @Column(name = "ver_matricula")
    private Boolean verMatricula;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "ciclo_amnistiado")
    private Integer cicloAministiado;

    @Column(name = "alumnos_minimo_tipo_general")
    private Integer alumnosMinimoTipoGeneral;

    @Column(name = "alumnos_minimo_tipo_obligatorio")
    private Integer alumnosMinimoTipoObligatorio;

    @Column(name = "actualizar_boletin")
    private Boolean actualizarBoletin;

    @Column(name = "ver_boletin")
    private Boolean verBoletin;

    @Column(name = "visible_login")
    private Boolean visibleLogin;

    @Column(name = "visible_obuae")
    private Boolean visibleObuae;

    @Column(name = "semanas_clases")
    private Long semanasClases;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_verifica_nmat")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVerificaNmat;

    @Column(name = "fecha_matriculables")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMatriculables;

    @Column(name = "fecha_prioridades")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPrioridades;

    @Column(name = "fecha_turnos_asignados")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaTurnosAsignados;

    @Column(name = "fecha_turnos_disponibles")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaTurnosDisponibles;

    @Column(name = "fecha_clonacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaClonacion;

    @Column(name = "fecha_cierre_clonacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreClonacion;

    @Column(name = "fecha_orden_horarios")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaOrdenHorarios;

    @Column(name = "fecha_cierre_orden")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreOrden;

    @Column(name = "fecha_cierre_prioridades")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierrePrioridades;

    @Column(name = "fecha_entrega_actas")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEntregaActas;

    @Column(name = "fecha_cierre_matriculable")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierreMatriculable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "cicloIngreso", fetch = FetchType.LAZY)
    private List<Alumno> alumno;

    @OneToMany(mappedBy = "cicloActivo", fetch = FetchType.LAZY)
    private List<Alumno> alumno1;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<AlumnoCiclo> alumnoCiclo;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<ConfiguracionReclamoNota> configuracionReclamoNota;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<LoggerMatricula> loggerMatricula;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<MatriculaResumen> matriculaResumen;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<CicloPostula> cicloPostula;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<RetiroCiclo> retiroCiclo;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCurso;

    @OneToMany(mappedBy = "cicloAcademico", fetch = FetchType.LAZY)
    private List<Tramite> tramite;

    public CicloAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCodigoAntiguo() {
        if (this.year == null) {
            return null;
        }
        if (this.numeroCiclo == null) {
            return null;
        }

        String codigo = this.year + "";
        codigo += this.numeroCiclo.equals("1.5") ? "N" : this.numeroCiclo;
        return codigo;
    }

    public String getCodigoAntiguoModalidad() {
        if (this.getModalidadEstudio() == null) {
            return null;
        }
        return this.getCodigoAntiguo() + "-" + this.getModalidadEstudio().getId();
    }

    public TipoCicloEnum getTipoEnum() {
        if (this.tipo == null) {
            return null;
        }
        return TipoCicloEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipo(TipoCicloEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public CicloAcademicoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return CicloAcademicoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(CicloAcademicoEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        estado = estadoEnum.name();
    }

    public CicloAcademicoEstadoEnum getEstadoObuEnum() {
        if (estadoObu == null) {
            return null;
        }
        return CicloAcademicoEstadoEnum.valueOf(estadoObu);
    }

    @JsonIgnore
    public void setEstadoObuEnum(CicloAcademicoEstadoEnum estadoObu) {
        if (estadoObu == null) {
            return;
        }
        this.estadoObu = estadoObu.name();
    }

    public CicloAcademicoEstadoEnum getEstadoAdmisionEnum() {
        if (estadoAdmision == null) {
            return null;
        }
        return CicloAcademicoEstadoEnum.valueOf(estadoAdmision);
    }

    @JsonIgnore
    public void setEstadoAdmisionEnum(CicloAcademicoEstadoEnum estadoAdmision) {
        if (estadoAdmision == null) {
            return;
        }
        this.estadoAdmision = estadoAdmision.name();
    }

    public CicloAcademicoEstadoEnum getEstadoSubvencionesEnum() {
        if (estadoSubvenciones == null) {
            return null;
        }
        return CicloAcademicoEstadoEnum.valueOf(estadoSubvenciones);
    }

    @JsonIgnore
    public void setEstadoSubvencionesEnum(CicloAcademicoEstadoEnum estadoSubvenciones) {
        if (estadoSubvenciones == null) {
            return;
        }
        this.estadoSubvenciones = estadoSubvenciones.name();
    }

    public boolean isTipoRegular() {
        if (this.getTipo() != null) {
            if (TipoCicloEnum.REG.name().equals(this.getTipo())) {
                return true;
            }
        }
        return false;
    }

    public boolean isTipoNivelacion() {
        if (this.getTipo() != null) {
            if (TipoCicloEnum.NIV.name().equals(this.getTipo())) {
                return true;
            }
        }
        return false;
    }

    public Integer getMatriculaSiguiente() {
        if (matriculaSiguiente == null) {
            return 0;
        }
        return matriculaSiguiente;
    }

    public boolean isActivo() {
        if (this.estado == null) {
            return false;
        }
        if (this.getEstadoEnum().equals(CicloAcademicoEstadoEnum.ACT)) {
            return true;
        }
        return false;
    }

    public boolean isDesactivado() {
        if (this.estado == null) {
            return false;
        }
        if (this.getEstadoEnum().equals(CicloAcademicoEstadoEnum.DES)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoConfigurando() {
        if (this.estado == null) {
            return false;
        }
        if (this.getEstadoEnum().equals(CicloAcademicoEstadoEnum.CFG)) {
            return true;
        }
        return false;
    }

    public int getCodigoInt() {
        if (this.codigo == null) {
            return -1;
        }
        return TypesUtil.getInt(this.codigo);
    }

    public boolean isAmnistiado() {
        if (this.cicloAministiado == null) {
            return false;
        }
        if (this.cicloAministiado.compareTo(BigDecimal.ONE.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public Boolean getActualizarBoletin() {
        if (actualizarBoletin == null) {
            return false;
        }
        return actualizarBoletin;
    }

    public Boolean getVerMatricula() {
        if (verMatricula == null) {
            return false;
        }
        return verMatricula;
    }

    public static class CompareCodigoDesc implements Comparator<CicloAcademico> {

        @Override
        public int compare(CicloAcademico ci1, CicloAcademico ci2) {
            return ci2.getCodigo().compareTo(ci1.getCodigo());
        }
    }

    public static class CompareCodigoAsc implements Comparator<CicloAcademico> {

        @Override
        public int compare(CicloAcademico ci1, CicloAcademico ci2) {
            return ci1.getCodigo().compareTo(ci2.getCodigo());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CicloAcademico)) {
            return false;
        }

        CicloAcademico other = (CicloAcademico) obj;
        if (this.id == null && other.getId() == null) {
            return true;
        }

        if ((this.id == null && other.getId() != null)
                || (this.id != null && other.getId() == null)
                || (this.id.compareTo(other.getId()) != 0)) {
            return false;
        }
        return true;
    }

    @Override
    public CicloAcademico clone() {
        CicloAcademico clone = null;
        try {
            clone = (CicloAcademico) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "year", year);
        ModelUtils.getDataByAttr(join, "numeroCiclo", numeroCiclo);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "codigoAnterior", codigoAnterior, false);
        ModelUtils.getDataByAttr(join, "tipo", tipo, false);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "estadoObu", estadoObu, false);
        ModelUtils.getDataByAttr(join, "estadoAdmision", estadoAdmision, false);
        ModelUtils.getDataByAttr(join, "descripcion", descripcion, false);
        ModelUtils.getDataByAttr(join, "descripcion2", descripcion2, false);
        ModelUtils.getDataByAttr(join, "descripcion3", descripcion3, false);
        ModelUtils.getDataByAttr(join, "matriculaInicio", matriculaInicio, false);
        ModelUtils.getDataByAttr(join, "matriculaSiguiente", matriculaSiguiente, false);
        ModelUtils.getDataByAttr(join, "verMatricula", verMatricula, false);
        ModelUtils.getDataByAttr(join, "motivoAnulacion", motivoAnulacion, false);
        ModelUtils.getDataByAttr(join, "cicloAministiado", cicloAministiado, false);
        ModelUtils.getDataByAttr(join, "alumnosMinimoTipoGeneral", alumnosMinimoTipoGeneral, false);
        ModelUtils.getDataByAttr(join, "alumnosMinimoTipoObligatorio", alumnosMinimoTipoObligatorio, false);
        ModelUtils.getDataByAttr(join, "actualizarBoletin", actualizarBoletin, false);
        ModelUtils.getDataByAttr(join, "verBoletin", verBoletin, false);
        ModelUtils.getDataByAttr(join, "visibleLogin", visibleLogin, false);
        ModelUtils.getDataByAttr(join, "visibleObuae", visibleObuae, false);
        ModelUtils.getDataByAttr(join, "semanasClases", semanasClases, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaVerificaNmat", fechaVerificaNmat, false);
        ModelUtils.getDataByAttr(join, "fechaMatriculables", fechaMatriculables, false);
        ModelUtils.getDataByAttr(join, "fechaPrioridades", fechaPrioridades, false);
        ModelUtils.getDataByAttr(join, "fechaTurnosAsignados", fechaTurnosAsignados, false);
        ModelUtils.getDataByAttr(join, "fechaTurnosDisponibles", fechaTurnosDisponibles, false);
        ModelUtils.getDataByAttr(join, "fechaClonacion", fechaClonacion, false);
        ModelUtils.getDataByAttr(join, "fechaCierreClonacion", fechaCierreClonacion, false);
        ModelUtils.getDataByAttr(join, "fechaOrdenHorarios", fechaOrdenHorarios, false);
        ModelUtils.getDataByAttr(join, "fechaCierreOrden", fechaCierreOrden, false);
        ModelUtils.getDataByAttr(join, "fechaCierrePrioridades", fechaCierrePrioridades, false);
        ModelUtils.getDataByAttr(join, "fechaEntregaActas", fechaEntregaActas, false);
        ModelUtils.getDataByAttr(join, "fechaCierreMatriculable", fechaCierreMatriculable, false);
        ModelUtils.getDataByAttrObject(join, "modalidadEstudio", modalidadEstudio, "id", "codigo", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
