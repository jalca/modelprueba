package pe.edu.lamolina.model.escalafon;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.apache.commons.lang3.StringUtils;
import pe.edu.lamolina.model.escalafon.enums.GradoEscalafonEnum;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(catalog = "lamolina", name = "esc_academico_escalafon")
public class AcademicoEscalafon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "institucion")
    private String institucion;

    @Column(name = "grado")
    private String grado;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaFin;

    @Column(name = "confirmado")
    private Boolean confirmado;

    @Column(name = "nota_confirmacion")
    private String notaConfirmacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escalafon")
    private Escalafon escalafon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public AcademicoEscalafon() {
    }

    public AcademicoEscalafon(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
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

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public GradoEscalafonEnum getGradoEnum() {
        if (StringUtils.isBlank(grado)) {
            return null;
        }
        return GradoEscalafonEnum.valueOf(grado);
    }

    @JsonIgnore
    public void setGradoEnum(GradoEscalafonEnum gradoEscalafonEnum) {
        this.grado = gradoEscalafonEnum.name();
    }
}
