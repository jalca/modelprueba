package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.croacia.HistoMy;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import pe.edu.lamolina.model.enums.OrigenDataSituacionAcademicaEnum;
import pe.edu.lamolina.model.enums.TipoMigracionEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.AutorizacionRegistro;
import pe.edu.lamolina.model.tramite.ConvalidacionInterna;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "aca_alumno_ciclo_curso")
public class AlumnoCicloCurso implements Serializable, Cloneable {

    public static final String ORIGEN_DATA_MAT = "MATRICULA";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "nota")
    private String nota;

    @Column(name = "esta_aprobado")
    private Integer estaAprobado;

    @Column(name = "origen_data")
    private String origenData;

    @Column(name = "registro_activo")
    private Integer registroActivo;

    @Column(name = "tipo_migracion")
    private String tipoMigracion;

    @Column(name = "user_migracion")
    private String userMigracion;

    @Column(name = "es_equivalente")
    private Boolean esEquivalente;

    @Column(name = "veces_cursado")
    private Integer vecesCursado;

    @Column(name = "veces_cursado_regular")
    private Integer vecesCursadoRegular;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_migracion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaMigracion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_ciclo")
    private AlumnoCiclo alumnoCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso_equivalente")
    private Curso cursoEquivalente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_ciclo_curso_origen")
    private AlumnoCicloCurso alumnoCicloCursoOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_curso_curricula")
    private TipoCursoCurricula tipoCursoCurricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autorizacion_registro")
    private AutorizacionRegistro autorizacionRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_convalidacion_interna")
    private ConvalidacionInterna convalidacionInterna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario usuarioRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private Integer vecesCursadoTransient;

    @Transient
    private Integer esCaduco;

    public AlumnoCicloCurso() {
    }

    public AlumnoCicloCurso(Long idAlumno, Long idCurso, Long veces) {
        this.alumnoCiclo = new AlumnoCiclo();
        this.alumnoCiclo.setAlumno(new Alumno(idAlumno));
        this.curso = new Curso(idCurso);
        this.vecesCursado = veces.intValue();
    }

    public AlumnoCicloCurso(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public AlumnoCicloCurso(
            AlumnoCiclo alumnoCiclo,
            Curso curso,
            HistoMy histoMy,
            EstadoMatriculaEnum estadoMatriculaEnum,
            Integer registroActivo,
            Usuario usuario) {

        this.alumnoCiclo = alumnoCiclo;
        //  alumnoCicloCurso.setAutorizacionRegistro(autorizacionRegistro); wtf
        this.creditos = histoMy.getCurCredit();
        this.curso = curso;
        this.estaAprobado = histoMy.getFlagAprobado().equals("SI") ? 1 : 0;
        this.userMigracion = histoMy.getUsuario();

        this.estado = estadoMatriculaEnum.name();
        this.fechaModificacion = null;
        if (histoMy.getFechaMov() != null) {
            this.fechaRegistro = histoMy.getFechaMov();
        } else {

            DateTime nullDate = new DateTime()
                    .withYear(2000)
                    .withMonthOfYear(DateTimeConstants.JANUARY)
                    .withDayOfMonth(BigDecimal.ONE.intValue())
                    .withTime(0, 0, 0, 0);
            this.fechaRegistro = nullDate.toDate();

        }
        this.nota = histoMy.getNota();
        this.origenData = histoMy.gettMov() == null ? "NFOUND" : histoMy.gettMov();

        this.registroActivo = registroActivo;
        this.userModificacion = usuario;
        this.usuarioRegistro = usuario;
        if (this.origenData != null && this.origenData.equals("RET")) {
            this.estado = EstadoMatriculaEnum.RCI.name();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoCiclo getAlumnoCiclo() {
        return alumnoCiclo;
    }

    public void setAlumnoCiclo(AlumnoCiclo alumnoCiclo) {
        this.alumnoCiclo = alumnoCiclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estado) {
        this.estado = estado.name();
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(this.getEstado());
    }

    public Integer getCreditos() {
        if (creditos == null) {
            return 0;
        }
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getEstaAprobado() {
        return estaAprobado;
    }

    public void setEstaAprobado(Integer estaAprobado) {
        this.estaAprobado = estaAprobado;
    }

    public boolean isAprobado() {
        if (this.estaAprobado != null) {
            return (this.estaAprobado.compareTo(BigDecimal.ONE.intValue()) == 0);
        }
        return false;
    }

    public String getOrigenData() {
        return origenData;
    }

    public void setOrigenData(OrigenDataSituacionAcademicaEnum origenData) {
        this.origenData = origenData.name();
    }

    public Integer getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(Integer registroActivo) {
        this.registroActivo = registroActivo;
    }

    public boolean isBooleanRegistroActivo() {
        return BigDecimal.ONE.intValue() == this.getRegistroActivo();
    }

    public AutorizacionRegistro getAutorizacionRegistro() {
        return autorizacionRegistro;
    }

    public void setAutorizacionRegistro(AutorizacionRegistro autorizacionRegistro) {
        this.autorizacionRegistro = autorizacionRegistro;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistroString() {
        if (this.fechaRegistro == null) {
            return null;
        }
        String fechaMov = TypesUtil.getStringDate(this.getFechaRegistro(), "dd/MM/yyyy H:mm:ss");
        return fechaMov;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getVecesCursado() {
        return vecesCursado;
    }

    public void setVecesCursado(Integer vecesCursado) {
        this.vecesCursado = vecesCursado;
    }

    public Integer getVecesCursadoTransient() {
        if (vecesCursadoTransient == null) {
            return vecesCursado;
        }
        return vecesCursadoTransient;
    }

    public void setVecesCursadoTransient(Integer vecesCursadoTransient) {
        this.vecesCursadoTransient = vecesCursadoTransient;
    }

    public AlumnoCicloCurso getAlumnoCicloCursoOrigen() {
        return alumnoCicloCursoOrigen;
    }

    public void setAlumnoCicloCursoOrigen(AlumnoCicloCurso alumnoCicloCursoOrigen) {
        this.alumnoCicloCursoOrigen = alumnoCicloCursoOrigen;
    }

    public Integer getVecesCursadoRegular() {
        return vecesCursadoRegular;
    }

    public void setVecesCursadoRegular(Integer vecesCursadoRegular) {
        this.vecesCursadoRegular = vecesCursadoRegular;
    }

    public Date getFechaMigracion() {
        return fechaMigracion;
    }

    public void setFechaMigracion(Date fechaMigracion) {
        this.fechaMigracion = fechaMigracion;
    }

    public String getTipoMigracion() {
        return tipoMigracion;
    }

    public void setTipoMigracion(TipoMigracionEnum tipoMigracionEnum) {
        this.tipoMigracion = tipoMigracionEnum.name();
    }

    public String getUserMigracion() {
        return userMigracion;
    }

    public void setUserMigracion(String userMigracion) {
        this.userMigracion = userMigracion;
    }

    public TipoCursoCurricula getTipoCursoCurricula() {
        return tipoCursoCurricula;
    }

    public void setTipoCursoCurricula(TipoCursoCurricula tipoCursoCurricula) {
        this.tipoCursoCurricula = tipoCursoCurricula;
    }

    public Curso getCursoEquivalente() {
        return cursoEquivalente;
    }

    public void setCursoEquivalente(Curso cursoEquivalente) {
        this.cursoEquivalente = cursoEquivalente;
    }

    public Boolean getEsEquivalente() {
        return esEquivalente;
    }

    public void setEsEquivalente(Boolean esEquivalente) {
        this.esEquivalente = esEquivalente;
    }

    public ConvalidacionInterna getConvalidacionInterna() {
        return convalidacionInterna;
    }

    public void setConvalidacionInterna(ConvalidacionInterna convalidacionInterna) {
        this.convalidacionInterna = convalidacionInterna;
    }

    public String getKeyCicloCurso() {
        if (this.curso == null) {
            return null;
        }
        if (this.alumnoCiclo == null) {
            return null;
        }
        if (this.alumnoCiclo.getCicloAcademico() == null) {
            return null;
        }
        return this.alumnoCiclo.getCicloAcademico().getId() + "-" + this.curso.getId();
    }

    public String getAlumnoCursoKey() {
        if (this.alumnoCiclo == null) {
            return null;
        }
        if (this.alumnoCiclo.getAlumno() == null) {
            return null;
        }
        if (this.alumnoCiclo.getAlumno().getId() == null) {
            return null;
        }
        if (this.curso == null) {
            return null;
        }
        if (this.curso.getId() == null) {
            return null;
        }
        return this.getAlumnoCiclo().getAlumno().getId() + "-" + this.curso.getId();
    }

    public String getAlumnoCicloCursoKey() {
        if (this.alumnoCiclo == null) {
            return null;
        }
        if (this.alumnoCiclo.getAlumno() == null) {
            return null;
        }
        if (this.alumnoCiclo.getAlumno().getId() == null) {
            return null;
        }
        if (this.alumnoCiclo.getCicloAcademico() == null) {
            return null;
        }
        if (this.alumnoCiclo.getCicloAcademico().getId() == null) {
            return null;
        }
        if (this.curso == null) {
            return null;
        }
        if (this.curso.getId() == null) {
            return null;
        }
        return this.getAlumnoCiclo().getAlumno().getId() + "-" + this.getAlumnoCiclo().getCicloAcademico().getId() + "-" + this.curso.getId();
    }

    public boolean getEstaActivo() {
        if (this.getRegistroActivo().compareTo(BigDecimal.ONE.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoMatriculado() {
        if (EstadoMatriculaEnum.MAT.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoRCU() {
        if (EstadoMatriculaEnum.RCU.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoRCI() {
        if (EstadoMatriculaEnum.RCI.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoRET() {
        if (EstadoMatriculaEnum.RET.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoNotaModificada() {
        if (EstadoMatriculaEnum.NMOD.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoNotaEliminada() {
        if (EstadoMatriculaEnum.NELI.equals(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsHijo() {
        if (ObjectUtil.getParentTree(this, "alumnoCicloCursoOrigen.id") != null) {
            return true;
        }
        return false;
    }

    public static class CompareCursoCiclo implements Comparator<AlumnoCicloCurso> {

        @Override
        public int compare(AlumnoCicloCurso acc1, AlumnoCicloCurso acc2) {
            Curso c1 = acc1.getCurso();
            Curso c2 = acc2.getCurso();
            int comparacion = c1.getNombre().compareTo(c2.getNombre());
            if (comparacion == 0) {
                CicloAcademico ca1 = acc1.alumnoCiclo.getCicloAcademico();
                CicloAcademico ca2 = acc2.alumnoCiclo.getCicloAcademico();
                comparacion = ca1.getCodigo().compareTo(ca2.getCodigo());
            }
            return comparacion;
        }
    }

    public static class CompareCiclo implements Comparator<AlumnoCicloCurso> {

        @Override
        public int compare(AlumnoCicloCurso acc1, AlumnoCicloCurso acc2) {
            CicloAcademico ca1 = acc1.alumnoCiclo.getCicloAcademico();
            CicloAcademico ca2 = acc2.alumnoCiclo.getCicloAcademico();
            return ca1.getCodigo().compareTo(ca2.getCodigo());
        }
    }

    public void defaultValuesToCreate(AlumnoCiclo alumnoCiclo, Curso curso, MatriculaCurso matriculaCurso, Usuario usuario) {
        this.setAlumnoCiclo(alumnoCiclo);
        if (curso.isTieneCreditosVariables()) {
            this.setCreditos(matriculaCurso.getCreditosAprobados());
        } else {
            this.setCreditos(matriculaCurso.getCreditos());
        }
        this.setCurso(curso);

        this.setEstadoEnum(matriculaCurso.getEstadoEnum());
        this.setNota(matriculaCurso.getNotaFinal());
        this.setOrigenData(OrigenDataSituacionAcademicaEnum.ACTA);
        this.setRegistroActivo(BigDecimal.ONE.intValue());
        this.setFechaRegistro(new Date());
        this.setUsuarioRegistro(usuario);
    }

    @Override
    public String toString() {
        return "AlumnoCicloCurso{" + "id=" + id + ", estado=" + estado + ", creditos=" + creditos + ", nota=" + nota + ", estaAprobado=" + estaAprobado + '}';
    }

    public Integer getEsCaduco() {
        if (esCaduco == null) {
            return 0;
        }
        return esCaduco;
    }

    public void setEsCaduco(Integer esCaduco) {
        this.esCaduco = esCaduco;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
