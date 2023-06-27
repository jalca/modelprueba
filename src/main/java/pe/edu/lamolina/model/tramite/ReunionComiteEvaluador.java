package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.enums.EstadoReunionComiteEvaluadorEnum;
import pe.edu.lamolina.model.enums.ResultadoReunionComiteEvaluadorEnum;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "epg_reunion_comite_evaluador")
public class ReunionComiteEvaluador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "instancia")
    private Long instancia;

    @Column(name = "fecha_reunion")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaReunion;

    @Column(name = "fecha_acta")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaActa;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tramite")
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registra")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "reunionComiteEvaluador", fetch = FetchType.LAZY)
    private List<MiembroComiteEvaluador> miembroComiteEvaluador;
    
    @Transient
    private int cantidadMiembros;

    public ReunionComiteEvaluador() {
    }

    public ReunionComiteEvaluador(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ResultadoReunionComiteEvaluadorEnum getResultadoEnum() {
        if (StringUtils.isBlank(resultado)) {
            return null;
        }
        return ResultadoReunionComiteEvaluadorEnum.valueOf(this.resultado);
    }

    @JsonIgnore
    public void setResultadoEnum(ResultadoReunionComiteEvaluadorEnum resultadoEnum) {
        this.resultado = resultadoEnum.name();
    }

    public EstadoReunionComiteEvaluadorEnum getEstadoEnum() {
        if (StringUtils.isBlank(this.estado)) {
            return null;
        }
        return EstadoReunionComiteEvaluadorEnum.valueOf(this.estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoReunionComiteEvaluadorEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public Long getInstancia() {
        return instancia;
    }

    public void setInstancia(Long instancia) {
        this.instancia = instancia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public Date getFechaActa() {
        return fechaActa;
    }

    public void setFechaActa(Date fechaActa) {
        this.fechaActa = fechaActa;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<MiembroComiteEvaluador> getMiembroComiteEvaluador() {
        return miembroComiteEvaluador;
    }

    public void setMiembroComiteEvaluador(List<MiembroComiteEvaluador> miembroComiteEvaluador) {
        this.miembroComiteEvaluador = miembroComiteEvaluador;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public void setCantidadMiembros(int cantidadMiembros) {
        this.cantidadMiembros = cantidadMiembros;
    }
        
}
