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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EnteAcademicoEstadoEnum;
import pe.edu.lamolina.model.inscripcion.CarreraPostula;
import pe.edu.lamolina.model.inscripcion.Evaluado;
import pe.edu.lamolina.model.inscripcion.Ingresante;
import pe.edu.lamolina.model.enums.TipoCarreraEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "aca_carrera")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad_ciclos")
    private Integer cantidadCiclos;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_admision")
    private String estadoAdmision;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre_corto")
    private String nombreCorto;

    @Column(name = "nombre_ingles")
    private String nombreIngles;

    @Column(name = "nombre_resultado")
    private String nombreResultado;

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_posgrado")
    private AreaPosgrado areaPosgrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Alumno> alumno;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<AlumnoCiclo> alumnoCiclo;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<OrientacionCarrera> orientacionCarrera;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<PlanCurricular> planCurricular;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<CarreraPostula> carreraPostula;

    @OneToMany(mappedBy = "carreraIngreso", fetch = FetchType.LAZY)
    private List<Evaluado> evaluado;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Ingresante> ingresante;

    @Transient
    private BigDecimal notaMinima;
    @Transient
    private Integer matriculados;
    @Transient
    private Integer matriculables;

    public Carrera() {
    }

    public Carrera(
            Long id,
            String nombre,
            String codigo,
            String estado,
            BigDecimal notaMin) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.notaMinima = notaMin;
    }

    public Carrera(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EnteAcademicoEstadoEnum getEstadoEnum() {
        return estado != null ? EnteAcademicoEstadoEnum.valueOf(estado) : null;
    }

    @JsonIgnore
    public void setEstadoEnum(EnteAcademicoEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public EnteAcademicoEstadoEnum getEstadoAdmisionEnum() {
        return estadoAdmision != null ? EnteAcademicoEstadoEnum.valueOf(estadoAdmision) : null;
    }

    @JsonIgnore
    public void setEstadoAdmisionEnum(EnteAcademicoEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estadoAdmision = estadoEnum.name();
    }

    public TipoCarreraEnum getTipoEnum() {
        return tipo != null ? TipoCarreraEnum.valueOf(tipo) : null;
    }

    @JsonIgnore
    public void setTipoEnum(TipoCarreraEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public boolean isTipoMAE() {
        return TipoCarreraEnum.MAE == this.getTipoEnum();
    }

    public boolean isTipoDOC() {
        return TipoCarreraEnum.DOC == this.getTipoEnum();
    }

    public boolean isTieneRestriccion(List<RestriccionCarrera> restriccionesCarrera) {
        for (RestriccionCarrera restriccionCarreraEach : restriccionesCarrera) {
            if (this.getId().compareTo(restriccionCarreraEach.getCarrera().getId()) == 0) {
                return true;
            }
        }
        return false;
    }

    public String getDescripcionCarreraFacultad() {
        if (this.modalidadEstudio.isPregrado()) {
            if (!this.getNombre().equals(this.facultad.getNombre())) {
                return this.facultad.getNombre() + " - " + this.getNombre();
            }
        }
        if (this.modalidadEstudio.isOperativeEPG()) {
            if (this.getTipoEnum() == TipoCarreraEnum.MAE) {
                return "Maestría en " + this.nombre;
            }
            if (this.getTipoEnum() == TipoCarreraEnum.DOC) {
                return "Doctorado en " + this.nombre;
            }
        }
        return this.getNombre();
    }

    public String getNombreSelect() {
        if (StringUtils.isBlank(tipo) || StringUtils.isBlank(nombre)) {
            return null;
        }
        if (TipoCarreraEnum.valueOf(tipo) == TipoCarreraEnum.DOC || TipoCarreraEnum.valueOf(tipo) == TipoCarreraEnum.MAE) {
            return tipo.concat(" - ").concat(nombre);
        } else {
            return nombre;
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
        if (!(obj instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public static class CompareCodigo implements Comparator<Carrera> {

        @Override
        public int compare(Carrera ca1, Carrera ca2) {
            return ca1.getCodigo().compareTo(ca2.getCodigo());
        }
    }

    public static class CompareNombrePosgrado implements Comparator<Carrera> {

        @Override
        public int compare(Carrera ca1, Carrera ca2) {
            int tipo = ca1.getTipo().compareTo(ca2.getTipo());
            if (tipo != 0) {
                return tipo;
            }
            return ca1.getNombre().compareTo(ca2.getNombre());
        }
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "estado", estado, false);
        ModelUtils.getDataByAttr(join, "tipo", tipo, false);
        ModelUtils.getDataByAttr(join, "cantidadCiclos", cantidadCiclos, false);
        ModelUtils.getDataByAttr(join, "nombreCorto", nombreCorto, false);
        ModelUtils.getDataByAttr(join, "nombreIngles", nombreIngles, false);
        ModelUtils.getDataByAttr(join, "nombreResultado", nombreResultado, false);
        ModelUtils.getDataByAttr(join, "motivoAnulacion", motivoAnulacion, false);
        ModelUtils.getDataByAttr(join, "fechaAnulacion", fechaAnulacion, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttrObject(join, "modalidadEstudio", modalidadEstudio, "id", "nombre", "codigo");
        ModelUtils.getDataByAttrObject(join, "facultad", facultad, "id", "nombre", "codigo");
        ModelUtils.getDataByAttrObject(join, "areaPosgrado", areaPosgrado, "id", "nombre", "codigo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
