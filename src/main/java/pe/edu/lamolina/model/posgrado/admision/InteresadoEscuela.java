package pe.edu.lamolina.model.posgrado.admision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.TipoDocIdentidad;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "epg_interesado_escuela")
public class InteresadoEscuela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "google")
    private String google;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "user_clave")
    private String userClave;

    @Column(name = "razon_token")
    private String razonToken;

    @Column(name = "token")
    private String token;

    @Column(name = "estado_token")
    private String estadoToken;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "fecha_vence_token")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaVenceToken;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_registro")
    private CicloEscuela cicloRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocIdentidad tipoDocIdentidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private String tipoLogin;

    public InteresadoEscuela() {
    }

    public InteresadoEscuela(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    @JsonIgnore
    public String getNombreCompleto() {
        if (this.tieneNombre()) {
            return this.nombres
                    + (StringUtils.isEmpty(this.paterno) ? "" : (" " + this.paterno))
                    + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno));
        } else {
            return null;
        }
    }

    private boolean tieneNombre() {
        return !StringUtils.isEmpty(paterno)
                || !StringUtils.isEmpty(materno)
                || !StringUtils.isEmpty(nombres);
    }

    @JsonIgnore
    public String getApellidosNombres() {
        if (tieneNombre()) {
            return (StringUtils.isEmpty(this.paterno) ? "" : this.paterno)
                    + (StringUtils.isEmpty(this.materno) ? "" : (" " + this.materno))
                    + ", " + this.nombres;
        } else {
            return null;
        }
    }

    @JsonIgnore
    public String getAvatar() {
        int loop = 0;
        String avatar = "";
        if (!StringUtils.isBlank(this.nombres)) {
            avatar += this.nombres.substring(0, 1).toUpperCase();
            loop++;
        }
        if (!StringUtils.isBlank(this.paterno)) {
            avatar += this.paterno.substring(0, 1).toUpperCase();
            loop++;
        }

        if (loop < 2) {
            if (!StringUtils.isBlank(this.materno)) {
                avatar += this.materno.substring(0, 1).toUpperCase();
                loop++;
            }
        }
        return avatar;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "paterno", paterno);
        ModelUtils.getDataByAttr(join, "materno", materno);
        ModelUtils.getDataByAttr(join, "nombres", nombres);
        ModelUtils.getDataByAttr(join, "google", google, false);
        ModelUtils.getDataByAttr(join, "facebook", facebook, false);
        ModelUtils.getDataByAttr(join, "userEmail", userEmail, false);
        ModelUtils.getDataByAttr(join, "celular", celular, false);
        ModelUtils.getDataByAttr(join, "telefono", telefono, false);
        ModelUtils.getDataByAttr(join, "userClave", userClave, false);
        ModelUtils.getDataByAttr(join, "razonToken", razonToken, false);
        ModelUtils.getDataByAttr(join, "token", token, false);
        ModelUtils.getDataByAttr(join, "estadoToken", estadoToken, false);
        ModelUtils.getDataByAttr(join, "numeroDocIdentidad", numeroDocIdentidad, false);
        ModelUtils.getDataByAttr(join, "fechaVenceToken", fechaVenceToken, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "cicloRegistro", cicloRegistro, "id");
        ModelUtils.getDataByAttrObject(join, "tipoDocIdentidad", tipoDocIdentidad, "id", "codigo", "nombre", "simbolo");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}
