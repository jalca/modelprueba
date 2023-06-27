package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.tramite.RetiroCurso;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.ModalidadEstudioEnum;
import pe.edu.lamolina.model.enums.TipoCreditoEnum;
import pe.edu.lamolina.model.enums.TipoCurriculaEnum;
import pe.edu.lamolina.model.enums.TipoCursoCurriculaEnum;
import pe.edu.lamolina.model.enums.TipoCursoEnum;
import pe.edu.lamolina.model.enums.TipoTallerOficinaEnum;
import pe.edu.lamolina.model.general.TipoCarpeta;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aca_curso")
public class Curso implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo_anterior1")
    private String codigoAnterior1;

    @Column(name = "codigo_anterior2")
    private String codigoAnterior2;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "horas_ciclo")
    private Integer horasCiclo;

    @Column(name = "horas_teoria")
    private Integer horasTeoria;

    @Column(name = "horas_practica")
    private Integer horasPractica;

    @Column(name = "horas_teoria_verano")
    private Integer horasTeoriaVerano;

    @Column(name = "horas_practica_verano")
    private Integer horasPracticaVerano;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "creditos_variables")
    private Integer creditosVariables;

    @Column(name = "creditos_teoria")
    private Integer creditosTeoria;

    @Column(name = "creditos_practica")
    private Integer creditosPractica;

    @Column(name = "tipo_curso")
    private String tipoCurso;

    @Column(name = "tipo_credito")
    private String tipoCredito;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "tipo_curricula")
    private String tipoCurricula;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "descuento_verano")
    private BigDecimal descuentoVerano;

    @Column(name = "no_encuestar")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean noEncuestar;

    @Column(name = "no_carga_adicional")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean noCargaAdicional;

    @Column(name = "tipo_taller")
    private String tipoTaller;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_plan_calificacion")
    private Date fechaPlanCalificacion;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento_academico")
    private DepartamentoAcademico departamentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY) //nivelacion
    @JoinColumn(name = "id_plan_calificacion")
    private PlanCalificacion planCalificacion;

    @ManyToOne(fetch = FetchType.LAZY) //regular
    @JoinColumn(name = "id_plan_calificacion_regular")
    private PlanCalificacion planCalificacionRegular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coordinador")
    private Docente coordinador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta_teoria")
    private TipoCarpeta tipoCarpetaTeoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta_practica")
    private TipoCarpeta tipoCarpetaPractica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegsitro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_plan_calificacion")
    private Usuario userPlanCalificacion;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<AlumnoCicloCurso> alumnoCicloCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CursoAdicionalCurricula> cursoAdicionalCurricula;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CursoCurricula> cursoCurricula;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CursoOpcionalCurricula> cursoOpcionalCurricula;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<FormatoCurso> formatoCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<MatriculaCurso> matriculaCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<NombreCurso> nombreCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCurso;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<PlanCalificacionCurso> planesCalificacionCursos;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<GrupoSeccion> grupoSeccion;

    @Transient
    private Long[] idIdioma;

    @Transient
    private String[] nombreIdioma;

    @Transient
    private Long cantidadGrupos;

    @Transient
    private Integer numeroCiclo;

    @Transient
    private BigDecimal precio;

    @Transient
    private BigDecimal precioTpc;

    @Transient
    private Boolean seleccionado;

    @Transient
    private Boolean programado;

    @Transient
    private Boolean trikeado;

    @Transient
    private BigDecimal montoVerano;

    @Transient
    private Integer matriculados;

    @Transient
    private String tipoCursoCurricula;

    @Transient
    private TipoCursoCurriculaEnum tipoCursoCurriculaEnum;

    @Transient
    private Boolean simultaneo;

    @Transient
    private Boolean aprobado;

    @Transient
    private Boolean requisitoObligatorio;

    @Transient
    private Integer creditosRequisitos;

    @Transient
    private Integer restricciones;

    public Curso(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Curso(Long id, Long cantidadGrupos) {
        this.id = id;
        this.cantidadGrupos = cantidadGrupos;
    }

    public String requiereEspecialidad() {
        if (id == null) {
            return "INDEFINIDO";
        }
        if (modalidadEstudio != null && modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.EPG) {
            return "SI";
        }
        return "NO";
    }

    public String getCodigoNombre() {
        return this.codigo + " " + this.nombre;
    }

    public String getTpc() {
        if (horasTeoria == null
                || horasPractica == null
                || (creditos == null && creditosVariables == null)
                || StringUtils.isEmpty(tipoCredito)) {
            return null;
        }

        StringBuilder tpc = new StringBuilder();
        tpc.append(horasTeoria).append("-");
        tpc.append(horasPractica).append("-");

        if (getTipoCreditoEnum() == TipoCreditoEnum.FIJO) {
            tpc.append(creditos);
        } else if (getTipoCreditoEnum() == TipoCreditoEnum.VAR) {
            tpc.append("[1 a ").append(creditosVariables).append("]");
        }

        return tpc.toString();
    }

    public boolean isEstadoActive() {
        return this.getEstadoEnum() == EstadoEnum.ACT;
    }

    public boolean isTieneCreditosVariables() {
        if (StringUtils.isBlank(this.getTipoCredito())) {
            return false;
        }
        return this.getTipoCreditoEnum() == TipoCreditoEnum.VAR;
    }

    public boolean isTieneCreditosFijos() {
        if (StringUtils.isBlank(this.getTipoCredito())) {
            return false;
        }
        return this.getTipoCreditoEnum() == TipoCreditoEnum.FIJO;
    }

    //Se pone solo a o d, mas no la cantidad de creditos
    public boolean isCreditosZero() {
        if (this.getTipoCreditoEnum() == TipoCreditoEnum.FIJO && this.getCreditos().compareTo(BigDecimal.ZERO.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public TipoTallerOficinaEnum getTipoTallerEnum() {
        if (tipoTaller == null) {
            return null;
        }
        return TipoTallerOficinaEnum.valueOf(tipoTaller);
    }

    @JsonIgnore
    public void setTipoTallerEnum(TipoTallerOficinaEnum tipoTaller) {
        if (tipoTaller == null) {
            return;
        }
        this.tipoTaller = tipoTaller.name();
    }

    public boolean isPostgrado() {
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.EPG);
    }

    public boolean isPregrado() {
        return (modalidadEstudio.getCodigoEnum() == ModalidadEstudioEnum.PRE);
    }

    public boolean isTipoCursoTEO() {
        return TipoCursoEnum.TEO.equals(getTipoCursoEnum());
    }

    public boolean isTipoCursoPRA() {
        return TipoCursoEnum.PRA.equals(getTipoCursoEnum());
    }

    public boolean isTipoCursoTEOPRA() {
        return TipoCursoEnum.TEOPRA.equals(getTipoCursoEnum());
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    @JsonIgnore
    public void setTipoCursoCurriculaEnum(TipoCursoCurriculaEnum tipoCursoCurriculaEnum) {
        this.tipoCursoCurriculaEnum = tipoCursoCurriculaEnum;
    }

    public Integer getCreditos() {
        if (creditos == null) {
            return 0;
        }
        return creditos;
    }

    public Integer getCreditosVariables() {
        if (creditosVariables == null) {
            return 0;
        }
        return creditosVariables;
    }

    public TipoCursoEnum getTipoCursoEnum() {
        if (this.tipoCurso == null) {
            return TipoCursoEnum.NINGUNO;
        }
        return TipoCursoEnum.valueOf(this.tipoCurso);
    }

    @JsonIgnore
    public void setTipoCursoEnum(TipoCursoEnum tipoCursoEnum) {
        if (tipoCursoEnum == null) {
            return;
        }
        this.tipoCurso = tipoCursoEnum.name();
    }

    public TipoCurriculaEnum getTipoCurriculaEnum() {
        if (tipoCurricula == null) {
            return null;
        }
        return TipoCurriculaEnum.valueOf(tipoCurricula);
    }

    @JsonIgnore
    public void setTipoCurriculaEnum(TipoCurriculaEnum tipoCurricula) {
        if (tipoCurricula == null) {
            return;
        }
        this.tipoCurricula = tipoCurricula.name();
    }

    public TipoCreditoEnum getTipoCreditoEnum() {
        if (tipoCredito == null) {
            return null;
        }
        return TipoCreditoEnum.valueOf(tipoCredito);
    }

    @JsonIgnore
    public void setTipoCreditoEnum(TipoCreditoEnum tipoCreditoEnum) {
        if (tipoCreditoEnum == null) {
            this.tipoCredito = null;
            return;
        }
        this.tipoCredito = tipoCreditoEnum.name();
    }

    public void setTipoCredito(String tipoCredito) {
        if (tipoCredito != null) {
            tipoCredito = tipoCredito.trim();
            if (StringUtils.isEmpty(tipoCredito)) {
                this.tipoCredito = null;
                return;
            }
        }
        this.tipoCredito = tipoCredito;
    }

    public String getPrecioFormato() {
        if (precio == null) {
            return null;
        }
        return NumberFormat.precio(precio);
    }

    public String getPrecioTpcFormato() {
        if (precioTpc == null) {
            return null;
        }
        return NumberFormat.precio(precioTpc);
    }

    public String getMontoVeranoFormato() {
        if (this.montoVerano == null) {
            return null;
        }
        return NumberFormat.precio(this.montoVerano);
    }

    public Boolean getAprobado() {
        if (aprobado == null) {
            return false;
        }
        return aprobado;
    }

    public Boolean getTrikeado() {
        if (trikeado == null) {
            return false;
        }
        return trikeado;
    }

    public static class CompareNombre implements Comparator<Curso> {

        @Override
        public int compare(Curso cur1, Curso cur2) {
            return cur1.getNombre().compareTo(cur2.getNombre());
        }
    }

    @Override
    public Curso clone() {
        try {
            return (Curso) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
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
        if (!(obj instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory, true);
        DepartamentoAcademico departamentoAcademico = this.departamentoAcademico == null ? new DepartamentoAcademico() : this.departamentoAcademico;
        json.set("departamentoAcademico", departamentoAcademico.toJson());

        return json;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", estado=" + estado + ", codigo=" + codigo + '}';
    }

}
