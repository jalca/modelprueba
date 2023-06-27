package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.constantines.AcademicoConstantine;
import pe.edu.lamolina.model.enums.DocenteEstadoEnum;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.rrhh.CategoriaDocente;
import pe.edu.lamolina.model.rrhh.DedicacionDocente;
import pe.edu.lamolina.model.rrhh.SituacionDocente;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "aca_docente")
public class Docente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "clave_obu")
    private String claveObu;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento_academico")
    private DepartamentoAcademico departamentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaDocente categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion")
    private SituacionDocente situacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dedicacion")
    private DedicacionDocente dedicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_inicio_contrato")
    private CicloAcademico cicloInicioContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_fin_contrato")
    private CicloAcademico cicloFinContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @OneToMany(mappedBy = "coordinador", fetch = FetchType.LAZY)
    private List<Curso> curso;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
    private List<DocenteSeccion> docenteSeccion;

    @Transient
    private String codigoTipoDocumento;
    @Transient
    private String numeroDocumento;
    @Transient
    private String codigoDepartamento;
    @Transient
    private String claveObuLibre;
    @Transient
    private BigDecimal montoTotalVerano;
    @Transient
    private Carrera carrera;

    @Transient
    private Long cantSeccionesPre;
    @Transient
    private Long cantSeccionesPos;

    public Docente(String codigo, String codigoTipoDocumento, String numeroDocumento, String codigoDepartamento) {
        this.codigo = codigo;
        this.codigoTipoDocumento = codigoTipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.codigoDepartamento = codigoDepartamento;
    }

    public Docente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public DocenteEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        if (estado.equals("")) {
            return null;
        }
        return DocenteEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(DocenteEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public String getMontoTotalVeranoFormato() {
        if (this.montoTotalVerano == null) {
            return null;
        }
        return NumberFormat.precio(this.montoTotalVerano);
    }

    public boolean isCodigoNN() {
        if (AcademicoConstantine.DOCENTE_INDETERMINADO.equals(this.getCodigo())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "claveObu", claveObu, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModifica", fechaModifica, false);
        ModelUtils.getDataByAttr(join, "modalidadEstudio", modalidadEstudio);
        ModelUtils.getDataByAttr(join, "departamentoAcademico", departamentoAcademico);
        ModelUtils.getDataByAttr(join, "persona", persona);
        ModelUtils.getDataByAttr(join, "categoria", categoria, false);
        ModelUtils.getDataByAttr(join, "situacion", situacion, false);
        ModelUtils.getDataByAttr(join, "dedicacion", dedicacion, false);
        ModelUtils.getDataByAttr(join, "cicloInicioContrato", cicloInicioContrato, false);
        ModelUtils.getDataByAttr(join, "cicloFinContrato", cicloFinContrato, false);

        ModelUtils.getDataByAttr(join, "codigoTipoDocumento", codigoTipoDocumento, false);
        ModelUtils.getDataByAttr(join, "numeroDocumento", numeroDocumento, false);
        ModelUtils.getDataByAttr(join, "codigoDepartamento", codigoDepartamento, false);
        ModelUtils.getDataByAttr(join, "claveObuLibre", claveObuLibre, false);
        ModelUtils.getDataByAttr(join, "montoTotalVerano", montoTotalVerano, false);
        ModelUtils.getDataByAttr(join, "carrera", carrera, false);
        ModelUtils.getDataByAttr(join, "cantSeccionesPre", cantSeccionesPre, false);
        ModelUtils.getDataByAttr(join, "cantSeccionesPos", cantSeccionesPos, false);

        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);

        return join.toString();
    }
}
