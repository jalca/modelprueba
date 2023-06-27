package pe.edu.lamolina.model.socioeconomico;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.activadorficha.TipoVigenciaEnum;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "isec_activador_ficha")
public class ActivadorFicha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "mensaje_obligatorio")
    private String mensajeObligatorio;

    @Column(name = "mensaje_opcional")
    private String mensajeOpcional;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Transient
    private List<MenuActivarFicha> menusActivador;
    @Transient
    private String rutaCrearFicha;

    public ActivadorFicha() {
    }

    public ActivadorFicha(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public TipoVigenciaEnum getVigenciaEnum() {
        Date hoy = new LocalDate().toDate();
        Date fin = this.fechaFin;
        if (fin == null) {
            fin = new LocalDate(hoy).plusDays(5).toDate();
        }

        if (hoy.compareTo(this.fechaInicio) >= 0
                && hoy.compareTo(fin) <= 0) {
            return TipoVigenciaEnum.VIGENTE;
        }

        if (hoy.compareTo(fin) > 0) {
            return TipoVigenciaEnum.PASADO;
        }

        return TipoVigenciaEnum.FUTURO;
    }

    public String getNombre() {
        if (this.fechaInicio == null) {
            return null;
        }
        if (this.fechaFin == null) {
            return null;
        }
        if (this.id == null) {
            return null;
        }

        String inicio = new DateTime(this.fechaInicio).toString("dd/MM/yyyy");
        String fin = new DateTime(this.fechaFin).toString("dd/MM/yyyy");
        return this.id + " - [" + inicio + " hasta " + fin + "]";
    }

}
