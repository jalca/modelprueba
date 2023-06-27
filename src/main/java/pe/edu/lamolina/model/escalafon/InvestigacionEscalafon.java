package pe.edu.lamolina.model.escalafon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.util.Date;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.persistence.Id;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(catalog = "lamolina", name = "esc_investigacion_escalafon")
public class InvestigacionEscalafon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "investigadores")
    private String investigadores;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFin;

    @Column(name = "url_repositorio")
    private String urlRepositorio;

    @Column(name = "confirmado")
    private Boolean confirmado;

    @Column(name = "nota_confirmacion")
    private String notaConfirmacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escalafon")
    private Escalafon escalafon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area")
    private AreaInvestigacion area;

    public InvestigacionEscalafon() {
    }

    public InvestigacionEscalafon(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(String investigadores) {
        this.investigadores = investigadores;
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

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getNotaConfirmacion() {
        return notaConfirmacion;
    }

    public void setNotaConfirmacion(String notaConfirmacion) {
        this.notaConfirmacion = notaConfirmacion;
    }

    public Escalafon getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Escalafon escalafon) {
        this.escalafon = escalafon;
    }

    public AreaInvestigacion getArea() {
        return area;
    }

    public void setArea(AreaInvestigacion area) {
        this.area = area;
    }
}
