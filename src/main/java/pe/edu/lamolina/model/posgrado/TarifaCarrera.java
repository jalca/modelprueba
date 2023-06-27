package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.constantines.EpgConstantine;
import pe.edu.lamolina.model.enums.AmbitoTarifaEnum;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TarifaCarreraTipoMontoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_tarifa_carrera")
public class TarifaCarrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ambito")
    private String ambito;

    @Column(name = "nombre_especial")
    private String nombreEspecial;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "descuento_cash")
    private BigDecimal descuentoCash;

    @Column(name = "descuento_segundo_cash")
    private BigDecimal descuentoSegundoCash;

    @Column(name = "tasa_interes")
    private BigDecimal tasaInteres;

    @Column(name = "mora")
    private BigDecimal mora;

    @Column(name = "tipo_monto")
    private String tipoMonto;

    @Column(name = "creditos_maximo")
    private Integer creditosMaximo;

    @Column(name = "creditos_minimo")
    private Integer creditosMinimo;

    @Column(name = "costo_credito_minimo")
    private BigDecimal costoCreditoMinimo;

    @Column(name = "costo_credito_exceso")
    private BigDecimal costoCreditoExceso;

    @Column(name = "intereses")
    private BigDecimal intereses;

    @Column(name = "maximo_cuotas")
    private Integer maximoCuotas;

    @Column(name = "meses_cuota")
    private Integer mesesCuota;

    @Column(name = "usuario_migracion")
    private String usuarioMigracion;

    @Column(name = "cobrar_cursos_pregrado")
    private Boolean cobrarCursosPregrado;

    @Column(name = "porcentaje_descuento_retiro_curso")
    private BigDecimal porcentajeDescuentoRetiroCurso;

    @Column(name = "porcentaje_minimo_descuento_retiro_ciclo")
    private BigDecimal porcentajeMinimoDescuentoRetiroCiclo;

    @Column(name = "primera_cuota")
    private Integer primeraCuota;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaActivacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_inicio")
    private CicloAcademico cicloInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activacion")
    private Usuario userActivacion;

    @OneToMany(mappedBy = "tarifaCarrera", fetch = FetchType.LAZY)
    private List<TarifaConcepto> tarifasConcepto;

    @OneToMany(mappedBy = "tarifaCarrera", fetch = FetchType.LAZY)
    private List<AlumnoTarifa> alumnosTarifas;

    @OneToMany(mappedBy = "tarifaCarrera", fetch = FetchType.LAZY)
    private List<AlumnoResumenCuotas> alumnosResumen;

    @Transient
    private Integer alumnos;

    public TarifaCarrera() {
    }

    public TarifaCarrera(Long id, Long alumnos) {
        this.id = id;
        this.alumnos = alumnos.intValue();
    }

    public TarifaCarrera(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CicloAcademico getCicloInicio() {
        return cicloInicio;
    }

    public void setCicloInicio(CicloAcademico cicloInicio) {
        this.cicloInicio = cicloInicio;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public AmbitoTarifaEnum getAmbitoEnum() {
        if (ambito == null) {
            return null;
        }
        return AmbitoTarifaEnum.valueOf(ambito);
    }

    @JsonIgnore
    public void setAmbitoEnum(AmbitoTarifaEnum ambito) {
        if (ambito == null) {
            return;
        }
        this.ambito = ambito.name();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getDescuentoCash() {
        return descuentoCash;
    }

    public void setDescuentoCash(BigDecimal descuentoCash) {
        this.descuentoCash = descuentoCash;
    }

    public BigDecimal getDescuentoSegundoCash() {
        return descuentoSegundoCash;
    }

    public void setDescuentoSegundoCash(BigDecimal descuentoSegundoCash) {
        this.descuentoSegundoCash = descuentoSegundoCash;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public Integer getCreditosMaximo() {
        return creditosMaximo;
    }

    public void setCreditosMaximo(Integer creditosMaximo) {
        this.creditosMaximo = creditosMaximo;
    }

    public Integer getCreditosMinimo() {
        return creditosMinimo;
    }

    public void setCreditosMinimo(Integer creditosMinimo) {
        this.creditosMinimo = creditosMinimo;
    }

    public BigDecimal getCostoCreditoMinimo() {
        return costoCreditoMinimo;
    }

    public void setCostoCreditoMinimo(BigDecimal costoCreditoMinimo) {
        this.costoCreditoMinimo = costoCreditoMinimo;
    }

    public BigDecimal getCostoCreditoExceso() {
        return costoCreditoExceso;
    }

    public void setCostoCreditoExceso(BigDecimal costoCreditoExceso) {
        this.costoCreditoExceso = costoCreditoExceso;
    }

    public Integer getMaximoCuotas() {
        return maximoCuotas;
    }

    public void setMaximoCuotas(Integer maximoCuotas) {
        this.maximoCuotas = maximoCuotas;
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

    public List<AlumnoTarifa> getAlumnosTarifas() {
        return alumnosTarifas;
    }

    public void setAlumnosTarifas(List<AlumnoTarifa> alumnosTarifas) {
        this.alumnosTarifas = alumnosTarifas;
    }

    public List<AlumnoResumenCuotas> getAlumnosResumen() {
        return alumnosResumen;
    }

    public void setAlumnosResumen(List<AlumnoResumenCuotas> alumnosResumen) {
        this.alumnosResumen = alumnosResumen;
    }

//    public List<TarifaConcepto> getTarifaConcepto() {
//        return tarifaConcepto;
//    }
//
//    public void setTarifaConcepto(List<TarifaConcepto> tarifaConcepto) {
//        this.tarifaConcepto = tarifaConcepto;
//    }
    public Usuario getUserActivacion() {
        return userActivacion;
    }

    public void setUserActivacion(Usuario userActivacion) {
        this.userActivacion = userActivacion;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public String getTipoMonto() {
        return tipoMonto;
    }

    public TarifaCarreraTipoMontoEnum getTipoMontoEnum() {
        if (StringUtils.isBlank(this.tipoMonto)) {
            return null;
        }
        return TarifaCarreraTipoMontoEnum.valueOf(tipoMonto);
    }

    @JsonIgnore
    public void setTipoMontoEnum(TarifaCarreraTipoMontoEnum tipoMonto) {
        this.tipoMonto = tipoMonto.name();
    }

    public void setTipoMonto(String tipoMonto) {
        this.tipoMonto = tipoMonto;
    }

    public List<TarifaConcepto> getTarifasConcepto() {
        return tarifasConcepto;
    }

    public void setTarifasConcepto(List<TarifaConcepto> tarifasConcepto) {
        this.tarifasConcepto = tarifasConcepto;
    }

    public BigDecimal getIntereses() {
        return intereses;
    }

    public void setIntereses(BigDecimal intereses) {
        this.intereses = intereses;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuarioMigracion() {
        return usuarioMigracion;
    }

    public void setUsuarioMigracion(String usuarioMigracion) {
        this.usuarioMigracion = usuarioMigracion;
    }

    public Integer getMesesCuota() {
        return mesesCuota;
    }

    public void setMesesCuota(Integer mesesCuota) {
        this.mesesCuota = mesesCuota;
    }

    public Integer getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Integer alumnos) {
        this.alumnos = alumnos;
    }

    public Boolean getCobrarCursosPregrado() {
        return cobrarCursosPregrado;
    }

    public void setCobrarCursosPregrado(Boolean cobrarCursosPregrado) {
        this.cobrarCursosPregrado = cobrarCursosPregrado;
    }

    public BigDecimal getPorcentajeDescuentoRetiroCurso() {
        return porcentajeDescuentoRetiroCurso;
    }

    public void setPorcentajeDescuentoRetiroCurso(BigDecimal porcentajeDescuentoRetiroCurso) {
        this.porcentajeDescuentoRetiroCurso = porcentajeDescuentoRetiroCurso;
    }

    public BigDecimal getPorcentajeMinimoDescuentoRetiroCiclo() {
        return porcentajeMinimoDescuentoRetiroCiclo;
    }

    public void setPorcentajeMinimoDescuentoRetiroCiclo(BigDecimal porcentajeMinimoDescuentoRetiroCiclo) {
        this.porcentajeMinimoDescuentoRetiroCiclo = porcentajeMinimoDescuentoRetiroCiclo;
    }

    public Integer getPrimeraCuota() {
        return primeraCuota;
    }

    public void setPrimeraCuota(Integer primeraCuota) {
        this.primeraCuota = primeraCuota;
    }

    public String getNombre() {
        if (this.cicloInicio == null) {
            return "";
        }
        if (this.carrera == null) {
            return "";
        }
        String nombre = this.ambito + " " + this.cicloInicio.getDescripcion() + " ";
        if (!nombreEspecial.equals(EpgConstantine.TARIFA_NOMBRE_ESPECIAL)) {
            nombre += this.nombreEspecial + " ";
        }
        nombre += this.carrera.getTipo() + " " + this.carrera.getNombre();
        return nombre;
    }

    public String getNombreEspecial() {
        return nombreEspecial;
    }

    public void setNombreEspecial(String nombreEspecial) {
        this.nombreEspecial = nombreEspecial;
    }

    @Override
    public String toString() {
        return "TarifaCarrera{" + "id=" + id + ", ambito=" + ambito + ", codigo=" + codigo + ", estado=" + estado + '}';
    }

}
