package pe.edu.lamolina.model.examen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.academico.Seccion;
import pe.edu.lamolina.model.enums.encuesta.TipoObjetivoCursoEnum;
import pe.edu.lamolina.model.enums.encuesta.TipoObjetivoFacultadEnum;
import pe.edu.lamolina.model.enums.encuesta.TipoObjetivoMatriculablesEnum;
import pe.edu.lamolina.model.seguridad.AnuncioDashboard;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "exam_grupo_objetivo")
public class GrupoObjetivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_matriculables")
    private String tipoMatriculables;

    @Column(name = "modalidades_estudio")
    private String modalidadesEstudio;

    @Column(name = "ciclos_ingresantes")
    private String ciclosIngresantes;

    @Column(name = "tipo_facultad_carrera")
    private String tipoFacultadCarrera;

    @Column(name = "carreras_facultades")
    private String carrerasFacultades;

    @Column(name = "tipo_curso_seccion")
    private String tipoCursoSeccion;

    @Column(name = "cursos_secciones")
    private String cursosSecciones;

    @Column(name = "encuestables")
    private Integer encuestables;

    @Column(name = "encuestados")
    private Integer encuestados;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_encuesta_publicada")
    private EncuestaPublicada encuestaPublicada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anuncio_dashboard")
    private AnuncioDashboard anuncioDashboard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<ModalidadEstudio> modalidades;
    @Transient
    private List<CicloAcademico> ciclos;
    @Transient
    private List<Facultad> facultades;
    @Transient
    private List<Carrera> carreras;
    @Transient
    private List<Curso> cursos;
    @Transient
    private List<Seccion> secciones;
    @Transient
    private List<Alumno> alumnos;

    @Transient
    private List<ModalidadGrupoObjetivo> modalidadesGruposObjetivos;
    @Transient
    private List<CicloIngresoGrupoObjetivo> ciclosIngresosGruposObjetivos;
    @Transient
    private List<FacultadGrupoObjetivo> facultadesGruposObjetivos;
    @Transient
    private List<CarreraGrupoObjetivo> carrerasGruposObjetivos;
    @Transient
    private List<CursoGrupoObjetivo> cursosGruposObjetivos;
    @Transient
    private List<SeccionGrupoObjetivo> seccionesGruposObjetivos;
    @Transient
    private List<AlumnoGrupoObjetivo> alumnosGruposObjetivos;

    @Transient
    private Integer modalidadesCantidad;
    @Transient
    private Integer ciclosCantidad;
    @Transient
    private Integer facultadesCantidad;
    @Transient
    private Integer carrerasCantidad;
    @Transient
    private Integer cursosCantidad;
    @Transient
    private Integer seccionesCantidad;
    @Transient
    private Integer alumnosCantidad;

    public GrupoObjetivo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoObjetivoMatriculablesEnum getTipoMatriculablesEnum() {
        if (tipoMatriculables == null) {
            return null;
        }

        return TipoObjetivoMatriculablesEnum.valueOf(tipoMatriculables);
    }

    @JsonIgnore
    public void setTipoMatriculablesEnum(TipoObjetivoMatriculablesEnum tipoMatriculables) {
        if (tipoMatriculables == null) {
            return;
        }
        this.tipoMatriculables = tipoMatriculables.name();
    }

    public TipoObjetivoFacultadEnum getTipoFacultadCarreraEnum() {
        if (tipoFacultadCarrera == null) {
            return null;
        }

        return TipoObjetivoFacultadEnum.valueOf(tipoFacultadCarrera);
    }

    @JsonIgnore
    public void setTipoFacultadCarreraEnum(TipoObjetivoFacultadEnum tipoFacultadCarrera) {
        if (tipoFacultadCarrera == null) {
            return;
        }
        this.tipoFacultadCarrera = tipoFacultadCarrera.name();
    }

    public TipoObjetivoCursoEnum getTipoCursoSeccionEnum() {
        if (tipoCursoSeccion == null) {
            return null;
        }

        return TipoObjetivoCursoEnum.valueOf(tipoCursoSeccion);
    }

    @JsonIgnore
    public void setTipoCursoSeccionEnum(TipoObjetivoCursoEnum tipoCursoSeccion) {
        if (tipoCursoSeccion == null) {
            return;
        }
        this.tipoCursoSeccion = tipoCursoSeccion.name();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "tipoMatriculables", tipoMatriculables, false);
        ModelUtils.getDataByAttr(join, "modalidadesEstudio", modalidadesEstudio, false);
        ModelUtils.getDataByAttr(join, "ciclosIngresantes", ciclosIngresantes, false);
        ModelUtils.getDataByAttr(join, "tipoFacultadCarrera", tipoFacultadCarrera, false);
        ModelUtils.getDataByAttr(join, "carrerasFacultades", carrerasFacultades, false);
        ModelUtils.getDataByAttr(join, "tipoCursoSeccion", tipoCursoSeccion, false);
        ModelUtils.getDataByAttr(join, "cursosSecciones", cursosSecciones, false);
        ModelUtils.getDataByAttr(join, "encuestables", encuestables, false);
        ModelUtils.getDataByAttr(join, "encuestados", encuestados, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModificacion", fechaModificacion, false);
        ModelUtils.getDataByAttrObject(join, "encuestaPublicada", encuestaPublicada, "id");
        ModelUtils.getDataByAttrObject(join, "anuncioDashboard", anuncioDashboard, "id");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");
        ModelUtils.getDataByAttrObject(join, "userModificacion", userModificacion, "id", "google");

        return join.toString();
    }
}
