package pe.edu.lamolina.model.enums;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;

public enum TipoConstanciaEnum {

    CONS("Constancia"), CERT("Certificado");

    private final String value;
    private static final Map<String, TipoConstanciaEnum> lookup = new HashMap<>();

    static {
        for (TipoConstanciaEnum d : TipoConstanciaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoConstanciaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoConstanciaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoConstanciaEnum d : TipoConstanciaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
    public static ObjectNode getValue(String name){
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        for (TipoConstanciaEnum d : TipoConstanciaEnum.values()) {
            if (d.name().equalsIgnoreCase(name)) {
                node.put("name", d.name());
                node.put("value", d.value);
                return node;
            }
        }
        return node;
    }
    public static ArrayNode getJsonValues() {
        ArrayNode an = new ArrayNode(JsonNodeFactory.instance);
        for (TipoConstanciaEnum d : TipoConstanciaEnum.values()) {
            ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
            node.put("name", d.name());
            node.put("value", d.getValue());
            an.add(node);
        }
        return an;
    }
}
