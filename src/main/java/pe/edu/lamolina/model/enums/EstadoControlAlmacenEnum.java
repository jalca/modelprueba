package pe.edu.lamolina.model.enums;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;

public enum EstadoControlAlmacenEnum {

    ABI("Abierto"), CRE("Creado"), CERR("Cerrado"),REABI("ReAbierto");

    private final String value;
    private static final Map<String, EstadoControlAlmacenEnum> lookup = new HashMap<>();

    static {
        for (EstadoControlAlmacenEnum d : EstadoControlAlmacenEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoControlAlmacenEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoControlAlmacenEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoControlAlmacenEnum d : EstadoControlAlmacenEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

    public static ObjectNode getNameArray() {
        ObjectNode objNode = new ObjectNode(JsonNodeFactory.instance);

        for (TipoMatriculaEnum d : TipoMatriculaEnum.values()) {
            objNode.put(d.name(), d.getValue());
        };
        return objNode;

    }
}
