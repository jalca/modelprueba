package pe.edu.lamolina.model.academico;

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
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.TipoCarpeta;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "aca_curso_ciclo_academico")
public class CursoCicloAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "horas_semanales_teoria")
    private Integer horasSemanalesTeoria;

    @Column(name = "horas_semanales_practica")
    private Integer horasSemanalesPractica;

    @Column(name = "horas_ciclo")
    private Integer horasCiclo;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "precio_adicional")
    private BigDecimal precioAdicional;

    @Column(name = "precio_personalizado")
    private Boolean precioPersonalizado;

    @Column(name = "minimo_alumnos")
    private BigDecimal minimoAlumnos;

    @Column(name = "fecha_precio")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta_teoria")
    private TipoCarpeta tipoCarpetaTeoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta_practica")
    private TipoCarpeta tipoCarpetaPractica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_precio")
    private Usuario userPrecio;

    @Transient
    private Long cantidadGpoSecc;

    public CursoCicloAcademico() {
    }

    public CursoCicloAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public CursoCicloAcademico(Long id, Long cantidadGpoSecc) {
        this.id = id;
        this.cantidadGpoSecc = cantidadGpoSecc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getPrecioFormato() {
        if (precio == null) {
            return null;
        }
        return NumberFormat.precio(precio);
    }

    public String getPrecioTotalFormato() {
        if (precio == null) {
            return null;
        }
        return NumberFormat.precio(precio.add(precioAdicional));
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioAdicional() {
        return precioAdicional;
    }

    public String getPrecioAdicionalFormato() {
        if (precioAdicional == null) {
            return null;
        }
        return NumberFormat.precio(precioAdicional);
    }

    public void setPrecioAdicional(BigDecimal precioAdicional) {
        this.precioAdicional = precioAdicional;
    }

    public BigDecimal getMinimoAlumnos() {
        if (minimoAlumnos == null) {
            return BigDecimal.ZERO;
        }
        return minimoAlumnos;
    }

    public void setMinimoAlumnos(BigDecimal minimoAlumnos) {
        this.minimoAlumnos = minimoAlumnos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Long getCantidadGpoSecc() {
        return cantidadGpoSecc;
    }

    public void setCantidadGpoSecc(Long cantidadGpoSecc) {
        this.cantidadGpoSecc = cantidadGpoSecc;
    }

    public Boolean getPrecioPersonalizado() {
        if (precioPersonalizado == null) {
            return false;
        }
        return precioPersonalizado;
    }

    public void setPrecioPersonalizado(Boolean precioPersonalizado) {
        this.precioPersonalizado = precioPersonalizado;
    }

    public Date getFechaPrecio() {
        return fechaPrecio;
    }

    public void setFechaPrecio(Date fechaPrecio) {
        this.fechaPrecio = fechaPrecio;
    }

    public Usuario getUserPrecio() {
        return userPrecio;
    }

    public void setUserPrecio(Usuario userPrecio) {
        this.userPrecio = userPrecio;
    }

    public Integer getHorasSemanalesTeoria() {
        return horasSemanalesTeoria;
    }

    public void setHorasSemanalesTeoria(Integer horasSemanalesTeoria) {
        this.horasSemanalesTeoria = horasSemanalesTeoria;
    }

    public Integer getHorasSemanalesPractica() {
        return horasSemanalesPractica;
    }

    public void setHorasSemanalesPractica(Integer horasSemanalesPractica) {
        this.horasSemanalesPractica = horasSemanalesPractica;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(TipoCursoCurricula tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

    public Integer getHorasCiclo() {
        return horasCiclo;
    }

    public void setHorasCiclo(Integer horasCiclo) {
        this.horasCiclo = horasCiclo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public TipoCarpeta getTipoCarpetaTeoria() {
        return tipoCarpetaTeoria;
    }

    public void setTipoCarpetaTeoria(TipoCarpeta tipoCarpetaTeoria) {
        this.tipoCarpetaTeoria = tipoCarpetaTeoria;
    }

    public TipoCarpeta getTipoCarpetaPractica() {
        return tipoCarpetaPractica;
    }

    public void setTipoCarpetaPractica(TipoCarpeta tipoCarpetaPractica) {
        this.tipoCarpetaPractica = tipoCarpetaPractica;
    }

}
