package pe.edu.lamolina.model.encuestaestudiantil;

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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "exam_configura_encuesta")
public class ConfiguraEncuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad_minima_alumnos_pregrado")
    private Long cantidadMinimaAlumnosPregrado;

    @Column(name = "cantidad_minima_alumnos_posgrado")
    private Long cantidadMinimaAlumnosPosgrado;

    @Column(name = "cantidad_maxima_docentes")
    private Long cantidadMaximaDocentes;

    @Column(name = "encuesta_teoria_practica")
    private Long encuestaTeoriaPractica;

    @Column(name = "dias_encuesta")
    private Long diasEncuesta;

    @Column(name = "dias_encuesta_posgrado")
    private Long diasEncuestaPosgrado;

    @Column(name = "simultaneo")
    private Integer simultaneo;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_estudiantil")
    private EncuestaEstudiantil encuestaEstudiantil;

    public ConfiguraEncuesta() {
    }

    public ConfiguraEncuesta(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidadMinimaAlumnosPregrado() {
        return cantidadMinimaAlumnosPregrado;
    }

    public void setCantidadMinimaAlumnosPregrado(Long cantidadMinimaAlumnosPregrado) {
        this.cantidadMinimaAlumnosPregrado = cantidadMinimaAlumnosPregrado;
    }

    public Long getCantidadMaximaDocentes() {
        return cantidadMaximaDocentes;
    }

    public void setCantidadMaximaDocentes(Long cantidadMaximaDocentes) {
        this.cantidadMaximaDocentes = cantidadMaximaDocentes;
    }

    public Long getEncuestaTeoriaPractica() {
        return encuestaTeoriaPractica;
    }

    public void setEncuestaTeoriaPractica(Long encuestaTeoriaPractica) {
        this.encuestaTeoriaPractica = encuestaTeoriaPractica;
    }

    public Long getDiasEncuesta() {
        return diasEncuesta;
    }

    public void setDiasEncuesta(Long diasEncuesta) {
        this.diasEncuesta = diasEncuesta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public EncuestaEstudiantil getEncuestaEstudiantil() {
        return encuestaEstudiantil;
    }

    public void setEncuestaEstudiantil(EncuestaEstudiantil encuestaEstudiantil) {
        this.encuestaEstudiantil = encuestaEstudiantil;
    }

    public Integer getSimultaneo() {
        return simultaneo;
    }

    public void setSimultaneo(Integer simultaneo) {
        this.simultaneo = simultaneo;
    }

    public Long getCantidadMinimaAlumnosPosgrado() {
        return cantidadMinimaAlumnosPosgrado;
    }

    public void setCantidadMinimaAlumnosPosgrado(Long cantidadMinimaAlumnosPosgrado) {
        this.cantidadMinimaAlumnosPosgrado = cantidadMinimaAlumnosPosgrado;
    }

    public Long getDiasEncuestaPosgrado() {
        return diasEncuestaPosgrado;
    }

    public void setDiasEncuestaPosgrado(Long diasEncuestaPosgrado) {
        this.diasEncuestaPosgrado = diasEncuestaPosgrado;
    }

}
