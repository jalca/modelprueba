package pe.edu.lamolina.model.enums;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;

public enum CursoCurriculaEstadoEnum {

    APR("Aprobado"),
    EQUIV("Equivalente"),
    CONV("Convalidado"),
    SIM("Simultaneo"),
    NREQ("No cumple requisitos"),
    HAB("Habil para matricularse"),
    LIMB("Limbo"),
    COM("Completo"),
    PEND("Pendiente"),
    SUL("Simultaneo Último Ciclo") //MAT("Matriculado")
    ;

    private final String value;
    private static final Map<String, CursoCurriculaEstadoEnum> lookup = new HashMap<>();

    static {
        for (CursoCurriculaEstadoEnum d : CursoCurriculaEstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CursoCurriculaEstadoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CursoCurriculaEstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CursoCurriculaEstadoEnum d : CursoCurriculaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

    public static ObjectNode getNombreAndName(String nombre) {
        ObjectNode objNode = new ObjectNode(JsonNodeFactory.instance);
        for (CursoCurriculaEstadoEnum d : CursoCurriculaEstadoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                objNode.put("valor", d.getValue());
                objNode.put("nombre", d.name());
                return objNode;
            }
        }
        return objNode;
    }
}
