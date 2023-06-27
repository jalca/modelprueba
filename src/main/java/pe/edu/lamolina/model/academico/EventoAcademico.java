package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ContextoEventoEnum;
import pe.edu.lamolina.model.enums.EventoAcademicoEnum;

@Entity
@Table(name = "aca_evento_academico")
public class EventoAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contexto")
    private String contexto;

    @OneToMany(mappedBy = "eventoAcademico", fetch = FetchType.LAZY)
    private List<EventoCicloAcademico> eventoAcademico;

    public EventoAcademico() {
    }

    public EventoAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public EventoAcademicoEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return EventoAcademicoEnum.valueOf(codigo);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonIgnore
    public void setCodigoEnum(EventoAcademicoEnum codigoEnum) {
        if (codigoEnum == null) {
            return;
        }
        this.codigo = codigoEnum.name();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EventoCicloAcademico> getEventoAcademico() {
        return eventoAcademico;
    }

    public void setEventoAcademico(List<EventoCicloAcademico> eventoAcademico) {
        this.eventoAcademico = eventoAcademico;
    }

    public ObjectNode toJson() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode json = JsonHelper.createJson(this, factory, true);
        return json;
    }

    public ArrayNode toJsonArray(List<EventoAcademico> eventos) {
        ArrayNode eventosJson = new ArrayNode(JsonNodeFactory.instance);
        for (EventoAcademico eventoAca : eventos) {
            eventosJson.add(eventoAca.toJson());
        }

        return eventosJson;
    }

    public boolean isExamenFinal() {
        if (StringUtils.isBlank(this.codigo)) {
            return false;
        }
        return this.codigo.equals(EventoAcademicoEnum.EXAMEN_FIN.name());
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    @JsonIgnore()
    public void setContextoEnum(ContextoEventoEnum contextoEnum) {
        if (contextoEnum == null) {
            return;
        }
        this.contexto = contextoEnum.name();
    }

    public ContextoEventoEnum getContextoEnum() {
        return contexto != null ? ContextoEventoEnum.valueOf(contexto) : null;
    }

}
