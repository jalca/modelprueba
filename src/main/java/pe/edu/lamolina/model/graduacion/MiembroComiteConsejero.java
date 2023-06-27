package pe.edu.lamolina.model.graduacion;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.enums.MiembroConsejeroEstadoEnum;
import pe.edu.lamolina.model.enums.TipoAsesorEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "epg_miembro_comite_consejero")
public class MiembroComiteConsejero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comite_consejero")
    private ComiteConsejero comiteConsejero;

    @Column(name = "origen")
    private String origen;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_rechazo")
    private String motivoRechazo;

    @Column(name = "titulo_grado")
    private String tituloGrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asesor_externo")
    private AsesorExterno asesorExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curriculum_vitae")
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_consejero")
    private TipoConsejeroComite tipoConsejeroComite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificación")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @Transient
    private List<Docente> docentes;

    public MiembroComiteConsejero(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoAsesorEnum getOrigenEnum() {
        if (origen == null) {
            return null;
        }
        return TipoAsesorEnum.valueOf(origen);
    }

    @JsonIgnore
    public void setOrigenEnum(TipoAsesorEnum origen) {
        if (origen == null) {
            return;
        }
        this.origen = origen.name();
    }

    public MiembroConsejeroEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return MiembroConsejeroEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(MiembroConsejeroEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public static class CompareOrdenTipoMiembro implements Comparator<MiembroComiteConsejero> {

        @Override
        public int compare(MiembroComiteConsejero mcc1, MiembroComiteConsejero mcc2) {
            TipoConsejeroComite tcc1 = mcc1.tipoConsejeroComite;
            TipoConsejeroComite tcc2 = mcc2.tipoConsejeroComite;
            return tcc1.getOrden().compareTo(tcc2.getOrden());
        }
    }

}
