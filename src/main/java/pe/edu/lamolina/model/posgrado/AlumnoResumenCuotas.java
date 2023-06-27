package pe.edu.lamolina.model.posgrado;

import pe.edu.lamolina.model.posgrado.boleta.BoletaPosgrado;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.aporte.SaldoAfavorAlumno;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.posgrado.concepto.AyudaConceptoMatricula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "epg_alumno_resumen_cuotas")
public class AlumnoResumenCuotas implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "creditos_maximo")
    private Integer creditosMaximo;

    @NotNull
    @Column(name = "creditos_exceso")
    private Integer creditosExceso;

    @Column(name = "cuotas")
    private Integer cuotas;

    @Column(name = "factura")
    private Boolean factura;

    @Column(name = "guardado")
    private Boolean guardado;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @JoinColumn(name = "id_becado_posgrado")
    @ManyToOne(fetch = FetchType.LAZY)
    private BecadoPosgrado becadoPosgrado;

    @JoinColumn(name = "id_tarifa_carrera", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TarifaCarrera tarifaCarrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "alumnoResumenCuotas", fetch = FetchType.LAZY)
    private List<AlumnoConceptoMatricula> alumnoConceptosMatricula;

    @OneToMany(mappedBy = "alumnoResumenCuotas", fetch = FetchType.LAZY)
    private List<AlumnoCuotaMatricula> alumnoCuotasMatricula;

    @OneToMany(mappedBy = "alumnoResumenCuotas", fetch = FetchType.LAZY)
    private List<AyudaConceptoMatricula> ayudaConceptoMatriculas;

    @Transient
    private String porcentajeMontoInicial;
    @Transient
    private BigDecimal porcentajeMontoInicialDecimal;

    @Transient
    private Boolean pagoCash;

    @Transient
    private List<BoletaPosgrado> boletas;

    @Transient
    private List<BoletaPosgrado> boletasOld;

    @Transient
    private boolean showBecado;

    @Transient
    private boolean tarifaCambiada;

    @Transient
    private BigDecimal montoInicial;

    @Transient
    private Integer creditosMatriculados;

    @Transient
    private Integer creditosMatriculadosPregrado;

    @Transient
    private ResumenCuotas resumen;

    @Transient
    private List<SaldoAfavorAlumno> saldoAfavorAlumnos;

    @Transient
    private String razonPago;

    @Transient
    private BigDecimal saldoAfavor;

    public AlumnoResumenCuotas() {
        this.factura = false;
        this.guardado = false;
    }

    public AlumnoResumenCuotas(Object id) {
        this.id = TypesUtil.getLong(id);
        this.guardado = false;
    }

    public AlumnoResumenCuotas(Long idAlumno, Long idCiclo, Long idResumen) {
        this.cicloAcademico = new CicloAcademico(idCiclo);
        this.alumno = new Alumno(idAlumno);
        this.id = idResumen;
    }

    public boolean getEsCreditosMinimo() {
        boolean result = false;
        if (this.getCreditosMaximo() == null) {
            return result;
        }
        if (this.tarifaCarrera == null) {
            return result;
        }
        if (this.tarifaCarrera.getCreditosMinimo() == null) {
            return result;
        }
        if (this.getCreditosMaximo() <= this.tarifaCarrera.getCreditosMinimo()) {
            result = true;
        }
        return result;
    }

    public boolean getEsCreditosNormal() {
        boolean result = false;
        if (this.getCreditosMaximo() == null) {
            return result;
        }
        if (this.tarifaCarrera == null) {
            return result;
        }
        if (this.tarifaCarrera.getCreditosMinimo() == null) {
            return result;
        }
        if (this.getCreditosMaximo() > this.tarifaCarrera.getCreditosMinimo()
                && this.getCreditosMaximo() < this.tarifaCarrera.getCreditosMaximo()) {
            result = true;
        }
        return result;
    }

    public boolean getEsCreditosExcedido() {
        boolean result = false;
        if (this.getCreditosMaximo() == null) {
            return result;
        }
        if (this.tarifaCarrera == null) {
            return result;
        }
        if (this.tarifaCarrera.getCreditosMaximo() == null) {
            return result;
        }
        if (this.getCreditosMaximo() > this.tarifaCarrera.getCreditosMaximo()) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof AlumnoResumenCuotas)) {
            return false;
        }
        AlumnoResumenCuotas other = (AlumnoResumenCuotas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Boolean getPagoCash() {
        if (this.pagoCash == null) {
            return Boolean.FALSE;
        }
        return pagoCash;
    }

    @Override
    public AlumnoResumenCuotas clone() {
        AlumnoResumenCuotas clone = null;
        try {
            clone = (AlumnoResumenCuotas) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
