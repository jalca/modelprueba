package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "extn_taller_verano")
public class TallerVerano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "meses")
    private Integer meses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller_ciclo")
    private TallerCiclo tallerCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable_pago")
    private ResponsablePago responsablePago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda_taller_verano")
    private DeudaTallerVerano deudaTallerVerano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_precio_taller")
    private PrecioTaller precioTaller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_retiro")
    private Usuario userRetiro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_matricula")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaMatricula;

    @Column(name = "fecha_retiro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRetiro;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Transient
    Boolean conDescuento;

    @Transient
    BigDecimal saldoAFavorResponsable;

    public TallerVerano() {
    }

    public TallerVerano(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TallerCiclo getTallerCiclo() {
        return tallerCiclo;
    }

    public void setTallerCiclo(TallerCiclo tallerCiclo) {
        this.tallerCiclo = tallerCiclo;
    }

    public ResponsablePago getResponsablePago() {
        return responsablePago;
    }

    public void setResponsablePago(ResponsablePago responsablePago) {
        this.responsablePago = responsablePago;
    }

    public DeudaTallerVerano getDeudaTallerVerano() {
        return deudaTallerVerano;
    }

    public void setDeudaTallerVerano(DeudaTallerVerano deudaTallerVerano) {
        this.deudaTallerVerano = deudaTallerVerano;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        return EstadoMatriculaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estado) {
        this.estado = estado.name();
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Integer getMeses() {
        if (meses == null) {
            return 1;
        }
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Boolean getConDescuento() {
        if (conDescuento == null) {
            return false;
        }
        return conDescuento;
    }

    public void setConDescuento(Boolean conDescuento) {
        this.conDescuento = conDescuento;
    }

    public PrecioTaller getPrecioTaller() {
        return precioTaller;
    }

    public void setPrecioTaller(PrecioTaller precioTaller) {
        this.precioTaller = precioTaller;
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

    public String getKey() {
        return this.tallerCiclo.getId() + "-" + this.alumno.getId();
    }

    public Usuario getUserRetiro() {
        return userRetiro;
    }

    public void setUserRetiro(Usuario userRetiro) {
        this.userRetiro = userRetiro;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public BigDecimal getSaldoAFavorResponsable() {
        if (saldoAFavorResponsable == null) {
            return BigDecimal.ZERO;
        }
        return saldoAFavorResponsable;
    }

    public void setSaldoAFavorResponsable(BigDecimal saldoAFavorResponsable) {
        this.saldoAFavorResponsable = saldoAFavorResponsable;
    }

}
