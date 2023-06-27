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
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(catalog = "lamolina", name = "esc_experiencia_asesor")
public class ExperienciaAsesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_tesis")
    private String tipoTesis;

    @Column(name = "tesista")
    private String tesista;

    @Column(name = "url_repositorio")
    private String urlRepositorio;

    @Column(name = "fecha_aceptacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaAceptacion;

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

    public ExperienciaAsesor() {
    }

    public ExperienciaAsesor(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTesis() {
        return tipoTesis;
    }

    public void setTipoTesis(String tipoTesis) {
        this.tipoTesis = tipoTesis;
    }

    public String getTesista() {
        return tesista;
    }

    public void setTesista(String tesista) {
        this.tesista = tesista;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
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

    public GradoEscalafonEnum getTipoTesisEnum() {
        if (StringUtils.isBlank(tipoTesis)) {
            return null;
        }
        return GradoEscalafonEnum.valueOf(tipoTesis);
    }

    @JsonIgnore
    public void setTipoTesisEnum(GradoEscalafonEnum tipoTesisEnum) {
        this.tipoTesis = tipoTesisEnum.name();
    }
}
