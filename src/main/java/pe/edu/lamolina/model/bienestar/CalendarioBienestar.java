package pe.edu.lamolina.model.bienestar;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.Date;
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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@Table(name = "obu_calendario_bienestar")
public class CalendarioBienestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    public CalendarioBienestar() {
    }

    public CalendarioBienestar(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Oficina o = this.oficina == null ? new Oficina() : this.oficina;
        CicloAcademico ca = this.cicloAcademico == null ? new CicloAcademico() : this.cicloAcademico;
        Usuario u = this.userRegistro == null ? new Usuario() : this.userRegistro;

        json.set("oficina", JsonHelper.createJson(o, JsonNodeFactory.instance));
        json.set("cicloAcademico", JsonHelper.createJson(ca, JsonNodeFactory.instance));
        json.set("userRegistro", JsonHelper.createJson(u, JsonNodeFactory.instance));

        return json;
    }
}
