package pe.edu.lamolina.model.seguridad;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.enums.UserEstadoEnum;
import pe.edu.lamolina.model.tramite.Tramite;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "seg_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario")
    private String usuario2;

    @Column(name = "clave")
    private String clave;

    @Column(name = "estado")
    private String estado;

    @Column(name = "google")
    private String google;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "user_dni")
    private String userDni;

    @Column(name = "user_dni_pass")
    private String userDniPass;

    @Column(name = "token_appmovil")
    private String tokenAppmovil;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_activo")
    private Usuario userActivo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioRol> usuarioRol;

    @OneToMany(mappedBy = "userActivo", fetch = FetchType.LAZY)
    private List<Usuario> usuariosNoActivos;

    @OneToMany(mappedBy = "userRegistro", fetch = FetchType.LAZY)
    private List<Tramite> tramites;

    public Usuario(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public UserEstadoEnum getEstadoEnum() {
        return UserEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(UserEstadoEnum estadoEnum) {
        if (estadoEnum != null) {
            this.estado = estadoEnum.name();
        }
    }

    public boolean isEstadoLike(UserEstadoEnum estado) {
        if (this.getEstadoEnum() == estado) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }

        Usuario other = (Usuario) obj;
        if (this.id == null && other.getId() == null) {
            return true;
        }

        if ((this.id == null && other.getId() != null)
                || (this.id != null && other.getId() == null)
                || (this.id.compareTo(other.getId()) != 0)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "usuario2", usuario2, false);
        ModelUtils.getDataByAttr(join, "clave", clave, false);
        ModelUtils.getDataByAttr(join, "estado", estado);
        ModelUtils.getDataByAttr(join, "google", google, false);
        ModelUtils.getDataByAttr(join, "facebook", facebook, false);
        ModelUtils.getDataByAttr(join, "userDni", userDni, false);
        ModelUtils.getDataByAttr(join, "userDniPass", userDniPass, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "fechaModifica", fechaModifica, false);
        ModelUtils.getDataByAttrObject(join, "persona", persona, "id", "paterno", "materno", "nombres");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "estado", "google");
        ModelUtils.getDataByAttrObject(join, "userModifica", userModifica, "id", "estado", "google");
        ModelUtils.getDataByAttrObject(join, "userActivo", userActivo, "id", "estado", "google");

        return join.toString();
    }

}
