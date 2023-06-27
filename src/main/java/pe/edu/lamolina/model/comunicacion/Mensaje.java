package pe.edu.lamolina.model.comunicacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.enums.MessageTypeEnum;

public class Mensaje {

    private String identificador;

    private MessageTypeEnum tipo;

    private String operador;

    private String contenido;

    private Long fechaCreacion;

    private Long fechaLectura;

    private List<Adjunto> adjuntos;

    public Mensaje(MessageTypeEnum tipo) {
        this.adjuntos = new ArrayList();
        this.tipo = tipo;
        this.fechaCreacion = new Date().getTime();

    }

    public Mensaje() {
        this.adjuntos = new ArrayList();
        this.fechaCreacion = new Date().getTime();
    }

    public Long getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Long fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Long fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public MessageTypeEnum getTipo() {
        return tipo;
    }

    public void setTipo(MessageTypeEnum tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Adjunto> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance, true);

        ObjectMapper mapper = new ObjectMapper();
        json.set("adjuntos", mapper.valueToTree(this.adjuntos));

        return json;
    }

}
