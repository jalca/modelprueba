package pe.edu.lamolina.model.encuestaestudiantil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EncuestaEstadoEnum;
import pe.edu.lamolina.model.examen.ExamenVirtual;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "exam_encuesta_estudiantil")
public class EncuestaEstudiantil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "objetivos_encuesta")
    private Integer objetivosEncuesta;

    @Column(name = "objetivos_encuestados")
    private Integer objetivosEncuestados;

    @Column(name = "encuestas_programadas")
    private Integer encuestasProgramadas;

    @Column(name = "encuestas_ejecutadas")
    private Integer encuestasEjecutadas;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta")
    private ExamenVirtual encuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @OneToMany(mappedBy = "encuestaEstudiantil", fetch = FetchType.LAZY)
    private List<ConfiguraEncuesta> configuraEncuesta;

    @OneToMany(mappedBy = "encuestaEstudiantil", fetch = FetchType.LAZY)
    private List<PeriodoEncuesta> periodosEncuesta;

    @OneToMany(mappedBy = "encuestaEstudiantil", fetch = FetchType.LAZY)
    private List<CursoSinEncuesta> cursosNoEncuestar;

    @Transient
    private Integer encuestasCerradas;
    @Transient
    private Integer encuestasInnecesarias;
    @Transient
    private Integer encuestasAnuladas;
    @Transient
    private Integer encuestasActivas;
    @Transient
    private Integer encuestasSinPeriodo;
    @Transient
    private Integer encuestasPosgrado;
    @Transient
    private Integer encuestasPregrado;
    @Transient
    private Integer encuestasModulares;
    @Transient
    private Integer encuestasSemestrales;
    
    @Transient
    private Long totalEncuestaAlumnoPregrado;
    @Transient
    private Long pendienteEncuestaAlumnoPregrado;
    
    @Transient
    private Long totalEncuestaAlumnoPosgrado;
    @Transient
    private Long pendienteEncuestaAlumnoPosgrado;
    
    public EncuestaEstudiantil() {
    }

    public EncuestaEstudiantil(Object id) {
        this.id = TypesUtil.getLong(id);
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

    public EncuestaEstadoEnum getEstadoEnum() {
        if (StringUtils.isEmpty(estado)) {
            return null;
        }
        return EncuestaEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EncuestaEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Integer getObjetivosEncuesta() {
        return objetivosEncuesta;
    }

    public void setObjetivosEncuesta(Integer objetivosEncuesta) {
        this.objetivosEncuesta = objetivosEncuesta;
    }

    public Integer getObjetivosEncuestados() {
        return objetivosEncuestados;
    }

    public void setObjetivosEncuestados(Integer objetivosEncuestados) {
        this.objetivosEncuestados = objetivosEncuestados;
    }

    public Integer getEncuestasProgramadas() {
        return encuestasProgramadas;
    }

    public void setEncuestasProgramadas(Integer encuestasProgramadas) {
        this.encuestasProgramadas = encuestasProgramadas;
    }

    public Integer getEncuestasEjecutadas() {
        return encuestasEjecutadas;
    }

    public void setEncuestasEjecutadas(Integer encuestasEjecutadas) {
        this.encuestasEjecutadas = encuestasEjecutadas;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public ExamenVirtual getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(ExamenVirtual encuesta) {
        this.encuesta = encuesta;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public List<ConfiguraEncuesta> getConfiguraEncuesta() {
        return configuraEncuesta;
    }

    public void setConfiguraEncuesta(List<ConfiguraEncuesta> configuraEncuesta) {
        this.configuraEncuesta = configuraEncuesta;
    }

    public List<PeriodoEncuesta> getPeriodosEncuesta() {
        return periodosEncuesta;
    }

    public void setPeriodosEncuesta(List<PeriodoEncuesta> periodosEncuesta) {
        this.periodosEncuesta = periodosEncuesta;
    }

    public List<CursoSinEncuesta> getCursosNoEncuestar() {
        return cursosNoEncuestar;
    }

    public void setCursosNoEncuestar(List<CursoSinEncuesta> cursosNoEncuestar) {
        this.cursosNoEncuestar = cursosNoEncuestar;
    }

    public Integer getEncuestasCerradas() {
        return encuestasCerradas;
    }

    public void setEncuestasCerradas(Integer encuestasCerradas) {
        this.encuestasCerradas = encuestasCerradas;
    }

    public Integer getEncuestasInnecesarias() {
        return encuestasInnecesarias;
    }

    public void setEncuestasInnecesarias(Integer encuestasInnecesarias) {
        this.encuestasInnecesarias = encuestasInnecesarias;
    }

    public Integer getEncuestasAnuladas() {
        return encuestasAnuladas;
    }

    public void setEncuestasAnuladas(Integer encuestasAnuladas) {
        this.encuestasAnuladas = encuestasAnuladas;
    }

    public Integer getEncuestasActivas() {
        return encuestasActivas;
    }

    public void setEncuestasActivas(Integer encuestasActivas) {
        this.encuestasActivas = encuestasActivas;
    }

    public Integer getEncuestasSinPeriodo() {
        return encuestasSinPeriodo;
    }

    public void setEncuestasSinPeriodo(Integer encuestasSinPeriodo) {
        this.encuestasSinPeriodo = encuestasSinPeriodo;
    }

    public Integer getEncuestasPosgrado() {
        return encuestasPosgrado;
    }

    public void setEncuestasPosgrado(Integer encuestasPosgrado) {
        this.encuestasPosgrado = encuestasPosgrado;
    }

    public Integer getEncuestasPregrado() {
        return encuestasPregrado;
    }

    public void setEncuestasPregrado(Integer encuestasPregrado) {
        this.encuestasPregrado = encuestasPregrado;
    }

    public Integer getEncuestasModulares() {
        return encuestasModulares;
    }

    public void setEncuestasModulares(Integer encuestasModulares) {
        this.encuestasModulares = encuestasModulares;
    }

    public Integer getEncuestasSemestrales() {
        return encuestasSemestrales;
    }

    public void setEncuestasSemestrales(Integer encuestasSemestrales) {
        this.encuestasSemestrales = encuestasSemestrales;
    }

    public static class ComparePeriodo implements Comparator<EncuestaEstudiantil> {

        @Override
        public int compare(EncuestaEstudiantil cp1, EncuestaEstudiantil cp2) {
            CicloAcademico ciclo1 = cp1.getCicloAcademico();
            CicloAcademico ciclo2 = cp2.getCicloAcademico();

            return ciclo2.getCodigo().compareTo(ciclo1.getCodigo());
        }
    }

    public Long getTotalEncuestaAlumnoPregrado() {
        return totalEncuestaAlumnoPregrado;
    }

    public void setTotalEncuestaAlumnoPregrado(Long totalEncuestaAlumnoPregrado) {
        this.totalEncuestaAlumnoPregrado = totalEncuestaAlumnoPregrado;
    }

    public Long getPendienteEncuestaAlumnoPregrado() {
        return pendienteEncuestaAlumnoPregrado;
    }

    public void setPendienteEncuestaAlumnoPregrado(Long pendienteEncuestaAlumnoPregrado) {
        this.pendienteEncuestaAlumnoPregrado = pendienteEncuestaAlumnoPregrado;
    }

    public Long getTotalEncuestaAlumnoPosgrado() {
        return totalEncuestaAlumnoPosgrado;
    }

    public void setTotalEncuestaAlumnoPosgrado(Long totalEncuestaAlumnoPosgrado) {
        this.totalEncuestaAlumnoPosgrado = totalEncuestaAlumnoPosgrado;
    }

    public Long getPendienteEncuestaAlumnoPosgrado() {
        return pendienteEncuestaAlumnoPosgrado;
    }

    public void setPendienteEncuestaAlumnoPosgrado(Long pendienteEncuestaAlumnoPosgrado) {
        this.pendienteEncuestaAlumnoPosgrado = pendienteEncuestaAlumnoPosgrado;
    }

    
}
