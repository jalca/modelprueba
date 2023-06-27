package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoGestionObuaeEnum;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "gen_colegio")
public class Colegio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_modular")
    private String codigoModular;

    @Column(name = "anexo")
    private String anexo;

    @Column(name = "codigo_local")
    private String codigoLocal;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "centro_poblado")
    private String centroPoblado;

    @Column(name = "area")
    private Integer area;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "es_coar")
    private Integer esCoar;

    @Column(name = "tipo_obuae")
    private String tipoObuae;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_coar")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCoar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_modalidad")
    private NivelModalidadColegio nivelModalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_forma_atencion")
    private FormaAtencionColegio formaAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gestion_dependencia")
    private GestionDependenciaColegio gestionDependencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gestion")
    private GestionColegio gestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caracteristica")
    private CaracteristicaColegio caracteristica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_coar")
    private Usuario userCoar;

    @OneToMany(mappedBy = "colegioProcedencia", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    public Colegio() {
    }

    public Colegio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getNombreLargo() {
        if (this.formaAtencion == null) {
            return null;
        }
        return "[" + codigoModular + "-" + anexo + "] " + nombre + " / " + this.formaAtencion.getNombre();
    }

    public String getNombreJson() {
        if (this.formaAtencion == null) {
            return null;
        }
        return codigoModular + "::::" + anexo + "::::" + nombre + "::::" + this.formaAtencion.getNombre();
    }

    public String getCodigoAnexo() {
        return codigoModular + "::::" + anexo;
    }

    public TipoGestionObuaeEnum getTipoObuaeEnum() {
        if (tipoObuae == null) {
            return null;
        }
        return TipoGestionObuaeEnum.valueOf(tipoObuae);
    }

    @JsonIgnore
    public void setTipoObuaeEnum(TipoGestionObuaeEnum tipoObuae) {
        if (tipoObuae == null) {
            return;
        }
        this.tipoObuae = tipoObuae.name();
    }

    public boolean isCoar() {
        if (esCoar == null) {
            return false;
        }
        return esCoar == 1;
    }

    public ObjectNode toJson() {

        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Ubicacion ubica = this.ubicacion == null ? new Ubicacion() : this.ubicacion;
        NivelModalidadColegio nivelModal = this.nivelModalidad == null ? new NivelModalidadColegio() : this.nivelModalidad;
        FormaAtencionColegio formaAten = this.formaAtencion == null ? new FormaAtencionColegio() : this.formaAtencion;
        GestionDependenciaColegio gestionDependen = this.gestionDependencia == null ? new GestionDependenciaColegio() : this.gestionDependencia;
        GestionColegio gestio = this.gestion == null ? new GestionColegio() : this.gestion;
        CaracteristicaColegio caracteristic = this.caracteristica == null ? new CaracteristicaColegio() : this.caracteristica;
        Usuario userReg = this.userRegistro == null ? new Usuario() : this.userRegistro;
        Usuario usrCoar = this.userCoar == null ? new Usuario() : this.userCoar;

        json.set("ubicacion", JsonHelper.createJson(ubica, JsonNodeFactory.instance));
        json.set("nivelModalidad", JsonHelper.createJson(nivelModal, JsonNodeFactory.instance));
        json.set("formaAtencion", JsonHelper.createJson(formaAten, JsonNodeFactory.instance));
        json.set("gestionDependencia", JsonHelper.createJson(gestionDependen, JsonNodeFactory.instance));
        json.set("gestion", JsonHelper.createJson(gestio, JsonNodeFactory.instance));
        json.set("caracteristica", JsonHelper.createJson(caracteristic, JsonNodeFactory.instance));
        json.set("userRegistro", JsonHelper.createJson(userReg, JsonNodeFactory.instance));
        json.set("userCoar", JsonHelper.createJson(usrCoar, JsonNodeFactory.instance));

        return json;
    }
}
