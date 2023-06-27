package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
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
import pe.edu.lamolina.model.enums.ControlOrdenMeritoEscalaEnum;
import pe.edu.lamolina.model.enums.ControlOrdenMeritoEstadoEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_control_orden_merito")
public class ControlOrdenMerito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "escala")
    private String escala;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total_alumnos")
    private Integer totalAlumnos;

    @Column(name = "alumnos_computados")
    private Integer alumnosComputados;

    @Column(name = "alumnos_completos")
    private Integer alumnosCompletos;

    @Column(name = "alumnos_incompletos")
    private Integer alumnosIncompletos;

    @Column(name = "no_computados")
    private Integer noComputados;

    @Column(name = "computados_nivel1")
    private Integer computadosNivel1;

    @Column(name = "computados_nivel2")
    private Integer computadosNivel2;

    @Column(name = "computados_nivel3")
    private Integer computadosNivel3;

    @Column(name = "computados_nivel4")
    private Integer computadosNivel4;

    @Column(name = "computados_nivel5")
    private Integer computadosNivel5;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_calculo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaCalculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_calculo")
    private Usuario userCalculo;

    public ControlOrdenMerito() {
    }

    public ControlOrdenMerito(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEscala() {
        return escala;
    }

    public ControlOrdenMeritoEscalaEnum getEscalaEnum() {
        return ControlOrdenMeritoEscalaEnum.valueOf(escala);
    }

    public void setEscala(ControlOrdenMeritoEscalaEnum escala) {
        this.escala = escala.name();
    }

    public ControlOrdenMeritoEstadoEnum getEstadoEnum() {
        return ControlOrdenMeritoEstadoEnum.valueOf(estado);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(ControlOrdenMeritoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public Integer getTotalAlumnos() {
        return totalAlumnos;
    }

    public void setTotalAlumnos(Integer totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    public Integer getAlumnosComputados() {
        return alumnosComputados;
    }

    public void setAlumnosComputados(Integer alumnosComputados) {
        this.alumnosComputados = alumnosComputados;
    }

    public Integer getAlumnosCompletos() {
        return alumnosCompletos;
    }

    public void setAlumnosCompletos(Integer alumnosCompletos) {
        this.alumnosCompletos = alumnosCompletos;
    }

    public Integer getAlumnosIncompletos() {
        return alumnosIncompletos;
    }

    public void setAlumnosIncompletos(Integer alumnosIncompletos) {
        this.alumnosIncompletos = alumnosIncompletos;
    }

    public Integer getNoComputados() {
        return noComputados;
    }

    public void setNoComputados(Integer noComputados) {
        this.noComputados = noComputados;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserCalculo() {
        return userCalculo;
    }

    public void setUserCalculo(Usuario userCalculo) {
        this.userCalculo = userCalculo;
    }

    public Integer getComputadosNivel1() {
        return computadosNivel1;
    }

    public void setComputadosNivel1(Integer computadosNivel1) {
        this.computadosNivel1 = computadosNivel1;
    }

    public Integer getComputadosNivel2() {
        return computadosNivel2;
    }

    public void setComputadosNivel2(Integer computadosNivel2) {
        this.computadosNivel2 = computadosNivel2;
    }

    public Integer getComputadosNivel3() {
        return computadosNivel3;
    }

    public void setComputadosNivel3(Integer computadosNivel3) {
        this.computadosNivel3 = computadosNivel3;
    }

    public Integer getComputadosNivel4() {
        return computadosNivel4;
    }

    public void setComputadosNivel4(Integer computadosNivel4) {
        this.computadosNivel4 = computadosNivel4;
    }

    public Integer getComputadosNivel5() {
        return computadosNivel5;
    }

    public void setComputadosNivel5(Integer computadosNivel5) {
        this.computadosNivel5 = computadosNivel5;
    }

    public HashMap<String, Object> toMap() throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap();
        for (Field field : this.getClass().getDeclaredFields()) {
            map.put(field.getName(), field.get(this));
        }
        return map;
    }
}
