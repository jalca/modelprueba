package pe.edu.lamolina.model.almacen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ControlAlmacenEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "alm_control_almacen")
public class ControlAlmacen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year_mes")
    private String yearMes;

    @Column(name = "estado")
    private String estado;

    @Column(name = "year")
    private Long year;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_apertura")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaApertura;

    @Column(name = "fecha_cierre")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mes")
    private Mes mes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_cierre")
    private Usuario userCierre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_apertura")
    private Usuario userApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public ControlAlmacen() {
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public ControlAlmacen(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(ControlAlmacenEstadoEnum estado) {
        this.estado = estado.name();
    }

    public ControlAlmacenEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ControlAlmacenEstadoEnum.valueOf(estado);
    }

    public void setEstadoEnum(ControlAlmacenEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public String getYearMes() {
        return yearMes;
    }

    public void setYearMes(String yearMes) {
        this.yearMes = yearMes;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserApertura() {
        return userApertura;
    }

    public void setUserApertura(Usuario userApertura) {
        this.userApertura = userApertura;
    }

    public Usuario getUserCierre() {
        return userCierre;
    }

    public void setUserCierre(Usuario userCierre) {
        this.userCierre = userCierre;
    }

}
