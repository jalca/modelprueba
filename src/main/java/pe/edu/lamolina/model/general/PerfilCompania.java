package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Comparator;
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
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.PerfilColaboradorEnum;
import pe.edu.lamolina.model.seguridad.FuncionRol;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "gen_perfil_compania")
public class PerfilCompania implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "contexto")
    private String contexto;

    @Column(name = "es_automatico")
    private Long esAutomatico;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_contiene")
    private Oficina oficinaContiene;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY)
    private List<FuncionColaborador> funcionColaborador;

    @OneToMany(mappedBy = "perfilCompania", fetch = FetchType.LAZY)
    private List<FuncionRol> funcionRol;

    public PerfilCompania() {
    }

    public PerfilCompania(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public PerfilColaboradorEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        try {
            return PerfilColaboradorEnum.valueOf(codigo);
        } catch (Exception e) {
            return null;
        }
    }

    @JsonIgnore
    public void setCodigoEnum(PerfilColaboradorEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public static class CompareNombre implements Comparator<PerfilCompania> {

        @Override
        public int compare(PerfilCompania per1, PerfilCompania per2) {
            return per1.getNombre().compareTo(per2.getNombre());
        }
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "nombre", nombre);
        ModelUtils.getDataByAttr(join, "codigo", codigo);
        ModelUtils.getDataByAttr(join, "nombreDocumento", nombreDocumento, false);
        ModelUtils.getDataByAttr(join, "tipo", tipo, false);
        ModelUtils.getDataByAttr(join, "contexto", contexto, false);
        ModelUtils.getDataByAttr(join, "esAutomatico", esAutomatico, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttrObject(join, "oficinaContiene", oficinaContiene, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "compania", compania, "id", "nombre");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }
}
